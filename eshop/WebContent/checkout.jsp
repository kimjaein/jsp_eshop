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

<script type="text/javascript">
function cancelCart(num){
	var product_num = num;
	var id = "${sessionScope.loginId}";
	$.ajax({
		type:'post',
		url:'test?task=cartDel&id='+id+'&num='+product_num,
		dataType:'text', // ���䵥���� ����, ������ xml, json���� ��.
		success:function(delComplete){
			console.log('���� �Ϸ�');
			location.href="${pageContext.request.contextPath}/test?task=cart&id="+id;
		},
		error:function(){
			alert("ajax ��û�� ���޵��� ����.")
		}
	})
}
</script>
</head>
<body>
	<c:set var="sum" value="0" />

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
			<div class="cart-gd">
				<c:if test="${empty productList}">
					<h2>��ٱ��ϰ� ����ֽ��ϴ�.</h2>
				</c:if>
				<c:if test="${not empty productList}">
					<h2>���� ��ٱ��� [${cartCount}]</h2>
					<!-- ��ǰ �ϳ��� ���� -->
					<c:forEach var="list" items="${productList}" varStatus="status">
						<hr>
						<div class="cart-header1">
							<div class="cart-sec simpleCart_shelfItem">
								<div class="cart-item cyc">
									<img
										src="images/${list.large_Category}/${list.middle_Category}/${list.title}.JPG"
										class="img-responsive" alt="">
								</div>
								<div class="cart-item-info">
									<h3>
										<a href="#">��ǰ�� : ${list.title} </a>
										<a href="#" onclick="cancelCart(${list.product_num});">
											<img src="images/close_1.png" align="right">
										</a>
										<br> <br> <b>������ : ${list.size}</b><br> <br>
										<b>���� : ${list.color}</b><br> <br> <b>���� : ${cartList[status.index].cart_quantity} ��</b><br>
										<br> <b>���� : ${list.price * cartList[status.index].cart_quantity} ��
										</b><br> <br>
										<c:set var="sum"
											value="${sum + list.price * cartList[status.index].cart_quantity}" />
									</h3>
									<div class="delivery">
										<span> <b>[���� ���]</b>��� ������ 1~3��
										</span>
										<div class="clearfix"></div>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</c:forEach>
					<!-- ��ǰ �ϳ��� �� -->
					<hr>
					<h2>�����ݾ� : ${sum} ��</h2>
					<br>
					<h2>
						<a class="acount-btn"
							href="${pageContext.request.contextPath}/test?task=buy&id=${sessionScope.loginId}">�����ϱ�</a>
					</h2>

				</c:if>
			</div>
		</div>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>