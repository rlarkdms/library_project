<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<!DOCTYPE html>
<HTML>
  <HEAD>
    <TITLE> LIBARAY </TITLE>
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
      header {
        width: 50%;
        display: flex;
        align-items: center;
        justify-content: space-between;
        background-color: #fff;
        padding: 30px;
        box-sizing: border-box;
      }
      a {
        text-decoration: none;
        color: black;
      }
      .background {
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        background-image: url(https://images.unsplash.com/photo-1562932831-afcfe48b5786?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NzR8fGxpYnJhcnl8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60);
        width: 100%;
        height: 500px;
        opacity: 0.7;
        /* width: 100%;
        height: 400px; */
        /* overflow: hidden; */
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
      }
      .background > img {
        position: absolute;
        width: 100%;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
      }
      .board {
        background-color: #fff;
        box-sizing: border-box;
        width: 50%;
        height: 35.3vh;
        padding: 30px;
        display: flex;
        /* align-items: center; */
        /* justify-content: space-around; */
        font-size: 20px;
      }
      .title {
        font-size: 50px;
        font-weight: bold;
        color: #ff6d00;
        margin: 20px 0;
      }
      .subTitle {
        font-size: 15px;
        font-weight: bold;
        color: rgb(83, 77, 77);
        margin: 0 10px;
      }
      ul {
        padding: 0;
      }
      li {
        margin-bottom: 10px;
        display: flex;
        justify-content: space-between;
      }
      .notice,
      .thisMonth {
        margin: 10px 15px;
        width: 50%;
      }
      .boardTitle {
        font-size: 25px;
        font-weight: bold;
        border-bottom: 3px solid #ff6d00;
      }
      .search,
      .login,
      .signup {
        font-size: 17px;
        font-weight: bold;
      }
      .login {
        margin-right: 10px;
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
      footer {
        width: 50%;
        background-color: white;
        padding: 30px 0;
        display: flex;
        align-items: center;
        justify-content: center;
        border-top: 1px solid lightgray;
      }
      .date {
        color: rgb(83, 77, 77);
      }
    </style>
  </HEAD>
  <body>
    <header>
      <form action="search.jsp" method="POST" class="search">
        <label style="display: block">
          ????
          <input type="text" name="title" />
          <input type="submit" value="??????" />
        </label>
      </form>
      <div class="user">
        <span class="login">
          <a href="/login.jsp">?????????</a>
        </span>
        <span class="signup">
          <a href="/signup.jsp">????????????</a>
        </span>
      </div>
    </header>
    <div class="background">
      <!-- <img
        src="https://images.unsplash.com/photo-1507842217343-583bb7270b66?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8bGlicmFyeXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
        alt=""
      /> -->
      <div class="title">Spring Library</div>
    </div>
    <div class="board">
      <div class="notice">
        <div class="boardTitle">????????????</div>
        <ul>
          <li>
            <a href="/noti1.jsp"
              >??? ????????? ?????? ??????
            </a>
            <span class="date">2021-06-01</span>
          </li>
          <li>
            <a href="noti2.jsp"
              >??? ????????? ?????? ????????? ??? ?????? ??????</a
            >
            <span class="date">2021-06-01</span>
          </li>
        </ul>
      </div>
      <div class="thisMonth">
        <div class="boardTitle">????????? ??????</div>
        <ul>
          <li>
            <a href="/bestSeller.jsp"
              >??? ?????? ?????? TOP 10</a
            >
            <span class="date">2021-06-01</span>
          </li>
          <li>
            <a href="/newBooks.jsp">??? ??????</a>
            <span class="date">2021-06-01</span>
          </li>
        </ul>
      </div>
    </div>
    <footer>
      <span class="subTitle">2017301080 ?????????</span>
      <span class="subTitle">2017301004 ?????????</span>
    </footer>
  </body>
</HTML>
