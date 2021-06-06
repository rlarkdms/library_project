<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>회원탈퇴</title>
  </head>
  <body>
		<script type="text/javascript">
    		alert('<c:out value="${leave}" />');
    	</script>
    	<%
  			session.removeAttribute("id");
  		%>
  		<jsp:forward page="../index.jsp"></jsp:forward>	
  </body>
</html>
