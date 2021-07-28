package com.vfislk.com;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenExcelDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("src/test/resources/Driver/OpenEMRData.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(file);
		
		XSSFSheet sheet=book.getSheet("invalidCredentialTest");
		
	   for(int i=0;i<=2;i++)
	   {
		  XSSFRow row=sheet.getRow(i);
		  for(int j=0;j<=3;j++)
		  {
		
		   XSSFCell cell=row.getCell(j);
		
		  DataFormatter format=new DataFormatter();
		  String cellvalue=format.formatCellValue(cell);
		
		  System.out.print(cellvalue+" ");
		}
		 System.out.println();
	   }
	}

}
