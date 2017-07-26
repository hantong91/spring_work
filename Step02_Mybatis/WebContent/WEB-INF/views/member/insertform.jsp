<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>views/member/insertform.jsp</title>
</head>
<body>
<h3>첫번째 방법</h3>
<form action="insert.do" method="post">

	이름 <input type="text" name= "name" />
	주소 <input type="text" name = "addr" />
	<button type = "submit">추가</button>
</form>
<h3>두번째 방법</h3>
<form action="insert2.do" method="post">

	이름 <input type="text" name= "name" />
	주소 <input type="text" name = "addr" />
	<button type = "submit">추가</button>
</form>
</body>
</html>