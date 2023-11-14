package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

//CREATE OR REPLACE PROCEDURE P_GET_EMP_DETAILS_BY_ID 
//(
//  NO IN NUMBER 
//, NAME OUT VARCHAR2 
//, DESG OUT VARCHAR2 
//, SALARY OUT VARCHAR2 
//) AS 
//BEGIN
//  SELECT ENAME,JOB,SAL INTO NAME,DESG,SALARY FROM EMP WHERE EMPNO=NO;
//END P_GET_EMP_DETAILS_BY_ID;


public class CsForProcedureCallTest03 {
	private static final String EMP_PROCEDURE_CALL="{CALL P_GET_EMP_DETAILS_BY_ID(?,?,?,?)}";	

	public static void main(String[] args) {
		
		try(Scanner scn= new Scanner(System.in);
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
	CallableStatement cs=con.prepareCall(EMP_PROCEDURE_CALL);			
				){
			int no=0;
			if(scn!=null) {
				System.out.println("Enter Employee no::");
				no=scn.nextInt();
			}
			
			if(cs!=null) {
				cs.registerOutParameter(2,Types.VARCHAR);
				cs.registerOutParameter(3,Types.VARCHAR);
				cs.registerOutParameter(4,Types.VARCHAR);
				
				cs.setInt(1, no);
				
				cs.execute();
				
				System.out.println("Employee Name-->"+cs.getString(2));
				System.out.println("Employee Designation-->"+cs.getString(3));
				System.out.println("Employee Salary-->"+cs.getString(4));
				
				
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
