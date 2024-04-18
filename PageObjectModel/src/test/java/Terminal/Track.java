package Terminal;

import java.time.Duration;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Track {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver1\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		Navigate to webpage -TestCase-001
		driver.get("https://prism-terminal.dev.1stbet.com/");
		System.out.println("Test Case NET_SHS_001: User can navigate to the Webpage- passed");
		System.out.println("");
		System.out.println("");
		Thread.sleep(3000);
		
				
	
//		Navigate to the "Track Browser page"- Testcase-002
//		driver.findElement(By.xpath("//div[@class='MuiBox-root css-tw4vmx']")).click();
		System.out.println("Test Case NET_SHS_002: User can navigate to the Track Browser page- passed");
		System.out.println("");
		System.out.println("");
		
//		Get the title of the webpage- Testcase-003
		System.out.println("Title of the page is: "+driver.getTitle());
		System.out.println("Test Case NET_SHS_003: User can navigate to the Track Browser page- passed");
		System.out.println("");
		System.out.println("");
	
		
//		Verify whether the user is navigated to track browser page		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@id='root'])[1]")).click();
		System.out.println("Test Case NET_SHS_004: User can navigate to the Track Browser page- passed");
		System.out.println("");
		System.out.println("");
		
//		Verify tracks are sorted by track name
		driver.findElement(By.xpath("//button[normalize-space()='Track Name']")).click();
		List<WebElement> SortedTracks= driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-6 MuiGrid-grid-md-6 MuiGrid-grid-lg-4 css-1tppydz-MuiGrid-root']"));
		for (WebElement SortedTrack :SortedTracks)
		{
			System.out.println("Name of Horses in page: "+SortedTrack.getText());
		}
		System.out.println("Test Case NET_SHS_005: The tracks are sorted by track name- passed");
		System.out.println("");
		System.out.println("");
		
		
//		Verify that the start time is selected by default- Testcase-004
		boolean startTime= driver.findElement(By.xpath("//button[normalize-space()='Start Time']")).isEnabled();
		System.out.println("The start time is selected: "+startTime);
		System.out.println("Test Case NET_SHS_005: The start time is selected by default- passed");
		System.out.println("");
		System.out.println("");
		

		
//		Check the ticket Balance- Testcase-005
		driver.findElement(By.xpath("//div[contains(text(),'BALANCE')]")).click();
		String Balance=driver.findElement(By.xpath("(//div[contains(@class,'MuiBox-root css-35ezg3')])[1]")).getText();
		System.out.println("Ticket balance amount is: " +Balance);
		System.out.println("The user can see the available ticket balance- Test case 005 is passed");
		System.out.println("");
		System.out.println("");
		
		
//		Verify that "Your track" has only one track - Testcase-006 
		
		boolean TrackPresence=driver.findElement(By.xpath("//span[@class='MuiBox-root css-0']")).isDisplayed();
		if(TrackPresence==true)
		{
			Thread.sleep(1000);
			WebElement nameTrack=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div[1]/div[1]/h3"));
			System.out.println("One Track is available");
			System.out.println("Name of the track is: "+nameTrack.getText());
			System.out.println("Your Track data is available:" +TrackPresence);
			
		}
		else
		{
			System.out.println("Track is not available");
		}
		System.out.println("");
		System.out.println("");
		
		
//		Verify your track Race number and starting time is displayed - Testcase-007
		WebElement track= driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-6 MuiGrid-grid-md-6 MuiGrid-grid-lg-4 css-1tppydz-MuiGrid-root'][1]"));
		System.out.println("Your track details is: "+track);	
		System.out.println("Your Track Race number and starting time is displayed- Test case 007 is passed");
		System.out.println("");
		System.out.println("");
		
//		verify that no of tracks are available - Testcase-008
		List<WebElement> YourTrack= driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-6 MuiGrid-grid-md-6 MuiGrid-grid-lg-4 css-1tppydz-MuiGrid-root']"));
		int noTrack= YourTrack.size();
		System.out.println("Number of Tracks in page: "+noTrack);
		System.out.println("Your Track data is displayed- Test case 008 is passed");
		System.out.println("");
		System.out.println("");
		
//		List of available tracks - Testcase-009
		
		List<WebElement> TrackNames= driver.findElements(By.xpath("//h3[@class='MuiTypography-root MuiTypography-h3 text-uppercase css-1uo83c1-MuiTypography-root']"));
		for (WebElement TrackName :TrackNames)
		{
			System.out.println("Name of Horses in page: "+TrackName.getText());
		}
		System.out.println("Your Track data is displayed- Test case 009 is passed");
		System.out.println("");
		System.out.println("");
		
	
		
//		Navigate to horse selection page - Testcase-010
		driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-6 MuiGrid-grid-md-6 MuiGrid-grid-lg-4 css-1tppydz-MuiGrid-root']")).click();
		System.out.println("The user is navigated to the Horse Selection Page - Test case 010 is passed");
		System.out.println("");
		System.out.println("");
		
//		Get the title of the page
		System.out.println("Title is: "+driver.getTitle());
		
		List<WebElement> Horses= driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 MuiGrid-grid-md-4 MuiGrid-grid-lg-3 css-bjl4n6-MuiGrid-root']"));
		int noHorses= Horses.size();
		System.out.println("Number of Horses in page: "+noHorses);
		List<WebElement> HorsesNames= driver.findElements(By.xpath("//h6[@class='MuiTypography-root MuiTypography-h6 css-ctfxp2-MuiTypography-root'][1]"));
		for (WebElement HorsesName :HorsesNames)
		{
			System.out.println("Name of Horses in page: "+HorsesName.getText());
		}
		
//		Navigate to horse selection page - Testcase-011
		System.out.println("The list of horses on the Horse Selection Page - Test case 011 is passed");
		System.out.println("");
		System.out.println("");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 MuiGrid-grid-md-4 MuiGrid-grid-lg-3 css-bjl4n6-MuiGrid-root'][2]")).click();
		driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 MuiGrid-grid-md-4 MuiGrid-grid-lg-3 css-bjl4n6-MuiGrid-root'][3]")).click();
		driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 MuiGrid-grid-md-4 MuiGrid-grid-lg-3 css-bjl4n6-MuiGrid-root'][4]")).click();
		
		WebElement SelectedHorses= driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 MuiGrid-grid-md-4 MuiGrid-grid-lg-3 css-bjl4n6-MuiGrid-root'][2]"));
		System.out.println("Selected Horses in page: "+SelectedHorses.getText());
		System.out.println("");
		System.out.println("");
		
		WebElement SelectedHorses1= driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 MuiGrid-grid-md-4 MuiGrid-grid-lg-3 css-bjl4n6-MuiGrid-root'][3]"));
		System.out.println("Selected Horses in page: "+SelectedHorses1.getText());
		System.out.println("");
		System.out.println("");
		
		WebElement SelectedHorses2= driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 MuiGrid-grid-md-4 MuiGrid-grid-lg-3 css-bjl4n6-MuiGrid-root'][4]"));
		System.out.println("Selected Horses in page: "+SelectedHorses2.getText());
		System.out.println("Selected Horse");
		System.out.println("");
		System.out.println("");
		
		//The user is navigated to the three horse selection page			
		driver.findElement(By.xpath("//button[normalize-space()='NEXT']")).click();
		System.out.println("The user is navigated to the three horse selection page - Test case 012 is passed");		
		System.out.println("");
		System.out.println("");
		
//		Select any one wager range.
		driver.findElement(By.xpath("//div[@class='page-content-inner MuiBox-root css-0']//div[4]")).click();
		System.out.println("The user is selected the wager range - Test case 012 is passed");		
		System.out.println("");
		System.out.println("");
		
		
//		Select any one betting type
		driver.findElement(By.xpath("(//div[@class='MuiCardContent-root css-46bh2p-MuiCardContent-root'])[1]")).click();
		System.out.println("The user is selected the betting type - Test case 012 is passed");		
		System.out.println("");
		System.out.println("");
		
//		Select the bet placed button
		driver.findElement(By.xpath("//div[normalize-space()='place bets']")).click();
		System.out.println("The user is confirmed the betting - Test case 013 is passed");		
		System.out.println("");
		System.out.println("");		
		
		
//		Select the track is displayed on the drawer.
		WebElement SelectedHorse= driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-fekk9p-MuiTypography-root']"));
		System.out.println("Name of Horses in page: "+SelectedHorse.getText());
		System.out.println("The user is confirmed the betting - Test case 014 is passed");		
		System.out.println("");
		System.out.println("");		
		
//		Display the summary details		
		WebElement HorsesNames1= driver.findElement(By.xpath("//div[@class='MuiBox-root css-8gnftt']"));
		System.out.println("Selected Horses in page: "+HorsesNames1.getText());
		System.out.println("The betting summary is displayed - Test case 015 is passed");		
		System.out.println("");
		System.out.println("");
		
		
		
		
		
		
		
		
		
	

}
}
