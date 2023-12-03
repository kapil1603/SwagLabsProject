package testCases;

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
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.Loginpage;
import utility.ReadData;

public class CheckoutPageTest extends Test_Base {
	
	Loginpage login;
	InventoryPage invent;
	CartPage cart;
	CheckoutPage checkout1;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initilization();
		login = new Loginpage();
		invent = new InventoryPage();
		cart = new CartPage();
		checkout1 = new CheckoutPage();
		login.LoginToApplication(); 
		invent.verifyNumElementCart();
		invent.clickCartCount();
		cart.ChechOutBtn();
	}
	
	@Test
	public void verifyCheckOutTitleTest() throws EncryptedDocumentException, IOException {
		String expCheckOut = ReadData.readExcel(11, 2);;
		String actCheckout = checkout1.verifyCheckOutTitle();
		AssertJUnit.assertEquals(expCheckOut, actCheckout);
		Reporter.log("CheckOut 1= " + actCheckout);
	}
	
	@Test
	public void verifyCheckOutURLTest() throws EncryptedDocumentException, IOException{
		String expURL = ReadData.readExcel(9, 2);
		String actURL = checkout1.verifyCheckOutURL();
		AssertJUnit.assertEquals(expURL, actURL);
		Reporter.log("Actual Cart = " + actURL);
	}
	
	
	@Test
	public void personInfoTest() throws EncryptedDocumentException, IOException {
		String expCheckOut = ReadData.readExcel(10, 2);   // https://www.saucedemo.com/checkout-step-two.html
		String actCheckout = checkout1.personInfo();
		AssertJUnit.assertEquals(expCheckOut, actCheckout);
		Reporter.log("Checkout 2 = " + actCheckout);
		
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}


}
