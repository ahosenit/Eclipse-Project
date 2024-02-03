package pkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pkg.ServiceImp.DataConnection;
import pkg.model.User;

public class UserDao {
	private static final String select_all = "select * from user_info";
	private static final String select_By_ID = "select * from user_info where userId=?";
	private static final String Insert_into = "INSERT INTO `user_info`(`userId`, `full_name`, `user_designation`, `emp_id`, `user_email`, `password`, `user_role`) VALUES (?,?,?,?,?,?,?)";
	private static final String Update_By_ID = "UPDATE `user_info` SET `full_name`=?,`user_designation`=?,`emp_id`=?,`user_email`=?,`password`=?,`user_role`=? WHERE userId=? ";
	private static final String Delete_By_ID = "DELETE FROM `user_info` WHERE `userId`=?";
	private static final String MaxID = "SELECT nvl(max(userId),0)+1 FROM `user_info` ";

	private static final String select_By_IdAndPassword = "select * from user_info where emp_id=? and password=?";

	private DataConnection connectionObj = new DataConnection();

	public List<User> GetAllUser() {
		List<User> UserList = new ArrayList<User>();
		Connection Datasource = connectionObj.OpenConnection();
		try {
			PreparedStatement preparedStatement = Datasource.prepareStatement(select_all);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserList.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
						resultSet.getString(7)));
			}
			connectionObj.closeConnection(Datasource);
		} catch (Exception e) {

		}
		return UserList;
	}

	public boolean validate(User user) throws SQLException {
		boolean status = false;
		try (Connection connection = connectionObj.OpenConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(select_By_IdAndPassword)) {

			preparedStatement.setString(1, user.getEmployeeId());
			preparedStatement.setString(2, user.getPassWord());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
			// printSQLException(e);
		}
		return status;

	}

//	private void printSQLException(SQLException ex) {
//		for (Throwable e : ex) {
//			if (e instanceof SQLException) {
//				e.printStackTrace(System.err);
//				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//				System.err.println("Message: " + e.getMessage());
//				Throwable t = ex.getCause();
//				while (t != null) {
//					System.out.println("Cause: " + t);
//					t = t.getCause();
//				}
//			}
//		}
//	}

	public int GetMaxID() {
		int userID = 0;
		Connection Datasource = connectionObj.OpenConnection();
		try {
			PreparedStatement preparedStatement = Datasource.prepareStatement(MaxID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userID = resultSet.getInt(1);
			}
			connectionObj.closeConnection(Datasource);
		} catch (Exception e) {

		}
		return userID;
	}

	public void InsertUser(User user) throws SQLException {
		System.out.println(Insert_into);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = connectionObj.OpenConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Insert_into)) {
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getFullName());
			preparedStatement.setString(3, user.getUserDesignation());
			preparedStatement.setString(4, user.getEmployeeId());
			preparedStatement.setString(5, user.getUserEmail());
			preparedStatement.setString(6, user.getPassWord());
			preparedStatement.setString(7, user.getUserRole());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User GetUserByID(int userId) {
		User userObj = null;
		;
		Connection Datasource = connectionObj.OpenConnection();
		try {
			PreparedStatement preparedStatement = Datasource.prepareStatement(select_By_ID);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userObj = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
			}
			connectionObj.closeConnection(Datasource);
		} catch (Exception e) {

		}
		return userObj;
	}

	public boolean UpdateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = connectionObj.OpenConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Update_By_ID);) {

			preparedStatement.setString(1, user.getFullName());
			preparedStatement.setString(2, user.getUserDesignation());
			preparedStatement.setString(3, user.getEmployeeId());
			preparedStatement.setString(4, user.getUserEmail());
			preparedStatement.setString(5, user.getPassWord());
			preparedStatement.setString(6, user.getUserRole());
			preparedStatement.setInt(7, user.getUserId());
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public boolean deleteUser(int userId) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = connectionObj.OpenConnection();
				PreparedStatement statement = connection.prepareStatement(Delete_By_ID);) {
			statement.setInt(1, userId);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

}
