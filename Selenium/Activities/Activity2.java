package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		System.out.println(driver.getTitle());
		WebElement id = driver.findElement(By.id("about-link"));
		System.out.println(id.getText());
		//className is not working for this hence used xpath
		WebElement className = driver.findElement(By.xpath("//a[@class='ui inverted huge green button']"));
		System.out.println(className.getText());
		WebElement linkText = driver.findElement(By.linkText("About Us"));
		System.out.println(linkText.getText());
		WebElement selector = driver.findElement(By.cssSelector("a#about-link"));
		System.out.println(selector.getText());
	}

}
