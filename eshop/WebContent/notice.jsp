<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Notice</title>
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
<link rel="stylesheet" href="css/new.css" type="text/css" />

</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<c:set var="myContextPath" 
			value="${pageContext.request.contextPath}"/>
<div class="content">
	<div class="container">	
           <section id="tables">
           <br>
            <h1 id="h1.-bootstrap-heading">Notice</h1>
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
              
              <tbody id="qnaList">
                <c:choose>	
					<c:when test="${empty articlePage.articleList}">	
						<tr>
							<td colspan="5">작성된 게시글이 존재하지 않습니다.
							</td>
						</tr>
					</c:when>
					<c:otherwise>
					<ul id="link-top">
					<c:set var="i" value="${articlePage.articleList.size()}"/>
						<c:forEach var="article" items="${articlePage.articleList}">
							<tr>
								<td>${i}</td>
								<c:set var="i" value="${i-1}"/>
								<td>
								<a class="titlelink" value="${article.list}" href="${myContextPath}/board?task=read&articleNum=${article.articleNum}&type=notice" >
										<c:if test="${article.depth.length() >1}">
											<c:forEach var="i" begin="1" end="${article.depth.length()-1}">
												&nbsp;&nbsp;
											</c:forEach>
											->
										</c:if>
									${article.title}
								</a>
							
								</td>
								<td>${article.writer}</td>
								<td>${article.writeDate}</td>
								<td>${article.readCount}</td>
							</tr>
						</c:forEach>
						</ul>
					</c:otherwise>	
				</c:choose>	
				<!-- 게시글 끝 -->
				<tr>
				<td colspan=5>
					<div>
						<ul class="pagination pagination-sm">
						<c:if test="${articlePage.startPage>1}">
							<li class="disabled">
							<a href="${myContextPath}/board?p=${articlePage.startPage-1}">
							<span aria-hidden="true"> < </span></a></li>
						</c:if>
						<c:forEach begin="${articlePage.startPage}" end="${articlePage.endPage}" var="i">
							<c:choose>	
								<c:when test="${articlePage.currentPage == i}">
									<li class="active">
								</c:when>
								<c:otherwise>
									<li>
								</c:otherwise>
							</c:choose>
							<a href="${myContextPath}/board?task=boardList&type=notice&p=${i}" > ${i} </a></li>
						</c:forEach>
						<c:if test="${articlePage.endPage<articlePage.totalPage}">
							<li class="disabled">
							<a href="${myContextPath}/board?p=${articlePage.startPage-1}">
							<span aria-hidden="true"> > </span></a></li>
						</c:if>		
						</ul>	
					</div>
				</td>
				</tr>
				<tr>
					<c:if test="${sessionScope.loginId=='admin'}">
						<a href="<%=request.getContextPath()%>/board?task=writeForm" class="acount-btn" id="write">글쓰기</a>
					</c:if>
				</tr>
             </tbody>
           </table>
        </div>
    </section>
		  </div>
		  </div>
		  <jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>
