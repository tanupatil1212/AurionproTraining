package com.aurionpro.jdbc;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import com.aurionpro.model.Employee;


public class EmployeeDbUtil {
	private DataSource dataSource;

	public EmployeeDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<Employee> getAllEmployee() {
		List<Employee> employees = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT id, emp_ID, first_name, last_name, email, DOJ, birthDate, ELD FROM Employee";

			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);

			while (result.next()) {
				int id = result.getInt("id");
				int emp_ID = result.getInt("emp_ID");
				String first_name = result.getString("first_name");
				String last_name = result.getString("last_name");
				String email = result.getString("email");
				Date DOJ = result.getDate("DOJ");
				Date birthDate = result.getDate("birthDate");
				Date ELD = result.getDate("ELD"); 

				Employee tempEmployee = new Employee(id, emp_ID, first_name, last_name, email, DOJ, birthDate, ELD);
				tempEmployee.setELD(ELD); 
				employees.add(tempEmployee);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return employees;
	}

	public void AddEmployesList(Employee emp) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO Employee (emp_ID, first_name, last_name, email, DOJ, birthDate, ELD) VALUES (?, ?, ?, ?, ?, ?, ?)";

			stmt = conn.prepareStatement(sql);

			
			stmt.setInt(1, emp.getEmp_ID());
			stmt.setString(2, emp.getFirst_name());
			stmt.setString(3, emp.getLast_name());
			stmt.setString(4, emp.getEmail());
			stmt.setDate(5, new java.sql.Date(emp.getDOJ().getTime()));
			stmt.setDate(6, new java.sql.Date(emp.getBirthDate().getTime()));
			stmt.setDate(7, new java.sql.Date(emp.getELD().getTime())); // Add ELD parameter

			
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				
				System.out.println("Employee added successfully.");
			} else {
				
				System.err.println("Failed to add employee.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error while adding employee: " + e.getMessage());
		} finally {
			
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Employee getEmployeebyId(int id) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet result = null;
	    Employee tempEmployee = null;
	    
	    try {
	        conn = dataSource.getConnection();
	        String sql = "SELECT emp_ID, first_name, last_name, email, DOJ, birthDate, ELD FROM employee where id=?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, id);
	        result = stmt.executeQuery();
	        
	        if (result.next()) {
	            int emp_ID = result.getInt("emp_ID");
	            String first_name = result.getString("first_name");
	            String last_name = result.getString("last_name");
	            String email = result.getString("email");
	            Date DOJ = result.getDate("DOJ");
	            Date BirthDate = result.getDate("birthDate");
	            Date ELD = result.getDate("ELD");
	            
	            tempEmployee = new Employee(id, emp_ID, first_name, last_name, email, DOJ, BirthDate, ELD);
	        }
	        return tempEmployee;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return tempEmployee;
	}


	

	public void updateEmployee(Employee employee) {
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        conn = dataSource.getConnection();
	        String sql = "UPDATE Employee SET first_name=?, last_name=?, email=?, DOJ=?, birthDate=?, ELD=? WHERE emp_ID=?";


	        stmt = conn.prepareStatement(sql);

	        
	        stmt.setString(1, employee.getFirst_name());
	        stmt.setString(2, employee.getLast_name());
	        stmt.setString(3, employee.getEmail());
	        stmt.setDate(4, new java.sql.Date(employee.getDOJ().getTime()));
	        stmt.setDate(5, new java.sql.Date(employee.getBirthDate().getTime()));
	        stmt.setDate(6, new java.sql.Date(employee.getELD().getTime()));
	        stmt.setInt(7, employee.getEmp_ID()); // Use emp_ID in the WHERE clause
	        
	        
	        int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            // Data updated successfully
	            System.out.println("Employee updated successfully.");
	        } else {
	            // Data update failed
	            System.err.println("Failed to update employee.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.err.println("Error while updating employee: " + e.getMessage());
	    } finally {
	        
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public void deleteEmployee(int id) {
		 Connection conn = null;
		    PreparedStatement stmt = null;

		    try {
		        conn = dataSource.getConnection();
		        String sql = "DELETE FROM Employee WHERE id=?";
		        stmt = conn.prepareStatement(sql);
		        stmt.setInt(1, id);
		        stmt.executeUpdate();
		    }catch (Exception e) {
				// TODO: handle exception
			}
		
	}

	public List<Employee> searchEmployeeById(int id) {
		List<Employee> employee = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet result = null;

	    try {
	        conn = dataSource.getConnection();
	        String sql = "SELECT * FROM Employee WHERE id = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, id);
	        result = stmt.executeQuery();

	        while (result.next()) {
	            int employeeid = result.getInt("id");
	            int emp_ID = result.getInt("emp_ID");
	            
	            String first_name = result.getString("first_name");
	            String last_name = result.getString("last_name");
	            String email = result.getString("email");
	            Date DOJ = result.getDate("DOJ");
	            Date BirthDate = result.getDate("BirthDate");
	            Date ELD = result.getDate("BirthDate");
	            
	            
	            
	            Employee tempEmployee = new Employee(employeeid, emp_ID, first_name, last_name, email, DOJ, BirthDate, ELD);
	            employee.add(tempEmployee);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(conn, stmt, result);
	    }
	    return employee;
	}

	private void close(Connection conn, PreparedStatement stmt, ResultSet result) {
		// TODO Auto-generated method stub
		
	}

	

	public List<Employee> searchEmployeeByEmpID(String searchValue) {
		List<Employee> employee = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet result = null;

	    try {
	        conn = dataSource.getConnection();
	        String sql = "SELECT * FROM Employee WHERE emp_ID = ?";
	        stmt = conn.prepareStatement(sql);
	        int emp_Id = Integer.parseInt(searchValue);
	        stmt.setInt(1, emp_Id);
	        result = stmt.executeQuery();

	        while (result.next()) {
	            int employeeid = result.getInt("id");
	            int emp_ID = result.getInt("emp_ID");
	            
	            String first_name = result.getString("first_name");
	            String last_name = result.getString("last_name");
	            String email = result.getString("email");
	            Date DOJ = result.getDate("DOJ");
	            Date BirthDate = result.getDate("BirthDate");
	            Date ELD = result.getDate("BirthDate");
	            
	            
	            
	            Employee tempEmployee = new Employee(employeeid, emp_ID, first_name, last_name, email, DOJ, BirthDate, ELD);
	            employee.add(tempEmployee);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(conn, stmt, result);
	    }
	    return employee;
	}

	public List<Employee> searchEmployeeByFirstName(String searchValue) {
	    List<Employee> employeeList = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet result = null;

	    try {
	        conn = dataSource.getConnection();
	        String sql = "SELECT * FROM Employee WHERE first_name LIKE ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, "%" + searchValue + "%");
	        result = stmt.executeQuery();

	        while (result.next()) {
	            int employeeId = result.getInt("id");
	            int emp_ID = result.getInt("emp_ID");
	            String first_name = result.getString("first_name");
	            String last_name = result.getString("last_name");
	            String email = result.getString("email");
	            Date DOJ = result.getDate("DOJ");
	            Date BirthDate = result.getDate("BirthDate");
	            Date ELD = result.getDate("BirthDate");

	            Employee tempEmployee = new Employee(employeeId, emp_ID, first_name, last_name, email, DOJ, BirthDate, ELD);
	            employeeList.add(tempEmployee);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(conn, stmt, result);
	    }
	    return employeeList;
	}

	public List<Employee> searchEmployeeByLastName(String searchValue) {
		 List<Employee> employeeList = new ArrayList<>();
		    Connection conn = null;
		    PreparedStatement stmt = null;
		    ResultSet result = null;

		    try {
		        conn = dataSource.getConnection();
		        String sql = "SELECT * FROM Employee WHERE last_name LIKE ?";
		        stmt = conn.prepareStatement(sql);
		        stmt.setString(1, "%" + searchValue + "%");
		        result = stmt.executeQuery();

		        while (result.next()) {
		            int employeeId = result.getInt("id");
		            int emp_ID = result.getInt("emp_ID");
		            String first_name = result.getString("first_name");
		            String last_name = result.getString("last_name");
		            String email = result.getString("email");
		            Date DOJ = result.getDate("DOJ");
		            Date BirthDate = result.getDate("BirthDate");
		            Date ELD = result.getDate("BirthDate");

		            Employee tempEmployee = new Employee(employeeId, emp_ID, first_name, last_name, email, DOJ, BirthDate, ELD);
		            employeeList.add(tempEmployee);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        close(conn, stmt, result);
		    }
		    return employeeList;
	}

	public List<Employee> searchEmployeeByEmail(String searchValue) {
		 List<Employee> employeeList = new ArrayList<>();
		    Connection conn = null;
		    PreparedStatement stmt = null;
		    ResultSet result = null;

		    try {
		        conn = dataSource.getConnection();
		        String sql = "SELECT * FROM Employee WHERE email LIKE ?";
		        stmt = conn.prepareStatement(sql);
		        stmt.setString(1, "%" + searchValue + "%");
		        result = stmt.executeQuery();

		        while (result.next()) {
		            int employeeId = result.getInt("id");
		            int emp_ID = result.getInt("emp_ID");
		            String first_name = result.getString("first_name");
		            String last_name = result.getString("last_name");
		            String email = result.getString("email");
		            Date DOJ = result.getDate("DOJ");
		            Date BirthDate = result.getDate("BirthDate");
		            Date ELD = result.getDate("BirthDate");

		            Employee tempEmployee = new Employee(employeeId, emp_ID, first_name, last_name, email, DOJ, BirthDate, ELD);
		            employeeList.add(tempEmployee);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        close(conn, stmt, result);
		    }
		    return employeeList;
	}

	public List<Employee> searchEmployeeByDOJ(String searchValue) {
	    List<Employee> employeeList = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet result = null;

	    try {
	        conn = dataSource.getConnection();
	        String sql = "SELECT * FROM Employee WHERE DOJ = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setDate(1, java.sql.Date.valueOf(searchValue)); // Assuming searchValue is a date string in "yyyy-MM-dd" format
	        result = stmt.executeQuery();

	        while (result.next()) {
	            int employeeId = result.getInt("id");
	            int emp_ID = result.getInt("emp_ID");
	            String first_name = result.getString("first_name");
	            String last_name = result.getString("last_name");
	            String email = result.getString("email");
	            Date DOJ = result.getDate("DOJ");
	            Date BirthDate = result.getDate("BirthDate");
	            Date ELD = result.getDate("BirthDate");

	            Employee tempEmployee = new Employee(employeeId, emp_ID, first_name, last_name, email, DOJ, BirthDate, ELD);
	            employeeList.add(tempEmployee);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(conn, stmt, result);
	    }
	    return employeeList;
	}


	public List<Employee> searchEmployeeByDOB(String searchValue) {
		
		    List<Employee> employeeList = new ArrayList<>();
		    Connection conn = null;
		    PreparedStatement stmt = null;
		    ResultSet result = null;

		    try {
		        conn = dataSource.getConnection();
		        String sql = "SELECT * FROM Employee WHERE birthDate = ?";
		        stmt = conn.prepareStatement(sql);
		        stmt.setDate(1, java.sql.Date.valueOf(searchValue)); // Assuming searchValue is a date string in "yyyy-MM-dd" format
		        result = stmt.executeQuery();

		        while (result.next()) {
		            int employeeId = result.getInt("id");
		            int emp_ID = result.getInt("emp_ID");
		            String first_name = result.getString("first_name");
		            String last_name = result.getString("last_name");
		            String email = result.getString("email");
		            Date DOJ = result.getDate("DOJ");
		            Date BirthDate = result.getDate("BirthDate");
		            Date ELD = result.getDate("BirthDate");

		            Employee tempEmployee = new Employee(employeeId, emp_ID, first_name, last_name, email, DOJ, BirthDate, ELD);
		            employeeList.add(tempEmployee);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        close(conn, stmt, result);
		    }
		    return employeeList;
		}

	

	public List<Employee> searchEmployeeByELD(String searchValue) {
		
		    List<Employee> employeeList = new ArrayList<>();
		    Connection conn = null;
		    PreparedStatement stmt = null;
		    ResultSet result = null;

		    try {
		        conn = dataSource.getConnection();
		        String sql = "SELECT * FROM Employee WHERE ELD = ?";
		        stmt = conn.prepareStatement(sql);
		        stmt.setDate(1, java.sql.Date.valueOf(searchValue)); // Assuming searchValue is a date string in "yyyy-MM-dd" format
		        result = stmt.executeQuery();

		        while (result.next()) {
		            int employeeId = result.getInt("id");
		            int emp_ID = result.getInt("emp_ID");
		            String first_name = result.getString("first_name");
		            String last_name = result.getString("last_name");
		            String email = result.getString("email");
		            Date DOJ = result.getDate("DOJ");
		            Date BirthDate = result.getDate("BirthDate");
		            Date ELD = result.getDate("BirthDate");

		            Employee tempEmployee = new Employee(employeeId, emp_ID, first_name, last_name, email, DOJ, BirthDate, ELD);
		            employeeList.add(tempEmployee);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        close(conn, stmt, result);
		    }
		    return employeeList;
		}

	}



