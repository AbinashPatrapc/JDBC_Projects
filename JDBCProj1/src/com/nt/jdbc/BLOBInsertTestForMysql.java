package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BLOBInsertTestForMysql {
	private static final String INSERT_QUERY_MYSQL="INSERT INTO JDBC_ACTOR (ACTORNAME,ACTORGENDER,ACTORADDRS,PHOTO)VALUES(?,?,?,?)";
public static void main(String[] args) {
		try(
	Scanner scn=new Scanner(System.in);
	Connection con=DriverManager.getConnection("jdbc:mysql:/// ntaj915db","root","1234");
    PreparedStatement ps=con.prepareStatement(INSERT_QUERY_MYSQL);
		   ){
		String name=null,gender=null,addrs=null,photoLocation=null;
			if(scn!=null) {
				System.out.print("Enter Actor Name::");
				name=scn.next();
				System.out.print("Enter Actor Gender::");
				gender=scn.next();
				System.out.print("Enter Actor Address::");
				addrs=scn.next();
				System.out.println("Enter Actor Photo Location::");
				photoLocation=scn.next().replace("?","").trim();
			}
			InputStream is=new FileInputStream(photoLocation);
			
			if(ps!=null) {
			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setString(3, addrs);
			ps.setBinaryStream(4, is);
			}
			int count=0;
			if(ps!=null)
				count=ps.executeUpdate();
			if(count==0)
				System.out.println("Record Insertion Failed");
			else
				System.out.println("Record Inserted Successfully");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    
}
