package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//INSERT INTO JDBC_PRODUCT VALUES(pno,'pname',price,qty);

public class Assignment7 {

	public static void main(String[] args) {
		Scanner scn=null;
		Connection con=null;
		Statement st=null;
		
		
		try {
			int pno=0;
			String pname=null;
			int price=0;
			int qty=0;
			
			scn=new Scanner(System.in);
			
			if(scn!=null)
			System.out.print("Enter the Product Number:");
			pno=scn.nextInt();
			System.out.print("Enter the Product Name:");
			scn.nextLine();
			pname=scn.nextLine();
			System.out.print("Enter the Product Price:");
			price=scn.nextInt();
			System.out.print("Enter the Product Quantity:");
			qty=scn.nextInt();
			
			pname="'"+pname+"'";
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			if(con!=null)
				st=con.createStatement();
			//INSERT INTO JDBC_PRODUCT VALUES(pno,'pname',price,qty);
			
			String query="INSERT INTO JDBC_PRODUCT VALUES("+pno+","+pname+","+price+","+qty+")";
			System.out.println(query);
			
			int count=0;
			if(st!=null)
				count=st.executeUpdate(query);
			if(count==0) {
				System.out.println("Record not inserted");
			}else {
				System.out.println("Record inserted successfully");
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
