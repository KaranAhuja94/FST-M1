package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is on Google Home Page$")
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 20);
		driver.get("https://www.google.com/");
	}
	
	@When("^User types in Cheese and hits ENTER$")
	public void search() {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Cheese",Keys.RETURN);
	}
	
	@Then("^Show hom many search results were shown$")
	public void displaySearchResults() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='result-stats']")));
		System.out.println("Total results displayed: " + driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
	}
	
	@And("^Close the browser$")
	public void close() {
		driver.close();
	}
	
}
