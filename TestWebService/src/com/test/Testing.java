package com.test;

import org.joda.time.format.DateTimeFormat;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		org.joda.time.format.DateTimeFormatter df =DateTimeFormat.forPattern("MM/dd/yyyy");
		System.out.println(df.parseLocalDate("01/02/2015"));
	}

}
