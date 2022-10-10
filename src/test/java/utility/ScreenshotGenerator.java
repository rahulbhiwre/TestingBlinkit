package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenshotGenerator {

	static int i = 1;

	public static void takeScreenshot(WebDriver driver) throws IOException {
		File srcFile;
		srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("C:\\Users\\RBHIWRE\\eclipse-workspace\\blinkit1\\screenshots\\img" + i + ".jpeg"));
		i++;
	}

	
}
