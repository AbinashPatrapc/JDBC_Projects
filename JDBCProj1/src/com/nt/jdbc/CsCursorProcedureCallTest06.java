package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

public class CsCursorProcedureCallTest06 {
   private static final String CURSOR_CALL="{CALL P_GET_EMP_BY_INITIAL_CHAR(?,?)}";
	public static void main(String[] args) {
     try(Scanner scn=new Scanner(System.in);
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
    CallableStatement cs=con.prepareCall(CURSOR_CALL);		 
    		 ){
    	 String initialnm=null;
    	 if(scn!=null) {
    		 System.out.println("Enter Employee's Name First Letter:");
    		 initialnm=scn.next();
    	 }
    	 
    	 if(cs!=null) {
    		 cs.registerOutParameter(2,OracleTypes.CURSOR);
    		 
    		 
    		 cs.setString(1, initialnm+"%");
    		 
    		 cs.execute();
    		 
    		 try(ResultSet rs=(ResultSet)cs.getObject(2)) {
    			 if(rs!=null) {
    				 System.out.println("");
    				 while(rs.next()) {
    					 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
    				 }
    			 
    			 }
    		 }catch(SQLException se) {
    			 se.printStackTrace();
    		 }
    	 }
    	 
    	 
    	 
    	 
    	 
    	 
    	 
     }catch(SQLException se) {
    	 se.printStackTrace();
     }catch(Exception e) {
    	 e.printStackTrace();
    	 
     }
	}

}
