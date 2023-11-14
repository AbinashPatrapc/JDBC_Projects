package com.nt.jdbc.DateValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class DateValueRetrieveTest {
	//SQL Query
    private static final String DATE_VALUE_RETRIEVE="SELECT * FROM JDBC_PERSON_DATE";
    
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
				PreparedStatement ps=con.prepareStatement(DATE_VALUE_RETRIEVE);
				ResultSet rs=ps.executeQuery();){//Try With Resource
	
			if(rs!=null) {
				while(rs.next()) {
				//Getting the sql date values
					int pid=rs.getInt(1);
					String pname=rs.getString(2);
					java.sql.Date sqdob=rs.getDate(3);
					java.sql.Date sqdoj=rs.getDate(4);
					java.sql.Date sqdom=rs.getDate(5);
					
			   //Converting sql date values to util date value
					java.util.Date udob=sqdob;
					java.util.Date udoj=sqdoj;
					java.util.Date udom=sqdom;
					
			  //Converting util date values to String values
					SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
					String sdob=sdf.format(udob);
					String sdoj=sdf.format(udoj);
					String sdom=sdf.format(udom);
					
					System.out.println(pid+"\t\t "+pname+"\t\t "+sdob+"\t\t "+sdoj+"\t\t "+sdom);
				
				}//while end
			}//if end
			
		//Catch Block
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
		   e.printStackTrace();
			
		}
		
		}//Main end

}//class end

