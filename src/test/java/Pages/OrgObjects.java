package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrgObjects {
	WebDriver driver=null;
//	Login to the portal
	By Login_Button1=By.xpath("//*[@id='root']/div/div/div/div[2]/button");
	By User_Name1=By.xpath("(//input[@id='Input_Username'])[1]");
	By Password1=By.xpath("(//input[@id='Input_Password'])[1]");
	By Login_BTN1=By.xpath("//button[@value='login']");
	
//	Navigate to Core
	By Hamburger_Menu1=By.xpath("//button[@aria-label='menu']//*[name()='svg']");
	By Core_selection1=By.xpath("//span[normalize-space()='Core']");
	By Org_selection1=By.xpath("//p[normalize-space()='Organization']");
	
	
//	Create a new organization
	By Add_Icon1=By.xpath("//button[@title='Add Organization']");
	By Display_Name1=By.xpath("//input[@id='Display-Name']");
	By Short_Name1=By.xpath("//input[@id='Short-Name']");
	By ADD_Button1=By.xpath("(//button[normalize-space()='Add'])[1]");
	
	
//	Search
	By Search1=By.xpath("//input[@type='search']");
//  Navigate to organization Unit	
	By NavToUnit1=By.xpath("(//div[@role='cell'])[1]");
	
	
	
public OrgObjects(WebDriver driver)
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
	
		
//	Navigate to Core
	public void Hamburger_Menu() {
		driver.findElement(Hamburger_Menu1).click();
		
	}
	public void Core_selection() {
		driver.findElement(Core_selection1).click();
		
	}
	public void Org_selection() {
		driver.findElement(Org_selection1).click();
		
	}
	
//	Get title
	public void Title() {
		System.out.println("Title of the Web page is: "+driver.getTitle());
	}
	
//	Create a new organization
	public void Add_Icon() {
		driver.findElement(Add_Icon1).click();
	}
	public void Display_Name(String DisplayName) {
		driver.findElement(Display_Name1).sendKeys(DisplayName);
	}
	public void Short_Name(String ShortName) {
		driver.findElement(Short_Name1).sendKeys(ShortName);
	}
	public void ADD_Button() {
		driver.findElement(ADD_Button1).click();
		System.out.println("Testcase 2 is Passed");
		System.out.println("Successfully created a new organization");
		
	}
	
	public void Search(String searchKeyword) {
		driver.findElement(Search1).sendKeys(searchKeyword);
		
		System.out.println("");
	}
	
	public void NavToUnit() {
		driver.findElement(NavToUnit1).click();
		
		System.out.println("Successfully Navigated to Organization Unit");
	}
	
	
	
	
	
}
