package edu.csula.cs3220.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.cs3220.storage.*;

@WebServlet("/todo")
public class TodoServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: implement rendering the todo index.jsp page
      out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Final</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../app.css \">");
		out.println("</head>");

		out.println("<body>");
		out.println("<h1>Todo</h1>");
		out.println("<body>");
		out.println("<a>Edit</a>");
		out.println(" | ");
		out.println("<a>Pomodoro</a>");
		out.println(" | ");
		out.println("<a>Done</a>");
		out.println("</body>");

		out.println("<textarea></textarea>");
		out.println("<button>Add todo</button>");

	}

	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		// TODO: handle adding a new todo item
	}
}
