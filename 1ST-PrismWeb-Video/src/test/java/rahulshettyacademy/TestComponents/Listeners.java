package rahulshettyacademy.TestComponents;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import rahulshettyacademy.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentTest Test;	
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result)	
	{
		Test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(Test);//Assign Unique thread ID
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		extentTest.get().log(Status.PASS, "Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		
//		Take Screenshot
		
		String filePath = null;
		try {
		filePath=getScreenshot(result.getMethod().getMethodName(),driver);
		}catch(IOException e) {
			e.printStackTrace();	
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
//		Attached with document
	}
	
	


	@Override
	public void onTestSkipped(ITestResult result)
	{
		
	}
	
//	@Override
//	public void onFinish(ITestResult result)
//	{
//		
//	}

}
