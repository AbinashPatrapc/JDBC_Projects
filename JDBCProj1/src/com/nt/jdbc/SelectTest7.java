package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//SELECT COUNT(*)FROM EMP;

public class SelectTest7 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			
	        
	        
	        if(con!=null)
	        	st=con.createStatement();
	        
	        String query="SELECT COUNT(*)FROM EMP";
	        
	        System.out.println(query);
	        
	        if(st!=null) 
	        	rs=st.executeQuery(query);
	        
	        if(rs!=null) {
	        	rs.next();
	        	
	        	int count=rs.getInt("count(*)");
	        		System.out.println("emp DB Table Records Count is:"+count);
	        		
	        
	        		//System.out.println("No Record Found");
	        	}
	        		
	        
	        	
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			}catch(SQLException se) {
				se.printStackTrace();
				
			}
			
			try {
				st.close();
			}catch(SQLException se) {
				se.printStackTrace();
				
			}
			
			try {
				con.close();
			}catch(SQLException se) {
				se.printStackTrace();
				
			}
	}
	}
}


