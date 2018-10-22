package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPage extends PageObject{
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div/div/div/div[1]/div[2]/div[2]/div/div")
	private WebElement cartEmptyMessage;
	@FindBy(id="empty-cart")
	private WebElement emptyCartButton;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div[2]/div/div/div/span[2]/button")
	private WebElement increaseNumberButton;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div/div/div/div[2]/div[2]/a")
	private WebElement payButton;
	@FindBy(id="0")
	private WebElement product1Count;
	
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public void emptyCart() {
		emptyCartButton.click();
	}

	public String getEmptyCartMessage() {
		return cartEmptyMessage.getText();
	}
	
	public int getProduct1Count() {
		return Integer.parseInt(product1Count.getAttribute("value"));
	}

	public void IncreaseNumberButton() {
		increaseNumberButton.click();
	}
	
	public PayPage payNow() {
		payButton.click();
		return new PayPage(driver);
	}
}
