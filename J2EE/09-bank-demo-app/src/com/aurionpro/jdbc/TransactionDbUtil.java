package com.aurionpro.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.aurionpro.model.Transaction;

public class TransactionDbUtil {
	private static DataSource dataSource;

	public TransactionDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	// public static void deposit(int accountNo, BigDecimal amount) {
	// Connection conn = null;
	// PreparedStatement pstmt = null;
	//
	// try {
	// conn = dataSource.getConnection();
	// conn.setAutoCommit(false); // Start a transaction
	//
	// // Create a SQL query to update the account balance by depositing the
	// specified amount
	// String sql = "UPDATE accounts SET amount = amount + ? WHERE accountno = ?";
	//
	// pstmt = conn.prepareStatement(sql);
	// pstmt.setBigDecimal(1, amount);
	// pstmt.setInt(2, accountNo);
	//
	// // Execute the update query
	// pstmt.executeUpdate();
	//
	// // Commit the transaction
	// conn.commit();
	// } catch (SQLException e) {
	// // Handle exceptions, for example, by rolling back the transaction
	// try {
	// if (conn != null) {
	// conn.rollback();
	// }
	// } catch (SQLException rollbackException) {
	// rollbackException.printStackTrace();
	// }
	// e.printStackTrace();
	// } finally {
	// // Close resources and set auto-commit to true
	// try {
	// if (pstmt != null) {
	// pstmt.close();
	// }
	// if (conn != null) {
	// conn.setAutoCommit(true); // Set auto-commit back to true
	// conn.close();
	// }
	// } catch (SQLException closeException) {
	// closeException.printStackTrace();
	// }
	// }
	// }

	public static void deposit(int accountNo, BigDecimal amount) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false); 

		
			String sql = "UPDATE accounts SET amount = amount + ? WHERE accountno = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setBigDecimal(1, amount);
			pstmt.setInt(2, accountNo);

		
			pstmt.executeUpdate();

		
			conn.commit();

		
			String insertTransactionSql = "INSERT INTO transactions (account_no, transaction_type_id, transaction_time, description, amount) VALUES (?, ?, NOW(), ?, ?)";
			pstmt = conn.prepareStatement(insertTransactionSql);
			pstmt.setInt(1, accountNo);
			pstmt.setInt(2, 1); 
			pstmt.setString(3, "Deposit");
			pstmt.setBigDecimal(4, amount);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException rollbackException) {
				rollbackException.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.setAutoCommit(true); 
					conn.close();
				}
			} catch (SQLException closeException) {
				closeException.printStackTrace();
			}
		}
	}

	public static void transfer(int fromAccountNo, int toAccountNo, BigDecimal amount) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();

			
			String debitSql = "UPDATE accounts SET balance = balance - ? WHERE accountno = ?";
			String creditSql = "UPDATE accounts SET balance = balance + ? WHERE accountno = ?";

		
			conn.setAutoCommit(false);

			
			pstmt = conn.prepareStatement(debitSql);
			pstmt.setBigDecimal(1, amount);
			pstmt.setInt(2, fromAccountNo);
			pstmt.executeUpdate();

			
			pstmt = conn.prepareStatement(creditSql);
			pstmt.setBigDecimal(1, amount);
			pstmt.setInt(2, toAccountNo);
			pstmt.executeUpdate();

			
			conn.commit();
		} catch (SQLException e) {
			
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException rollbackException) {
				rollbackException.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.setAutoCommit(true); 
					conn.close();
				}
			} catch (SQLException closeException) {
				closeException.printStackTrace();
			}
		}
	}

	// public static void withdraw(int accountNo, BigDecimal amount) {
	// Connection conn = null;
	// PreparedStatement pstmt = null;
	//
	// try {
	// conn = dataSource.getConnection();
	// conn.setAutoCommit(false); // Start a transaction
	//
	// // Create a SQL query to update the account balance by withdrawing the
	// specified amount
	// // Create a SQL query to update the account balance by withdrawing the
	// specified amount
	// String sql = "UPDATE accounts SET amount = amount - ? WHERE accountno = ?";
	//
	//
	// pstmt = conn.prepareStatement(sql);
	// pstmt.setBigDecimal(1, amount);
	// pstmt.setInt(2, accountNo);
	//
	// // Execute the update query
	// pstmt.executeUpdate();
	//
	// // Commit the transaction
	// conn.commit();
	// } catch (SQLException e) {
	// // Handle exceptions, for example, by rolling back the transaction
	// try {
	// if (conn != null) {
	// conn.rollback();
	// }
	// } catch (SQLException rollbackException) {
	// rollbackException.printStackTrace();
	// }
	// e.printStackTrace();
	// } finally {
	// // Close resources and set auto-commit to true
	// try {
	// if (pstmt != null) {
	// pstmt.close();
	// }
	// if (conn != null) {
	// conn.setAutoCommit(true); // Set auto-commit back to true
	// conn.close();
	// }
	// } catch (SQLException closeException) {
	// closeException.printStackTrace();
	// }
	// }
	// }

	public static void withdraw(int accountNo, BigDecimal amount) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false); 

			
			String sql = "UPDATE accounts SET amount = amount - ? WHERE accountno = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setBigDecimal(1, amount);
			pstmt.setInt(2, accountNo);

			pstmt.executeUpdate();

	
			conn.commit();

			String insertTransactionSql = "INSERT INTO transactions (account_no, transaction_type_id, transaction_time, description, amount) VALUES (?, ?, NOW(), ?, ?)";
			pstmt = conn.prepareStatement(insertTransactionSql);
			pstmt.setInt(1, accountNo);
			pstmt.setInt(2, 2);
			pstmt.setString(3, "Withdrawal");
			pstmt.setBigDecimal(4, amount);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException rollbackException) {
				rollbackException.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.setAutoCommit(true); 
					conn.close();
				}
			} catch (SQLException closeException) {
				closeException.printStackTrace();
			}
		}
	}

	public static List<Transaction> getUserTransactionsbyUserSide(int userId) {
		List<Transaction> transactionss = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT transactions.trans_id, transactions.account_no, transactions.transaction_type_id, transactions.transaction_time, transactions.description, transactions.amount\r\n" + 
					"FROM transactions\r\n" + 
					"INNER JOIN accounts ON transactions.account_no = accounts.accountno\r\n" + 
					"INNER JOIN users ON accounts.userid = users.user_id\r\n" + 
					"WHERE users.user_id = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId); 
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int trans_id = rs.getInt("trans_id");
				int transaction_type_id = rs.getInt("transaction_type_id");
				Timestamp transaction_time = rs.getTimestamp("transaction_time");
				String description = rs.getString("description");
				BigDecimal amount = rs.getBigDecimal("amount");
				int account_no = rs.getInt("account_no"); 

				Transaction transactions = new Transaction(trans_id, account_no, transaction_type_id, transaction_time,
						description, amount);
				transactionss.add(transactions);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return transactionss;
	}

}
