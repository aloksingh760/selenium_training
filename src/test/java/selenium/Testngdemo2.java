package selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testngdemo2 {

	
	@Test
	public void demoMethod1(){
		
		System.out.println("demomethod1");
	}
	@Test
   public void demoMethod2(){
		
		System.out.println("demomethod1 in class testngdemo2");
	}
	
	@BeforeMethod
	   public void beforeMethod() {
	      System.out.println("in beforeMethod  in class testngdemo2");
	   }

	   @AfterMethod
	   public void afterMethod() {
	      System.out.println("in afterMethod in class testngdemo2");
	   }

	   @BeforeClass
	   public void beforeClass() {
	      System.out.println("in beforeClass in class testngdemo2");
	   }

	   @AfterClass
	   public void afterClass() {
	      System.out.println("in afterClass  in class testngdemo2");
	   }

	   @BeforeTest
	   public void beforeTest() {
	      System.out.println("in beforeTest in class testngdemo2");
	   }

	   @AfterTest
	   public void afterTest() {
	      System.out.println("in afterTest in class testngdemo2");
	   }

	   @BeforeSuite
	   public void beforeSuite() {
	      System.out.println("in beforeSuite in class testngdemo2");
	   }

	   @AfterSuite
	   public void afterSuite() {
	      System.out.println("in afterSuite in class testngdemo2");
	   }
}
