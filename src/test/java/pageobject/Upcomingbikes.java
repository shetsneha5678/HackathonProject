package pageobject;

//import java.io.File;
import java.io.IOException;
import java.util.List;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import hutils.ExcelUtils;

public class Upcomingbikes extends BasePage {
	ExcelUtils Eu=new ExcelUtils();
	
	public Upcomingbikes(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//a[normalize-space()='New Bikes']")
	public WebElement NewBikes;
	
	@FindBy(xpath = "//span[normalize-space()='Upcoming Bikes']")
	public WebElement upcomingBikes;
	
	@FindBy(id = "makeId")
	public WebElement Brand;
	
	@FindBy(xpath = "//span[@class='zw-cmn-loadMore']") ////*[@id="div-gpt-ad-1558070816143-0"]
	public WebElement viewMoreBikesButton;
	
	//@FindBy(xpath = "//*[@id=\"div-gpt-ad-1529569826071-3\"]")
	//public WebElement ScrollTop;
	
	
	@FindBy(css = ".lnk-hvr.block.of-hid.h-height")
	public List<WebElement> modelName;
	
	@FindBy(xpath = "//li[contains(@class,'modelItem')]")
	public List<WebElement> bikePrice;
	
	@FindBy(css = ".clr-try.fnt-14")
	public List<WebElement> dateOfBikes;
	
	
	//click new bikes
	public void HoverNewBikes() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(NewBikes).perform();
		Thread.sleep(3000);
	}
	
	//click upcoming bikes
	public void selectUpcomingBikes() throws IOException{
		
		Actions actions = new Actions(driver);
		actions.moveToElement(upcomingBikes).perform();
		
		//new Baseclass().screenshot("UpcomingBike");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", upcomingBikes);
	}
	//Handling Dropdown
	public void clickBrand() {
		Brand.click();
		Select s=new Select(Brand);
		s.selectByVisibleText("Honda");
	}
	
	//Go to view more bikes and click
	public void clickViewMoreButton() throws InterruptedException {

		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("arguments[0].scrollIntoView(true);", viewMoreBikesButton);
			executor.executeScript("arguments[0].click();", viewMoreBikesButton);
			Thread.sleep(2000);
			//executor.executeScript("arguments[0].scrollIntoView(true);", ScrollTop);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void bikeDetails() throws IOException, InterruptedException {
		
		//new Baseclass().screenshot("All_Bikes");
		Eu.setCellData("UpcomingBike", 0, 0, "BikeName");
		Eu.setCellData("UpcomingBike", 0, 1, "Price");
		Eu.setCellData("=U        pcomingBike", 0, 2, "LaunchDate");
		int row=1;
		for (int i = 0; i < modelName.size(); i++) {
          String  bikeName = modelName.get(i).getText();
			String launchDate = dateOfBikes.get(i).getText();
			int price = Integer.parseInt(bikePrice.get(i).getAttribute("data-price"));
			if (price < 400000) {
				System.out.println(bikeName + "\n" + price + "\n" + launchDate);
				System.out.println("---------------------------");
			Eu.setCellData("UpcomingBike", row, 0, bikeName);
			Eu.setCellData("UpcomingBike", row, 1, price + "");
			Eu.setCellData("UpcomingBike", row, 2, launchDate);
				row++;
			}
		}
		//Thread.sleep(9000);
		//JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("arguments[0].scrollIntoView(true);", ScrollTop);
	}
}
