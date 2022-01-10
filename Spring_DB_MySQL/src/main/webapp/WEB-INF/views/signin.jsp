<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입완료</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css">

<c:url value='/login_main' var="login_main" />
<c:url value='/signin_main' var="signin_main" />
<c:url value='/search' var="search"/>
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
			<span>회원가입이 완료되었습니다</span>
			</div>
			<div>
			<span><a href="${login_main}">로그인 화면으로 이동하기</a></span>
			</div>
		</div>
		<div id="footer"></div>

	</div>

</body>
</html>