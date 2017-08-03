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
<h3>Spring Exception 처리 예제</h3>

<ul>
	<li><a href="test01.do?name=kimgura">테스트1</a></li>
	<li><a href="test01.do">테스트2</a></li>
	<li><a href="shop/signup_form.do">쇼핑몰 회원 가입</a></li>
	<li><a href="shop/deposit_form.do">입금</a></li>
	<li><a href="shop/buy_form.do">구입</a></li>
</ul>

<h3>공지 사항 입니다.</h3>
<ul>
	<c:forEach var="tmp" items="${list }">
		<li>${tmp }</li>
	</c:forEach>
</ul>
</body>
</html>





