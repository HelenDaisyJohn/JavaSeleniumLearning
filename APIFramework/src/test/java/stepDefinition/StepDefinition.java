package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddLocation;
import pojo.AddPlace;
import resources.APIResourses;
import resources.TestDataBuild;
import resources.Utils;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;


public class StepDefinition extends Utils{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;	
	TestDataBuild data=new TestDataBuild();
	static String place_id;
	
	@Given("Add PlacePayload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		
//		RestAssured.baseURI="https://rahulshettyacademy.com";
		res=given().spec(requestSpecification()).body(data.addPlacePayload(name,language,address ));		
	}
	
	@When("User calls {string} with {string} API request")
	public void user_calls_with_http_api_request(String resource, String method) {
		
//		Constructor will be called with the resourses
		APIResourses resourceAPI=APIResourses.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();
		if(method.equalsIgnoreCase("POST"))
				response=res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
				response=res.when().get(resourceAPI.getResource());
//		else if(method.equalsIgnoreCase("DELETE"))
//			response=res.when().delete(resourceAPI.getResource());
	}
	
	@Then("the API calls got success with {int}")
	public void the_api_calls_got_success_with_200(Integer int1) {
		assertEquals(response.getStatusCode(),200);
	}
	
	
	@Then("{string} in response body as {string}")
	public void in_response_body_is(String keyValue,String ExpectedValue) {
		assertEquals(getJsonPath(response,keyValue),ExpectedValue);

	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String expectedName,String resource) throws IOException
	{
		place_id=getJsonPath(response, "place_id");
		res=given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_api_request(resource,"GET");
		String actualName=getJsonPath(response,"name");
		assertEquals(actualName,expectedName);
	}
	
//	Delete
	
	@Given("DeletePlace_payload")
	public void DeletePlace_payload() throws IOException  {
		res=given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}
	


	
	
	
}
