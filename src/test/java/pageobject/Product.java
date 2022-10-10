package pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ScreenshotGenerator;

public class Product {

	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[3]/div/div/div[3]/div[1]/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/a[1]/div/div[2]/img")
	WebElement cookies;

	public WebDriver driver;

	public Product(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getProductLink() throws IOException {
		driver.get("https://blinkit.com/cn/bakery-biscuits/cookies/cid/888/28");
		ScreenshotGenerator.takeScreenshot(driver);

	}

	public void clickCookies() throws IOException {
		cookies.click();
		ScreenshotGenerator.takeScreenshot(driver);

	}
}
