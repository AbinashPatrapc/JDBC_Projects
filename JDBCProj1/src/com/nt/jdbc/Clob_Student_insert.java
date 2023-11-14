package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Clob_Student_insert implements Serializable {
		private static final String CLOB_INSERT_QUERY="INSERT INTO CLOBSTUDENT VALUES(S1.NEXTVAL,?,?)";
		private String name;
		private String addrs;
		private long mobileNo;
		
	    
		public Clob_Student_insert(String name, String addrs, long mobileNo) {
			super();
			this.name = name;
			this.addrs = addrs;
			this.mobileNo = mobileNo;
		}


		public static void main(String[] args) {
			try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","7873");
				PreparedStatement ps=con.prepareStatement(CLOB_INSERT_QUERY)){
				Clob_Student_insert csi=new Clob_Student_insert("Abinash","Hyderabad",7873);
				
				
				
				int count=0;
				FileOutputStream is=new FileOutputStream("SerializedStudent.ser");
				ObjectOutputStream oos=new ObjectOutputStream(is);
				oos.writeObject(csi);
				
				FileInputStream fis=new FileInputStream("SerializedStudent.ser");
				if(ps!=null) {
					ps.setString(1,"Abinash");
					ps.setBinaryStream(2,fis);
					
					 count=ps.executeUpdate();
				}
				if(count==0)
					System.out.println("Failed to insert data");
				else
					System.out.println("Inserted");
		
				
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	} }


