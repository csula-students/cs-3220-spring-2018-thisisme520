package edu.csula.cs3220.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.cs3220.storage.*;

@WebServlet("/todo/edit")
public class EditTodoServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: implement rendering the todo edit.jsp page
      out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Edit Hello todo</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../app.css \">");
		out.println("</head>");

		out.println("<body>");
		out.println("<h1>Edit Hello todo</h1>");
		out.println("<textarea></textarea>");
		out.println("<button>Edit todo</button>");
      out.println("</body>");

      
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		// TODO: handle editing an existing todo item
	}
}
