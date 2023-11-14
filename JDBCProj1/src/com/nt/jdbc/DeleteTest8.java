package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// DELETE FROM STUDENT WHERE STUD_AVG>=40 AND STUD_AVG<=90;;

public class DeleteTest8 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner scn=null;
		
		double startavg=0.0;
		double endavg=0.0;
		
		try {
			scn=new Scanner(System.in);
			System.out.print("Enter Starting avg:");
			startavg=scn.nextDouble();
			System.out.print("Enter Ending avg:");
			endavg=scn.nextDouble();
			
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			
	        
	        
	        if(con!=null)
	        	st=con.createStatement();
	        
	        String query="DELETE FROM STUDENT WHERE STUD_AVG>="+startavg+" AND STUD_AVG<="+endavg;
	        
	        System.out.println(query);
	        
	        int count=0;
	        if(st!=null)
	        	count=st.executeUpdate(query);
	        if(count==0)
	        	System.out.println("Record not found for Delete operation");
	        else
	        	System.out.println("Record found and Deleted");
	        
	        	
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
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


