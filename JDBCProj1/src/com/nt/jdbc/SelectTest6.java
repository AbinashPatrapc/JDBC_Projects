package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//select empno,sal,job from emp  where empno=7654;

public class SelectTest6 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Scanner scn=null;
		
		try {
			scn=new Scanner(System.in);
			System.out.print("Enter the Employe no:");
			int no=scn.nextInt();
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			
	        
	        
	        if(con!=null)
	        	st=con.createStatement();
	        String query="SELECT EMPNO,SAL,JOB FROM EMP WHERE EMPNO="+no;
	        System.out.println(query);
	        
	        if(st!=null) 
	        	rs=st.executeQuery(query);
	        if(rs!=null) {
	        	if(rs.next()) {
	        		System.out.println("Record Found");
	        		System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
	        	}else {
	        		System.out.println("No Record Found");
	        	}
	        		
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
			
			try {
				scn.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
		
		

	}

}
