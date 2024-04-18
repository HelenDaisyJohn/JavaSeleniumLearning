package Tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Pages.OrgObjects;
import Pages.DecoderPage;

import Pages.OrgObjects;
public class DecoderTest {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://prism-web-hotfix-stm-prism-xpressbet.preprod.1stbet.com/");
		driver.manage().window().maximize();
		
//		create object
		DecoderPage Decoder=new DecoderPage(driver);
		
//		Inputs-Login
		String UserName="admin@1st.com";
		String PassWord="admin";
		String DisplayName="Test01";
		String ShortName="Test01";
		
//		Inputs- Add Decoder
		String OrgName="Test_Org";
		String UnitName="Unit-01";
		String DecoderName="Dec-Test21";
		String DecoderID="Dec-Test21";
		String ChannelID="Dec-Test21";
		String ProjectID="Dec-Test21";
		String Zone="Dec-Test21";
		String InstanceName="Dec-Test21";
		
//		Search		
		String searchKeyword="Dec-Test21";
			
//		Test case1-Login
		Decoder.Login_Button();
		Decoder.User_Name(UserName);
		Decoder.Password(PassWord);
		Decoder.Login_BTN();
		Decoder.Hamburger_Menu();
		
		
//		Navigate to Video Platform
		
		Decoder.Select_Org_Dropdown(OrgName);
		Decoder.Select_Unit_Dropdown(UnitName);

		
//		Add Decoder-Test
//		Decoder.Select_Decoder();
		Decoder.Select_Decoder(DecoderName,DecoderID,ChannelID,ProjectID,Zone,InstanceName);
		Decoder.Message();
//		
// 		Tooltip
		Decoder.Tool_Tip1();
		Decoder.Tool_Tip2();
		Decoder.Tool_Tip3();
		
//		Search
		Decoder.DisplayInactiveDecoder();
		Decoder.Search(searchKeyword);
		Decoder.Disable();
		Decoder.DisabledMessage();
		
//		Upsdate
		Decoder.UpdateDecoder();
		Decoder.UpdatedMessage();
		
//		Delete
		Decoder.DeleteDecoder();
		Decoder.DeletedMessage();
	
	}
}