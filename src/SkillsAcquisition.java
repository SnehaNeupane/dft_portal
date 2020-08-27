import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SkillsAcquisition {

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

		
		//Student Selection
		driver.findElement(By.id("searchfield_chosen")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Allan, Ciri");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		
		//Skills Acquisition activities
		WebDriverWait d = new WebDriverWait(driver, 20);
		d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("skillAquistionTab")));
		driver.findElement(By.id("skillAquistionTab")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='add']")).click();		

		
		//Add new Skill
//		WebElement element = d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@itemtype='programCategory']")));
//		element.findElement(By.xpath("//li[@itemtype='programCategory']")).sendKeys("Automated");	
		
/*		WebElement ele = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[4]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[2]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].value='Smoke Test';", ele);
		Thread.sleep(3000);
//		driver.findElement(By.id("latestTasks")).click(); */
		
		//Continue with existing skill
		driver.findElement(By.id("1b42c923-ff0c-49fa-85b2-c06170a872fe")).click();
		driver.findElement(By.id("addProgramButton")).click();
		WebDriverWait block = new WebDriverWait(driver, 10);
		block.until(ExpectedConditions.visibilityOfElementLocated(By.className("simplemodal-container")));
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='editor-container']")));
		WebElement program;
		program = driver.findElement(By.id("ProgramName"));
		driver.findElement(By.id("ProgramName")).sendKeys("Smoke Test");
		driver.findElement(By.id("SaveNewProgram")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[contains(text(),'Smoke Test)]")).click();
		
		//Add new Target
		driver.findElement(By.id("addTargetButton")).click();
		driver.close();
	}

}
