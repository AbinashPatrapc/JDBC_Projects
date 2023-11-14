package com.nt.jdbc.DateValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonAgeCalculatorForOracle {
	private static final String PERSON_AGE_CALC="SELECT (SYSDATE-DOB)/365.25 FROM JDBC_PERSON_DATE WHERE PNAME=?";
	
	public static void main(String[] args) {
		Scanner scn=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
		     String pid=null;
			scn=new Scanner(System.in);
			if(scn!=null) {
				System.out.print("Enter Person Name::");
				pid=scn.next();
				
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
				if(con!=null)
					ps=con.prepareStatement(PERSON_AGE_CALC);
				if(ps!=null)
					ps.setString(1, pid);
				if(ps!=null)
					rs=ps.executeQuery();
				if(rs.next())
					System.out.println("Person Age::"+rs.getFloat(1));
				else
					System.out.println("No record Found");
				
				
					
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
		   e.printStackTrace();
			
		}
		finally {
			try {
				ps.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				con.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				rs.close();
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
