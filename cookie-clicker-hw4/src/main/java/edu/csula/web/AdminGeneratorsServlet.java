package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;


@WebServlet("/admin/generators")
public class AdminGeneratorsServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO: render the generators page HTML
      GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		Collection<Generator> gen = dao.getAll();
      
		request.setAttribute("generatorEntries", gen);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin-generator.jsp");
		  rd.forward(request, response);
   }
	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
      GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		Collection<Generator> gen = dao.getAll();
      
		String name = request.getParameter("name");
		int rate = Integer.parseInt(request.getParameter("rate"));
		int baseCost = Integer.parseInt(request.getParameter("cost"));
		int unlockAt = Integer.parseInt(request.getParameter("unlock"));
		String description = request.getParameter("description");   
		Generator generator = new Generator(gen.size(), name, description, rate, baseCost, unlockAt);
		dao.add(generator);
		response.sendRedirect("generators");
	}
	
}
