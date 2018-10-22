package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SuccessPaymentPage extends PageObject{
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div/div/div/a")
	private WebElement homeButton;
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div/div/div/h2")
	private WebElement paymentSuccessfulText;

	public SuccessPaymentPage(WebDriver driver) {
		super(driver);
	}

	public String getPaymentSuccessfulText() {
		return paymentSuccessfulText.getText();
	}
	
	public HomePage homePageClic() {
		homeButton.click();
		return new HomePage(driver);
	}
}