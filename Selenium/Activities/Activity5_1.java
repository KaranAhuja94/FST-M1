package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/dynamic-controls");
		System.out.println("Page title: " + driver.getTitle());
		WebElement element = driver.findElement(By.xpath("//input[@name='toggled']"));
		System.out.println(element.isDisplayed());
		driver.findElement(By.xpath("//button[@id='toggleCheckbox']")).click();
		/*boolean existsAgain = driver.findElement(By.xpath("//input[@name='toggled']")).isDisplayed();
		System.out.println(existsAgain);*/
		System.out.println(element.isDisplayed());
		driver.close();
	}

}
