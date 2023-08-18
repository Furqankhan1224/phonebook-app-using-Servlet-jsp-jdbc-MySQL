package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DbConnect;
import com.dao.UserDao;
import com.entity.User;
import com.mysql.cj.Session;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		String parameter = request.getParameter("name");
		String parameter1 = request.getParameter("email");
		String parameter2 = request.getParameter("password");
		User u = new User(parameter,parameter1,parameter2);
		UserDao dao = new UserDao(DbConnect.getconn());
		boolean userRegister = dao.userRegister(u);
		HttpSession session = request.getSession();
		if(userRegister=true) {
			session.setAttribute("sucssMsg", "User Register Sucessfully....");
			response.sendRedirect("register.jsp");
		}else {
			session.setAttribute("errorMsg", "Somthing wrong on server....");
			response.sendRedirect("register.jsp");
		}
	}

}
