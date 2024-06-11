import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		
		devTools.createSession();
		Map<String,Object>coordinates=new HashMap<String,Object>();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
//		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		WebElement netflix=driver.findElement(By.xpath("//h3[contains(text(),'Netflix - Watch TV Shows Online, Watch Movies Onli')]"));
		netflix.click();
//		((WebElement) driver.findElements(By.xpath("//h3[contains(text(),'Netflix - Watch TV Shows Online, Watch Movies Onli']"))).click();
		String title=driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		System.out.println(title);
		
	}

}
