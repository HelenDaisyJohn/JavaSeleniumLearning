package Streaming;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class search {
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.findElement(By.xpath("(//input[@id='Input_Username'])[1]")).sendKeys("admin@1st.com");
		driver.findElement(By.xpath("(//input[@id='Input_Password'])[1]")).sendKeys("admin");
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='login']")));
		element.click();
		
//		Navigate to Core
		driver.findElement(By.xpath("//button[@aria-label='menu']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Core']")).click();
		driver.findElement(By.xpath("//p[normalize-space()='Organization']")).click();
		
//		search data
//		WebElement search=driver.findElement(By.xpath("//*[@id='root']/div/div/div/div[2]/button"));
//		WebElement frame1=driver.findElement(By.xpath("//div[@class='MuiDataGrid-virtualScroller css-1w5m2wr-MuiDataGrid-virtualScroller']"));
//		driver.switchTo().frame(frame1);
		//First half of the webtable
		List<WebElement> allRows1= driver.findElements(By.xpath("//div[@role='row']"));
		Thread.sleep(1000);		
		int rowsize1= allRows1.size();
		System.out.println("Rows size is " +rowsize1);
		List<WebElement> allColumns1= driver.findElements(By.xpath("//div[@role='columnheader']"));
		int colSize1= allColumns1.size();
		System.out.println("Columns size is " +colSize1);
//		Assert.assertEquals(colSize1, 5,"Row missmatched");
		for(int i=1;i<=rowsize1;i++)
		{
			for (int j=1;j<=colSize1;j++)
			{
			System.out.println(driver.findElement(By.xpath("(//div[@role='row'])["+ i +"]/div["+ j +"]")).getText());
			Thread.sleep(1000);			
			}
			System.out.println("");
		}
		String dataPage=(driver.findElement(By.xpath("//div[@class='MuiDataGrid-row MuiDataGrid-row--lastVisible']"))).getAttribute("data-rowindex");
		System.out.println("The no of org in a page: 0-"+dataPage );
//		JavascriptExecutor js= (JavascriptExecutor)driver;
//		js.executeScript("document.querySelector(\"div[class$='MuiDataGrid-virtualScroller css-1w5m2wr-MuiDataGrid-virtualScroller']\").scrollTop=5000");
		String org= "Test_Org";
		
		String attributes=(driver.findElement(By.className("MuiDataGrid-row"))).getAttribute("data-id");
//		int size=attributes.size();
//		List<WebElement> allRows= driver.findElements(By.xpath("//div[@role='row']"));
//		int rowSize= allRows.size();
		System.out.println("Org name is " +attributes);
		
		if (attributes.equals("org/1ST"))
		{
			driver.findElement(By.xpath("//div[@data-id='"+attributes+"']/div[1]")).click();
		}
		
		
//		//div[@data-rowindex='0']
//		List<WebElement> allColumns= driver.findElements(By.xpath("//div[@role='columnheader']"));
//		int colSize= allColumns.size();
//		System.out.println("Columns size is " +colSize);
//		for(int i=1;i<=rowSize;i++)
//		{
//			for (int j=1;j<=colSize;j++)
//			{
//			String text=driver.findElement(By.xpath("(//div[@role='row'])["+ i +"]/div["+ j +"]")).getText();
//			System.out.println("" +text);
//			Thread.sleep(1000);			
//				
//			System.out.println("");
//			if (text.equals("Test28"))
//			{
////				cols.get(i).findElement(By.xpath("//div[@data-field='shortName']")).click();
//				WebElement selectedOrg = allRows.get(1).findElement(By.xpath("//div[@class='MuiDataGrid-cellContent']"));
//				selectedOrg.click();
//				break;
//			}
//			}
//			System.out.println("");
		
		
		
		
	
		
		
	}
}


