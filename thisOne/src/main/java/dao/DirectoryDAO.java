package dao;

import model.Directory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectoryDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/test";
	private String jdbcUsername = "root";
	private String jdbcPassword = "DetroitandNewYork#1104";
	private static final String INSERT_DIRECTORY_SQL =
			"INSERT INTO directory" + "  (title, description, user, link) VALUES " + " (?, ?, ?, ?);";
	private static final String SELECT_DIRECTORIES_BY_ID =
			"select id,title,description,user,link from directory where id =?";
	private static final String SELECT_ALL_DIRECTORIES =
			"select * from directory";
	private static final String DELETE_DIRECTORIES_SQL =
			"delete from directory where id = ?;";
	private static final String UPDATE_DIRECTORY_SQL =
			"update directory set title = ?, description= ?, user =?, link=? where id = ?;";

	public DirectoryDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertDirectory(Directory directory) throws SQLException {
		System.out.println(INSERT_DIRECTORY_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DIRECTORY_SQL)) {
			preparedStatement.setString(1, directory.getTitle());
			preparedStatement.setString(2, directory.getDescription());
			preparedStatement.setString(3, directory.getUser());
			preparedStatement.setString(4, directory.getLink());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Directory selectDirectory(int id) {
		Directory directory = null;
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DIRECTORIES_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				String description = rs.getString("description");
				String user = rs.getString("user");
				String link = rs.getString("link");
				directory = new Directory(id, title, description, user, link);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return directory;
	}

	public List<Directory> selectAllDirectories() {
		List<Directory> directories = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIRECTORIES);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String user = rs.getString("user");
				String link = rs.getString("link");
				directories.add(new Directory(id, title, description, user, link));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return directories;
	}

	public boolean deleteDirectory(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_DIRECTORIES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateDirectory(Directory directory) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_DIRECTORY_SQL);) {
			statement.setString(1, directory.getTitle());
			statement.setString(2, directory.getDescription());
			statement.setString(3, directory.getUser());
			statement.setString(3, directory.getLink());
			statement.setInt(4, directory.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
