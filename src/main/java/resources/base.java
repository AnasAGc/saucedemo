package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public Properties Prop;
	public WebDriver driver;

	public WebDriver initialzeWebDriver() throws IOException {

		Prop = new Properties();
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties";
		FileInputStream file = new FileInputStream(path);
		Prop.load(file);
		String Url = Prop.getProperty("Url");
		String BrowserName = System.getProperty("Browser");

		if (BrowserName == null) {

			BrowserName = Prop.getProperty("Browser");
		}

		if (BrowserName.toLowerCase().equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "\\src\\main\\java\\resources\\drivers\\chromedriver");
			driver = new ChromeDriver();

		}

		return driver;

	}

}
