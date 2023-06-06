package jp.co.aforce.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jp.co.aforce.object.AccountInfo;

public class AccountDao4 {
//	private static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
//	private static String URL = "jdbc:mysql://localhost:3306/member_information";
//	private static String USER = "root";
//	private static String PASS = "Kaziwara926";
			
			static DataSource ds;
			public static Connection getConnection() throws Exception{
				try {
					InitialContext ic = new InitialContext();
					ds = (DataSource)ic.lookup("java:/comp/env/jdbc/member_information");
				}catch(Exception e) {
					throw new IllegalStateException(e);
				}
				return ds.getConnection();
	}
	
	public int insert(AccountInfo accountinfo) {
		Connection con = null;
		Statement smt = null;
		
		int count = 0;
		
		String sql = "INSERT INTO customer_tb VALUES('"
					+ accountinfo.getAdmin_id() + "','"
					+ accountinfo.getName() + "','"
					+ accountinfo.getAddress() + "')";
					
		try {
			con = getConnection();
			smt = con.createStatement();
			
			count = smt.executeUpdate(sql);
		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			if(smt != null) {
				try {smt.close();}catch(SQLException ignore) {}
			}
			if(con != null) {
				try {con.close();}catch(SQLException ignore) {}
			}
		}
		return count;
	}
}

