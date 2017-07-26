<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>views/member/list.jsp</title>
</head>
<body>
<a href="insertform.do">회원 추가하기</a>
<h3>회원 목록입니다.</h3>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="tmp" items="${list }">
			<tr>
				<th>${tmp.num }</th>
				<th>${tmp.name }</th>			
				<th>${tmp.addr }</th>
				<th><a href="delete.do?num=${tmp.num }">삭제</a></th>
			</tr>
		</c:forEach>		
	</tbody>
</table>
</body>
</html>