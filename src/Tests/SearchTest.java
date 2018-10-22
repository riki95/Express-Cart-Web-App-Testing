package Tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import Driver.DriverLifeCycleSetting;
import PageObjects.HomePage;
import PageObjects.NikePage;
import PageObjects.SearchDonePage;
import PageObjects.TshirtPage;

public class SearchTest extends DriverLifeCycleSetting{
	@BeforeClass
	public static void initialize() {
		driver.get("http://localhost:1111/");
	}

	/*Test using XPath Locator for Search*/
	@Test
	public void searchWrongNameReturnsNoProductFound() {
		HomePage homePage = new HomePage(driver);
		homePage.enterSearch("abc");
		
		SearchDonePage searchDone = homePage.search();
		
		assertEquals("No products found", searchDone.getNoProductsFound());
	}
	
	@Test
	public void searchVansReturnVansOldSkool() {
		HomePage homePage = new HomePage(driver);
		homePage.enterSearch("vans");
		
		SearchDonePage searchDone = homePage.search();
		
		assertEquals("Vans Old Skool", searchDone.getVansProductH3());
	}
	
	/*Test using TotalProductCount variable*/
	
	@Test
	public void searchVansReturn1Result() {
		HomePage homePage = new HomePage(driver);
		homePage.enterSearch("vans");
		
		SearchDonePage searchDone = homePage.search();
		
		assertEquals(1, searchDone.getProductCount());
	}

	@Test
	public void searchWrongNameReturnsProductCount0() {
		HomePage homePage = new HomePage(driver);
		homePage.enterSearch("abc");
		
		SearchDonePage searchDone = homePage.search();
		
		assertEquals(0, searchDone.getProductCount());
	}
	
	@Test
	public void searchNikeReturnSomeProducts() {
		HomePage homePage = new HomePage(driver);
		homePage.enterSearch("nike");
		
		SearchDonePage searchDone = homePage.search();
		
		assertTrue(searchDone.getProductCount() > 0);
	} 
	
	@Test
	public void searchedPageIsNikeOk() {
		HomePage homePage = new HomePage(driver);
		
		NikePage nikePage = homePage.nikePageButton();
		
		assertEquals("nike", nikePage.getSearchResult());
	}
	
	@Test
	public void searchedPageIsTshirtOk() {
		HomePage homePage = new HomePage(driver);
		
		TshirtPage tshisrtPage = homePage.TshirtPageButton();
		
		assertEquals("tshirt", tshisrtPage.getSearchResult());
	}
}