package edu.csula.cs3220.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.cs3220.storage.*;

@WebServlet("/todo/pomodoro")
public class TodoPomodoroServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: implement rendering the todo pomodoro.jsp page
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		// TODO: handle adding pomodoro counter
	}
}
