package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;


public class ErrorValidation extends BaseTest {
//	@Test(groups={"ErrorHandling"},retryAnalyzer=Retry.class)
	
	@Test(groups={"ErrorHandling"})
	public void loginErrorValidation() throws IOException, InterruptedException
	
	{
		String productName = "ADIDAS ORIGINAL";
		ProductCatalogue productCatalogue=landingPage.loginApplication("anshika@gmail.com", "111");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
	}
	
	@Test
	public void productErrorValidation() throws IOException, InterruptedException
	{
		String productName="ADIDAS ORIGINAL11";
	
		LandingPage landingPage=launchApplication();
		ProductCatalogue productCatalogue=landingPage.loginApplication("helendaisy.john@gmail.com", "Helen#1989");
		
		
		List<WebElement>products=productCatalogue.getProductList();
		productCatalogue.getProductByName(productName);
		
		productCatalogue.addProductToCart(productName);
		Thread.sleep(5000);
		CartPage cartPage=productCatalogue.goToCartPage();

		
		
		Boolean match=cartPage.VerifyProductDisplay(productName);
		Assert.assertFalse(match);
//		CheckoutPage checkoutPage=cartPage.goToCheckout();
//		checkoutPage.selectCountry("india");
//		  
//		ConfirmationPage confirmationPage=checkoutPage.SubmitOrder();
//		String confirmMessage = confirmationPage.getConfirmationMessage();
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		driver.close();
	}
	

}
