package Streaming;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Organization {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
		//ChromeDriver driver= new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
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
		
//// 		Add a new organization		
//		driver.findElement(By.xpath("//button[@title='Add Organization']")).click();
//		driver.findElement(By.xpath("//input[@id='Display-Name']")).sendKeys("Test1");
//		driver.findElement(By.xpath("//input[@id='Short-Name']")).sendKeys("Test1");
//		driver.findElement(By.xpath("(//button[normalize-space()='Add'])[1]")).click();
//		Thread.sleep(1000);
//		
////		Success message
//		WebElement Drop=driver.findElement(By.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
//		String drop12=Drop.getText();
//		System.out.println("Message is:" +drop12);
//		Assert.assertEquals("Organization Successfully Added", drop12, "Please enter valid org");

//		Getting Row size		
		List<WebElement> allRows= driver.findElements(By.xpath("//div[@role='row']"));
		int rowsize= allRows.size();
		System.out.println("Rows size is " +rowsize);
		
		
//		Getting Column size	
		List<WebElement> allColumns= driver.findElements(By.xpath("//div[@role='columnheader']"));
		int colSize= allColumns.size();
		System.out.println("Column size is " +colSize);
		
		

		
//		Print the short name and display name
//		String nextButtonClassName= driver.findElement(By.xpath("//button[@aria-label='Go to next page']")).getAttribute("class");
		
		List<WebElement> allRows1= driver.findElements(By.xpath("//div[@role='row']"));
		int size1= allRows1.size();
		
		System.out.println("Rows size is " +size1);
		
		for(int i=0;i<size1;i++)
		{
			List<WebElement> orgRows1= allRows1.get(i).findElements(By.xpath("//div[@role='row']"));
			WebElement data1 = orgRows1.get(i);
			String text= data1.getText();
			System.out.println(text);
					
			if (text.equals("FJWKR"))
			{
//				WebElement selectedOrg =cols.get(i).findElement(By.xpath("//div[@data-field='shortName']")).click();
//				WebElement selectedOrg = orgRows1.get(i).findElement(By.xpath("//div[@class='MuiDataGrid-cellContent']"));
//				selectedOrg.click();
				
				break;
			}
			System.out.println("");
		}
		//*[@data-testid='ArrowDropDownIcon']
		driver.findElement(By.xpath("//button[@aria-label='Go to next page']")).click();
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500)","");
		Thread.sleep(2000);
		
		WebElement pagination=driver.findElement(By.xpath("(//p[@class='MuiTablePagination-displayedRows css-hz3agd-MuiTablePagination-displayedRows'])[1]"));
		String page1=pagination.getText();
		System.out.println(page1);
		
		
//		Select DropDown=new Select(driver.findElement(By.xpath("(//div[@class='MuiInputBase-root MuiInputBase-colorPrimary css-1ba8m3u-MuiInputBase-root-MuiTablePagination-select'])[1]")));
////		Select select=new Select(DropDown);
//		DropDown.selectByVisibleText("50");
		
//		Tried to select the pagination of 50.
		
		List<WebElement> options1=driver.findElements(By.xpath("//li[@role='option']"));
		Thread.sleep(1000);
		for(WebElement option1:options1)
		{
			if(option1.getText().trim().equals(50));
			option1.click();
			break;
		}
		
		
//		Select organization.	
		String attributes=(driver.findElement(By.className("MuiDataGrid-row"))).getAttribute("data-id");
		Thread.sleep(1000);
		System.out.println("Org name is " +attributes);
		
		if (attributes.equals("BFQAT-TSG"))
		{
			driver.findElement(By.xpath("//div[@data-id='BFQAT-TSG']/div[1]")).click();
//			attributes.click();
		}
		
		
		

		
//		No of Rows and columns in the table.
		
		String attributes1=(driver.findElement(By.xpath("(//div[@role='grid'])[1]"))).getAttribute("aria-rowcount");
		String attributes2=(driver.findElement(By.xpath("(//div[@role='grid'])[1]"))).getAttribute("aria-colcount");
		Thread.sleep(1000);
		System.out.println("No of organization in the table " +attributes1);
		System.out.println("");
		System.out.println("No of organization columns in the table " +attributes2);
		System.out.println("");
		
//		boolean org = false;
//		while(!org) {
//			List<WebElement> listOfOrg=driver.findElements(By.xpath("//li[@role='option']"));
//		}(//input[@id=':r2:'])[1]
		Thread.sleep(1000);
		
		
//		Verify the name of the entity
		String entity=(driver.findElement(By.xpath("(//h6[normalize-space()='Organization'])[1]"))).getText();
		System.out.println("Entity name is " +entity);
		Thread.sleep(1000);
		System.out.println("");
		
		
//		Verify the icon of the plus icon tooltip is "Add Organization"
		String icon1=(driver.findElement(By.xpath("(//button[@title='Add Organization'])[1]"))).getAttribute("title");
		System.out.println("The name of the plus icon tool tip is: "  +icon1);
		System.out.println("");
		
		
//		"Verify the settings icon tooltip is "Settings"
		String icon2=(driver.findElement(By.xpath("(//button[@title='Column Settings'])[1]"))).getAttribute("title");
		System.out.println("The setting icon tool tip is: "  +icon2);
		System.out.println("");
		
		
//		Verify the icon of the Export tooltip is "Export"
		String icon3=(driver.findElement(By.xpath("(//button[normalize-space()='Export'])[1]"))).getAttribute("title");
		System.out.println("The setting icon tool tip is: "  +icon3);
		System.out.println("");
		
//		Verify whether the action column has three options
		
		
		
//		searching an org
//		driver.findElement(By.xpath("//div[@class='MuiDataGrid-toolbarContainer css-1it2ytw-MuiDataGrid-toolbarContainer']/div[1]/div")).sendKeys("AATest31");
			
		
		
	}

}



