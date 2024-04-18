package Tests;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.SourcePage;
public class SourceTest {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.get("https://prism-web-hotfix-stm-prism-xpressbet.preprod.1stbet.com/");
		driver.manage().window().maximize();
		
		String randomName=UUID.randomUUID().toString();
		
//		Inputs-Login
		String UserName="admin@1st.com";
		String PassWord="admin";
		
		
//		Inputs- Add Source
		String OrgName="Test_Org";
		String UnitName="Unit-01";
		String SourceName="Dec-Test"+randomName.subSequence(0, 2);
		
		
//		Search	
		String searchKeyword=SourceName;
		
//		create object
		SourcePage src=new SourcePage(driver);

			
//		Test case1-Login
		src.Login_Button();
		src.User_Name(UserName);
		src.Password(PassWord);
		src.Login_BTN();
		src.Hamburger_Menu();
		
		
//		Navigate to Video Platform
		
		src.Select_Org_Dropdown(OrgName);
		src.Select_Unit_Dropdown(UnitName);

		
//		Add Source-Test
		src.Select_Source();
		src.Select_Source(SourceName);
//		src.Message();
//		
// 		Tooltip
		src.Tool_Tip1();
		src.Tool_Tip2();
		src.Tool_Tip3();
		
		
//		Table header
		src.Table_Columns();
		
//		Search
		src.DisplayInactiveSource();
		src.Search(searchKeyword);
		src.Disable();
		src.Reenable();

////		Update
		src.UpdateSource();
//		Source.UpdatedMessage();
		
//		

		
	}
}