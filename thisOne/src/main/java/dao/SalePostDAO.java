package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SalePost;

public class SalePostDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/test";
	private String jdbcUsername = "root";
	private String jdbcPassword = "DetroitandNewYork#1104";

	private static final String INSERT_SALES_SQL = "INSERT INTO salesBoard" + "  (name, description, user, file) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_SALES_BY_ID = "select id, name, description, user, file from salesBoard where id =?";
	private static final String SELECT_ALL_SALES = "select * from salesBoard";
	private static final String DELETE_SALES_SQL = "delete from salesBoard where id = ?;";
	private static final String UPDATE_SALES_SQL = "update salesBoard set name = ?, description= ?, user =?, file =? where id = ?;";

	public SalePostDAO() {
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

	public void insertSale(SalePost salePost) throws SQLException {
		System.out.println(INSERT_SALES_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SALES_SQL)) {
			preparedStatement.setString(1, salePost.getName());
			preparedStatement.setString(2, salePost.getDescription());
			preparedStatement.setString(3, salePost.getUser());
			preparedStatement.setString(4, salePost.getFile());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public SalePost selectSalePost(int id) {
		SalePost salePost = null;
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SALES_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String user = rs.getString("user");
				String file = rs.getString("file");
				salePost = new SalePost(id, name, description, user, file);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return salePost;
	}

	public List<SalePost> selectAllSales() {
		List<SalePost> salePosts = new ArrayList<>();
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SALES);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String user = rs.getString("user");
				String file = rs.getString("file");
				salePosts.add(new SalePost(id, name, description, user, file));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return salePosts;
	}

	public boolean deleteSale(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
			 PreparedStatement statement = connection.prepareStatement(DELETE_SALES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateSale(SalePost salePost) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
			 PreparedStatement statement = connection.prepareStatement(UPDATE_SALES_SQL);) {
			statement.setString(1, salePost.getName());
			statement.setString(2, salePost.getDescription());
			statement.setString(3, salePost.getUser());
			statement.setString(4, salePost.getFile());
			statement.setInt(5, salePost.getId());

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
