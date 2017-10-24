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
<title>회원 가입</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Eshop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
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
</head>

<body>
	<jsp:include page="top.jsp"></jsp:include>
	<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
	<form action="${myContextPath}/member" method="post">
	<input type = "hidden" name = "task" value="join">
		<!-- registration-form -->
<div class="registration-form">
	<div class="container">
	<div class="dreamcrub">
			   	 <ul class="breadcrumbs">
                    <li class="home">
                       <a href="index.jsp" title="Go to Home Page">홈</a>&nbsp;
                       <span>&gt;</span>
                    </li>
                   
                    <li class="women">
						회원가입
                    </li>
                </ul>
                <ul class="previous">
                	<li><a href="index.jsp">메인 화면으로</a></li>
                </ul>
                <div class="clearfix"></div>
			   </div>

		<h2>회원가입</h2>
		
		<div class="registration-grids">
			<div class="reg-form">
				<div class="reg">
					 <p>아래 항목에 해당되는 내용을 적어주십시오.</p>
					 <p>이미 가입이 되어있다면, <a href="account.jsp">여기를 누르세요!!</a></p>
					 <form >
						 <ul>
							 <li class="text-info">아이디: </li>
							 <li><input type="text" id="id" name="id" placeholder="아이디를 입력하세요."></li>
						 </ul>
						 <ul>
							 <li class="text-info">비밀번호: </li>
							 <li><input type="password" name="pw" placeholder="비밀번호를 입력하세요."></li>
						 </ul>				 
						<ul>
							 <li class="text-info">이름: </li>
							 <li><input type="text" name="name" placeholder="이름을 입력하세요."></li>
						 </ul>
						 <ul>
							 <li class="text-info">전화번호: </li>
							 <li><input type="text" name="phone" placeholder="전화번호를 입력하세요."></li>
						 </ul>
						 <ul>
							 <li class="text-info">주소:</li>
							 <li><input type="text" name="address" placeholder="주소를 입력하세요."></li>
						 </ul>
						 <ul>
							 <li class="text-info">이메일:</li>
							 <li><input type="text" name="email" placeholder="메일 주소를 입력하세요."></li>
						 </ul>						
						 <input type="submit" value="지금 가입하기">
<!-- 						 <p class="click">By clicking this button, you are agree to my  <a href="#">Policy Terms and Conditions.</a></p>  -->
					 </form>
				 </div>
			</div>
<!-- 			<div class="reg-right"> -->
<!-- 				 <h3>Completely Free Account</h3> -->
<!-- 				 <div class="strip"></div> -->
<!-- 				 <p>Pellentesque neque leo, dictum sit amet accumsan non, dignissim ac mauris. Mauris rhoncus, lectus tincidunt tempus aliquam, odio  -->
<!-- 				 libero tincidunt metus, sed euismod elit enim ut mi. Nulla porttitor et dolor sed condimentum. Praesent porttitor lorem dui, in pulvinar enim rhoncus vitae. Curabitur tincidunt, turpis ac lobortis hendrerit, ex elit vestibulum est, at faucibus erat ligula non neque.</p> -->
<!-- 				 <h3 class="lorem">Lorem ipsum dolor.</h3> -->
<!-- 				 <div class="strip"></div> -->
<!-- 				 <p>Tincidunt metus, sed euismod elit enim ut mi. Nulla porttitor et dolor sed condimentum. Praesent porttitor lorem dui, in pulvinar enim rhoncus vitae. Curabitur tincidunt, turpis ac lobortis hendrerit, ex elit vestibulum est, at faucibus erat ligula non neque.</p> -->
<!-- 			</div> -->
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- registration-form -->

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
	</form>
		<jsp:include page="bottom.jsp"></jsp:include>	
</body>
</html>