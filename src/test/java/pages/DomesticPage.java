package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DomesticPage {

	WebDriver driver;
	
	public DomesticPage(WebDriver driver){
		
		this.driver=driver;
	}
	
	public void setFrom(String from){
		
		driver.findElement(By.xpath("//*[@id='origin']")).sendKeys(from);
	}
	
   public void setTo(String to){
		
		driver.findElement(By.xpath("//*[@id='destination']")).sendKeys(to);
	}
   
   public void setDepartureDate(String date){
	   
	   driver.findElement(By.xpath("//*[@id='departDate']")).sendKeys(date);
   }
   
   public void setNoofPassenger(String passenger){
	   
	   driver.findElement(By.xpath("//*[@id='noOfAdult']")).sendKeys(passenger);
   }
   
   public void clickSearch(){
	   
	   driver.findElement(By.xpath("//*[@id='showdometic']/div[6]")).click();
   }
}
