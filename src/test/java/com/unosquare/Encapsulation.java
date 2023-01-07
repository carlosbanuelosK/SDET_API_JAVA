package com.unosquare;

import java.io.IOException;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;

public class Encapsulation {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String test = TestDataBuild.Add("C:\\Users\\carlos.banuelos\\eclipse-workspace\\API\\Json\\Create.json");
		System.out.println(test);

	}

}
