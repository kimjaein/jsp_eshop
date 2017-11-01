<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Q&A</title>
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
$(function(){
	$('#delete').click(function(){
		if(confirm("정말 삭제 하시겠습니까?")){
			var url=$(this).attr('href');
			location.href=url;
		}else{
			return false;
		}
	})
})
</script>

</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<!-- <h4>${sessionScope.loginId}</h4> -->
	<div class="container">
		<center>
			<div class="qna">
				<section id="tables">
					<br>
					<h1 id="h1.-bootstrap-heading">
					<c:if test="${requestScope.type eq 'notice'}">
						Notice
					</c:if>
					<c:if test="${requestScope.type eq 'qna'}">
						QnA
					</c:if>
					</h1>
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
						href="<%=request.getContextPath()%>/board?task=updateForm&articleNum=${article.articleNum}">수정</a>
					<a class="acount-btn" id="delete"
						href="board?task=delete&articleNum=${article.articleNum}&writer=${article.writer}">삭제</a>
				</c:if>
				<c:if test="${sessionScope.loginId eq 'admin'}">
					<a class="acount-btn"
					href="<%=request.getContextPath()%>/board?task=replyForm&articleNum=${article.articleNum}">답변</a>
				</c:if>
				<a class="acount-btn"
					href="<%=request.getContextPath()%>/board?task=boardList&type=${requestScope.type}">목록으로</a>
			</div>
		</center>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>