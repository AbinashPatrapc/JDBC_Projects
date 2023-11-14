package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

/*CREATE OR REPLACE FUNCTION FX_GET_STUD_DETAILS_BY_SNO 
(
  SNO IN NUMBER 
, NAME OUT VARCHAR2 
, ADDRS OUT VARCHAR2 
) RETURN FLOAT AS 
  AGGREGATE FLOAT;   
BEGIN
  SELECT STUD_NAME,STUD_ADD,STUD_AVG INTO NAME,ADDRS,AGGREGATE FROM STUDENT WHERE STUD_ROLL=SNO;
END FX_GET_STUD_DETAILS_BY_SNO;*/

public class CsCursorFunctionCallTest07 {
	private static final String CALL_FUNCTION="{?=call FX_GET_STUD_DETAILS_BY_SNO(?,?,?)}";

	public static void main(String[] args) {
		try(Scanner scn=new Scanner(System.in);
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
	CallableStatement cs=con.prepareCall(CALL_FUNCTION);			
				){
			int sno=0;
			if(scn!=null) {
				System.out.println("Enter Student Roll no:");
				sno=scn.nextInt();
			}
			
			if(cs!=null) {
				cs.registerOutParameter(1,OracleTypes.FLOAT);
				cs.registerOutParameter(3,OracleTypes.VARCHAR);
				cs.registerOutParameter(4,OracleTypes.VARCHAR);
				
				cs.setInt(2,sno);
				
				cs.execute();
				
				System.out.println("Student name:"+cs.getString(3));
				System.out.println("Student Address:"+cs.getString(4));
				System.out.println("Student Average:"+cs.getFloat(1));
			}
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
			
		}

	}

}
