package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/test";
	private String jdbcUsername = "root";
	private String jdbcPassword = "DetroitandNewYork#1104";

	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country, password, firstName, lastName, description, favoriteColor, file) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_NAME = "select id,name,email,country,password,firstName,lastName,description,favoriteColor,file from users where name =?";
	private static final String SELECT_USER_BY_ID = "select id,name,email,country,password,firstName,lastName,description,favoriteColor,file from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name =?,email=?,country =?,password =?,firstName =?,lastName =?,description=?,favoriteColor=? where id = ?;";

	public UserDAO() {
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

	public boolean userExists(String mysqlUser, String mysqlPassword) throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection login = (Connection) DriverManager
				.getConnection(this.jdbcURL, mysqlUser, mysqlPassword);

		if(login == null) {
			return false;
		}
		login.close();
		return true;
	}

	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getFirstName());
			preparedStatement.setString(6, user.getLastName());
			preparedStatement.setString(7, user.getDescription());
			preparedStatement.setString(8, user.getFavoriteColor());
			preparedStatement.setString(9, user.getFile());
			//preparedStatement.setInt(9, user.getId());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
			 // Step 2:Create a statement using connection object
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String password = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String description = rs.getString("description");
				String favoriteColor = rs.getString("favoriteColor");
				String file = rs.getString("file");
				user = new User(id, name, email, country, password, firstName, lastName, description, favoriteColor, file);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User> selectUser(String username) {
		//User user = null;
		List<User> user = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
			 // Step 2:Create a statement using connection object
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME);) {
			preparedStatement.setString(1, username);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String password = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String description = rs.getString("description");
				String favoriteColor = rs.getString("favoriteColor");
				String file = rs.getString("file");
				user.add(new User(id, name, email, country, password, firstName, lastName, description, favoriteColor, file));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String password = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String description = rs.getString("description");
				String favoriteColor = rs.getString("favoriteColor");
				String file = rs.getString("file");
				users.add(new User(id, name, email, country, password, firstName, lastName, description, favoriteColor,file));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getCountry());
			statement.setString(4, user.getFirstName());
			statement.setString(5, user.getLastName());
			statement.setString(6, user.getDescription());
			statement.setString(7, user.getFavoriteColor());
			statement.setString(8, user.getFile());
			//statement.setInt(8, user.getId());

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
