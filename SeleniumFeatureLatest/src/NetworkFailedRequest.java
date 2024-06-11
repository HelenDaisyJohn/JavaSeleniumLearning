import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v122.fetch.Fetch;
import org.openqa.selenium.devtools.v122.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v122.network.model.ErrorReason;

public class NetworkFailedRequest {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		
		devTools.createSession();
		Optional<List<RequestPattern>> patterns=Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBooks*"),Optional.empty(), Optional.empty())));;
		
		devTools.send(Fetch.enable(patterns,Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request ->
		{
			devTools.send(Fetch.failRequest(request.getRequestId(),ErrorReason.FAILED));
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Library")).click();
		Thread.sleep(3000);
//		System.out.println(driver.findElement(By.cssSelector("p")).getText());


	}
}
