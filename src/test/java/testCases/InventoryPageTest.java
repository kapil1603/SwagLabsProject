package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Test_Base;
import pages.InventoryPage;
import pages.Loginpage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class InventoryPageTest extends Test_Base {
	
	Loginpage login;
	InventoryPage invent;
//	precondtion mai intilization hona jahiye
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initilization();
//		create initialization and  login page and Inventory Page obj
		login = new Loginpage();	
		invent = new InventoryPage();	
		login.LoginToApplication();
	}

	
//new we have to make test cases
	@Test
	public void VerifyProductLabelTest() throws EncryptedDocumentException, IOException {
		String expLabel = ReadData.readExcel(6,2);  // (6,2)
		String actLabel = invent.VerifyProductLabel();
		AssertJUnit.assertEquals(expLabel, actLabel);
		Reporter.log("Application Label = " + actLabel);
	}
	
	@Test
	public void VerifyTwitterLogoTest() {
		boolean result = invent.VerifyLogo();
		AssertJUnit.assertEquals(result, true);
		Reporter.log("Twitter logo = " + result);
	}
	
	@Test
	public void verifyNumElementCartTest() throws EncryptedDocumentException, IOException {
		String expCount= ReadData.readExcel(4, 2); // 4, 2);
		String actCount = invent.verifyNumElementCart();
		AssertJUnit.assertEquals(actCount, expCount);
		Reporter.log("Cart Items = " + actCount);
	}
	
	@Test
	public void removeToCartTest() throws InterruptedException, EncryptedDocumentException, IOException {
		String expCount= ReadData.readExcel(5, 2);
		String actCount = invent.removeToCart();
		AssertJUnit.assertEquals(actCount, expCount);
		Reporter.log("Remaining Cart Items = " + actCount);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException {
		if (it.FAILURE == it.getStatus()) {
			CaptureScreenshot.screenshot(it.getName());
		}
		driver.close();
	}
	


	
}
