package com.db;

import com.core.DBconnect;
import java.sql.*;

public class DeleteLectureDB {
	public boolean DeleteMessage(int id)
	{
		Connection conn;
		DBconnect db = new DBconnect();
		conn = db.init();
		try{
			Statement stmt = conn.createStatement();
			String sql="DELETE FROM lecture_message WHERE id='"+id+"'";
			int result = 0;
			result = stmt.executeUpdate(sql);
			if(result > 0)
			{
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			System.err.println("删除信息出现错误:"+e.getMessage());
			return false;
		}
	}
}
