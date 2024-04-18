package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import Pages.OrgObjects;
import Pages.OrgUnitObjects;

public class OrgUnitTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://prism-web.dev.1stbet.com");
		driver.manage().window().maximize();
	
//		create object
		OrgObjects OrgUnit=new OrgObjects(driver);
//		OrgUnit.

	}

}
