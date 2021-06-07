<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<HTML>
  <HEAD>
    <TITLE>도서 검색</TITLE>
    <style>
      body {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        background-color: whitesmoke;
        width: 100%;
        margin: 0;
      }
      .white {
        width: 50%;
        background-color: white;
        box-sizing: border-box;
        height: 100vh;
      }
      header {
        padding: 30px;
        display: flex;
        align-items: center;
        justify-content: space-between;
      }
      a {
        text-decoration: none;
        color: black;
      }
      .search,
      .goHome,
      .login,
      .signup {
        font-size: 17px;
        font-weight: bold;
      }
      .login {
        margin: 0 10px;
      }
      input[type="text"] {
        padding: 5px;
        border-radius: 10px;
        width: 250px;
        outline: none;
      }
      input[type="submit"] {
        padding: 5px 10px;
        background-color: #ff6d00;
        color: white;
        border: none;
        cursor: pointer;
      }
      label {
        font-size: 20px;
      }
      .background {
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        background-image: url(https://images.unsplash.com/photo-1562932831-afcfe48b5786?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NzR8fGxpYnJhcnl8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60);
        width: 100%;
        height: 300px;
        opacity: 0.7;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
      }
      .title {
        font-size: 50px;
        font-weight: bold;
        color: #ff6d00;
        margin: 20px 0;
      }
      footer {
        position: absolute;
        bottom: 0%;
        width: 50%;
        padding: 30px 0;
        display: flex;
        align-items: center;
        justify-content: center;
        border-top: 1px solid lightgray;
      }
      .searchedTerm {
        margin: 20px 0;
        margin-left: 30px;
        font-size: 20px;
        font-weight: bold;
      }
      table {
        margin: 0 auto;
        width: 80%;
        font-size: 18px;
      }
      th,
      td {
        padding: 5px;
      }
      th {
      	border-top : 1px solid black;
      	border-bottom: 1px solid black;
      }
    </style>
  </HEAD>
  <body>
    <div class="white">
      <header>
        <form action="searchBook" method="POST" class="search">
          <label style="display: block">
            🔎
            <input type="text" name="keyword" />
            <input type="submit" value="검색" />
          </label>
        </form>
        <div class="user">
          <span class="goHome">
            <a href="../">홈으로</a>
          </span>
 			<%
        	String id = (String)session.getAttribute("id");
        	String admin = (String)session.getAttribute("admin");
        	if(id == null && admin==null) { %>
		        <span class="login">
		          <a href="../login/login">로그인</a>
		        </span>
		        <span class="signup">
		          <a href="../register/step2">회원가입</a>
		        </span> <%
	        } else if(admin != null &&id==null) { %> 
 	        	<span class="login">
		          <a href="../admin/adminPage?member_id=<%out.print(admin);%>">관리자페이지</a>
		        </span>
		        <span class="signup">
		          <a href="../login/logout">로그아웃</a>
		        </span> <%    	        	
	        }
        	else if(admin == null &&id!=null) { %>
	        	<span class="login">
		          <a href="../session/mypage?member_id=<%out.print(id);%>">마이페이지</a>
		        </span>
		        <span class="signup">
		          <a href="../login/logout">로그아웃</a>
		        </span> <%
	        } %>
        </div>
      </header>
      <div class="background">
        <div class="title">Spring Library</div>
      </div>
      <div class="searchedTerm">
      	<%
      		out.println("검색어 : " + request.getParameter("keyword"));
      	%>
      </div>
      <table>
      	<tr>
	        <th>도서 ID</th>
	        <th>도서 제목</th>
	        <th>작가</th>
	        <th>출판사</th>
	        <th>장르</th>
	        <th>자세히보기</th>
        </tr>
        <c:forEach var="book" items="${book}" varStatus="status">
	        <tr align="center">
	          <td>${book.book_id}</td>
	          <c:url value="../book/bookDetail?book_id" var="bookURL" />
	          <td>${book.book_name}</td>
	          <td>${book.writer}</td>
	          <td>${book.publisher}</td>
	          <td>${book.genre}</td>
	          <td><a href="${bookURL}=${book.book_id}">➡</a></td>
	        </tr>
        </c:forEach>
      </table>
      <footer>
        <span class="subTitle">2017301080 최은정</span>
        <span class="subTitle">2017301004 김가은</span>
      </footer>
    </div>
  </body>
</HTML>
