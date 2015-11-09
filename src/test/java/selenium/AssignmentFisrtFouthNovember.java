package selenium;

import java.awt.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Click;

public class AssignmentFisrtFouthNovember {

	WebDriver driver;
	
	@BeforeMethod
	public void initializeDriver(){
      driver=new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      
		
	}
	
	@Test
	public void testAssignmentFist() throws InterruptedException{
		
		driver.get("http://www1.macys.com");
		driver.findElement(By.id("closeButton")).click();
		java.util.List<WebElement> list=driver.findElements(By.xpath("//*[@id='globalMastheadCategoryMenu']//li//a"));
		
		//java.util.List<WebElement>  list=ele.findElements(By.tagName("li"));
		System.out.println("Link size is: "+list.size());
		Random random=new Random();
		
		int link=random.nextInt(list.size());
		WebElement  li=(WebElement)list.get(link);
		Actions action = new Actions(driver);
		action.moveToElement(li).build().perform();
		System.out.println("link is "+li.getText());
		Thread.sleep(2000);
		java.util.List<WebElement> divElement=driver.findElements(By.xpath("//div[@id='globalMastheadFlyout']/div[@class='subnav flyout-on']//li/a"));
        Random finalRandom=new Random();
		int finalLink=finalRandom.nextInt(divElement.size());
        System.out.println("final link size"+divElement.size());
        System.out.println("final link random"+finalLink);
        WebElement sublink=(WebElement)divElement.get(finalLink);
        System.out.println("final link text"+sublink.getAttribute("href"));
        System.out.println("subLink clicked is: "+sublink.getText());
      //  sublink.click();
        JavascriptExecutor jsx = (JavascriptExecutor)  driver;
        jsx.executeScript("arguments[0].click();", sublink);
     //   Thread.sleep(5000);
     //   sublink.findElement(By.xpath("//*[@id='nav_title']/span"));
        
        //Assert.assertTrue(sublink.getText().contentEquals("filter by"), "assert failed filter by not available on this page");
		Thread.sleep(10000);
        WebElement currentPageIndex=driver.findElement(By.xpath("//*[@id='paginateTop']/span[contains(@class,'currentPage')]"));
        String currentIndex=currentPageIndex.getText();
        System.out.println("Current page index : "+currentPageIndex.getText());
        WebElement nextPage=driver.findElement(By.xpath("//*[@id='paginateTop']/a[@class='arrowRight arrowButton']"));
        nextPage.click();
        WebElement nextPageIndex=driver.findElement(By.xpath("//*[@id='paginateTop']/a[@class='currentPage paginationSpacer']"));
        
        System.out.println("Next page index : "+nextPageIndex.getText());
//        currentPageIndex.click();
        WebElement recerseCurrentPage=driver.findElement(By.xpath("//*[@id='paginateTop']/a[text()='1']"));
        Thread.sleep(10000);
        jsx.executeScript("arguments[0].click();", recerseCurrentPage);
        //recerseCurrentPage.click();
        Thread.sleep(10000);
        System.out.println("text is"+ recerseCurrentPage.getText());
      //  System.out.println("text is"+ recerseCurrentPage.);
        Thread.sleep(10000);
        WebElement reversePageIndex=driver.findElement(By.xpath("//*[@id='paginateTop']/a[@class='currentPage paginationSpacer']"));
        String reverseIndex=reversePageIndex.getText();
        System.out.println("reverse page index : "+reversePageIndex.getText());
        Assert.assertEquals(currentIndex, reverseIndex);
        driver.quit();
		
		
	}
	
	
	@DataProvider
	public Object loginData(){
		String[][] logData=new String[3][2];
		//add element
		
		return logData;
		
	}
}
