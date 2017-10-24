<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:set var="myContextPath" 
			value="${pageContext.request.contextPath}"/>
<div class="content">
	<div class="container">	
           <section id="tables">
           <br>
            <h1 id="h1.-bootstrap-heading">QnA</h1>
			<br>
          
          <div class="bs-docs-example">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>작성일</th>
                  <th>조회</th>
                </tr>
              </thead>
              <!-- 게시글 부분 -->
              
              <tbody>
                <c:choose>	
		<c:when test="${empty articlePage.articleList}">	
			<tr>
				<td colspan="5">
					작성된 게시글이 존재하지 않습니다.
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="article" items="${articlePage.articleList}">
				<tr>
					<td>${article.articleNum}</td>
					<td>
						<a href="${myContextPath}/board?task=read&articleNum=${article.articleNum}">
						<c:if test="${article.b_level.length() >1}">
							<c:forEach var="i" begin="1" end="${article.b_level.length()-1}">
							&nbsp;
							</c:forEach>
							->
						</c:if>
						${article.title}
						</a>
					</td>
					<td>${article.writer}</td>
					<td><fmt:formatDate 	value="${article.writeDate}" type="both"
								dateStyle="short" timeStyle="short"/></td>
					<td>${article.readCount}</td>
				</tr>
			</c:forEach>
		</c:otherwise>	
	</c:choose>	
              </tbody>
            </table>
          </div>
          
		  
		  </section>
		  </div>
		  </div>
		  <jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>
