package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {
	WebDriver driver;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException{
		
		
		
//		Properties props=new Properties();
//		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resources//GlobalData.properties");
//		props.load(fis);
//		String browserName=props.getProperty("browser");
//		
//		
//		if(browserName.equalsIgnoreCase("chrome"))
//		{
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
//		
//	}
//		else if((browserName.equalsIgnoreCase("firefox"))){
//			
//		}
//else if((browserName.equalsIgnoreCase("edge"))){
//			
//		}
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
//		Convert JSON to String : we have inbuild function file utils
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
//		Convert from String to Hashmap: we dont ahve inbuild function so need external function Jackson Databind
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
			
		});
		return data;
	}
	
public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}
	
	
//	@BeforeMethod(groups= {"ErrorHandling"})
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver=initializeDriver();
		landingPage=new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun=true)
//	
	public void tearDown(){
		driver.close();
	}
}                                          
