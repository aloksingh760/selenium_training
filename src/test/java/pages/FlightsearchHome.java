package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightsearchHome {

WebDriver driver;
	
	public FlightsearchHome(WebDriver driver){
		
		this.driver=driver; 
	}
	
	public void setFrom(String from){
	
	    
		driver.findElement(By.xpath("//*[@id='origin']")).sendKeys(from);
	    driver.findElement(By.xpath("//div[@id='layer1']/following-sibling::ul[1]/li/a")).click();
		System.out.println("in from");
	}
	
   public void setTo(String to){
		
	   
	   
		driver.findElement(By.xpath("//*[@id='destination']")).sendKeys(to);
		driver.findElement(By.xpath("//html/body/ul[2]/li[1]/a")).click();
		System.out.println("in to"); 
   }
   
   public void setDepartureDate(String date){
	   
	   driver.findElement(By.xpath("//*[@id='departDate']")).sendKeys(date);
	   System.out.println("in departure");
   }
   
   public void setNoofPassenger(String passenger){
	   
	   driver.findElement(By.xpath("//*[@id='noOfAdult']")).sendKeys(passenger);
	   System.out.println("in pass");
   }
   
   public void clickSearch(){
	   
	   driver.findElement(By.xpath("//*[@id='showdometic']/div[6]")).click();
	   System.out.println("in search click");
   }	
	public int getFirstFlightRate(){
		
	String value=driver.findElement(By.xpath("//div[@id='flightListResult']/div[1]/table/tbody/tr[1]/td[9]/table/tbody/tr/td/span")).getText();
	
	int price=Integer.parseInt(value);
	return price;
	}
	
	 public void waitForNewWindowAndSwitchToIt(WebDriver driver) throws InterruptedException {
	        String cHandle = driver.getWindowHandle();
	        String newWindowHandle = null;
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        
	        //Wait for 20 seconds for the new window and throw exception if not found
	        for (int i = 0; i < 20; i++) {
	            if (allWindowHandles.size() > 1) {
	                for (String allHandlers : allWindowHandles) {
	                    if (!allHandlers.equals(cHandle))
	                    	newWindowHandle = allHandlers;
	                }
	                driver.switchTo().window(newWindowHandle);
	                break;
	            } else {
	                Thread.sleep(1000);
	            }
	        }
	        if (cHandle == newWindowHandle) {
	            throw new RuntimeException(
	                    "Time out - No window found");
	        }
	    }



}