package LabPractice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ClobInsertTest {
	
			private static final String BLOB_INSERT_QUERY="INSERT INTO CLOBDATA VALUES(?,?)";
		       public static void main(String[] args) {
				try(Scanner scn=new Scanner(System.in);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","7873");
			PreparedStatement ps=con.prepareStatement(BLOB_INSERT_QUERY);){
					
					
					System.out.print("Enter Student id:");
					int studentName=scn.nextInt();
					
					System.out.println("Enter Student File Location: ");
					String studentfile=scn.next().replace('?',' ').trim();
					
					FileReader is=new FileReader(studentfile);
					
						ps.setInt(1, studentName);
						
						ps.setCharacterStream(2, is);
						
						int i=ps.executeUpdate();
						
						if(i>0) {
							System.out.println("Record Inserted");
						}else {
							System.out.println("failed");
				}
				
				}catch(SQLException e) {
					e.printStackTrace();
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		


		}




