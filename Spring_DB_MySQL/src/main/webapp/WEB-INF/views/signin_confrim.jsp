<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css">

<c:url value='/login_main' var="login_main" />
<c:url value='/signin_main' var="signin_main" />
<c:url value='/search' var="search"/>

<%--j쿼리 --%>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>

<script type="text/javascript">

</script>

</head>
<body>
	<div id="wrap">

		<div id="header">
			<div id="search">
				<div id="searchblock">
					<form METHOD="get" ACTION="search">
						옷 정보 검색 : <input type="text" name="search"><input
							type="submit" value="검색">
					</form>
				</div>

			</div>
			<div id="logo">
				<a href="http://localhost:8888/Spring_DB_MySQL/"> <img alt="로고"
					src="${pageContext.request.contextPath}/images/kolonmall.png"
					width="150px" height="150px">
				</a>
			</div>
			<div id="nav"></div>
				<div id="login">
			<c:out value="${session_id}"/>
				<c:if test="${empty session_id }">
					<div id="loginbox">
						<a href="${login_main}">로그인</a>
					</div>
				</c:if>

				<c:if test="${not empty session_id }">
					<div id="logoutbox">
						<a href="${index}">로그아웃</a>
					</div>
				</c:if>
				<div id="signinbox">
					<a href="${signin_main}">회원가입</a>
				</div>
				<div></div>
			</div>

		</div>
		<div id="contents">
			<div id="singin">
			<form method="post" action="signin">
			아이디  <input type="text" name="id" id="id" class="id_input">
			<button type="button" onclick="checkid();">중복확인</button><br>
			비밀번호  <input type="text" name="pw"><br>
			비밀번호 확인 <input type="text" name="pw"><br>
			이름 <input type="text" name="name"><br>
			주소 <input type="text" name="address"><br>
			<input type="submit" value="회원가입">		
			</form>
			</div>
		</div>
		<div id="footer"></div>

	</div>
	<%-- 
<script type="text/javascript">
$('.id_input').on("propertychange change keyup paste input", function(){

	console.log("keyup 테스트");	

});// function 종료
</script>
--%>
</body>
</html>