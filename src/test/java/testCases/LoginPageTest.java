package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import base.Test_Base;
import pages.Loginpage;
import utility.CaptureScreenshot;
import utility.ReadData;


public class LoginPageTest extends Test_Base{
	
	Loginpage login;
	@BeforeMethod // precondition	
    public void setup() throws InterruptedException, IOException {
		initilization();
		login = new Loginpage();		
	}
	
	@Test (enabled = true, priority = 3, dependsOnMethods = "verifyURLofApplication" )
	public void verifyTitleOfApplication() throws EncryptedDocumentException, IOException {
		String exp_title = ReadData.readExcel(2,2);
		String act_title = login.verifyTitleOfApplication();
		AssertJUnit.assertEquals(exp_title, act_title);
	}
	
	@Test (enabled = true, priority = 1)
	public void verifyURLofApplication() throws EncryptedDocumentException, IOException {
		String exp_URL = ReadData.readExcel(0,2); 
		// imp ......// if we change excel path (0,2) then it dependsOnMethod annotation skip other 2 testcases / method 
	String act_URL = login.verifyURLofApplication();
		AssertJUnit.assertEquals(exp_URL, act_URL);
	}
	
	@Test (enabled = true, priority = 2, dependsOnMethods = "verifyURLofApplication")
	public void loginToAppTest() throws IOException {
		String exp_URL =ReadData.readExcel(3,2); // 3,2
		String act_URL = login.LoginToApplication();
		AssertJUnit.assertEquals(exp_URL, act_URL);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException {
		if (it.FAILURE == it.getStatus()) {
			CaptureScreenshot.screenshot(it.getName());
		}
		driver.close();
	}
	
	
//	console mai prority wise hai but index.html mai nahi hai?
}
