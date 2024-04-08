package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Baseclass  {
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeTest(groups={"smoke","regression","master"})
	@Parameters({"os", "browser"})
	public void invokeBrowser(String os, String browser) throws IOException {
		FileReader fileReader = new FileReader(".//src/test/resources/config.properties");
		Properties properties = new Properties();
		properties.load(fileReader);
		
		//loading log4j2 file
		
		logger = LogManager.getLogger(this.getClass());
		/*if(properties.getProperty("execution_env").equalsIgnoreCase("remote"))
	 	{	
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//os
		if(os.equalsIgnoreCase("windows"))
		{
			capabilities.setPlatform(Platform.WIN11);
		}
		else if(os.equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		else
		{
			System.out.println("No matching os..");
			return;
		}
		//browser
		switch(browser)
		{
		case "chrome" : capabilities.setBrowserName("chrome"); break;
		case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
		default: System.out.println("No matching browser.."); return;
		}
		driver = new RemoteWebDriver(new URL("http://192.168.43.79:4444"), capabilities);
	    }
	else if(properties.getProperty("execution_env").equalsIgnoreCase("local"))
	{
		//launching browser based on condition - locally
		switch(browser)
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default: System.out.println("No matching browser..");
					return;
		}*/
		if(browser.equalsIgnoreCase("chrome")) {			
		driver = new ChromeDriver();
	}else if(browser.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}else {
		System.out.println("No Matching Browser");
		return;
	}
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(properties.getProperty("Url"));
		driver.manage().window().maximize();
	}
	
	@AfterTest(groups={"smoke","regression","master"})
	public void tearDown() {
		driver.quit();
	}
	
	
	//screenshot implementation
	public String screenshot(String name) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\ScreenShots\\"+name+".png";
		File targetLocation = new File(path);
		FileUtils.copyFile(file, targetLocation);
		return path;
	}


}
