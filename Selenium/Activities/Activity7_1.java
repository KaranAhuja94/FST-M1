package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_1 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		System.out.println("Page title: " + driver.getTitle());
		driver.findElement(By.xpath("//input[starts-with(@class,'username')]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[starts-with(@class,'password')]")).sendKeys("password");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		System.out.println("Login message: " + driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText());
		driver.close();
	}
	
}
