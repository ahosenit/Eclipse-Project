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

<title>BHBFC | Update User Information</title>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
	<div class="row mt-2 d-flex justify-content-center">
		<div class="col-md-5">
			<div class="card">
				<div class="card-header text-center c-head text-white">
					<i class="fa fa-user-circle-o fa-2x"></i>
					<h5>Update User Information</h5>
				</div>
				<div class="card-body">

					<form action="UserModify" method="post">

						<c:if test="${user != null}">
							<input type="hidden" name="userId"
								value="<c:out value='${user.userId}' />" />
						</c:if>

						<fieldset class="form-group">
							<label>Enter Full Name</label> <input type="text"
								class="form-control" name="fullName"
								value="<c:out value='${user.fullName}' />" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>Enter Designation</label> <input type="text"
								class="form-control" name="userDesignation"
								value="<c:out value='${user.userDesignation}' />"
								required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>Enter PF Number</label> <input type="text"
								class="form-control" name="employeeId"
								value="<c:out value='${user.employeeId}' />" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>Enter Email Address</label> <input type="email" id="email"
								class="form-control" name="userEmail"
								value="<c:out value='${user.userEmail}' />" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>Enter Password</label> <input type="text"
								class="form-control" name=passWord
								value="<c:out value='${user.passWord}' />" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>User Role</label> <select name="userRole" id="userRole"
								class="form-control">
								<option value="Pending">Pending</option>
								<option value="Staff">Staff</option>
								<option value="Officer">Officer</option>
								<option value="Manager">Manager</option>
								<option value="Administrator">Administrator</option>
							</select>
						</fieldset>



						<button type="submit" class="btn btn-success">Save</button>
					</form>

				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>