package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
	 * This Class Consists of Generic Methods Related To Property File
	 * @author Bittu Kumar Sharma
	 * 
	 */

public class PropertyFileUtility {
	
	/**
	 * This Method Reads Data From Property File on Given Key.
	 * @param key
	 * @return value
	 * @throws Throwable 
	 */
	
	public String getDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
			
	}

}
