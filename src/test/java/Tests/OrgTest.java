package Tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.OrgObjects;
public class OrgTest {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://prism-web-feature-stm-467-edit-booking-end-time.dev.1stbet.com/");
		driver.manage().window().maximize();
		
//		create object
		OrgObjects login=new OrgObjects(driver);
		
//		Inputs
		String UserName="admin@1st.com";
		String PassWord="admin";
		String DisplayName="Test-014";
		String ShortName="Test-014";
		
		String searchKeyword="Test_Org";
		
		
		
//		Test case1-Login
		login.Login_Button();
		login.User_Name(UserName);
		login.Password(PassWord);
		login.Login_BTN();
		login.Hamburger_Menu();
		login.Core_selection();
		login.Org_selection();
//		Get title of the page
		login.Title();
		
		
//		Test case2-Add organization
		login.Add_Icon();
		login.Display_Name(DisplayName);
		login.Short_Name(ShortName);
		login.ADD_Button();
		
//		Test case3-Add organization
		
		
//		Search
		login.Search(searchKeyword);
		
//		Navigate to organization unit
		login.NavToUnit();
		
		
		
		
		
		
		
		
		
		
	
	}

}
