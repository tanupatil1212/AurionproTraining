package com.aurionpro.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;

import com.aurionpro.model.Student;

public class StudentDbUtil {

	private DataSource dataSource;

	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<Student> getAllStudnts() throws SQLException {
		List<Student> students = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		try {

			conn = dataSource.getConnection();
			String sql = "select * from students";
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);

			while (result.next()) {
				int id = result.getInt("id");
				String firstname = result.getString("first_name");
				String lastname = result.getString("last_name");
				String email = result.getString("email");
				Student tempStudent = new Student(id, firstname, lastname, email);

				students.add(tempStudent);
			}
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, result);

		}
		return students;
	}

	private void close(Connection conn, Statement stmt, ResultSet result) throws SQLException {
		if (conn != null) {
			conn.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (result != null) {
			result.close();
		}

	}

	public void addNewStudent(Student stud) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = dataSource.getConnection();
			String sql = "insert into students (first_name,last_name,email) values (?,?,?)";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, stud.getFirst_name());
			stmt.setString(2, stud.getLast_name());
			stmt.setString(3, stud.getEmail());
			stmt.execute();
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			close(conn, stmt, null);

		}

	}

	public Student getStudentbyId(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		Student tempStudent = null;
		try {

			conn = dataSource.getConnection();
			String sql = "SELECT * FROM students where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			result = stmt.executeQuery();

			if (result.next()) {
				String firstname = result.getString("first_name");
				String lastname = result.getString("last_name");
				String email = result.getString("email");
				tempStudent = new Student(id, firstname, lastname, email);

			}
			return tempStudent;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, result);

		}
		return tempStudent;
	}

	public void updateStudent(Student stud) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
				try {

			conn = dataSource.getConnection();
			String sql = "update students set first_name=?,last_name=?,email=?where id=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, stud.getFirst_name());
			stmt.setString(2, stud.getLast_name());
			stmt.setString(3, stud.getEmail());
			stmt.setInt(4, stud.getId());
			stmt.execute();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);

		}
	}

	public void deleteStudent(int id) throws SQLException {
		 Connection conn = null;
		    PreparedStatement stmt = null;

		    try {
		        conn = dataSource.getConnection();
		        String sql = "DELETE FROM students WHERE id=?";
		        stmt = conn.prepareStatement(sql);
		        stmt.setInt(1, id);
		        stmt.executeUpdate();
		    } finally {
		        close(conn, stmt, null);
		    }
		
	}

	public List<Student> searchStudentsByFirstName(String searchValue) throws SQLException {
	    List<Student> students = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet result = null;
	    
	    try {
	        conn = dataSource.getConnection();
	        String sql = "SELECT * FROM students WHERE first_name = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, searchValue);

	        result = stmt.executeQuery();

	        while (result.next()) {
	            int studentId = result.getInt("id");
	            String firstname = result.getString("first_name");
	            String lastname = result.getString("last_name");
	            String email = result.getString("email");
	            Student tempStudent = new Student(studentId, firstname, lastname, email);
	            students.add(tempStudent);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(conn, stmt, result);
	    }
	    return students;
	}

	public List<Student> searchStudentsByLastName(String searchValue) throws SQLException {
	    List<Student> students = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet result = null;
	    
	    try {
	        conn = dataSource.getConnection();
	        String sql = "SELECT * FROM students WHERE last_name = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, searchValue);
	        result = stmt.executeQuery();

	        while (result.next()) {
	            int id = result.getInt("id");
	            String firstname = result.getString("first_name");
	            String lastname = result.getString("last_name");
	            String email = result.getString("email");
	            Student tempStudent = new Student(id, firstname, lastname, email);
	            students.add(tempStudent);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(conn, stmt, result);
	    }
	    return students;
	}

	public List<Student> searchStudentsByEmail(String searchValue) throws SQLException {
	    List<Student> students = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet result = null;
	    
	    try {
	        conn = dataSource.getConnection();
	        String sql = "SELECT * FROM students WHERE email = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, searchValue);
	        result = stmt.executeQuery();

	        while (result.next()) {
	            int id = result.getInt("id");
	            String firstname = result.getString("first_name");
	            String lastname = result.getString("last_name");
	            String email = result.getString("email");
	            Student tempStudent = new Student(id, firstname, lastname, email);
	            students.add(tempStudent);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(conn, stmt, result);
	    }
	    return students;
	}

	public List<Student> searchStudentsById(int id) throws SQLException {
	    List<Student> students = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet result = null;

	    try {
	        conn = dataSource.getConnection();
	        String sql = "SELECT * FROM students WHERE id = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, id);
	        result = stmt.executeQuery();

	        while (result.next()) {
	            int studentId = result.getInt("id");
	            String firstname = result.getString("first_name");
	            String lastname = result.getString("last_name");
	            String email = result.getString("email");
	            Student tempStudent = new Student(studentId, firstname, lastname, email);
	            students.add(tempStudent);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(conn, stmt, result);
	    }
	    return students;
	}

	
}
