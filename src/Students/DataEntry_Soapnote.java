package Students;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DataEntry_Soapnote extends BaseTest{
	
	@Test(priority = 5)
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
