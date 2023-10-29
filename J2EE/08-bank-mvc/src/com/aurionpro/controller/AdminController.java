package com.aurionpro.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.aurionpro.jdbc.AdminDbUtil;
import com.aurionpro.model.Account;
import com.aurionpro.model.Transaction;
import com.aurionpro.model.User;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/bank-source")
	private DataSource datasource;
	AdminDbUtil DbUtil;

	@Override
	public void init() throws ServletException {

		super.init();
		DbUtil = new AdminDbUtil(datasource);
	}

	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("action");
		
		HttpSession session = request.getSession();
		Object admin = (Object) session.getAttribute("admin");
		HttpSession session1 = request.getSession();
		Object user = (Object) session1.getAttribute("user");
		
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
		case "user":

			try {
				ifUser(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
//		case "adminDashboard":
//			showAdminDashboard(request, response);
//			break;
		case "viewUsers":
			viewUsers(request, response);
			break;
		case "createUser":
			createUser(request, response);
			break;
		case "logout":

			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/home.jsp");
			break;
		case "createAccount":
			createAccount(request, response);
			break;
		case "showUserAccounts":
			showUserAccounts(request, response);
			break;
		case "showTransaction":
			showTransaction(request, response);

			break;
		case "search":
			search(request, response);
			break;
		case "Edit":
			getUserforEdit(request, response);
			break;
		case "Edit-save":
			updateUser(request, response);
			break;
		case "showUserTransaction":
			showUserTransaction(request, response);
		case "searchTransactionByDate":
			try {
				searchTransactionByDate(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case "AccountsTransaction":
			AccountsTransaction(request, response);
			break;	
		default:
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}

	}

	private void AccountsTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userIdParam = request.getParameter("user_id");

		if (userIdParam == null) {
			request.setAttribute("errorMessage", "Missing user_id parameter. Please provide a valid user_id.");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			return;
		}

		int user_id;
		try {
			user_id = Integer.parseInt(userIdParam);
		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage", "Invalid user ID. Please enter a valid number.");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			return;
		}

		List<Account> accounts = DbUtil.getUserAccountsForTransaction(user_id);

		if (accounts == null) {
			request.setAttribute("errorMessage", "An error occurred while retrieving user accounts.");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
		} else {
			request.setAttribute("accounts", accounts);
			request.getRequestDispatcher("/AccountsTransaction.jsp").forward(request, response);
		}
		
	}

	private void searchTransactionByDate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		String userIdParam = request.getParameter("user_id");
         
		
		System.out.println(userIdParam);
		if (userIdParam == null) {
			request.setAttribute("errorMessage", "Missing user_id parameter. Please provide a valid user_id.");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			return;
		}

		int user_id;
		try {
			user_id = Integer.parseInt(userIdParam);
		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage", "Invalid user ID. Please enter a valid number.");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			return;
		}

		
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");

		
			List<Transaction> transactions = DbUtil.getUserTransactionsByDate(user_id, startDate, endDate);

		
			request.setAttribute("userTransactions", transactions);

			
			request.getRequestDispatcher("/passbook.jsp").forward(request, response);
		}
	

	private void showUserTransaction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userIdParam = request.getParameter("user_id");

	
		if (userIdParam != null && userIdParam.matches("\\d+")) {
			int user_id = Integer.parseInt(userIdParam);
		
			List<Transaction> userTransactions = DbUtil.getTransactionsByUserId(user_id);

		
			request.setAttribute("userTransactions", userTransactions);
			request.setAttribute("user_id", user_id);
		
			request.getRequestDispatcher("/passbook.jsp").forward(request, response);
		} else {
		
		}
	}



	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_idParam = request.getParameter("user_id");
		String fnameParam = request.getParameter("fname");
		String lnameParam = request.getParameter("lname");
		String usernameParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");

		if (user_idParam != null && !user_idParam.isEmpty() && fnameParam != null && !fnameParam.isEmpty()
				&& lnameParam != null && !lnameParam.isEmpty() && usernameParam != null && !usernameParam.isEmpty()
				&& passwordParam != null && !passwordParam.isEmpty()) {
			try {
				int user_id = Integer.parseInt(user_idParam);
				User updatedUser = new User(user_id, fnameParam, lnameParam, usernameParam, passwordParam);

				DbUtil.updateUser(updatedUser);

				List<User> users = DbUtil.getUsers();

				request.setAttribute("users", users);

				request.getRequestDispatcher("success.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				request.setAttribute("error", "Invalid input. Please check integer fields: " + e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("update-user.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			request.setAttribute("error", "Missing or empty parameters.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("update-user.jsp");
			dispatcher.forward(request, response);
		}
	}

	

	private void getUserforEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		User user = DbUtil.getUserById(user_id);

		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/EditProfile.jsp");
		dispatcher.forward(request, response);

	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchParameter = request.getParameter("searchParameter");
		String searchValue = request.getParameter("searchValue");

		List<User> userList = new ArrayList<>();

		if (searchParameter != null && !searchValue.isEmpty()) {
			switch (searchParameter) {
			case "id":
				int userId = Integer.parseInt(searchValue);
				User user = DbUtil.getUserById(userId);
				if (user != null) {
					userList.add(user);
				}
				break;
			case "firstName":
				userList = DbUtil.searchUserByFirstName(searchValue);
				break;
			case "lastName":
				userList = DbUtil.searchUserByLastName(searchValue);
				break;
			case "username":
				userList = DbUtil.searchUserByUsername(searchValue);
				break;
			default:
				break;
			}
		} else {
			userList = DbUtil.getUsers();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/users.jsp");
		request.setAttribute("users", userList);
		dispatcher.forward(request, response);
	}


	private void showTransaction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Transaction> transactions = DbUtil.getTransaction();

		request.setAttribute("transactions", transactions);

		request.getRequestDispatcher("/PassbookPage.jsp").forward(request, response);

	}

	

	private void showUserAccounts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userIdParam = request.getParameter("user_id");

		if (userIdParam == null) {
			request.setAttribute("errorMessage", "Missing user_id parameter. Please provide a valid user_id.");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			return;
		}

		int user_id;
		try {
			user_id = Integer.parseInt(userIdParam);
		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage", "Invalid user ID. Please enter a valid number.");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			return;
		}

		List<Account> accounts = DbUtil.getUserAccounts(user_id);

		if (accounts == null) {
			request.setAttribute("errorMessage", "An error occurred while retrieving user accounts.");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
		} else {
			request.setAttribute("accounts", accounts);
			request.getRequestDispatcher("/ShowAccounts.jsp").forward(request, response);
		}
	}

	private void createAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int user_id = 0;

		String userIdParam = request.getParameter("user_id");
		if (userIdParam != null) {
			try {
				user_id = Integer.parseInt(userIdParam);
			} catch (NumberFormatException e) {

			}
		}

		request.setAttribute("user_id", user_id);

		String accountType = request.getParameter("accountType");
		String amountParam = request.getParameter("amount");

		if (user_id == 0 || accountType == null || amountParam == null || amountParam.isEmpty()) {

			request.setAttribute("errorMessage", "Missing or empty parameter(s). Please fill in all required fields.");
			request.getRequestDispatcher("CreateAccount.jsp").forward(request, response);
			return;
		}

		try {
			BigDecimal amount = new BigDecimal(amountParam);

			boolean accountCreated = DbUtil.createAccount(user_id, accountType, amount);

			if (accountCreated) {

				response.sendRedirect("success.jsp");
			} else {

				request.setAttribute("errorMessage", "Account creation failed. Please try again.");
				request.getRequestDispatcher("CreateAccount.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {

			request.setAttribute("errorMessage", "Invalid input for user ID or amount. Please enter valid numbers.");
			request.getRequestDispatcher("CreateAccount.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "An error occurred. Please try again.");
			request.getRequestDispatcher("CreateAccount.jsp").forward(request, response);
		}
	}

	private void createUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User newUser = new User(fname, lname, username, password);

		boolean userCreated = DbUtil.createUser(newUser);

		if (userCreated) {

			List<User> users = DbUtil.getUsers();

			request.setAttribute("users", users);

			request.getRequestDispatcher("success.jsp").forward(request, response);
		} else {

			response.sendRedirect("error.jsp");
		}
	}

	void viewUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<User> users = DbUtil.getUsers();

		request.setAttribute("users", users);

		request.getRequestDispatcher("/users.jsp").forward(request, response);
	}


	private void ifUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userType = request.getParameter("userType");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			if ("user".equals(userType)) {
				int userId = DbUtil.getUserId(username, password);
				if (userId > 0) {

					
					 request.getSession().setAttribute("username", username);
				
					request.getSession().setAttribute("userId", userId);
					
					response.sendRedirect(request.getContextPath() + "/user.jsp"); // Redirect to user dashboard
				} else {
				
					request.setAttribute("errorMessage", "Invalid user login. Please try again.");
					request.getRequestDispatcher("/home.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
