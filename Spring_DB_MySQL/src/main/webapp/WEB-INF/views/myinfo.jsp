<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인완료</title>
<link href="${pageContext.request.contextPath}/css/index.css?after"
	rel="stylesheet" type="text/css">

<c:url value='/login_main' var="login_main" />
<c:url value='/signin_main' var="signin_main" />
<c:url value='/search' var="search" />

<%--제이쿼리 코드사용 --%>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

<script type="text/javascript">
	function confirming() {
		alert('<c:out value="로그아웃 되었습니다"/>')
	}

	function loadUserInfo() {
		alert("loadUserInfo실행")
		console.log("id:" + $('#session_id').val());
		console.log("pw:" + $('#authenticatingPW').val());
		var json = {
			"id" : $('#session_id').val(),
			"pw" : $('#authenticatingPW').val()
		};
		$.ajax({
			url : "loadUserInfo.do",
			type : "POST",
			async : true,
			data : json,
			success : function(data) {
				if (data.cnt != null) {
					alert(JSON.stringify(data)); //오브젝트값 출력해보는 코드
					//var infoList=data.infoList;
					//var name =infoList.name;
					var userIdInfo = (data.cnt[0].id);
					var userPwInfo = (data.cnt[0].pw);
					var userNameInfo = (data.cnt[0].name);
					var userAddressInfo = (data.cnt[0].address);
					//alert(userIdInfo);
				} else {
					alert("ajax 값 불러오기 실패");
					//alert(JSON.stringify(data)); //오브젝트값 출력해보는 코드
				}
				//alert(JSON.stringify(data));  //오브젝트값 출력해보는 코드
			},
			error : function() {
				alert("에러")
			}

		})

	}

	function signout() {
		var conf = confirm('정말 회원탈퇴 하시겠습니까?');
		if (conf) {
			var prom = prompt('아이디를 다시 입력해 주세요.')
			if (prom === $('#session_id').val()) {
				alert("탈퇴되었습니다!")
<%-- a태그 클릭
				$('#withdrawal').get(0).click();
				    from태그 id                   주소--%>
	$('input[name=withdrawal]').attr('value', prom);
				$("#withdrawal").attr("action", "withdrawal").submit();
			} else {
				alert("아이디가 다릅니다. \n취소되었습니다.")
			}
		}

	}
	<%--수정칸 열고 닫기--%>
	function openupdate(para){
		if ( $("."+para).css("display") == "none" ){
			$("."+para).show(); 
			}
		else{
			$("."+para).hide(); 
		}
	}
	
	<%-- --%>
	function pwchange(){
		alert("!")
		console.log("id:" + $('#session_id').val());
		console.log("pw:" + $('#inputpw').val());
		var json = {
			"id" : $('#session_id').val(),
			"pw" : $('#inputpw').val()
		};
		$.ajax({
			url : "update.do",
			type : "POST",
			async : true,
			data : json,
			success : function(data) {
				if (data.cnt1 != null) {
					alert(JSON.stringify(data));
					var userPwInfo = (data.cnt[0].pw);
					alert(userPwInfo);
				} else {
					alert("ajax 값 불러오기 실패");
				}
			},
			error : function() {
				alert("에러")
			}

		})

	}
	
</script>

</head>
<body>
	<input type="hidden" name="session_id" id="session_id"
		value="${sessionScope.id}" />
	<%-- 이렇게 하면 칸안에 값이 차있음	--%>
	<%--세션(로그인) 확인을 위한 코드~~ --%>
	<c:set var="session_id" value="${sessionScope.id}" scope="session" />
	<c:url value='/' var="index" />
	<c:set var="checkconfrim" value="${confrimUser}" />
	<c:url value="myinfo" var="myinfo" />
	<c:url value="withdrawal" var="withdrawal" />
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

				<c:if test="${empty session_id }">
					<div id="signinbox">
						<a href="${signin_main}">회원가입</a>
					</div>
				</c:if>
				<div id="myinfo">
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
						<input type="hidden" name="session_id" value="${session_id}">
						<button type="submit" id="submit" onclick="loadUserInfo();">입력</button>
					</form>
				</div>
			</c:if>

			<c:if test="${checkconfrim eq true}">
				<div id="infobox">개인정보</div>
				<table id="table">
					<thead>
						<tr>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${memberInfo}" var="info">
							<tr>
								<th class="infocom"><div>아이디</div></th>
								<td class="infocon"><div>${info.id}</div></td>
							</tr>
							<tr>
								<th class="infocom"><div>비밀번호</div></th>
								<td class="infocon"><span class="nowinfo">${info.pw}</span>
								<button onclick="openupdate('pwinput')">수정</button>
									<div class="pwinput">
										<form method="post" action="checkuser">
											<input type="text" id="inputpw" name="pw" value="${info.pw}">
											<input type="hidden" name="session_id" value="${session_id}">
											<button type="submit" id="submit" onclick="pwchange();">완료</button>
										</form>
									</div></td>
							</tr>
							<tr>
								<th class="infocom"><div>이름</div></th>
								<td class="infocon"><span class="nowinfo">${info.name}</span>
								<button onclick="openupdate('nameinput')">수정</button>
									<div class="nameinput">
										<form>
											<input type="text" value="${info.name}">
											<button type="submit" id="">완료</button>
										</form>
									</div></td>
							</tr>
							<tr>
								<th class="infocom"><div class="nowinfo">주소</div></th>
								<td class="infocon"><span class="nowinfo">${info.address}</span>
								<button onclick="openupdate('addressinput')">수정</button>
									<div class="addressinput">
										<form>
											<input type="text" value="${info.address}">
											<button type="submit" id="">완료</button>
										</form>
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div id="signout">
					<button onclick="signout();">회원탈퇴</button>
					<form METHOD="post" id="withdrawal">
						<input type="hidden" name="withdrawal" value="">
					</form>

					<%-- 
					<a href="${withdrawal}" type="hidden" id="withdrawal"></a>
					--%>
				</div>
			</c:if>

			<c:if test="${checkconfrim eq false}">
				<div>
					<h1>비밀 번호가 틀렸습니다. 재입력해 주세요</h1>
					<form method="post" action="checkuser">
						비밀번호<input type="password" name="pw" id="authenticatingPW">
						<input type="hidden" name="session_id" value="${session_id}">
						<button type="submit" id="submit" onclick="loadUserInfo();">입력</button>
					</form>
				</div>
			</c:if>

		</div>
		<div id="footer">
			<div>ㅎㅇ</div>
		</div>

	</div>

</body>
</html>