package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ps_ScrollableRsTest {
	private static final String SELECT_STUDENT="SELECT * FROM STUDENT";

	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
				PreparedStatement ps=con.prepareStatement(SELECT_STUDENT,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=ps.executeQuery();){
			
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


