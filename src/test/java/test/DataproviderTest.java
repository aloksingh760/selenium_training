package test;

import java.io.FileInputStream;
import java.io.*;




import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class DataproviderTest {

	
	@Test(dataProvider="getData")
	public void setData(String username, String password)
	{
		System.out.println("you have provided username as::"+username);
		System.out.println("you have provided password as::"+password);
	}

	@DataProvider
	public Object[][] getData()
	{
	//Rows - Number of times your test has to be repeated.
	//Columns - Number of parameters in test data.
	Object[][] data = new Object[3][2];
    
	
	try {
		   
		    FileInputStream file = new FileInputStream("E:\\Sellenium_training\\selenium\\Dataprovidertest.xls");  
		    HSSFWorkbook workbook = new HSSFWorkbook(file);
		 
		    //Get first sheet from the workbook
		    HSSFSheet sheet = workbook.getSheetAt(0);
		   
		     
		    //Iterate through each rows from first sheet
		    Iterator<Row> rowIterator = sheet.iterator();
      
          
		        while(rowIterator.hasNext()) {
		           Row row = rowIterator.next();
		           int rownum=row.getRowNum(); 
		           for (int r=0; r<data.length; r++) {
		           if(rownum>0){   
		    
		    	    System.out.println("row number is  : "+ rownum);
		            Iterator<Cell> cellIterator = row.cellIterator();
		            
		            while(cellIterator.hasNext()) {
		            	for (int c=0; c<data[r].length; c++) { 
		            		
		            		
		            Cell cell = cellIterator.next();
		            
		            switch(cell.getCellType()) {
		               
		                case Cell.CELL_TYPE_STRING:
		                	String values=cell.getStringCellValue();
		                    System.out.print(values + "\t\t");
		                   
		                   
		                            data[r][c]=values;
		                        
		                    break;
		            }
		        }
		        System.out.println("");
		    }
		    }
          }
      }
		    file.close();
		   
		     
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}	
	

	return data;
	}
	
			
}


