<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<title>�α��� ����</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
	<h2>�α��� �����Ͽ����ϴ�.</h2>
	<a href="${myContextPath}/member?task=loginForm">
		�α��� ȭ������
	</a>
	
	<a href="${myContextPath}/">
		ó�� ȭ������
	</a>
</body>
</html>