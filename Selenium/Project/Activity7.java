package projectActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void countCourses() {
		driver.findElement(By.xpath("//a[text()='All Courses']")).click();
		List<WebElement> courseCount = driver.findElements(By.xpath("//div[starts-with(@class,'ld-course-list-items')]/div"));
		System.out.println("Number of courses: " + courseCount.size());
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}

}
