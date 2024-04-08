package pageobject;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import hutils.ExcelUtils;

//import baseClass.BaseClass;

public class Usedcars extends BasePage{
	ExcelUtils Eu=new ExcelUtils();
	
	public Usedcars(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//a[normalize-space()='Used Cars']")
	public WebElement usedCarsMenu;
	
	@FindBy(xpath = "//span[contains(text(),\"Chennai\")]")
	public WebElement chennaiUsedCars;
	
	@FindBy(xpath = "//*[@id=\"seoMore\"]/span")
	public WebElement readMore;
	@FindBy(xpath = "//ul[@class=\"zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10\"]/li/label")
	public List<WebElement> checkboxOfCars;

	@FindBy(xpath = "//span[normalize-space()='Brand and Model']")
	public WebElement BrandAndModel;
	
	@FindBy(xpath = "//*[@id=\"models-table\"]")
	public WebElement table;
	
public void usedCarsMenu() {
		
		Actions action = new Actions(driver);
		action.moveToElement(usedCarsMenu).perform();

	}

public void selectChennaiUsedCars() throws IOException {
	//new Baseclass().screenshot("UsedCarLocation");
	chennaiUsedCars.click();

}
public void clickReadMore()
{
	readMore.click();
}
public void printTable()
{
	System.out.println(table.getText());
}
public void extractPopularModels() throws IOException, InterruptedException {
	System.out.println("Total no of cars:" + checkboxOfCars.size());
	Eu.setCellData("PopularModels", 0, 0, "PopularModelsList");
	int row=1;
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);",BrandAndModel );
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	for (WebElement model : checkboxOfCars) {
		try {
			System.out.println(model.getText());
			Eu.setCellData("PopularModels", row, 0, model.getText());
			row++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

}
