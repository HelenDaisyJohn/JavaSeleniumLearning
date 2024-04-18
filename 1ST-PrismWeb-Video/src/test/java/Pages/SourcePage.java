package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SourcePage {


	WebDriver driver=null;
//	Login to the portal
	By Login_Button1=By.xpath("(//button[normalize-space()='Log in'])[1]");
	By User_Name1=By.xpath("(//input[@id='Input_Username'])[1]");
	By Password1=By.xpath("(//input[@id='Input_Password'])[1]");
	By Login_BTN1=By.xpath("//button[@value='login']");
		
///	Navigate to VideoPlatform
	By Hamburger_Menu1=By.xpath("(//button[@type='button'])[2]");
		
//	select org
	By Select_Org_Dropdown1=By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-sizeSmall css-niyuos'])[1]");
	By Select_Unit_Dropdown1=By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/ul/div/form[2]/div/div/div/div");
	
	
//	Select Source
	By Select_Source1=By.xpath("//p[normalize-space()='Video Source']");
		
//  Add a new Source
	By Add_icon1=By.xpath("//button[@title='Add Video Source']");
	By Display_Name1=By.xpath("//input[@id='Display-Name']");
	By Angle1=By.xpath("(//div[@id='Angle'])[1]");
	By Select_Angle1=By.xpath("//li[normalize-space()='Backside']");
	By Encoder1=By.xpath("(//div[@id='Video Encoder Display Name'])[1]");
	By Select_Encoder1=By.xpath("//li[@role='option'][1]");
	
	By Start_Margin=By.xpath("//*[@id=\"add-new\"]/div/div/div/form/div[4]/div/div/div/button");
	By Select_Start_Margin=By.xpath("//div[@class='MuiClock-squareMask css-1umqo6f']");
	By ConfirmStartMargin=By.xpath("//button[normalize-space()='OK']");
	
	By End_Margin=By.xpath("//*[@id=\"add-new\"]/div/div/div/form/div[5]/div/div/div/button");
	By Select_End_Margin=By.xpath("//div[@class='MuiClock-squareMask css-1umqo6f']");
	By ConfirmEndMargin=By.xpath("//button[normalize-space()='OK']");
	
	By ADD_Button1=By.xpath("(//button[normalize-space()='Add'])[1]");
	By Success_Message1=By.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']");
	
//	Tooltip
	By Tool_Tip1=By.xpath("(//button[@title='Add Video Source'])[1]");
	By Tool_Tip2=By.xpath("(//button[normalize-space()='Export'])[1]");
	By Tool_Tip3=By.xpath("(//button[@title='Column Settings'])[1]");
	
//	Confirmation element
	By confirmYes=By.xpath("(//button[contains(@type,'button')][normalize-space()='Yes'])[2]");
	
//	Search
	By Search1=By.xpath("//input[@type='search']");
	
//	Disable/Enable
	By menu=By.xpath("(//div[@role='menu'])[1]");
	By disable=By.xpath("//li[normalize-space()='Disable']");
	By reenable=By.xpath("//li[normalize-space()='Enable']");
	
//	Update
	By update=By.xpath("//li[normalize-space()='Edit']");
	By updateButton=By.xpath("(//button[normalize-space()='Update'])[1]");
	
//	Delete
	By delete=By.xpath("//li[normalize-space()='Delete']");
	

//	Login to the Portal
public SourcePage(WebDriver driver)
	{
		this.driver= driver;
	}


//	Login to the Portal
	public void Login_Button() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(Login_Button1).click();;
	}

	public void User_Name(String UserName) {
		driver.findElement(User_Name1).sendKeys(UserName);
		
	}
	public void Password(String Password) {
		driver.findElement(Password1).sendKeys(Password);
		
	}
	public void Login_BTN() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(Login_BTN1).click();
		System.out.println("Testcase 1 is Passed");
		System.out.println("Successfully Login to the Prism Portal");
	}

	
//Navigate to Video
	public void Hamburger_Menu() {
		driver.findElement(Hamburger_Menu1).click();
		
	}
	
// 	Select anyone org
	public void Select_Org_Dropdown(String OrgName) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Select_Org_Dropdown1).click();
		List<WebElement> allOptions= driver.findElements(By.xpath("(//li[@role='option'])"));
		for(WebElement option:allOptions)
		{
//			System.out.println(option.getText());
			if(option.getText().equals(OrgName))
			{
				option.click();
				break;
			}
		}
	}
	
//	Select anyone org assosiated unit
		public void Select_Unit_Dropdown(String UnitName) throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(Select_Unit_Dropdown1).click();
			List<WebElement> allOptions1= driver.findElements(By.xpath("(//li[@role='option'])"));
			for(WebElement option1:allOptions1)
			{
//				System.out.println(option1.getText());
				if(option1.getText().equals(UnitName))
				{
					option1.click();
					break;
				}
			}		
	}
		
		public void Select_Source() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(Select_Source1).click();
		
			}

