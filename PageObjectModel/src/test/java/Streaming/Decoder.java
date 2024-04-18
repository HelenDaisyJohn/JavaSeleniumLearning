package Streaming;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Decoder {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
		//ChromeDriver driver= new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://prism-web.dev.1stbet.com/");
		driver.manage().window().maximize();
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
		
//		Navigate to Video
		driver.findElement(By.xpath("//button[@aria-label='menu']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Video']")).click();
		
//		select org
		driver.findElement(By.xpath("//div[@id=':r0:']")).click();
		
		
		List<WebElement> allOptions= driver.findElements(By.xpath("(//li[@role='option'])"));
		for(WebElement option:allOptions)
		{
//			System.out.println(option.getText());
			if(option.getText().equals("Test_Org"))
			{
				option.click();
				break;
			}
		}

		driver.findElement(By.xpath("//div[@id=':r1:']")).click();
		List<WebElement> allOptions1= driver.findElements(By.xpath("(//li[@role='option'])"));
		for(WebElement option1:allOptions1)
		{
//			System.out.println(option.getText());
			if(option1.getText().equals("Unit_01"))
			{
				option1.click();
				break;
			}
		}
		
		
//Decoder
		driver.findElement(By.xpath("//p[normalize-space()='Video Decoder']")).click();
		driver.findElement(By.xpath("//button[@title='Add Video Decoder']")).click();
		
//Add Decoder with Vendor Phenix
		driver.findElement(By.xpath("//input[@id='Decoder-Name']")).sendKeys("Decoder-05");
		driver.findElement(By.xpath("//input[@id='Decoder-ID']")).sendKeys("Dec-05");
		driver.findElement(By.xpath("//input[@id='Vendor-Channel-Identifier']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@id='Project-id']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@id='Zone']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@id='Instance-name']")).sendKeys("12");
		Thread.sleep(1000);
		WebElement target= driver.findElement(By.xpath("(//button[normalize-space()='Add'])[1]"));
		Actions actions=new Actions(driver);
		actions.scrollToElement(target).click();
		
//		Success message
		WebElement Drop=driver.findElement(By.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
		String drop12=Drop.getText();
		System.out.println("Message is:" +drop12);
		Assert.assertEquals("Decoder Successfully Added", drop12, "Please enter valid Decoder");
		
		
		
//		driver.findElement(By.xpath("(//button[normalize-space()='Add'])[1]")).click();
//		
//		
//		driver.findElement(By.xpath("(//input[@id=':rbh:'])[1]")).sendKeys("Encoder-03");
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
//		driver.findElement(By.xpath("//*[@data-value='org/org-IRSAP']")).click();
//		
//		
//		String selectedOrg="Test_Org";
//		JavascriptExecutor je = (JavascriptExecutor) driver;
//        WebElement element1 = driver.findElement(By.xpath("//*[@data-value="+ selectedOrg +"']"));
//        je.executeScript("arguments[0].scrollIntoView(true);",element1);
//        element1.click();
//        Thread.sleep(4000);
//		
//		
//		WebElement orgUnit=driver.findElement(By.xpath("//div[@class='MuiBox-root css-os8c3x'][2]/div/div"));
//		orgUnit.click();
		
		
		
		
	}

}
