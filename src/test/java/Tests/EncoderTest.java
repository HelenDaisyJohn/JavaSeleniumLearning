package Tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Pages.OrgObjects;
import Pages.EncoderPage;

import Pages.OrgObjects;
public class EncoderTest {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://prism-web-feature-stm-467-edit-booking-end-time.dev.1stbet.com/");
		driver.manage().window().maximize();
		
//		create object
		EncoderPage Encoder=new EncoderPage(driver);
		

		
//		Inputs-Login
		String UserName="admin@1st.com";
		String PassWord="admin";
		String DisplayName="Test-02";
		String ShortName="Test-02";
		
//		Inputs- Add Encoder
		String OrgName="Test_Org";
		String UnitName="Unit-01";
		String EncoderName="Enc-Test2";
		String EncoderID="Enc-Test2";
		
		String searchKeyword="Test_Org";
		
		
		
//		Test case1-Login
		Encoder.Login_Button();
		Encoder.User_Name(UserName);
		Encoder.Password(PassWord);
		Encoder.Login_BTN();
		Encoder.Hamburger_Menu();
		
		
//		Navigate to Video Platform
		Encoder.Select_Video();
		Encoder.Select_Org_Dropdown(OrgName);
		Encoder.Select_Unit_Dropdown(UnitName);

		
//		Add Encoder-Test
		Encoder.Select_Encoder();
//		Encoder.Select_Encoder(EncoderName,EncoderID);
//		Encoder.Message();
		
// 		Tooltip
		Encoder.Tool_Tip1();
		Encoder.Tool_Tip2();
		Encoder.Tool_Tip3();
		
//		Search
		Encoder.Search(searchKeyword);
		
		
		
		
		
	}
}