<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>오류 페이지</title>
	<link href="/servletExample/image/icon.png" rel="icon" type="image/x-icon" />
	
	<style type="text/css">
		a{ text-decoration: none; }
	</style>
</head>
<body>
	<div>
		<% String message = (String)request.getAttribute("message"); %>
	</div>
	<div>
		<a href="/servletExample/list">리스트로 이동</a>
	</div>
</body>
</html>