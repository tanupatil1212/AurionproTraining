package com.aurionpro.controller;

import java.io.IOException;

import java.sql.SQLException;
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

import com.aurionpro.jdbc.StudentDbUtil;
import com.aurionpro.model.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/student-source")
	private DataSource datasource;

	private StudentDbUtil dbUtil;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dbUtil = new StudentDbUtil(datasource);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentController() {
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
				listStudent(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "add":
			try {
				addStudent(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println("add operation");
			break;
		case "update":
			try {
				getStudentforUpdate(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// System.out.println("add operation");
			break;
		case "update-save":
			try {
				updateStudent(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "delete":
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				deleteStudent(request, response, id);
			} catch (NumberFormatException e) {
				// Handle invalid ID or other errors
				e.printStackTrace();
			}
			break;

		case "search":
			try {
				searchStudents(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		default:
			try {
				listStudent(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void searchStudents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String searchParameter = request.getParameter("searchParameter");
		String searchValue = request.getParameter("searchValue");

		List<Student> studentList = new ArrayList<>();

		if (searchParameter != null && !searchValue.isEmpty()) {
			switch (searchParameter) {
			case "id":
				try {
					int id = Integer.parseInt(searchValue);
					studentList = dbUtil.searchStudentsById(id);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				break;
			case "firstName":
				studentList = dbUtil.searchStudentsByFirstName(searchValue);
				break;
			case "lastName":
				studentList = dbUtil.searchStudentsByLastName(searchValue);
				break;
			case "email":
				studentList = dbUtil.searchStudentsByEmail(searchValue);
				break;
			default:
				listStudent(request, response);
				break;
			}
		} else {
			studentList = dbUtil.getAllStudnts();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		request.setAttribute("allStud", studentList);
		dispatcher.forward(request, response);
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response, int id)
			throws ServletException, IOException {
		try {
			dbUtil.deleteStudent(id);
			listStudent(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		Student stud = new Student(id, fname, lname, email);
		dbUtil.updateStudent(stud);
		// listStudent(request,response);
		response.sendRedirect(request.getContextPath() + "/StudentController");

	}

	private void getStudentforUpdate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = dbUtil.getStudentbyId(id);
		System.out.println(student);
		request.setAttribute("student", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student.jsp");
		dispatcher.forward(request, response);

	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		Student stud = new Student(fname, lname, email);
		dbUtil.addNewStudent(stud);
		System.out.println(stud);
		// listStudent(request, response);
		response.sendRedirect(request.getContextPath() + "/StudentController");
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Student> studentList = dbUtil.getAllStudnts();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		request.setAttribute("allStud", studentList);
		dispatcher.forward(request, response);

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
