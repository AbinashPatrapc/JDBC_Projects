package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*QUERY
 *1. SELECT COUNT (*) FROM USERINFO WHERE USERNAME='Abinash' AND password='Bittu';
 *2. CREATE TABLE USERINFO(username varchar2(20) primary key,password varchar2(20));
 *3. INSERT INTO USERINFO VALUES('Raja','Rani');
*/
public class LoginApp {

	public static void main(String[] args) {
		Scanner scn=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		
		
		try {
			String usrnm=null,pswd=null;
			scn=new Scanner(System.in);
			System.out.print("Enter Username:");
			usrnm=scn.nextLine();
			System.out.print("Enter password:");
			pswd=scn.nextLine();
			
			
			usrnm="'"+usrnm+"'";
			pswd="'"+pswd+"'";
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			
			if(con!=null)
			st=con.createStatement();
			
			
			//SELECT COUNT (*) FROM USERINFO WHERE USERNAME='Abinash' AND password='Bittu';
			String query="SELECT COUNT (*) FROM USERINFO WHERE USERNAME="+usrnm+"ANd PASSWORD="+pswd;
			
			System.out.println(query);
			
			
            if(st!=null)
	        rs=st.executeQuery(query);
             
			
			if(rs!=null)
				rs.next();
			  int count=rs.getInt(1);
			if(count==0) {
				System.out.println("Invalid Credentials");
			}else {
				System.out.println("Valid Credentials");
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
