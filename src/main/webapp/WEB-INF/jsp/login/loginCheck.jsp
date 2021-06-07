<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>로그인 완료</title>
  </head>
  <body>
     <%
        String id = (String)request.getAttribute("id");
        String admin = (String)request.getAttribute("admin");
        if(id != null)
           session.setAttribute("id",  request.getAttribute("id"));
        else if(admin != null) {
           session.setAttribute("admin",  request.getAttribute("admin"));
        }
     %>
     <script type="text/javascript">
    	alert('${result}');
    	window.location.href="http://localhost:9200";
   	</script>
  </body>
</html>