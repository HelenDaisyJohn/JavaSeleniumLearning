package Tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.BookingPage;

public class BookingTest {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.get("https://prism-web-hotfix-stm-prism-xpressbet.preprod.1stbet.com/");
		driver.manage().window().maximize();
		
//		create object
		BookingPage Booking=new BookingPage(driver);
		
//		Inputs-Login
		String UserName="admin@1st.com";
		String PassWord="admin";
		
//		Inputs- Add Encode
		String OrgName="Test_Org";
		String UnitName="Unit-01";
		
//		Search		
		String searchKeyword="Enc-Test23";
			
//		Test case1-Login
		
		Booking.Login_Button();
		Booking.User_Name(UserName);
		Booking.Password(PassWord);
		Booking.Login_BTN();
		Booking.Hamburger_Menu();
		
		
//		Navigate to Video Platform
		Booking.Select_Org_Dropdown(OrgName);
		Booking.Select_Unit_Dropdown(UnitName);


		
//		Add Booking-Test
		Booking.Select_Booking();
		Booking.Add_Booking();
////		Check Title
//		Booking.Check_Title();
		
		Booking.Select_Booking();
		Booking.Message();
//		
// 		Tooltip
		Booking.Tool_Tip1();
		Booking.Tool_Tip2();
		Booking.Tool_Tip3();
		
//		Search
		Booking.DisplayInactiveBooking();
		Booking.Search(searchKeyword);
		Booking.Disable();
		Booking.DisabledMessage();
		
//		Update
//		Booking.UpdateBooking();
//		Booking.UpdatedMessage();
//		
////		Delete
//		Booking.DeleteBooking();
//		Booking.DeletedMessage();
	
		
	}
}