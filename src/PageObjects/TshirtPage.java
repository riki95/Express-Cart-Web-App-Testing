package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TshirtPage extends PageObject{
	
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div[1]/div[1]/h4/strong")
	private WebElement searchResult;

	public TshirtPage(WebDriver driver) {
		super(driver);
	}

	public String getSearchResult() {
		return searchResult.getText();
	}
}
