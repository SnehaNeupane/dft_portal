package Students;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EverythingYouNeed extends BaseTest{
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
	
	
	@Test(priority = 1, groups="IgnoreForCertainTime")
	public void addSkills() throws InterruptedException {
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
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("AutomatedSkill");
		driver.findElement(By.id("page-wrapper-1")).click();
		Thread.sleep(2000);
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
		System.out.println("Program created sucessfully");
	}

	
	@Test(priority = 2, groups="IgnoreForCertainTime")
	public void addTarget() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.linkText("Program 1")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"addTargetButton\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("TargetName")).clear();
		driver.findElement(By.id("TargetName")).sendKeys("Anecdotal-Automated");
		driver.findElement(By.id("GoalName")).click();
		driver.findElement(By.id("GoalName")).clear();
		driver.findElement(By.id("GoalName")).sendKeys("Automated test");
		Select targetType = new Select(driver.findElement(By.id("TargetKind")));
		Thread.sleep(3000);
		targetType.selectByVisibleText("Anecdotal");
		driver.findElement(By.id("SaveNewTargetAddAnother")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("TargetName")).clear();
		driver.findElement(By.id("TargetName")).sendKeys("DTT");
		driver.findElement(By.id("GoalName")).click();
		driver.findElement(By.id("GoalName")).clear();
		driver.findElement(By.id("GoalName")).sendKeys("Automated test");
		Select targetType1 = new Select(driver.findElement(By.id("TargetKind")));
		targetType1.selectByVisibleText("DTT");
		driver.findElement(By.id("SaveNewTarget")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Anecdotal-AutomatedOpenLink")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnMsgBoxOk")).click();
		driver.findElement(By.id("DTTOpenLink")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnMsgBoxOk")).click();
}
	
	@Test(priority = 3, groups="IgnoreForCertainTime")
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
		String Newprogramname = driver.findElement(By.xpath("//*[@id=\"latestTasks\"]/tbody/tr[2]/td[1]/b/span")).getText();
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
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/thead/tr/th[1]/div[1]/button[1]/span")).click(); //Click on + below "Target"
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[1]/span/div/div[1]")).click(); //Click on select target drop-down
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[1]/span/div/div[2]/div/div/div[2]/div/div/div")).click(); //Select first target i.e anecdotal
		
		
//		Select tragetDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[1]/span/div/div[1]")));
//		tragetDropdown.selectByIndex(0);
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[5]/span/span/textarea")).sendKeys("nothing"); //Fill Anecdotal input box
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/thead/tr/th[1]/div[1]/button[1]/span")).click(); //Click on + below "Target"
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[1]/span/div/div[1]")).click(); //Click on select target drop-down
		driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[1]/span/div/div[2]/div/div/div[3]/div/div/div")).click();
		Thread.sleep(3000);
		
		
		Select tragetDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"enteredData\"]/tbody/tr/td[5]/span/span/div/select")));
		Thread.sleep(3000);
		tragetDropdown.selectByVisibleText("I--Independent");
		Thread.sleep(2000);
 		driver.findElement(By.xpath("//*[@id=\"contentArea\"]/div[1]/form[1]/div[2]/fieldset/div[3]/button[1]")).click();
 		
 		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,-250)");
 		String errorMessage = driver.findElement(By.xpath("//*[@id=\"contentArea\"]/div[1]/form[1]/div[2]/fieldset/div[1]/div/span")).getText();
 		System.out.println(errorMessage);
 			}
	
	@Test(priority = 5, groups="IgnoreForCertainTime")
	public void soapNoteEntry() throws InterruptedException{
		Thread.sleep(3000);
		WebDriverWait d = new WebDriverWait(driver, 50);
		driver.findElement(By.xpath("//*[@id=\"mainTabsMenu\"]/li[7]/a")).click();
		Thread.sleep(3000);
		//d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[5]/div[4]/div[2]/div[1]/div[1]/div/ul/li[3]/a")));
		driver.findElement(By.id("soapNotesButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"latestTasks\"]/tbody/tr[2]/td/a")).click();
		Thread.sleep(2000);
	//	driver.findElement(By.xpath("//*[@id=\"Answers_0__Answer\"]")).click();
		Thread.sleep(2000);
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		Date today = Calendar.getInstance().getTime();
		DateFormat timewithzone = new SimpleDateFormat("hhmm a");
		
		System.out.println(dateFormat);
		String date = dateFormat.format(today);
		String time = timewithzone.format(today);
		//*[@id="Answers_0__Answer"]
		System.out.println(date);
		System.out.println(time);
		//driver.findElement(By.id("Answers_0__Answer")).clear();
		driver.findElement(By.id("Answers_0__Answer")).sendKeys(date);
		Thread.sleep(2000);
		driver.findElement(By.id("Signature4CheckBox")).click();
		driver.findElement(By.id("Answers_3__Answer")).sendKeys("Notes");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"targetEntryForm\"]/div[1]/h2")).click();
	//	System.out.println(today.getHours() + "" + today.getMinutes());
		driver.findElement(By.id("Answers_1__Answer")).sendKeys("10:00A");
		driver.findElement(By.id("Answers_4__Answer")).sendKeys("Signature");
		Thread.sleep(2000);
		driver.findElement(By.id("Answers_2__Answer")).sendKeys("05:00P");

		driver.findElement(By.id("Answers_4__Answer")).sendKeys("Signature");

		driver.findElement(By.id("saveTimesheet")).click();
	//	btnMsgBoxOk
		Thread.sleep(2000);
		driver.findElement(By.id("btnMsgBoxOk")).click();
	
	}
}