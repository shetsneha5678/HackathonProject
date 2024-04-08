package stepDefinition;

import java.time.Duration;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Usedcars;
public class usedCars extends BaseClass {
//	public WebDriver driver = new ChromeDriver();
	public Usedcars usedCars = new Usedcars(driver);
	@Given("I am opening zigwheels WebSite")
	public void i_am_opening_zigwheels_web_site() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
//		driver.get(" https://www.zigwheels.com/");
	}

	@When("I am able to see the used car option")
	public void i_am_able_to_see_the_used_car_option() {
	    Assert.assertTrue(usedCars.usedCarsMenu.isDisplayed());
	}

	@When("I am hovering over used car option")
	public void i_am_hovering_over_used_car_option()
	{
	   usedCars.usedCarsMenu();
	}

	@When("I am able to see chennai option")
	public void i_am_able_to_see_chennai_option() 
	{
		
		Assert.assertTrue(usedCars.chennaiUsedCars.isDisplayed());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("I am clicking on chennai option displayed")
	public void i_am_clicking_on_chennai_option_displayed() throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
	    usedCars.selectChennaiUsedCars();
	}

	@Then("I am navigated to new page for used cars")
	public void i_am_navigated_to_new_page_for_used_cars() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("I am able to see the read more option")
	public void i_am_able_to_see_the_read_more_option() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    Assert.assertTrue(usedCars.readMore.isDisplayed());
	}

	@When("I am clicking on read more option")
	public void i_am_clicking_on_read_more_option() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    usedCars.clickReadMore();
	}

	@Then("I am able to see the model")
	public void i_am_able_to_see_the_model() 
	{
	   usedCars.printTable();
	}
}
