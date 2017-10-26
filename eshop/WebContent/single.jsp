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
<title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Single :: w3layouts</title>
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
		<!-- content-section-starts -->
	<div class="container">
	   <div class="products-page">
			<div class="products">
				<div class="product-listy">
					<h2>our Products</h2>
					<ul class="product-list">
						<li><a href="">OUTER</a></li>
						<li><a href="">TOP</a></li>
						<li><a href="">BOTTOM</a></li>
					</ul>
				</div>


			</div>
			<div class="new-product">
				<div class="col-md-5 zoom-grid">
					<div class="flexslider">
						<ul class="slides">
							<c:forEach var="i" begin="1" end="3">
							
							
							<li data-thumb="images/${singleProduct.large_Category}/${singleProduct.middle_Category}/${singleProduct.title}-${i}.JPG">
								<div class="thumb-image"> <img src="images/${singleProduct.large_Category}/${singleProduct.middle_Category}/${singleProduct.title}-${i}.JPG" data-imagezoom="true" class="img-responsive" alt="" /> </div>
							</li>		
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col-md-7 dress-info">
					<div class="dress-name">
						<h3>${singleProduct.title}</h3>
						<span>${singleProduct.price}원</span>
						<div class="clearfix"></div>
					</div>
					<div class="span span3">
						<p class="left">COLOR</p>
						<p class="right">${singleProduct.color}</p>
						<div class="clearfix"></div>
					</div>
					<div class="span span4">
						<p class="left">SIZE</p>
						<p class="right">
						<span class="selection-box">
						<select class="domains valid" name="domains">
										   <option>S</option>
										   <option>M</option>
										   <option>L</option>
										   <option>XL</option>
						</select>
						</span></p>
						<div class="clearfix"></div>
					</div>
					<div class="purchase">
						<a href="#">Buy</a>
						<div class="social-icons">
							<ul>
								<li><a class="facebook1" href="#"></a></li>
								<li><a class="googleplus1" href="#"></a></li>
							</ul>
						</div>
						<div class="clearfix"></div>
					</div>
				<script src="js/imagezoom.js"></script>
					<!-- FlexSlider -->
					<script defer src="js/jquery.flexslider.js"></script>
					<script>
						// Can also be used with $(document).ready()
						$(window).load(function() {
						  $('.flexslider').flexslider({
							animation: "slide",
							controlNav: "thumbnails"
						  });
						});
					</script>
				</div>
				<div class="clearfix"></div>
					<div class="reviews-tabs">
      <!-- Main component for a primary marketing message or call to action -->
      <ul class="nav nav-tabs responsive hidden-xs hidden-sm" id="myTab">
        <li class="test-class active"><a class="deco-none misc-class" href="#how-to"> More Information</a></li>
        <li class="test-class"><a href="#features">Specifications</a></li>
        <li class="test-class"><a class="deco-none" href="#source">Reviews (7)</a></li>
      </ul>

      <div class="tab-content responsive hidden-xs hidden-sm">
        <div class="tab-pane active" id="how-to">
		 <p class="tab-text">여기에 추가정보 작성</p>    
        </div>
        <div class="tab-pane" id="features">
		  <p class="tab-text"> 여기에 상세정보</p>
		</div>
		<div class="tab-pane" id="source">
		  <div class="response">
						<div class="media response-info">
							<div class="media-left response-text-left">
								<h5><a href="#">Username</a></h5>
							</div>
							<div class="media-body response-text-right">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,There are many variations of passages of Lorem Ipsum available, 
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
								<ul>
									<li>MARCH 21, 2015</li>
									<li><a href="single.html">Reply</a></li>
								</ul>
							</div>
							<div class="clearfix"> </div>
						</div>
						

						<div class="media response-info">
							<div class="media-left response-text-left">
								<h5><a href="#">${sessionScope.loginId}UserName</a></h5>
							</div>
							<div class="media-body response-text-right">
								<ul>
								<form action="comment" method="post">
									<input type="hidden" name="writer" value="${sessionScope.loginId}">
									<input type="hidden" name="articleNum" value="${article.articleNum}">
										<li><textarea rows="5" cols="50" name="contents" placeholder="리뷰를 입력하세요." class="form-control"></textarea></li>
										<li><input type="submit" value="리뷰달기" class="acount-btn"></li>
								</form>
								</ul>
							</div>
						</div>
					
					</div>
        </div>
 	</div>

			</div>
			<div class="clearfix"></div>
			</div>
   </div>
   <!-- content-section-ends -->
		<jsp:include page="bottom.jsp"></jsp:include>
 <script src="js/responsive-tabs.js"></script>
    <script type="text/javascript">
      $( '#myTab a' ).click( function ( e ) {
        e.preventDefault();
        $( this ).tab( 'show' );
      } );

      $( '#moreTabs a' ).click( function ( e ) {
        e.preventDefault();
        $( this ).tab( 'show' );
      } );

      ( function( $ ) {
          // Test for making sure event are maintained
          $( '.js-alert-test' ).click( function () {
            alert( 'Button Clicked: Event was maintained' );
          } );
          fakewaffle.responsiveTabs( [ 'xs', 'sm' ] );
      } )( jQuery );

    </script>

</body>
</html>