package Students;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@Test
public class SkillsAcquisition extends BaseTest{

		@Test(priority = 1)
		public void addSkills() throws InterruptedException {
			System.out.println("Second file");
			//driver.findElement(By.linkText("SUPPORT")).click() ;
			WebDriverWait d = new WebDriverWait(driver, 20);
			d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("skillAquistionTab")));
			driver.findElement(By.id("skillAquistionTab")).click();
			Thread.sleep(3000);
			d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='add']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='add']")).click();		
			System.out.println("dwwwwwwww");
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Skill1");
			driver.findElement(By.id("page-wrapper-1")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Skill1")).click();
			//driver.findElement(By.xpath("(//input[@type='text'])[1]")).click();
			Thread.sleep(3000);
		//	d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("addProgramButton")));
			driver.findElement(By.id("addProgramButton")).click();
			//driver.findElement(By.id("addProgramButton")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("ProgramName")).clear();
			driver.findElement(By.id("ProgramName")).sendKeys("Program1");
			driver.findElement(By.id("SaveNewProgram")).click();
			Thread.sleep(2000);
			String Newprogramname = driver.findElement(By.linkText("Program1")).getText();
			String createdprogramName = "Program1";
			Assert.assertEquals(Newprogramname,createdprogramName);
			System.out.println("Program created sucessfully");
		}
	//
		@Test(priority=2)
		public void addTarget() throws InterruptedException{
			Thread.sleep(3000);
			driver.findElement(By.linkText("Program1")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"addTargetButton\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("TargetName")).clear();
			driver.findElement(By.id("TargetName")).sendKeys("Anecdotal");
			driver.findElement(By.id("GoalName")).click();
			driver.findElement(By.id("GoalName")).clear();
			driver.findElement(By.id("GoalName")).sendKeys("automatedtest");
			Select targetType = new Select(driver.findElement(By.id("TargetKind")));
			Thread.sleep(3000);
			targetType.selectByVisibleText("Anecdotal");
			driver.findElement(By.id("SaveNewTargetAddAnother")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("TargetName")).clear();
			driver.findElement(By.id("TargetName")).sendKeys("DTT");
			driver.findElement(By.id("GoalName")).click();
			driver.findElement(By.id("GoalName")).clear();
			driver.findElement(By.id("GoalName")).sendKeys("automatedtest");
			Select targetType1 = new Select(driver.findElement(By.id("TargetKind")));
			targetType1.selectByVisibleText("DTT");
			driver.findElement(By.id("SaveNewTarget")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("AnecdotalOpenLink")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("btnMsgBoxOk")).click();
			driver.findElement(By.id("DTTOpenLink")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("btnMsgBoxOk")).click();
			
		}		
	}
