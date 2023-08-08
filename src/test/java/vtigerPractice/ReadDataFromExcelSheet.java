package vtigerPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		// Step 1 : Load the File in Java Readable Format.
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		// Step 2 : Create a WorkBook for the File Loaded.
		
		Workbook wb = WorkbookFactory.create(fis);
		
		// Step 3 : Navigate to Required Sheet.
		
		Sheet sh = wb.getSheet("Organization");
		
		// Step 4 : Navigate to Required Row.
		
		Row rw = sh.getRow(1);
		
		// Step 5 : Navigate to Required Cell.
		
		Cell ce = rw.getCell(2);
		
		// Step 6 : Capture the value Inside the Cell.
		
		String value = ce.getStringCellValue();
		System.out.println(value);
	}

}
