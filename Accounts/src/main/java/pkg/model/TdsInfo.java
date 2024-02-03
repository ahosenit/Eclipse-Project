package pkg.model;

import java.sql.Date;

public class TdsInfo {
	private int tdsSL;
	private String branchCode;
	private String branchName;
	private String tdsChequeNo;
	private Date tdsChequeIssueDate;
	private String chalanNo;
	private Date chalanDate;
	private String bankName;
	private String tdsAmount;
	private String underSection;
	
	public TdsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TdsInfo(int tdsSL, String branchCode, String branchName, String tdsChequeNo, Date tdsChequeIssueDate,
			String chalanNo, Date chalanDate, String bankName, String tdsAmount, String underSection) {
		super();
		this.tdsSL = tdsSL;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.tdsChequeNo = tdsChequeNo;
		this.tdsChequeIssueDate = tdsChequeIssueDate;
		this.chalanNo = chalanNo;
		this.chalanDate = chalanDate;
		this.bankName = bankName;
		this.tdsAmount = tdsAmount;
		this.underSection = underSection;
	}
	public int getTdsSL() {
		return tdsSL;
	}
	public void setTdsSL(int tdsSL) {
		this.tdsSL = tdsSL;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getTdsChequeNo() {
		return tdsChequeNo;
	}
	public void setTdsChequeNo(String tdsChequeNo) {
		this.tdsChequeNo = tdsChequeNo;
	}
	public Date getTdsChequeIssueDate() {
		return tdsChequeIssueDate;
	}
	public void setTdsChequeIssueDate(Date tdsChequeIssueDate) {
		this.tdsChequeIssueDate = tdsChequeIssueDate;
	}
	public String getChalanNo() {
		return chalanNo;
	}
	public void setChalanNo(String chalanNo) {
		this.chalanNo = chalanNo;
	}
	public Date getChalanDate() {
		return chalanDate;
	}
	public void setChalanDate(Date chalanDate) {
		this.chalanDate = chalanDate;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getTdsAmount() {
		return tdsAmount;
	}
	public void setTdsAmount(String tdsAmount) {
		this.tdsAmount = tdsAmount;
	}
	public String getUnderSection() {
		return underSection;
	}
	public void setUnderSection(String underSection) {
		this.underSection = underSection;
	}
	@Override
	public String toString() {
		return "TdsInfo [tdsSL=" + tdsSL + ", branchCode=" + branchCode + ", branchName=" + branchName
				+ ", tdsChequeNo=" + tdsChequeNo + ", tdsChequeIssueDate=" + tdsChequeIssueDate + ", chalanNo="
				+ chalanNo + ", chalanDate=" + chalanDate + ", bankName=" + bankName + ", tdsAmount=" + tdsAmount
				+ ", underSection=" + underSection + "]";
	}
	
	

}
