package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DecoderPage {


	WebDriver driver=null;
//	Login to the portal
	By Login_Button1=By.xpath("//*[@id='root']/div/div/div/div[2]/button");
	By User_Name1=By.xpath("(//input[@id='Input_Username'])[1]");
	By Password1=By.xpath("(//input[@id='Input_Password'])[1]");
	By Login_BTN1=By.xpath("//button[@value='login']");
		
//	Navigate to Video
	By Hamburger_Menu1=By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[1]/button[2]");
	
		
//	select org
//	By Select_Org_Dropdown1=By.xpath("(//div[@id=':r0:'])[1]");
//	By Select_Unit_Dropdown1=By.xpath("(//div[@id=':r1:'])[1]");
	By Select_Org_Dropdown1=By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-sizeSmall css-niyuos'])[1]");
	By Select_Unit_Dropdown1=By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/ul/div/form[2]/div/div/div/div");
	
	
//	Select Decoder
	By Select_Decoder1=By.xpath("(//p[normalize-space()='Video Decoder'])[1]");
		
//  Add a new Decoder
	By Add_icon1=By.xpath("//button[@title='Add Video Decoder']");  
	By Decoder_Name1=By.xpath("//input[@id='Decoder-Name']");
	By Decoder_ID1=By.xpath("//input[@id='Decoder-ID']");
	By Channel_ID1=By.xpath("//input[@id='Vendor-Channel-Identifier']");
	By Project_ID1=By.xpath("//input[@id='Project-id']");
	By Zone1=By.xpath("//input[@id='Zone']");
	By Instance_Name1=By.xpath("//input[@id='Instance-name']");
	By Add_button1=By.xpath("(//button[normalize-space()='Add'])[1]");
	By Success_Message=By.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']");
	
//	Tooltip
	By Tool_Tip1=By.xpath("(//button[@title='Add Video Decoder'])[1]");
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
public DecoderPage(WebDriver driver)
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
		System.out.println("Testcase 1 is Passed");
		System.out.println("Successfully Login to the Prism Portal");
	}

	
//Navigate to Video
	public void Hamburger_Menu() throws InterruptedException {
		driver.findElement(Hamburger_Menu1).click();
		Thread.sleep(1000);
		driver.findElement(Select_Decoder1).click();
		
		
	}
	
// 	Select anyone org
	public void Select_Org_Dropdown(String OrgName) throws InterruptedException {
		Thread.sleep(1000);
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
		
//		public void Select_Decoder() {
//			driver.findElement(Select_Decoder1).click();
//		
//			}

//	Create a new Video Decoder -Testcase 1
		public void Select_Decoder(String DecoderName, String DecoderID, String ChannelID, String ProjectID, String Zone, String InstanceName ) throws InterruptedException {
			Thread.sleep(3000);
			
			driver.findElement(Add_icon1).click();
			driver.findElement(Decoder_Name1).sendKeys(DecoderName);
			driver.findElement(Decoder_ID1).sendKeys(DecoderID);
			WebElement SpportedChannelVendor=driver.findElement(By.xpath("(//div[@id='Supported-Channel-Vendor'])[1]"));
			SpportedChannelVendor.click();
			WebElement SpportedChannelVendorOption=driver.findElement(By.xpath("//li[normalize-space()='Phenix']"));
			SpportedChannelVendorOption.click();
			driver.findElement(Channel_ID1).sendKeys(ChannelID);
			driver.findElement(Project_ID1).sendKeys(ProjectID);
			driver.findElement(Zone1).sendKeys(Zone);
			driver.findElement(Instance_Name1).sendKeys(InstanceName);
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 500);");
			driver.findElement(Add_button1).click();
			
		}
//		Getting Success/warning  message- Testcase 2
		public void Message() throws InterruptedException {
			Thread.sleep(500);
			WebElement message=driver.findElement(Success_Message);
			String message1=message.getText();
			System.out.println("Message is:" +message1);
			Assert.assertEquals( message1, "Video Decoder Successfully Added");
			System.out.println(" ");
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
			System.out.println("");
		}
		public void DisplayInactiveDecoder() {
			driver.findElement(By.xpath("//input[@name='gilad']")).click();
			System.out.println(" ");
			System.out.println("All the active/Inactive Decoders are visible");
			System.out.println(" ");
		}
		public void Search(String searchKeywordDecoder) {
			driver.findElement(Search1).sendKeys(searchKeywordDecoder);
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
			WebElement DisabledMessage=driver.findElement(Success_Message);
			String DisabledMessage1=DisabledMessage.getText();
			System.out.println("Message is:" +DisabledMessage1);
			Assert.assertEquals( DisabledMessage1, "Video Decoder Successfully Disabled");
			System.out.println("Disabled message is displayed properly");
			System.out.println(" ");
			
		}
		public void UpdateDecoder() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(menu).click();
			driver.findElement(update).click();
			Thread.sleep(1000);
			driver.findElement(Decoder_ID1).sendKeys("111111");
			driver.findElement(Decoder_Name1).sendKeys("111111");
			Thread.sleep(1000);
			driver.findElement(updateButton).click();
			System.out.println("Update functionality is working fine");
			System.out.println(" ");
			
		}
		public void UpdatedMessage() throws InterruptedException {
			Thread.sleep(500);
			WebElement UpdatedMessage=driver.findElement(Success_Message);
			String UpdatedMessage1=UpdatedMessage.getText();
			System.out.println("Message is:" +UpdatedMessage1);
			Assert.assertEquals( UpdatedMessage1, "Video Decoder Successfully Updated");
			System.out.println("Update message is displayed properly");
			System.out.println(" ");
			
		}
		public void DeleteDecoder() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(menu).click();
			driver.findElement(delete).click();
			Thread.sleep(1000);
			driver.findElement(confirmYes).click();
			System.out.println("Delete functionality is working fine");
			System.out.println(" ");
			
		}
		public void DeletedMessage() {
			WebElement DeletedMessage=driver.findElement(Success_Message);
			String DeletedMessage1=DeletedMessage.getText();
			System.out.println("Message is:" +DeletedMessage1);
			Assert.assertEquals( DeletedMessage1, "Video Decoder Successfully Deleted");
			System.out.println("Delete message is displayed properly");
			System.out.println(" ");
			driver.quit();			
		}
		

	}
