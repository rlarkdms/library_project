<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<!DOCTYPE html>
<HTML>
  <HEAD>
    <TITLE>회원가입</TITLE>
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
      .signupLabel {
        margin: 10px 0;
        display: flex;
        align-items: center;
        justify-content: space-between;
      }
      input[name="id"],
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
    <script type = "text/javascript">
      function CheckForm(){
		var password= document.getElementById("password").value;
		var pwcomfirm= document.getElementById("pwcomfirm").value;
		console.log(password, pwcomfirm);
		if(password !== pwcomfirm)
			alert("비밀번호가 일치하지 않습니다!");
		else {
			document.getElementById("signUpForm").submit();
		}
	  }
	</script>
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
           <span class="login">
		      <a href="../login/login">로그인</a>
		   </span>
        </div>
      </header>
      <div class="background">
        <div class="title">Spring Library</div>
      </div>
      <div class="formBox">
      	<div class="pageTitle">회원 가입</div>
        <form action="step3" method="POST" class="search" id="signUpForm">
          <label class="signupLabel">
            <span>ID</span>
            <input
              type="text"
              name="id"
               placeholder="중복 불가"
              value="${registerRequest.id}"
              required
            />
          </label>
          <label class="signupLabel">
            <span>PW</span>
            <input
              type="password"
              id="password"
              name="password"
              value="${registerRequest.password}"
              required
            />
          </label>
          <label class="signupLabel">
            <span>PW 확인</span>
            <input
              type="password"
              id="pwcomfirm"
              name="pwcomfirm"
              value="${registerRequest.confirmPassword}"
              required
            />
          </label>
          <label class="signupLabel">
            <span>이름</span>
            <input
              type="text"
              name="name"
              value="${registerRequest.name}"
              required
            />
          </label>
          <label class="signupLabel">
            <span>이메일</span>
            <input
              type="text"
              name="email"
              value="${registerRequest.email}"
              required
            />
          </label>
          <label class="signupLabel">
            <span>휴대폰</span>
            <input
              type="text"
              name="phone"
              value="${registerRequest.phone}"
              required
            />
          </label>
          <input type="button" value="회원가입" class="signup" onclick="CheckForm();"/>
        </form>
      </div>
      <footer>
        <span class="subTitle">2017301080 최은정</span>
        <span class="subTitle">2017301004 김가은</span>
      </footer>
    </div>
  </body>
</HTML>
