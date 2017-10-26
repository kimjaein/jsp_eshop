<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Eshop a Flat E-Commerce Bootstrap Responsive Website
	Template | Chectout :: w3layouts</title>
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
<script type="application/x-javascript">addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }</script>
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
	<!-- checkout -->
	<div class="cart-items">
		<div class="container">
			<div class="dreamcrub">
				<ul class="breadcrumbs">
					<li class="home"><a href="index.jsp" title="Go to Home Page">Home</a>&nbsp;
						<span>&gt;</span></li>
					<li class="women">Cart</li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<h2>나의 장바구니 (Count(*))</h2>
			<div class="cart-gd">
				<!-- 상품 하나의 시작 -->
				<c:forEach var="list" items="${cartList}">
				<hr>
				<div class="cart-header1">
					<div class="close1"></div>
					<div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
							<img src="images/${list.large_Category}/${list.middle_Category}/${list.title}.JPG" class="img-responsive" alt="">
						</div>
						<div class="cart-item-info">
							<h3>
								<a href="#">상품명 : ${list.title} </a><br><br>
								<b>사이즈 : ${list.size}</b><br><br>
								<b>색상 : ${list.color}</b><br><br>
								<b>수량 : 1개</b><br><br>
								<b>가격 : ${list.price} </b><br><br>
							</h3>
							<div class="delivery">
								<span>
									<b>[무료 배송]</b>배송 예정일 1~3일
								</span>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				</c:forEach>
				<!-- 상품 하나의 끝 -->

			</div>
		</div>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>