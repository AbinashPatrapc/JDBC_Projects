package com.nt.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class BLOBREtrieveForOracle {
	private static final String RETRIEVE_QUERY="SELECT * FROM JDBC_ACTOR WHERE ACTORID=?";
	public static void main(String[] args) {
		try(Scanner scn=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","7873");
				PreparedStatement ps=con.prepareCall(RETRIEVE_QUERY);
				){
			int aID=0;
			if(scn!=null) {
				System.out.println("Enter Actor ID:");
				aID=scn.nextInt();
			}
			
			if(ps!=null)
				ps.setInt(1, aID);
			try(ResultSet rs=ps.executeQuery();){
				if(rs!=null) {
					if(rs.next()) {
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
						
						InputStream is=rs.getBinaryStream(4);
						
						OutputStream os=new FileOutputStream("new_pic.jpg");
						
						IOUtils.copy(is, os);
						System.out.println("Photo Retrieved to the File");
					}//inner if
					else {
						System.out.println("Record Not Found");
					}
				}//outer if
				
			}//Inner try	
			
		}//outer try
		catch(SQLException se) {
			se.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
     
	}

}
