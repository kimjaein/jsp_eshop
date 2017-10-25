<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
!DOCTYPE html>
<html>
<head>
<title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Home :: w3layouts</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
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
	<!-- <h4>${sessionScope.loginId}</h4> -->
	 <section id="tables">
	<br>
            <h1 id="h1.-bootstrap-heading">QnA</h1>
			<br>
	 <div class="bs-docs-example">
	<table class="table">
		<tr>
			<td><span text-align=left>${article.title}</span><span text-align=right>${article.writeDate}</span></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${article.writer}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${article.readCount}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${article.contents}</td>
		</tr>
	</table>
	</div>
	</section>
	
	<c:if test="${sessionScope.loginId==article.writer}">
	<a
		href="<%=request.getContextPath()%>/board?task=updateForm&articleNum=${article.articleNum}">수정하기</a>
	<a
		href="<%=request.getContextPath()%>/board?task=deleteForm&articleNum=${article.articleNum}">삭제하기</a>
	</c:if>
	<a href="<%=request.getContextPath()%>/board?task=boardList">게시글
		목록으로</a>
		<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>