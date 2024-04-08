package stepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TimeoutException;


public class Hooks {

	 public WebDriver driver;
	 public Properties p;
	 public Logger logger;
     
	@Before
    public void setup() throws IOException, InterruptedException
    {
    	driver=BaseClass.initilizeBrowser();
    	 logger = BaseClass.getLogger();   	
    	p=BaseClass.getProperties();
    	try {
    		driver.get(p.getProperty("Url"));
    		Thread.sleep(2000);
        } catch (TimeoutException e) {
            System.out.println("Page: " + "https://www.zigwheels.com/" + " did not load within 60 seconds!");
        }
    	
    	driver.manage().window().maximize();
    
    			
	}
		
    
    @After
    public void tearDown(Scenario scenario) {
        		
       driver.quit();
       
    }
    

    @AfterStep
    public void addScreenshot(Scenario scenario) {
    	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
    }
   
}
