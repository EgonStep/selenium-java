package classSelenium.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static classSelenium.selenium.utils.Tools.waitBy;

import java.util.List;

public class GooglePage {

	private WebDriver driver;

	@FindBy(how = How.NAME, using = "q")
	private WebElement searchInput;

	@FindBy(how = How.NAME, using = "btnK")
	private WebElement searchBtn;

	@FindBy(how = How.CLASS_NAME, using = "LC20lb")
	private List<WebElement> searchResult;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public GooglePage acessGoogle() {
		driver.get("http://google.com");
		return this;
	}

	public GooglePage typeTextToSearch(String text) {
		waitBy(searchInput, driver).sendKeys(text);
		return this;
	}

	public GooglePage clickSearchButton() {
		waitBy(searchBtn, driver).click();
		return this;
	}

	public boolean searchResult(String text) {
		for (WebElement i : searchResult) {
			if (i.getText().equals(text)) {
				return true;
			}
		}
		return false;
	}
}
