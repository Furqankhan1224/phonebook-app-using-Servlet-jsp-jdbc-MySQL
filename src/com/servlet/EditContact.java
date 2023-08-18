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
import com.entity.Contact;

/**
 * Servlet implementation class EditContact
 */
@WebServlet("/EditContact")
public class EditContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String parameter = request.getParameter("name");
		String parameter1 = request.getParameter("email");
		String parameter2 = request.getParameter("number");
		String parameter3 = request.getParameter("about");
		System.out.println(parameter+parameter1+parameter2+parameter3);
		Contact u = new Contact();
		u.setId(cid);
		u.setName(parameter);
		u.setEmail(parameter1);
		u.setPhone(parameter2);
		u.setAbout(parameter3);
		ContactDao dao = new ContactDao(DbConnect.getconn());
		boolean updateContact = dao.updateContact(u);
		HttpSession session = request.getSession();
		if(updateContact) {
			session.setAttribute("succMsg", "your contact updated.....");
			response.sendRedirect("viewContact.jsp");
		}else {
			session.setAttribute("failedMsg", "somthing wrong....");
			response.sendRedirect("editcontact.jsp?cid="+cid);
		}
	}

}
