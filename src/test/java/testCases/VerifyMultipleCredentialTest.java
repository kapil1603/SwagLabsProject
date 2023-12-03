package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Test_Base;
import pages.Loginpage;
import utility.CaptureScreenshot;

public class VerifyMultipleCredentialTest extends Test_Base{
	
	Loginpage login;
	@BeforeMethod // precondition	
    public void setup() throws InterruptedException, IOException {
		initilization();
		login = new Loginpage();		
	}
	 
	@Test (dataProvider = "credentials")
	public void loginToAppWithMutipledataTest(String un,String pass) throws IOException {
		SoftAssert s = new SoftAssert();
		String exp_URL ="https://www.saucedemo.com/inventory.html";// ReadData.readExcel(3,2); // 3,2
		String act_URL = login.loginToAppWithMutipledata(un,pass);
		s.assertEquals(exp_URL, act_URL);
		s.assertAll();
	}
	
	@DataProvider (name="credentials")
	public Object [] [] getData(){
		return new Object [] []{
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"}
		};
		
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException {
		if (it.FAILURE == it.getStatus()) {
			CaptureScreenshot.screenshot(it.getName());
		}
		driver.close();
	}
	

}
