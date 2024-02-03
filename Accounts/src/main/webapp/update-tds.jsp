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


<div class="container py-3">
	<div class="row mt-2 d-flex justify-content-center">
		<div class="col-md-10 mx-auto">
			<div class="card">
				<div class="card-header text-center c-head text-white">
					<i class="fa fa-user-circle-o fa-2x"></i>
					<h5>Tax Deduction at Source (TDS) Information Update</h5>
				</div>
				<div class="card-body">
					<form>
						<div class="form-group row">
							<div class="col-sm-3">
								<label for="branchCode">Brance Code</label> <input
									name="branchCode" type="text" class="form-control"
									id="branchCode">
							</div>
							<div class="col-sm-3">
								<label for="branchName">Brance Name</label> <input
									name="branchName" type="text" class="form-control"
									id="branchName">
							</div>
							<div class="col-sm-3">
								<label for="tdsChequeNo">Cheque Number</label> <input
									name="tdsChequeNo" type="text" class="form-control"
									id="tdsChequeNo">
							</div>
							<div class="col-sm-3">
								<label for="tdsChequeIssueDate">Cheque Issue Date</label> <input
									name="tdsChequeIssueDate" type="date" class="form-control"
									id="tdsChequeIssueDate">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-6">
								<label for="chalanNo">TDS Chalan Number</label> <input
									name="chalanNo" type="text" class="form-control" id="chalanNo">
							</div>
							<div class="col-sm-3">
								<label for="bankName">Bank Name</label> <input name="bankName"
									type="text" class="form-control" id="bankName">
							</div>
							<div class="col-sm-3">
								<label for="chalanDate">Chalan Date</label> <input
									name="chalanDate" type="date" class="form-control"
									id="chalanDate">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-6">
								<label for="tdsAmount">TDS Amount</label> <input
									name="tdsAmount" type="number" class="form-control"
									id="tdsAmount">
							</div>
							<div class="col-sm-6">
								<label for="underSection">Withhold Under Section</label> <select
									name="underSection" id="underSection" class="form-control">
									<option value="86">Income Tax Clause - 86</option>
									<option value="89">Income Tax Clause - 89</option>
									<option value="90">Income Tax Clause - 90</option>
									<option value="91">Income Tax Clause - 91</option>
									<option value="92">Income Tax Clause - 92</option>
									<option value="109">Income Tax Clause - 109</option>
									<option value="110">Income Tax Clause - 110</option>
									<option value="131">Income Tax Clause - 131</option>
									<option value="132">Income Tax Clause - 132</option>
								</select>
							</div>
						</div>
						<button type="button" class="btn btn-primary px-4 float-right">Save</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>





<jsp:include page="footer.jsp"></jsp:include>