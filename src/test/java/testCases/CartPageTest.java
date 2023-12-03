package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Test_Base;
import pages.CartPage;
import pages.InventoryPage;
import pages.Loginpage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class CartPageTest extends Test_Base {
	
	Loginpage login;
	InventoryPage invent;
	CartPage cart;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initilization();
		login = new Loginpage();
		invent = new InventoryPage();
		cart = new CartPage();
		login.LoginToApplication(); 
		invent.verifyNumElementCart();
		invent.clickCartCount();
	}
	
	@Test
	public void VerifyCartURLTest() throws EncryptedDocumentException, IOException {
		String expURL = ReadData.readExcel(7, 2);
		String actURL = cart.VerifyCartURL();
		AssertJUnit.assertEquals(expURL, actURL);
		Reporter.log("Actual Cart = " + actURL);
		
	}
	@Test
	public void VerifyCartTitleTest() throws EncryptedDocumentException, IOException {
		String expTitle = ReadData.readExcel(8, 2);
		String actTitle = cart.VerifyCartTitle();
		AssertJUnit.assertEquals(expTitle, actTitle);
		Reporter.log("Actual Cart = " + actTitle);
	}
	
	@Test
	public void ChechOutBtnTest() {
		cart.ChechOutBtn();
		Reporter.log("CheckOut to shopping Page");
	}
//	@Test
//	public void continueShoppingBtnTest() {
//		cart.continueShoppingBtn();
//		Reporter.log("Come back to shopping Page");
//	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException {
		if (it.FAILURE == it.getStatus()) {
			CaptureScreenshot.screenshot(it.getName());
		}
		driver.close();
	}

}
