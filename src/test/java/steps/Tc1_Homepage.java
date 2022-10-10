package steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.HomePage;
import utility.Initialize;
import utility.ReportGenertor;
import utility.ScreenshotGenerator;

public class Tc1_Homepage extends Initialize  {

	public static HomePage homePage;

	@Given("user is in the blinkit website")
	public void user_is_in_the_blinkit_website() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\RBHIWRE\\eclipse-workspace\\blinkit1\\src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		homePage = new HomePage(driver);
		report = new ReportGenertor();
		report.startReport();
		report.startTest("Home page Test");
		homePage.getWebsite();

	}

	@When("user selects the detect location")
	public void user_selects_the_detect_location() throws InterruptedException, IOException {
		homePage.detectLocation();
//		homePage.clickLogin();
	}

	@Then("user will redirected to homepage")
	public void user_will_redirected_to_homepage() {
		report.endTest();
	}

}
