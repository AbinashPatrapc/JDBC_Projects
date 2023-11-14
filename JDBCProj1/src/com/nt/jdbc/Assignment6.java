package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//INSERT INTO EMP(EMPNO,ENAME,SAL,JOB)VALUES(1100,'RAMESH',8000,'SELLER');

public class Assignment6 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner scn=null;
		
		int eno=0;
		String ename=null;
		int sal=0;
		String job=null;
		
		try {
			scn=new Scanner(System.in);
			System.out.print("Enter Employee Number:");
			eno=scn.nextInt();
			System.out.print("Enter Employee name:");
			ename=scn.next();
			System.out.print("Enter Salary:");
			sal=scn.nextInt();
			System.out.print("Enter Employee Job:");
			job=scn.next();
			
			ename="'"+ename+"'";
			job="'"+job+"'";
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			
			if(con!=null)
				st=con.createStatement();
			//INSERT INTO EMP(EMPNO,ENAME,SAL,JOB)VALUES(1100,'RAMESH',8000,'SELLER');

			String query="INSERT INTO EMP(EMPNO,ENAME,SAL,JOB)VALUES("+eno+","+ename+","+sal+","+job+")";
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
