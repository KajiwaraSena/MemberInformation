package jp.co.aforce.servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jp.co.aforce.object.AccountInfo;

public class AccountDao1 {
	
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
	public ArrayList<AccountInfo> selectAll(){
		Connection con = null;
		Statement smt = null;
		
		ArrayList<AccountInfo> list = new ArrayList<AccountInfo>();
		
		String sql = "SELECT * FROM customer_tb";
		
		try {
			con = getConnection();
			smt = con.createStatement();
			
			ResultSet rs = smt.executeQuery(sql);
			
			while(rs.next()) {
				AccountInfo accountinfo =new AccountInfo();
				 accountinfo.setAdmin_id(rs.getString("admin_id"));
				 accountinfo.setName(rs.getString("name"));
				 accountinfo.setAddress(rs.getString("address"));
				 list.add(accountinfo);
			}
			
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
		return list;
		}
	}
	
