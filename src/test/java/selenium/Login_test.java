package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



public class Login_test {

	@Test
	public void testGmailLogin(){
		try{
		WebDriver driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("aloksingh760");
		driver.findElement(By.xpath("//*[@id='next']")).click();
	    Thread.sleep(2000);
		
	
		driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys("760alok2prince");
		driver.findElement(By.xpath("//*[@id='signIn']")).click();
		
		
		
		driver.findElement(By.xpath("//*[@id=':y3']/div/div")).click();
	    driver.findElement(By.xpath("//*[@id=':12n']//div[@class='wO nr l1']/textarea[@name='to']")).sendKeys("shubham.mathur@gspann.com");
	    driver.findElement(By.xpath("//*[@id=':12n']/descendant::div[1]/following-sibling::div[2]/input[1]")).sendKeys("Sending mail by selenium program");
	    
	    driver.findElement(By.xpath("//*[@id=':12n']/descendant::table[2]//div[@class='Am Al editable LW-avf']")).sendKeys("Hi Subham, this mail is regarding assignment,");
	    
	    driver.findElement(By.id(":136")).click();
	    
		
//		driver.findElement(By.xpath("//*[@id=':136']/ancestor::table[3]/descendant::div[1]/following-sibling::div[1]")).sendKeys("shubham.mathur@gspann.com");
//		driver.findElement(By.xpath("//*[@id=':136']/ancestor::table[3]/descendant::div[1]/following-sibling::div[2]")).sendKeys("Sending mail by selenium program");
//		driver.findElement(By.xpath("//*[@id=':136']/ancestor::table[2]/descendant::div[1]")).sendKeys("Hi shinham");
//		driver.findElement(By.xpath("//div[text()='Send']")).click();

		/* Go to Sent Items and verify */
		driver.findElement(By.xpath("//*[@id=':136']")).click();
	    
		   
	    
	    
	    
	    
	    
	  //  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}	
	
	public static void main(String[] args){
		
		Login_test login=new Login_test();
		login.testGmailLogin();
	}
}
