package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.Test_Base;

public class CheckoutPage extends Test_Base{
	
//	create obj repo
	
	@FindBy (xpath = "//input[@id=\"first-name\"]") private WebElement firstName;
	@FindBy (xpath = "//input[@id=\"last-name\"]") private WebElement lastName;
	@FindBy (xpath = "//input[@id=\"postal-code\"]") private WebElement postalCode;
	@FindBy (xpath = "//input[@id=\"continue\"]") private WebElement continues;
	@FindBy (xpath = "//span[@class=\"title\"]") private WebElement checkoutTitle;
	
	public  CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckOutTitle() {
		return checkoutTitle.getText();	
	}
	
	public String verifyCheckOutURL() {
		return driver.getCurrentUrl();	
	}
	
	public String personInfo() {
		firstName.sendKeys("Kapil");
		lastName.sendKeys("Kumar");
		postalCode.sendKeys("201001");
		continues.click();
//		return mai muje click karne ke baad jo next page aayega uska url ie checkout page 2.
		return driver.getCurrentUrl();	
	}
}
