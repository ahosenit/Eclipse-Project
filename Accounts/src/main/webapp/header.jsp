<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BHBFC | Accounts</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<!-- Navbar -->

	<nav class="navbar navbar-expand-lg navbar-dark bg-custom" style="background: #1b5e20;">
		<a class="navbar-brand" href="<%=request.getContextPath()%>">BHBFC</a>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/Dashboard">Dashboard</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/UserList">User List</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/UserForm">Create User</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> TDS </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item"
							href="<%=request.getContextPath()%>/TDSInfoList">TDS List</a> 
						<a class="dropdown-item"
							href="<%=request.getContextPath()%>/TDSInfoForm">TDS Entry</a> 
						<%-- <a class="dropdown-item"
							href="<%=request.getContextPath()%>/update-tds.jsp">Update TDS</a> --%>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/logout">LogOut</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">PF Number : <%=session.getAttribute("UserName")%>
					</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">PF Number : <%=session.getAttribute("UserName")%></a>
							<a class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/logout">Logout</a>
						</div></li>
				</ul>
			</form>
		</div>
	</nav>

	<!-- End Navbar -->