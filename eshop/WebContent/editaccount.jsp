<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Edit Account</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Eshop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--webfont-->
<!-- for bootstrap working -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //for bootstrap working -->
<!-- cart -->
<script src="js/simpleCart.min.js">
	
</script>
<!-- cart -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />

	<script type="text/javascript">
		function pwCheck(){
			var pw1= $('#pw1').val();
			var pw2=$('#pw2').val();
			
			if(pw1 == pw2){
				$('#passwordCheck').html("<b>패스워드가 일치합니다</b>");
				$('#passwordCheck').css('color','green');
				$('#submit').val('수정 완료');
				$('#submit').attr('disabled',false);
			}else{
				$('#passwordCheck').html("<b>패스워드가 일치하지 않습니다</b>");
				$('#passwordCheck').css('color','red');
				$('#submit').attr('disabled',true);
				$('#submit').val('수정 불가');
			}
		}
		$(function(){
			// submit을 실행했을 때의 이벤트 및 조건문
			$('#editForm').submit(function(){
				if($('#pw1').val()== null || $('#pw1').val()==''){
					alert('패스워드를 입력하세요.');
					$('#pw1').focus();
					return false;
				}else if($('#pw2').val()== null || $('#pw2').val()==''){
					alert('패스워드를 입력하세요.');
					$('#pw2').focus();
					return false;
				}else if($('#pw1').val() != $('#pw2').val()){
					alert('패스워드가 일치하지 않습니다');
					return false;
				}else if($('input[name=username]').val() ==null || $('input[name=username]').val()==''){
					alert('이름을 입력하세요');
					return false;
				}else if($('input[name=userphone]').val() == null || $('input[name=userphone]').val()==''){
					alert('휴대폰번호를 입력하세요');
					return false;
				}else if($('input[name=useremail]').val() == null || $('input[name=useremail]').val() == ''){
					alert('이메일을 입력하세요');
					return false;
				}else if($('input[name=useraddress]').val() == null || $('input[name=useraddress]').val() == ''){
					alert('주소를 입력하세요')
					return false;
				}
				document.form.submit();
			})
		})
	</script>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<center>
		<div class="clearfix"></div>
		<p><br></p>
		<h2>정보 수정</h2>
		<div class="registration-grids">
			<div class="reg-form">
				<div class="reg">
					<form name="form" id="editForm" action="${pageContext.request.contextPath}/test" method="post">
					<input type="hidden" name="task" value="edit">
					<input type="hidden" name="userid" value="${sessionScope.loginId}">
					<!-- List에서 값 받아오고 text value에 넣고 수정완료 클릭시 값 넘어감 -->
						<ul>
							<li class="text-info">ID:</li>
							<li><input type="text" value="${memberInfo.id}" disabled="disabled"></li>
						</ul>
						<ul>
							<li class="text-info">Password:</li>
							<li><input type="password" name="userpw1" id="pw1" onkeyup="pwCheck();"></li>
						</ul>
						<ul>
							<li class="text-info">Password2:</li>
							<li><input type="password" name="userpw2" id="pw2" onkeyup="pwCheck();"></li>
						</ul>
						<ul>
						<li class="text-info">PASSWORD SAME:</li>
						<li id="passwordCheck"></li>
						</ul>
						
						<ul>
							<li class="text-info">Name:</li>
							<li><input type="text" value="${memberInfo.name}" name="username"></li>
						</ul>
						<ul>
							<li class="text-info">Phone Number:</li>
							<li><input type="text" value="${memberInfo.phone}" name="userphone"></li>
						</ul>
						<ul>
							<li class="text-info">Address:</li>
							<li><input type="text" value="${memberInfo.address}" name="useraddress"></li>
						</ul>
						<ul>
							<li class="text-info">E-mail:</li>
							<li><input type="text" value="${memberInfo.email}" name="useremail"></li>
						</ul>
						<input type="submit" id="submit" class="acount-btn" value="수정 불가">
					</form>
				</div>
			</div>
		</div>
	</center>
	<div class="clearfix"></div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>