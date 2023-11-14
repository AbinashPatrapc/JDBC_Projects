package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;


public class CsForProcedureCallTest1 {
	public static final String CALL_PROCEDURE="{call first_pro(?,?)}";

	public static void main(String[] args) {
      try(Scanner scn=new Scanner(System.in);
   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
   CallableStatement cs=con.prepareCall(CALL_PROCEDURE); 		  
    		  ){
    	  int no=0;
    	  if(scn!=null) {
    		  System.out.println("Enter the no::");
    		  no=scn.nextInt();
    	  }
    	  if(cs!=null)
    		  cs.registerOutParameter(2,Types.INTEGER);
    	  
    		  cs.setInt(1,no);
    		  
    		  cs.execute();
    	  int result=cs.getInt(2);
    	  System.out.println("Result::"+result);
    	  
    	  
      }catch(SQLException se) {
    	  se.printStackTrace();
      }catch(Exception e) {
    	  e.printStackTrace();
      }
	}

}
