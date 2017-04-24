package com.db;

import com.core.DBconnect;
import java.sql.*;

public class ReleaseLectureDB {
	
	public boolean releaseLecture(String theme , String author , String date , String time , String details)
	{
		Connection conn;
		PreparedStatement pstate;
		DBconnect db = new DBconnect();
		
		try{
			conn = db.init();
			String sql="INSERT INTO lecture_message(theme , start_date , start_time , author , details , due_num) VALUES (?,?,?,?,?,?)";
			pstate = conn.prepareStatement(sql);
			
			
			System.out.println(author);
			
			pstate.setString(1, theme);
			pstate.setString(2, date);
			pstate.setString(3, time);
			pstate.setString(4, author);
			pstate.setString(5, details);
			pstate.setInt(6, 0);
			
			int n = 0;
			n = pstate.executeUpdate();
			if(n>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}catch(Exception e){
			System.err.println("发布信息时出错:"+e.getMessage());
			return false;
		}finally{
			db.CloseConn();
		}
	}

}
