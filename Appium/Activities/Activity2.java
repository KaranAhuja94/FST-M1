package activities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceId", "emulator-5554");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("deviceName", "Pixel3Emulator");
		capabilities.setCapability("appPackage", "com.android.chrome");
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, capabilities);
		
		wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void webAppTest() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.training-support.net/");
		String title = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
		
		/*MobileElement text = driver.findElementByXPath("//android.view.View[@text='Training Support']");
		wait.until(ExpectedConditions.visibilityOf(text));
		String title = text.getText();*/
		
		System.out.println("Page Title: " + title);
		driver.findElementById("about-link").click();
		String newPageTitle = driver.findElementByXPath("//android.view.View[@text='About Us']").getText();
		System.out.println("About Us page title: " + newPageTitle);
		
		Assert.assertEquals(title, "Training Support");
		Assert.assertEquals(newPageTitle, "About Us");
		
	}
  

	@AfterClass
	public void afterClass() {
		
		driver.quit();
		
	}

}
