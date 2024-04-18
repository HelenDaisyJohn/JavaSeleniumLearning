package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practise {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
//		WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
//		System.out.println(checkbox.getSize());
		WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
		checkbox.click();
		Boolean select=checkbox.isSelected();
		Assert.assertEquals(select, true);
		System.out.println(checkbox.isSelected());
		Thread.sleep(1000);
		checkbox.click();
		Boolean select1=checkbox.isSelected();
		Assert.assertEquals(select1, false);
		System.out.println(checkbox.isSelected());

	
	}

}
