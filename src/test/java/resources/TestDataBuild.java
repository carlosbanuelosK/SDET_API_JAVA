package resources;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import io.restassured.RestAssured;


public class TestDataBuild {
	
	public static String Add(String path) throws IOException {
		RestAssured.baseURI = "https://reqres.in/";
		String response = given().log().all().body(new String(Files.readAllBytes(Paths.get(path)))).when()
				.post("/api/users").then().log().all().assertThat().statusCode(201).extract().response().asString();
		return response;
	}
	
	public static String Add2(String path) throws IOException {
		RestAssured.baseURI ="https://reqres.in/";
		String response = given().log().all()
		.body(new String(Files.readAllBytes(Paths.get(path))))
		.when().post("/api/register")
		.then().log().all().assertThat().statusCode(400).extract().response().asString();
		return response;
	}
	
	public static String Add3(String path) throws IOException {
		RestAssured.baseURI ="https://reqres.in/";
		String response = given().log().all()
		.body(new String(Files.readAllBytes(Paths.get(path))))
		.when().post("/api/register")
		.then().log().all().assertThat().statusCode(400).extract().response().asString();
		return response;
	}
	
	public static String Add4(String path) throws IOException {
		RestAssured.baseURI ="https://reqres.in/";
		String response = given().log().all()
		.body(new String(Files.readAllBytes(Paths.get(path))))
		.when().post("/api/login")
		.then().log().all().assertThat().statusCode(400).extract().response().asString();
		return response;
	}
	
	public static void Get1() {
		given().log().all()
		 .when().get("https://reqres.in/api/users?page=2")
		 .then().assertThat().log().all().statusCode(200).extract().asString();
	}
	
	public static void Get2() {
		given().log().all()
		 .when().get("https://reqres.in/api/users/2")
		 .then().assertThat().log().all().statusCode(200).extract().asString();
	}
	public static void Get3() {
		given().log().all()
		 .when().get("https://reqres.in/api/users/23")
		 .then().assertThat().log().all().statusCode(404).extract().asString();
	}
	public static void Get4() {
		given().log().all()
		 .when().get("https://reqres.in/api/unknown")
		 .then().assertThat().log().all().statusCode(200).extract().asString();
	}
	
	public static String Update(String path) throws IOException {
		RestAssured.baseURI ="https://reqres.in/";
		String response = given().log().all()
		.body(new String(Files.readAllBytes(Paths.get(path))))
		.when().put("/api/user/2")
		.then().log().all().assertThat().statusCode(400).extract().response().asString();
		return response;
	}

}
