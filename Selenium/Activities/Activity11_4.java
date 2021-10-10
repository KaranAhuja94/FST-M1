package activities;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_4 {
	
	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		driver.get("https://www.training-support.net/selenium/tab-opener");
		System.out.println("Page title: " + driver.getTitle());
		System.out.println("Window handle: " + driver.getWindowHandle());
		
		driver.findElement(By.xpath("//a[@id='launcher']")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
		}
		
		System.out.println("Page title: " + driver.getTitle());
		
		wait.until(ExpectedConditions.titleIs("Newtab"));
		
		//Thread.sleep(1000);
		
		WebElement text = driver.findElement(By.xpath("//div[contains(text(),'New')]"));
		wait.until(ExpectedConditions.visibilityOf(text));
		System.out.println(text.getText());
		
		driver.findElement(By.xpath("//a[@id='actionButton']")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		
		windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
		}
		
		System.out.println("Page title: " + driver.getTitle());
		
		wait.until(ExpectedConditions.titleIs("Newtab2"));
		
		System.out.println(driver.findElement(By.xpath("//div[@class='content']")).getText());
	}
}
