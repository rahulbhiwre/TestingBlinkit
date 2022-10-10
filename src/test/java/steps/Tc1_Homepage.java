package steps;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.HomePage;
import utility.Initialize;

public class Tc1_Homepage extends Initialize {

	public static HomePage homePage;

	public Tc1_Homepage() {
		super();
	}

	@Given("user is in the blinkit website")
	public void user_is_in_the_blinkit_website() throws InterruptedException, IOException {
		homePage = new HomePage(driver);
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
		driver.quit();
	}

}
