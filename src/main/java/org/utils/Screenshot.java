package org.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static void capture (WebDriver driver, String screenshotname ) throws IOException {
		
	
	 File src = ((TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
	 File dest = new File("./Output/"+ screenshotname +"-png");
	 FileUtils.copyFile(src, dest);

	}
}
