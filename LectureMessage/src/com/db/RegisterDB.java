package com.db;

import java.sql.*;
import com.core.DBconnect;


public class RegisterDB {
	public boolean registerCheck(String username , String email , String password){
		Connection conn;
		PreparedStatement pstate;
		DBconnect db = new DBconnect();
		
		try{
			conn = db.init();
			String sql = "INSERT INTO user_info(username , password , email) VALUES(? , ? , ?)";
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, username);
			pstate.setString(2, password);
			pstate.setString(3, email);
			
			int n = 0;
			n = pstate.executeUpdate();
			
			if(n>0){
				return true;
			}else{
				return false;
			}
			
					
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			db.CloseConn();
		}
		
	}
}
