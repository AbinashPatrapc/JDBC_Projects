package com.nt.jdbc;

import java.io.FileWriter;
import java.io.Writer;
import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import oracle.jdbc.rowset.OracleWebRowSet;

public class WebRowSetDemo {
        public static void main(String[] args) {
		try(WebRowSet wrs=new OracleWebRowSet()){
		wrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		wrs.setUsername("Abinash");
		wrs.setPassword("1234");
		
		wrs.setCommand("SELECT * FROM STUDENT");
		wrs.execute();
		while(wrs.next()) {
			System.out.println(wrs.getInt(1)+" "+wrs.getString(2)+" "+wrs.getString(3)+" "+wrs.getString(4));
		}
		
		wrs.writeXml(System.out);
		Writer writer=new FileWriter("Student.xml");
		wrs.writeXml(writer);
		writer.flush();
		writer.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
