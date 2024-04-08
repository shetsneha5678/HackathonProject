package stepDefinition;

import java.time.Duration;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Upcomingbikes;

public class upcomingBikes extends BaseClass
{
//	public static WebDriver driver = new ChromeDriver();
	public Upcomingbikes upcomingBike = new Upcomingbikes(driver);
	
	
	@Given("the user is in zigwheel homepage")
	public void the_user_is_in_zigwheel_homepage() {
		logger.info("**Statring the Upcoming bikes Test Case**");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@When("the user able to see New bikes option")
	public void the_user_able_to_see_new_bikes_option() {
		logger.info("**Validating whether new bikes option displayed**");
		Assert.assertTrue(upcomingBike.NewBikes.isDisplayed());
	}

	@Then("the user should hover mouse over newBikes option")
	public void the_user_should_hover_mouse_over_new_bikes_option() throws Exception {
		logger.info("**Hover on new bikes option**");
		upcomingBike.HoverNewBikes();
	}


	@When("the user able to see upcoming bikes option")
	public void the_user_able_to_see_upcoming_bikes_option() {
		logger.info("**Checking for new bikes option**");
		Assert.assertTrue(upcomingBike.upcomingBikes.isDisplayed());
	}

	@Then("the user clicks on upcoming bike")
	public void the_user_clicks_on_upcoming_bike() throws Exception {
		logger.info("**Clicking on upcoming bikes option**");
		upcomingBike.selectUpcomingBikes();
	}

	@When("the user able to see dropdown")
	public void the_user_able_to_see_dropdown() 
	{
		logger.info("**Checking for dropdown**");
	    Assert.assertTrue(upcomingBike.Brand.isDisplayed());
	}

	@When("the user clicks on honda option from dropdown")
	public void the_user_clicks_on_honda_option_from_dropdown() {
		logger.info("**Clicking honda option**");
	    upcomingBike.clickBrand();
	}

	@When("the user can see read more option")
	public void the_user_can_see_read_more_option() 
	{
		logger.info("**Checking for read more options**");
	   Assert.assertTrue(upcomingBike.viewMoreBikesButton.isDisplayed());
	}

	@When("the user can see table with list of bikes")
	public void the_user_can_see_table_with_list_of_bikes() 
	{
		logger.info("**Checking for list of bikes**");
		Assert.assertTrue(upcomingBike.modelName.size()>0);
	}

	@Then("the user can see the list in console")
	public void the_user_can_see_the_list_in_console() throws Exception, InterruptedException {
		logger.info("**Printing bike details in console**");
		upcomingBike.bikeDetails();
	}
}
