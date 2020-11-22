package test.utils;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Basic {
	private static ExtentHtmlReporter htmlReport;
	private static ExtentReports extent;
	private static ExtentTest extentTest;
	private static WebDriver driver;

	public static ExtentReports getInstance() {

		String reportName = getReporttName();
		String directory = System.getProperty("user.dir") + "/reports/";
		new File(directory).mkdirs();
		String path = directory + reportName;
		htmlReport = new ExtentHtmlReporter(path);
		htmlReport.config().setEncoding("utf-8");
		htmlReport.config().setDocumentTitle("Automation Test");
		htmlReport.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.setSystemInfo("organization", "abdou guesmi");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("organization", "abdou guesmi");
		extent.attachReporter(htmlReport);

		// WebDriverManager.chromedriver().setup();
		return extent;
	}

	public static String getReporttName() {
		Date d = new Date();
		String fileName = "Report_" + d.toString().replace(":", "-") + ".html";
		return fileName;

	}
}
