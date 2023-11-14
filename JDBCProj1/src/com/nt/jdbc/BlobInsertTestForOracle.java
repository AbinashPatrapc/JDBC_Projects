package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BlobInsertTestForOracle {
	private static final String BLOB_INSERT_QUERY="INSERT INTO JDBC_ACTOR VALUES(ACTORID_SEQ.NEXTVAL,?,?,?)";

	public static void main(String[] args) {
		try(Scanner scn=new Scanner(System.in);
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
				PreparedStatement ps=con.prepareStatement(BLOB_INSERT_QUERY);
				){
			String name=null,addrs=null,photoLocation=null;
			if(scn!=null) {
			System.out.println("Enter Actor Name::");
			name=scn.next();
			System.out.println("Enter Actor Address::");
			addrs=scn.next();
			System.out.println("Enter Actor Photo Location::");
			photoLocation=scn.next().trim();
			}
			
			InputStream is =new FileInputStream(photoLocation);
			if(ps!=null) {
				ps.setString(1, name);
				ps.setString(2, addrs);
				ps.setBinaryStream(3, is);
			}
			int count=0;
			if(ps!=null)
				count=ps.executeUpdate();
			
			if(count==0)
				System.out.println("Failed to Update Data");
			else
				System.out.println("Data Updated Successfully");
					
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(FileNotFoundException fne) {
			fne.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
