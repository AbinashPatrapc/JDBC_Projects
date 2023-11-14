package com.nt.jdbc;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class CachedRowSetDemo {
      public static void main(String[] args) {
		try(CachedRowSet crs=new OracleCachedRowSet()){
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("Abinash");
			crs.setPassword("7873");
			
			crs.setCommand("SELECT * FROM STUDENT");
			crs.execute();
			while(crs.next())
			System.out.println(crs.getInt(1)+" "+crs.getString(2)+" "+crs.getString(3)+" "+crs.getString(4));
			Thread.sleep(5000);
			System.out.println("Sleeping Thread for 5 Sec");
			crs.absolute(5);
			crs.updateString(5, "Abinash");
			crs.updateRow();
			Thread.sleep(4000);
			crs.acceptChanges();
			while(crs.next())
			System.out.println(crs.getInt(1)+" "+crs.getString(2)+" "+crs.getString(3)+" "+crs.getString(4));
			
	
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
