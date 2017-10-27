<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>결제 화면</title>
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
<script type="text/javascript">
	function cancelCart(num) {
		var product_num = num;
		var id = "${sessionScope.loginId}";
		$
				.ajax({
					type : 'post',
					url : 'test?task=cartDel&id=' + id + '&num=' + product_num,
					dataType : 'text', // 응답데이터 형식, 보통은 xml, json으로 옴.
					success : function(delComplete) {
						console.log('삭제 완료');
						location.href = "${pageContext.request.contextPath}/test?task=buy&id="
								+ id;
					},
					error : function() {
						alert("ajax 요청이 전달되지 못함.")
					}
				})
	}
</script>
</head>
<body>
	<jsp:include page="top.jsp" />
	<c:set var="sum" value="0" />
	<div class="content">
		<div class="container">
			<div class="page-header">
				<h1 style="color: #816263;">결제 화면</h1>
			</div>

			<div class="bs-docs-example">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>상품명</th>
							<th>사이즈</th>
							<th>색상</th>
							<th>수량</th>
							<th>가격</th>
							<th>취소</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${cartList}" varStatus="status">
							<tr>
							<td>${list.title}</td>
							<td>${list.size }</td>
							<td>${list.color }</td>
							<td>${quantityList[status.index].cart_quantity}</td>
							<td>${list.price *quantityList[status.index].cart_quantity}</td>
							<c:set var="sum" value="${sum + list.price * quantityList[status.index].cart_quantity}"></c:set>
							<td><a href="#"
										onclick="cancelCart(${list.product_num});">
										<img src="images/close_1.png" align="middle">
									</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<h4>5만원 이상 구매시 무료배송</h4>
				<c:if test="${sum >= 200000}">
				<h4>20만원 이상 구매하여 10% <font style="color: white; background-color: rgb(129,98,99); ">${sum * 0.1}</font>원 할인 되었습니다.</h4>
				<c:set var="sum" value="${sum * 0.9}"/>
				</c:if>
				<c:if test="${sum < 200000}">
				<h4>20만원 이상 구매시 10% 할인됩니다</h4>
				</c:if>
				<c:if test="${sum < 50000 }">
				<c:set var="sum" value="${sum + 2500}"/>
				</c:if>
				<h3><b>${sessionScope.loginId}</b>님 총 결제금액은 <font style="color: white; background-color: rgb(129,98,99); ">${sum}</font>원 입니다.</h3>
				<center>
					<a class="acount-btn"
						href="${pageContext.request.contextPath}/test?task=payment&id=${sessionScope.loginId}">결제하기</a>
				</center>
			</div>
		</div>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>