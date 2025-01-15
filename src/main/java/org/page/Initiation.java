package org.page;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.utils.Constants;
import org.utils.GetExcel;
import org.utils.Screenshot;

import org.apache.logging.log4j.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Initiation extends Constants {
	
	protected WebDriver driver ;
	
	public static org.apache.logging.log4j.Logger log ;
	
	public static GetExcel excel = new GetExcel ();
	
	public static List<String> Data;

	//**** Get Excel Data****//
	static {
	
		try {
			Data = GetExcel.fetch(Registeration_data, Sheetname,row_No);
		} 
		catch (IOException e) {
			throw new RuntimeException (e);
			}	
		}
		
	@BeforeSuite
	public void logging(){
	
//	log = LogManager.getLogger(this.getClass().getName());
		
		log = LogManager.getLogger(this.getClass().getName());
			
	}
	
	@BeforeClass // include this ‹ scope>compile‹/scope> in POM under Testng dependcy
	public void startUp(){
	
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver() ;
		driver.manage().window().maximize();
		driver.get(URL);
		log.info ("Webdriver Initiated");
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			Screenshot.capture(driver,result.getName()); // separate class in Utils
		}

	}
}
