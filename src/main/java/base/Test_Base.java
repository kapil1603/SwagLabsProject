package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportManager;
import utility.ReadData;
//interview ques
//we can check passed and failed test case after creating suit and also run in testing.xml. and we can see failed test cases separately and run testing failed.xaml 
public class Test_Base {
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
//	public static WebDriver driver;
	public static ChromeDriver driver;
	public void initilization() throws InterruptedException, IOException {
//		String browser = ReadData.readPropertieFile("Browser");
//		if (browser.equals("Chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		else if (browser.equals("firefox")){
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		else if (browser.equals("Edge")){
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(ReadData.readPropertieFile("URL"));
		driver.manage().deleteAllCookies();
	}
}
//
//Q1) checkoutpage2 full not excecuted.
//q2) cross browser is not working
//q3) how to delay the time of each test case exceution.
//q3) when we use void, static void
