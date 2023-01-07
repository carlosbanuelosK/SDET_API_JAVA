package com.unosquare;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.TestDataBuild;

public class apiPost {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI ="https://reqres.in/";
		String response = given().log().all()
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\carlos.banuelos\\eclipse-workspace\\API\\Json\\Create.json"))))
		.when().post("/api/users")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		System.out.println(response);
		
		RestAssured.baseURI ="https://reqres.in/";
		String response2 = given().log().all()
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\carlos.banuelos\\eclipse-workspace\\API\\Json\\Register.json"))))
		.when().post("/api/login")
		.then().log().all().assertThat().statusCode(400).extract().response().asString();
		System.out.println(response2);
		
	}

}
