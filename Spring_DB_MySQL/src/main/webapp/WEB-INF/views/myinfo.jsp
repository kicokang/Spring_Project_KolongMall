<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인완료</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css">

<c:url value='/login_main' var="login_main" />
<c:url value='/signin_main' var="signin_main" />
<c:url value='/search' var="search" />

<%--제이쿼리 코드사용 --%>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
  
<script type="text/javascript">
	function confirming() {
		alert('<c:out value="로그아웃 되었습니다"/>')
	}
	
	function loadUserInfo(){
		alert("loadUserInfo실행")
		console.log("authenticatingPW:"+$('#authenticatingPW').val());
		var json={"authenticatingPW":$('#authenticatingPW').val()};
		$.ajax({
			url:"loadUserInfo",
			type:"POST",
			async:true,
			data:json,
			success:function(data){
				if(data.cnt==1){
					$(".result .msg").text("아이디가 겹칩니다.")
					$(".result .msg").attr("style", "color:#f00")
					$("#submit").attr("disabled","disabled")
					alert("아이디가 겹칩니다.");
				}else{
					$(".result .msg").text("사용 가능한 아이디 입니다.")
					$(".result .msg").attr("style", "color:#00f")
					alert("사용 가능한 아이디 입니다.");
					$("#submit").removeAttr("disabled")
				}
				//alert(JSON.stringify(data));  //오브젝트값 출력해보는 코드
			},
			error:function(){
				alert("에러")
			}
			
		})
		
	}
	
</script>

</head>
<body>
	<%-- <input type="text" name="session_id" id="session_id" value="${sessionScope.id}"/>
이렇게 하면 칸안에 값이 차있음	--%>
	<%--세션(로그인) 확인을 위한 코드~~ --%>
	<c:set var="session_id" value="${sessionScope.id}" scope="session" />
	<c:url value='/' var="index" />
	<c:set var="checkconfrim" value="${confrimUser}" />
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
				<div id="myInfo">
					<a href="${myinfo}">내정보</a>
				</div>
			</div>

		</div>
		<div id="contents">
			<%--비밀번호 입력 받아서....참이면 화면이 전환되게... --%>
			<c:if test="${empty checkconfrim}">
				<div>
					<h1>본인 인증을 위한 비밀번호를 입력해 주세요</h1>
					<form method="post" action="checkuser">
						비밀번호<input type="password" name="pw" id="authenticatingPW">
						<button type="submit" id="submit" onclick="loadUserInfo();">입력</button>
					</form>
				</div>
			</c:if>

			<c:if test="${checkconfrim eq true}">
				<div>개인정보</div>
				<div>
					<c:forEach items="${memberInfo}" var="info">
						<tr>
							<td>${info.id}</td>
							<td>${info.pw}</td>
							<td>${info.name}</td>
						</tr>
					</c:forEach>
				</div>
			</c:if>

		</div>
		<div id="footer"></div>

	</div>

</body>
</html>