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
<ul>
	<li><a href="member/list.do">회원 목록 보기</a></li>
</ul>
<h3>공지사항</h3>
<ul>
	<c:forEach var = "tmp" items="${list }">
		<li>${tmp }</li>
	</c:forEach>
</ul>
</body>
</html>