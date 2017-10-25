<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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


