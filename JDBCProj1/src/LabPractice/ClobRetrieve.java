package LabPractice;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class ClobRetrieve {

	
		private static final String BLOB_INSERT_QUERY="SELECT * FROM CLOBDATA WHERE STUDID=?";
	       public static void main(String[] args) {
			try(Scanner scn=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","7873");
		PreparedStatement ps=con.prepareStatement(BLOB_INSERT_QUERY);){
				
				
				System.out.print("Enter Student id:");
				int studentName=scn.nextInt();
				ps.setInt(1, studentName);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					String data=rs.getString(2);
					
					Reader rd=rs.getCharacterStream(2);
					System.out.println(rd);
					System.out.println("Enter the file Path: ");
				    String file=scn.next();
					FileWriter fw=new FileWriter(file);
					fw.write(data);
					fw.close();
					System.out.println("Success");
					 
				}

	        }catch(Exception e) {
		      e.printStackTrace();
	}

	       }
}
