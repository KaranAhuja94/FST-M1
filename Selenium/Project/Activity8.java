package projectActivities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,20);
		driver.get("https://alchemy.hguy.co/lms/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void contactAdmin() {
		driver.findElement(By.xpath("//a[text()='Contact']")).click();
		driver.findElement(By.xpath("//input[@id='wpforms-8-field_0']")).sendKeys("Karan Ahuja");
		driver.findElement(By.xpath("//input[@id='wpforms-8-field_1']")).sendKeys("ahujakaranv@gmail.com");
		driver.findElement(By.xpath("//input[@id='wpforms-8-field_3']")).sendKeys("Project");
		driver.findElement(By.xpath("//textarea[@id='wpforms-8-field_2']")).sendKeys("Project Completed");
		driver.findElement(By.xpath("//button[text()='Send Message']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Thanks for contacting')]")));
		String text = driver.findElement(By.xpath("//p[contains(text(),'Thanks for contacting')]")).getText();
		assertEquals(text, "Thanks for contacting us! We will be in touch with you shortly.");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
}
