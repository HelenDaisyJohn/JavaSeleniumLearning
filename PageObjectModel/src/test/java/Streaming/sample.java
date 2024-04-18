package Streaming;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sample {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\ChromeDriver\\chromedriver.exe");
		//ChromeDriver driver= new ChromeDriver();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://prism-web.dev.1stbet.com/");
		
		System.out.println("Title is"+driver.getTitle());
		driver.findElement(By.xpath("//*[@id='root']/div/div/div/div[2]/button")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.findElement(By.xpath("(//input[@id='Input_Username'])[1]")).sendKeys("admin@1st.com");
		driver.findElement(By.xpath("(//input[@id='Input_Password'])[1]")).sendKeys("admin");
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='login']")));
		element.click();

		
//		Navigate to Core
		driver.findElement(By.xpath("//button[@aria-label='menu']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Core']")).click();
		driver.findElement(By.xpath("//p[normalize-space()='Organization']")).click();
		
		//First half of the webtable
		List<WebElement> allRows1= driver.findElements(By.xpath("//div[@role='row']"));
		Thread.sleep(1000);		
		int rowsize1= allRows1.size();
		System.out.println("Rows size is " +rowsize1);
		List<WebElement> allColumns1= driver.findElements(By.xpath("//div[@role='columnheader']"));
		int colSize1= allColumns1.size();
		System.out.println("Columns size is " +colSize1);
		for(int i=1;i<=rowsize1;i++)
		{
			for (int j=1;j<=colSize1;j++)
			{
			System.out.println(driver.findElement(By.xpath("(//div[@role='row'])["+ i +"]/div["+ j +"]")).getText());
			Thread.sleep(1000);			
			}
			System.out.println("");
		}
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500)","");
		Thread.sleep(2000);
//		js.executeScript("window.scroll(0,-500)","");
		js.executeScript("document.querySelector(\"div[class$='MuiDataGrid-virtualScroller css-1w5m2wr-MuiDataGrid-virtualScroller']\").scrollTop=5000");
		
		
		List<WebElement> allRows= driver.findElements(By.xpath("//div[@role='row']"));
		int rowsize= allRows.size();
		System.out.println("Rows size is " +rowsize);
		List<WebElement> allColumns= driver.findElements(By.xpath("//div[@role='columnheader']"));
		int colSize= allColumns.size();
		System.out.println("Columns size is " +colSize);
		for(int i=1;i<=rowsize;i++)
		{
			for (int j=1;j<=colSize;j++)
			{
			System.out.println(driver.findElement(By.xpath("(//div[@role='row'])["+ i +"]/div["+ j +"]")).getText());
			Thread.sleep(1000);			
				}
			System.out.println("");
		}
		
	}
}
