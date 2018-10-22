package Driver;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverLifeCycleSetting {
	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/riccardo/Desktop/chromedriver");
		driver = new ChromeDriver(); // Create a new instance of the Chrome driver
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After 
	public void cleanUp(){
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass 
	public static void tearDown(){
		driver.close();
	}
}