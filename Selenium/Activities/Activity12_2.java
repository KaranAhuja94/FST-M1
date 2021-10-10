package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_2 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/nested-iframes");
		System.out.println("Page title: " + driver.getTitle());
		
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		
		System.out.println("Frame1 Heading: " + driver.findElement(By.xpath("//div[starts-with(@class,'activity')]/div/div/div[contains(text(),'Frame 1')]")).getText());
		
		//System.out.println(driver.findElement(By.cssSelector("div.content")).getText());
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);
		
		System.out.println("Frame2 Heading: " + driver.findElement(By.xpath("//div[starts-with(@class,'activity')]/div/div/div[contains(text(),'Frame 2')]")).getText());
		
		driver.close();
	}
}
