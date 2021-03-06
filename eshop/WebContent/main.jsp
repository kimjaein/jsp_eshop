<%@page import="vo.Product"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>SDS-SHOP</title>
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

<%
	//로그아웃 수행시 로그아웃 세션 속성을 삭제함.
	String logout = (String) session.getAttribute("logout");
	if (logout == "complete") {
%>
	<script>alert("로그아웃 하였습니다.")</script>
<%
	session.removeAttribute("logout");
	}
%>
<!-- msg로 저장된 session을 알림창으로 출력 (예시:회원탈퇴 완료, 정보수정 완료 등등]-->
<%
	String msg = (String) session.getAttribute("msg");
	if (msg != null) {
%><script>alert('<%=msg%>')</script>

<%
	session.removeAttribute("msg");
	}
%>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="banner">
		<div class="container">
			<div class="banner-bottom">
				<div class="banner-bottom-right">
					<div class="callbacks_container">
						<ul class="rslides" id="slider4">
							<li>
								<div class="banner-info">
									<h3>Join LIFE</h3>
									<p>SUSTAINABILITY</p>
								</div>
							</li>
							<li>
								<div class="banner-info">
									<h2>our boxes  are made<br>of boxes with<br> a past</h2>
									
									<p>#recycle</p>
								</div>
							</li>
							<li>
								<div class="banner-info">
									<h3>Our products</h3>
									<p>Our products meet the most<br>stringent health, safety and<br>environmental sustainability<br>standards</p>
								</div>
							</li>
							<li>
								<div class="banner-info">
									<h3>Our suppliers</h3>
									<p>Our supply chain respects workers<br>and the environment</p>
								</div>
							</li>
						</ul>
					</div>
					<!--banner-->
					<script src="js/responsiveslides.min.js"></script>
					<script>
						// You can also use "$(window).load(function() {"
						$(function() {
							// Slideshow 4
							$("#slider4")
									.responsiveSlides(
											{
												auto : true,
												pager : true,
												nav : false,
												speed : 300,
												namespace : "callbacks",
												before : function() {
													$('.events')
															.append(
																	"<li>before event fired.</li>");
												},
												after : function() {
													$('.events')
															.append(
																	"<li>after event fired.</li>");
												}
											});

						});
					</script>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- content-section-starts-here -->
	<div class="container">
		<div class="main-content">
			<div class="online-strip">
				<div class="col-md-4 follow-us">
					<h3>
						Facebook :
						<a class="facebook" href="http://www.facebook.com"></a>
					</h3>
				</div>
				<div class="col-md-4 shipping-grid">
					<div class="shipping">
						<img src="images/shipping.png" alt="" />
					</div>
					<div class="shipping-text">
						<h3>Free Shipping</h3>
						<p>When purchasing <br> more than ￦ 50,000</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-4 online-order">
					<p>Phone Num</p>
					<h3>Tel : 070 1234 5678 <br> Mobile : 010 8765 4321</h3>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="products-grid">
				<header>
					<h3 class="head text-center">N e w &nbsp; &nbsp; P r o d u c t
						s</h3>
				</header>


				<!-- 							메인 상품 new -->
				<c:choose>
					<c:when test="${empty recentProductList}">
						<div class="banner-info">
							<div class="banner-info">
								<h3 class="head text-center"> 상품이 존재하지 않습니다.</h3>
								 <h3><br><br></h3>
							</div>
						</div>
					</c:when>
					<c:otherwise>

						<c:forEach var="recentProduct" items="${recentProductList}">
							<div class="col-md-4 product simpleCart_shelfItem text-center">
								<a href="product?task=detail&title=${recentProduct.title}-${1}">
									<img
										src="images/${recentProduct.large_Category}/${recentProduct.middle_Category}/${recentProduct.title}-${1}.JPG"
										alt="" />
								</a>

								<div class="mask">
									<a href="product?task=detail&title=${recentProduct.title}-${1}">Quick
										View</a>
								</div>
								<a class="product_name"
									href="product?task=detail&title=${recentProduct.title}-${1}">${recentProduct.title}
									<br><br>
									<p>
										<span class="item_price">${recentProduct.price} ￦</span>
									</p>
								</a>
									
						
									
									
								
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>

				<div class="clearfix"></div>
			</div>
		</div>
	

	<!-- 	best상품 -->
	<div class="products-grid">
		<header>
			<h3 class="head text-center">B e s t &nbsp; &nbsp; P r o d u c t
				s</h3>
		</header>


		<!-- 							메인 상품 new -->
		<c:choose>
			<c:when test="${empty bestProductList}">
				<div class="banner-info">
					<div class="banner-info">
						<h3 class="head text-center"> 상품이 존재하지 않습니다. </h3>
					</div>
				</div>
			</c:when>
			<c:otherwise>

				<c:forEach var="bestProduct" items="${bestProductList}">
					<div class="col-md-4 product simpleCart_shelfItem text-center">
						<a href="product?task=detail&title=${bestProduct.title}-${1}">
							<img
								src="images/${bestProduct.large_Category}/${bestProduct.middle_Category}/${bestProduct.title}-${1}.JPG"
								alt="" />
						</a>

						<div class="mask">
							<a href="product?task=detail&title=${bestProduct.title}-${1}">Quick
								View</a>
						</div>
						<a class="product_name"
							href="product?task=detail&title=${bestProduct.title}-${1}">${bestProduct.title}
						<br><br>
						<p>
								</i> <span class="item_price">${bestProduct.price} ￦</span>
						</p>
						</a>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>

		<div class="clearfix"></div>
	</div>
	</div>
	<div class="clearfix"></div>

	<!-- content-section-ends-here -->
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>