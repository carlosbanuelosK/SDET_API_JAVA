package stepDefinations;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	JsonPath js;
	static String place_id;
	static String partialCode;

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {

		res = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));

	}
	
	@Given("Delete Place Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		place_id= "f68e1e428501eba12a9b7c27cd96f1fc";
		if(place_id == null) {
			String text; 
	        FileReader f = new FileReader("C:\\Users\\carlos.banuelos\\eclipse-workspace\\APIFramework\\pid"); 
	        BufferedReader b = new BufferedReader(f); 
	        while((text = b.readLine())!=null) { 
	        	partialCode = text.split("place_id=")[1];
	        } 
	       // place_id = partialCode;
	        res = given().spec(requestSpecification()).body(data.deleteBuildPayload(partialCode));
	        
	        b.close(); 
		}else {
			res = given().spec(requestSpecification()).body(data.deleteBuildPayload(place_id));
		}
	        
	        
		
	}


	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {

		//Constructor will be called with value of resoruces wich you pass
		
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (method.equalsIgnoreCase("POST")) {
			response = res.when().post(resourceAPI.getResource());
		}
		else if(method.equalsIgnoreCase("GET")) {
			response = res.when().get(resourceAPI.getResource());
		}
	}

	@Then("The response API call is Success with status code {int}")
	public void the_response_api_call_is_success_with_status_code(Integer int1) {

		assertEquals(response.getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {

		assertEquals(getJsonPath(response ,keyValue), expectedValue);

	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		//Request Spec
		place_id = getJsonPath(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET");
		String actualName = getJsonPath(response, "name");
		assertEquals(actualName, expectedName);
		Utils.PlaceId(place_id);
		 
	}
}
