package vtigerPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {
	
	public static void main(String[] args) throws IOException {
		
		// Step 1 : Load the File in Java Readable Format
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		
		// Step 2 : Create a WorkBook for the File Loaded.
		
		Workbook wb = WorkbookFactory.create(fis);
		
		
		// Step 3 : Create Sheet.
		
		Sheet sh = wb.createSheet("Trial");
		
		
		// Step 4 : Create Row.
		
		Row rw = sh.createRow(4);
		
		
		// Step 5 : Create Cell.
		
		Cell ce = rw.createCell(3);
		
		
		// Step 6 : Set the Value into the Cell.
		
		ce.setCellValue("Spider Man");
		
		
		// Step 7 : Open the File in Java Write Format.
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		
		// Step 8 : Call the Write Method.
		
		wb.write(fos);
		System.out.println("Data Added");
		
		
		// Step 9: Close the WorkBook.
		
		wb.close();
		System.out.println("WorkBook Closed");
		
	}

}
