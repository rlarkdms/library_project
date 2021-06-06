<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>도서 연장 결과</title>
  </head>
  <body>
    <div>
    	<script type="text/javascript">
    		alert('<c:out value="${extend}" />');
    		history.go(0);
    	</script>
    </div>
  </body>
</html>
