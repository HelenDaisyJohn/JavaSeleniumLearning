package rahulshettyacademy.ExtendReports;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReports {
	ExtentReports extent;
	@BeforeTest
	public void config() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Result");
		reporter.config().setDocumentTitle("Test");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Helen");
	}

	
@Test
public void initialDemo()
{
	ExtentTest test=extent.createTest("Initial Test");
	System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com");
	System.out.println(driver.getTitle());
	driver.close();
	test.fail("Result do not match");
	
	extent.flush();
}
		

}

//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//
//
//public class ExtendReports {
//	ExtentReports extent;
//	
//	@BeforeTest
//	public void config()
//	{
//		String path=System.getProperty("user.dir")+"\\reports\\index.html";
//		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//		reporter.config().setReportName("Web Automation Result");
//		reporter.config().setDocumentTitle("Test Result");
//		
//		ExtentReports extent=new ExtentReports();
//		extent.attachReporter();
//		extent.setSystemInfo("Tester","Helen Daisy");
//	}
//	
//	@Test
//	public void initialDemo() {
//		extent.createTest("Initial Demo");
//		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
//		ChromeDriver driver= new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
//		driver.get("https://rahulshettyacademy.com/client/");
//		driver.manage().window().maximize();
//		System.out.println(driver.getTitle());
//		extent.flush();
//	}
//
//}
