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
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
   
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
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



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		case "user":

			try {
				ifUser(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		default:
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
	}
	
	

	
	private void ifUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userType = request.getParameter("userType");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			if ("user".equals(userType)) {
			    if (DbUtil.isValidUser(username, password)) {
			        int userId = DbUtil.getUserId(username, password); // Retrieve user ID
			        request.getSession().setAttribute("userId", userId); // Store user ID in the session
			        response.sendRedirect(request.getContextPath() + "/user.jsp"); // Redirect to user dashboard
			    } else {

					System.out.println("Invalid user login: " + username);
					request.setAttribute("errorMessage", "Invalid user login. Please try again.");
					request.getRequestDispatcher("/home.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
