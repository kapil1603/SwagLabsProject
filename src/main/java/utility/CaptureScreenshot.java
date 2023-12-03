package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.Test_Base;

public class CaptureScreenshot extends Test_Base{
	public static String myDate() {
		return new SimpleDateFormat("dd-MM-YYYY HH-mm-ss").format(new Date());
		
	}
	public static void screenshot(String NameOfMethod) throws IOException {
	  File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File dest = new File("C:\\Users\\kappu\\eclipse-workspace\\SeleniumFramework\\screenshot\\"+NameOfMethod+"-----"+myDate()+".jpeg");
	  FileHandler.copy(source, dest);

	}
}
