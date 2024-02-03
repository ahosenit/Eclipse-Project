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
	<div class="row mt-5 d-flex justify-content-center">
		<div class="col-md-5">
			<div class="card">
				<div class="card-header text-center">
					<i class="fa fa-user-circle-o fa-2x"></i>
					<h3>Welcome</h3>
					<%-- <%
						User user = (User) session.getAttribute("UserName");
						%> --%>

					<div class="card-body text-left">
						<h4>Name : <%=session.getAttribute("FullName")%></h4>
						<h4>
							PF Number :
							<%=session.getAttribute("UserName")%>
						</h4>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>


<jsp:include page="footer.jsp"></jsp:include>