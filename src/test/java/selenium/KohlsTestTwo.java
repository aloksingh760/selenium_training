package selenium;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KohlsTestTwo {

	WebDriver driver;
	
	 
	 @BeforeMethod
	   public void beforeMethod() {
		 driver=new FirefoxDriver();
		 
		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      System.out.println("in beforeMethod");
	       driver.get("http://www.kohls.com");
	       Actions ac=new Actions(driver);
	       
	      JavascriptExecutor js=(JavascriptExecutor)driver;
	      
	   }
	 
	 
  

	 @AfterMethod
	 public void closeBrowser(){
		 
		 driver.quit();
		 System.out.println("in after method browser closed");
		 
	 }
	 @Test(priority=0)
	   public void testUrl(){
			
			driver.findElement(By.xpath(".//*[@id='navigation']/li[6]/h2/a")).click();
			Assert.assertTrue(driver.getCurrentUrl().contains("mens-clothing"), "mens clothing not found");
			System.out.println("Test successfull");
		}
	 
	 @Test(priority=1)
	   public void testSearch(){
			
			driver.findElement(By.xpath("//*[@id='search']")).sendKeys("jeans");
			driver.findElement(By.xpath(".//*[@id='site-search']/fieldset/input[2]")).click();
			//driver.findElement(By.xpath("//*[@id='Gender']/li[2]/a/span[2]")).click();
			Assert.assertTrue(driver.getCurrentUrl().contains("jeans"), "mens clothing not found");
			System.out.println("Test 2 successfull");
			
		}
//	 @AfterTest
//	 public void closeResources(){
//		 driver.close();
//		 
//	 }
	
}
