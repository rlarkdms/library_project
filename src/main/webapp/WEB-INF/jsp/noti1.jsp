<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<HTML>
  <HEAD>
    <TITLE>공지사항</TITLE>
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
      .textBox {
        margin: 30px;
        font-size: 20px;
      }
      .pageTitle {
        font-size: 30px;
        font-weight: bold;
        border-bottom: 3px solid #ff6d00;
      }
      .notiTitle {
        margin-top: 20px;
        font-size: 24px;
        font-weight: bold;
      }
      .date {
        color: gray;
        font-size: 18px;
        margin-top: 5px;
      }
      li {
        margin-bottom: 5px;
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
      .subTitle {
        font-size: 15px;
        font-weight: bold;
        color: rgb(83, 77, 77);
        margin: 0 10px;
      }
    </style>
  </HEAD>
  <body>
    <div class="white">
      <header>
        <form action="/search/searchBook" method="POST" class="search">
          <label style="display: block">
            🔎
            <input type="text" name="keyword" />
            <input type="submit" value="검색" />
          </label>
        </form>
        <div class="user">
          <span class="goHome">
            <a href="index">홈으로</a>
          </span>
        <%
        	String id = (String)session.getAttribute("id");
        	String admin = (String)session.getAttribute("admin");      
        	if(id == null) { %>
		        <span class="login">
		          <a href="/login/login">로그인</a>
		        </span>
		        <span class="signup">
		          <a href="/register/step2">회원가입</a>
		        </span> <%
	        } else if(admin != null) { %> 
 	        	<span class="login">
		          <a href="/admin/adminPage?member_id=<%out.print(admin);%>">관리자페이지</a>
		        </span>
		        <span class="signup">
		          <a href="/login/logout">로그아웃</a>
		        </span> <%    	        	
	        }
        	else { %>
	        	<span class="login">
		          <a href="/session/mypage?member_id=<%out.print(id);%>">마이페이지</a>
		        </span>
		        <span class="signup">
		          <a href="/login/logout">로그아웃</a>
		        </span> <%
	        } %>
        </div>
      </header>
      <div class="background">
        <div class="title">Spring Library</div>
      </div>
      <div class="textBox">
        <div class="pageTitle">공지사항</div>
        <div class="notiTitle">도서관 이용 규칙</div>
        <div class="date">2021-06-01</div>
        <div class="content">
          <ul>
            <li>한 명당 대여는 5권까지 가능합니다.</li>
            <li>대여 기간은 빌린 시점부터 일주일동안 입니다.</li>
            <li>연장은 권 당 딱 한 번, 일주일까지 하실 수 있습니다</li>
            <li>
              연체가 된 도서가 경우에는 연체된 기간만큼 도서 대여가 불가능하며
              반납만 하실 수 있습니다.
            </li>
          </ul>
        </div>
      </div>
      <footer>
        <span class="subTitle">2017301080 최은정</span>
        <span class="subTitle">2017301004 김가은</span>
      </footer>
    </div>
  </body>
</HTML>
