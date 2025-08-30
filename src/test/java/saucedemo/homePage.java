package saucedemo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.saucedemoHomepage;
import resources.base;

public class homePage extends base {
	public WebDriver driver;
	public WebDriverWait wait;
	public saucedemoHomepage hp;
	
	@BeforeMethod
	public void setup() throws IOException {
		this.driver = initialzeWebDriver();
		this.hp = new saucedemoHomepage(driver);
		driver.get(Prop.getProperty("Url"));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));;

	}
	
	
	
	
	
	
	@Test
	public void DemoTest()  {
		
		wait.until(ExpectedConditions.elementToBeClickable(hp.userField()));
		hp.userField().sendKeys(Prop.getProperty("User"));
		hp.PassWordField().sendKeys(Prop.getProperty("Pass"));
		hp.LoginButton().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(hp.addToCartButton()));
		hp.addToCartButton().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(hp.shoppingcartcontainer()));
		hp.shoppingcartcontainer().click();
		
		

		wait.until(ExpectedConditions.visibilityOf(hp.checkoutButton()));
		hp.checkoutButton().click();
		
		
		
		hp.firstName().sendKeys(Prop.getProperty("FirstName"));
		hp.lastname().sendKeys(Prop.getProperty("lastName"));
		hp.postalcode().sendKeys(Prop.getProperty("postalcode"));
		
		wait.until(ExpectedConditions.elementToBeClickable(hp.continueButton()));
		hp.continueButton().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(hp.finishButton()));
		hp.finishButton().click();
		wait.until(ExpectedConditions.visibilityOf(hp.successMessage()));
		assertEquals(hp.successMessage().getText(),"Thank you for your order!");
		
		
		
	}

}
