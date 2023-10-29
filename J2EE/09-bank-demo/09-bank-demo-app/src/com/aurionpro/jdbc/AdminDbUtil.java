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

import com.aurionpro.model.Account;
import com.aurionpro.model.Transaction;
import com.aurionpro.model.User;

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

	public List<Transaction> getAdminTransactions(String adminUsername) {
		List<Transaction> transactions = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT t.trans_id, t.account_no, t.transaction_type_id, t.transaction_time, "
					+ "t.description, t.amount FROM transactions t " + "JOIN accounts a ON t.account_no = a.accountno "
					+ "JOIN users u ON a.userid = u.user_id " + "WHERE u.username = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminUsername);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int transactionId = rs.getInt("trans_id");
				int accountNo = rs.getInt("account_no");
				int transactionTypeId = rs.getInt("transaction_type_id");
				Timestamp transactionTime = rs.getTimestamp("transaction_time");
				String description = rs.getString("description");
				BigDecimal amount = rs.getBigDecimal("amount");

				Transaction transaction = new Transaction(transactionId, accountNo, transactionTypeId, transactionTime,
						description, amount);
				transactions.add(transaction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}

		return transactions;
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT user_id, fname, lname, username, password FROM users";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int user_id = rs.getInt("user_id");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String username = rs.getString("username");
				String password = rs.getString("password");

				User user = new User(user_id, fname, lname, username, password); 
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}

		return users;
	}

	public boolean createUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean userCreated = false;

		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO users (fname, lname, username, password) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getFname());
			pstmt.setString(2, user.getLname());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				userCreated = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close database resources...
		}

		return userCreated;
	}

	public boolean createAccount(int userid, String accountType, BigDecimal amount) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean accountCreated = false;

		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO accounts (accounttype, userid, amount) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, accountType);
			pstmt.setInt(2, userid);
			pstmt.setBigDecimal(3, amount);

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					
					int accountNo = generatedKeys.getInt(1);
					
				}
				accountCreated = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}

		return accountCreated;
	}

	public List<Account> getUserAccounts(int userId) {
	    List<Account> accounts = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = dataSource.getConnection();
	        String sql = "SELECT a.accountno, a.accounttype, a.amount " +
	                     "FROM accounts a " +
	                     "INNER JOIN users u ON a.userid = u.user_id " +
	                     "WHERE u.user_id = ?";

	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, userId);

	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            int accountno = rs.getInt("accountno");
	            String accounttype = rs.getString("accounttype");
	            BigDecimal amount = rs.getBigDecimal("amount");

	            Account account = new Account(accountno, accounttype, amount);
	            accounts.add(account);
	        }

	        System.out.println("Retrieved user accounts: " + accounts);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        
	    }

	    return accounts;
	}

	// public User getUserProfile(int userId) {
	// Connection conn = null;
	// PreparedStatement pstmt = null;
	// ResultSet rs = null;
	// User user = null;
	//
	// try {
	// conn = dataSource.getConnection();
	// String sql = "SELECT user_id, fname, lname, username, password FROM users
	// WHERE user_id = ?";
	// pstmt = conn.prepareStatement(sql);
	// pstmt.setInt(1, userId);
	// rs = pstmt.executeQuery();
	//
	// if (rs.next()) {
	// String fname = rs.getString("fname");
	// String lname = rs.getString("lname");
	// String username = rs.getString("username");
	// String password = rs.getString("password");
	//
	// user = new User(userId, fname, lname, username, password);
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// // Close database resources
	// // ...
	// }
	//
	// return user;
	// }

	// public boolean updateUserProfile(User updatedUser) {
	// Connection conn = null;
	// PreparedStatement pstmt = null;
	// boolean updated = false;
	//
	// try {
	// conn = dataSource.getConnection();
	// String sql = "UPDATE users SET fname = ?, lname = ?, username = ?, password =
	// ? WHERE user_id = ?";
	// pstmt = conn.prepareStatement(sql);
	// pstmt.setString(1, updatedUser.getFname());
	// pstmt.setString(2, updatedUser.getLname());
	// pstmt.setString(3, updatedUser.getUsername());
	// pstmt.setString(4, updatedUser.getPassword());
	// pstmt.setInt(5, updatedUser.getUser_id());
	//
	// int rowsAffected = pstmt.executeUpdate();
	// if (rowsAffected > 0) {
	// updated = true;
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return updated;
	// }

	public List<Transaction> getTransaction() {
		List<Transaction> transactions = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT trans_id, account_no, transaction_type_id, transaction_time,description,amount  FROM transactions";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int trans_id = rs.getInt("trans_id");
				int transaction_type_id = rs.getInt("transaction_type_id");
				Timestamp transaction_time = rs.getTimestamp("transaction_time");
				String description = rs.getString("description");
				BigDecimal amount = rs.getBigDecimal("amount");
				int account_no = rs.getInt("account_no"); 

				Transaction transaction = new Transaction(trans_id, account_no, transaction_type_id, transaction_time,
						description, amount);
				transactions.add(transaction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}

		return transactions;
	}

	public User getUserById(int userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT user_id, fname, lname, username, password FROM users WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String username = rs.getString("username");
				String password = rs.getString("password");

				user = new User(userId, fname, lname, username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}

		return user;
	}

	public List<User> searchUserByFirstName(String searchValue) {
		List<User> users = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT user_id, fname, lname, username, password FROM users WHERE fname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchValue + "%"); 
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int user_id = rs.getInt("user_id");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String username = rs.getString("username");
				String password = rs.getString("password");

				User user = new User(user_id, fname, lname, username, password);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}

		return users;
	}

	public List<User> searchUserByLastName(String searchValue) {
		List<User> users = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT user_id, fname, lname, username, password FROM users WHERE lname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchValue + "%"); 
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int user_id = rs.getInt("user_id");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String username = rs.getString("username");
				String password = rs.getString("password");

				User user = new User(user_id, fname, lname, username, password);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}

		return users;
	}

	public List<User> searchUserByUsername(String searchValue) {
		List<User> users = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT user_id, fname, lname, username, password FROM users WHERE username LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchValue + "%"); 
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int user_id = rs.getInt("user_id");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String username = rs.getString("username");
				String password = rs.getString("password");

				User user = new User(user_id, fname, lname, username, password);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}

		return users;

	}

	// public List<Transaction> getTransactionsByAccountNo(int accountNo) {
	// List<Transaction> transactions = new ArrayList<>();
	// String sql = "SELECT * FROM transactions WHERE account_no = ?";
	// conn = dataSource.getConnection();
	// pstmt = conn.prepareStatement(sql);
	// preparedStatement.setInt(1, accountNo);
	// try (ResultSet resultSet = preparedStatement.executeQuery()) {
	// while (resultSet.next()) {
	// int transId = resultSet.getInt("trans_id");
	// int transactionTypeId = resultSet.getInt("transaction_type_id");
	// Timestamp transactionTime = resultSet.getTimestamp("transaction_time");
	// String description = resultSet.getString("description");
	// BigDecimal amount = resultSet.getBigDecimal("amount");
	//
	// Transaction transaction = new Transaction(transId, accountNo,
	// transactionTypeId, transactionTime,
	// description, amount);
	// transactions.add(transaction);
	// }
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return transactions;
	// }

	public void updateUser(User updatedUser) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			String sql = "UPDATE users SET fname = ?, lname = ?, username = ?, password = ? WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updatedUser.getFname());
			pstmt.setString(2, updatedUser.getLname());
			pstmt.setString(3, updatedUser.getUsername());
			pstmt.setString(4, updatedUser.getPassword());
			pstmt.setInt(5, updatedUser.getUser_id());

			int rowsAffected = pstmt.executeUpdate();

			
			if (rowsAffected > 0) {
			
			} else {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}

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
