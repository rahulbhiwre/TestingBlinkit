package steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Product;
import utility.Initialize;
import utility.ReportGenertor;

public class Tc2_SelectProduct extends Initialize {

	public static Product product;

	public Tc2_SelectProduct() {
		super();
	}

	@Given("user is in homepage")
	public void user_is_in_the_blinkit_website() throws InterruptedException, IOException {
		product = new Product(driver);
		report.startTest("Select Product Test");
		product.getProductLink();
	}

	@When("user selects the product")
	public void user_selects_the_detect_location() throws InterruptedException, IOException {
		product.clickCookies();
	}

	@Then("user will able to see product details")
	public void user_will_redirected_to_homepage() {
		report.endTest();
		report.endReport();
		driver.quit();
	}

}
