<%@page import="vo.Product"%>
<%@page import="vo.ProductList"%>

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
<title>Home</title>
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
	<div class="banner">
		<div class="container">
			<div class="banner-bottom">
				<div class="banner-bottom-right">
					<div class="callbacks_container">
						<ul class="rslides" id="slider4">
							<li>
								<div class="banner-info">
									<h3>첫번째 배너</h3>
									<p>공지사항1</p>
								</div>
							</li>
							<li>
								<div class="banner-info">
									<h3>두번째 배너</h3>
									<p>공지사항2</p>
								</div>
							</li>
							<li>
								<div class="banner-info">
									<h3>세번째 배너</h3>
									<p>Start your shopping here...</p>
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
												speed : 500,
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
						Facebook : <a class="facebook" href="#"></a>
					</h3>
				</div>
				<div class="col-md-4 shipping-grid">
					<div class="shipping">
						<img src="images/shipping.png" alt="" />
					</div>
					<div class="shipping-text">
						<h3>무료배송</h3>
						<p>50,000원 이상 구입시</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-4 online-order">
					<p>Phone Num</p>
					<h3>Tel : 000 0000 0000</h3>
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
					<c:when test="${empty ProductList}">
						<div class="banner-info">
							<h3>상품이 존재하지 않습니다.</h3>
						</div>
					</c:when>
					<c:otherwise>
									<%
										String path = "images/${product.large_Category}/${product.middle_Category}/${product.title}.JPG";
									%>
						<c:forEach var="product" items="${ProductList}">
							<div class="col-md-4 product simpleCart_shelfItem text-center">
								<a href="single.jsp"><img src="path" alt="" /></a>
				
								<div class="mask">

									<a href="single.jsp">Quick View</a>
								</div>
								<a class="product_name" href="single.jsp">${product.title}</a>
								<p>
									<a class="item_add" href="#"><i></i> <span
										class="item_price">${product.price}</span></a>
								</p>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>

				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<!-- 	best상품 -->
						<h3 class="like text-center">B e s t &nbsp; &nbsp; P r o d u c t s</h3>
	<c:choose>
		<c:when test="${empty ProductList}">
			<div class="banner-info">
				<h3>상품이 존재하지 않습니다.</h3>
			</div>
		</c:when>
		<c:otherwise>
				<div class="other-products">
			<c:forEach var="product" items="${ProductList}">
					<div class="container">
						<ul id="flexiselDemo3">
							<li><a href="single.jsp"><img src="images/${product.large_Category}/${product.middle_Category}/${product.title}.JPG" class="img-responsive" alt="" /></a>
								<div class="product liked-product simpleCart_shelfItem">
									<a class="like_name" href="single.jsp">${product.title}</a>
									<p><a class="item_add" href="#"><i></i> <span class=" item_price">${product.price}</span></a></p>
								</div>								
							</li>
					</div>
			</c:forEach>
				</div>
		</c:otherwise>
	</c:choose>
	<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo3").flexisel({
				visibleItems : 4,
				animationSpeed : 1000,
				autoPlay : true,
				autoPlaySpeed : 3000,
				pauseOnHover : true,
				enableResponsiveBreakpoints : true,
				responsiveBreakpoints : {
					portrait : {
						changePoint : 480,
						visibleItems : 1
					},
					landscape : {
						changePoint : 640,
						visibleItems : 2
					},
					tablet : {
						changePoint : 768,
						visibleItems : 3
					}
				}
			});

		});
	</script>
	</ul>
	<script type="text/javascript" src="js/jquery.flexisel.js"></script>
	</div>
	<!-- content-section-ends-here -->
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>