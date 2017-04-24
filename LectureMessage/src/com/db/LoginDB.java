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
			String sql = "SELECT * FROM user_info WHERE username= '"+username+"' AND password= '"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			System.err.println("��¼ʱ���ִ���:"+e.getMessage());
			return false;
		}finally{
			db.CloseConn();
		}
	}
}
