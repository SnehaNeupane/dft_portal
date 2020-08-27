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

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
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
//		driver.navigate().back();
		
	}

}
