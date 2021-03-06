package com.vfislk.utils;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExcelUtils {
	
	public static Object[][] getSheetIntoObjectArray(String fileDetail,String sheetName) throws IOException
	{
		FileInputStream file=null;
		XSSFWorkbook book=null;
		Object[][] main=null;
		try
		{
			file = new FileInputStream(fileDetail);
			
			 book = new XSSFWorkbook(file); 
			XSSFSheet sheet = book.getSheet(sheetName);	
			int rowCount=sheet.getPhysicalNumberOfRows();	
			int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
			
			DataFormatter format = new DataFormatter();
			
			main=new Object[rowCount-1][cellCount];
			
			for (int r = 1; r < rowCount; r++) 
			{
				XSSFRow row = sheet.getRow(r);
				for (int c = 0; c < cellCount; c++) 
				{		
					XSSFCell cell = row.getCell(c);		
					main[r-1][c]=format.formatCellValue(cell);;
				}
			}

			
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			//or
			//throw e;
		}
		finally {
			book.close();
			file.close();
		}
		return main;
	}

}