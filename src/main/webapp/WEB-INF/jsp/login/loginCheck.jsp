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
        System.out.print("admin check " + admin);
        if(id != null)
           session.setAttribute("id",  request.getAttribute("id"));
        else if(admin != null) {
           session.setAttribute("admin",  request.getAttribute("admin"));
           System.out.print("session setting!");
        }
     %>
     <jsp:forward page="../index.jsp"></jsp:forward>
  </body>
</html>