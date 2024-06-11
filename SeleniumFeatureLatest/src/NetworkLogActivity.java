import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v123.network.Network;
import org.openqa.selenium.devtools.v123.network.model.Request;
import org.openqa.selenium.devtools.v123.network.model.Response;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.addListener(Network.requestWillBeSent(), request->{
			Request req=request.getRequest();
			System.out.println(req.getUrl());
		});
		
		
		devTools.addListener(Network.responseReceived(), response->{
			Response res=response.getResponse();

			System.out.println(res.getStatus());
			if(res.getStatus().toString().startsWith("4"));
			{
			System.out.println(res.getUrl()+" is failing with the status code"+res.getStatus());
			
			}
			
			
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Library")).click();

	}

}
