package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsForProcedureCallTest2 {
    private static final String CALL_PROCEDURE="{call second_pro(?,?,?)}";
	public static void main(String[] args) {
        try(Scanner scn=new Scanner(System.in);
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
        		CallableStatement cs=con.prepareCall(CALL_PROCEDURE);
        		){
        	
        	int no=0;
        	if(scn!=null) {
        		System.out.print("Enter the Number::");
        		no=scn.nextInt();
        	}
        	if(cs!=null) {
        		cs.registerOutParameter(2,Types.INTEGER);
        	    cs.registerOutParameter(3,Types.INTEGER);
        	
        	
        	cs.setInt(1, no);
        	
        	cs.execute();
        	
        	int sqr=cs.getInt(2);
        	int cube=cs.getInt(3);
        	
        	
        	
        	System.out.println("Square of the Number:"+sqr);
        	System.out.println("Cube of the Number:"+cube);
        	
        	
        	}
        	
        }catch(SQLException se) {
        	se.printStackTrace();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

}
