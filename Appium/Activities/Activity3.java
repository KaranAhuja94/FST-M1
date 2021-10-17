package activities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	
	AppiumDriver<AndroidElement> driver = null;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceID", "emulator-5554");
		capabilities.setCapability("deviceName", "Pixel3Emulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<AndroidElement>(url,capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void add() {
	
		driver.findElementById("digit_5").click();
		driver.findElementByAccessibilityId("plus").click();
		driver.findElementById("digit_9").click();
		driver.findElementByXPath("//android.widget.Button[@text='=']").click();
		String result = driver.findElementById("result").getText();
		System.out.println("Addition: " + result);
		driver.findElementById("clr").click();
		
		Assert.assertEquals(result, "14");
	}
	
	@Test
	public void subtract() {
	
		driver.findElementById("digit_1").click();
		driver.findElementById("digit_0").click();
		driver.findElementByAccessibilityId("minus").click();
		driver.findElementById("digit_5").click();
		driver.findElementByXPath("//android.widget.Button[@text='=']").click();
		String result = driver.findElementById("result").getText();
		System.out.println("Subtraction: " + result);
		driver.findElementById("clr").click();
		
		Assert.assertEquals(result, "5");
	}
	
	@Test
	public void multiply() {
	
		driver.findElementById("digit_5").click();
		driver.findElementByAccessibilityId("multiply").click();
		driver.findElementById("digit_1").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("digit_0").click();
		driver.findElementByXPath("//android.widget.Button[@text='=']").click();
		String result = driver.findElementById("result").getText();
		System.out.println("Multiplication: " + result);
		driver.findElementById("clr").click();
		
		Assert.assertEquals(result, "500");
	}
	
	@Test
	public void division() {
	
		driver.findElementById("digit_5").click();
		driver.findElementById("digit_0").click();
		driver.findElementByAccessibilityId("divide").click();
		driver.findElementById("digit_2").click();		
		driver.findElementByXPath("//android.widget.Button[@text='=']").click();
		String result = driver.findElementById("result").getText();
		System.out.println("Division: " + result);
		driver.findElementById("clr").click();
		
		Assert.assertEquals(result, "25");
	}
  

	@AfterClass
	public void afterClass() {
		
		driver.quit();
		
	}

}
