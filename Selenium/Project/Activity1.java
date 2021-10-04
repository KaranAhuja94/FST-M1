package projectActivities;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyWebsiteTitle() {
		String title = driver.getTitle();
		assertEquals(title, "Alchemy LMS – An LMS Application");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}


}
