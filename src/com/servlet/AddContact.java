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
import com.dao.UserDao;
import com.entity.Contact;
import com.entity.User;

/**
 * Servlet implementation class AddContact
 */
@WebServlet("/AddContact")
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContact() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String parameter = request.getParameter("name");
		String parameter1 = request.getParameter("email");
		String parameter2 = request.getParameter("number");
		String parameter3 = request.getParameter("about");
//		System.out.println(parameter+parameter1+parameter2+parameter3);
		Contact u = new Contact(parameter,parameter1,parameter2,parameter3,userId);
		ContactDao dao = new ContactDao(DbConnect.getconn());
		boolean userRegister = dao.saveContact(u);
		HttpSession session = request.getSession();
		if(userRegister) {
			session.setAttribute("succMsg", "your contact save....");
			response.sendRedirect("addContact.jsp");
		}else {
			session.setAttribute("failedMsg", "somthing wrong....");
			response.sendRedirect("addContact.jsp");
		}
	}

}
