package Test;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class drivenTest {
	
	@Test
	public void addBook() throws IOException
	{
		HashMap<String, Object> map=new HashMap<>();
		map.put("name","RestAssured1223");
		map.put("isbn","testqwesa");
		map.put("aisle","123adxd");
		map.put("author","Rahulxds");
		RestAssured.baseURI="http://216.10.245.166";
		String resp=given().header("Content-Type","application/json")
//				.body("{\r\n"
//						+ "\"name\":\"Learn Appium Automation with Java-01\",\r\n"
//						+ "\"isbn\":\"bcdq\",\r\n"
//						+ "\"aisle\":\"227qw\",\r\n"
//						+ "\"author\":\"John foel\"\r\n"
//						+ "}\r\n"
//						+ "")
				.body(map)
				.when().post("/Library/Addbook.php").then().log().all().extract().response().asString();
		JsonPath js=new JsonPath(resp);
		String id=js.getString("ID");
		System.out.println(id);
		
		
	
	}

}
