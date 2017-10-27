<%@page import="java.util.List"%>
<%@page import="vo.Product"%>
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
<title>Products</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/component.css" rel='stylesheet' type='text/css' />
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
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<script src="js/cbpViewModeSwitch.js" type="text/javascript"></script>
<script src="js/classie.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#selectimg').click(function(){
			var select = $('#selectBox option:selected').text()
			var url = $(this).attr('href')+select;
				
			location.href = url;
			
			alert(url);
			
		})
	})
</script>
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
						<li><a href="product?task=largeCategory&largeList=OUTER">OUTER</a></li>
						<li><a href="product?task=middleCategory&middleList=COAT">&nbsp;>&nbsp;
								COAT</a></li>
						<li><a href="product?task=middleCategory&middleList=PADDING">&nbsp;>&nbsp;
								PADDING</a></li>
						<li><a href="product?task=middleCategory&middleList=JACKET">&nbsp;>&nbsp;
								JACKET</a></li>

						<li><a href="product?task=largeCategory&largeList=TOP">TOP</a></li>
						<li><a
								href="product?task=middleCategory&middleList=LONG SLEEVE">&nbsp;>&nbsp;
								LONG SLEEVE</a></li>
						<li><a
								href="product?task=middleCategory&middleList=SHORT SLEEVE">&nbsp;>&nbsp;
								SHORT SLEEVE</a></li>
						<li><a
								href="product?task=middleCategory&middleList=SLEEVELESS">&nbsp;>&nbsp;
								SLEEVELESS</a></li>

						<li><a href="product?task=largeCategory&largeList=BOTTOM">BOTTOM</a></li>
						<li><a href="product?task=middleCategory&middleList=SLACKS">&nbsp;>&nbsp;
								SLACKS</a></li>
						<li><a href="product?task=middleCategory&middleList=JEANS">&nbsp;>&nbsp;
								JEANS</a></li>
						<li><a href="product?task=middleCategory&middleList=SHORT">&nbsp;>&nbsp;
								SHORT</a></li>
					</ul>
				</div>

			</div>
			<div class="new-product">
				<div class="new-product-top">
					<ul class="product-top-list">
						<li><a href="index.jsp">Home</a>&nbsp;<span>&gt;</span></li>
						<%-- 					<li><span class="act">${categoryList.get(0).large_Category}</span>&nbsp;</li> --%>

						<c:choose>

							<c:when test="${empty categoryPage.productList}">
							</c:when>

							<c:otherwise>
								<c:choose>
									<c:when test="${type eq 'largeCategory'}">
										<li><span class="act">${categoryPage.productList.get(0).large_Category}</span>&nbsp;</li>
									</c:when>
									<c:otherwise>
										<li><span class="act">${categoryPage.productList.get(0).large_Category}
												> ${categoryPage.productList.get(0).middle_Category}</span>&nbsp;</li>
									</c:otherwise>
								</c:choose>
							</c:otherwise>



						</c:choose>
					</ul>
					<p class="back">
						<a href="index.jsp">Back to Previous</a>
					</p>
					<div class="clearfix"></div>
				</div>
				<div class="mens-toolbar">
<<<<<<< HEAD
					<div class="sort">
						<div class="sort-by">
							<label>Sort By</label> <select>
								<option value="recent">Recent</option>
								<option value="name">Name</option>
								<option value="price">Price</option>
							</select>
							<a href="">
								<img src="images/find.png" alt="" class="v-middle">
							</a>
						</div>
					</div>
					<ul class="women_pagenation">
=======
                	<div class="sort">
               	 		<div class="sort-by">
			            	<label>Sort By</label>
			            	<select id="selectBox">
			            		<option value="recent">DATE</option>
			                	<option value="name">TITLE</option>
			                    <option value="price">PRICE</option>
			           		</select>
<!-- 			           		정렬 -->
							<c:choose>
							
									<c:when test = "${type eq 'largeCategory'}">
			            				<a href="product?task=largeCategory&p=${categoryPage.currentPage}&largeList=${categoryPage.productList.get(0).large_Category}&option=" id="selectimg"><img src="images/find.png" alt="" class="v-middle"></a>
									</c:when>		
							
									<c:otherwise>
			            				<a href="product?task=middleCategory&p=${categoryPage.currentPage}&middleList=${categoryPage.productList.get(0).middle_Category}&option=" id="selectimg"><img src="images/find.png" alt="" class="v-middle"></a>
									</c:otherwise>					
							</c:choose>
							
	                   </div>
	    		    </div>
		    	    <ul class="women_pagenation">
>>>>>>> 9b382293e844cdc701665ab06b2826aa3fe1c4c9
						<li>Page:</li>

						<c:choose>
							<c:when test="${empty categoryPage.productList}">
							</c:when>
							<c:otherwise>

								<c:forEach begin="${categoryPage.startPage}"
									end="${categoryPage.endPage}" var="i">
									<c:choose>
										<c:when test="${type eq 'largeCategory'}">
											<li class="active"><a
													href="product?task=largeCategory&p=${i}&largeList=${categoryPage.productList.get(0).large_Category}">
													${i} </a></li>
										</c:when>
										<c:otherwise>
											<li class="active"><a
													href="product?task=middleCategory&p=${i}&middleList=${categoryPage.productList.get(0).middle_Category}">
													${i} </a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:otherwise>
						</c:choose>


					</ul>
					<div class="clearfix"></div>
				</div>
				<div id="cbp-vm" class="cbp-vm-switcher cbp-vm-view-grid">
					<div class="cbp-vm-options">
						<a href="#" class="cbp-vm-icon cbp-vm-grid cbp-vm-selected"
							data-view="cbp-vm-view-grid" title="grid">Grid View</a>
						<!-- 						<a href="#" class="cbp-vm-icon cbp-vm-list" data-view="cbp-vm-view-list" title="list">List View</a> -->
					</div>
					<div class="pages"></div>
					<div class="clearfix"></div>
					<ul>
						<c:choose>
							<c:when test="${empty categoryPage.productList}">
								<div class="banner-info">
									<h3 class="head text-center">상품이 존재하지 않습니다.</h3>
								</div>
							</c:when>
							<c:otherwise>

								<c:forEach var="categoryProduct"
									items="${categoryPage.productList}">

									<li><a class="cbp-vm-image"
											href="product?task=detail&title=${categoryProduct.title}-${1}">
											<div class="simpleCart_shelfItem">
												<div class="view view-first">
													<div class="inner_content clearfix">
														<div class="product_image"></div>
														<img
															src="images/${categoryProduct.large_Category}/${categoryProduct.middle_Category}/${categoryProduct.title}-${1}.JPG"
															class="img-responsive" alt="" />
														<div class="mask">
															<div class="info">Quick View</div>
														</div>
														<div class="product_container">
															<div class="cart-left">
																<p class="title">${categoryProduct.title}</p>
															</div>
															<div class="pricey">
																<span class="item_price">\
																	${categoryProduct.price}</span>
															</div>
															<div class="clearfix"></div>
														</div>
													</div>
												</div>
											</div>
										</a> <%-- 									<a class="cbp-vm-icon cbp-vm-add item_add" href="#" onclick="addCart(${categoryProduct.product_num});">Add to cart</a> --%>
									</li>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
		<!-- content-section-ends-here -->
		<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>