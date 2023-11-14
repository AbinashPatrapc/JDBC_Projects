package com.nt.jdbc.DateValues;

import java.text.SimpleDateFormat;

public class ConvertingStringToSqlDate {

	public static void main(String[] args) throws Exception {
		//Converting String Date value to Util date value
		String d1="29-10-1998";
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date ud1=sdf.parse(d1);//Throws Unchecked Exception
		System.out.println("String Date:"+d1);
		System.out.println("Util Date:"+ud1);
		System.out.println("----------------------");
		
		//Converting Util date value to Sql date 
		long ms=ud1.getTime();
		java.sql.Date sqd=new java.sql.Date(ms);
		System.out.println("Sql Date:"+sqd);
		System.out.println("---------------------");
		
		//If the given String Format is yyyy-MM-dd then it can be converted directly
		//to java.sql.Date class obj by using valueOf()method.
		String d2="1999-01-16";
		java.sql.Date sqd1=java.sql.Date.valueOf(d2);
		System.out.println("String Date:"+d2);
		System.out.println("Sql Date:"+sqd1);
		System.out.println("-----------------------------");
		
		//Converting java.sql.Date class to java.util.Date
		java.util.Date ud2=sqd1;
		System.out.println("util date:"+ud2);
		System.out.println("----------------------");
		
		//converting utill date to String date value
		SimpleDateFormat sdf1=new SimpleDateFormat("MM-dd-yyyy");
		String sd3 =sdf1.format(ud2);
		System.out.println("String Date:"+sd3);

	}
}

