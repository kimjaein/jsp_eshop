<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<html>
<head>
<title>Eshop a Flat E-Commerce Bootstrap Responsive Website
	Template | Home :: w3layouts</title>
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
	<!-- <h4>${sessionScope.loginId}</h4> -->
	<div class="container">
		<center>
			<div class="qna">
				<section id="tables">
					<br>
					<h1 id="h1.-bootstrap-heading">QnA</h1>
					<br>
					<div class="bs-docs-example">
						<table class="table">
							<tr>
								<th><span class=pull-left>${article.title}</span>
								<span class=pull-right>${article.writeDate}</span>
							</tr>
							<tr>
								<td><span class=pull-left>${article.writer}</span>
								 <span class=pull-right>${article.readCount}</span></td>
							</tr>
							<tr>
								<td height=100px>${article.contents}</td>
							</tr>
							<tr>
								<td></td>
							</tr>
						</table>
					</div>
				</section>

				<c:if test="${sessionScope.loginId==article.writer}">
					<a class="acount-btn"
						href="<%=request.getContextPath()%>/board?task=updateForm&articleNum=${article.articleNum}">����</a>
					<a class="acount-btn"
						href="<%=request.getContextPath()%>/board?task=deleteForm&articleNum=${article.articleNum}">����</a>
				</c:if>
				<c:if test="${sessionScope.loginId eq 'admin'}">
					<a class="acount-btn"
					href="<%=request.getContextPath()%>/board?task=replyForm">�亯</a>
				</c:if>
				<a class="acount-btn"
					href="<%=request.getContextPath()%>/board?task=boardList">�������</a>
			</div>
		</center>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>