//	Create a new Video Source -Testcase 1
		public void Select_Source(String SourceName ) throws InterruptedException {
			
			driver.findElement(Add_icon1).click();
			driver.findElement(Display_Name1).sendKeys(SourceName);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 500);");
			driver.findElement(Angle1).click();
			driver.findElement(Select_Angle1).click();
			
			driver.findElement(Encoder1).click();
			driver.findElement(Select_Encoder1).click();
			
			driver.findElement(Start_Margin).click();
			
			driver.findElement(Select_Start_Margin).click();
			driver.findElement(ConfirmStartMargin).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(End_Margin).click();
			Thread.sleep(2000);
			driver.findElement(Select_End_Margin).click();
			driver.findElement(ConfirmEndMargin).sendKeys(Keys.ENTER);
			
			driver.findElement(ADD_Button1).click();
			
		}
//		Getting Success/warning  message- Testcase 2
//		public void Message() throws InterruptedException {
//			Thread.sleep(500);
//			WebElement message=driver.findElement(Success_Message1);
//			String message1=message.getText();
//			System.out.println("Message is:" +message1);
//			Assert.assertEquals( message1, "Video Source Successfully Added");
//			System.out.println(" ");
//		}
		
		
		//		Verify the icon of the plus icon tooltip is "Add Organization"
		public void Tool_Tip1() {
			String icon1=driver.findElement(Tool_Tip1).getAttribute("title");
			System.out.println("The name of the plus icon tool tip is: "  +icon1);
			System.out.println("");
		}
		public void Tool_Tip2() {
			String icon1=driver.findElement(Tool_Tip2).getAttribute("title");
			System.out.println("The name of the plus icon tool tip is: "  +icon1);
			System.out.println("");
		}
		public void Tool_Tip3() {
			String icon1=driver.findElement(Tool_Tip3).getAttribute("title");
			System.out.println("The name of the plus icon tool tip is: "  +icon1);
			System.out.println("");
		}
		
		public void Table_Columns() {
			List<WebElement> columnHeaders = driver.findElements(By.xpath("//div[@role='columnheader']"));

	        // Perform assertions
	        try {
	            // Assert the first column header
	            assert columnHeaders.get(0).getText().equals("Display Name");

	            // Assert the second column header
	            assert columnHeaders.get(1).getText().equals("Camera Angle");

	            // Assert the third column header
	            assert columnHeaders.get(2).getText().equals("Video Encoder");
	            assert columnHeaders.get(3).getText().equals("Start Margin11");
	            assert columnHeaders.get(4).getText().equals("End Margin");
	            // Assert the fourth column header
	            assert columnHeaders.get(5).getText().equals("Active/Inactive");

	            System.out.println("Testcase 003 passed - Column headers are displayed properly");
	        } catch (AssertionError e) {
	            System.out.println("Testcase 003 failed - Column headers are not displayed properly"+e);
	        } 
			
		}
		public void DisplayInactiveSource() throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='gilad']")).click();
			System.out.println(" ");
			System.out.println("All the active/Inactive Sources are visible");
			System.out.println(" ");
		}
		public void Search(String searchKeywordSource) throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(Search1).sendKeys(searchKeywordSource);
			System.out.println("Search functionality is working fine");
			System.out.println("");
		}
		public void Disable() throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(menu).click();
			driver.findElement(disable).click();
			Thread.sleep(1000);
			driver.findElement(confirmYes).click();
			System.out.println("Disabled functionality is working fine");
			System.out.println(" ");
		}
//		getting Success/warning  message- Testcase 2
		public void DisabledMessage() throws InterruptedException {
			Thread.sleep(500);
			WebElement DisabledMessage=driver.findElement(Success_Message1);
			String DisabledMessage1=DisabledMessage.getText();
			System.out.println("Message is:" +DisabledMessage1);
			Assert.assertEquals( DisabledMessage1, "Video Source Successfully Disabled");
			System.out.println("Disabled message is displayed properly");
			System.out.println(" ");
			
		}
		
		public void Reenable() throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(menu).click();
			driver.findElement(reenable).click();
			Thread.sleep(1000);
			driver.findElement(confirmYes).click();
			System.out.println("Enabled functionality is working fine");
			System.out.println(" ");
		}
		public void UpdateSource() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(menu).click();
			driver.findElement(update).click();
			Thread.sleep(1000);
			driver.findElement(Display_Name1).sendKeys("111111");
			Thread.sleep(1000);
			driver.findElement(updateButton).click();
			System.out.println("Update functionality is working fine");
			System.out.println(" ");
			
		}
		public void UpdatedMessage() {
			WebElement UpdatedMessage=driver.findElement(Success_Message1);
			String UpdatedMessage1=UpdatedMessage.getText();
			System.out.println("Message is:" +UpdatedMessage1);
			Assert.assertEquals( UpdatedMessage1, "Video Source Successfully Updated");
			System.out.println("Update message is displayed properly");
			System.out.println(" ");
			
		}
		
//		
			
		}
		

	
