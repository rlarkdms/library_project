<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>로그인 완료</title>
  </head>
  <body>
  	<%
  		String id = request.getParameter("id");
  		System.out.println(id);
  		session.setAttribute("id", id);
  	%>
  	<jsp:forward page="../index.jsp"></jsp:forward>
  </body>
</html>
