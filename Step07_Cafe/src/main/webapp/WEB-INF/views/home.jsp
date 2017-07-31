<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>views/home.jsp</title>
</head>
<body>
<h3>인덱스 페이지 입니다.</h3>
<c:choose>
	<c:when test="${empty id }">
		<div>
			<a href="users/signin_form.do?url=${pageContext.request.contextPath }">로그인</a>
			<a href="users/signup_form.do">회원가입</a>
		</div>
	</c:when>
	<c:otherwise>
		<div>
			<strong><a href="users/private/info.do">${id }</a></strong> 님 로그인중 ...
			<a href="users/signout.do">로그아웃</a>
		</div>
	</c:otherwise>
</c:choose>


<h3>공지 사항 입니다.</h3>
<ul>
	<c:forEach var="tmp" items="${list }">
		<li>${tmp }</li>
	</c:forEach>
</ul>
</body>
</html>





