<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
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
	<div class="container">
		<center>
			<div class="qna">

				<table class="table table-bordered ">
					<thead>
						<br>
						<h1 id="h1.-bootstrap-heading">QnA</h1>
						<br>

					</thead>
						<form action="<%=request.getContextPath()%>/board" method="post">
					<tbody>
							<input type="hidden" name="writer" value="wodls" /><!-- session.loginId 받아오기 -->
							<input type="hidden" name=task value="write" />
							<input type="hidden" name=type value="qna" />
						<tr>
							<td>제목:</td>
							<td><input type="text" placeholder="제목을 입력하세요. "
								name="title" class="form-control" /></td>
						</tr>
						<tr>
							<td>내용:</td>
							<td><textarea cols="10" rows=20 placeholder="내용을 입력하세요. "
									name="contents" class="form-control"></textarea></td>
						</tr>

						<tr>
							<td colspan="2">
								<ol class="breadcrumb">
									<li><input type="submit" value="등록" class="acount-btn"/></li>
									<li><input type="reset" value="reset" class="acount-btn"/></li>
									<li><a href="board?task=boardList&type=qna"  class="acount-btn">목록으로</a></li>
								</ol>

							</td>
						</tr>
					</tbody>
						</form>
				</table>
			</div>
		</center>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>


