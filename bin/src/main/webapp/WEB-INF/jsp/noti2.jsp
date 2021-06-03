<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
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
        margin-bottom: 0;
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
      .content {
        margin: 20px 0;
      }
      .li,
      .text {
        margin-bottom: 5px;
      }
      .ul {
        margin: 20px 0 5px 0;
        font-weight: bold;
      }
      footer {
        background-color: white;
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
        <form action="search.jsp" method="POST" class="search">
          <label style="display: block">
            🔎
            <input type="text" name="title" />
            <input type="submit" value="검색" />
          </label>
        </form>
        <div class="user">
          <span class="goHome">
            <a href="/index.jsp">홈으로</a>
          </span>
          <span class="login">
            <a href="/login.jsp">로그인</a>
          </span>
          <span class="signup">
            <a href="/signup.jsp">회원가입</a>
          </span>
        </div>
      </header>
      <div class="background">
        <div class="title">Spring Library</div>
      </div>
      <div class="textBox">
        <div class="pageTitle">공지사항</div>
        <div class="notiTitle">
          도서관 내 마스크 마스크 착용 의무화 및 제재 안내
        </div>
        <div class="date">2021-06-01</div>
        <div class="content">
          <div class="text">
            "마스크 착용 의무화 행정명령"에 따라 도서관 내에서는 반드시 마스크를
            착용하여야 합니다.
          </div>
          <div class="text">
            마스크 미착용 시 다음과 같은 도서관 이용이 제한되오니 양지하시기
            바랍니다.
          </div>
          <ul>
            <div class="ul">1. 마스크 착용 기준</div>
            <li>입과 코를 모두 가리지 않으면 미착용으로 간주</li>
            <li>밸브형 마스크, 스카프, 옷가지 등은 마스크로 인정 불가</li>
            <div class="ul">2. 적발 시 제재사항</div>
            <li>1회 적발 : 구두 경고</li>
            <li>2회 적발 : 즉시 퇴실 및 10일간 도서관 출입불가</li>
            <div class="ul">3. 제재 근거</div>
            <li>도서관 이용 규정 제6장 18조 1항 5호</li>
            <li>
              질서유지를 위한 도서관 직원의 요구 불응 : 10일 이상 3개월 이하의
              도서관 이용 중지
            </li>
            <div class="ul">4. 시행기간</div>
            <li>2020년 11월 18일 ~ 별도 공지시 까지</li>
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
