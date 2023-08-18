<%@page import="com.entity.Contact"%>
<%@page import="com.conn.DbConnect"%>
<%@page import="com.dao.ContactDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/allCss.jsp" %>
</head>
<body>
<%@include file="component/navbar.jsp" %> 
<% 
if(user==null){
	session.setAttribute("invalidMsg", "Login please....");
	response.sendRedirect("login.jsp");
}
%>
<div class="container-fluid">
<div class="row p-2">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<h4 class="text-center text-success">Add Contact Page</h4>
<%
  String sucssMsg=(String)session.getAttribute("succMsg");
   String errorMsg =(String)session.getAttribute("failedMsg");
   if(sucssMsg!=null){
	   %>
	   <p class="text-success text-center"><%=sucssMsg %></p>
	  <%
	  session.removeAttribute("succMsg");
	  
	  
   }
   if(errorMsg!=null){
       %>
	   <p class="text-danger text-center"><%=errorMsg %></p>
	  <%
	  session.removeAttribute("failedMsg");
	 
   }
%>
  <form action="EditContact" method="post">
     <%
    
    int cid= Integer.parseInt(request.getParameter("cid"));
     ContactDao dao = new ContactDao(DbConnect.getconn());
     Contact c=dao.getContact(cid);
     %>
     <input type="hidden" value="<%=cid%>" name="cid">
    <div class="form-group">
    <label for="exampleInputEmail1">Enter Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name" name="name" value="<%=c.getName()%>">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email" value="<%=c.getEmail()%>" >
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Enter phone No</label>
    <input type="number" class="form-control" id="exampleInputPassword1" placeholder="Enter your number" name="number" value="<%=c.getPhone()%>" >
   <div class="text-center mt-2">
    <div class="form-group">
        <textarea rows="3" cols="" placeholder="Enter About" name="about" class="form-control" ><%=c.getAbout()%></textarea>
  </div>
    <button type="submit" class="btn btn-success">update</button>
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