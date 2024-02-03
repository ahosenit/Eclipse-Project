
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



		<h3 class="text-center">List of TDS</h3>
		<hr>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Brance Code</th>
					<th>Brance Name</th>
					<th>Cheque Number</th>
					<th>Cheque Issue Date</th>
					<th>Chalan Numbe</th>
					<th>Chalan Date</th>
					<th>Bank Name</th>
					<th>TDS Amount</th>
					<th>Section</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="tdsinfo" items="${TDSList}">

					<tr>
						<td><c:out value="${tdsinfo.tdsSL}" /></td>
						<td><c:out value="${tdsinfo.branchCode}" /></td>
						<td><c:out value="${tdsinfo.branchName}" /></td>
						<td><c:out value="${tdsinfo.tdsChequeNo}" /></td>
						<td><c:out value="${tdsinfo.tdsChequeIssueDate}" /></td>
						<td><c:out value="${tdsinfo.chalanNo}" /></td>
						<td><c:out value="${tdsinfo.chalanDate}" /></td>
						<td><c:out value="${tdsinfo.bankName}" /></td>
						<td><c:out value="${tdsinfo.tdsAmount}" /></td>
						<td><c:out value="${tdsinfo.underSection}" /></td>
						<td><a
							href="UserEditForm?tdsSL=<c:out value='${tdsinfo.tdsSL}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="UserDelete?tdsSL=<c:out value='${tdsinfo.tdsSL}' />">Delete</a></td>
					</tr>
				</c:forEach>
				<!-- } -->
			</tbody>

		</table>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>