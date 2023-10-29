package com.aurionpro.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.aurionpro.jdbc.TransactionDbUtil;
import com.aurionpro.model.Transaction;

/**
 * Servlet implementation class TransactionController
 */
@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/bank-source")
	private DataSource datasource;
	private TransactionDbUtil DbUtil;

	@Override
	public void init() throws ServletException {

		super.init();
		DbUtil = new TransactionDbUtil(datasource);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		int accountNo = Integer.parseInt(request.getParameter("accountNo"));
		BigDecimal amount = new BigDecimal(request.getParameter("amount"));

		if ("deposit".equals(action)) {
			
			TransactionDbUtil.deposit(accountNo, amount);
		} else if ("withdraw".equals(action)) {
			
			TransactionDbUtil.withdraw(accountNo, amount);
		}

		request.getRequestDispatcher("success.jsp").forward(request, response);
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
