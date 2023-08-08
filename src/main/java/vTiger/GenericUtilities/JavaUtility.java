package vTiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This Class Consists of all Generic Methods Related to Java.
 * @author Bittu Kumar Sharma 
 *
 */

public class JavaUtility {
	
	/**
	 * This Method will Generate a Random Number for Every Execution.
	 * @return Random Value 
	 */
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	
	
	/**
	 * This method will Generate System Date.
	 * @return Date
	 */
	
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	
	/**
	 * This Method will Generate the System Date in Specific Format.
	 * @return Current System Date
	 */
	
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String[] date = d.toString().split(" ");
		String currentdate = date[2];
		String month = date[1];
		String year = date[5];
		String time = date[3].replace(":","-");
		
		String dateInFormat = currentdate+"_"+month+"_"+year+"_"+time;
		return dateInFormat;
	}

}
