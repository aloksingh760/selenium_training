package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class IrctcHomepage {
	WebDriver driver;

	public IrctcHomepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public HotelAndLoungePage clickHotelTab() {
		// TODO Auto-generated method stub
		Actions action=new Actions(driver);
		
	WebElement	element=driver.findElement(By.xpath("//*[@id='hotelsAndLounges']"));
	action.moveToElement(element).moveToElement(driver.findElement(By.xpath("//*[@id='hotelsAndLounges']/following-sibling::ul/li[1]/a"))).click().build().perform();
	System.out.println("In test for hotel click");
		
	try {
		waitForNewWindowAndSwitchToIt(driver);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
		
	HotelAndLoungePage loung=new HotelAndLoungePage(driver);
	return loung;
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
