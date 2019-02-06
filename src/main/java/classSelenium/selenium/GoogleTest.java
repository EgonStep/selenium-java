package classSelenium.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import classSelenium.selenium.pom.GooglePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	WebDriver driver;

	@Before
	public void before() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testGoogle() {
		GooglePage page = new GooglePage(driver);
		page.acessGoogle().typeTextToSearch("The DogFather").clickSearchButton();

		String text = "The Dogfather Brasil: A maior franquia de premium Hot dogs do Brasil";
		Assert.assertEquals(true, page.searchResult(text));
	}

	@After
	public void after() {
		driver.quit();
	}
}
