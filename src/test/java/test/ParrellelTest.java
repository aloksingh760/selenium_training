package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class ParrellelTest {

	@Test
	public void chromeTest(){
		
		 System.setProperty("webdriver.chrome.driver","chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         //Goto guru99 site
         driver.get("https://www.google.co.in");
         //find user name text box and fill it
         //driver.findElement(By.name("uid")).sendKeys("Driver 1");
         System.out.println("chrome browser opened");
	}
	
	@Test 
	public void firefoxTest(){
		WebDriver driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
		System.out.println("firefox browser opened");
		
	}
	
	@Test
	public void ieTest(){
		
		 System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
         WebDriver driver = new InternetExplorerDriver();
         //Goto guru99 site
         driver.get("https://www.google.co.in");
         //find user name text box and fill it
         //driver.findElement(By.name("uid")).sendKeys("Driver 1");
         System.out.println("IE browser opened");
	}

}
