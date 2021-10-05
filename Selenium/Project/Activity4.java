package projectActivities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyTitleOfSecondCourse() {
		String courseTitle = driver.findElement(By.xpath("//div[@class='ld-course-list-items row']/div[@class='ld_course_grid col-sm-8 col-md-4 '][2]/article/div/h3")).getText();
		assertEquals(courseTitle, "Email Marketing Strategies");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
}
