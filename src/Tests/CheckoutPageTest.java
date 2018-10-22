package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import Driver.DriverLifeCycleSetting;
import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.HomePage;

public class CheckoutPageTest extends DriverLifeCycleSetting{
	@BeforeClass
	public static void initialize() {
		driver.get("http://localhost:1111/");
	}
	
	@Test
	public void emptyCartSuccess() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		
		CheckoutPage checkoutPage = cartPage.checkout();
		Thread.sleep(1000);
		checkoutPage.emptyCart();
		Thread.sleep(1000);
		
		assertEquals("Cart empty", checkoutPage.getEmptyCartMessage());
	}
	
	@Test
	public void increaseProductNumberCorrectlyChangesCount() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		
		CheckoutPage checkoutPage = cartPage.checkout();
		Thread.sleep(1000);
		checkoutPage.IncreaseNumberButton();
		Thread.sleep(1000);
		
		assertEquals(2, checkoutPage.getProduct1Count());
	}
}
