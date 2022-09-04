package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class utils {
	public static WebDriver driver;

	public static WebDriver instantiate() {
		//System.setProperty("webdriver.chrome.whitelistedIps", "");

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.wikipedia.org");
		return driver;
	}
	public static void waitAmelisecond(int melisecond){
		try {
			Thread.sleep(melisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void closeDriver() {
		driver.close();
	}
}