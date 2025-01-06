package org.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Initiation {

	public RegisterPage (WebDriver driver) {
		this. driver = driver;
		}
	
	public static By firstname_fld = By.xpath("//input[@name='data[basicInfo.firstName]']");
	public static By Lastname_fld = By.xpath("//input[@name= 'data[basicInfo.lastName]']");
	public static By email_fld = By.xpath("//input[@name= 'data[basicInfo.email]']");
	public static By password_fld = By.xpath("//input[@name='data[basicInfo.password]']");
	public static By confirmpw_fld = By.xpath(" //input[@name='data[basicInfo.confirmPassword]']");
	public static By mobiLenumber_fld = By.xpath("//input[@name='data[basicInfo.mobile]']");
	
	
	public RegisterPage firstName(String firstname) {
		driver. findElement(firstname_fld) .sendKeys(firstname);
		log.info("First name is feeded");
		return this;
		}
	
	public RegisterPage lastName(String lastname) {
		
		driver. findElement(Lastname_fld).sendKeys(lastname);
		log.info("Last name is feeded");
		return this;
		
	}
	
	public RegisterPage email (String email) {
		
		driver.findElement(email_fld) .sendKeys(email);
		log.info("email is feeded");
		return this;
		
	}
	
	public RegisterPage password (String password) {
		driver.findElement(password_fld).sendKeys(password);
		log.info("Password is feeded"); 
		return this;
		}
	
	public RegisterPage confirmPassword (String confirmPassword) {
		driver.findElement(confirmpw_fld).sendKeys(confirmPassword);
		log.info("Confirm Password is feeded");
		return this;
		}
	
	public RegisterPage mobilenumber(String mobilenumber) {
		driver.findElement(mobiLenumber_fld).sendKeys(mobilenumber);
		log.info("Mobile number is feeded"); 
		return this;
		
	}
	
	public RegisterPage wait_until(){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return this;
		
	}
	
}
