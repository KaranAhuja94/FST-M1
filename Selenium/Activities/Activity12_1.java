package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_1 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/iframes");
		System.out.println("Page title: " + driver.getTitle());
		
		driver.switchTo().frame(0);
		System.out.println("Frame 1 heading: " + driver.findElement(By.xpath("//div[starts-with(@class,'activity')]/div/div/div[@class='content']")).getText());
		
		WebElement button1 = driver.findElement(By.xpath("//button[contains(@class,'red')]"));
		System.out.println("Button text: " + button1.getText());
		System.out.println("Button color: " + button1.getCssValue("color"));
		button1.click();
		
		WebElement button2 = driver.findElement(By.xpath("//button[contains(@class,'blue')]"));
		System.out.println("New button text: " + button2.getText());
		System.out.println("New button color: " + button2.getCssValue("color"));
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		System.out.println("Frame 2 heading: " + driver.findElement(By.xpath("//div[starts-with(@class,'activity')]/div/div/div[@class='content']")).getText());
		
		WebElement button3 = driver.findElement(By.xpath("//button[contains(@class,'green')]"));
		System.out.println("Button text: " + button3.getText());
		System.out.println("Button color: " + button3.getCssValue("color"));
		button3.click();
		
		WebElement button4 = driver.findElement(By.xpath("//button[contains(@class,'purple')]"));
		System.out.println("New button text: " + button4.getText());
		System.out.println("New button color: " + button4.getCssValue("color"));
		
		driver.close();
	}

}
