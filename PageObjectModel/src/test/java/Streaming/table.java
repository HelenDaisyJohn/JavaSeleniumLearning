package Streaming;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class table {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\ChromeDriver\\chromedriver.exe");
		//ChromeDriver driver= new ChromeDriver();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://prism-web.dev.1stbet.com/");
		System.out.println("Title is"+driver.getTitle());
		driver.findElement(By.xpath("//*[@id='root']/div/div/div/div[2]/button")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		Alert until=wait.until(ExpectedConditions.textToBePresentInElement(null, null))
		driver.findElement(By.xpath("(//input[@id='Input_Username'])[1]")).sendKeys("admin@1st.com");
		driver.findElement(By.xpath("(//input[@id='Input_Password'])[1]")).sendKeys("admin");
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='login']")));
		element.click();
//		driver.findElement(By.xpath("//button[@value='login']")).click();
		
//		Navigate to Core
		driver.findElement(By.xpath("//button[@aria-label='menu']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Core']")).click();
		driver.findElement(By.xpath("//p[normalize-space()='Organization']")).click();
		
		
//		WebElement frame1=driver.findElement(By.name("MuiDataGrid-main css-204u17-MuiDataGrid-main"));
//		driver.switchTo().frame(frame1);
		
		List<WebElement> allRows= driver.findElements(By.xpath("//div[@role='row']"));
		int size= allRows.size();
		System.out.println("Rows size is " +size);
		
		
		
		
	}
}
	
