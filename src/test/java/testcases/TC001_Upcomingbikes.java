package testcases;

import java.io.IOException;

import pageobject.Upcomingbikes;
import testbase.Baseclass;

public class TC001_Upcomingbikes  extends Baseclass {
	public static void HoverNewBikes(){
		try {
		logger.info("**** Starting TC_001_UpcomingBike ****");
			logger.info("clicking on  New Bikes ");
			Upcomingbikes upcomingBike = new Upcomingbikes(driver);
			upcomingBike.HoverNewBikes();
		}
		catch(Exception e){}
		}
	
	public static void selectupcomingbikes() throws IOException {
		logger.info("Selecting Upcoming Bikes");
		Upcomingbikes upcomingBike = new Upcomingbikes(driver);
		upcomingBike.selectUpcomingBikes();
	}

	
	public static void clickonbrand() throws InterruptedException, IOException {
		 
			logger.info("clicking on Upcoming Bikes");
			Upcomingbikes upcomingBike = new Upcomingbikes(driver);
			// Click on Brand 
			upcomingBike.clickBrand();
			
			// View more bikes 
			upcomingBike.clickViewMoreButton();
			
	
	}
	// Display details
	public static void Displaybikesdetails() throws IOException, InterruptedException{
		logger.info("Displaying bikes details");
		Upcomingbikes upcomingBike = new Upcomingbikes(driver);
		upcomingBike.bikeDetails();
		logger.info("**** Finished TC_001_UpcomingBike ****");
	}
		
	}
		
		
		 



