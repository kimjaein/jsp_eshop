<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!-- header-section-starts -->
	<div class="header">
		<div class="header-top-strip">
			<div class="container">
				<div class="header-top-left">
					<ul>
					<c:if test="${sessionScope.loginId == null}">
						<li><a href="account.jsp"><span class="glyphicon glyphicon-user"> </span>Login</a></li>
						<li><a href="register.jsp"><span class="glyphicon glyphicon-lock"> </span>Create an Account</a></li>			
					</c:if>
					<c:if test="${sessionScope.loginId != null}">
					<li><a href="${pageContext.request.contextPath}/member?task=logout"><span class="glyphicon glyphicon-user"> </span>Logout</a></li>
					<li><a href="mypage.jsp"><span class="glyphicon glyphicon-user"> </span>My page</a></li>
					<li><b><span style="color: white;">${sessionScope.loginId}´Ô ¹Ý°©½À´Ï´Ù</span></b></li>
					</c:if>
					</ul>
				</div>
				<div class="header-right">
						<div class="cart box_1">
							<a href="${pageContext.request.contextPath}/test?task=cart&id=${sessionScope.loginId}">
								<h3> <img src="images/bag.png" alt=""></h3>
							
							<p style="font-size: 14px; color: rgb(255, 198, 207);">Cart</p></a>	
							<div class="clearfix"> </div>
						</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!-- header-section-ends -->
			<div class="banner-top">
		<div class="container">
				<nav class="navbar navbar-default" role="navigation">
	    <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
	        </button>
				<div class="logo">
					<h1><a href="index.jsp"><span>S</span> -Shop</a></h1>
				</div>
	    </div>
	    <!--/.navbar-header-->
	
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	        <ul class="nav navbar-nav">
			<li><a href="index.jsp">Home</a></li>
		        <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Outer<b class="caret"></b></a>
		            <ul class="dropdown-menu multi-column columns-1">
			            <div>
				            <div class="col-sm-12">
					            <ul class="multi-column-dropdown">
									<h6>OUTER</h6>
						            <li><a href="product?task=middleCategory&middleList=PADDING">PADDING</a></li>
						            <li><a href="product?task=middleCategory&middleList=COAT">COAT</a></li>
						            <li><a href="product?task=middleCategory&middleList=JACKET">JACKET</a></li>
					            </ul>
				            </div>
							<div class="clearfix"></div>
			            </div>
		            </ul>
		        </li>
		        <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Top <b class="caret"></b></a>
		            <ul class="dropdown-menu multi-column columns-1">
			            <div >
				            <div class="col-sm-12">
					            <ul class="multi-column-dropdown">
									<h6>TOP</h6>
						            <li><a href="product?task=middleCategory&middleList=LONG SLEEVE">LONG SLEEVE</a></li>
						            <li><a href="product?task=middleCategory&middleList=SHORT SLEEVE">SHORT SLEEVE</a></li>
						            <li><a href="product?task=middleCategory&middleList=SLEEVELESS">SLEEVELESS</a></li>
					            </ul>
				            </div>
							<div class="clearfix"></div>
			            </div>
		            </ul>
		        </li>
		        <li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">bottom<b class="caret"></b></a>
		            <ul class="dropdown-menu multi-column columns-1">
			            <div >
				            <div class="col-sm-12">
					            <ul class="multi-column-dropdown">
									<h6>BOTTOM</h6>
						            <li><a href="product?task=middleCategory&middleList=SLACKS">SLACKS</a></li>
						            <li><a href="product?task=middleCategory&middleList=JEANS">JEANS</a></li>
						            <li><a href="product?task=middleCategory&middleList=SHORT">SHORTS</a></li>
					            </ul>
				            </div>
							<div class="clearfix"></div>
			            </div>
		            </ul>
		        </li>
					<li><a href="board?task=boardList&type=qna">Q & A</a></li>
	        </ul>
	    </div>
	    <!--/.navbar-collapse-->
	</nav>
	<!--/.navbar-->
</div>
</div>