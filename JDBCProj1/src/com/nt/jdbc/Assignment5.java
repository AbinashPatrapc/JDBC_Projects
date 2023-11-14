/* WRITE A JDBC PROGRAM TO GET EMPLOYE DETAILS WHO IS HAVING HIGHEST SALARY. 

SQL-QUERY-->SELECT ENAME,JOB,SAL FROM EMP WHERE SAL=(SELECT MAX(SAL)FROM EMP);

*/
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Assignment5 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			//GETING CONNECTION WITH ORACLE DATABASE
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			if(con!=null);
			//CREATING STATEMENT
			st=con.createStatement();
			//SQL-QUERY
			String query=("SELECT ENAME,JOB,SAL FROM EMP WHERE SAL=(SELECT MAX(SAL)FROM EMP)");
			
			if(st!=null) {
				rs=st.executeQuery(query);
			System.out.println(query);
			
			}
			boolean isRSEmpty=true;
			while(rs.next()) {
				isRSEmpty=false;
				System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
			}
			if(isRSEmpty) {
				System.out.println("NO RECORD FOUND");
				
			}else {
				System.out.println("RECORD FOUND AND DISPLAYED");
			}
			
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		finally {
			try {
				rs.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			
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
