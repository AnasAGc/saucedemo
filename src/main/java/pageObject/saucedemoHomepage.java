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
