package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StripePage extends PageObject{
	@FindBy(how=How.XPATH, xpath="//*[@placeholder='Numero carta']")
	private WebElement cardStripe;
	@FindBy(how=How.XPATH, xpath="//*[@placeholder='CVC']")
	private WebElement cvcStripe;
	@FindBy(how=How.XPATH, xpath="//*[@placeholder='MM / AA']")
	private WebElement dateStripe;
	@FindBy(how=How.XPATH, xpath="//*[@placeholder='Email']")
	private WebElement emailStripe;
	@FindBy(how=How.XPATH, xpath="//button[@type='submit']")
	private WebElement submitButton;
	

	public StripePage(WebDriver driver) {
		super(driver);
	}

	public SuccessPaymentPage confirm() {
		submitButton.click();
		return new SuccessPaymentPage(driver);
	}

	public void setCardStripe(String toInsert) {
		this.cardStripe.sendKeys(toInsert);
	}

	public void setCvcStripe(String toInsert) {
		this.cvcStripe.sendKeys(toInsert);
	}

	public void setDateStripe(String toInsert) {
		this.dateStripe.sendKeys(toInsert);
	}
	
	public void setEmailStripe(String toInsert) {
		emailStripe.sendKeys(toInsert);
	}
}