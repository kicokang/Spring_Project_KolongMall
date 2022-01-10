<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인완료</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css">

<%--주소 이름 설정 --%>
<c:url value='/login_main' var="login_main" />
<c:url value='/signin_main' var="signin_main" />
<c:url value='/search' var="search" />
<c:url value='/myinfo' var="myinfo"/>


<script type="text/javascript">
	function confirming() {
		alert('<c:out value="로그아웃 되었습니다"/>')
	}
</script>

</head>
<body>
	<%-- <input type="text" name="session_id" id="session_id" value="${sessionScope.id}"/>
이렇게 하면 칸안에 값이 차있음--%>

	<c:set var="session_id" value="${sessionScope.id}" scope="session" />
	
	<c:url value='/' var="index" />

	<%-- 출력
<c:out value="${session_id}"/> 
--%>

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
					width="150px" height="150px" onclick="confirming()">

				</a>
			</div>
			<div id="nav"></div>
			<div id="login">
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
				<c:if test="${not empty session_id }">
					<div id="myinfo">
						<a href="${myinfo}">내정보</a>
					</div>
				</c:if>
			</div>

		</div>
		<div id="slide"></div>
		<div id="contents"></div>
		<div id="footer"></div>

	</div>

</body>
</html>