package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//UPDATE STUDENT SET STUD_ADD='BANGALORE',STUD_AVG=89.5 WHERE STUD_ROLL=101;

public class UpdateTest10 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		Scanner scn=null;
				
		String nwAdd=null;
		double nwAvg=0.0;
		int extRoll=0;
		
		try {
			scn=new Scanner(System.in);
			System.out.print("Enter Student New Address:");
			nwAdd=scn.next();
			System.out.print("Enter Student New Average:");
			nwAvg=scn.nextDouble();
			System.out.print("Enter exsisting Student Roll no:");
			extRoll=scn.nextInt();
			
			nwAdd="'"+nwAdd+"'";
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			
			if(con!=null)
				st=con.createStatement();
			//UPDATE STUDENT SET STUD_ADD='BANGALORE',STUD_AVG=89.5 WHERE STUD_ROLL=101

			String query="UPDATE STUDENT SET STUD_ADD="+nwAdd+",STUD_AVG="+nwAvg+" WHERE STUD_ROLL="+extRoll;
			System.out.println(query);
			
			int count=0;
			if(st!=null) {
				count=st.executeUpdate(query);
				if(count==0)
					System.out.println("Record is Not Updated");
				else
					System.out.println(count+" no of Record Updated succsfully");
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
