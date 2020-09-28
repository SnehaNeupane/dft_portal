package Students;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DataEntry_SkillData extends BaseTest{
	
	@Test(priority = 4)
	public void dataentry() throws InterruptedException{
		Thread.sleep(2000);
		WebDriverWait d = new WebDriverWait(driver, 50);
		Thread.sleep(3000);
		//d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[5]/div[4]/div[2]/div[1]/div[1]/div/ul/li[3]/a")));
		driver.findElement(By.xpath("//*[@id=\"mainTabsMenu\"]/li[7]/a")).click();
		Thread.sleep(3000);
		WebElement radio1 = driver.findElement(By.xpath("//*[@id=\"contentArea\"]/div[1]/form[1]/div[1]/div[1]/input"));							
        radio1.click();			
		//driver.findElement(By.xpath("/html/body/div[5]/div[4]/div[2]/div[1]/div[1]/div/div[2]/div/div[3]/div[1]/form[1]/div[1]/div[1]/input")).click();
		Thread.sleep(2000);
		
		//*[@id="contentArea"]/div[1]/form[1]/div[1]/div[1]/select
		driver.findElement(By.xpath("//*[@id=\"contentArea\"]/div[1]/form[1]/div[1]/div[1]/select")).click();
		
		Select universalsetting = new Select(driver.findElement(By.xpath("//*[@id=\"contentArea\"]/div[1]/form[1]/div[1]/div[1]/select")));
		universalsetting.selectByVisibleText("Neupane, Sneha");
		Thread.sleep(2000);
		//Assert.assertEquals(actual, expected);
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/thead/tr/th[1]/div[1]/button[1]/span")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[1]/span/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[1]/span/div/div[2]/div/div/div[2]/div/div/div")).click();
				
//		Select tragetDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[1]/span/div/div[1]")));
//		tragetDropdown.selectByIndex(0);
		Thread.sleep(2000);
			
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[5]/span/span/textarea")).sendKeys("nothing");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/thead/tr/th[1]/div[1]/button[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[1]/span/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[1]/span/div/div[2]/div/div/div[23]/div/div/div")).click();
		Thread.sleep(3000);
			
		Select tragetDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[5]/span/span/div/select")));
		Thread.sleep(3000);
		tragetDropdown.selectByVisibleText("I--Independent");
		Thread.sleep(2000);
 		driver.findElement(By.xpath("//*[@id=\"contentArea\"]/div[1]/form[1]/div[2]/fieldset/div[3]/button[1]")).click();
 		
 		Thread.sleep(2000);
 		String errorMessage = driver.findElement(By.xpath("//*[@id=\"contentArea\"]/div[1]/form[1]/div[2]/fieldset/div[1]/div/span")).getText();
 		System.out.println(errorMessage);
 			}
	
}
