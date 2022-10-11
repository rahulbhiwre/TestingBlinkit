package pagefactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ScreenshotGenerator;

public class Search {

	public WebDriver driver;

	public Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "input")
	WebElement searchbox;

	public String searchProduct(String product) throws IOException {
		searchbox.sendKeys(product);
		ScreenshotGenerator.takeScreenshot(driver);
		searchbox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ScreenshotGenerator.takeScreenshot(driver);
		return driver.getCurrentUrl();
		
	}

}
