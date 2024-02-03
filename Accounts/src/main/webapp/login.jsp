<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BHBFC | Login</title> -->

<jsp:include page="header.jsp"></jsp:include>


<!-- <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">

</head>
<body> -->


<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
	
	<div class="container">
		<div class="row mt-5 d-flex justify-content-center">
			<div class="col-5 mt-5 mx-auto">
				<div class="card">
					<div class="card-header text-center c-head text-white">
						<i class="fa fa-user-circle-o fa-2x"></i>
						<h5>User Login Information</h5>
					</div>
					<div class="card-body">

						<form action="LoginValidation" method="post" id="loginForm">

							<fieldset class="form-group">
								<label>Enter PF Number</label> <input type="text"
									class="form-control" name="employeeId" required="required">
							</fieldset>

							<fieldset class="form-group">
								<label>Enter Password</label> <input type="text" class="form-control"
									name="passWord" required="required">
							</fieldset>

							<button type="submit"
								class="btn btn-primary btn-block badge-pill">Login</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="footer.jsp"></jsp:include>