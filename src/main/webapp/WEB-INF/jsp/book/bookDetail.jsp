<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<HTML>
  <HEAD>
    <TITLE>도서 정보 조회</TITLE>
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
      .bookTitle {
        margin-top: 20px;
        font-size: 20px;
        font-weight: bold;
        margin-right: 10px;
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
      .bookinfo {
         font-size: 18px;
         margin-right: 5px;
      }
      img {
      	margin: 10px 0;
      	margin-right: 20px;
      }
      .mainInfo {
      	display: flex;
      	align-item: center;
      }
      .story {
      	margin-top: 10px;
      }
      .row {
      	display: flex;
        align-items: center;
      }
    </style>
  </HEAD>
  <body>
    <div class="white">
      <header>
        <form action="../search/searchBook" method="POST" class="search">
          <label style="display: block">
            🔎
            <input type="text" name="title" />
            <input type="submit" value="검색" />
          </label>
        </form>
        <div class="user">
          <%
           String id = (String)session.getAttribute("id");      
           if(id == null) { %>
              <span class="goHome">
                  <a href="../">홈으로</a>
                </span>
              <span class="login">
                <a href="../login/login">로그인</a>
              </span>
              <span class="signup">
                <a href="../register/step2">회원가입</a>
              </span> <%
           } else { %>
              <span class="goHome">
                  <a href="../">홈으로</a>
                </span>           
              <span class="login">
                <a href="../session/mypage">마이페이지</a>
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
      <div class="textBox">
        <div class="pageTitle">도서 정보 조회</div>
        <form action="bookLoan" method="POST">
           <c:forEach var="detail" items="${detail}" varStatus="status">
			  <div class="bookTitle">${detail.book_name}</div>
              <input 
                type="hidden"
                readonly="readonly"
                name="book_id"
                placeholder="<c:out value='${param.book_id}'/>"
                value="<c:out value='${param.book_id}'/>"
               />
               <div class="mainInfo">               
	               <img alt="" src="${detail.image}"/>
	               <div class="right">
		               <div>
		                  <span class="bookinfo">작가 : ${detail.writer} | </span>
		                  <span class="bookinfo">출판사 : ${detail.publisher} | </span>
		                  <span class="bookinfo">장르 : ${detail.genre}</span>               
		               </div>
		               <div class="story">${detail.story}</div>	               
	               </div>
               </div>
           </c:forEach>
           <%  
           if(id != null) { %>
               <input 
                type="hidden"
                readonly="readonly"
                name="id"             
                value="<%out.print(id);%>"
               />          
              <input type="submit" value="대여하기" /> 
           <% } %>       
        </form>
      </div>
      <footer>
        <span class="subTitle">2017301080 최은정</span>
        <span class="subTitle">2017301004 김가은</span>
      </footer>
    </div>
  </body>
</HTML>