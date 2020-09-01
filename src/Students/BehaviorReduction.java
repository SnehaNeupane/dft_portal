package Students;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BehaviorReduction extends BaseTest{
	
	@Test(priority = 3)
	public void behaviourReduction() throws InterruptedException{
		Thread.sleep(2000);
		WebDriverWait d = new WebDriverWait(driver, 50);
		//d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[5]/div[4]/div[2]/div[1]/div[1]/div/ul/li[3]/a")));
		driver.findElement(By.xpath("/html/body/div[5]/div[4]/div[2]/div[1]/div[1]/div/ul/li[3]/a")).click();
		Thread.sleep(3000);
	
		//d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("createBehaviorItem")));
		driver.findElement(By.id("createBehaviorItem")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Name")).sendKeys("Aggression");
		Select drpCountry = new Select(driver.findElement(By.id("behaviorCategory")));
		drpCountry.selectByVisibleText("Aggression");
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
		String Newprogramname = driver.findElement(By.xpath("//*[@id=\"latestTasks\"]/tbody/tr[3]/td[1]/b/span")).getText();
		//String behavior = driver.getPageSource();
		String createdprogramName = "Aggression";
		Assert.assertEquals(Newprogramname,createdprogramName);
		System.out.println("Behaviour created sucessfully");
		if(driver.getPageSource().contains("Aggression"))
		{
			System.out.println("Name is Present");
		}

		else{
			System.out.println("Name is not Present");

		}		
	}
}
