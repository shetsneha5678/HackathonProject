package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Usedcars;
import testbase.Baseclass;

public class TC002_Usedcars extends Baseclass {
	@Test(groups= {"regression","master"})
	public void UsedCarDetails() throws InterruptedException, IOException {
		logger.info("**** Starting TC_002_UsedCar ****");
		try {
			logger.info("clicking on  Used Cars and selecting Chennai");
			Usedcars usedCar = new Usedcars(driver);
			
			//Hover and select used cars
			usedCar.usedCarsMenu();
			
			//Click on the selected car
			usedCar.selectChennaiUsedCars();

			//Click on the popular models
			usedCar.extractPopularModels();
		} catch (Exception e) {
			logger.info("Failed to click used cars!!!");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished TC_002_UsedCar ****");
	}


}
