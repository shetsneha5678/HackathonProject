package stepDefinition;
import java.io.IOException;
import java.time.Duration;

import factory.BaseClass;
import io.cucumber.java.en.Given;
 
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Loginpage;
 
 
	
public class LoginSteps extends BaseClass {
	
	Loginpage lp =  new Loginpage(driver);
	@Given("the user opens zigwheels site")
	public void the_user_opens_zigwheels_site() {
		logger.info("**Statring the login Test Case**");
		driver.manage().window().maximize();
		lp.gotohome();
	}
 
	@Given("the user navigates to ZigWheels login page")
	public void the_user_navigates_to_zig_wheels_login_page() throws InterruptedException {
		logger.info("**Clicking Login Button**");
	   lp.clickLoginSignUp(); 
	}
 
	@When("the user clicks on sign in with Google")
	public void the_user_clicks_on_sign_in_with_google() throws InterruptedException  {
		logger.info("**Clicking the google Button**");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp.selectGoogleButton();
	}
 
	@When("the user enters the invalid email id")
	public void the_user_enters_the_invalid_email_id_email() throws InterruptedException {
		logger.info("**Giving Email Input**");
	   lp.setEmailInput();
	}
	@When("the user clicks next")
	public void the_user_clicks_next() throws InterruptedException {
		logger.info("**Clicking next Button**");
	   lp.clickNextButton();
	}
 
	@Then("the user should see error on the login page")
	public void the_user_should_see_error_on_the_login_page() {
		logger.info("**Capturing the error message**");
		try {
			lp.captureErrorMsg();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	}
