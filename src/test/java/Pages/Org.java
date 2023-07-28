package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Org {
	static WebElement element=null;
	
	
//	Login to the Portal
	public static WebElement Login_Button(WebDriver driver) {
		element =driver.findElement(By.xpath("//*[@id='root']/div/div/div/div[2]/button"));
		return element;
	}
	
	public static WebElement User_Name(WebDriver driver) {
		element =driver.findElement(By.xpath("(//input[@id='Input_Username'])[1]"));
		return element;
	}
	public static WebElement PassWord(WebDriver driver) {
		element =driver.findElement(By.xpath("(//input[@id='Input_Password'])[1]"));
		return element;
	}
	public static WebElement Login_BTN(WebDriver driver) {
		element =driver.findElement(By.xpath("//button[@value='login']"));
		System.out.println("Testcase 1 is Passed");
		System.out.println("Successfully Login to the Prism Portal");
		return element;
		
	}
		
//	Navigate to Core
	public static WebElement Hamburger_Menu(WebDriver driver) {
		element =driver.findElement(By.xpath("//button[@aria-label='menu']//*[name()='svg']"));
		return element;
	}
	public static WebElement Core_selection(WebDriver driver) {
		element =driver.findElement(By.xpath("//span[normalize-space()='Core']"));
		return element;
	}
	public static WebElement Org_selection(WebDriver driver) {
		element =driver.findElement(By.xpath("//p[normalize-space()='Organization']"));
		return element;
	}
	
//	Create a new organization
	public static WebElement Add_Icon(WebDriver driver) {
		element =driver.findElement(By.xpath("//button[@title='Add Organization']"));
		return element;
	}
	public static WebElement Display_Name(WebDriver driver) {
		element =driver.findElement(By.xpath("//input[@id='Display-Name']]"));
		return element;
	}
	public static WebElement Short_Name(WebDriver driver) {
		element =driver.findElement(By.xpath("//input[@id='Short-Name']"));
		return element;
	}
	public static WebElement ADD_Button(WebDriver driver) {
		element =driver.findElement(By.xpath("(//button[normalize-space()='Add'])[1]"));
		return element;
	}
	
}
