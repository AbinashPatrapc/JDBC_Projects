package com.nt.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class BLOBRetrieve02 {
	private static final String BLOB_RETRIEVE_QUERY="SELECT * FROM NITSTUDENT WHERE STUDENTID=?";
        public static void main(String[] args) {
			try(Scanner scn=new Scanner(System.in);
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","7873");
					PreparedStatement ps=con.prepareCall(BLOB_RETRIEVE_QUERY)){
				 int sid=0;
				 System.out.print("Enter Student ID:");
				 sid=scn.nextInt();
				 
				 if(ps!=null)
					 ps.setInt(1, sid);
				 try(ResultSet rs=ps.executeQuery()){
					 if(rs!=null) {
						 if(rs.next()) {
							 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getBinaryStream(3));
						     InputStream is=rs.getBinaryStream(3);
						     FileOutputStream fis=new FileOutputStream("NewPic.jpg");
						     IOUtils.copy(is, fis);
						     System.out.println("Photo is retrieved");
						 }else
							 System.out.println("File Not Found");
					 }
				 }
			
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
