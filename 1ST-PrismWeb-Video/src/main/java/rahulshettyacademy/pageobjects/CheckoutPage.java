package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	WebDriver driver;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
//	@FindBy(xpath="//button[contains(@class,'ta-item')])[2]")
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement selectCountry;
	
	By results=By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
		
		
	}
	
	public ConfirmationPage SubmitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
	
	

}
