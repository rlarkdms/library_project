<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>로그아웃 완료</title>
  </head>
  <body>
  	<%
		String id = (String)session.getAttribute("id");
		String admin = (String)session.getAttribute("admin");
  	    
		if(id != null) session.removeAttribute("id");
		else if(admin != null) session.removeAttribute("admin");
  	%>
  	<jsp:forward page="../index.jsp"></jsp:forward>
  </body>
</html>
