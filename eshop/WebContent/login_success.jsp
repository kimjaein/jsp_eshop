<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<html>
<head>
<title>로그인 완료 페이지</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>

	<h2>${sessionScope.loginId}님 반갑습니다!!</h2>
	<a href="${myContextPath}/member">메인으로</a>
</body>
</html>