package com.nt.jdbc.DateValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertTest {
	private static final String INSERT_PERSON_DATE="INSERT INTO JDBC_PERSON_DATE VALUES(?,?,?,?,?)";
	public static void main(String[] args) {
        Scanner scn=null;
		Connection con=null;
		PreparedStatement ps=null;

		try{
			int pid=0;
			String pname=null,dob=null,doj=null,dom=null;
			scn=new Scanner(System.in);
			if(scn!=null){
			
			
			System.out.println("Enter peron id:");
			pid=scn.nextInt();
			System.out.println("Enter Person Name:");
			pname=scn.next();
			System.out.println("Enter Date of Birth(dd-MM-yyyy)");
			dob=scn.next();
			System.out.println("Enter Date of Joining(MM-dd-yyyy)");
			doj=scn.next();
			System.out.println("Enter Date of Marriage(yyyy-MM-dd)");
			dom=scn.next();
			}//if end

			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date udob=sdf.parse(dob);
			long ms=udob.getTime();
			java.sql.Date sqdob=new java.sql.Date(ms);

			SimpleDateFormat sdf1=new SimpleDateFormat("MM-dd-yyyy");
			java.util.Date udoj=sdf1.parse(doj);
			long ms1=udoj.getTime();
			java.sql.Date sqdoj =new java.sql.Date(ms1);

			java.sql.Date sqdom =java.sql.Date.valueOf(dom);
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","7873");
			
			if(con!=null)
				ps=con.prepareStatement(INSERT_PERSON_DATE);
			if(ps!=null){
				ps.setInt(1,pid);
				ps.setString(2,pname);
				ps.setDate(3,sqdob);
				ps.setDate(4,sqdoj);
				ps.setDate(5,sqdom);

			}

			int count=0;
			if(ps!=null)
				count=ps.executeUpdate();
			if(count==0){
				System.out.println("Record is not Inserted");
			}else{
				System.out.println("Record is Inserted");
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