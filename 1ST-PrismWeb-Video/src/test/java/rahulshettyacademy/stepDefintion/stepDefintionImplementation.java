package rahulshettyacademy.stepDefintion;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class stepDefintionImplementation extends BaseTest{
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landingPage=launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) throws IOException
	{
		 productCatalogue=landingPage.loginApplication(username, password);
	}
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName)
	{
		List<WebElement>products=productCatalogue.getProductList();
//		productCatalogue.getProductByName(input.get("product"));
		productCatalogue.addProductToCart(productName);
	}
	
	@When("^And Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName)
	{
		CartPage cartPage=productCatalogue.goToCartPage();

		Boolean match=cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		  
		confirmationPage=checkoutPage.SubmitOrder();
	}
	
	@Then("{string} message is displayed on confirmationPage")
	public void message_is_displayed_on_confirmationPage (String string)
	{
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	}
	
}
