package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SingleProductPage extends PageObject{
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div/div/div[1]/div/div[3]/button")
	private WebElement addToCartButton;
	@FindBy(how=How.XPATH, xpath="/html/body/nav/div/div[2]/ul/li[1]/a")
	private WebElement cartButton;
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div/div/div[1]/div/div[2]/div/span[2]/button")
	private WebElement increaseProductCountButton;
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div/div/div[1]/div/div[2]/div/span[1]/button")
	private WebElement decreaseProductCountButton;
	@FindBy(id="product_quantity")
	private WebElement productCount;
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div/div/div[1]/div/div[1]/div[3]/label")
	private WebElement size40;
	
	public SingleProductPage(WebDriver driver) {
		super(driver);
	}
	
	public void addToCart() {
		addToCartButton.click();
	}

	public CartPage cart() {
		cartButton.click();
		return new CartPage(driver);
	}
	
	public void increaseProductCount() {
		increaseProductCountButton.click();
	}
	
	public int getProductCount() {
		return Integer.parseInt(productCount.getAttribute("value"));
	}

	public void decreaseProductCount() {
		decreaseProductCountButton.click();
	}
	
	public void selectSize40() {
		size40.click();
	}
}
