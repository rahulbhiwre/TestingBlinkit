package steps;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.HomePage;
import pagefactory.Search;
import utility.ExcelReader;
import utility.Initialize;

public class Tc4_Search extends Initialize {

	public static Search search;
	public static String actResult;
	public static HomePage homePage;
	public static String productName;

	public Tc4_Search() {
		super();
	}

	@Given("when user is in blinkit Home page")
	public void when_user_is_in_blinkit_home_page() throws InterruptedException, IOException {
		homePage = new HomePage(driver);
		report.startTest("Search Test");
		homePage.getWebsite();
		homePage.detectLocation();
	}

	@When("he enters product name in search bar from {string} and {int}")
	public void he_enters_product_name_in_search_bar_from_and(String SheetName, Integer Rownumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader
				.getData("C:\\Users\\RBHIWRE\\eclipse-workspace\\blinkit1\\Blinkitsearch.xls", SheetName);
		
		productName = testData.get(Rownumber).get("searchProduct");
		search = new Search(driver);
		actResult = search.searchProduct(productName);
		System.out.println("----------------------------" + actResult);
	}

	@Then("he sees the product details")
	public void he_sees_the_product_details() {
		String expResult = "https://blinkit.com/s/?q=" + productName + "&suggestion_type=0&t=1" ;
		assertEquals(actResult,expResult);
		report.getResult(actResult,expResult);
		report.endTest();
		report.endReport();
		driver.quit();
	}

}
