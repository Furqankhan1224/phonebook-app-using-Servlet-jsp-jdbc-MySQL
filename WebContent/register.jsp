<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/allCss.jsp" %>
</head>
<body style="background-color: #f7faf8;">
<%@include file="component/navbar.jsp" %>
<div class="container-fluid">
<div class="row p-2">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<h4 class="text-center text-success">Registaration Page</h4>
<%
  String sucssMsg=(String)session.getAttribute("sucssMsg");
   String errorMsg =(String)session.getAttribute("errorMsg");
   if(sucssMsg!=null){
	   %>
	   <p class="text-success text-center"><%=sucssMsg %></p>
	  <%
	  session.removeAttribute("sucssMsg");
	  
	  
   }
   if(errorMsg!=null){
       %>
	   <p class="text-danger text-center"><%=sucssMsg %></p>
	  <%
	  session.removeAttribute("errorMsg");
	 
   }
%>
  <form action="RegisterServlet" method="post">
    <div class="form-group">
    <label for="exampleInputEmail1">Enter Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name" name="name">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
   <div class="text-center mt-2">
    <button type="submit" class="btn btn-primary">Registaration</button>
    </div>
  </div>
  
  
</form>

</div>

</div>

</div>

</div>

</div>

<div style="margin-top:20px">
<%@include file="component/footer.jsp" %>
</div>
</body>
</html>