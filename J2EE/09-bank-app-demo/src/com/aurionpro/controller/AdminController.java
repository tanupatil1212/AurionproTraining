package com.aurionpro.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.aurionpro.jdbc.AdminDbUtil;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminController() {
		super();

	}

	@Resource(name = "jdbc/bankk-source")
	private DataSource datasource;
	private AdminDbUtil DbUtil;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		DbUtil = new AdminDbUtil(datasource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String command = request.getParameter("action");
		if (command == null) {
			command = "home";
		}
		switch (command) {
		case "home":

			try {
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "admin":

			try {
				ifAdmin(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		
		default:
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}

	}
	
	

	

	private void ifAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userType = request.getParameter("userType");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if ("admin".equals(userType) && DbUtil.isValidAdmin(username, password)) {

			request.getSession().setAttribute("userType", "admin");
			response.sendRedirect(request.getContextPath() + "/admin.jsp");
		} else {

			request.setAttribute("errorMessage", "Invalid admin login. Please try again.");
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
