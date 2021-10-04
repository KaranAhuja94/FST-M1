package projectActivities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void navigatePage() {
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		String pageTitle = driver.getTitle();
		assertEquals(pageTitle, "My Account – Alchemy LMS");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
}
