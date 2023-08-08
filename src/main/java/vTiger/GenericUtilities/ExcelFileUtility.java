package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class consists of Generic Methods related to Excel File. 
 * @author Bittu Kumar Sharma
 * 
 */

public class ExcelFileUtility {


	/**
	 * This Method will Read Data from Excel Sheet based on Sheet Name,Row Number and Cell Number given by Caller.
	 * @param sheetName
     * @param rowNo
     * @param celNo
     * @return value
     * @throws Throwable
     * @throws IOException
     * 
	 */
	
	
	public String getDataFromExcel(String sheetName, int rowNo, int celNo) throws Throwable, IOException
	{
		FileInputStream fis = new FileInputStream(IConstants.excelfilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		wb.close();
		return value;
		
	}

	
	
	/**
	 * This method will Write Data into Excel Sheet.
	 * @param sheetName 
	 * @param celNo 
	 * @param rowNo 
	 * @param data 
	 * @throws Throwable
	 *  
	 */
	
	public void writeDataIntoExcel(String sheetName, int celNo, int rowNo, String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.excelfilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetName);
		Row rw = sh.createRow(rowNo);
		Cell cl = rw.createCell(celNo);
		cl.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IConstants.excelfilePath);
		wb.write(fos);   // Action
		wb.close();
		
		
	}	
	
	
	/**
	 * 
	 * This method will Read All the Data Inside a Sheet to Use in Data Provider.
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * 
	 */
	
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstants.excelfilePath);
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet(sheetName);
		
		int lastRow = sh.getLastRowNum();                // Capture No. of Rows.
		 
		int lastCell = sh.getRow(0).getLastCellNum();    // Capture the Number of Cells.
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i = 0;i<lastRow;i++)                     // for Row Navigation
		{
			for(int j = 0;j<lastCell;j++)              // For Cell Navigation.
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
}