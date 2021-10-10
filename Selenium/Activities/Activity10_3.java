package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_3 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		Actions actions = new Actions(driver);
		
		driver.get("https://training-support.net/selenium/drag-drop");
		System.out.println("Page title: " + driver.getTitle());
		
		WebElement draggable = driver.findElement(By.xpath("//div/img[@id='draggable']"));
		WebElement dropzone1 = driver.findElement(By.xpath("//div[@id='droppable']"));
		WebElement dropzone2 = driver.findElement(By.xpath("//div[@id='dropzone2']"));
		
		actions.dragAndDrop(draggable, dropzone1).build().perform();
		if(driver.findElement(By.xpath("//div[@style='background-color: rgb(33, 186, 69);']")) != null)
			System.out.println("Ball has entered: " + dropzone1.getText());
		
		actions.dragAndDrop(dropzone1, dropzone2).build().perform();
		if(driver.findElement(By.xpath("//div[@style='background-color: rgb(33, 186, 69);']")) != null)
			System.out.println("Ball has entered: " + dropzone2.getText());
		
		driver.close();
	}
	
}
