package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		Actions actions = new Actions(driver);
		Actions actions1 = new Actions(driver);
		
		driver.get("https://www.training-support.net/selenium/input-events");
		System.out.println("Page title: " + driver.getTitle());
		String keyText;
		WebElement text = driver.findElement(By.id("keyPressed"));
		
		actions.sendKeys("K").build().perform();
		keyText = text.getText();
		System.out.println("Key pressed: " + keyText);
		
		actions1.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		keyText = text.getText();
		System.out.println("Key pressed: " + keyText);
		
		driver.close();
		
	}
	
}
