import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class UploadDownload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver().manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

	}

}
