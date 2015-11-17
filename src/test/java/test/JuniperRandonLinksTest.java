package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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

public class JuniperRandonLinksTest {
	
	

	
	WebDriver driver;
	String filePath="E:\\Sellenium_training\\selenium\\juniperlinksTest.xls";
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
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.List<WebElement> anchorElement=driver.findElements(By.xpath("//a"));
		System.out.println("Total size is : "+anchorElement.size());
		for(int anchor=0; anchor<anchorElement.size();anchor++){
			
			String hrefValue=anchorElement.get(anchor).getAttribute("href");
			
			
			if(!hrefValue.equals(null)){
			System.out.println("value is : "+hrefValue);
			links.add(hrefValue);
			
			}
			
		}
		
		
		writeInExcelFile(links,filePath);
		try {
			
			for(int i=0; i<5;i++){
				
				String randLink=readExcelSheet(filePath);
				URL url = new URL("http://example.com");
				HttpURLConnection connection = (HttpURLConnection)url.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();

				int code = connection.getResponseCode();
				System.out.println("resposnse code is : "+code);
				Assert.assertEquals(code, code, "actual response is :"+code+" and expected is 200");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	
	
	public void writeInExcelFile(ArrayList<String> list, String path){
		
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet=workbook.createSheet("Juniperlinks");
		int rowIndex=0;
		for(String alist: list){
			
			Row row = sheet.createRow(rowIndex++);
			int cellIndex = 0;
			 row.createCell(cellIndex).setCellValue(alist);
			 
		}
		        try {
		            FileOutputStream fos = new FileOutputStream(path);
		            workbook.write(fos);
		            fos.close();
		            System.out.println("excel sheet is successfully written");
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

			 

		
		
		
		
	}
	
	public String readExcelSheet(String path) throws IOException{
		
		
		FileInputStream infile=new FileInputStream(path);
		HSSFWorkbook workbook = new HSSFWorkbook(infile);
	    Sheet sheet=workbook.getSheet("Juniperlinks");
	    int r=sheet.getLastRowNum();
	    System.out.println("row size is : "+r);
	    Random rand=new Random();
	     
		int randNum=rand.nextInt(r);
		System.out.println("random number is "+randNum);   
		Row rlink=sheet.getRow(randNum);
		String ranlink=rlink.getCell(0).getStringCellValue();
		return ranlink;
	   
	   
		
		
	}


}
