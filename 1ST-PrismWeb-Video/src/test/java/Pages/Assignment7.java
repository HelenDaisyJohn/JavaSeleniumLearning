package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		WebElement table=driver.findElement(By.cssSelector(".table-display"));
		System.out.println("Table Rows in the table is:"+table.findElements(By.tagName("tr")).size());
		System.out.println("Table columns in the table is:"+table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		List<WebElement> secondRow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println("The Row value is:"+secondRow.get(0).getText());
		System.out.println("The Row value is:"+secondRow.get(1).getText());
		System.out.println("The Row value is:"+secondRow.get(2).getText());
	
	
	}
	}

