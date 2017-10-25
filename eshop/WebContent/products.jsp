<%@page import="vo.Product"%>
<%@page import="vo.ProductList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
<%
	ProductList productList = (ProductList) request.getAttribute("productList");
%>
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
				<div class="new-product-top">
					<ul class="product-top-list">
						<li><a href="index.jsp">Home</a>&nbsp;<span>&gt;</span></li>
						<li><span class="act">Best Sales</span>&nbsp;</li>
					</ul>
					<p class="back"><a href="index.jsp">Back to Previous</a></p>
					<div class="clearfix"></div>
				</div>
				<div class="mens-toolbar">
                 <div class="sort">
               	   <div class="sort-by">
			            <label>Sort By</label>
			            <select>
			                            <option value="">
			                    Name                </option>
			                            <option value="">
			                    Price                </option>
			            </select>
			            <a href=""><img src="images/arrow2.gif" alt="" class="v-middle"></a>
	                   </div>
	    		     </div>
		    	        <ul class="women_pagenation">
					     <li>Page:</li>
					     <li class="active"><a href="#">1</a></li>
					     <li><a href="#">2</a></li>
				  	    </ul>
	               		 <div class="clearfix"></div>		
			        </div>
			        <div id="cbp-vm" class="cbp-vm-switcher cbp-vm-view-grid">
					<div class="cbp-vm-options">
						<a href="#" class="cbp-vm-icon cbp-vm-grid cbp-vm-selected" data-view="cbp-vm-view-grid" title="grid">Grid View</a>
						<a href="#" class="cbp-vm-icon cbp-vm-list" data-view="cbp-vm-view-list" title="list">List View</a>
					</div>
					<div class="pages">   
       	   </div>
       	   
					<div class="clearfix"></div>
					<ul>
					  <li>
							<a class="cbp-vm-image" href="single.jsp">
								<div class="simpleCart_shelfItem">
							 <div class="view view-first">
					   		  <div class="inner_content clearfix">
								<div class="product_image">
									<img src="images/coat/coat1-1.JPG" class="img-responsive" alt=""/>
									<div class="mask">
			                       		<div class="info">Quick View</div>
					                  </div>
									<div class="product_container">
									   <div class="cart-left">
										 <p class="title">coat1</p>
									   </div>
									   <div class="pricey"><span class="item_price">50000</span></div>
									   <div class="clearfix"></div>
								     </div>		
								  </div>
			                     </div>
		                      </div>
		                    </a>
							<a class="cbp-vm-icon cbp-vm-add item_add" href="#">Add to cart</a>
							</div>
						</li>
						
<!-- 						여기서부터 똑같은 상품목록 -->
						
						<li>
							<a class="cbp-vm-image" href="single.jsp">
								<div class="simpleCart_shelfItem">
							  <div class="view view-first">
					   		  <div class="inner_content clearfix">
								<div class="product_image">
									<img src="images/p2.jpg" class="img-responsive" alt=""/>
									<div class="mask">
			                       		<div class="info">Quick View</div>
					                  </div>
									<div class="product_container">
									   <div class="cart-left">
										 <p class="title">Great Explorer</p>
									   </div>
									   <div class="pricey"><span class="item_price">$189.00</span></div>
									   <div class="clearfix"></div>
								     </div>		
								  </div>
			                     </div>
		                      </div>
							 </a>
							<a class="cbp-vm-icon cbp-vm-add item_add" href="#">Add to cart</a>
							</div>
						</li>
						<li>
							<a class="cbp-vm-image" href="single.jsp">
								<div class="simpleCart_shelfItem">
								<div class="view view-first">
					   		  <div class="inner_content clearfix">
								<div class="product_image">
									<img src="images/p3.jpg" class="img-responsive" alt=""/>
									<div class="mask">
			                       		<div class="info">Quick View</div>
					                  </div>
									<div class="product_container">
									   <div class="cart-left">
										 <p class="title">Similique Sunt</p>
									   </div>
									   <div class="pricey"><span class="item_price">$699.00</span></div>
									   <div class="clearfix"></div>
								     </div>		
								  </div>
			                     </div>
		                      </div>
							</a>
							<a class="cbp-vm-icon cbp-vm-add item_add" href="#">Add to cart</a>
							</div>
						</li>
						<li>
							<a class="cbp-vm-image" href="single.jsp">
								<div class="simpleCart_shelfItem">
								<div class="view view-first">
					   		  <div class="inner_content clearfix">
								<div class="product_image">
									<img src="images/p4.jpg" class="img-responsive" alt=""/>
									<div class="mask">
			                       		<div class="info">Quick View</div>
					                  </div>
									<div class="product_container">
									   <div class="cart-left">
										 <p class="title">Shrinking</p>
									   </div>
									   <div class="pricey"><span class="item_price">$599.00</span></div>
									   <div class="clearfix"></div>
								     </div>		
								  </div>
			                     </div>
		                      </div>
							</a>
							<a class="cbp-vm-icon cbp-vm-add item_add" href="#">Add to cart</a>
							</div>
						</li>
						<li>
							<a class="cbp-vm-image" href="single.jsp">
								<div class="simpleCart_shelfItem">
								<div class="view view-first">
					   		  <div class="inner_content clearfix">
								<div class="product_image">
									<img src="images/p5.jpg" class="img-responsive" alt=""/>
									<div class="mask">
			                       		<div class="info">Quick View</div>
					                  </div>
									<div class="product_container">
									   <div class="cart-left">
										 <p class="title">Perfectly Simple</p>
									   </div>
									   <div class="pricey"><span class="item_price">$459.00</span></div>
									   <div class="clearfix"></div>
								     </div>		
								  </div>
			                     </div>
		                      </div>
							</a>
							<a class="cbp-vm-icon cbp-vm-add item_add" href="#">Add to cart</a>
							</div>
						</li>
						<li>
							<a class="cbp-vm-image" href="single.jsp">
								<div class="simpleCart_shelfItem">
								<div class="view view-first">
					   		  <div class="inner_content clearfix">
								<div class="product_image">
									<img src="images/p6.jpg" class="img-responsive" alt=""/>
									<div class="mask">
			                       		<div class="info">Quick View</div>
					                  </div>
									<div class="product_container">
									   <div class="cart-left">
										 <p class="title">Equal Blame</p>
									   </div>
									   <div class="pricey"><span class="item_price">$119.00</span></div>
									   <div class="clearfix"></div>
								     </div>		
								  </div>
			                     </div>
		                      </div>
							</a>
							<a class="cbp-vm-icon cbp-vm-add item_add" href="#">Add to cart</a>
							</div>
						</li>
					</ul>
				</div>
				
				<script src="js/cbpViewModeSwitch.js" type="text/javascript"></script>
                <script src="js/classie.js" type="text/javascript"></script>
			</div>
			<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
   </div>

		<!-- content-section-ends-here -->
		<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>