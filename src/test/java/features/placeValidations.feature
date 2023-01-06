Feature: Validating Place API's
@AddPlace @Regression
Scenario Outline: Verify id Place is being Succesfully added using AddPlaceAPI
		Given Add Place Payload with "<name>" "<language>" "<address>"
		When User calls "AddPlaceAPI" with "POST" http request
		Then The response API call is Success with status code 200
		And "status" in response body is "OK"
		And "scope" in response body is "APP" 
		And verify place_Id created maps to "<name>" using "GetPlaceAPI"
	
	Examples:
		|name      |language |address           |
		|UnoHouse  |English  |World cross center|
		#|Squhouse  |Spanish  |Sea cross center  |
		
@DeletePlace @Regression
Scenario: Verify if deleted place functionality is working
		Given Delete Place Payload
		When User calls "DeletePlaceAPI" with "POST" http request
		Then The response API call is Success with status code 200
		And "status" in response body is "OK"
