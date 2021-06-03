<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<!DOCTYPE html>
<HTML>
  <HEAD>
    <TITLE>Log In</TITLE>
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
      .signup {
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
        padding: 100px 30px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
      }
      .loginLabel {
        margin: 20px 0;
      }
      input[name="member_id"],
      input[name="password"] {
        margin-left: 10px;
        padding: 10px 20px;
      }
      .loginBottom {
        margin-top: 20px;
        display: flex;
        align-items: center;
        justify-content: space-around;
      }
      .signup,
      input[name="login"] {
        padding: 10px 15px;
        font-size: 18px;
        border-radius: 10px;
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
      .warning {
      	color: crimson
      }
    </style>
    <script type="text/javascript">
      $("input:radio[name='status']:radio[value='normal']").prop("checked", true); // 선택하기
      $("input:radio[name='status']:radio[value='admin']").prop("checked", false); // 해제하기
    </script>
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
          <span class="goHome">
            <a href="../">홈으로</a>
          </span>
        </div>
      </header>
      <div class="background">
        <div class="title">Spring Library</div>
      </div>
      <div class="formBox">
        <div class="loginType">
          <input
            type="radio"
            name="status"
            value="normal"
            checked="checked"
          />일반 <input type="radio" name="status" value="admin" />관리자
        </div>
        <form action="loginCheck" method="POST" class="search">
          <label style="display: block" class="loginLabel">
            <span>ID</span>
            <input
              type="text"
              name="member_id"
              required
            />
          </label>
          <label style="display: block" class="loginLabel">
            <span>PW</span>
            <input
              type="text"
              name="password"
              required
            />
          </label>
   		  <div class="warning">${error}</div>
          <div class="loginBottom">
            <div class="signup">
              <a href="../register/step1">회원가입</a>
            </div>
            <input type="submit" value="로그인" name="login" />
          </div>
        </form>
      </div>
      <footer>
        <span class="subTitle">2017301080 최은정</span>
        <span class="subTitle">2017301004 김가은</span>
      </footer>
    </div>
  </body>
</HTML>
