package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DbConnect;
import com.dao.ContactDao;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		int cid =Integer.parseInt( request.getParameter("cid"));
		ContactDao dao = new ContactDao(DbConnect.getconn());
		boolean deleteContactById = dao.deleteContactById(cid);
		HttpSession session = request.getSession();
		if(deleteContactById) {
			session.setAttribute("succMsg", "contact Delete SuccessFully....");
			response.sendRedirect("viewContact.jsp");
		}else {
			session.setAttribute("failedMsg", "somthing wrong....");
			response.sendRedirect("viewContact.jsp");
		}
	}

	

}
