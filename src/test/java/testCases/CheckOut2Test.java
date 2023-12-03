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
import pages.CheckOut2;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.Loginpage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class CheckOut2Test extends Test_Base {
	
	Loginpage login;
	InventoryPage invent;
	CartPage cart;
	CheckoutPage checkout1;
	CheckOut2 check2;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initilization();
		login = new Loginpage();
		invent = new InventoryPage();
		cart = new CartPage();
		checkout1 = new CheckoutPage();
		check2  = new CheckOut2();
		login.LoginToApplication(); 
		invent.verifyNumElementCart();
		invent.clickCartCount();
		cart.ChechOutBtn();
		checkout1.personInfo();
	}
	
	@Test
	public void checkout2Titlepage() throws EncryptedDocumentException, IOException {
		String expCheckOut = ReadData.readExcel(12, 2);;
		String actCheckout = check2.checkout2Titlepage();
		AssertJUnit.assertEquals(expCheckOut, actCheckout);
		Reporter.log("CheckOut 2= " + actCheckout);
	}
	
	@Test
	public void inventory_item_name1pageTest() throws EncryptedDocumentException, IOException {
		String expCheckOut = ReadData.readExcel(13, 2);;
		String actCheckout = check2.inventory_item_name1page();
		AssertJUnit.assertEquals(expCheckOut, actCheckout);
		Reporter.log("CheckOut 2= " + actCheckout);
	}
	@Test
	public void clickFinishBtnTest() {
		Reporter.log("Finish button");
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException {
		if (it.FAILURE == it.getStatus()) {
			CaptureScreenshot.screenshot(it.getName());
		}
		driver.close();
	}


}
