package Tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import AuxClasses.Money;
import Driver.DriverLifeCycleSetting;
import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.NikePage;
import PageObjects.SingleProductPage;

public class CartPageTest extends DriverLifeCycleSetting{

	@BeforeClass
	public static void initialize() {
		driver.get("http://localhost:1111/");
	}
	
	@Test
	public void addProductFromSingleProductPageCorrectlyAddToCart() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		
		NikePage nikePage = homePage.nikePageButton();
		Thread.sleep(1000);
		
		SingleProductPage product2Page = nikePage.product2Clic();
		product2Page.addToCart();
		
		CartPage cart = product2Page.cart();
		Thread.sleep(1000);
		
		String productName = cart.getProduct1Name();
		cart.closeCart();
		Thread.sleep(1000);
		
		assertEquals("Nike Hoodie", productName);
	}
	
	@Test
	public void decreaseProductNumberCorrectlyChangesCount() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		cartPage.increaseProduct1Number();
		Thread.sleep(1000);
		cartPage.decreaseProduct1Number();
		Thread.sleep(1000);
		int count = cartPage.getProduct1Count();
		cartPage.closeCart();
		Thread.sleep(1000);

		assertEquals(1, count);
	}
	
	@Test
	public void differentProductsSumNoShippingIsCorrect() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		homePage.addProduct3ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		String price1 = cartPage.getProduct1Price();
		String price2 = cartPage.getProduct2Price();
		Money sumPrices = new Money(Integer.parseInt(price1))
				.add(new Money(Integer.parseInt(price2)));
		cartPage.closeCart();
		Thread.sleep(1000);
		
		assertEquals(9600, sumPrices.get());
	}
	
	@Test
	public void differentProductsSumPlusShippingIsCorrect() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.nikePageButton();
		homePage.addProduct1ToCart();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		String price1 = cartPage.getProduct1Price();
		String price2 = cartPage.getProduct2Price();
		Money shipping = new Money(1000);
		Money sumPrices = new Money(Integer.parseInt(price1))
				.add(new Money(Integer.parseInt(price2)))
				.add(shipping);
		cartPage.closeCart();
		Thread.sleep(1000);
		
		assertEquals(10600, sumPrices.get());
	}
	
	@Test
	public void emptyCartSuccess() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		cartPage.emptyCart();
		Thread.sleep(1000);
		cartPage.closeCart();
		Thread.sleep(1000);
		
		assertEquals(0, homePage.getCartCount());
	}
	
	@Test
	public void increaseProductNumberCorrectlyChangesCount() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		cartPage.increaseProduct1Number();
		Thread.sleep(1000);
		int count = cartPage.getProduct1Count();
		cartPage.closeCart();
		Thread.sleep(1000);

		assertEquals(2, count);
	}
	
	@Test
	public void productPricePlusShippingIsCorrect() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		String price = cartPage.getProduct1Price();
		Money shipping = new Money(1000);
		Money money = new Money(Integer.parseInt(price)).add(shipping);
		Money total = cartPage.getTotalPrice();
		cartPage.closeCart();
		Thread.sleep(1000);
		
		assertEquals(money.get(), total.get());
	}
	
	@Test
	public void productSumOver100WillShipFree() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		cartPage.increaseProduct1Number();
		Thread.sleep(1000);
		cartPage.increaseProduct1Number();
		Thread.sleep(1000);
		String price = cartPage.getShippingPrice();
		cartPage.closeCart();
		Thread.sleep(1000);
		
		assertEquals("FREE", price);
	}
}

/*
 * Controllare se il carrello è già vuoto
 */