package org.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends Initiation{

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		}

		public static By registerTab = By.xpath("//button [contains(text(), 'Register')]");

		public static By jobseekerOption = By.xpath("//li [contains(text(), 'Jobseeker')]");


		public LandingPage register() {

		driver.findElement(registerTab).click();
		log.info("Register Button is clicked");
		return this;
}


		public LandingPage jobseeker () {

		driver.findElement(jobseekerOption).click();
		log.info("Job Seeker Button is clicked");
		return this;
		}

		public LandingPage wait_until() {

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return this;

		}
}