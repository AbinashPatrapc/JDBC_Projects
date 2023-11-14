package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*CREATE OR REPLACE PROCEDURE P_AUTHENTICATION 
(
  UNAME IN VARCHAR2 
, UPASS IN VARCHAR2 
, RESULT OUT VARCHAR2 
) AS 
  CNT NUMBER(2);
BEGIN
 SELECT COUNT(*)INTO CNT FROM USERINFO WHERE USERNAME=UNAME AND PASSWORD=UPASS;
 IF(CNT<>0)THEN
  RESULT:='iNVALID CREDENTIAL';
  ELSE
  RESULT:='VALID CREDENTIAL';
  END IF;
  
END P_AUTHENTICATION;*/

public class CsForProcedureCallTest04 {
	private static final String AUTHENTICATION_CALL="{CALL P_AUTHENTICATION(?,?,?)}";

	public static void main(String[] args) {
		try(Scanner scn=new Scanner(System.in);
				
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
	CallableStatement cs=con.prepareCall(AUTHENTICATION_CALL);			
					){
			String uname=null,upass=null;
			if(scn!=null) {
				System.out.print("Enter Username:");
				uname=scn.next();
				System.out.print("Enter Password:");
				upass=scn.next();
			}
			
			if(cs!=null) {
				cs.registerOutParameter(3,Types.VARCHAR);
				
				cs.setString(1, uname);
				cs.setString(2, upass);
				
				cs.execute();
				
				
				String result=cs.getString(3);
				System.out.println(result);
			}
			
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
