package vtigerPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {
	
	public static void main(String[] args) throws IOException {
		
		// Step 1 : Load the Document in Java Readable Format
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		
		// Step 2 : Create Object of Properties Class from java.util
		
		Properties pObj = new Properties();
		
		
		// Step 3 : Load the File into Properties Class
		
		pObj.load(fis);
		
		
		// Step 4 : Provide the Key & Get the Value
		
		String value = pObj.getProperty("url");
		System.out.println(value);
	}

}
