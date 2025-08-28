package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class saucedemoHomepage extends base {

	private WebDriver driver;

	public saucedemoHomepage(WebDriver driver) {
		this.driver = driver;
	}

	private By userName = By.id("user-name");
	private By PassWord = By.id("password");
	private By LoginButton = By.id("login-button");
	private By addToCartButton = By.xpath("//button[text()='Add to cart']");
	private By shoppingcartcontainer = By.id("shopping_cart_container");
	private By checkoutButton=By.id("checkout");
	private By firstname=By.id("first-name");
	private By lastname=By.id("last-name");
	private By postalcode=By.id("postal-code");
	private By continueButton=By.name("continue");
	private By finishButton=By.id("finish");
	private By successMessage=By.tagName("h2");
	
	public WebElement successMessage() {
		return driver.findElement(successMessage);
	}
		
	public WebElement finishButton() {
		return driver.findElement(finishButton);
	}
	
	public WebElement continueButton() {
		return driver.findElement(continueButton);
	}
	
	public WebElement lastname() {
		return driver.findElement(lastname);
	}
	public WebElement postalcode() {
		return driver.findElement(postalcode);
	}
	
	public WebElement firstName() {
		return driver.findElement(firstname);
	}
	public WebElement checkoutButton() {
		return driver.findElement(checkoutButton);
	}

	
	public WebElement shoppingcartcontainer() {
		
		return driver.findElement(shoppingcartcontainer);
	}
	
	public WebElement addToCartButton() {
		
		return driver.findElement(addToCartButton);
	}

	public WebElement userField() {

		return driver.findElement(userName);
	}

	public WebElement PassWordField() {

		return driver.findElement(PassWord);
	}

	public WebElement LoginButton() {
		return driver.findElement(LoginButton);
	}

}
