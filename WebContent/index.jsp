
<%@page import="com.entity.User"%>
<%@page import="com.conn.DbConnect"%>

<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to servlet</title>
<%@include file="component/allCss.jsp" %>

<style type="text/css">
.back-img{
  background: url("img/pexels-hermaion-205414.jpg");
  width: 100%;
  height: 80vh;
  background-repeat: no-repeat;
  background-size: cover;
  
}
</style>
</head>
<body>
<%@include file="component/navbar.jsp" %>


<div class="container-fluid back-img text-center text-success">
   <h1 class="mt-1">Welcome to PhoneBook App</h1>

</div>
<div style="margin-top:1px">
<%@include file="component/footer.jsp" %>
</div>
</body>
</html>