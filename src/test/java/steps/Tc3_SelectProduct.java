package steps;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Product;
import utility.Initialize;

public class Tc3_SelectProduct extends Initialize {

	public static Product product;
	public static boolean result;


	public Tc3_SelectProduct() {
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
		result = product.clickCookies();
	}

	@Then("user will able to see product details")
	public void user_will_redirected_to_homepage() {
		assertEquals(true, result);
		report.getResult(result);
		report.endTest();
		report.endReport();
		driver.quit();
	}

}
