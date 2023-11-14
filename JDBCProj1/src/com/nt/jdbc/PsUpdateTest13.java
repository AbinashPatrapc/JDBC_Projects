package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//UPDATE STUDENT SET STUD_ADD=?,STUD_AVG=? WHERE STUD_ROLL=?;

public class PsUpdateTest13 {
	private static final String UPDATE_STUDENT_QUERY="UPDATE STUDENT SET STUD_ADD=?,STUD_AVG=? WHERE STUD_ROLL=?";

	public static void main(String[] args) {
		Scanner scn=null;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			String newadd=null;
			Float newavg=0f;
			int roll=0;
			
			scn=new Scanner(System.in);
			//reading values
			System.out.print("Enter New Address:");
			newadd=scn.next();
			System.out.print("Enter New Average:");
			newavg=scn.nextFloat();
			System.out.print("Enter Student Roll no:");
			roll=scn.nextInt();
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			
			if(con!=null)
				ps=con.prepareStatement(UPDATE_STUDENT_QUERY);
			
			if(ps!=null)
				ps.setString(1,newadd);
			    ps.setFloat(2,newavg);
			    ps.setInt(3, roll);
			    
			    int count=0;
			 if(ps!=null)
			    count=ps.executeUpdate();
			 if(count==0) {
				 System.out.println("Record not updated");
			 }else {
				 System.out.println("Record updated");
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
				scn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
