import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v122.fetch.Fetch;
import org.openqa.selenium.devtools.v123.network.Network;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		
		devTools.createSession();
		
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(),request->
		{
			if(request.getRequest().getUrl().contains("shetty"))
			{
				String MockedUrl= request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(MockedUrl);
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(MockedUrl), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		}
			else
				
			{
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
			}
			
		
	});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Library")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("p")).getText());

}
}
