package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//INSERT INTO STUDENT VALUES(111,'KALUA','UP',90);

public class InsertTest9 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner scn=null;
		
		int sno=0;
		String sname=null;
		String sadd=null;
		int avg=0;
		
		try {
			scn=new Scanner(System.in);
			System.out.print("Enter Student Number:");
			sno=scn.nextInt();
			System.out.print("Enter Student name:");
			sname=scn.next();
			System.out.print("Enter Student Address:");
			sadd=scn.next();
			System.out.print("Enter Student Average:");
			avg=scn.nextInt();
			
			sname="'"+sname+"'";
			sadd="'"+sadd+"'";
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			
			if(con!=null)
				st=con.createStatement();
			//INSERT INTO STUDENT VALUES(111,'KALUA','UP',90)
			String query="INSERT INTO STUDENT VALUES("+sno+","+sname+","+sadd+","+avg+")";
			System.out.println(query);
			
			int count=0;
			if(st!=null) {
				count=st.executeUpdate(query);
				if(count==0)
					System.out.println("Record not inserted");
				else
					System.out.println("Record inserted succsfully");
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
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
