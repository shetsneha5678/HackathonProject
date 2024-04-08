package testcases;

import java.io.IOException;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;

//import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import hutils.WindowHandle;
import pageobject.Loginpage;
import testbase.Baseclass;

public class TC003_Googlesignin extends Baseclass{
	@Test(groups= {"smoke","regression","master"})
	public void verifyLoginPage() throws InterruptedException, IOException {
		logger.info("**** Starting TC_003_LoginSignup ****");
		try {
			logger.info("Verifying login/SignUp");
			//LoginSignupPage loginSignupPage = new LoginSignupPage(driver);
			Loginpage lp = new Loginpage(driver);
			
			// click on the Zigwheels link to navigate back
			lp.gotohome();
			
			// Click on the Login/Signup button
			lp.clickLoginSignUp();
			// Taking screenshot
			screenshot("LoginSignUpCard");
			
			// Select the google button
			lp.selectGoogleButton();
	    	} catch (Exception e) {
			logger.info("Verifying login/SignUp failed!!");
			e.printStackTrace();
			Assert.fail();
		}

}
	
	@Test(dependsOnMethods= {"verifyLoginPage"},groups= {"regression","master"})
	public void verifyGoogleLogin() throws InterruptedException, IOException {
		
		try {
			logger.info("Verifying loginPage");
			// Implementing window handles
			WindowHandle window = new WindowHandle(driver);
			window.windowNavigate("Sign in - Google Accounts");
			Loginpage lp = new Loginpage(driver);
			
			
			/*Set<String> window = driver.getWindowHandles();
			for(String id : window) {
				driver.switchTo().window(id);
				String title = driver.getTitle();
				if(title.equals("Sign in - Google Accounts"))*/	
			
			//email string
			lp.setEmailInput();

			// Click on the next button displayed on the login page
			lp.clickNextButton();
	
	 
			lp.captureErrorMsg();

			// Taking screenshot
			screenshot("LoginErrorMsg");
		}catch (Exception e) {
	 logger.info("LoginPage verification failed!!!");
		 	e.printStackTrace();
		 	Assert.fail();
		}
		 logger.info("**** Finished TC_003_LoginSignup ****");
	}
}


