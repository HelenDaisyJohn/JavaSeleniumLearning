import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v122.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		
		devTools.createSession();
//		Send command to CDP Method (https://chromedevtools.github.io/devtools-protocol/tot/Emulation/)
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		Thread.sleep(7000);
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
//		driver.findElement(By.linkText("Library")).click();
		
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

	}

}
