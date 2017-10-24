<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<title>로그인 실패</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
	<h2>로그인 실패하였습니다.</h2>
	<a href="${myContextPath}/member?task=loginForm">
		로그인 화면으로
	</a>
	
	<a href="${myContextPath}/">
		처음 화면으로
	</a>
</body>
</html>