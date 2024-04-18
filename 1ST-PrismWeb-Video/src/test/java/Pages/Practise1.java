package Pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import Pages.OrgObjects;


//import Pages.OrgObjects;
public class Practise1 {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.findElement(By.name("name")).sendKeys("Helen");
		driver.findElement(By.name("email")).sendKeys("test@abc.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("123");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select abc = new Select(dropdown);
		abc.selectByVisibleText("Female");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("05/08/1997");
		driver.findElement(By.cssSelector(".btn-success")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		

	}

}
