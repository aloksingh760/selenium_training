package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.FlightsearchHome;

public class FlightSearch {
	
	WebDriver driver;
	FlightsearchHome search;
	String from="Delhi";
	String to="Jaipur";
	String ddate="15/11/2015";
	String pCount="2";
	
	
	 @BeforeTest
	 
	    public void setup(){
	 
	        driver = new FirefoxDriver();
	 
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        driver.get("https://www.irctc.co.in");
	        driver.manage().window().maximize();
	       
	 
	    }

	
	public void clickFlight(){
		 driver.findElement(By.xpath("//*[@id='bluemenu']/ul/li[4]/a")).click();
		 search=new FlightsearchHome(driver);	
		 try {
			search.waitForNewWindowAndSwitchToIt(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testFlight(){
		
		
		this.clickFlight();
		search.setFrom(from);
		search.setTo(to);
		search.setNoofPassenger(pCount);
		search.setDepartureDate(ddate);
		search.clickSearch();
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	int price=	search.getFirstFlightRate();
	Assert.assertTrue(price<50000, "test failed due to higher price");
	}
	
	
	
}
