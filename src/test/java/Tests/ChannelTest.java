package Tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import Pages.OrgObjects;
import Pages.ChannelPage;

//import Pages.OrgObjects;
public class ChannelTest {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://prism-web-hotfix-stm-prism-xpressbet.preprod.1stbet.com/");
		driver.manage().window().maximize();
		
//		create object
		ChannelPage Channel=new ChannelPage(driver);
		
//		Inputs-Login
		String UserName="admin@1st.com";
		String PassWord="admin";
		String DisplayName="Test";
		String ShortName="Test";
		
//		Inputs- Add Encode
		String OrgName="Test-Org";
		String UnitName="unit-01";
		String ChannelName="Enc-Test23";
		String Description="Enc-Test23";
		String VendorChannelID="Test";
//		Search		
		String searchKeyword="Enc-Test23";
			
//		Test case1-Login
		Channel.Login_Button();
		Channel.User_Name(UserName);
		Channel.Password(PassWord);
		Channel.Login_BTN();
		Channel.Hamburger_Menu();
		
		
//		Navigate to Video Platform
		Channel.Select_Org_Dropdown(OrgName);
		Channel.Select_Unit_Dropdown(UnitName);


		
//		Add Channel-Test
		Channel.Select_Channel();
////		Check Title
//		Channel.Check_Title();
		
		Channel.Select_Channel(ChannelName,VendorChannelID, Description );
		Channel.Message();
//		
// 		Tooltip
		Channel.Tool_Tip1();
		Channel.Tool_Tip2();
		Channel.Tool_Tip3();
		
//		Search
		Channel.DisplayInactiveChannel();
		Channel.Search(searchKeyword);
		Channel.Disable();
		Channel.DisabledMessage();
		
//		Update
//		Channel.UpdateChannel();
//		Channel.UpdatedMessage();
//		
////		Delete
//		Channel.DeleteChannel();
//		Channel.DeletedMessage();
	
		
	}
}