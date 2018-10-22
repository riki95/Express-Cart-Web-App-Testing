package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends PageObject {
	@FindBy(how=How.XPATH, xpath="/html/body/nav/div/div[2]/ul/li[1]/a")
	private WebElement cartButton;
	@FindBy(id="cart-count")
	private WebElement cartCount;
	@FindBy(how=How.XPATH, xpath="/html/body/nav/div/div[1]/a")
	private WebElement homePageButton;
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/nav/div/div/ul/li[3]/a")
	private WebElement nikePageButton;
	@FindBy(id="notify_message")
	private WebElement notifyMessage;
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div[2]/div/ul/li[3]/a")
	private WebElement page2Button;
	@FindBy(id="pageNum")
	private WebElement pageNumber;
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div[1]/div/div[1]/div/p/a")
	private WebElement product1Add;
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div[1]/div/div[2]/div/p/a")
	private WebElement product2Add;
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div[1]/div/div[3]/div/p/a")
	private WebElement product3Add;
	@FindBy(id="btn_search")
	private WebElement searchButton;
	@FindBy(id="frm_search")
	private WebElement searchInput;
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/nav/div/div/ul/li[2]/a")
	private WebElement tshirtPageButton;
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div[1]/div/div[1]/div/div/a/div/img")
	private WebElement product1Page;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void addProduct1ToCart() {
		product1Add.click();
	}
	
	public void addProduct2ToCart() {
		product2Add.click();
	}
	
	public void addProduct3ToCart() {
		product3Add.click();
	}
	
	public CartPage cart() {
		cartButton.click();
		return new CartPage(driver);
	}
	
	public void enterSearch(String toSearch) {
		this.searchInput.clear();
		this.searchInput.sendKeys(toSearch);
	}
	
	public int getCartCount() {
 		return Integer.parseInt(cartCount.getText());
 	}
	
	public String getNotifyMessage() {
		return notifyMessage.getText();
	}
	
	public int getPageNumber() {
		return Integer.parseInt(pageNumber.getAttribute("value"));
	}
	
	public void goToPage2() {
		page2Button.click();
	}

	public NikePage nikePageButton() {
		nikePageButton.click();
		return new NikePage(driver);
	}
	
	public HomePage returnToHomePage(){
		homePageButton.click();
		return new HomePage(driver);
	}
	
	public SearchDonePage search(){
		this.searchButton.click();
		return new SearchDonePage(driver);
	}

	public TshirtPage TshirtPageButton() {
		tshirtPageButton.click();
		return new TshirtPage(driver);
	}
	
	public SingleProductPage openProduct1Page() {
		product1Page.click();
		return new SingleProductPage(driver);
	}
}