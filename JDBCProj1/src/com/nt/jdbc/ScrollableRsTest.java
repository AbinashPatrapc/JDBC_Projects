package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableRsTest {

	public static void main(String[] args) {
	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","Abinash","1234");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery("SELECT * FROM STUDENT");){
		
		if(rs!=null) {
			System.out.println("Records From TOP to Bottom");
			System.out.println();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getFloat(4));
			}
			System.out.println("----------------------------------------------------------------");
			rs.afterLast();
			System.out.println("Records From BOTTOM to TOP");
			System.out.println();
			while(rs.previous()) {
		        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getFloat(4));	
			}
			System.out.println("-----------------------------------------------------------------");
			rs.first();
			System.out.println(rs.getRow()+"----->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getFloat(4));
			rs.last();
			System.out.println(rs.getRow()+"----->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getFloat(4));
			rs.absolute(5);
			System.out.println(rs.getRow()+"----->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getFloat(4));
			rs.absolute(8);
			System.out.println(rs.getRow()+"----->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getFloat(4));
			rs.relative(4);
			System.out.println(rs.getRow()+"----->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getFloat(4));
			rs.relative(-6);
			System.out.println(rs.getRow()+"----->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getFloat(4));
			rs.relative(9);
			System.out.println(rs.getRow()+"----->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getFloat(4));
			rs.absolute(1);
			System.out.println(rs.getRow()+"----->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getFloat(4));
			rs.relative(5);
			System.out.println(rs.getRow()+"----->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getFloat(4));
		}
		
		
	}catch(SQLException se) {
		se.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}

	}

}
