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
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Org {

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
		

////		
//		List<WebElement> Rows= driver.findElements(By.xpath("//div[@role='row']"));
//		List<String> Orgs=new ArrayList<String>();
//		
//		for(WebElement Row:Rows)
//		{
//			Orgs.add(Row.getText());
//		
//		}
//		String nextButtonClassName= driver.findElement(By.xpath("//button[@aria-label='Go to next page']")).getAttribute("class");
//		while(!nextButtonClassName.contains("disabled"));
//		
//		{
//			driver.findElement(By.xpath("//button[@aria-label='Go to next page']")).click();
//			Rows= driver.findElements(By.xpath("//div[@role='row']"));
//			
//			for(WebElement Row:Rows)
//			{
//				Orgs.add(Row.getText());
//			
//			}
//			nextButtonClassName= driver.findElement(By.xpath("//button[@aria-label='Go to next page']")).getAttribute("class");
//			
//			
//		}
//		for(String Org:Orgs)
//		{
//			System.out.println(Org);
//		}
//		int totalRows= Rows.size();
//		System.out.println("Total Rows:"+totalRows);
//		
//		List<WebElement> allRows= driver.findElements(By.xpath("//div[@role='row']"));
//		int rowsize= allRows.size();
//		
//		System.out.println("Rows size is " +rowsize);
////		
//		List<WebElement> allColumns= driver.findElements(By.xpath("//div[@role='columnheader']"));
//		int colSize= allColumns.size();
//		System.out.println("Column size is " +colSize);
//		
//		
//		
//		for(int i=1;i<=rowsize;i++)
//		{
//			for (int j=1;j<=colSize;j++)
//			{
//			System.out.println(driver.findElement(By.xpath("(//div[@role='row'])["+ i +"]/div["+ j +"]")).getText());
//			List<WebElement> orgRows= allRows.get(i).findElements(By.xpath("(//div[@role='row'])"));
//			WebElement data = orgRows.get(i);
//			String text= data.getText();
//			System.out.println(text);
//			Thread.sleep(2000);			
//			
//			if (text.equals("Test_Org"))
//			{
////				cols.get(i).findElement(By.xpath("//div[@data-field='shortName']")).click();
//				WebElement selectedOrg = orgRows.get(1).findElement(By.xpath("//div[@class='MuiDataGrid-cellContent']"));
//				selectedOrg.click();
//				break;
//			}
//		}
//			System.out.println("");
//		}
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500)","");
		
		//Page2
//		String nextButtonClassName= driver.findElement(By.xpath("//button[@aria-label='Go to next page']")).getAttribute("class");
//		driver.findElement(By.xpath("//button[@aria-label='Go to next page']")).click();
		List<WebElement> allRows1= driver.findElements(By.xpath("//div[@role='row']"));
		int size1= allRows1.size();
		
		System.out.println("Rows size is " +size1);
		
		for(int i=0;i<size1;i++)
		{
			List<WebElement> orgRows1= allRows1.get(i).findElements(By.xpath("//div[@role='row']"));
			WebElement data1 = orgRows1.get(i);
			String text= data1.getText();
			System.out.println(text);
					
			if (text.equals("core-01"))
			{
//				cols.get(i).findElement(By.xpath("//div[@data-field='shortName']")).click();
				WebElement selectedOrg = orgRows1.get(1).findElement(By.xpath("//div[@class='MuiDataGrid-cellContent']"));
				selectedOrg.click();
				break;
			}
			System.out.println("");
		}
		//*[@data-testid='ArrowDropDownIcon']
		
//		WebElement DropDown=driver.findElement(By.xpath("//*[@data-testid='ArrowDropDownIcon']"));
//		Select select=new Select(DropDown);
//		select.selectByVisibleText("50");
//		Thread.sleep(5000);               
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//	       //specify the WebElement till which the page has to be scrolled
//	    WebElement element1 =(driver.findElement(By.xpath("//p[normalize-space()='FVYSB-TSG']")));
//	 
//	    js.executeScript("arguments[0].scrollIntoView();", element1);
		
		Actions at = new Actions(driver);
	    at.sendKeys(Keys.PAGE_DOWN).build().perform();
		
//		WebElement element1 =(driver.findElement(By.xpath("//div[@data-id='org/RYRCS-TSG']")));
//		WebElement scroll =  driver.findElement(By.xpath("//div[@class='MuiDataGrid-virtualScroller css-1w5m2wr-MuiDataGrid-virtualScroller']"));
//		scroll.sendKeys(Keys.PAGE_DOWN);
	 
	     
		
		
//		List<WebElement> attributes=(driver.findElements(By.className("MuiDataGrid-row")));
		
//		for(WebElement attribute:attributes)
//		{
////			Orgs.add(Row.getText());
//			System.out.println("Org name is " +attributes);
//		
//		}
//		
//		
//		 
	       //specify the WebElement till which the page has to be scrolled
		
//		System.out.println("Org name is " +attributes1);
//	 
//	       js.executeScript("arguments[0].scrollIntoView();", element1);
//		
////	List<WebElement> attributes1=(driver.findElements(By.xpath("//p[normalize-space()='1ST']")));
		WebElement attributes1=(driver.findElement(By.xpath("//p[normalize-space()='1ST']")));
		if (attributes1.equals("1ST"))
		{
			driver.findElement(By.xpath("//div[@data-id='"+attributes1+"']/div[1]")).click();
		}
//		
		
	}

}

//EventFiringWebDriver eventfiringwebdriver=new EventFiringWebDriver(driver);
//
//eventfiringwebdriver.executeScript("document.querySelector('//div[@class=\"MuiDataGrid-virtualScroller css-1w5m2wr-MuiDataGrid-virtualScroller\"]').scrollTop=500");


