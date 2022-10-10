package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initialize {

	public ReportGenertor report;
	public WebDriver driver;

	public Initialize() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\RBHIWRE\\eclipse-workspace\\blinkit1\\src\\test\\resources\\drivers\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.report = new ReportGenertor();
	}

}
