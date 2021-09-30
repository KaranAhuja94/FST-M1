package activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
	}
	
	@Test
	public void test() throws InterruptedException {
		String title = driver.getTitle();
		Reporter.log("Getting page title");
		System.out.println("Title: " + title);
		Reporter.log("Printing page title");
		assertEquals(title, "Training Support");
		Reporter.log("Asserting values");
		driver.findElement(By.xpath("//div/div/a[@id='about-link']")).click();
		Reporter.log("Clicking button");
		String newTitle = driver.getTitle();
		Reporter.log("Getting page title");
		System.out.println("Title: " + newTitle);
		Reporter.log("Printing page title");
		assertEquals(newTitle, "About Training Support");
		Reporter.log("Asserting values");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
	
}
