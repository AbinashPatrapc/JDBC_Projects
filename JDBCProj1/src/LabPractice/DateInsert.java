package LabPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DateInsert {
		private static final String BLOB_INSERT_QUERY="INSERT INTO DATEVALUE VALUES(?,sysdate)";
	       public static void main(String[] args) {
	    	  
			try(Scanner scn=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","7873");
		PreparedStatement ps=con.prepareStatement(BLOB_INSERT_QUERY);){
				int count=0;
				if(ps!=null) {
					ps.setString(1, "Abinash");
					
					count=ps.executeUpdate();
				}
				if(count==0) {
					System.out.println("There is a problem during Insertion");
				}else {
					System.out.println("Record Inserted");
				}
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

}

