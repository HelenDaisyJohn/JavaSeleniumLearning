package reports.extendReports;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportDemo {
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


//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//public class ExtendReportDemo<WebDriver> {
//	ExtentReports extent;
//	@BeforeTest
//	public void config() {
//		String path=System.getProperty("user.dir")+"\\reports\\index.html";
//		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
//		reporter.config().setReportName("Result");
//		reporter.config().setDocumentTitle("Test");
//		extent=new ExtentReports();
//		extent.attachReporter(reporter);
//		extent.setSystemInfo("Tester","Helen");
//	}
//
//	
//@Test
//public void initialDemo()
//{
//	extent.createTest("Initial Test");
//	System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
//	ChromeDriver driver=new ChromeDriver();
//	driver.get("https://rahulshettyacademy.com");
//	extent.flush();
//}
//		
//
//}

	
