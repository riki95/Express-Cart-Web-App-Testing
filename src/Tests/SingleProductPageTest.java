package Tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Driver.DriverLifeCycleSetting;
import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.SingleProductPage;

public class SingleProductPageTest extends DriverLifeCycleSetting{
	
	@BeforeClass
	public static void initialize() {
		driver.get("http://localhost:1111/");
	}

	@Test
	public void increaseProductButtonWorks() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		
		SingleProductPage singleProductPage = homePage.openProduct1Page();
		Thread.sleep(500);
		
		singleProductPage.increaseProductCount();
		assertEquals(2, singleProductPage.getProductCount());
	}
	
	@Test
	public void decreaseProductButtonWorks() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		
		SingleProductPage singleProductPage = homePage.openProduct1Page();
		Thread.sleep(500);
		
		singleProductPage.increaseProductCount();
		singleProductPage.decreaseProductCount();
		assertEquals(1, singleProductPage.getProductCount());
	}
	
	@Test
	public void addProductWithSize40ToCart() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		
		SingleProductPage singleProductPage = homePage.openProduct1Page();
		Thread.sleep(500);
		
		singleProductPage.selectSize40();
		singleProductPage.addToCart();
		
		CartPage cartPage = singleProductPage.cart();
		Thread.sleep(1000);
		
		String size = cartPage.getSize().trim();
		cartPage.closeCart();
		Thread.sleep(1000);
		
		assertEquals("40", size);
	}

}
