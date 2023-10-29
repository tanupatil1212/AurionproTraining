package com.aurionpro.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
		case "user":

			try {
				ifUser(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "adminDashboard":
			showAdminDashboard(request, response);
			break;
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
		// case "editUserProfile":
		// editUserProfile(request, response);
		// break;
		// case "updateUserProfile":
		// updateUserProfile(request, response);
		// break;

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
//		case "showTransactioninuser":
//			showTransactioninuser(request, response);
//		break;
		default:
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}

	}

	//****
//	private void showTransactioninuser(HttpServletRequest request, HttpServletResponse response) {
//	    String username = request.getParameter("username");
//	    String password = request.getParameter("password");
//
//	    // Authenticate the user and obtain user_id
//	    int userId = DbUtil.getUserId(username, password); // Retrieve user ID
//	    request.getSession().setAttribute("userId", userId); // Store user ID in the session
//// Replace with your authentication logic.
//
//	    if (userId > 0) {
//	        // User is authenticated, retrieve transactions.
//	        List<Transaction> userTransactions = getUserByUserId(userId);
//
//	        // Set transactions as a request attribute.
//	        request.setAttribute("userTransactions", userTransactions);
//
//	        // Redirect to the user's dashboard.
//	        response.sendRedirect("userDashboard.jsp"); // Replace with your actual dashboard page.
//	    } else {
//	        // Authentication failed, handle accordingly.
//	        response.sendRedirect("login.jsp"); // Redirect back to the login page with an error message.
//	    }
//	}









	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User updatedUser = new User(userId, fname, lname, username, password);

		DbUtil.updateUser(updatedUser);

		List<User> users = DbUtil.getUsers();

		request.setAttribute("users", users);

		request.getRequestDispatcher("success.jsp").forward(request, response);
	}

	private void getUserforEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		User user = DbUtil.getUserById(userId);

		request.setAttribute("users", user);
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

	// private void showTransactionsByAccountNo(HttpServletRequest request,
	// HttpServletResponse response) {
	// int accountNo = Integer.parseInt(request.getParameter("accountNo"));
	// List<Transaction> transactions =
	// DbUtil.getTransactionsByAccountNo(accountNo);
	//
	// // Set the transactions as an attribute in the request
	// request.setAttribute("transactionss", transactions);
	//
	// // Forward the request to the JSP for displaying transactions
	// RequestDispatcher dispatcher = request.getRequestDispatcher("/passbook.jsp");
	// try {
	// dispatcher.forward(request, response);
	// } catch (ServletException | IOException e) {
	// e.printStackTrace();
	// }
	// }

	private void showTransaction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Transaction> transactions = DbUtil.getTransaction();

		request.setAttribute("transactions", transactions);

		request.getRequestDispatcher("/PassbookPage.jsp").forward(request, response);

	}

	// private void editUserProfile(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// String userIdParam = request.getParameter("user_id");
	//
	// if (userIdParam != null && !userIdParam.isEmpty()) {
	// int userId = Integer.parseInt(userIdParam);
	// User user = DbUtil.getUserProfile(userId);
	//
	// if (user != null) {
	// request.setAttribute("user", user);
	// request.getRequestDispatcher("/EditProfile.jsp").forward(request, response);
	// } else {
	// response.sendRedirect("error.jsp");
	// }
	// } else {
	// // Handle the case where 'user_id' is missing or empty
	// response.sendRedirect("error.jsp");
	// }
	// }

	// private void updateUserProfile(HttpServletRequest request,
	// HttpServletResponse response)
	// throws ServletException, IOException {
	// String userIdParam = request.getParameter("user_id");
	//
	// if (userIdParam != null && !userIdParam.isEmpty()) {
	// int userId = Integer.parseInt(userIdParam);
	// String fname = request.getParameter("fname");
	// String lname = request.getParameter("lname");
	// String username = request.getParameter("username");
	// String password = request.getParameter("password");
	//
	// User updatedUser = new User(userId, fname, lname, username, password);
	//
	// boolean updated = DbUtil.updateUserProfile(updatedUser);
	//
	// if (updated) {
	// response.sendRedirect("/success.jsp");
	// } else {
	// response.sendRedirect("error.jsp");
	// }
	// } else {
	// // Handle the case where 'user_id' is missing or empty
	// response.sendRedirect("error.jsp");
	// }
	// }

	private void showUserAccounts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("user_id"));

		List<Account> accounts = DbUtil.getUserAccounts(userId);
		System.out.println(accounts);
		request.setAttribute("accounts", accounts);

		request.getRequestDispatcher("/ShowAccounts.jsp").forward(request, response);
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

	private void showAdminDashboard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String adminUsername = (String) request.getSession().getAttribute("username");
		if (adminUsername != null) {
			List<Transaction> adminTransactions = DbUtil.getAdminTransactions(adminUsername);
			request.setAttribute("adminTransactions", adminTransactions);
			request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
		} else {

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
