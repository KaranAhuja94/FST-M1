package activities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity4 {
	
	WebDriverWait wait;
	AppiumDriver<AndroidElement> driver = null;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
	  
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceId", "emulator-5554");
		capabilities.setCapability("deviceName", "Pixel3Emulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity", ".activities.PeopleActivity");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<AndroidElement>(url,capabilities);
		
		wait = new WebDriverWait(driver, 20);
	}
  
	@Test
	public void addContact() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElementById("add_contact_button").click();
		driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Aaditya");
		driver.findElementByXPath("//android.widget.EditText[@text='Last name']").sendKeys("Varma");
		driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("9991284782");
		driver.findElementByXPath("//android.widget.Button[@text='SAVE']").click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.android.contacts:id/action_bar_gradient")));
		
		String contactName = driver.findElementById("title_gradient").getText();
		System.out.println("Contact Name: " + contactName);
		
		Assert.assertEquals(contactName, "Aaditya Verma");
	}

	@AfterClass
	public void afterClass() {
		
		driver.quit();
		
	}

}
