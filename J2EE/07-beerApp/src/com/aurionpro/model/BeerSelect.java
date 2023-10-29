package com.aurionpro.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeerSelect
 */
@WebServlet("/BeerSelect")
public class BeerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerSelect() {
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
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			out.println("Beer Selection Advice <br>");
			String c =request.getParameter("color");
//			out.println("<br>Got Beer Color: "+c);
					
			BeerExpert beerExpert = new BeerExpert(); 
			List results= beerExpert.getBrands(c);
			System.out.println(results);
			
			RequestDispatcher view = request.getRequestDispatcher("reult.jsp");
			request.setAttribute("styles", results);
			view.forward(request, response);

			
			
			
//			Iterator iterator = results.iterator();
//			while(iterator.hasNext()) {
//				out.println("<br> Try-> "+iterator.next());
//			}
			
		}

}
