package com.db;

import com.core.DBconnect;
import java.sql.*;

public class OrderDB {
	
	public boolean getOrderStatic(int id , String username)
	{
		Connection conn;
		DBconnect db = new DBconnect();
		conn = db.init();
		try{
			Statement stmt=conn.createStatement();
			String sql="SELECT * FROM lecture_order WHERE username='"+username+"' AND lecture_id='"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception e){
			System.err.println("查询预订状态时出错:"+e.getMessage());
			return false;
		}finally{
			db.CloseConn();
		}
	}
	
	public boolean setOrderStatic(int id ,String username)
	{
		Connection conn;
		DBconnect db = new DBconnect();
		PreparedStatement pstate;
		conn = db.init();
		try{
			String sql="INSERT INTO lecture_order(username , lecture_id) VALUES (?,?)";
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, username);
			pstate.setInt(2, id);
			
			int n=0;
			n = pstate.executeUpdate();
			if(n>0)
			{
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			System.err.println("插入预订状态时出错:"+e.getMessage());
			return false;
		}finally{
			db.CloseConn();
		}
	}
	
	public boolean deleteOrderStatic(int id ,String username)
	{
		Connection conn;
		DBconnect db=new DBconnect();
		conn = db.init();
		
		try{
			Statement stmt = conn.createStatement();
			String sql="DELETE FROM lecture_order WHERE lecture_id='"+id+"' AND username='"+username+"'";
			int result = 0;
			result = stmt.executeUpdate(sql);
			if(result > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception e){
			System.err.println("删除预约出错:"+e.getMessage());
			return false;
		}finally{
			db.CloseConn();
		}
	}

}
