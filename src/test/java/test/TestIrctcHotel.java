package test;

import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.CPInstruction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CateringPage;
import pages.HotelAndLoungePage;
import pages.IrctcHomepage;

public class TestIrctcHotel {
	
	WebDriver driver; 
	IrctcHomepage homePage;
	
	@BeforeTest
	 
	    public void setup(){
	 
	        driver = new FirefoxDriver();
	 
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        driver.get("https://www.irctc.co.in");
	        driver.manage().window().maximize();
	        homePage=new IrctcHomepage(driver);
	       
	 
	    }

    @Test
    public void testLinks(){
    	
    	
   HotelAndLoungePage loung=homePage.clickHotelTab();
   String homeString =loung.homeText();
   System.out.println("home text is" +homeString);
   Assert.assertEquals(homeString, "HOME");
   String pack=loung.tourPackegeText();
   System.out.println("package text is" +pack);
   Assert.assertEquals(pack, "TOUR PACKAGE");
   String flight= loung.flightText();
   System.out.println("flight text is" +flight);
   Assert.assertEquals(flight, "FLIGHTS");
   String accom= loung.accomdationText();
   System.out.println("accomadation text is" +accom);
   Assert.assertEquals(accom, "ACCOMMODATION");
   String cabString=loung.cabText();
   System.out.println("cab text is" +cabString);
   Assert.assertEquals(cabString, "CAB/BUS");
   String tourString=loung.touristTrainsText();
   System.out.println("tour text is" +tourString);
   Assert.assertEquals(tourString, "TOURIST TRAINS");
   CateringPage cPage=loung.clickMore();
   cPage.setSearchByStation("delhi");
   cPage.clickCheckout();
   String alertText=cPage.verifyAlert();
   Assert.assertTrue(alertText.contains("Your Cart is empty.Please select some product before checkout"), "actual alert text is"+alertText);  	    	
   String ammount=cPage.verifyAmmount();
   Assert.assertTrue(ammount.contains("Rs. 0"), "actual ammount is"+ammount);  	
    }
}
