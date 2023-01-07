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

}
