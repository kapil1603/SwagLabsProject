package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;
import utility.ReadData;
public class Loginpage extends Test_Base{
	// obj repository used to indentify the web element
	@FindBy (xpath = "//input[@id = \"user-name\"]") private WebElement usernameTextBox;
	@FindBy (xpath = "//input[@id = \"password\"]") private WebElement passwordTextBox;
	@FindBy (xpath = "//input[@id = \"login-button\"]") private WebElement clickbtn;
	
//	constructor use to initilize the webelement
	public Loginpage() {  
//		this refer to current obj . agar cont. usernameTextBox par work karega tao usko pointout karega.
//		hame har webelemt ke liye separte cont. likhne ji jarurat nahi hai. that's why we use const.
//		this ko call karne ke liye humko page factory class chahiye and eske saath inti method deta hai jo ki element initilize karne mai help karta hai.
	
		PageFactory.initElements(driver, this);
	}
	
	// method to login application
	public String verifyTitleOfApplication(){
		return driver.getTitle();
	}
	
	public String verifyURLofApplication() {
		return driver.getCurrentUrl();
	}
	
	public String LoginToApplication() throws IOException {
// IOException : input output exception , take input from config.properties and give output from this ReadData.readPropertieFile("Username"). esmai problem aata hai humko IOException throw hoga.
		usernameTextBox.sendKeys(ReadData.readPropertieFile("Username"));
		passwordTextBox.sendKeys(ReadData.readPropertieFile("Password"));
		clickbtn.click();
		return driver.getCurrentUrl();		
	}
	

	public String loginToAppWithMutipledata(String un, String pass) {
		usernameTextBox.sendKeys(un);
		passwordTextBox.sendKeys(pass);
		clickbtn.click();
		return driver.getCurrentUrl();
		
	}

}
