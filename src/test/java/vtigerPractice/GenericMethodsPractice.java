package vtigerPractice;

public class GenericMethodsPractice {
	
	public static void main(String[] args) {  // Caller
		
		int result = add(28,10);
		System.out.println(result);
	}
	
	public static int add(int a, int b)   // Called Method - Generic 
	{
		int c = a+b;
		return c;
	}
	


}
