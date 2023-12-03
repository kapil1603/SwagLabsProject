package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Test_Base;

public class ExtentReportManager extends Test_Base{
	static ExtentReports report;
	public static ExtentReports getReportInstance() {
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("C:\\Users\\kappu\\eclipse-workspace\\SeleniumFramework\\extentreport\\report.html");
		report = new ExtentReports();
		report.attachReporter(htmlreporter);
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("Environment", "SIT");
		report.setSystemInfo("Build Number", "102.02.02.123");
		report.setSystemInfo("Browser", "chrome");
		htmlreporter.config().setDocumentTitle("UI Testing Document");
		htmlreporter.config().setReportName("UI Test Report");
		
		return report;
		
	}

}
