package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrgUnitObjects {

	
		WebDriver driver=null;
//		Create a new organization Unit
		By Action=By.xpath("//button[@aria-label='more']");
		By Add_Unit=By.xpath("(//li[normalize-space()='Add Organization Unit'])[1]");
		By Display_Name=By.xpath("(//input[@id='Display-Name'])[1]");
		By Short_Name=By.xpath("(//input[@id='Short-Name'])[1]");
		By Unit_Type=By.xpath("(//div[@id='Type'])[1]");
		By Type_Name=By.xpath("(//li[normalize-space()='generic'])[1]");
		By ADDButton=By.xpath("(//button[normalize-space()='Add'])[1]");
		By SucessMessage_UnitAdd=By.xpath("(//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message'])[1]");
		
		
	
		public OrgUnitObjects(WebDriver driver)
		{
			this.driver= driver;
		}
//		Create a new organization Unit
		public void Action() {
			driver.findElement(Action).click();
		}
		public void Add_Unit() {
			driver.findElement(Add_Unit).click();
		}
		public void Display_Name(String UnitDisplayName) {
			driver.findElement(Display_Name).sendKeys(UnitDisplayName);
		}
		public void Short_Name(String UnitShortName) throws InterruptedException {
			driver.findElement(Short_Name).sendKeys(UnitShortName);
			Thread.sleep(1000);
		}
		public void Type() {
			driver.findElement(Unit_Type).click();
			driver.findElement(Type_Name).click();
			
		}
		public void ADD_Button() {
			driver.findElement(ADDButton).click();
			System.out.println("Testcase 2 is Passed");
			System.out.println("Successfully created a new organization Unit");
			System.out.println("");
		}
		
}


