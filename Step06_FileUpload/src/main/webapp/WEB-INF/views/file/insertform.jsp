<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>views/file/insertform.jsp</title>
</head>
<body>
<h3>파일 업로드 폼입니다.</h3>
<form action="insert.do" method="post" enctype="multipart/form-data">
	<label for="writer">작성자</label>
	<input type="text" name="writer" id="writer"/><br/>
	<label for="title">제목</label>
	<input type="text" name="title" id="title"/><br/>
	<label for="file">첨부 파일</label>
	<input type="file" name="file" id="file" /><br/>
	<button type="submit">업로드</button>
</form>
</body>
</html>












