import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class BasicAuthendication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
//		Predictae will help us to filter and give the output.
		Predicate<URI>uriPredicate=uri->uri.getHost().contains("httpbin.org");
		
		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");
		

	}

}
