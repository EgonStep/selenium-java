package classSelenium.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import classSelenium.selenium.pom.DogFatherPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DogFatherTest {

	WebDriver driver;

	@Before
	public void before() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testDogFather() {
		DogFatherPage page = new DogFatherPage(driver);
		page.acessDogFather();
		Assert.assertEquals("17 cm R$ 12,90", page.searchProduct("17 cm R$ 12,90"));
		Assert.assertEquals("33 cm R$ 22,90", page.searchProduct("33 cm R$ 22,90"));
	}

	@After
	public void after() {
		driver.quit();
	}
}
