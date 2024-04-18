package Pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {
	
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		String opt=driver.findElement(By.cssSelector("#checkBoxOption1")).getAttribute("value");
		System.out.println("Selected option is: " +opt);
		//		Select the dropdown
//		driver.findElement(By.cssSelector("#dropdown-class-example")).click();
//		WebElement dropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));
//		Select option=new Select(dropdown);
//		option.selectByVisibleText(abc);
		WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));

        Select s=new Select(dropdown);

        s.selectByVisibleText("Option1");
        driver.findElement(By.name("enter-name")).sendKeys(opt);
        driver.findElement(By.id("alertbtn")).click();
        String text=  driver.switchTo().alert().getText();
        if(text.contains(opt))
        {
       System.out.println("Alert message success");
        }
        else
       System.out.println("Something wrong with execution");
   }

          

          

        //  System.out.println( driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText());   

	}

