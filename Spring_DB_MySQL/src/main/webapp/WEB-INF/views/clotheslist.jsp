<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>clothesList</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/search.css"
	rel="stylesheet" type="text/css">
</head>
<body>


	<%-- 	<c:set var="currentPage" value="1" />
	<c:out value="${currentPage}" />

	<c:set var="pagePerRow" value="5" />
	<c:set var="lastPage" value="${totalRowCount/pagePerRow}" />
	if (totalRowCount % pagePerRow != 0) { lastPage++; }

 --%>
	<%
	int nowPage = 1;
	%>

	<%
String search = request.getParameter("search");
String SnowPage = Integer.toString(nowPage);
%>
	<c:url value='/login_main' var="login_main" />
	<c:url value='/signin_main' var="signin_main" />


	<c:url value='/search' var="search">
		<c:param name="search" value="<%=search%>" />
		<c:param name="nowPage" value="<%=SnowPage%>" />
	</c:url>



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
		</div>


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
						<div id="page-number">

							<span id="page"><a href="${search}">${data}</a></span>
							<%
nowPage = Integer.parseInt(SnowPage);
SnowPage = Integer.toString(nowPage+1);
%>
							<c:url value='/search' var="search">
								<c:param name="search" value="<%=search%>" />
								<c:param name="nowPage" value="<%=SnowPage%>" />
							</c:url>

							<%--이제 span안에 누를때 snowPage만 다르게하면...
						우선 따로따로 출력을 확인해야할것같은데? --%>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>

		<div id="slide"></div>

		<div id="footer"></div>

	</div>
</body>
</html>
