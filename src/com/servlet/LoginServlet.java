package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DbConnect;
import com.dao.UserDao;
import com.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("email");
		String parameter1 = request.getParameter("password");
//		System.out.println(parameter + parameter1);
		
		UserDao dao= new UserDao(DbConnect.getconn());
		User u = dao.LoginUser(parameter, parameter1);
//		response.sendRedirect("index.jsp");
		HttpSession session = request.getSession();
		if(u!=null) {
		session.setAttribute("user", u);
			response.sendRedirect("index.jsp");
		}else {
			session.setAttribute("invalidMsg", "Invalid Eamil & Password");
			response.sendRedirect("login.jsp");
		}
	}

}
