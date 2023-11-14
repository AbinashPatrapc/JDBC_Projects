package com.nt.jdbc;

import java.sql.SQLException;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleJoinRowSet;

public class JoinRowSetDemo {
      public static void main(String[] args) {
      try(OracleCachedRowSet crs1=new OracleCachedRowSet();
    	OracleCachedRowSet crs2=new OracleCachedRowSet();
    	OracleJoinRowSet jrs=new OracleJoinRowSet();){
    	
    	crs1.setUrl("jdbc:oracle:@localhost:1521:xe");
    	crs1.setUsername("Abinash");
    	crs1.setPassword("7873");
    	crs1.setCommand("SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP");
    	crs1.setMatchColumn(5);
    	crs1.execute();
    	
    	crs2.setUrl("jdbc:oracle:@localhost:1521:xe");
    	crs2.setUsername("Abinash");
    	crs2.setPassword("7873");
    	crs2.setCommand("SELECT DEPTNO,DNAME,LOC FROM DEPT");
    	crs1.setMatchColumn(1);
    	crs2.execute();
    	
        jrs.addRowSet(crs1);
        jrs.addRowSet(crs2);
        
        while(jrs.next()) {
        	System.out.println(jrs.getInt(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getString(4)+" "+jrs.getString(5)+" "+jrs.getString(6)+" "+jrs.getString(7)+" "+jrs.getString(8));	
        }
    	
       }catch(SQLException e) {
    	   e.printStackTrace();
       }catch(Exception e) {
    	   e.printStackTrace();
       }
	}
}
