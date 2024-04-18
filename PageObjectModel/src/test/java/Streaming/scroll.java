package Streaming;

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
import org.openqa.selenium.support.ui.WebDriverWait;

public class scroll {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
		//ChromeDriver driver= new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://prism-web-feature-stm-309-vod-player.dev.1stbet.com/");
		System.out.println("Title is"+driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id='root']/div/div/div/div[2]/button")).click();
//		driver.sleep(2000);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		Thread.sleep(2000);
		List<WebElement> allRows1= driver.findElements(By.xpath("//div[@role='row']"));
		int size1= allRows1.size();
		
		System.out.println("Rows size is " +size1);
		
		for(int i=0;i<size1;i++)
		{
			List<WebElement> orgRows1= allRows1.get(i).findElements(By.xpath("//div[@role='row']"));
			WebElement data1 = orgRows1.get(i);
			String text= data1.getText();
			System.out.println(text);
					
			if (text.equals("LSOGG-TSG"))
			{
//				cols.get(i).findElement(By.xpath("//div[@data-field='shortName']")).click();
				WebElement selectedOrg = orgRows1.get(1).findElement(By.xpath("//div[@class='MuiDataGrid-cellContent']"));
				selectedOrg.click();
				break;
			}
			System.out.println("");
		}
		
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.querySelector(\"div[class$='MuiDataGrid-virtualScroller css-1w5m2wr-MuiDataGrid-virtualScroller']\").scrollTop=600");
		Thread.sleep(2000);
//		
//		WebElement search=driver.findElement(By.cssSelector(".MuiDataGrid-row[data-id='org/1ST-DQHXI']"));
//		Thread.sleep(5000);
//		Select select=new Select(search);
//		select.selectByVisibleText("1ST-DQHXI");
//		@SuppressWarnings("deprecation")
//		EventFiringWebDriver eventFiringWebDriver= new EventFiringWebDriver(driver);
//		eventFiringWebDriver.executeScript()
//		
		
//		js.executeScript("window.scroll(0,500)","");
		Thread.sleep(2000);
		List<WebElement> allRows11= driver.findElements(By.xpath("//div[@role='row']"));
		int size11= allRows11.size();
		
		System.out.println("Rows size is " +size11);
		
		for(int i=0;i<size11;i++)
		{
			List<WebElement> orgRows1= allRows11.get(i).findElements(By.xpath("//div[@role='row']"));
			WebElement data1 = orgRows1.get(i);
			String text= data1.getText();
			System.out.println(text);
					
			if (text.equals("LSOGG-TSG"))
			{
//				cols.get(i).findElement(By.xpath("//div[@data-field='shortName']")).click();
				WebElement selectedOrg = orgRows1.get(1).findElement(By.xpath("//div[@class='MuiDataGrid-cellContent']"));
				selectedOrg.click();
				break;
			}
			System.out.println("");
		}
		
//		js.executeScript("window.scroll(0,-500)","");
		js.executeScript("document.querySelector(\"div[class$='MuiDataGrid-virtualScroller css-1w5m2wr-MuiDataGrid-virtualScroller']\").scrollTop=1000");
		Thread.sleep(2000);
		List<WebElement> allRows111= driver.findElements(By.xpath("//div[@role='row']"));
		int size111= allRows111.size();
		
		System.out.println("Rows size is " +size111);
		
		for(int i=0;i<size111;i++)
		{
			List<WebElement> orgRows1= allRows111.get(i).findElements(By.xpath("//div[@role='row']"));
			WebElement data1 = orgRows1.get(i);
			String text= data1.getText();
			System.out.println(text);
					
			if (text.equals("Test_Org"))
			{
//				cols.get(i).findElement(By.xpath("//div[@data-field='shortName']")).click();
				WebElement selectedOrg = orgRows1.get(1).findElement(By.xpath("//div[@class='MuiDataGrid-cellContent']"));
				selectedOrg.click();
				break;
			}
			System.out.println("");
		}
		
		
//		WebElement target= driver.findElement(By.xpath("(//div[contains(text(),'KCGRT')])[1]"));
//		Actions actions=new Actions(driver);
//		actions.scrollToElement(target).perform();
		
//		Select selecting=new Select(search);
//		selecting.selectByVisibleText("org-VQKRF");
		
		
		

}
}
