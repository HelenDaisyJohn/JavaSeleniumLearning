package Tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import Pages.OrgObjects;
import Pages.EncoderPage;

//import Pages.OrgObjects;
public class EncoderTest {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://prism-web-hotfix-stm-prism-xpressbet.preprod.1stbet.com/");
		driver.manage().window().maximize();
		
//		create object
		EncoderPage Encoder=new EncoderPage(driver);
		
//		Inputs-Login
		String UserName="admin@1st.com";
		String PassWord="admin";
		String DisplayName="Test";
		String ShortName="Test";
		
//		Inputs- Add Encode
		String OrgName="Test";
		String UnitName="A-01";
		String EncoderName="Enc-Test23";
		String EncoderID="Enc-Test23";
//		Search		
		String searchKeyword="Enc-Test23";
			
//		Test case1-Login
		Encoder.Login_Button();
		Encoder.User_Name(UserName);
		Encoder.Password(PassWord);
		Encoder.Login_BTN();
		Encoder.Hamburger_Menu();
		
		
//		Navigate to Video Platform
		Encoder.Select_Org_Dropdown(OrgName);
		Encoder.Select_Unit_Dropdown(UnitName);


		
//		Add Encoder-Test
		Encoder.Select_Encoder1();
////		Check Title
//		Encoder.Check_Title();
		
		Encoder.Select_Encoder(EncoderName,EncoderID);
		Encoder.Message();
//		
// 		Tooltip
		Encoder.Tool_Tip1();
		Encoder.Tool_Tip2();
		Encoder.Tool_Tip3();
		
//		Search
		Encoder.DisplayInactiveEncoder();
		Encoder.Search(searchKeyword);
		Encoder.Disable();
		Encoder.DisabledMessage();
		
//		Update
		Encoder.UpdateEncoder();
		Encoder.UpdatedMessage();
		
//		Delete
		Encoder.DeleteEncoder();
		Encoder.DeletedMessage();
	
		
	}
}