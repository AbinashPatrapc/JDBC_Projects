//Write a JDBC Program to insert 'n' no of 
//Student details in Oracle DB Table using PreparedStatement.

//Query: INSERT INTO STUDENT VALUES(?,?,?,?)

package com.nt.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsInsertTest11 {

	public static void main(String[] args) {
		Scanner scn=null;
		Connection con=null;
		PreparedStatement ps=null;
		
		
		try {
		  scn=new Scanner(System.in);
		  
		  int count=0;
		 if(scn!=null) {
			 System.out.print("How Many Numbers of Student Details You Want to Enter:");
			 count=scn.nextInt();
		 }
			//Establish Connection 
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			 //Creating PreparedStatement Obj representing the pre-compiled SQL Query
			 if(con!=null)
				 ps=con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?)");
			 //Read multiple student details and set them to pre-compiled INSERT query param values
			 for(int i=1;i<=count;++i) {
			//Reading each student details
				 System.out.println("Enter"+" "+i+" "+"Student Details");
				 System.out.print("Enter Student Number:");
				 int sno=scn.nextInt();
				 System.out.print("Enter Student name:");
				 String sname=scn.next();
				 System.out.print("Enter Student Address:");
				 scn.nextLine();
				 String sadd=scn.nextLine();
				 System.out.print("Enter Student Average:");
				 double avg=scn.nextDouble();
				 
				 //set each student details to query param values
				 ps.setInt(1, sno);
				 ps.setString(2, sname);
				 ps.setString(3, sadd);
				 ps.setDouble(4, avg);
				 
				 //Execute the SQL query
				 int result=ps.executeUpdate();
				 //Process the Results
				 if(result==0)
					 System.out.println(i+" "+"Record not Inserted");
				 else
					 System.out.println(i+" "+"Record Inserted");
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

	
