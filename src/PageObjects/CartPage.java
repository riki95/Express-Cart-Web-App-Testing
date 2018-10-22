package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import AuxClasses.Money;

public class CartPage extends PageObject{
	@FindBy(how=How.XPATH, xpath="/html/body/nav/div/div[2]/ul/li[1]/a")
	private WebElement cartButton;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div[3]/div[2]/a")
	private WebElement checkoutButton;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div[1]/div/button")
	private WebElement closeCartButton;
	@FindBy(id="empty-cart")
	private WebElement emptyCartButton;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div/span[1]/button")
	private WebElement lessProduct1Button;
	@FindBy(id="notify_message")
	private WebElement notifyMessage;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div/span[2]/button")
	private WebElement plusProduct1Button;
	@FindBy(id="0")
	private WebElement product1Count;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/p[1]/a")
	private WebElement product1Name;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[3]/strong")
	private WebElement product1Price;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]/strong")
	private WebElement product2Price;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[1]/strong")
	private WebElement shippingPrice;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/strong")
	private WebElement totalPrice;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/p[2]")
	private WebElement size;
	
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public CheckoutPage checkout() {
		checkoutButton.click();
		return new CheckoutPage(driver);
	}
	
	public HomePage closeCart() {
		closeCartButton.click();
		return new HomePage(driver);
	}
	
	public void decreaseProduct1Number() {
		lessProduct1Button.click();
	}
	
	public void emptyCart() {
		emptyCartButton.click();
	}
	
	public String getNotifyMessage() {
		return notifyMessage.getText();
	}
	
	public int getProduct1Count() {
		return Integer.parseInt(product1Count.getAttribute("value"));
	}

	public String getProduct1Name() {
		return product1Name.getText();
	}

	public String getProduct1Price() {
		String unformatted = product1Price.getText();
		String replaced = unformatted.replace(".", "");
		replaced = replaced.replace("£", "");
		return replaced;
	}
	
	public String getProduct2Price() {
		String unformatted = product2Price.getText();
		String replaced = unformatted.replace(".", "");
		replaced = replaced.replace("£", "");
		return replaced;
	}

	public String getShippingPrice() {
		String unformatted = shippingPrice.getText();
		String replaced = unformatted.replace(".", "");
		replaced = replaced.replace("£", "");
		return replaced;
	}
	
	public Money getTotalPrice() {
		String unformatted = totalPrice.getText();
		String replaced = unformatted.replace(".", "");
		replaced = replaced.replace("£", "");
		return new Money(Integer.parseInt(replaced));
	}

	public void increaseProduct1Number() {
		plusProduct1Button.click();
	}
	
	public String getSize() {
		return size.getText();
	}
}
