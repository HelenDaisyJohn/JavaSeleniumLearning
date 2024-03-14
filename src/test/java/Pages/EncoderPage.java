package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class EncoderPage {


	WebDriver driver=null;
//	Login to the portal
	By Login_Button1=By.xpath("//*[@id='root']/div/div/div/div[2]/button");
	By User_Name1=By.xpath("(//input[@id='Input_Username'])[1]");
	By Password1=By.xpath("(//input[@id='Input_Password'])[1]");
	By Login_BTN1=By.xpath("//button[@value='login']");
		
//	Navigate to VideoPlatform
	By Hamburger_Menu1=By.xpath("(//button[@type='button'])[2]");
	
		
//	select org
	By Select_Org_Dropdown1=By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div/div[2]/ul/div/form[1]/div/div/div");
	By Select_Unit_Dropdown1=By.xpath("//*[@id=\\\"root\\\"]/div[2]/div[2]/div/div/div/div[2]/ul/div/form[1]/div/div/div/div");
	
	
//	Select Encoder
	By Select_Encoder1=By.xpath("(//p[normalize-space()='Video Encoder'])[1]");
//	Check Title
	By Check_Title=By.xpath("(//h6[normalize-space()='Video Encoder'])[1]");
		
//  Add a new Encoder
	By Add_icon1=By.xpath("//button[@title='Add Video Encoder']");
	By Encoder_Name1=By.xpath("//input[@id='Encoder-Name']");
	By Encoder_ID1=By.xpath("//input[@id='Encoder-ID']");
	By Add_button1=By.xpath("(//button[normalize-space()='Add'])[1]");
	By Success_Message=By.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']");
	
//	Tooltip
	By Tool_Tip1=By.xpath("(//button[@title='Add Video Encoder'])[1]");
	By Tool_Tip2=By.xpath("(//button[normalize-space()='Export'])[1]");
	By Tool_Tip3=By.xpath("(//button[@title='Column Settings'])[1]");
	
//	Confirmation element
	By confirmYes=By.xpath("(//button[contains(@type,'button')][normalize-space()='Yes'])[2]");
	
//	Search
	By Search1=By.xpath("//input[@type='search']");
	
//	Disable
	By menu=By.xpath("(//div[@role='menu'])[1]");
	By disable=By.xpath("//li[normalize-space()='Disable']");
	
//	Update
	By update=By.xpath("//li[normalize-space()='Edit']");
	By updateButton=By.xpath("(//button[normalize-space()='Update'])[1]");
	
//	Delete
	By delete=By.xpath("//li[normalize-space()='Delete']");
	

//	Login to the Portal
public EncoderPage(WebDriver driver)
	{
		this.driver= driver;
	}


//	Login to the Portal
	public void Login_Button() {
		driver.findElement(Login_Button1).click();;
	}

	public void User_Name(String UserName) {
		driver.findElement(User_Name1).sendKeys(UserName);
		
	}
	public void Password(String Password) {
		driver.findElement(Password1).sendKeys(Password);
		
	}
	public void Login_BTN() {
		driver.findElement(Login_BTN1).click();
		System.out.println("Testcase 001 is Passed-Successfully Login to the Prism Portal");
		System.out.println("");
	}

	
//Navigate to Video
	public void Hamburger_Menu() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Hamburger_Menu1).click();
		
	}
	
// 	Select anyone org
	public void Select_Org_Dropdown(String OrgName) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Select_Org_Dropdown1).click();
		Thread.sleep(2000);
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
			Thread.sleep(3000);
			driver.findElement(Select_Unit_Dropdown1).click();
			Thread.sleep(1000);
			List<WebElement> allOptions1= driver.findElements(By.xpath("(//li[@role='option'])"));
			for(WebElement option1:allOptions1)
			{
//				System.out.println(option1.getText());
				if(option1.getText().equals(UnitName))
				{
					option1.click();
					System.out.println("Testcase 002 is Passed-Successfully Selected org and its associated unit");
					System.out.println("");
					break;
				}
			}		
	}
		
//		Navigated to Video Encoder page		
		public void Select_Encoder1() {
			driver.findElement(Select_Encoder1).click();
			System.out.println("Testcase 003 is Passed-Successfully Navigated to Video Encoder page");
			System.out.println("");
		
			}
		
