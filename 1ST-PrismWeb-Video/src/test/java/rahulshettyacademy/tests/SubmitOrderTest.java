package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.OrderPage;

public class SubmitOrderTest extends BaseTest{
	WebDriver driver;
	String productName="ADIDAS ORIGINAL";
	@Test(dataProvider="getData",groups= {"Purchase"})
//	public void submitOrder(String email, String password, String productName) throws IOException, InterruptedException
	
	public void submitOrder(HashMap <String,String> input) throws IOException, InterruptedException
	{
		
//		ProductCatalogue productCatalogue=landingPage.loginApplication(email, password);
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("password"));
		
		List<WebElement>products=productCatalogue.getProductList();
//		productCatalogue.getProductByName(productName);
//		productCatalogue.addProductToCart(productName);
		productCatalogue.getProductByName(input.get("product"));
		productCatalogue.addProductToCart(input.get("product"));
		Thread.sleep(3000);
		CartPage cartPage=productCatalogue.goToCartPage();

		Boolean match=cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		  
		ConfirmationPage confirmationPage=checkoutPage.SubmitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		driver.close();
	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest() throws InterruptedException {
		ProductCatalogue productCatalogue=landingPage.loginApplication("helendaisy.john@gmail.com", "Helen#1989");
		
		OrderPage ordersPage=productCatalogue.goToOrdersPage();	
	 	Assert.assertFalse(ordersPage.VerifyOrderDisplay(productName));
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] {{"helendaisy@gmail.com","Johann#12","ADIDAS ORIGINAL"},{"helendaisy.john@gmail.com", "Helen#1989","ZARA COAT 3"}};
//	}
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email","helendaisy@gmail.com");
//		map.put("password","Johann#12");
//		map.put("product","ADIDAS ORIGINAL");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email","helendaisy.john@gmail.com");
//		map1.put("password","Helen#1989");
//		map1.put("product","ZARA COAT 3");
//		return new Object[][]  {{map},{map1}};
//		
//	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		return new Object[][]  {{data.get(0)},{data.get(1)}};
	
	}

}
