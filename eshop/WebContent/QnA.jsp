<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Q&A</title>
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
<script>
	var loginId = <%=session.getAttribute("loginId")%>;
</script>
<script type="text/javascript">
$(function(){
	var loginId = $('#loginId').attr('value');
	var writer;
	$('.titlelink').click(function(){
		var list = $(this).attr('value');
		var url =$(this).attr('href');
		$.ajax({
			type:'post',
			url:'board?task=qnaRead&list='+list,
			dataType:'text', 
			success:function(result){
				if(loginId != result && loginId != 'admin'){
					alert("작성자만 읽을 수 있습니다.")
					return false;
				}else{
					location.href=url;
				}
			},
			error:function(){
				alert("잠시 후 다시 실행해 주시길 바랍니다.")
				return false;
			}
		})
		return false;
	})
	
	$('#write').click(function(){
		var url =$(this).attr('href');
		if(loginId == null || loginId==""){
			alert("로그인 하세요");
			return false;
		}else{
			location.href=url;
		}
		return false;
	})
	
})

</script>
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
              
              <tbody id="qnaList">
              <input type="hidden" value="${sessionScope.loginId}" id="loginId">
                <c:choose>	
					<c:when test="${empty articlePage.articleList}">	
						<tr>
							<td colspan="5">작성된 게시글이 존재하지 않습니다.
							</td>
						</tr>
					</c:when>
					<c:otherwise>
					<ul id="link-top">
						<c:forEach var="article" items="${articlePage.articleList}">
							<tr>
								<td>${article.articleNum}</td>
								<td>
								<a class="titlelink" value="${article.list}" href="${myContextPath}/board?task=read&articleNum=${article.articleNum}&type=qna" >
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
							<a href="${myContextPath}/board?task=boardList&type=qna&p=${i}" > ${i} </a></li>
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
					<td colspan =5>
						<a href="<%=request.getContextPath()%>/board?task=writeForm" class="acount-btn" id="write">글쓰기</a>
					<td>
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
