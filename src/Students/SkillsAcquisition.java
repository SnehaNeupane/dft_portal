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

public class SkillsAcquisition extends Login{

		@Test(priority = 1)
		public void addSkills() throws InterruptedException {
			//driver.findElement(By.linkText("SUPPORT")).click() ;
			WebDriverWait d = new WebDriverWait(driver, 20);
			d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("skillAquistionTab")));
			driver.findElement(By.id("skillAquistionTab")).click();
			Thread.sleep(2000);
			d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='add']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='add']")).click();		
			System.out.println("Clicked on Skill Add.");
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("AutomatedSkill");
			driver.findElement(By.id("page-wrapper-1")).click();
			Thread.sleep(2000);
			System.out.println("Skill created: 'AutomatedSkill.'");
			driver.findElement(By.linkText("AutomatedSkill")).click();
			//driver.findElement(By.xpath("(//input[@type='text'])[1]")).click();
			Thread.sleep(3000);
		//	d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("addProgramButton")));
			driver.findElement(By.id("addProgramButton")).click();
			//driver.findElement(By.id("addProgramButton")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("ProgramName")).clear();
			driver.findElement(By.id("ProgramName")).sendKeys("Program 1");
			driver.findElement(By.id("SaveNewProgram")).click();
			Thread.sleep(2000);
			String Newprogramname = driver.findElement(By.linkText("Program 1")).getText();
			String createdprogramName = "Program 1";
			Assert.assertEquals(Newprogramname,createdprogramName);
			System.out.println("Program 1 created sucessfully");
		}
	//
		@Test(priority=2)
		public void addTarget() throws InterruptedException{
			Thread.sleep(3000);
			driver.findElement(By.linkText("Program 1")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"addTargetButton\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("TargetName")).clear();
			driver.findElement(By.id("TargetName")).sendKeys("AnecdotalTarget");
			driver.findElement(By.id("GoalName")).click();
			driver.findElement(By.id("GoalName")).clear();
			driver.findElement(By.id("GoalName")).sendKeys("Automated test");
			Select targetType = new Select(driver.findElement(By.id("TargetKind")));
			Thread.sleep(3000);
			targetType.selectByVisibleText("Anecdotal");
			driver.findElement(By.id("SaveNewTargetAddAnother")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("TargetName")).clear();
			driver.findElement(By.id("TargetName")).sendKeys("DTTTarget");
			driver.findElement(By.id("GoalName")).click();
			driver.findElement(By.id("GoalName")).clear();
			driver.findElement(By.id("GoalName")).sendKeys("Automated test");
			Select targetType1 = new Select(driver.findElement(By.id("TargetKind")));
			targetType1.selectByVisibleText("DTT");
			driver.findElement(By.id("SaveNewTarget")).click();
			Thread.sleep(2000);
			System.out.println("Anecdotal Target created.");
			System.out.println("DTT Target created.");
			driver.findElement(By.id("AnecdotalTargetOpenLink")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("btnMsgBoxOk")).click();
			System.out.println("Anecdotal Target is opened.");
			driver.findElement(By.id("DTTTargetOpenLink")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("btnMsgBoxOk")).click();
			System.out.println("DTT Target is opened.");
			
		}		
	}
