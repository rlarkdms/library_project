<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>회원탈퇴</title>
  </head>
  <body>
      	<%
  			session.removeAttribute("id");
  		%>
		<script type="text/javascript">
    		alert('${leave}');
    		window.location.href="http://localhost:9200";
    	</script>
  </body>
</html>
