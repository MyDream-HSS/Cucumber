/*package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks2 {

WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/drivers/" + "chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Chrome browser launched");
	}

	@After
	public void tearDown() {
		driver.quit();
		System.out.println("Browser closed");
	}
}
*/