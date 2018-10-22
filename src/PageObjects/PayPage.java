package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PayPage extends PageObject{
	@FindBy(id="empty-cart")
	private WebElement emptyCartButton;
	@FindBy(id="customerLogin")
	private WebElement existingLoginButton;
	@FindBy(id="customerLoginEmail")
	private WebElement existingLoginEmail;
	@FindBy(id="customerLoginPassword")
	private WebElement existingLoginPassword;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div[2]/div/div/div/span[2]/button")
	private WebElement increaseProduct1CountButton;
	@FindBy(id="shipAddr1")
	private WebElement newUserAddr1;
	@FindBy(id="shipAddr2")
	private WebElement newUserAddr2;
	@FindBy(id="shipCountry")
	private WebElement newUserCountry;
	@FindBy(id="createCustomerAccount")
	private WebElement newUserCreateAccountButton;
	@FindBy(id="shipEmail")
	private WebElement newUserEmail;
	@FindBy(id="shipFirstname")
	private WebElement newUserFirstName;
	@FindBy(id="shipLastname")
	private WebElement newUserLastName;
	@FindBy(id="newCustomerPassword")
	private WebElement newUserPassword;
	@FindBy(id="shipPhoneNumber")
	private WebElement newUserPhone;
	@FindBy(id="shipPostcode")
	private WebElement newUserPostCode;
	@FindBy(id="shipState")
	private WebElement newUserState;
	@FindBy(id="0")
	private WebElement product1Count;
	@FindBy(how=How.XPATH, xpath="/html/body/div[2]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[1]/strong")
	private WebElement shippingInfo;
	@FindBy(id="stripeButton")
	private WebElement stripeButton;
	
	
	public PayPage(WebDriver driver) {
		super(driver);
	}

	public void emptyCart() {
		emptyCartButton.click();
	}

	public void existingLoginButtonClic() {
		this.existingLoginButton.click();
	}

	public int getProduct1Count() {
		return Integer.parseInt(product1Count.getAttribute("value"));
	}

	public String getShippingInfo() {
		return shippingInfo.getText();
	}

	public void increaseProduct1Count() {
		increaseProduct1CountButton.click();
	}

	public void newUserCreateAccountButtonClic() {
		this.newUserCreateAccountButton.click();
	}

	public void setExistingLoginEmail(String toInsert) {
		this.existingLoginEmail.sendKeys(toInsert);
	}

	public void setExistingLoginPassword(String toInsert) {
		this.existingLoginPassword.sendKeys(toInsert);
	}

	public void setNewUserAddr1(String toInsert) {
		this.newUserAddr1.sendKeys(toInsert);
	}

	public void setNewUserAddr2(String toInsert) {
		this.newUserAddr2.sendKeys(toInsert);
	}

	public void setNewUserCountry(String toInsert) {
		this.newUserCountry.sendKeys(toInsert);
	}

	public void setNewUserEmail(String toInsert) {
		this.newUserEmail.sendKeys(toInsert);
	}

	public void setNewUserFirstName(String toInsert) {
		this.newUserFirstName.sendKeys(toInsert);
	}

	public void setNewUserLastName(String toInsert) {
		this.newUserLastName.sendKeys(toInsert);
	}
	
	public void setNewUserPassword(String toInsert) {
		this.newUserPassword.sendKeys(toInsert);
	}
	
	public void setNewUserPhone(String toInsert) {
		this.newUserPhone.sendKeys(toInsert);
	}

	public void setNewUserPostCode(String toInsert) {
		this.newUserPostCode.sendKeys(toInsert);
	}

	public void setNewUserState(String toInsert) {
		this.newUserState.sendKeys(toInsert);
	}

	public StripePage StripeButton() {
		this.stripeButton.click();
		return new StripePage(driver);
	}
}