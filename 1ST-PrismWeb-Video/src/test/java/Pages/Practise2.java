package Pages;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


//import Pages.OrgObjects;


//import Pages.OrgObjects;
public class Practise2 {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
//		ChromeDriver driver= new ChromeDriver();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("password")).sendKeys("learning");
		driver.findElement(By.cssSelector("label:nth-child(2)")).click();
//		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select option=new Select(dropdown);
		option.selectByVisibleText("Student");
		driver.findElement(By.id("signInBtn")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-info")));
		List<WebElement> products=driver.findElements(By.cssSelector(".btn.btn-info"));
		for(int i=0;i<products.size();i++)
		{
			products.get(i).click();
		}
		driver.findElement(By.partialLinkText("Checkout")).click();
		
		
	}
	
}