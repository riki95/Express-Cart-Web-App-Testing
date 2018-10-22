package Tests;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import Driver.DriverLifeCycleSetting;
import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.HomePage;
import PageObjects.PayPage;
import PageObjects.StripePage;
import PageObjects.SuccessPaymentPage;

public class PayPageTest extends DriverLifeCycleSetting{
	@BeforeClass
	public static void initialize() throws InterruptedException {
		driver.get("http://localhost:1111/");
		HomePage homePage = new HomePage(driver);
		homePage.addProduct2ToCart();
		driver.get("http://localhost:1111/pay");
		PayPage payPage = new PayPage(driver);
		Thread.sleep(500);
		createNewUser(payPage, "riki-95@hotmail.it");
		Thread.sleep(500);
		payPage.newUserCreateAccountButtonClic();
	}
	
	//Can create different users for tests, but country-sate-code etc. remains the same
	public static void createNewUser(PayPage payPage, String email) {
		payPage.setNewUserFirstName("nomePersona");
		payPage.setNewUserLastName("cognomePersona");
		payPage.setNewUserPassword("passwordPersona");
		payPage.setNewUserEmail(email);
		payPage.setNewUserAddr1("Via di prova 5");
		payPage.setNewUserCountry("Genova");
		payPage.setNewUserPhone("33535454567");
		payPage.setNewUserPostCode("11873");
		payPage.setNewUserState("Italia");
	}
	
	private void stripeFillForm(StripePage stripePage) {
		stripePage.setEmailStripe("mailDiStripe@mail.it");
		stripePage.setCardStripe("4242424242424242");
		stripePage.setDateStripe("122022");
		stripePage.setCvcStripe("111");
	}
	
	@Test
	public void cannotCreateCustomerThatAlreadyExist() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		
		CheckoutPage checkoutPage = cartPage.checkout();
		
		PayPage payPage = checkoutPage.payNow();
		Thread.sleep(1000);
		createNewUser(payPage, "riki-95@hotmail.it");
		payPage.newUserCreateAccountButtonClic();
		Thread.sleep(1000);
		
		assertEquals("A customer already exists with that email address", 
				homePage.getNotifyMessage());
	}
	
	@Test
	public void createNewUserAndPayCorrect() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		
		CheckoutPage checkoutPage = cartPage.checkout();
		
		PayPage payPage = checkoutPage.payNow();
		Thread.sleep(1000);
		createNewUser(payPage,Integer.toString(new Random().nextInt(500))+"@prova.it");
		payPage.newUserCreateAccountButtonClic();
		Thread.sleep(2000);
		
		StripePage stripePage = payPage.StripeButton();
		Thread.sleep(2000);
		
		driver.switchTo().frame("stripe_checkout_app");
		stripeFillForm(stripePage);
		Thread.sleep(1000);
		
		SuccessPaymentPage successPage = stripePage.confirm();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		assertEquals("Your payment has been successfully processed", 
				successPage.getPaymentSuccessfulText());
	}
	
	@Test
	public void emptyCartSuccessfull() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		
		CheckoutPage checkoutPage = cartPage.checkout();
		
		PayPage payPage = checkoutPage.payNow();
		Thread.sleep(1000);
		
		payPage.emptyCart();
		Thread.sleep(1000);
		
		assertEquals("Cart successfully emptied", 
				homePage.getNotifyMessage());
	}
	
	@Test
	public void increaseProductNumberCorrectlyChangesCount() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		
		CheckoutPage checkoutPage = cartPage.checkout();
		
		PayPage payPage = checkoutPage.payNow();
		Thread.sleep(1000);
		
		payPage.increaseProduct1Count();
		Thread.sleep(1000);
		
		assertEquals(2, payPage.getProduct1Count());
	}
	
	@Test
	public void loginExistingUserAndPayCorrect() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		
		CheckoutPage checkoutPage = cartPage.checkout();
		
		PayPage payPage = checkoutPage.payNow();
		Thread.sleep(1000);
		payPage.setExistingLoginEmail("riki-95@hotmail.it");
		payPage.setExistingLoginPassword("passwordPersona");
		payPage.existingLoginButtonClic();
		Thread.sleep(2000);
		
		StripePage stripePage = payPage.StripeButton();
		Thread.sleep(2000);
		
		driver.switchTo().frame("stripe_checkout_app");
		stripeFillForm(stripePage);
		Thread.sleep(1000);
		
		SuccessPaymentPage successPage = stripePage.confirm();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		assertEquals("Your payment has been successfully processed", 
				successPage.getPaymentSuccessfulText());
	}
	
	@Test
	public void productSumOver100WillShipFree() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.returnToHomePage();
		homePage.addProduct2ToCart();
		
		CartPage cartPage = homePage.cart();
		Thread.sleep(1000);
		
		CheckoutPage checkoutPage = cartPage.checkout();
		
		PayPage payPage = checkoutPage.payNow();
		Thread.sleep(1000);
		payPage.increaseProduct1Count();
		Thread.sleep(1000);
		payPage.increaseProduct1Count();
		Thread.sleep(1000);
		
		assertEquals("FREE", payPage.getShippingInfo());
	}
}