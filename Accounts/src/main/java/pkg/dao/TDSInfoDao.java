package pkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pkg.ServiceImp.DataConnection;
import pkg.model.TdsInfo;
import pkg.model.User;

public class TDSInfoDao {
	private static final String select_all_from_tds = "select * from tds_info";
	private static final String select_tds_all_By_SL = "select * from tds_info where tds_sl=?";
	private static final String Insert_into_tds = "INSERT INTO `tds_info`(`tds_sl`, `branch_code`, `branch_name`, `tds_cheque`, `chq_issue_date`, `chalan_no`, `chalan_date`, `bank_name`, `amount`, `under_section`) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String Update_tds_By_SL = "UPDATE `tds_info` SET `branch_code`=?,`branch_name`=?,`tds_cheque`=?,`chq_issue_date`=?,`chalan_no`=?,`chalan_date`=?,`bank_name`=?,`amount`=?,`under_section`=? WHERE tds_sl=? ";
	private static final String Delete_tds_By_SL = "DELETE FROM `tds_info` WHERE `tds_sl`=?";
	private static final String MaxSL_No = "SELECT nvl(max(tds_sl),0)+1 FROM `tds_info` ";

	private static DataConnection connectionObj = new DataConnection();

	public List<TdsInfo> GetAllTDS() {
		List<TdsInfo> TDSList = new ArrayList<TdsInfo>();
		Connection Datasource = connectionObj.OpenConnection();
		try {
			PreparedStatement preparedStatement = Datasource.prepareStatement(select_all_from_tds);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TDSList.add(new TdsInfo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getDate(7),
						resultSet.getString(8), resultSet.getString(9), resultSet.getString(10)));
			}
			connectionObj.closeConnection(Datasource);
		} catch (Exception e) {

		}
		return TDSList;
	}

	public static int GetMaxSL() {
		int TDSSL = 0;
		Connection Datasource = connectionObj.OpenConnection();
		try {
			PreparedStatement preparedStatement = Datasource.prepareStatement(MaxSL_No);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TDSSL = resultSet.getInt(1);
			}
			connectionObj.closeConnection(Datasource);
		} catch (Exception e) {

		}
		return TDSSL;
	}

	public void InsertTDSInfo(TdsInfo tdsinfo) throws SQLException {
		System.out.println(Insert_into_tds);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = connectionObj.OpenConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Insert_into_tds)) {
			preparedStatement.setInt(1, tdsinfo.getTdsSL());
			preparedStatement.setString(2, tdsinfo.getBranchCode());
			preparedStatement.setString(3, tdsinfo.getBankName());
			preparedStatement.setString(4, tdsinfo.getTdsChequeNo());
			preparedStatement.setDate(5, tdsinfo.getTdsChequeIssueDate());
			preparedStatement.setString(6, tdsinfo.getChalanNo());
			preparedStatement.setDate(7, tdsinfo.getChalanDate());
			preparedStatement.setString(8, tdsinfo.getBankName());
			preparedStatement.setString(9, tdsinfo.getTdsAmount());
			preparedStatement.setString(10, tdsinfo.getUnderSection());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public TdsInfo GetTDSInfoBySL(int tdsSL) {
		TdsInfo TDSInfoObj = null;
		Connection Datasource = connectionObj.OpenConnection();
		try {
			PreparedStatement preparedStatement = Datasource.prepareStatement(select_tds_all_By_SL);
			preparedStatement.setInt(1, tdsSL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TDSInfoObj = new TdsInfo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getDate(7),
						resultSet.getString(8), resultSet.getString(9), resultSet.getString(10));
			}
			connectionObj.closeConnection(Datasource);
		} catch (Exception e) {

		}
		return TDSInfoObj;
	}

	public boolean UpdateTDSInfo(TdsInfo tdsinfo) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = connectionObj.OpenConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Update_tds_By_SL);) {
			preparedStatement.setString(1, tdsinfo.getBranchCode());
			preparedStatement.setString(2, tdsinfo.getBankName());
			preparedStatement.setString(3, tdsinfo.getTdsChequeNo());
			preparedStatement.setDate(4, tdsinfo.getTdsChequeIssueDate());
			preparedStatement.setString(5, tdsinfo.getChalanNo());
			preparedStatement.setDate(6, tdsinfo.getChalanDate());
			preparedStatement.setString(7, tdsinfo.getBankName());
			preparedStatement.setString(8, tdsinfo.getTdsAmount());
			preparedStatement.setString(9, tdsinfo.getUnderSection());
			preparedStatement.setInt(10, tdsinfo.getTdsSL());
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public boolean deleteTDSInfo(int tdsSL) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = connectionObj.OpenConnection();
				PreparedStatement statement = connection.prepareStatement(Delete_tds_By_SL);) {
			statement.setInt(1, tdsSL);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

}
