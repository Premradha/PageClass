package org.validation;

import java.io.IOException;

import org.page.Initiation;
import org.page.LandingPage;
import org.page.RegisterPage;
import org.testng.annotations.Test;

public class Wyo extends Initiation {

	private static final String first_name = Data.get(0);
	private static final String Last_name = Data.get(1);
	private static final String email = Data.get (2);
	private static final String password = Data.get(3);
	private static final String cnf_password = Data.get(4);
	private static final String mobile_no = Data.get(5);
	
	
	@Test (priority = 1)
	
	public void homePage()throws IOException {
		LandingPage land = new LandingPage(driver);
		
		land
		.wait_until()
		.register()
		.jobseeker();
	}
	
	
	@Test (priority = 2)
	
	public void registerPage() throws IOException {
		
		RegisterPage reg = new RegisterPage(driver);
		
		 reg
			.wait_until()
			.firstName(first_name)
			.lastName(Last_name)
			.email(email)
			.password(password)
			.confirmPassword(cnf_password)
			.mobilenumber(mobile_no);
			
	}
}
