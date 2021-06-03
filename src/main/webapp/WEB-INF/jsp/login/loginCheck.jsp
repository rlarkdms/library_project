<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>로그인 완료</title>
  </head>
  <body>
  	<%
  		session.setAttribute("id",  request.getAttribute("id"));
  	%>
  	<jsp:forward page="../index.jsp"></jsp:forward>
  </body>
</html>
