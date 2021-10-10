package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		Actions actions = new Actions(driver);
		
		driver.get("https://www.training-support.net/selenium/input-events");
		System.out.println("Page title: " + driver.getTitle());
		
		WebElement element = driver.findElement(By.id("D3Cube"));
		
		actions.click(element).perform();
		WebElement side = driver.findElement(By.xpath("//div[@class='active']/h1"));
		System.out.println("Left click: " + side.getText());
		
		actions.doubleClick(element).perform();
		side = driver.findElement(By.xpath("//div[@class='active']/h1"));
		System.out.println("Double click: " + side.getText());
		
		actions.contextClick(element).perform();
		side = driver.findElement(By.xpath("//div[@class='active']/h1"));
		System.out.println("Right click: " + side.getText());
		
		driver.close();
	}
	
}
