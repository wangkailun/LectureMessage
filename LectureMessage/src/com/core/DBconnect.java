package com.core;

import java.sql.*;

public class DBconnect {
	
	private Connection conn = null;
	
	public Connection init(){
		try{
			String url="jdbc:mysql://123.206.191.48:3306/lecturemessage";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url , "root" , "root");
			return conn;
		}catch(Exception e){
			System.err.println("�������ݿ��쳣"+e.getMessage());
			return null;
		}
		
	}
	
	public void CloseConn(){
		try{
			conn.close();
		}catch(Exception e){
			System.err.println("���ݿ�ر��쳣"+e.getMessage());
		}
	}

}
