package Pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practise3 {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> page=driver.getWindowHandles();
		java.util.Iterator<String> it=page.iterator();
		String parentWindow=it.next();
		driver.switchTo().window(it.next());
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		
		//		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText().split("New")[1].trim());

		
		

	}

}