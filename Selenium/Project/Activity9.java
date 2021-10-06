package projectActivities;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,20);
		driver.get("https://alchemy.hguy.co/lms/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	public void completeLesson() {
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		driver.findElement(By.xpath("//a[text()='All Courses']")).click();
		driver.findElement(By.xpath("//h3[contains(text(),'Social Media')]/following-sibling::p/a")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Developing')]")).click();
		String pageTitle = driver.getTitle();
		assertEquals(pageTitle, "Developing Strategy – Alchemy LMS");
		
		//Mark complete button not available on page since course was already completed
		
	}
	
	@Test(priority=1)
	public void checkForMarkCompleteButton() {
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		driver.findElement(By.xpath("//a[text()='All Courses']")).click();
		driver.findElement(By.xpath("//h3[contains(text(),'Content')]/following-sibling::p/a")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Analyze')]")).click();
		String pageTitle = driver.getTitle();
		assertEquals(pageTitle, "Analyze Content & Develop Writing Strategies – Alchemy LMS");
		List<WebElement> button = driver.findElements(By.xpath("//input[@class='learndash_mark_complete_button']"));
		for (WebElement webElement : button) {
			webElement.click();
			break;
		}
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
}
