<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>회원가입 결과</title>
  </head>
  <body>
    <div>
    	<script type="text/javascript">
    		console.log("<c:out value="${result}" />");
    		alert('<c:out value="${result}" />');
    		window.location.href="http://localhost:9200" />";
    	</script>
    </div>
  </body>
</html>
