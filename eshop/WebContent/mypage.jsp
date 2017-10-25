<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>MyPage</title>
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
<center>
		<div class="clearfix"></div>
		<p><br></p>
		<h2>����������</h2>
		<div class="registration-grids">
			<div class="reg-form">
				<div class="reg">
					<h2>${sessionScope.loginId}�� �ݰ����ϴ�.</h2>
				���Ը��� ������ / �پ��� ���������� �Ѵ��� �� �� �ִ� �����Դϴ�.

				<hr>
				<!-- �α��� �ɶ� session attribute�� ���� loginId -->
				<!-- setattribute �� ȸ���� ���� �����ͼ� ���̵�� ��ġ�ϸ� ������� -->
				<%--<c:if test="${SessionScope.loginId != null}"> --%>
				<%--<a class="acount-btn" onclick="memberCheck(${loginId},${SessionScope.loginId});">��������</a> <a --%>
				<a class="acount-btn" href="${pageContext.request.contextPath}/test?task=editaccount">��������</a>
				<a class="acount-btn" href="buylist.jsp">���ų���</a>
				<a class="acount-btn" href="checkout.jsp">��ٱ���</a>
				<a class="acount-btn" href="deleteaccount.jsp">ȸ��Ż��</a>
				<%-- 				</c:if> --%>
				<%-- 				<c:if test="${SessionScope.loginId == null}"> --%>
				<a class="acount-btn" href="account.jsp">�α���</a>
				<%-- 				</c:if> --%>

				</div>
			</div>
		</div>
	</center>
	<div class="clearfix"></div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>