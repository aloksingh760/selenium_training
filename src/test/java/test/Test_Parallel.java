package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_Parallel {

	 private  WebDriver driver=null;
	
	
	 @Parameters ({"browser"})
	 public void setup(String browser){
	  if (browser.equals("FFX")) {
	   System.out.println("Test Starts Running In Firefox Browser.");
	   driver = new FirefoxDriver();   
	  }else if (browser.equals("CRM")){
	   System.out.println("Test Starts Running In Google chrome.");
	   System.setProperty("webdriver.chrome.driver", 
	     "chromedriver.exe");
	   driver = new ChromeDriver();   
	  }else if (browser.equals("ie")){
		   System.out.println("Test Starts Running In Internet explorer.");
		   System.setProperty("webdriver.ie.driver", 
		     "IEDriverServer.exe");
		   driver = new ChromeDriver();   
		  }
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com");  
	 } 
	 //this tets will execute all three browsers
	 @Test
	 public void verify_title(){   
	   String title = driver.getTitle();
	   Assert.assertEquals("Google", title);
	   System.out.println("Title Is Fine.");   
	 } 
	 @AfterClass 
	 public void closebrowser(){
	   driver.quit();  
	 }
	}
