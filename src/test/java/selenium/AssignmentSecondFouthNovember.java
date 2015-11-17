package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentSecondFouthNovember {

			
		WebDriver driver;
		@BeforeMethod
		public void initializeDriver(){
	      driver=new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      
			
		}
		
		
		@Test
		public void assignmentTwo_juniperlink(){

			ArrayList<String> links=new ArrayList<String>();
					
			driver.get("http://www.juniper.net");
			
			java.util.List<WebElement> anchorElement=driver.findElements(By.xpath("//a"));
			System.out.println("Total size is : "+anchorElement.size());
			for(int anchor=0; anchor<anchorElement.size();anchor++){
				
				String hrefValue=anchorElement.get(anchor).getAttribute("href");
				
				
				if(!hrefValue.equals(null)){
				System.out.println("value is : "+hrefValue);
				links.add(hrefValue);
				
				}
				
			}
			
			
					
	}
		
		
}
