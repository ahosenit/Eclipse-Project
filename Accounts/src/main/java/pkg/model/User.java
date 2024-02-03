package pkg.model;


public class User {
	private int userId;
	private String fullName;
	private String userDesignation;
	private String employeeId;
	private String userEmail;
	private String passWord;
	private String userRole;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String fullName, String userDesignation, String employeeId, String userEmail,
			String passWord, String userRole) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.userDesignation = userDesignation;
		this.employeeId = employeeId;
		this.userEmail = userEmail;
		this.passWord = passWord;
		this.userRole = userRole;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserDesignation() {
		return userDesignation;
	}

	public void setUserDesignation(String userDesignation) {
		this.userDesignation = userDesignation;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", userDesignation=" + userDesignation
				+ ", employeeId=" + employeeId + ", userEmail=" + userEmail + ", passWord=" + passWord + ", userRole="
				+ userRole + "]";
	}

		
}
