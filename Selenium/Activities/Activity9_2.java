package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_2 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");
		Select multiSelect = new Select(driver.findElement(By.xpath("//select[@id='multi-select']")));
		WebElement selectedValues = driver.findElement(By.xpath("//h3[@id='multi-value']"));
		
		if(multiSelect.isMultiple()) {
			
			multiSelect.selectByVisibleText("Javascript");
			System.out.println(selectedValues.getText());
			
			multiSelect.selectByValue("node");
			System.out.println(selectedValues.getText());
			
			multiSelect.selectByIndex(4);
			multiSelect.selectByIndex(5);
			multiSelect.selectByIndex(6);
			System.out.println(selectedValues.getText());
			
			multiSelect.deselectByValue("node");
			System.out.println(selectedValues.getText());
			
			multiSelect.deselectByIndex(7);
			System.out.println(selectedValues.getText());
			
			System.out.println("Multi-select values:");
			List<WebElement> values = multiSelect.getOptions();
			for (WebElement value : values) {
				System.out.println(value.getText());
			}
			
			multiSelect.deselectAll();
			System.out.println(selectedValues.getText());
		}
		
		driver.close();
	}

}
