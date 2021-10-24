package project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoogleKeep {
  
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		capabilities.setCapability("deviceId", "emulator-5554");
		capabilities.setCapability("deviceName", "Pixel4Emulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.google.android.keep");
		capabilities.setCapability("appActivity", ".activities.BrowseActivity");
		
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,capabilities);
		wait = new WebDriverWait(driver, 10);
	}
  
	@Test
	public void addNoteUsingGoogleKeep() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String createNoteButton = "resourceId(\"com.google.android.keep:id/new_note_button\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(createNoteButton))).click();
		String title = "resourceId(\"com.google.android.keep:id/editable_title\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(title))).sendKeys("Test");
		String note = "resourceId(\"com.google.android.keep:id/edit_note_text\")";
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(note))).sendKeys("20-10-2021");
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"))).click();
		MobileElement text = driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(@text,'Test')]"));
		wait.until(ExpectedConditions.visibilityOf(text));
		Assert.assertEquals(text.getText(), "Test");
	}
	
	@Test
	public void addNoteUsingGoogleKeepWithReminder() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String createNoteButton = "resourceId(\"com.google.android.keep:id/new_note_button\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(createNoteButton))).click();
		String title = "resourceId(\"com.google.android.keep:id/editable_title\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(title))).sendKeys("Test");
		String note = "resourceId(\"com.google.android.keep:id/edit_note_text\")";
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(note))).sendKeys("Note with Reminder");
		String reminder = "resourceId(\"com.google.android.keep:id/menu_reminder\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(reminder))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text,'Pick a date & time')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[contains(@text,'October 21')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text,'Tomorrow')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[contains(@text,'8:00 AM')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text,'Afternoon')]"))).click();
		String saveButton = "resourceId(\"com.google.android.keep:id/save\")";
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(saveButton))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]"))).click();
		String reminderTab = "resourceId(\"com.google.android.keep:id/drawer_navigation_reminders\")";
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(reminderTab))).click();
		MobileElement text = driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(@text,'Test')]"));
		wait.until(ExpectedConditions.visibilityOf(text));
		Assert.assertEquals(text.getText(), "Test");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
