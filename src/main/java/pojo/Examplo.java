package pojo;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;


public class Examplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String place_id="968e925943b8a2931ba0b757f838d78c";

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "    \"place_id\": \""+ place_id +"\"\r\n"
				+ "}")
		.when().delete("/maps/api/place/delete/json?key=qaclick123 ")
		.then().extract().response().asString();
		
		System.out.println("The place id: "+place_id +" has been deleted");
		
		 
	
	}

}
