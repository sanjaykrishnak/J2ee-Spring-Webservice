package com.test;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name="TestWebService")

public class TestWebService 
{
	

	public int testAddMethod(int a, int b)
	{
		return a+b;
	}

}
