package com.nt.jdbc;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JdbcRowSetDemo {
       public static void main(String[] args) {
		try(JdbcRowSet jrw=new OracleJDBCRowSet()){
			
		   jrw.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		   jrw.setUsername("Abinash");
		   jrw.setPassword("7873");
		   
		   jrw.setCommand("SELECT * FROM STUDENT");
		   jrw.execute();
		   while(jrw.next()) {
			   System.out.println(jrw.getInt(1)+" "+jrw.getString(2)+" "+jrw.getString(3)+" "+jrw.getString(4));
		   }
	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
