package saucedemo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.saucedemoHomepage;
import resources.base;

public class homePage extends base {
	public WebDriver driver;
	public saucedemoHomepage hp;
	public WebDriverWait wait;
	
	
	@BeforeMethod
	public void setup() throws IOException {
		this.driver = initialzeWebDriver();
		this.hp = new saucedemoHomepage(driver);
		driver.get(Prop.getProperty("Url"));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));;

	}
	
	@Test
	public void test() {
		
	
		
		
	}
}
