package com.db;

import com.core.DBconnect;
import java.sql.*;

public class OrderCount {
	
	public int Count(int lecture_id)
	{
		Connection conn;
		DBconnect db = new DBconnect();
		conn = db.init();
		try{
			Statement stmt = conn.createStatement();
			String sql="SELECT * FROM lecture_order WHERE lecture_id='"+lecture_id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			rs.last();
			int count = rs.getRow();
			System.out.println(count);
			return count;
		}catch(Exception e){
			System.err.println("查询预约出错:"+e.getMessage());
			return 0;
		}finally{
			db.CloseConn();
		}
	}

}
