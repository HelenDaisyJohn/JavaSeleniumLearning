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
		
//	Navigate to Video
	By Hamburger_Menu1=By.xpath("//button[@aria-label='menu']//*[name()='svg']");
	By Select_Video1=By.xpath("//span[normalize-space()='Video']");
		
//	select org
	By Select_Org_Dropdown1=By.xpath("//div[@id=':r0:']");
	By Select_Unit_Dropdown1=By.xpath("//div[@id=':r1:']");
	
	
//	Select Encoder
	By Select_Encoder1=By.xpath("//p[normalize-space()='Video Encoder']");
		
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
	
//	Search
	By Search1=By.xpath("//input[@type='search']");
	
	
//	Delete
	
	
	
	
	
	
	
	
	
	
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
		System.out.println("Testcase 1 is Passed");
		System.out.println("Successfully Login to the Prism Portal");
	}

	
//Navigate to Video
	public void Hamburger_Menu() {
		driver.findElement(Hamburger_Menu1).click();
		
	}
	public void Select_Video() {
		driver.findElement(Select_Video1).click();
	
		}
// 	Select anyone org
	public void Select_Org_Dropdown(String OrgName) {
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
		public void Select_Unit_Dropdown(String UnitName) {
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
		
		public void Select_Encoder() {
			driver.findElement(Select_Encoder1).click();
		
			}

//	Create a new Video Encoder -Testcase 1
		
		
		
		public void Select_Encoder(String EncoderName, String EncoderID) {
			
			driver.findElement(Add_icon1).click();
			driver.findElement(Encoder_Name1).sendKeys(EncoderName);
			driver.findElement(Encoder_ID1).sendKeys(EncoderID);
			driver.findElement(Add_button1).click();
			
		}
//		Getting Success/warning  message- Testcase 2
		public void Message() {
			WebElement message=driver.findElement(By.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
			String message1=message.getText();
			System.out.println("Message is:" +message1);
			Assert.assertEquals( message1, "Video Encoder Successfully Added");
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
		public void Search(String searchKeyword) {
			driver.findElement(Search1).sendKeys(searchKeyword);
			
			System.out.println("");
		}
		
		
		
//		

	
	}

