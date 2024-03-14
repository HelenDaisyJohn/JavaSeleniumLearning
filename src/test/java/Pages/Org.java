package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
		element =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/button[2]"));
		return element;
	}
	
	public static WebElement Org_selection(WebDriver driver) {
		element =driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body2 css-z01lgo css-1bz7ler'][normalize-space()='Organization'])[1]"));
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
