package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown {
//	variable stored in ele and option are stored into value	
	public static void dropDownClass(WebElement ele,String value) {
//		eske liye hum 2 argument pass karange
		Select s = new Select(ele);
		s.selectByVisibleText(value);
	}

}
