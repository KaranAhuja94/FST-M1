package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println("Page title: " + driver.getTitle());
		WebElement checkbox = driver.findElement(By.xpath("//input[@name='toggled']"));
		WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
		button.click();
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		button.click();
		wait.until(ExpectedConditions.visibilityOf(checkbox)).click();
		driver.close();
	}

}
