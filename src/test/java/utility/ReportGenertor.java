package utility;

import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportGenertor {

	public static ExtentReports extent;
	public static ExtentTest logger;
	public static int i = 1;

	public void startReport() {
		extent = new ExtentReports("C:\\Ranjith training\\git\\TestingBlinkit\\reports\\blinkit.html", true);
	}

	public void startTest(String message) {
		logger = extent.startTest(" test " + i + " " + message);
		i++;
	}

	public void getResult(boolean result) {
		if (!result) {
			logger.log(LogStatus.FAIL, "Test is failed");

		} else {
			logger.log(LogStatus.PASS, "Test is pass");
		}
	}

	public void getResult(String acResult, String exResult) {
		if (acResult.equals(exResult)) {
			logger.log(LogStatus.PASS, "Test is pass");
		} else {
			logger.log(LogStatus.FAIL, "Test is failed");
		}
	}

	public void endTest() {
		extent.flush();
		extent.endTest(logger);
	}

	public void endReport() {
		extent.close();
	}

}
