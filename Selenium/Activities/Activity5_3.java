package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/dynamic-controls");
		System.out.println("Page title: " + driver.getTitle());
		WebElement element = driver.findElement(By.xpath("//input[@id='input-text']"));
		System.out.println(element.isEnabled());
		driver.findElement(By.xpath("//button[@id='toggleInput']")).click();
		System.out.println(element.isEnabled());
		driver.close();
	}
	
}
