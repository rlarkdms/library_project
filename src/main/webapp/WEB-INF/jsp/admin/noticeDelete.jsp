<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>도서 삭제 결과</title>
  </head>
  <body>
    <div>
    	<script type="text/javascript">
    		alert('<c:out value="${result}" />');
    		window.location.href="http://localhost:9200/admin/adminPage?admin_id=<c:out value="${admin_id}" />";
    	</script>
    </div>
  </body>
</html>
