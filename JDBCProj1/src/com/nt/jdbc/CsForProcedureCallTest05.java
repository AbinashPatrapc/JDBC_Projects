package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsForProcedureCallTest05 {
	private static final String STUDENT_CALL="{CALL P_STUDENT_DETAILS_BY_ROLLNO(?,?,?,?)}";

	public static void main(String[] args) {
		try(Scanner scn=new Scanner(System.in);
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
	CallableStatement cs=con.prepareCall(STUDENT_CALL);			
				){
			int rollno=0;
			if(scn!=null) {
				System.out.println("Enter Student Roll no:");
				rollno=scn.nextInt();
			}
			
			if(cs!=null) {
				//Registering out parameters 
				cs.registerOutParameter(2,Types.VARCHAR);
				cs.registerOutParameter(3,Types.VARCHAR);
				cs.registerOutParameter(4,Types.VARCHAR);
				
				//Setting In parameter value
				cs.setInt(1,rollno);
				
				//Executing the Query
				cs.execute();
				
				//Getting the out Parameter value
				 System.out.println("Student name::"+cs.getString(2));
				 System.out.println("Student Address::"+cs.getString(3));
				 System.out.println("Student Average::"+cs.getFloat(4));
				
				
				
				
				
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
