<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<html>
<head>
<title>�α��� �Ϸ� ������</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>

	<h2>${sessionScope.loginId}�� �ݰ����ϴ�!!</h2>
	<a href="${myContextPath}/board">�Խ��� �����ϱ�</a>
	
	<a href="${myContextPath}/">
		ó�� ȭ������
	</a>
</body>
</html>