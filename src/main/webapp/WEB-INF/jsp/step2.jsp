<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>
    <h2>회원 정보 입력</h2>
    <form action="step3" method="post">
       <p> <label>이메일:<br>
             <input type="text" name="email" id="email" value="${registerRequest.email}">
             </label> </p>
       <p> <label>이름:<br>
             <input type="text" name="name" id="name" value="${registerRequest.name}">
             </label> </p>
      <p> <label>비밀번호:<br>
            <input type="password" name="password" id="password">
            </label> </p>
      <p> <label>비밀번호 확인:<br>
            <input type="password" name="confirmPassword" id="confirmPassword">
            </label> </p>
      <input type="submit" value="가입 완료">
    </form>
</body>
</html>