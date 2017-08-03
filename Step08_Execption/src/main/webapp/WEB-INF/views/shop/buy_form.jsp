<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>views/shop/buy_form.jsp</title>
</head>
<body>
<h3>물품 구입 폼입니다.</h3>
<form action="buy.do" method="post">
	구입자 아이디 <input type="text" name ="id" /><br />
	가격 <input type="text" name ="money" /><br />
	주소 <input type="text" name="addr" /><br />
	<button type="submit">구입</button>
</form>
</body>
</html>