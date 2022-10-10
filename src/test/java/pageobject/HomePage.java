package pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ScreenshotGenerator;

public class HomePage {

	@FindBy(className = "location-box")
	WebElement detectLocationButton;

	@FindBy(xpath = "//*[@id=\\\"app\\\"]/div/div/div[1]/header/div[3]/div[1]/div")
	WebElement login;
	
	@FindBy(xpath = "/html/body/div[5]/div/div/div/div[2]/form/div/input")
	WebElement mobileNo;
	
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getWebsite() throws IOException {
		driver.get("https://blinkit.com/");
		ScreenshotGenerator.takeScreenshot(driver);
	}

	public void detectLocation() throws InterruptedException, IOException {
		detectLocationButton.click();
		ScreenshotGenerator.takeScreenshot(driver);
		Thread.sleep(9000);
	}

	public void clickLogin() {
		login.click();
		
	}
	
	public void enterMobile() {
		mobileNo.sendKeys("");
	}

}
