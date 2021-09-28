package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/simple-form");
		
		System.out.println("Title: " + driver.getTitle());
		
		driver.findElement(By.id("firstName")).sendKeys("John");
		Thread.sleep(1000);
		
		driver.findElement(By.id("lastName")).sendKeys("Doe");
		Thread.sleep(1000);
		
		driver.findElement(By.id("email")).sendKeys("johndoe@gmail.com");
		Thread.sleep(1000);
		
		driver.findElement(By.id("number")).sendKeys("9988775870");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div/div/input[@type='submit']")).click();
		Thread.sleep(1000);
		
		driver.close();
	}

}
