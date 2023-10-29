package com.aurionpro.controller;

import java.io.IOException;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.aurionpro.jdbc.EmployeeDbUtil;
import com.aurionpro.model.Employee;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/employee-source")
	private DataSource datasource;
	private EmployeeDbUtil DbUtil;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		DbUtil = new EmployeeDbUtil(datasource);

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
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
			command = "list";
		}
		switch (command) {
		case "list":

			try {
				listEmployee(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "add":

			try {
				addEmployee(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "update":

			try {
				updateEmployee(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "update-save":
			afterUpdateEmployee(request, response);
			
			break;
		case "delete":
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				deleteEmployee(request, response, id);
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			}
			break;
		case "search":
			searchEmployees(request, response);
			break;	
		default:
			listEmployee(request, response);
		}
	}

	private void searchEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchParameter = request.getParameter("searchParameter");
		String searchValue = request.getParameter("searchValue");

		List<Employee> employeelist = new ArrayList<>();

		if (searchParameter != null && !searchValue.isEmpty()) {
			switch (searchParameter) {
			case "id":
				try {
					int id = Integer.parseInt(searchValue);
					employeelist = DbUtil.searchEmployeeById(id);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				break;
			case "EmpId":
				employeelist =DbUtil.searchEmployeeByEmpID(searchValue);
				break;
			case "firstName":
				employeelist = DbUtil.searchEmployeeByFirstName(searchValue);
				break;
			case "lastName":
				employeelist = DbUtil.searchEmployeeByLastName(searchValue);
				break;
			case "email":
				employeelist = DbUtil.searchEmployeeByEmail(searchValue);
				break;
			case "DOJ":
				employeelist = DbUtil.searchEmployeeByDOJ(searchValue);
				break;
			case "DOB":
				employeelist = DbUtil.searchEmployeeByDOB(searchValue);
				break;
			case "ELD":
				employeelist = DbUtil.searchEmployeeByELD(searchValue);
				break;	
			default:
				listEmployee(request, response);
				break;
			}
		} else {
			employeelist = DbUtil.getAllEmployee();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employee.jsp");
		request.setAttribute("allEmp", employeelist);
		dispatcher.forward(request, response);
		
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		DbUtil.deleteEmployee(id);
		listEmployee(request, response);
		
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("id"));
	    Employee employee = DbUtil.getEmployeebyId(id);
	    request.setAttribute("employee", employee); 
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/update-employee.jsp");
	    dispatcher.forward(request, response);
	}

	private void afterUpdateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("id");
		String empIDParam = request.getParameter("Emplid");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String dojParam = request.getParameter("DoJ");
		String dobParam = request.getParameter("DOB");
		String eldParam = request.getParameter("ELD");

		
		if (idParam != null && !idParam.isEmpty() && empIDParam != null && !empIDParam.isEmpty() && firstName != null
				&& !firstName.isEmpty() && lastName != null && !lastName.isEmpty() && email != null && !email.isEmpty()
				&& dojParam != null && !dojParam.isEmpty() && dobParam != null && !dobParam.isEmpty()
				&& eldParam != null && !eldParam.isEmpty()) {

			try {
				int id = Integer.parseInt(idParam);
				int empID = Integer.parseInt(empIDParam);

				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date doj = new Date(dateFormat.parse(dojParam).getTime());
				Date dob = new Date(dateFormat.parse(dobParam).getTime());
				Date eld = new Date(dateFormat.parse(eldParam).getTime());

				Employee emp = new Employee(id, empID, firstName, lastName, email, doj, dob, eld);
				DbUtil.updateEmployee(emp);

				response.sendRedirect(request.getContextPath() + "/EmployeeController?action=list");

			} catch (NumberFormatException | java.text.ParseException e) {
			    e.printStackTrace();
			    request.setAttribute("error", "Invalid input. Please check date formats or integer fields: " + e.getMessage());
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/update-employee.jsp");
			    dispatcher.forward(request, response);
			}

		} else {
			
			request.setAttribute("error", "Missing or empty parameters.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/update-employee.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, IOException, ServletException {
		int emp_ID = Integer.parseInt(request.getParameter("Emplid"));
		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String email = request.getParameter("email");
		String DOJ = request.getParameter("DoJ");
		String birthDate = request.getParameter("DOB");
		String ELD = request.getParameter("ELD"); 
		Date doj = null;
		Date dob = null;
		Date eld = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (DOJ != null && !DOJ.isEmpty()) {
				doj = new Date(dateFormat.parse(DOJ).getTime());
			}

			if (birthDate != null && !birthDate.isEmpty()) {
				dob = new Date(dateFormat.parse(birthDate).getTime());
			}

			if (ELD != null && !ELD.isEmpty()) { // Parse ELD
				eld = new Date(dateFormat.parse(ELD).getTime());
			}
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		if (doj != null && dob != null && eld != null && is18YearsOrOlder(dob)) {
			Employee emp = new Employee(emp_ID, first_name, last_name, email, doj, dob, eld);
			DbUtil.AddEmployesList(emp);
			response.sendRedirect(request.getContextPath() + "/EmployeeController");
		} else {
			request.setAttribute("error", "Invalid Date of Birth, Date of Joining, or Employee Leaving Date.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/add-employee.jsp");
			dispatcher.forward(request, response);
		}
	}

	private boolean is18YearsOrOlder(Date dob) {
		Date currentDate = new Date(System.currentTimeMillis());
		long ageInMillis = currentDate.getTime() - dob.getTime();
		int ageInYears = (int) (ageInMillis / (365L * 24 * 60 * 60 * 1000));
		return ageInYears >= 18;
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> employeelist = DbUtil.getAllEmployee();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employee.jsp");
		request.setAttribute("allEmp", employeelist);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
