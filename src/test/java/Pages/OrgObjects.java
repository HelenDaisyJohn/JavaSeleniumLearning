package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrgObjects {
	
	WebDriver driver=null;
//	Login to the portal
	By Login_Button=By.xpath("//*[@id='root']/div/div/div/div[2]/button");
	By User_Name=By.xpath("(//input[@id='Input_Username'])[1]");
	By User_Password=By.xpath("(//input[@id='Input_Password'])[1]");
	By Login_BTN=By.xpath("//button[@value='login']");
	
//	Navigate to Core

	By Hamburger_Menu1=By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[1]/button[1]");
	
	By Org_selection=By.xpath("//p[normalize-space()='Organization']");
	
	
//	Create a new organization
	By Add_Icon=By.xpath("//button[@title='Add Organization']");
	By Display_Name=By.xpath("//input[@id='Display-Name']");
	By Short_Name=By.xpath("//input[@id='Short-Name']");
	By ADD_Button=By.xpath("(//button[normalize-space()='Add'])[1]");
	
	
//	Search
	By Search1=By.xpath("//input[@type='search']");
	
	
//	Actions
	By Actions1=By.xpath("(//li[@role='menuitem'])");
	
//  Navigate to organization Uni	
//	String DisplayName="Test_Org";
	
	
	
	
public OrgObjects(WebDriver driver)
	{
		this.driver= driver;
	}

	//	Login to the Portal
	public void Login_Button() {
		driver.findElement(Login_Button).click();;
	}
	
	public void User_Name(String UserName) {
		driver.findElement(User_Name).sendKeys(UserName);
		
	}
	public void Password(String Password) {
		driver.findElement(User_Password).sendKeys(Password);
		
	}
	public void Login_BTN() {
		driver.findElement(Login_BTN).click();
		System.out.println("Testcase 1 is Passed");
		System.out.println("Successfully Login to the Prism Portal");
	}
	
		
//	Navigate to Core
	public void Hamburger_Menu() {
		driver.findElement(Hamburger_Menu1).click();
		
	}
	
	public void Org_selection() {
		driver.findElement(Org_selection).click();
		
	}
	
//	Get title
	public void Title() {
		System.out.println("Title of the Web page is: "+driver.getTitle());
	}
	
//	Create a new organization
	public void Add_Icon() {
		driver.findElement(Add_Icon).click();
	}
	public void Display_Name(String DisplayName) {
		driver.findElement(Display_Name).sendKeys(DisplayName);
	}
	public void Short_Name(String ShortName) {
		driver.findElement(Short_Name).sendKeys(ShortName);
	}
	public void ADD_Button() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ADD_Button).click();
		System.out.println("Testcase 2 is Passed");
		
		System.out.println("Successfully created a new organization");
		System.out.println("");
	}
	
	public void Search(String DisplayName) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(Search1).sendKeys(DisplayName);
		System.out.println("Testcase 3 is Passed");
		System.out.println("Successfully searched the organization");
		System.out.println("");
	}
	
	
//	public void Action() throws InterruptedException 
//	{
//		driver.findElement(By.xpath("(//div[@role='menu'])[1]")).click();
//		Thread.sleep(2000);
//		System.out.println("The organization action optionsa are:");	
//		List<WebElement> allActions= driver.findElements(By.xpath("(//li[@role='menuitem'])"));
//		Thread.sleep(2000);
//		for(WebElement option:allActions)
//		{
//			System.out.println(option.getText());	
//		}
//	}

	

	
	
	public void NavToUnit(String DisplayName) throws InterruptedException {
		WebElement navtounit=driver.findElement(By.xpath("(//p[contains(text(),'" + DisplayName + "')])[1]"));
		navtounit.click();
		Thread.sleep(1000);
		System.out.println("Successfully Navigated to Organization Unit");
	}
	
//	public void Rowscount() throws InterruptedException {
//	JavascriptExecutor js=(JavascriptExecutor)driver;
//	js.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
//	driver.findElement(By.xpath("//p[@class='MuiTablePagination-displayedRows css-12aoau8']")).getText();
//	System.out.println("Total Rows:"+totalRows);
//	}
	
//	public void Rows() throws InterruptedException {
//		driver.findElement(By.xpath("//div[@class='rst__rowContents rst__rowContentsDragDisabled']//div[@class='rst__rowToolbar']//div[@class='rst__toolbarButton']//div//button[@aria-label='more']"));
//		Thread.sleep(1000);
//		System.out.println("Organization Unit");
//		List<WebElement> OrgUnitActions= driver.findElements(By.xpath("(//li[@role='menuitem'])"));
//		
//	}
	
	
	
	
	
}
