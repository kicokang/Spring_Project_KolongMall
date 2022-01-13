<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>

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

<%--제이쿼리 코드사용 --%>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>

<script type="text/javascript">
function checkID(){
	console.log("checkID:"+$('#checkid').val());
	var json={"checkID":$('#checkid').val()};
	console.log("checkID:"+checkid);
	$.ajax({
		url:"idcheck.do",
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

function checkPW(){
	var pw=$('#pw').val()
	var pw2=$('#pw2').val()
	console.log("pw:"+pw)
	console.log("pw2:"+pw2)
	if(pw==pw2){
		alert("비밀번호가 확인 되었습니다.")
		$("#submit").removeAttr("disabled")
	}else{
		alert("비밀번호가 일치하지 않습니다!")
		$("#submit").attr("disabled","disabled")
	}
}

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
			아이디  <input type="text" name="checkid" id="checkid">
			<button type="button" class="checkid" onclick="checkID();">중복확인</button><br>
			<p class="result">
			<span class="msg"></span></p>
			비밀번호  <input type="password" name="pw" id="pw"><br>
			비밀번호 확인 <input type="password" name="pw2" id="pw2"> 
			<button type="button" onclick="checkPW();">비밀번호 확인</button><br>
			이름 <input type="text" name="name"><br>
			주소 <input type="text" name="address"><br>
			<button type="submit" id="submit" disabled="disabled" >회원가입</button>		
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