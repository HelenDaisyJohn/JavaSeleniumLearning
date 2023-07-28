package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver1.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage containing the MUI dynamic table
        driver.get("https://prism-web-feature-stm-467-edit-booking-end-time.dev.1stbet.com/");
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//*[@id='root']/div/div/div/div[2]/button")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("(//input[@id='Input_Username'])[1]")).sendKeys("admin@1st.com");
		driver.findElement(By.xpath("(//input[@id='Input_Password'])[1]")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@value='login']")).click();
//		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='login']")));
//		element.click();
		Thread.sleep(1000);
        
//		Navigate to Core
		driver.findElement(By.xpath("//button[@aria-label='menu']//*[name()='svg']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[normalize-space()='Core']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[normalize-space()='Organization']")).click();
		Thread.sleep(1000);

        
        
//        WebElement toolbarContainer = driver.findElement(By.xpath("//div[@class='MuiDataGrid-toolbarContainer css-1it2ytw-MuiDataGrid-toolbarContainer']"));

        // Locate the search input field within the toolbar container
        WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));


        // Enter the search criteria in the search input
        String searchKeyword = "Test_Org";
        searchInput.sendKeys(searchKeyword);
        Thread.sleep(1000);
        searchInput.sendKeys(Keys.ENTER);

        // Click the search button if required (some tables may have an explicit search button)
//        if (searchButton != null) {
//            searchButton.click();
//        } else {
//            // If there's no search button, you may trigger the search by other means (e.g., pressing Enter)
//            searchInput.sendKeys(Keys.RETURN);
//        }

        // Perform a loop to extract data from multiple pages
        






	}
}


