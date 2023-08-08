package vtigerPractice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest 

{
   @Test
   public void read()
   {
	   String UN = System.getProperty("Username");
	   System.out.println(UN);
	   
	   String PWD = System.getProperty("Password");
	   System.out.println(PWD);
   }

}
