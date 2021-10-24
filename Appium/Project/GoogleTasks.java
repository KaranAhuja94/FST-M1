package project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoogleTasks {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceId", "emulator-5554");
		capabilities.setCapability("deviceName", "Pixel4Emulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appActivity", ".ui.TaskListsActivity");
		capabilities.setCapability("appPackage", "com.google.android.apps.tasks");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,capabilities);
		wait = new WebDriverWait(driver,10);
		
	}
  
	@Test
	public void createTasksUsingGoogleTaskApp() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String getStartedButton = "resourceId(\"com.google.android.apps.tasks:id/welcome_get_started\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(getStartedButton))).click();
		String createTaskButton = "resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(createTaskButton))).click();
		String taskTitle = "resourceId(\"com.google.android.apps.tasks:id/add_task_title\")";
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(taskTitle))).sendKeys("Complete Activity with Google Tasks");
		String saveButton = "resourceId(\"com.google.android.apps.tasks:id/add_task_done\")";
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(saveButton))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(createTaskButton))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(taskTitle))).sendKeys("Complete Activity with Google Keep");
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(saveButton))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(createTaskButton))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(taskTitle))).sendKeys("Complete the second Activity Google Keep");
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(saveButton))).click();
		
		String taskName1 = driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(@text,'Complete the second Activity Google Keep')]")).getText();
		String taskName2 = driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(@text,'Complete Activity with Google Keep')]")).getText();
		String taskName3 = driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(@text,'Complete Activity with Google Tasks')]")).getText();
		
		Assert.assertEquals(taskName1, "Complete the second Activity Google Keep");
		Assert.assertEquals(taskName2, "Complete Activity with Google Keep");
		Assert.assertEquals(taskName3, "Complete Activity with Google Tasks");
		
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
