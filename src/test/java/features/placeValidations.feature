Feature: Validating place API's
@AddPlace @Regression
Scenario Outline: Verify if place is being Sucessfully added using AddPlaceAPI
     Given Add Place Payload with "<name>" "<language>"  "<address>"
     When user calls "AddPlaceAPI" with "Post" http request
     Then the API calls got success with status code 200
     And "status" in response body is "OK"
     And "scope" in response body is "APP"
     And verify Place Id created maps to "<name>" using "getPlaceAPI"
     
Examples:
        |name      |language  |address           |
       |AAHouse   |English   |World cross center|    
#       |BBHouse   |Spanish   |Sea cross center| 

@DeletePlace @Regression
Scenario: Verify if Delete Place functionality is working

    Given Delete Place Payload 
     When user calls "deletePlaceAPI" with "Post" http request
    Then the API calls got success with status code 200
     And "status" in response body is "OK"