package com.aurionpro.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeerServlet
 */
@WebServlet(name = "BeerServlett", urlPatterns = { "/BeerServlett" })
public class BeerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerServlet() {
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
		 String beerType = request.getParameter("beerType");

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("<html>");
	        out.println("<head><title>Beer Selection Result</title></head>");
	        out.println("<body>");
	        out.println("<h1>You've selected: " + beerType + "</h1>");
	        out.println("</body>");
	        out.println("</html>");
	}

}