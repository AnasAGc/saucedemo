package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.saucedemoHomepage;
import resources.base;

public class CheckoutSteps extends base {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public saucedemoHomepage hp;
	
	
	@Given("I am on the SauceDemo login page")
	public void land_on_SauceDemoPage() throws IOException {
		
		this.driver = initialzeWebDriver();
		this.hp = new saucedemoHomepage(driver);
		driver.get(Prop.getProperty("Url"));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));;
	}
	
	
	@When ("^I login with valid credentials username (.+) & password (.+)$")
	public void When_I_login_with_valid_credentials(String user, String Pass) {
		
		wait.until(ExpectedConditions.elementToBeClickable(hp.userField()));
		hp.userField().sendKeys(user);
		hp.PassWordField().sendKeys(Pass);
		hp.LoginButton().click();
	}
	
	
	@When("I add one product to the cart")
	public void add_one_product_to_the_cart () {

		wait.until(ExpectedConditions.elementToBeClickable(hp.addToCartButton()));
		hp.addToCartButton().click();}
	
	
	@And("I proceed to checkout")
	public void proceed_to_checkout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(hp.shoppingcartcontainer()));
		hp.shoppingcartcontainer().click();
		
		

		wait.until(ExpectedConditions.visibilityOf(hp.checkoutButton()));
		hp.checkoutButton().click();
		
		
		
		
		
	}
	
	@And("^I fill the checkout form with first name(.+), last name(.+), and zip(.+)")
	public void fill_checkout_form(String FirstName, String lastName,String postalcode  ){
		
		hp.firstName().sendKeys(FirstName);
		hp.lastname().sendKeys(lastName);
		hp.postalcode().sendKeys(postalcode);
		
	}
	
	
	@And("I finish the order")
	public void finish_the_order(){
		
		wait.until(ExpectedConditions.elementToBeClickable(hp.continueButton()));
		hp.continueButton().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(hp.finishButton()));
		hp.finishButton().click();
		
	}
	
			
	
	
	@Then("I should see the success message \"Thank you for your order!")
	public void success_message_appears(){
		wait.until(ExpectedConditions.visibilityOf(hp.successMessage()));
		assertEquals(hp.successMessage().getText(),"Thank you for your order!");
	}
	
	
	

}
