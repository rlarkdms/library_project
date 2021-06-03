<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>로그아웃 완료</title>
  </head>
  <body>
  	<%
  		session.removeAttribute("id");
  	%>
  	<jsp:forward page="../index.jsp"></jsp:forward>
  </body>
</html>
