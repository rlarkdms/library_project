<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<HTML>
  <HEAD>
    <TITLE>관리자 페이지</TITLE>
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
      .content {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        padding-top: 30px;
      }
      .userName {
        font-size: 20px;
        font-weight: bold;
      }
      .userName {
        font-size: 20px;
        font-weight: bold;
      }
      .tableName {
        font-size: 18px;
        margin: 10px 0;
        font-weight: bold;
      }
      table {
        font-size: 16px;
        width: 80%;
        border: 1px solid black;
        margin-bottom: 30px;
      }
      th {
        border-bottom: 1px solid black;
      }
      th,
      td {
        padding: 5px;
      }      
    </style>
  </HEAD>
  <body>
    <div class="white">
      <header>
        <form action="../search/searchBook" method="POST" class="search">
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
          <% String admin = (String)session.getAttribute("admin"); 
          	if(admin != null) { %>
	          <span class="signup">
	            <a href="../login/logout">로그아웃</a>
	          </span>
          <% } %>
        </div>
      </header>
      <div class="background">
        <div class="title">Spring Library</div>
      </div>

      <div class="content">
		<c:forEach var="detail" items="${user}" varStatus="status">
        	<div class="userName">관리자 ${user.name}님</div>
        	<button onclick="location='http://localhost:9200/admin/bookInsert.jsp'">도서 추가</button> 
		</c:forEach>      
      
        <div class="tableName">총 도서 목록</div>
        <table>
       	  <th>도서 ID</th>
          <th>도서 제목</th>
          <th>작가</th>
          <th>출판사</th>
          <th>장르</th>
          <th>삭제하기</th>
          <c:forEach var="book" items="${book_list}" varStatus="status">
          	<tr align="center">		          	             	
	          	<td>${book.book_id}</td>
	            <td>${book.book_name}</td>
	            <td>${book.writer}</td>
	            <td>${book.publiser}</td>
	            <td>${book.genre}</td>
          		<form action="bookDelete" method="POST">
		            <input 
		              type="hidden"
		              readonly="readonly"
		              name="book_id"
		              value="<c:out value='${book.book_id}'/>"
		             />				             					
	            	<td>
	            		<input type="submit" value="삭제" /> 
	            	</td>
	            </form>
          	</tr>
	      </c:forEach>
        </table>	  
	  </div>		

      <footer>
        <span class="subTitle">2017301080 최은정</span>
        <span class="subTitle">2017301004 김가은</span>
      </footer>
    </div>
  </body>
</HTML>
