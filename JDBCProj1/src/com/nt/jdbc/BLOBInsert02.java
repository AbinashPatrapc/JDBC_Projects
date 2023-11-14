package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BLOBInsert02 {
	private static final String BLOB_INSERT_QUERY="INSERT INTO NITSTUDENT VALUES(S1.NEXTVAL,?,?)";
       public static void main(String[] args) {
		try(Scanner scn=new Scanner(System.in);
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","7873");
	PreparedStatement ps=con.prepareStatement(BLOB_INSERT_QUERY);){
			String studentName=null,studentPhoto=null;int count=0;
			System.out.print("Enter Student Name:");
			studentName=scn.next();
			System.out.println("Enter Student Photo Location: ");
			studentPhoto=scn.next().replace('?',' ').trim();
			
			InputStream is=new FileInputStream(studentPhoto);
			if(ps!=null) {
				ps.setString(1, studentName);
				ps.setBinaryStream(2, is);
				
				count=ps.executeUpdate();
			}
			if(count==0) {
				System.out.println("There is a problem during Insertion");
			}else {
				System.out.println("Record Inserted");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
























//InputStream is=new FileInputStream(studentPhoto);
//if(ps!=null) {
//	ps.setString(1, studentName);
//	ps.setBinaryStream(2, is);
//	
//	count=ps.executeUpdate();
//
//	
//	
//	
//	ObjectInputStream ois=new ObjectInputStream(new FileInputStream("BankDetails.ser"));
//	System.out.println(ois.readObject());
//	
//	
//	FileOutputStream fos=new FileOutputStream("abc.ser");
//	ObjectOutputStream oos=new ObjectOutputStream(fos);
//	System.out.println("X: "+s1.x);
//	System.out.println("Y: "+s1.y);
//	oos.writeObject(s1);
//	System.out.println("Serialized");








