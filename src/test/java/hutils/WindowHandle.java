package hutils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import pageobject.BasePage;

public class WindowHandle extends BasePage{
	public WindowHandle(WebDriver driver) {
		super(driver);
	}
	
	// window Handling
	public boolean windowNavigate(String WebsiteTitle) {
		Set<String> window = driver.getWindowHandles();
		for(String id : window) {
			driver.switchTo().window(id);
			String title = driver.getTitle();
			if(title.equals(WebsiteTitle)) {
				return true;
			}
		}
		return false;
	}

}


