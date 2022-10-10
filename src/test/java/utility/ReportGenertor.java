package utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportGenertor {

	public static ExtentReports extent;
	public static ExtentTest logger;
	public static int i = 1;

	public void startReport() {
		extent = new ExtentReports("C:\\Users\\RBHIWRE\\eclipse-workspace\\blinkit1\\reports\\blinkit.html",
				true);
	}

	public void startTest(String message) {
		logger = extent.startTest("test" + i);
		logger.log(LogStatus.PASS, message);
		i++;
	}

	public void endTest() {
		extent.flush();
		extent.endTest(logger);
	}

	public void endReport() {
		extent.close();
	}

	
}
