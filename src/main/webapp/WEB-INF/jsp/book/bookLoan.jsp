<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>도서 대여 결과</title>
  </head>
  <body>
    <div>
    	<c:out value="${loan}" />
    </div>
    <button type="button" name="back" onclick="history.back()">뒤로가기</button>
  </body>
</html>
