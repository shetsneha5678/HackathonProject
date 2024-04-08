package pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hutils.WindowHandle;

public class Loginpage extends BasePage {
	
	public Loginpage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//div[@class='row qlc']//div[@class='col-lg-2']")
	public WebElement zigwheelshome;
	
	@FindBy(xpath = "//div[@id='forum_login_title_lg']")
	public WebElement loginSignUpButton;
	
	@FindBy(xpath="//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	public WebElement loginWithGoogleButton;
	
	//@FindBy(xpath=" //*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/div")//#identifierId                   
	//public WebElement emailInput;
	
	@FindBy(id="identifierId")//#identifierId
	public WebElement emailInput;
	
	@FindBy(xpath = "//span[normalize-space()='Next']")
	public WebElement nextbutton;
	
	@FindBy(css=".Ekjuhf.Jj6Lae")//.o6cuMc.Jj6Lae  //.Ekjuhf.Jj6Lae ///html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/c-wiz[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]
	public WebElement errorMessage;
	
	
	public void gotohome() {
		zigwheelshome.click();
	}
	
	public void clickLoginSignUp() throws InterruptedException {
		Thread.sleep(6000);
		loginSignUpButton.click();
		 
	}
	
	public void selectGoogleButton() throws InterruptedException {
		loginWithGoogleButton.click();
		Thread.sleep(8000);
	}
	
	public void setEmailInput() throws InterruptedException {
		//Thread.sleep(6000);
		WindowHandle window = new WindowHandle(driver);
		window.windowNavigate("Sign in - Google Accounts");
		emailInput.sendKeys("cucumber"+ "gmail.com");//RandomStringUtils.randomAlphabetic(5) + "@gmail.com"
	}
	
	public void clickNextButton() throws InterruptedException {
		nextbutton.click();
		Thread.sleep(5000);
	}
	//Capturing Error message
	public void captureErrorMsg() throws IOException, InterruptedException {
		Thread.sleep(10000);
		String errorMsg = errorMessage.getText();
		System.out.println("-----------------------");
		System.out.println(errorMsg);
		System.out.println("-----------------------");
	}
}
