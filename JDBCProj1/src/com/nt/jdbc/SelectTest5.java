	/*Write a jdbc Program with coding standard to get student details
 * who is having highest avg.

 *SQL-QUERY:
 *------------
 *-->SELECT * FROM STUDENT WHERE AVG=(SELECT MAX(AVG)FROM STUDENT)
 */
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectTest5 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abinash","1234");
			if(con!=null)
				st=con.createStatement();
			
			String query=("SELECT * FROM STUDENT WHERE STUD_AVG=(SELECT MAX(STUD_AVG)FROM STUDENT)");
			if(st!=null)
			rs=st.executeQuery(query);
			
			if(rs!=null) {
				boolean isRSEmpty=true;
				while(rs.next()) {
					isRSEmpty=false;
					System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getFloat(4));
				}
		
			if(isRSEmpty) {
				System.out.println("Record not Found");
			}else {
				System.out.println("Record found and displayed");
			}
			
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		//catch(ClassNotFoundException cnf) {
			//cnf.printStackTrace();
	//	}
	     catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				st.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				con.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			
			
			
		}
		
		

	}

	

}
