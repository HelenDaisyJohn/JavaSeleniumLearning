import java.net.URI;
import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogCapture {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
//		Ontest Failure-Listener
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.partialLinkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
//		Get log entry objects
		LogEntries entry=driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs=entry.getAll();
		for(LogEntry e:logs)
		{
			System.out.println(e.getMessage());
		}
	
	}

}
