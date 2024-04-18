package Streaming;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Encoder {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
		//ChromeDriver driver= new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://prism-web-feature-stm-450-updating-validation-and-date-search.dev.1stbet.com/");
		driver.manage().window().maximize();
		System.out.println("Title is"+driver.getTitle());
		System.out.println("");
		
		
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
		
//		Navigate to Video
		driver.findElement(By.xpath("//button[@aria-label='menu']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Video']")).click();
		
//		select org
		driver.findElement(By.xpath("//div[@id=':r0:']")).click();
		
		
		List<WebElement> allOptions= driver.findElements(By.xpath("(//li[@role='option'])"));
		for(WebElement option:allOptions)
		{
//			System.out.println(option.getText());
			if(option.getText().equals("Test-Org"))
			{
				option.click();
				break;
			}
		}
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("//div[@id=':r1:']")).click();
		List<WebElement> allOptions1= driver.findElements(By.xpath("(//li[@role='option'])"));
		for(WebElement option1:allOptions1)
		{
			System.out.println(option1.getText());
			if(option1.getText().equals("Unit_01"))
			{
				option1.click();
				break;
			}
		}
		
		
//Encoder
		driver.findElement(By.xpath("//p[normalize-space()='Video Encoder']")).click();

//		List all Encoder Identifier
		List<WebElement> identifiers= driver.findElements(By.xpath("(//div[@role='row'])"));
		for(WebElement identifier:identifiers)
		{
			System.out.println(identifier.getText());
			if(identifier.getText().equals("zz"))
			{
				System.out.println("The identifier name is: "  +identifier.getText());
				System.out.println("");
				break;
			}
			else
			{
				System.out.println("The Encoder details are: " +identifier.getText() );
				System.out.println("");
			}
		}
		
//		Verify whether the action column has two options 
		driver.findElement(By.xpath("(//div[@role='menu'])[1]")).click();
		List<WebElement> actionOptions= driver.findElements(By.xpath("//li[@role='menuitem']"));
		for(WebElement actionOption:actionOptions)
		{
			System.out.println("The Action Column options is: "  +actionOption.getText());
		}
		
		System.out.println("");
		
		
//		Verify whether the decoder is deleted
		driver.findElement(By.xpath("//li[normalize-space()='Delete']")).click();
		driver.findElement(By.xpath("(//button[contains(@type,'button')][normalize-space()='Yes'])[2]")).click();
		System.out.println("The Encoder is deleted ");
		
//		//		Success message
		WebElement message=driver.findElement(By.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
		String message1=message.getText();
		System.out.println("Message is:" +message1);
		Assert.assertEquals("Video Encoder Successfully Deleted", message1, "Video Encoder Successfully Deleted");
		System.out.println("");
		
		
		
//		Verify whether update the Encoder(//button[contains(@type,'button')][normalize-space()='Yes'])[2]
		
		
//		WebElement Target= driver.findElement(By.xpath("//div[@data-id='org/org-QMDLI']")).click();
		
		
		
//		Verify whether the encoder is deleted
		List<WebElement> identifiers1= driver.findElements(By.xpath("(//div[@role='row'])"));
		for(WebElement identifier:identifiers1)
		{
			System.out.println(identifier.getText());
			Thread.sleep(1000);
			if(identifier.getText().equals("Display Name"))
			{
//				driver.findElement(By.xpath("(//div[@role='menu'])[1]")).click();
//				driver.findElement(By.xpath("//li[normalize-space()='Delete']")).click();
//				WebElement iden = driver.findElement(By.xpath("//div[@aria-labelledby=':rko:']//p[@id='alert-dialog-slide-description']"));
//				System.out.println("Message is:" +iden.getText());
//				driver.findElement(By.xpath("//div[contains(@aria-labelledby,':rko:')]//button[contains(@type,'button')][normalize-space()='Yes']")).click();
//		
				System.out.println("Message is:" );
				
			}
			
		}
		
		
		
//		
		
		
		
		
		
//		OrgOptions.selectByVisibleText("org-IRSAP");
//		OrgOptions.selectByIndex(3);
//		OrgOptions.selectByValue("org-IRSAP");
		
		
//		List<WebElement>allOptions= OrgOptions.getOptions();
//		for(WebElement option:allOptions)
//		{
//			if(option.getText().equals("Test_Org"))
//			{
//				option.click();
//				break;
//			}
//		}
//		driver.findElement(By.xpath("//*[@data-value='org/org-IRSAP']")).click();   (By.xpath("//*[@data-value="+ selectedOrg +"']"));
//		
//			(//div[@data-id="+selectedOrg+"'])[1]
		
		Thread.sleep(4000);
		String selectedOrg="yy";
		
		
		
//		JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element1 = driver.findElement(By.xpath("(//div[@data-id='"+selectedOrg+"'])[1]"));
        Actions actions= new Actions(driver);
        actions.scrollToElement(element1).perform();
        
        
//        je.executeScript("arguments[0].scrollIntoView(true);",element1);
//        element1.click();
        Thread.sleep(4000);
//		
//		
//		WebElement orgUnit=driver.findElement(By.xpath("//div[@class='MuiBox-root css-os8c3x'][2]/div/div"));
//		orgUnit.click();
		
		
		
		
	}
}
