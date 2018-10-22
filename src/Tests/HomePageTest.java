package Tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Driver.DriverLifeCycleSetting;
import PageObjects.HomePage;

public class HomePageTest extends DriverLifeCycleSetting{
	@BeforeClass
	public static void initialize() {
		driver.get("http://localhost:1111/");
	}
	
	@Test
	public void addToCartSuccess() {
		HomePage homePage = new HomePage(driver);
		homePage.addProduct1ToCart();
		
		assertEquals("Cart successfully updated", homePage.getNotifyMessage());
	}
	
	@Test
	public void changeToPage2Success() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.goToPage2();
		Thread.sleep(1000);
		
		assertEquals(2, homePage.getPageNumber());
	}
}
