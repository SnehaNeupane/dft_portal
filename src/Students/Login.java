package Students;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends BaseTest{
	
	@Test(priority = 0)
	public void login() throws InterruptedException{
		
		driver.findElement(By.id("Username")).clear();
		driver.findElement(By.id("Username")).sendKeys("p.test");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Automate123+");
		driver.findElement(By.id("Password")).sendKeys(Keys.RETURN);
		expected = "Catalyst - Student Overview";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);	
}
}