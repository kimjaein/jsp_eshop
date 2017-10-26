<%@page import="java.util.List"%>
<%@page import="vo.Product"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Write something else you want</title>
<!-- Latest compiled and minified CSS -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
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
						<li><a href="product?task=largeCategory&largeList=TOP">TOP</a></li>
						<li><a href="product?task=largeCategory&largeList=BOTTOM">BOTTOM</a></li>
					</ul>
				</div>

			</div>
			<div class="new-product">
				<div class="new-product-top">
					<ul class="product-top-list">
					<%
						System.out.println(request.getAttribute("large"));
						System.out.println(request.getAttribute("middle"));
					%>
						<li><a href="index.jsp">Home</a>&nbsp;<span>&gt;</span></li>
<%-- 						<li><span class="act">${categoryList.get(0).large_Category}</span>&nbsp;</li> --%>
						<c:choose>
							<c:when test = "${type eq 'largeCategory'}">
								<li><span class="act">${categoryPage.productList.get(0).large_Category}</span>&nbsp;</li>
							</c:when>
							
							<c:otherwise>
								<li><span class="act">${categoryPage.productList.get(0).large_Category} > ${categoryPage.productList.get(0).middle_Category}</span>&nbsp;</li>
							</c:otherwise>
							
						</c:choose>
						
						
						
						
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
					     
							
					     
					     <c:forEach begin="${categoryPage.startPage}" end="${categoryPage.endPage}" var="i">
					     <c:choose>
					     	<c:when test = "${type eq 'largeCategory'}">
					   	  		<li class="active"><a href="product?task=largeCategory&p=${i}"> ${i} </a></li>
							</c:when>
							
							<c:otherwise>
								<li class="active"><a href="product?task=middleCategory&p=${i}"> ${i} </a></li>
							</c:otherwise>
							
							
						</c:choose>
							
					     </c:forEach>
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
<!-- 상품 목록 -->
					
					<ul>
					  
				<c:choose>
					<c:when test="${empty categoryPage.productList}">
						<div class="banner-info">
							<h3 class="head text-center"> 상품이 존재하지 않습니다. </h3>
						</div>
					</c:when>
					<c:otherwise>		
												
						<c:forEach var="categoryProduct" items="${categoryPage.productList}">
						
					  <li>
							<a class="cbp-vm-image" href="product?task=detail&title=${categoryProduct.title}-${1}">
							<div class="simpleCart_shelfItem">
							 <div class="view view-first">
					   		  <div class="inner_content clearfix">
								<div class="product_image">
								</div>
									<img src="images/${categoryProduct.large_Category}/${categoryProduct.middle_Category}/${categoryProduct.title}-${1}.JPG" class="img-responsive" alt=""/>
									<div class="mask">
			                       		<div class="info">Quick View</div>
					                  </div>
									<div class="product_container">
									   <div class="cart-left">
										 <p class="title">${categoryProduct.title}</p>
									   </div>
									   <div class="pricey"><span class="item_price">\ ${categoryProduct.price}</span></div>
									   <div class="clearfix"></div>
								     </div>		
								  </div>
		                     </div>
		                     </div>
							<a class="cbp-vm-icon cbp-vm-add item_add" href="#" onclick="addCart(${categoryProduct.product_num});">Add to cart</a>
							
		                    </a>
						</li>					
						</c:forEach>
					</c:otherwise>
				</c:choose>
				
					</ul>
				</div>
				
				
				
				
				<script src="js/cbpViewModeSwitch.js" type="text/javascript"></script>
                <script src="js/classie.js" type="text/javascript"></script>
			<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
			</div>

		<!-- content-section-ends-here -->
		<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>