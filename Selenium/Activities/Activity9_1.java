package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_1 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='single-select']")));
		WebElement chosenValue = driver.findElement(By.xpath("//h3[@id='single-value']"));
		dropdown.selectByVisibleText("Option 2");
		System.out.println("Second Option: " + chosenValue.getText());
		dropdown.deselectByIndex(3);
		System.out.println("Third Option: " + chosenValue.getText());
		dropdown.selectByValue("Option 4");
		System.out.println("Fourth Option: " + chosenValue.getText());
		
		System.out.println("Dropdown values:");
		List<WebElement> values = dropdown.getOptions();
		for (WebElement value : values) {
			System.out.println(value.getText());
		}
		
		driver.close();
	}
	
}
