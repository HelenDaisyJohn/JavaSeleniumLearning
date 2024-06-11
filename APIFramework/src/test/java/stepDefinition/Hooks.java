package stepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		StepDefinition m=new StepDefinition();
		if(m.place_id==null)
		m.add_place_payload_with("Shetty", "French", "Asia");
		m.user_calls_with_http_api_request("deletePlaceAPI", "POST");
		m.verify_place_Id_created_maps_to_using("Shetty", "grtPlaceAPI");
	}

}
