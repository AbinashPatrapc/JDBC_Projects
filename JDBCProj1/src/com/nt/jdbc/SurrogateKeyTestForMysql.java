package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class SurrogateKeyTestForMysql {
	private static final String INSERT_CUSTOMER_QUERY="INSERT INTO JDBC_COSTUMER(CNAME,CADDRS,BILLAMT,DTOP) VALUES(?,?,?,?)";

	public static void main(String[] args) {
		
		
	try(Scanner scn= new Scanner(System.in);
	Connection con=DriverManager.getConnection("jdbc:mysql:/// ntaj915db","root","1234");
	PreparedStatement ps=con.prepareStatement(INSERT_CUSTOMER_QUERY);){//Try with Resource
		//Reading Values from Keyboard
		System.out.print("Enter the Customer Name::");
		String cname=scn.next();
		System.out.print("Enter the customer Address:");
		String cadd=scn.next();
		System.out.print("Enter the Bill Amount:");
		float billAmt=scn.nextFloat();	
		//Set Values For Query Parameter
		if(ps!=null) {
		ps.setString(1, cname);
		ps.setString(2, cadd);
		ps.setFloat(3, billAmt);
		ps.setTimestamp(4,Timestamp.valueOf(LocalDateTime.now()));
		}
		//Execute Pre-compiled Query
		int count=0;
		if(ps!=null)
			count=ps.executeUpdate();
		//Process the result
		if(count==0)
			System.out.println("Record not Found");
		else
			System.out.println("Record Inserted");
	}//Here con,scn,ps object will Close Automatically
	//Catch Block
	catch(SQLException se) {
		se.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
		

	}//main

}//class
