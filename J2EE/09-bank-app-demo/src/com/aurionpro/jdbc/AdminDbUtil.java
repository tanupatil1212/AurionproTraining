package com.aurionpro.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class AdminDbUtil {
	private DataSource dataSource;

	public AdminDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	
	
	public boolean isValidAdmin(String username, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isValid = false;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT id FROM admins WHERE username = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			isValid = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isValid;
	}
	
	public boolean isValidUser(String username, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isValid = false;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT user_id FROM users WHERE username = ? AND password = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			isValid = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return isValid;
	}


	public int getUserId(String username, String password) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int userId = -1; // Initialize to -1 to indicate an invalid user

	    try {
	        conn = dataSource.getConnection();
	        String sql = "SELECT user_id FROM users WHERE username = ? AND password = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, username);
	        pstmt.setString(2, password);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            userId = rs.getInt("user_id");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close database resources...
	    }

	    return userId;
	}
}