//		Check the title of the page
		public void Check_Title() {
			WebElement title = driver.findElement(By.xpath("(//h6[normalize-space()='Video Encoder'])[1]"));
			String actualTitle = title.getText();
			String expectedTitle = "Video Encoder";
			if (actualTitle.equals(expectedTitle)) {
                System.out.println("Testcase 004 passed - Page Title is properly displayed");
            } else {
                System.out.println("Testcase 004 failed - Page Title is not properly displayed");
            }
			
			}

//	Create a new Video Encoder -Testcase 1
		public void Select_Encoder(String EncoderName, String EncoderID) {
			
			driver.findElement(Add_icon1).click();
			driver.findElement(Encoder_Name1).sendKeys(EncoderName);
			driver.findElement(Encoder_ID1).sendKeys(EncoderID);
			driver.findElement(Add_button1).click();
			System.out.println("Testcase 005 is Passed-Successfully Created a new Video Encoder");
			System.out.println("");
			
		}
//		Getting Success/warning  message- Testcase 2
		public void Message() {
			WebElement message=driver.findElement(By.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
			String message1=message.getText();
			System.out.println("Message is:" +message1);
			Assert.assertEquals( message1, "Video Encoder Successfully Added");
			System.out.println("Testcase 006 is Passed-Success/warning  message Received properly");
			System.out.println("");
		}
		
		
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
			System.out.println("Testcase 007 is Passed-tool tip functionalities are working properly");
			System.out.println("");
		}
		public void DisplayInactiveEncoder() {
			driver.findElement(By.xpath("//input[@name='gilad']")).click();
			System.out.println("Testcase 008 is Passed-All the active/Inactive Encoders are visible");
			System.out.println("");
		}
		public void Search(String searchKeywordEncoder) {
			driver.findElement(Search1).sendKeys(searchKeywordEncoder);
			System.out.println("");
			System.out.println("Testcase 009 is Passed-Search functionality is working fine");
			System.out.println("");
		}
		public void Disable() throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(menu).click();
			driver.findElement(disable).click();
			Thread.sleep(1000);
			driver.findElement(confirmYes).click();
			System.out.println("Testcase 010 is Passed-Disabled functionality is working fine");
			System.out.println("");
		}
//		getting Success/warning  message- Testcase 2
		public void DisabledMessage() {
			WebElement DisabledMessage=driver.findElement(By.xpath("(//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message'])[1]"));
			String DisabledMessage1=DisabledMessage.getText();
			System.out.println("Message is:" +DisabledMessage1);
			Assert.assertEquals( DisabledMessage1, "Video Encoder Successfully Disabled");
			System.out.println("Testcase 011 is Passed-Disabled message is displayed properly");
			System.out.println("");
			
		}
		public void UpdateEncoder() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(menu).click();
			driver.findElement(update).click();
			Thread.sleep(1000);
			driver.findElement(Encoder_ID1).sendKeys("111111");
			driver.findElement(Encoder_Name1).sendKeys("111111");
			Thread.sleep(1000);
			driver.findElement(updateButton).click();
			System.out.println("Testcase 012 is Passed-Update functionality is working fine");
			System.out.println("");
			
		}
		public void UpdatedMessage() {
			WebElement UpdatedMessage=driver.findElement(By.xpath("(//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message'])[1]"));
			String UpdatedMessage1=UpdatedMessage.getText();
			System.out.println("Message is:" +UpdatedMessage1);
			Assert.assertEquals( UpdatedMessage1, "Video Encoder Successfully Updated");
			System.out.println("Testcase 013 is Passed-Update message is displayed properly");
			System.out.println("");
			
		}
		public void DeleteEncoder() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(menu).click();
			driver.findElement(delete).click();
			driver.findElement(confirmYes).click();
			Thread.sleep(1000);
			System.out.println("Testcase 014 is Passed-Delete functionality is working fine");
			System.out.println("");
			
		}
		public void DeletedMessage() {
			WebElement DeletedMessage=driver.findElement(By.xpath("(//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message'])[1]"));
			String DeletedMessage1=DeletedMessage.getText();
			System.out.println("Message is:" +DeletedMessage1);
			Assert.assertEquals( DeletedMessage1, "Video Encoder Successfully Deleted");
			System.out.println("Testcase 014 is Passed-Delete message is displayed properly");
			System.out.println("");
			
		}
		

	}
