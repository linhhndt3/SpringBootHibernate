<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Jazz Application</title>
</head>
<body>
	<h1>Welcome to Spring Jazz </h1>
	<p>
		<a href="/">Trang Chủ</a>
		<sec:authorize access="!hasAnyRole('ROLE_USER')">
					<a href="http://localhost:8080/dang-nhap" style="margin-left: 30px">Dang Nhap</a>
				</sec:authorize>
				
				<sec:authorize access="hasAnyRole('ROLE_USER')">
					<a href="http://localhost:8080/nguoi-dung" style="margin-left: 30px">Ca nhan</a>
					<a href="http://localhost:8080/j_spring_security_logout" style="margin-left: 30px">Logout</a>
					
				</sec:authorize>
	</p>
	<tiles:insertAttribute name="body" />
</body>
</html>