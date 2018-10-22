package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchDonePage extends PageObject{
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div[1]/div[2]/div/p")
	private WebElement noProductsFoundPath;
	@FindBy(id="totalProductCount")
	private WebElement productCount;
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div[1]/div[2]/div/div/div/a/h3")
	private WebElement productVansH3search;

	
 	public SearchDonePage(WebDriver driver) {
		super(driver);
	}
 	
 	public String getNoProductsFound() {
		return noProductsFoundPath.getText();
	}
	
	public int getProductCount() {
 		return Integer.parseInt(productCount.getAttribute("value"));
 	}
	
	public String getVansProductH3() {
		return productVansH3search.getText();
	}
}
