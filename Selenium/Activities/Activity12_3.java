package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12_3 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		Actions action = new Actions(driver);
		
		driver.get("https://www.training-support.net/selenium/popups");
		System.out.println("Page title: " + driver.getTitle());
		
		WebElement button = driver.findElement(By.xpath("//button[contains(@class,'orange')]"));
		action.moveToElement(button).pause(Duration.ofSeconds(1)).build().perform();
		String text = button.getAttribute("data-tooltip");
		System.out.println("Tooltip text: " + text);
		
		button.click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
		driver.findElement(By.xpath("//div[contains(@class,'form')]/button[contains(text(),'Log')]")).click();
		System.out.println("Page heading: " + driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText());
		
		driver.close();
	} 

}
