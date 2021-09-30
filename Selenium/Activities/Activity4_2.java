package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/simple-form");
		System.out.println("Title: " + driver.getTitle());
		driver.findElement(By.xpath("//div/div/input[@id='firstName']")).sendKeys("John");
		driver.findElement(By.xpath("//div/div/input[@id='lastName']")).sendKeys("Doe");
		driver.findElement(By.xpath("//div/div/input[@id='email']")).sendKeys("johndoe@example.com");
		driver.findElement(By.xpath("//div/div/input[@id='number']")).sendKeys("8787985000");
		driver.findElement(By.xpath("//div/div/textarea")).sendKeys("Message!!!");
		driver.findElement(By.xpath("//div/div/input[@value='submit']")).click();
		
		driver.quit();
	}
	
}
