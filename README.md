# library_project📖
### 도서관시스템 제작 기말 대체 과제

<b>Spring MVC와 DB를 이용하여 시스템 개발 </b><br>
<b>언어 : Java,JSP,Javascript,html,css </b><br>
<b>그외 : Mysql,Amazon S3,tomcat </b><br>
<b>개발 기간 : 2021-06-01~2021-06-08</b><br>
<b>Front-end+web design 최은정</b><br>
<b>Back-end+DB 김가은</b>



<br>
### ERD

![ERD](https://user-images.githubusercontent.com/31676033/121297398-38e25380-c92d-11eb-987e-75566a29408f.png)




### 구현한 서비스
1. 세션 생성 및 제거(#세션 생성)<br>
&nbsp;1) 회원가입<br>
&nbsp; 2) 로그인<br>
&nbsp;&nbsp;   -일반 로그인<br>
&nbsp;&nbsp;   - 관리자 로그인<br>
&nbsp; 3) 로그아웃<br>
2. 비세션 기능<br>
&nbsp; 1) 공지사항 조회<br>
&nbsp; 2) 이번달 소식<br>
&nbsp;&nbsp;   - 인기 도서<br>
&nbsp;&nbsp;   - 신작<br>
&nbsp; 3) 도서 검색<br>
&nbsp; 4) 도서 정보 조회<br>
&nbsp; 5) 동일 장르 추천 도서<br>
3. 회원 기능<br>
&nbsp; 1) 사용자 정보 조회<br>
&nbsp;&nbsp;   - 대여중인 도서 목록<br>
&nbsp;&nbsp;   - 연체중인 도서 목록<br>
&nbsp;&nbsp;   - 대여 히스토리<br>
&nbsp; 2) 회원 정보 수정<br>
&nbsp; 3) 회원 탈퇴<br>
&nbsp; 4) 도서 대여<br>
&nbsp; 5) 도서 반납<br>
&nbsp; 6) 도서 연장<br>
4. 관리자 기능<br>
&nbsp; 1) 도서 추가<br>
&nbsp; 2) 도서 삭제<br>
&nbsp; 3) 공지사항 관리<br>
&nbsp;&nbsp;   - 공지사항 생성<br>
&nbsp;&nbsp;   - 공지사항 삭제<br>
&nbsp; 4)회원 목록<br>

### 수정해야할 것  
매칭되지 않는 아이디 비번 일 경우 login/login에서 에러문구 나오게 하기(해결)


### 에러

spring서버에서 jsp 파일을 찾지 못해 404에러 존재(해결)<br>
-> pom.xml에 groupId와 package이름이 달라서 생겼던 에러


