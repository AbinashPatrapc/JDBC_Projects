//Write a JDBC Program to insert 'n' no of 
//CUSTOMER details in Oracle DB Table using PreparedStatement.

//Query: INSERT INTO CUSTOMER VALUES(?,?,?,?)

package com.nt.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsInsertTest12 {

	public static void main(String[] args) {
		Scanner scn=null;
		Connection con=null;
		PreparedStatement ps=null;
		
		
		try {
		  scn=new Scanner(System.in);
		  
		  int count=0;
		 if(scn!=null) {
			 System.out.print("How Many Numbers of Customer Details You Want to Enter:");
			 count=scn.nextInt();
		 }
			//Establish Connection 
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			 //Creating PreparedStatement Obj representing the pre-compiled SQL Query
			 if(con!=null)
				 ps=con.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?,?,?)");
			 //Read multiple student details and set them to pre-compiled INSERT query param values
			 for(int i=1;i<=count;++i) {
			//Reading each student details
				 System.out.println("Enter"+" "+i+" "+"Customer Details");
				 System.out.print("Enter CUSTOMER ID:");
				 int cid=scn.nextInt();
				 System.out.print("Enter Customer name:");
				 String cname=scn.next();
				 System.out.print("Enter Student Address:");
				 scn.nextLine();
				 String cadd=scn.nextLine();
				 System.out.print("Enter Payment Amount:");
				 String payment=scn.next();
				 
				 //set each student details to query param values
				 ps.setInt(1, cid);
				 ps.setString(2, cname);
				 ps.setString(3, cadd);
				 ps.setString(4, payment);
				 
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

	
