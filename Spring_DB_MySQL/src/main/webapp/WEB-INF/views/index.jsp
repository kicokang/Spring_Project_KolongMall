<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<%--j쿼리 --%>
<script type="text/javascript"
  src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js">
</script>
﻿
<%--css --%>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css">
<%--주소 매핑 --%>
<c:url value='/login_main' var="login_main" />
<c:url value='/signin_main' var="signin_main" />
<c:url value='/search' var="search" />

<script type="text/javascript">

$(document).ready(function(){
	var currentSlide=1;
	$(".prev").click(function(){
		if(currentSlide-1 <=0){
			currentSlide=3
		}else{
			currentSlide-=1
		}
		
		$("#current-slide").text(currentSlide)
		$("#tab>img").hide()
		//img요소의 인덱스는 0부터 시작이므로.. 0/1/2 밖에없다.
		$("#tab>img").eq(currentSlide-1).show()
	})
	
	$(".next").click(function(){
		if(currentSlide+1 > 3){
			currentSlide=1
		}else{
			currentSlide+=1
		}
		$("#current-slide").text(currentSlide)
		$("#tab>img").hide()
		$("#tab>img").eq(currentSlide-1).show()
	})
})

</script>

</head>
<body>
	<%-- <input type="text" name="session_id" id="session_id" value="${sessionScope.id}"/>
이렇게 하면 칸안에 값이 차있음--%>
	<c:remove var="session_id" scope="session" />

	<%-- 출력
<c:out value="${session_id}"/> --%>
	<%
	int nowPage = 1;
	%>

	<div id="wrap">
		<%--헤더 --%>
		<div id="header">
			<div id="search">
				<div id="searchblock">
					<form METHOD="get" ACTION="search">
						옷 정보 검색 : <input type="text" name="search"> <input
							type="submit" value="검색"> <input type="hidden"
							name="nowPage" value="<%=nowPage%>">
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
				<c:out value="${session_id}" />
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
		<%--슬라이드 --%>
		<div id="slide">
			<form>
				<input type="hidden" placeholder="1페이지 넘기기" name="page" id="page"
					value="1" />
			</form>
			<div id="right">
				<div id="tab">
					<img src="${pageContext.request.contextPath}/images/slide1.jpg"
						width="1600px" height="300px" /> <img
						src="${pageContext.request.contextPath}/images/slide2.jpg"
						width="1600px" height="300px" /> <img
						src="${pageContext.request.contextPath}/images/slide3.jpg"
						width="1600px" height="300px" />
				</div>
				<div id="tab-btn">
					<span id="current-slide">1</span> <span>/3</span>
					<button class="prev"></button>
					<button class="next"></button>
				</div>
			</div>

		</div>

		<%--본문 --%>
		<div id="contents">
			<div id="list">
				<table id="table">
					<thead>
						<tr>
							<th>이름</th>
							<th>카테고리</th>
							<th>브랜드</th>
							<th>가격</th>
							<th>수량</th>
							<th>사이즈</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clothesList}" var="clothes">
							<tr>
								<td>${clothes.name}</td>
								<td>${clothes.category}</td>
								<td>${clothes.brand}</td>
								<td>${clothes.price}</td>
								<td>${clothes.quantity}</td>
								<td>${clothes.c_size}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div id="page-list">
					<c:forEach items="${testArray}" var="data">
						<span id="page">${data}</span>
					</c:forEach>
				</div>
			</div>

		</div>

		<div id="footer"></div>

	</div>

</body>
</html>