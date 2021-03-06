<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  	
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Eshop Login</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Eshop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<!-- for bootstrap working -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //for bootstrap working -->
<!-- cart -->
<script src="js/simpleCart.min.js"> </script>
<!-- cart -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

<script type="text/javascript">
	$(function(){
		// submit을 실행했을 때의 이벤트 및 조건문
		$('#loginForm').submit(function(){
			console.log("test:"+$('#id').val()+"/");
			
			if($('#id').val()== null || $('#id').val()==''){
				alert('아이디를 입력하세요.');
				$('#id').focus();
				return false;
			}
			else if($('#pw').val()== null || $('#pw').val()==''){
				alert('비밀번호를 입력하세요.');
				$('#pw').focus();
				return false;
			}
			document.form.submit();
		})
	})
</script>
	<!-- msg로 저장된 session을 알림창으로 출력 (예시:회원탈퇴 완료, 정보수정 완료 등등]-->
<%
	String msg = (String) session.getAttribute("msg");
	if (msg != null) {
%>
		<script>alert('<%=msg%>')</script>
<%
		session.removeAttribute("msg");
	}
%>
</head>
<body>

	<jsp:include page="top.jsp"></jsp:include>
	<!-- content-section-starts -->
	<div class="content">
		<div class="container">
			<div class="login-page">
				<div class="dreamcrub">
					<ul class="breadcrumbs">
						<li class="home"><a href="index.jsp" title="Go to Home Page">홈</a>&nbsp;
							<span>&gt;</span></li>
						<li>로그인</li>
					</ul>
					<ul class="previous">
						<li><a href="index.jsp">메인 화면으로</a></li>
					</ul>
					<div class="clearfix"></div>
				</div>

				<div class="account_grid">
					<div class="col-md-6 login-left wow fadeInLeft"
						data-wow-delay="0.4s">
						<h2>신규 회원</h2>
						<p>Join</p>
						<a class="acount-btn" href="register.jsp">새 계정 만들기</a>
					</div>

					<div class="col-md-6 login-right wow fadeInRight" data-wow-delay="0.4s">
						<h3>기존 회원</h3>
						<p>Login</p>
						<form name="form" id="loginForm" action="${pageContext.request.contextPath}/member" method="post">
						<input type="hidden" value="login" name="task">
							<div>
								<span>아이디<label>*</label></span> 
								<input type="text" id="id" name="id" placeholder="아이디를 입력하세요.">
							</div>

							<div>
								<span>비밀번호<label>*</label></span> 
								<input type="password" id="pw" name="pw" placeholder="비밀번호를 입력하세요.">
							</div>
							<input type="submit" value="로그인">
						</form>
					</div>
					<div class="clearfix"></div>
				</div>

			</div>
		</div>
		<!-- 		<div class="news-letter"> -->
		<!-- 			<div class="container"> -->
		<!-- 				<div class="join"> -->
		<!-- 					<h6>JOIN OUR MAILING LIST</h6> -->
		<!-- 					<div class="sub-left-right"> -->
		<!-- 						<form> -->
		<!-- 							<input type="text" value="Enter Your Email Here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Your Email Here';}" /> -->
		<!-- 							<input type="submit" value="SUBSCRIBE" /> -->
		<!-- 						</form> -->
		<!-- 					</div> -->
		<!-- 					<div class="clearfix"> </div> -->
		<!-- 				</div> -->
		<!-- 			</div> -->
		<!-- 		</div> -->
	</div>
	<!-- 		<div class="news-letter"> -->
	<!-- 			<div class="container"> -->
	<!-- 				<div class="join"> -->
	<!-- 					<h6>JOIN OUR MAILING LIST</h6> -->
	<!-- 					<div class="sub-left-right"> -->
	<!-- 						<form> -->
	<!-- 							<input type="text" value="Enter Your Email Here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Your Email Here';}" /> -->
	<!-- 							<input type="submit" value="SUBSCRIBE" /> -->
	<!-- 						</form> -->
	<!-- 					</div> -->
	<!-- 					<div class="clearfix"> </div> -->
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</div> -->
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>