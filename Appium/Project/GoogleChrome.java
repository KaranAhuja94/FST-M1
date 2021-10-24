package project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class GoogleChrome {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	  
	@BeforeTest
	public void beforeClass() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceId", "emulator-5554");
		capabilities.setCapability("deviceName", "Pixel4Emulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.chrome");
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,capabilities);
		wait = new WebDriverWait(driver, 100);
	}
  
	@Test
	public void testToDoList() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElementById("com.android.chrome:id/terms_accept").click();
		driver.findElementById("com.android.chrome:id/next_button").click();
		driver.findElementById("com.android.chrome:id/negative_button").click();
		Thread.sleep(2000);
		driver.get("https://www.training-support.net/selenium");
		Thread.sleep(10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
		Thread.sleep(10000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[contains(@text,'To-Do List')]"))).click();
		String textField = "resourceId(\"taskInput\")";
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(textField))).click();
		ArrayList<String> data = new ArrayList<String>();
		data.add("Add tasks to list");
		data.add("Get number of tasks");
		data.add("Clear the list");
		for(int i=0;i<data.size();i++) {
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(textField))).sendKeys(data.get(i));
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[contains(@text,'Add Task')]"))).click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[contains(@text,'Add tasks')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[contains(@text,'Get number')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[contains(@text,'Clear')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[contains(@text,'Clear List')]"))).click();
		Assert.assertTrue(true);
	}
	
	@Test
	public void testLogin_CorrectCredentials() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementById("com.android.chrome:id/terms_accept").click();
		driver.findElementById("com.android.chrome:id/next_button").click();
		driver.findElementById("com.android.chrome:id/negative_button").click();
		Thread.sleep(2000);
		driver.get("https://www.training-support.net/selenium");
		Thread.sleep(10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
		Thread.sleep(10000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(2)"));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[contains(@text,'Login Form')]"))).click();
		String username = "resourceId(\"username\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(username))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(username))).sendKeys("admin");
		String password = "resourceId(\"password\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(password))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(password))).sendKeys("password");
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[contains(@text,'Log in')]"))).click();
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("action-confirmation"))).getText();
		Assert.assertEquals(message, "Welcome Back, admin");
	}
	
	@Test
	public void testLogin_IncorrectCredentials() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementById("com.android.chrome:id/terms_accept").click();
		driver.findElementById("com.android.chrome:id/next_button").click();
		driver.findElementById("com.android.chrome:id/negative_button").click();
		Thread.sleep(2000);
		driver.get("https://www.training-support.net/selenium");
		Thread.sleep(10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
		Thread.sleep(10000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(2)"));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[contains(@text,'Login Form')]"))).click();
		String username = "resourceId(\"username\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(username))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(username))).sendKeys("admin");
		String password = "resourceId(\"password\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(password))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(password))).sendKeys("password1");
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[contains(@text,'Log in')]"))).click();
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("action-confirmation"))).getText();
		Assert.assertEquals(message, "Invalid Credentials");
	}
	
	@Test
	public void popupSignin_CorrectCredentials() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementById("com.android.chrome:id/terms_accept").click();
		driver.findElementById("com.android.chrome:id/next_button").click();
		driver.findElementById("com.android.chrome:id/negative_button").click();
		Thread.sleep(2000);
		driver.get("https://www.training-support.net/selenium");
		Thread.sleep(10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
		Thread.sleep(10000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[contains(@text,'Popups')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[contains(@text,'Sign')]"))).click();
		String username = "resourceId(\"username\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(username))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(username))).sendKeys("admin");
		String password = "resourceId(\"password\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(password))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(password))).sendKeys("password");
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[contains(@text,'Log in')]"))).click();
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("action-confirmation"))).getText();
		Assert.assertEquals(message, "Welcome Back, admin");
	}
	
	@Test
	public void popupSignin_IncorrectCredentials() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementById("com.android.chrome:id/terms_accept").click();
		driver.findElementById("com.android.chrome:id/next_button").click();
		driver.findElementById("com.android.chrome:id/negative_button").click();
		Thread.sleep(2000);
		driver.get("https://www.training-support.net/selenium");
		Thread.sleep(10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
		Thread.sleep(10000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[contains(@text,'Popups')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[contains(@text,'Sign')]"))).click();
		String username = "resourceId(\"username\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(username))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(username))).sendKeys("admin");
		String password = "resourceId(\"password\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(password))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(password))).sendKeys("password1");
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[contains(@text,'Log in')]"))).click();
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("action-confirmation"))).getText();
		Assert.assertEquals(message, "Invalid Credentials");
	}
	
	
	@AfterTest
	public void afterClass() {
		driver.quit();
	}

}
