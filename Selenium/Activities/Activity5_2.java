package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/dynamic-controls");
		System.out.println("Page title: " + driver.getTitle());
		WebElement element = driver.findElement(By.xpath("//input[@name='toggled']"));
		System.out.println(element.isSelected());
		element.click();
		System.out.println(element.isSelected());
		driver.close();
	}

}
