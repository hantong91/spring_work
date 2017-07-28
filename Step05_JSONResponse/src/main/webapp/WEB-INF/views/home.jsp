<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>views/home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<h3>인덱스 페이지 입니다.</h3>
<ul>
	<li><a href="json01.do">json 응답1</a></li><!-- 간단한문자열 -->
	<li><a href="json02.do">json 응답2</a></li><!-- Map<> -->
	<li><a href="json03.do">json 응답3</a></li><!-- List<> -->
	<li><a href="json04.do">json 응답4</a></li><!-- List<Map<>> -->
	<li><a href="json05.do">json 응답5</a></li><!-- dto -->
	<li><a href="member_list.do">회원목록</a></li>
</ul>

<button id="getListBtn">Ajax 회원목록 요청</button>

<h3>공지 사항 입니다.</h3>
<ul>
	<c:forEach var="tmp" items="${list }">
		<li>${tmp }</li>
	</c:forEach>
</ul>

<h3>회원가입 폼입니다.</h3>
<form action="signup.do" method="post" id="myForm">
	아이디 <input type="text" id="id" name="id"/>
	<button id="checkBtn">중복확인</button>
	<span id="checkResult"></span>
	<button type="submit">가입</button>
</form>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.2.0.js"></script>
<script>
	$("#getListBtn").click(function(){
		$.ajax({
			url:"${pageContext.request.contextPath }/member_list.do",
			method:"GET",
			success:function(data){
				console.log(data);
			}
		});
	});
	
	//아이디 중복 확인 버튼을 눌렀을때 실행할 함수 드옥
	$("#checkBtn").click(function(){
		//입력한 아이디를 읽어온다.
		var id=$("#id").val();
		//ajax 를 이용해서 사용가능한지 여부를 응답받는다.
		$.ajax({
			url:"checkid.do",
			method:"GET",
			data:{inputId:id},
			success:function(data){
				if(data.isExist){
					$("#checkResult").text("사용불가");
				}else{
					$("#checkResult").text("사용가능");
				}
			}
		});
		
		return false; //폼 전송 막기
	});
</script>
</body>
</html>














