package pagefactory;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ScreenshotGenerator;

public class Login {
	
	@FindBy(className="bFHCDW")
	WebElement loginButton;
	
	@FindBy(xpath="/html/body/div[5]/div/div/div/div[2]/form/div/input")
	WebElement enterMobileNumber;
	
	@FindBy(className="login-button")
	WebElement submitMobileNumberButton;
		
	public WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogin() throws IOException {
		loginButton.click();
		ScreenshotGenerator.takeScreenshot(driver);
	}
	
	public void enterMobileNo(String mobileNo) throws IOException {
		enterMobileNumber.sendKeys(mobileNo);
		ScreenshotGenerator.takeScreenshot(driver);
		submitMobileNumberButton.click();
		ScreenshotGenerator.takeScreenshot(driver);
	}
	public String clickNext() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(submitMobileNumberButton)).click();
		ScreenshotGenerator.takeScreenshot(driver);
		return driver.findElement(By.className("bFHCDW")).getText();
	}
}
