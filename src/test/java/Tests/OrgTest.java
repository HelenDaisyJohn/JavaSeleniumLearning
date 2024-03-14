package Tests;
import java.util.concurrent.TimeUnit;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import Pages.EncoderPage;
import Pages.Org;
import Pages.OrgObjects;
import Pages.OrgUnitObjects;
//import Pages.OrgUnitObjects;
import Pages.EncoderPage;
public class OrgTest {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://prism-web.dev.1stbet.com/");
		driver.manage().window().maximize();
	
//		create object
		OrgObjects login=new OrgObjects(driver);
		
//		Inputs
		String UserName="admin@1st.com";
		String PassWord="admin";
		String randomDisplayName=UUID.randomUUID().toString();
		String DisplayName = "Test" + randomDisplayName.substring(0, 4);
		String ShortName = "Test" + randomDisplayName.substring(0, 4);

		String searchKeyword=DisplayName;
		
		String randomUnitDisplayName=UUID.randomUUID().toString();
		String UnitDisplayName = "Unit-" + randomUnitDisplayName.substring(0, 4);
		String UnitShortName = "Unit-" + randomUnitDisplayName.substring(0, 4);
		
		
		
		
//		Inputs- Add Encoder
		String OrgName=DisplayName;
		String UnitName=UnitDisplayName;
		String EncoderName="Enc-Test2";
		String EncoderID="Enc-Test2";
		
		String searchKeywordEncoder="Enc-Test2";
		
		String SucessMessage_UnitAdd="Organization Unit Successfully Added";
		
//		Inputs- Add Encode
		
	
//		Test case1-Login
		login.Login_Button();
		login.User_Name(UserName);
		login.Password(PassWord);
		login.Login_BTN();
		login.Hamburger_Menu();

		login.Org_selection();
		
//		Get title of the page
		login.Title();
		
//		Test case2-Add organization
		login.Add_Icon();
		login.Display_Name(DisplayName);
		login.Short_Name(ShortName);
		login.ADD_Button();
		
//		Test case3-	Search
		login.Search(DisplayName);
		
//		Action for the organization
//		login.Action();
		
//		Test case4-Navigate to organization unit
		login.NavToUnit(DisplayName);
//		login.Rows();
		
//		create object
		OrgUnitObjects OrgUnit=new OrgUnitObjects(driver);
		OrgUnit.Action();
		OrgUnit.Add_Unit();
		OrgUnit.Display_Name(UnitDisplayName);
		OrgUnit.Short_Name(UnitShortName);
		OrgUnit.Type();
		OrgUnit.ADD_Button();
		
//		create object
		EncoderPage Encoder=new EncoderPage(driver);
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


