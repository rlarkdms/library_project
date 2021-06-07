<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<!DOCTYPE html>
<HTML>
  <HEAD>
    <TITLE>도서 정보 추가</TITLE>
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
      .user {
        font-size: 17px;
        font-weight: bold;
      }
      input[type="text"] {
        padding: 5px;
        border-radius: 10px;
        width: 250px;
        outline: none;
      }
      .signup,
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
      .formBox {
        box-sizing: border-box;
        width: 100%;
        padding: 50px 30px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
      }
      form {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
      }
      form input {
      	margin-left : 10px;
      }
      .signupLabel {
        margin: 10px 0;
        display: flex;
        align-items: center;
        justify-content: space-between;
      }
      input[name="member_id"],
      input[name="password"],
      input[name="pwcomfirm"],
      input[name="name"],
      input[name="email"],
      input[name="phone"] {
        margin-left: 10px;
        padding: 10px 20px;
      }
      .signup {
        padding: 10px 15px;
        font-size: 18px;
        border-radius: 10px;
        margin-top: 20px;
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
      .pageTitle {
        font-size: 30px;
        font-weight: bold;
        border-bottom: 3px solid #ff6d00;
        margin-bottom: 20px;
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
	          <span class="goHome">
	            <a href="../login/logout">로그아웃</a>
	          </span>
          <% } %>
        </div>
      </header>
      <div class="background">
        <div class="title">Spring Library</div>
      </div>
      <div class="formBox">
      	<div class="pageTitle">도서 추가</div>
        <form action="bookInsertCheck" method="POST" class="search" id="signUpForm">
          <label class="signupLabel">
            <input 
              type="hidden"
              readonly="readonly"
              name="admin_id"
              value="${param.admin_id}"
             />           
           <span>도서 제목</span>
           <input 
             type="text"
             name="book_name"
             required
             value="${book.book_name}"
            />
          </label>
          <label class="signupLabel">
            <span>작가</span>
            <input
              type="text"
              id="password"
              name="writer"
              value="${book.writer}"
              required
            />
          </label>
          <label class="signupLabel">
            <span>출판사</span>
            <input
              type="text"
              id="pwcomfirm"
              name="publisher"
              value="${book.publisher}"
              required
            />
          </label>
          <label class="signupLabel">
            <span>장르</span>
            <input
              type="text"
              name="genre"
              value="${book.genre}"
              required
            />
          </label>
          <label class="signupLabel">
            <span>줄거리</span>
            <input
              type="text"
              name="story"
              value="${book.story}"
              required
            />
          </label>
          <label class="signupLabel">
            <span>이미지</span>
            <input
              type="text"
              name="image"
              value="${book.image}"
            />
          </label>
          <input type="submit" value="추가하기" class="signup"/>
        </form>
      </div>
      <footer>
        <span class="subTitle">2017301080 최은정</span>
        <span class="subTitle">2017301004 김가은</span>
      </footer>
    </div>
  </body>
</HTML>
