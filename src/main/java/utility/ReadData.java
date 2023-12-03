package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {
	
//  ek method liya (readpropertyfile) us method ko public declare kiya. public is used bcz we have use that data through out the framework. and es data ko kisi bhi class mai excess kar sakte hai.
//	basically public is excess specifier which define the scope of the object/method
//	static is used, muje ReadData class ka obj create karke readpropertyfile ko access nahi karna hai. muje directly readpropertyfile ko access karna hai. bcz static method directly belong to the class.
//	static used bcz humko data change nahi karna hai. 
//	static rahega to class (readdata) ka obj create karne ke jarurat nahi. From static we can directly belong to the class. static se we can directly access to the class or uske method *****
	                     // yaha ek parameter pass karenge.
	public static String readPropertieFile(String Value) throws IOException {
//		properties is predefined class and we have to create obj of properties i.e. prop.
		Properties prop = new Properties();
//		fileinputstream use kiya which help to read the file. then create the obj of fileinputstream ie file . and give path of the file.
		FileInputStream file = new FileInputStream("C:\\Users\\kappu\\eclipse-workspace\\SeleniumFramework\\TestData\\Config.properties");
//		load method help to load the file
		prop.load(file);		
		return prop.getProperty(Value);
//interview question.     kon kon se exception framework mai use kiya hai.		
	}
	
	public static String readExcel(int rownum, int colnum) throws EncryptedDocumentException, IOException {
		FileInputStream file1 = new FileInputStream("C:\\Users\\kappu\\eclipse-workspace\\SeleniumFramework\\TestData\\Book1.xlsx");
		Sheet excelFile = WorkbookFactory.create(file1).getSheet("Sheet1");
		String value = excelFile.getRow(rownum).getCell(colnum).getStringCellValue();
		return value;
		
	}

}
