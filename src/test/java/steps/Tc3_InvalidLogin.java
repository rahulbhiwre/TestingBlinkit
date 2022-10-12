package steps;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.HomePage;
import pageobject.Login;
import utility.Initialize;

public class Tc3_InvalidLogin extends Initialize{
	public static HomePage homePage;
	public static Login loginPage;
	public static boolean resultBool;
	public static String resultText;

	public Tc3_InvalidLogin() {
		super();
	}

	@Given("user is in the homepage")
	public void user_is_in_the_homepage() throws IOException, InterruptedException {
		homePage = new HomePage(driver);
		loginPage= new Login(driver);
		report.startTest("Invalid Login Test ");
		homePage.getWebsite();
		resultBool = homePage.detectLocation();
	}

	@When("user enters the {string} and invalid otp")
	public void user_enters_the_and_invalid_otp(String mobileNo) throws IOException {
		loginPage.clickLogin();
	    loginPage.enterMobileNo(mobileNo);
	    resultText=loginPage.invalidClickNext();
	    System.out.println("---------------------------------" + resultText);	    
	}

	@Then("user will see verfication failed message")
	public void user_will_see_verfication_failed_message() {
		assertEquals("Verification Failed.", resultText);
		report.getResult(resultText, "Verification Failed.");
	    report.endTest();
		driver.quit();
	}

}
