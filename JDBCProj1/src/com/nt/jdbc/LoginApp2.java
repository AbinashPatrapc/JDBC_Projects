package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginApp2 {
	private static final String QUERY ="SELECT COUNT(*) FROM USERINFO WHERE USERNAME=? AND PASSWORD=?";

	public static void main(String[] args) {
		Scanner scn=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		
		try {
			String usrnm=null,pwd=null;
			
			scn=new Scanner(System.in);
			//Reading values
			System.out.print("Enter Username:");
			usrnm=scn.next();
			System.out.print("Enter Password:");
			pwd=scn.next();
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			
			if(con!=null)
				ps=con.prepareStatement(QUERY);
			
			if(ps!=null) {
				ps.setString(1, usrnm);
			    ps.setString(2, pwd);
			}
			if(ps!=null)
				rs=ps.executeQuery();
			if(rs!=null)
				rs.next();
			int count=rs.getInt(1);
			
			if(count==0) 
				System.out.println("Invalid Credential");
			else 
				System.out.println("Valid Credential");
			
			
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
				rs.close();
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
