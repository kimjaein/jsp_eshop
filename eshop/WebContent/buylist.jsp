<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>구매 목록</title>
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
	<div class="content">

		<div class="container">
			<div class="page-header">
				<h1 style="color: #816263;">구매 목록</h1>
			</div>

			<div class="bs-docs-example">
				<table class="table table-striped">
					<thead>
						<tr>
							<!-- forEach 로 List로 출력[등록일로 group by 되어있음]
						아무거나 클릭시 해당 정보 가지고 구매목록 DB에서 그룹 풀고 구매목록 상세 페이지에 보여줌 -->
							<th>번호</th>
							<th>구매일자</th>
							<th>상품명</th>
							<th>구매수량</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty buylist}">
							<c:forEach var="list" items="${buylist}">
								<tr>
									<td>${list.buy_list_num}</td>
									<td>${list.buy_date}</td>
									<td><a href="${pageContext.request.contextPath}/product?task=detail&title=${list.product_title}">${list.product_title}</a></td>
									<td>${list.buy_quantity}</td>
								</tr>
							</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="4">구매목록이 없습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>