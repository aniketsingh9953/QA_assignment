package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver Driver;

	public static void initDriver() {
		WebDriverManager.chromedriver().setup();
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
	}
}
