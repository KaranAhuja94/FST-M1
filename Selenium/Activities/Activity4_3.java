package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
	
	public static void main(String[] args){
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
		System.out.println("Third Header: " + driver.findElement(By.xpath("//h3[@id='third-header']")).getText());
		System.out.println("Fifth Header color: " + driver.findElement(By.xpath("//h5[contains(text(),'Fifth')]")).getCssValue("color"));
		System.out.println("Violet button: " + driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class"));
		System.out.println("Gray Button with absolute xpath: " + driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/button[2]")).getText());

		driver.close();
	}	
}
