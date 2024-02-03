<%@page import="pkg.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
if (session.getAttribute("UserName") == null || session.getAttribute("PassWord") == null
		|| session.getAttribute("ClientId") == null) {
	response.sendRedirect("login.jsp");
}
%>

<jsp:include page="header.jsp"></jsp:include>

<div class="row mt-3">
	<div class="container">



		<h3 class="text-center">List of Users</h3>
		<hr>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Full Name</th>
					<th>Designation</th>
					<th>PF Number</th>
					<th>Email Address</th>
					<th>Password</th>
					<th>User Role</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="user" items="${UserList}">

					<tr>
						<td><c:out value="${user.userId}" /></td>
						<td><c:out value="${user.fullName}" /></td>
						<td><c:out value="${user.userDesignation}" /></td>
						<td><c:out value="${user.employeeId}" /></td>
						<td><c:out value="${user.userEmail}" /></td>
						<td><c:out value="${user.passWord}" /></td>
						<td><c:out value="${user.userRole}" /></td>
						<td><a href="UserEditForm?userId=<c:out value='${user.userId}' />">Edit</a>
							&nbsp;&nbsp;&nbsp; 
							<a href="UserDelete?userId=<c:out value='${user.userId}' />">Delete</a></td>
					</tr>
				</c:forEach>
				<!-- } -->
			</tbody>

		</table>
	</div>
</div>


<jsp:include page="footer.jsp"></jsp:include>