package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

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
			driver = WebDriverManager.chromedriver().create();
		}
		if (BrowserName.toLowerCase().equals("edge")) {
			driver = WebDriverManager.edgedriver().create();
		}
		if (BrowserName.toLowerCase().equals("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;

	}

}
