package com.unosquare;

import java.io.IOException;

import resources.TestDataBuild;

public class Encapsulation {

	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//POST
		String test = TestDataBuild.Add("C:\\Users\\carlos.banuelos\\eclipse-workspace\\API\\Json\\Create.json");
		String test2 = TestDataBuild.Add("C:\\Users\\carlos.banuelos\\eclipse-workspace\\API\\Json\\Register.json");
		String test3 = TestDataBuild.Add("C:\\Users\\carlos.banuelos\\eclipse-workspace\\API\\Json\\Register.json");
		String test4 = TestDataBuild.Add("C:\\Users\\carlos.banuelos\\eclipse-workspace\\API\\Json\\Register.json");

		System.out.println(test);
		System.out.println(test2);
		System.out.println(test3);
		System.out.println(test4);
		
		System.out.println("-------------------------------- Get API ---------------------------------");
		//GET
		TestDataBuild.Get1();
		TestDataBuild.Get2();
		TestDataBuild.Get3();
		TestDataBuild.Get4();
		
		System.out.println("-------------------------------- Update API ---------------------------------");
		
		String update = TestDataBuild.Add("C:\\Users\\carlos.banuelos\\eclipse-workspace\\API\\Json\\Update.json");
		System.out.println(update);
		
		
	}
}
