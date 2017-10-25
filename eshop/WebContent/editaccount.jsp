<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>정보수정</title>
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
		<h2>정보 수정</h2>
		<div class="registration-grids">
			<div class="reg-form">
				<div class="reg">
					<form action="${pageContext.request.contextPath}/test" method="post">
					<input type="hidden" name="task" value="edit">
					<!-- List에서 값 받아오고 text value에 넣고 수정완료 클릭시 값 넘어감 -->
						<ul>
							<li class="text-info">ID:</li>
							<li><input type="text" value="${memberInfo.id}" name="userid"></li>
						</ul>
						<ul>
							<li class="text-info">Password:</li>
							<li><input type="password" name="userpw1"></li>
						</ul>
						<ul>
							<li class="text-info">Password2:</li>
							<li><input type="password" name="userpw2"></li>
						</ul>
						<ul>
							<li class="text-info">Name:</li>
							<li><input type="text" value="${memberInfo.name}" name="username"></li>
						</ul>
						<ul>
							<li class="text-info">Phone Number:</li>
							<li><input type="password" value="${memberInfo.phone}" name="userphone"></li>
						</ul>
						<ul>
							<li class="text-info">Address:</li>
							<li><input type="password" value="${memberInfo.address}" name="useraddress"></li>
						</ul>
						<ul>
							<li class="text-info">E-mail:</li>
							<li><input type="text" value="${memberInfo.email}" name="useremail"></li>
						</ul>
						<input type="submit" value="수정 완료">
					</form>
				</div>
			</div>
		</div>
	</center>
	<div class="clearfix"></div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>