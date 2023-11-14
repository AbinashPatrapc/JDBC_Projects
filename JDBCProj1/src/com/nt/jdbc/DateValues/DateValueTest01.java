
package com.nt.jdbc.DateValues;

//import java.util.Date;

public class DateValueTest01 {

	public static void main(String[] args) {
	//	Date d=new Date();
	    java.util.Date d=new java.util.Date();//Here in util.date package Zero-param 
	                                          //Constructor available
		System.out.println("UtilDate:"+d);
		java.sql.Date sqd=new java.sql.Date(d.getTime());//Here in Sql.date package
		                                                //Zero-param const is not available
		                                               //So we have taken d.getTime()as mili sec
		System.out.println("Sql Date:"+sqd);
		

	}

}
