package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.storage.UsersDAO;
import edu.csula.models.User;

@WebServlet("/admin/auth")
public class AuthenticationServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO: render the authentication page HTML
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Homeworktwo</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../app.css \">");
		out.println("</head>");

		out.println("<body>");
		out.println("<h1>Incremental Game Framework</h1>");

		out.println("<form method=\"POST\">");
		out.println("<label for=\"username\">Username: </label><br>");
		out.println("<input type=\"text\"  id=\"username\"><br>");
		out.println("<label for=\"password\">Password: </label><br>");
		out.println("<input type=\"password\" id=\"password\"><br>");
		out.println("<input type=\"submit\" value=\"Log in\">");
		out.println("<button>Log in</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle login
      UsersDAO dao = new UsersDAOImpl(request.getSession());
		if (dao.authenticate(request.getParameter("username"), request.getParameter("password"))) {
			response.sendRedirect("../admin/events");
		} else {
			response.sendRedirect("../admin/auth");
		}
	}


    @Override
    public void doDelete( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: handle logout
      UsersDAO dao = new UsersDAOImpl(request.getSession());
		dao.logout();
    }
}
