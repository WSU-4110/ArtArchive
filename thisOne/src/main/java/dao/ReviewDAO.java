package dao;

import model.Review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/test";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password123";

	private static final String INSERT_REVIEW_SQL = "INSERT INTO review" + "  (user, review, sales_id, stars) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_REVIEW_BY_ID = "select * from review where id =?";
	private static final String SELECT_REVIEW_BY_SALES_ID = "select * from review where sales_id =?";
	private static final String SELECT_ALL_REVIEW = "select * from review";
	private static final String DELETE_REVIEW_SQL = "delete from review where id = ?;";
	private static final String UPDATE_REVIEW_SQL = "update review set review = ?, stars= ? where id = ?;";

	public ReviewDAO() {
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

	public void insertReview(Review review) throws SQLException {
		System.out.println(INSERT_REVIEW_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REVIEW_SQL)) {
			preparedStatement.setString(1, review.getUser());
			preparedStatement.setString(2, review.getReview());
			preparedStatement.setInt(3, review.getSalesID());
			preparedStatement.setInt(4, review.getStars());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Review selectReview(int id) {
		Review review = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String reviewText = rs.getString("review");
				String user = rs.getString("user");
				int stars = Integer.parseInt(rs.getString("stars"));
				int salesID = Integer.parseInt(rs.getString("sales_id"));
				review = new Review(id, reviewText, user, salesID, stars);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return review;
	}

	public List<Review> selectAllReviews() {
		List<Review> reviews = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REVIEW);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String reviewText = rs.getString("review");
				String user = rs.getString("user");
				int stars = Integer.parseInt(rs.getString("stars"));
				int salesID = Integer.parseInt(rs.getString("sales_id"));
				reviews.add(new Review(id, reviewText, user, salesID, stars));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return reviews;
	}

	public boolean deleteReview(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_REVIEW_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateReview(Review review) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_REVIEW_SQL);) {
			statement.setString(1, review.getReview());
			statement.setInt(2, review.getStars());
			statement.setInt(4, review.getId());

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
