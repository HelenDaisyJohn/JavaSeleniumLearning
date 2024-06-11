Feature: Validating the place API's
@AddPlace
Scenario: Verify whether place is being successfully
Given Add PlacePayload with "<name>" "<language>" "<address>"
When User calls "AddPlaceAPI" with "post" API request
Then the API calls got success with 200
And "status" in response body as "OK"
And "scope" in response body as "APP"
And verify place_Id created maps to "<name>" using "getPlaceAPI"


Examples:
	|name					|language			|address									|
	|AAhouse			|English			|World cropostss center				|
#	|BBhouse1			|Spanish			|Sea cross center	1				|

@DeletePlace
Scenario: Verify if Delete place functionality is working
Given: DeletePlace Payload
When User calls "deletePlaceAPI" with "post" API request
Then the API calls got success with 200
And "status" in response body as "OK"



	


















