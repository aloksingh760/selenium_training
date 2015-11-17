package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HotelAndLoungePage {

	
	WebDriver driver;
	
	public  HotelAndLoungePage(WebDriver driver){
		
		this.driver=driver;
	}

	public String homeText() {
		// TODO Auto-generated method stub
		String home=driver.findElement(By.xpath("//*[@id='main-menu']/li[1]/a")).getText();
		return home;
	}

	public String cabText() {
		// TODO Auto-generated method stub
		String cab=driver.findElement(By.xpath("//*[@id='main-menu']/li[5]/a")).getText();
		return cab;
	}

	public String touristTrainsText() {
		// TODO Auto-generated method stub
		String trString=driver.findElement(By.xpath("//*[@id='main-menu']/li[6]/a")).getText();
		return trString;
	}

	public String accomdationText() {
		// TODO Auto-generated method stub
		String accom=driver.findElement(By.xpath("//*[@id='main-menu']/li[4]/a")).getText();
		return accom;
	}

	public String flightText() {
		// TODO Auto-generated method stub
		String tour=driver.findElement(By.xpath("//*[@id='main-menu']/li[3]/a")).getText();
		return tour;
	}

	public String tourPackegeText() {
		// TODO Auto-generated method stub
		String tour=driver.findElement(By.xpath("//*[@id='main-menu']/li[2]/a")).getText();
		return tour;
	}
	
	public CateringPage clickMore(){
		
		
		Actions action=new Actions(driver);
		
		WebElement we=driver.findElement(By.xpath("//*[@id='main-menu']/li[7]/a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].click();", we);
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/li[7]/ul/li[1]/div/a"))).click().build().perform();
		
		return new CateringPage(driver);
	}
	
}
