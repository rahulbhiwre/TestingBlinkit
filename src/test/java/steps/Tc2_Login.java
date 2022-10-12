package steps;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.HomePage;
import pageobject.Login;
import utility.Initialize;

public class Tc2_Login extends Initialize {
	public static HomePage homePage;
	public static Login loginPage;
	public static boolean resultBool;
	public static String resultText;

	public Tc2_Login() {
		super();
	}

	@Given("user is in  homepage")
	public void user_is_in__homepage() throws IOException, InterruptedException {
		homePage = new HomePage(driver);
		loginPage= new Login(driver);
		report.startTest("Login Test");
		homePage.getWebsite();
		resultBool = homePage.detectLocation();
	}

	@When("user enters the  {string} and valid otp")
	public void user_enters_the_and_valid_otp(String mobileNo) throws IOException {
	    loginPage.clickLogin();
	    loginPage.enterMobileNo(mobileNo);
	    resultText=loginPage.validClickNext();
	    System.out.println("---------------------------------" + resultText);
	}

	@Then("user will see login successful message")
	public void user_will_see_login_successful_message() {
		assertEquals("Account", resultText);
		report.getResult(resultText,"Account");
	    report.endTest();
		driver.quit();
	}
}
