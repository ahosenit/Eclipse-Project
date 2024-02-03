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

<div class="container">
	<div class="row mt-2 d-flex justify-content-center">
		<div class="col-md-5">
			<div class="card">
				<div class="card-header text-center c-head text-white">
					<i class="fa fa-user-circle-o fa-2x"></i>
					<h5>Create User</h5>
				</div>
				<div class="card-body">

					<form action="CreateUser" method="post">

						<fieldset class="form-group">
							<label>Enter Full Name</label> <input type="text"
								class="form-control" name="fullName" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>Enter Designation</label> <input type="text"
								class="form-control" name="userDesignation" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>Enter PF Number</label> <input type="text"
								class="form-control" name="employeeId" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>Enter Email Address</label> <input type="email" id="email"
								name="userEmail" required="required" class="form-control">
						</fieldset>

						<!-- <fieldset class="form-group">
						<label>Enter Password</label> <input type="text" class="form-control"
							name="passWord" required="required">
					</fieldset> -->

						<button type="submit" class="btn btn-primary btn-block badge-pill">Save</button>
					</form>

				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>