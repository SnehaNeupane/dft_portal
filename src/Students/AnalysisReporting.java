package Students;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AnalysisReporting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date today = Calendar.getInstance().getTime();
		String date = dateFormat.format(today);
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneupane/Documents/work/chromedriver");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		//Login
		driver.get("https://staging.datafinch.com");
		driver.findElement(By.id("Username")).clear();
		driver.findElement(By.id("Username")).sendKeys("st6.kim");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Temp123!");
		driver.findElement(By.id("Password")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		
		
		//Analysis & Reporting
		driver.findElement(By.xpath("//a[contains(text(),'Analysis & Reporting')]")).click();
		Thread.sleep(2000);
		
		//Daily Reports
		driver.findElement(By.xpath("//span[contains(text(),'Daily Reports')]")).click(); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement dtttrialsheet = driver.findElement(By.xpath("//li[@class='closed collapsable']//li[6]//span[1]//a[1]"));
		js.executeScript("arguments[0].scrollIntoView();", dtttrialsheet);
		driver.findElement(By.xpath("//li[@class='closed collapsable']//li[6]//span[1]//a[1]")).click();
		driver.findElement(By.xpath("//li[@class='closed collapsable']//li[6]//span[1]//a[1]")).click();
				
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)"); //Scroll up window
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='parameters_0__Value']")).click();
				
		//Select current date from dynamic calendar
		driver.findElement(By.xpath("//input[@id='parameters_0__Value']")).sendKeys(date);
		driver.findElement(By.xpath("//input[@id='parameters_0__Value']")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("btnExecute")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='left']")).getText(), "Results");
		
		WebElement scrollArea = driver.findElement(By.cssSelector("div.Graphlist"));
		jse.executeScript("arguments[0].scrollTop = arguments[1];",scrollArea, -250); //Scroll up only specific div
		driver.findElement(By.xpath("//span[contains(text(),'Daily Reports')]")).click(); 
		Thread.sleep(2000);
		
		//Monthly Sessions (with therapist initials)
		driver.findElement(By.xpath("//span[contains(text(),'Monthly Reports')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Monthly Sessions (with therapist initials)')]")).click();
		driver.findElement(By.xpath("//input[@id='parameters_0__Value']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='parameters_0__Value']")).sendKeys(date);
		driver.findElement(By.xpath("//input[@id='parameters_0__Value']")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("btnExecute")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='left']")).getText(), "Results");
		driver.findElement(By.xpath("//span[contains(text(),'Monthly Reports')]")).click();
		
		//Weekly Reports
		driver.findElement(By.xpath("//span[contains(text(),'Weekly Reports')]")).click();
		jse.executeScript("arguments[0].scrollIntoView = arguments[1];",scrollArea, 250); //Scroll down only specific div
		jse.executeScript("window.scrollBy(0,250)"); //Scroll window down
		driver.findElement(By.xpath("//a[contains(text(),'Weekly Trial Counts')]")).click();
		driver.findElement(By.xpath("//input[@id='parameters_0__Value']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[4]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/form[1]/input[2]")).sendKeys("08/28/2020");
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[4]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/form[1]/input[2]")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("btnExecute")).click();
		Thread.sleep(2000);
		
		driver.close();

	}

}
