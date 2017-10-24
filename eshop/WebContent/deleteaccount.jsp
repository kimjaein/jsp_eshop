<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>계정 삭제</title>
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
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<center>
		<div class="clearfix"></div>
		<p><br></p>
		<h2>계정 삭제</h2>
		<div class="registration-grids">
			<div class="reg-form">
				<div class="reg">
					<form action="보낼 서블릿으로 정보전송">
					<!-- 입력한 패스워드가 DB에 있는 패스워드와 일치시에 삭제 -->
					<!-- SessionScope.loginId 값도 같이 보낸다. -->
					<input type="hidden" name="userid" value="${SessionScope.loginId}">
						<ul>
							<li class="text-info">Password:</li>
							<li><input type="text" value="" name="userpw"></li>
							<li></li>
						</ul>
						<input type="submit" value="삭제 하기">
					</form>
				</div>
			</div>
		</div>
	</center>
	<div class="clearfix"></div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>