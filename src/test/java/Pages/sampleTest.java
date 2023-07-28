package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sampleTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
		//ChromeDriver driver= new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://prism-web-hotfix-stm-prism-xpressbet.preprod.1stbet.com/");
		System.out.println("Title is"+driver.getTitle());
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='root']/div/div/div/div[2]/button")).click();
//		driver.sleep(2000);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		Alert until=wait.until(ExpectedConditions.textToBePresentInElement(null, null))
		driver.findElement(By.xpath("(//input[@id='Input_Username'])[1]")).sendKeys("admin@1st.com");
		driver.findElement(By.xpath("(//input[@id='Input_Password'])[1]")).sendKeys("admin");
//		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='login']")));
		driver.findElement(By.xpath("//button[@value='login']")).click();
//		driver.findElement(By.xpath("//button[@value='login']")).click();
		
//		Navigate to Core
		driver.findElement(By.xpath("//button[@aria-label='menu']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Core']")).click();
		driver.findElement(By.xpath("//p[normalize-space()='Organization']")).click();
		
		
		List<WebElement> Rows= driver.findElements(By.xpath("//div[@role='row']"));
		int totalRows= Rows.size();
		System.out.println("Total Rows:"+totalRows);
		
		List<WebElement> allRows= driver.findElements(By.xpath("//div[@role='row']"));
		int rowsize= allRows.size();
		
		System.out.println("Rows size is " +rowsize);
//		
		List<WebElement> allColumns= driver.findElements(By.xpath("//div[@role='columnheader']"));
		int colSize= allColumns.size();
		System.out.println("Column size is " +colSize);
		
		
		//specify the WebElement till which the page has to be scrolled
	    WebElement element1 =(driver.findElement(By.xpath("//p[normalize-space()='org-QLDMX']")));
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();", element1);
	    Thread.sleep(2000);
	    
	    WebElement element2 =(driver.findElement(By.xpath("//p[normalize-space()='70cec5ae-2ddb-4']")));
	    JavascriptExecutor js1=(JavascriptExecutor)driver;
	    js1.executeScript("arguments[0].scrollIntoView();", element2);
	    
	    
	    WebElement element3 =(driver.findElement(By.xpath("//p[normalize-space()='O-CCRIU']")));
	    JavascriptExecutor js2=(JavascriptExecutor)driver;
	    js2.executeScript("arguments[0].scrollIntoView();", element3);
	   
	    
	  
//		js.executeScript("window.scroll(0,2500)");
		js.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		driver.findElement(By.xpath("//p[@class='MuiTablePagination-displayedRows css-12aoau8']")).getText();
		System.out.println("Total Rows:"+totalRows);
		
	}
}
		
