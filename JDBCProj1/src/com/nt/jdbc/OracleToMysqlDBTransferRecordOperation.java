package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;      
public class OracleToMysqlDBTransferRecordOperation {
	private static final String ORA_SELECT_QUERY="SELECT STUD_NAME,STUD_ADD,STUD_AVG FROM STUDENT";
    private static final String MYSQL_INSERT_QUERY=" INSERT INTO student(stud_name,stud_add,stud_avg) VALUES(?,?,?);";

	public static void main(String[] args) {//Try with Resource
	   try(Connection oracon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
		   Connection sqlcon=DriverManager.getConnection("jdbc:mysql:/// ntaj915db","root","1234");
		   Statement st=oracon.createStatement();
		   PreparedStatement ps=sqlcon.prepareStatement(MYSQL_INSERT_QUERY);
		   ResultSet rs=st.executeQuery(ORA_SELECT_QUERY);)
	   {
		   
		  
			   while(rs.next()) {
				   //Getting values from Oracle DB
				   String name=rs.getString(1);
				   String add=rs.getString(2);
				   Float avg=rs.getFloat(3); 
				   
				   
			   //Setting Oracle DB values to MySQL
			  ps.setString(1, name);
			  ps.setString(2, add);
			  ps.setFloat(3, avg);
			   
			   //Execute the Query
			   ps.executeUpdate();
		   }//While end
			System.out.println("Record Transfered Successfully");   
    //  }//if end
		   
	  
	   }catch(SQLException se) {
		   se.printStackTrace();
		   System.out.println("Problem in Transfering Record 1");
	   }catch(Exception e) {
		   e.printStackTrace();
		   System.out.println("Problem in Transfering Record 2");
	   }

	}//main end

}//class end
