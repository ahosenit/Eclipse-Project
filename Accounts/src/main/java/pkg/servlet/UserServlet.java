package pkg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.ServiceImp.DataConnection;
import pkg.dao.TDSInfoDao;
import pkg.dao.UserDao;
import pkg.model.TdsInfo;
import pkg.model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String url = request.getServletPath();
		try {
			switch (url) {
			case "/":
				HomeController(request, response);
				break;
			case "/Dashboard":
				UserDashboard(request, response);
				break;
			case "/LoginValidation":
				UserLoginValidation(request, response);
				break;
			case "/logout":
				Logout(request, response);
				break;
			case "/LoginError":
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
				break;
			case "/UserList":
				UserList(request, response);
				break;
			case "/UserForm":
				UserForm(request, response);
				break;
			case "/CreateUser":
				SaveNewUser(request, response);
				break;
			case "/UserEditForm":
				UserEditForm(request, response);
				break;
			case "/UserModify":
				UserModify(request, response);
				break;
			case "/UserDelete":
				DeleteUser(request, response);
				break;
			case "/SaveNewTDSInfo":
				SaveNewTDSInfo(request, response);
				break;
			case "/TDSInfoList":
				TDSInfoList(request, response);
				break;
			case "/TDSInfoForm":
				TDSInfoForm(request, response);
				break;
			default:
				UserList(request, response);
				break;
			}

		} catch (Exception e) {

		}
	}

	UserDao UserDao = new UserDao();
	TDSInfoDao TDSInfoDao = new TDSInfoDao();

	void HomeController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String clientID = null;
		try {
			clientID = session.getAttribute("ClientId").toString();
		} catch (Exception e) {

		}
		if ("1234567890".equalsIgnoreCase(clientID)) {
			UserDashboard(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}

	}
	
	private void UserDashboard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}
	


	void UserLoginValidation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String employeeId = request.getParameter("employeeId");
		String passWord = request.getParameter("passWord");
		User user = new User();
		user.setEmployeeId(employeeId);
		user.setPassWord(passWord);

		try {
			if (UserDao.validate(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("UserName", employeeId);
				session.setAttribute("PassWord", passWord);
				session.setAttribute("ClientId", 1234567890);
				session.setMaxInactiveInterval(500);
				response.sendRedirect("Dashboard");
				
			} else {
				// HttpSession session = request.getSession();
				// session.setAttribute("user", userEmail);
				//request.setAttribute("status", "faild");
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("UserName");
		session.removeAttribute("PassWord");
		session.removeAttribute("ClientId");
		session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);

	}

	void UserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<User> UserList = UserDao.GetAllUser();
		request.setAttribute("UserList", UserList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void UserForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void UserEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-user.jsp");
		User userObj = UserDao.GetUserByID(userId);
		request.setAttribute("user", userObj);
		dispatcher.forward(request, response);

	}

	private void SaveNewUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String fullName = request.getParameter("fullName");
		String userDesignation = request.getParameter("userDesignation");
		String employeeId = request.getParameter("employeeId");
		String userEmail = request.getParameter("userEmail");
		User UserObj = new User(UserDao.GetMaxID(), fullName, userDesignation, employeeId, userEmail, "1234",
				"Pending");
		UserDao.InsertUser(UserObj);
		System.out.println(UserObj.toString());
		response.sendRedirect("UserList");
	}

	private void UserModify(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String fullName = request.getParameter("fullName");
		String userDesignation = request.getParameter("userDesignation");
		String employeeId = request.getParameter("employeeId");
		String userEmail = request.getParameter("userEmail");
		String passWord = request.getParameter("passWord");
		String userRole = request.getParameter("userRole");

		User UserObj = new User(userId, fullName, userDesignation, employeeId, userEmail, passWord, userRole);
		UserDao.UpdateUser(UserObj);

		System.out.println(UserObj.toString());
		response.sendRedirect("UserList");
	}

	private void DeleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		System.out.println(userId);
		UserDao.deleteUser(userId);
		response.sendRedirect("UserList");

	}

	void TDSInfoList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<TdsInfo> TDSList = TDSInfoDao.GetAllTDS();
		request.setAttribute("TDSList", TDSList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("tds-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void TDSInfoForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("tds-entry-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void SaveNewTDSInfo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String branchCode = request.getParameter("branchCode");
		String branchName = request.getParameter("branchName");
		String tdsChequeNo = request.getParameter("tdsChequeNo");
		Date  tdsChequeIssueDate = Date.valueOf(request.getParameter("tdsChequeIssueDate"));		
		String chalanNo = request.getParameter("chalanNo");
		Date  chalanDate = Date.valueOf(request.getParameter("chalanDate"));
		String bankName = request.getParameter("bankName");
		String tdsAmount = request.getParameter("tdsAmount");
		String underSection = request.getParameter("underSection");
		
		TdsInfo TDSInfoObj = new TdsInfo(TDSInfoDao.GetMaxSL(), branchCode, branchName, tdsChequeNo, tdsChequeIssueDate, chalanNo,
				chalanDate, bankName, tdsAmount, underSection);
		TDSInfoDao.InsertTDSInfo(TDSInfoObj);
		System.out.println(TDSInfoObj.toString());
		response.sendRedirect("TDSInfoList");
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
