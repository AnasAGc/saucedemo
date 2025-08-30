package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import resources.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class hooks extends base{


	    @Before
	    public void setUp(Scenario scenario) {
	        System.out.println("Starting scenario: " + scenario.getName());
	    }

	    @After
	    public void tearDown(Scenario scenario) {
	        try {
	        	 if (driver != null) {
	                 final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

	                 scenario.attach(screenshot, "image/png", 
	                                 scenario.getName() + " - Screenshot");

	                 System.out.println("📸 Screenshot captured for scenario: " + scenario.getName());
	             }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (driver != null) {
	                driver.quit();
	            }
	        }
	    }
	}

