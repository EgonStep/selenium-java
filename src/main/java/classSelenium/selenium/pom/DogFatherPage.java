package classSelenium.selenium.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DogFatherPage {

	private WebDriver driver;
	
	@FindBy(how = How.CLASS_NAME, using = "produtos-info__box")
	private List<WebElement> products;

	public DogFatherPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public DogFatherPage acessDogFather() {
		driver.get("https://thedogfatherbrasil.com.br/cardapio-the-dogfather/");
		return this;
	}
	
	public String searchProduct(String text) {		
		for( WebElement p : products) {
			String pd = p.findElement(By.className("produtos-info__peso")).getText();
			String pr =	p.findElement(By.className("produtos-info__preco")).getText();
			String result = pd + " " + pr;
			if(result.equals(text)) {
				return result;
			}
		}
		return "";
	}
}
