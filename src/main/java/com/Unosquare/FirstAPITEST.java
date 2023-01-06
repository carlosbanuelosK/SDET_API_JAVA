package com.Unosquare;

import static io.restassured.RestAssured.given;

public class FirstAPITEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		given().log().all()
		 .when().get("https://reqres.in/api/users/2")
		 .then().assertThat().log().all().statusCode(200).extract().asString();
		
		given().log().all()
		 .when().get("https://reqres.in/api/unknown/2")
		 .then().assertThat().log().all().statusCode(200).extract().asString();
	}

}
