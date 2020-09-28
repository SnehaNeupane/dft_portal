package Students;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class StudentSelection extends BaseTest{
	@Test(priority = 1)
	public void studentselect() throws InterruptedException {
		driver.findElement(By.id("searchfield_chosen")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Miller, Dior')]")).click();
		System.out.println("Selecting 'Miller, Dior'...");
		driver.findElement(By.id("search")).click();
		Thread.sleep(3000);
		String studentselected = driver.findElement(By.xpath("//span[contains(text(),'Miller, Dior')]")).getText();
		String givenparam = "Miller, Dior";
		Assert.assertEquals(studentselected,givenparam);
		System.out.println("Selected Student is 'Miller, Dior'.");
	}

}
