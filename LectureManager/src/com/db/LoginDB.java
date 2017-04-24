package com.db;


import java.sql.*;
import com.core.DBconnect;

public class LoginDB {
	public boolean checkLogin(String username , String password)
	{
		Connection conn;
		DBconnect db = new DBconnect();
		conn = db.init();
		
		try{
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM manager_info WHERE username= '"+username+"' AND password= '"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			System.err.println("登录验证时出现错误:"+e.getMessage());
			return false;
		}
	}
}
