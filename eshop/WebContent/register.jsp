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
<title>Register</title>
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
<style>
#idCheck{
	border:none;
	color: #ffffff;
	padding: 9px 35px;
	font-size: 14px;
	cursor: pointer;
	font-weight: 500;
	margin: 0 0 22px 0;
	background: #816263;
	border-top: none;
	border-left: none;
	border-right: none;
	display:inline-block;
}

#id{
	display:inline-block;
	width:50%;
}
</style>
<script type="text/javascript">
	$(function(){
		// 아이디 중복여부 검사
		$('#idCheck').click(function(){
			var id = $('#id').val();
			$.ajax({
				type:'post',
				url:'member?task=loginIdCheck&id='+id,
				dataType:'text', // 응답데이터 형식, 보통은 xml, json으로 옴.
				success:function(idCheck){
					
					if(id == ''){
						alert('아이디를 입력하세요.')
						return false;
					}
					
					if(idCheck == null || idCheck == 'null'){
						alert('사용할수 있는 아이디입니다.')
						document.form.submit.disabled = false;
					}
					
					else{
						alert('이미 등록된 아이디입니다.')
					}
					
				},
				error:function(){
					alert("ajax 요청이 전달되지 못함.")
				}
			})
			return false;
		})
		
		// 가입 버튼을 눌렀을 때의 이벤트 및 조건문
		$('#joinForm').submit(function(){
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
			else if($('#name').val()== null || $('#name').val()==''){
				alert('이름을 입력하세요.');
				$('#name').focus();
				return false;
			}
			else if($('#phone').val()== null || $('#phone').val()==''){
				alert('전화번호를 입력하세요.');
				$('#phone').focus();
				return false;
			}
			else if($('#address').val()== null || $('#address').val()==''){
				alert('주소를 입력하세요.');
				$('#address').focus();
				return false;
			}
			else if($('#email').val()== null || $('#email').val()==''){
				alert('이메일을 입력하세요.');
				$('#email').focus();
				return false;
			}
			document.form.submit();
		})
	})
</script>
</head>

<body>
	<jsp:include page="top.jsp"></jsp:include>
<%-- 	<form action="${myContextPath}/member" method="post"> --%>
<!-- 	<input type="hidden" name="task" value="join"> -->
		<!-- registration-form -->
<div class="registration-form">
	<div class="container">
	<div class="dreamcrub">
			   	 <ul class="breadcrumbs">
                    <li class="home">
                       <a href="index.jsp" title="Go to Home Page">홈</a>&nbsp;
                       <span>&gt;</span>
                    </li>
                   
                    <li>
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
				 <!-- form에도 id, name을 부여할수 있다. -->	
					 <form name="form" id="joinForm" action="${pageContext.request.contextPath}/member" method="post">
					 <input type="hidden" name="task" value="join">
						 <ul style="height:38px;">
							 <li class="text-info">아이디: </li>
							 <li>
							 <input type="text" id="id" name="id" placeholder="아이디를 입력하세요.">
							 	 <button id="idCheck">중복검사</button>	
							 </li>
						 </ul>
						 <ul>
							 <li class="text-info">비밀번호: </li>
							 <li><input type="password" id="pw" name="pw" placeholder="비밀번호를 입력하세요."></li>
						 </ul>				 
						<ul>
							 <li class="text-info">이름: </li>
							 <li><input type="text" id="name" name="name" placeholder="이름을 입력하세요."></li>
						 </ul>
						 <ul>
							 <li class="text-info">전화번호: </li>
							 <li><input type="text" id="phone" name="phone" placeholder="전화번호를 입력하세요."></li>
						 </ul>
						 <ul style="margin-bottom: 25px;">
							 <li class="text-info">주소:</li>
							 <li><input type="text" id="address" name="address" placeholder="주소를 입력하세요."></li>
						 </ul>
						 <ul>
							 <li class="text-info">이메일:</li>
							 <li><input type="text" id="email" name="email" placeholder="메일 주소를 입력하세요."></li>
						 </ul>						
						 <input type="submit" name="submit" value="지금 가입하기" disabled="disabled">
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
<!-- 	</form> -->
		<jsp:include page="bottom.jsp"></jsp:include>	
	
</body>
</html>