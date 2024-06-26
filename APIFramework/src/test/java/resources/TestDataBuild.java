package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddLocation;
import pojo.AddPlace;

public class TestDataBuild {
	public AddPlace addPlacePayload(String name, String language, String address)
	{
		AddPlace ap=new AddPlace();
		ap.setAccuracy(50);
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setName(name);
		ap.setWebsite("http://google.com");
		
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		ap.setTypes(myList);
		
		AddLocation l=new AddLocation();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		return ap;
	}
	
	public String deletePlacePayload(String placeId) {
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}

}
