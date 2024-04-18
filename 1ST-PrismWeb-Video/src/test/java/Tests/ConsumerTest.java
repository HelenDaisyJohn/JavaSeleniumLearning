package Tests;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.ConsumerPage;
public class ConsumerTest {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://prism-web-hotfix-stm-prism-xpressbet.preprod.1stbet.com/");
		driver.manage().window().maximize();
		
		String randomName=UUID.randomUUID().toString();
		String randomNumber=UUID.randomUUID().toString();
		
//		Inputs-Login
		String UserName="admin@1st.com";
		String PassWord="admin";
		
		
//		Inputs- Add Consumer
		String OrgName="Test_Org";
		String UnitName="Unit-01";
		String ConsumerName="Dec-Test"+randomName.subSequence(0, 2);
		String ConsumerNumber="123";
		CharSequence UsageLimit=randomNumber.subSequence(0, 4);		
		
		
//		Search	
		String searchKeyword=ConsumerName;
//		create object
		ConsumerPage src=new ConsumerPage(driver);
//		Test case1-Login
		src.Login_Button();
		src.User_Name(UserName);
		src.Password(PassWord);
		src.Login_BTN();
		src.Hamburger_Menu();
		
		
//		Navigate to Video Platform
		src.Select_Org_Dropdown(OrgName);
		src.Select_Unit_Dropdown(UnitName);

		
//		Add Consumer-Test
		src.Select_Consumer();
		src.Add_Consumer(ConsumerName,ConsumerNumber,UsageLimit);
//		src.Message();
//		
// 		Tooltip
		src.Tool_Tip1();
		src.Tool_Tip2();
		src.Tool_Tip3();
		
		
//		Table header
		src.Table_Columns();
		
//		Search
		src.DisplayInactiveConsumer();
		src.Search(searchKeyword);
		src.Disable();
		src.Reenable();

//		Update
		src.UpdateConsumer();
//		Consumer.UpdatedMessage();
		
//	
	}
}