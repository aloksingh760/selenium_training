package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CateringPage {
	
	WebDriver driver;

	public CateringPage(WebDriver  driver){
		
		this.driver=driver;
	}
	
	public void setSearchByStation(String searchKey){
		
		driver.findElement(By.id("stnCode")).sendKeys(searchKey);
		driver.findElement(By.xpath("//*[@id='ui-id-1']/li[3]")).click();
		driver.findElement(By.xpath("//*[@id='stncode']/input[2]")).click();
	}

	public void clickCheckout() {
		// TODO Auto-generated method stub
		driver.findElement(By.id("button")).click();;
	}

	public String verifyAlert() {
		// TODO Auto-generated method stub
		Alert alert = driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		return text;
		
	}

	public String verifyAmmount() {
		// TODO Auto-generated method stub
		String text=driver.findElement(By.xpath("//*[@id='totalAmount']/h2/strong")).getText();
		return text;
	}

	
}
