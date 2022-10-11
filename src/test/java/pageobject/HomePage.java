package pageobject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ScreenshotGenerator;

public class HomePage {

	@FindBy(className = "location-box")
	WebElement detectLocationButton;

	@FindBy(className = "bFHCDW")
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

	public Boolean detectLocation() throws InterruptedException, IOException {
		detectLocationButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Ahmedabad']")).click();
		ScreenshotGenerator.takeScreenshot(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return login.isDisplayed();

	}

}
