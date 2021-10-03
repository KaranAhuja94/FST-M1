package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_2 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		System.out.println("Page title: " + driver.getTitle());
		driver.findElement(By.xpath("//input[contains(@class,'-username')]")).sendKeys("Adam");
		driver.findElement(By.xpath("//input[contains(@class,'-password')]")).sendKeys("password");
		driver.findElement(By.xpath("//label[text()='Confirm Password']/following::input[@type='password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[starts-with(@class,'email-')]")).sendKeys("adam14@example.com");
		driver.findElement(By.xpath("//button[contains(text(),'Sign')]")).click();
		System.out.println("Sign up message: " + driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText());
		driver.close();
	}
	

}
