package vtigerPractice;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	
	public static void main(String[] args) throws Throwable {
		
		JavaUtility jUtil = new JavaUtility();
		
		int value = jUtil.getRandomNumber();
		System.out.println(value);
		
		System.out.println(jUtil.getSystemDate());
		
		System.out.println(jUtil.getSystemDateInFormat());
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value1 = pUtil.getDataFromPropertyFile("password");
		System.out.println(value1);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.getDataFromExcel("Organization", 1, 2);
		System.out.println(data);
		
		eUtil.writeDataIntoExcel("sample", 3, 4, "BatMan");
		System.out.println("Data Added");
		
	}
	
}
