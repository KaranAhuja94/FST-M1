package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_1 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/tables");
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[1]/td"));
		System.out.println("Number of rows: " + rows.size());
		System.out.println("Number of columns: " + columns.size());
		WebElement element = driver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody/tr[3]"));
		System.out.println("Third row data: " + element.getText());
		System.out.println("Second row second column data: " + driver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody/tr[2]/td[2]")).getText());
		driver.close();
	}

}
