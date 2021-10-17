package activities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class Activity1 {
	
	AppiumDriver<MobileElement> driver;
  
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceId", "emulator-5554");
		capabilities.setCapability("deviceName", "Pixel3Emulator");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, capabilities);
	}
	
	
	@Test
	public void testMultiplication() {
		
		driver.findElementById("com.android.calculator2:id/digit_5").click();
		driver.findElementByAccessibilityId("multiply").click();
		driver.findElementByXPath("//android.widget.Button[contains(@text,8)]").click();
		driver.findElementByXPath("//android.widget.Button[@content-desc=\"equals\"]").click();
		
		String result = driver.findElementById("result").getText();
		System.out.println("Result: " + result);
	}
  
  

	@AfterClass
	public void afterClass() {
		
		driver.quit();
		
	}

}
