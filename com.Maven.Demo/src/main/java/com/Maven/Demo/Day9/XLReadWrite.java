package com.Maven.Demo.Day9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLReadWrite {
	
	public static void readSingleData() throws Exception
	{
		String dirPath=System.getProperty("user.dir");
		System.out.println(dirPath);
		File file=new File(dirPath+"\\Resource\\Book1.xlsx");
		
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Feb2026");
		System.out.println("first row number: "+sheet.getFirstRowNum());
		System.out.println("last row number: "+sheet.getLastRowNum());
		XSSFRow row=sheet.getRow(0);
		System.out.println("first cell number: "+row.getFirstCellNum());
		System.out.println("last last number: "+row.getLastCellNum());
		XSSFCell cell=row.getCell(0);
		if(cell.getCellType()==CellType.STRING)
		{
			System.out.println(cell.getStringCellValue());
		}
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			System.out.println(cell.getNumericCellValue());
		}
		else
		{
			System.out.println("Number Format Exception");
		}
		wb.close();
		fis.close();
		System.out.println("read operation is done...");
	
	}
	
	
	public static void readAllData() throws Exception
	{
		String dirPath=System.getProperty("user.dir");
		File file=new File(dirPath+"\\src\\Resource\\Book1.xlsx");
		
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Feb2026");
		
		Iterator<Row> rows=sheet.rowIterator();
		while(rows.hasNext())
		{
			Row row=rows.next();
			Iterator<Cell> cells=row.cellIterator();
			while(cells.hasNext())
			{
				Cell cell=cells.next();
				
				switch(cell.getCellType()) {
				case STRING: System.out.println(cell.getStringCellValue());
					break;
				case NUMERIC: System.out.println(cell.getNumericCellValue()); 
					break;
				case BOOLEAN: System.out.println(cell.getBooleanCellValue());
					break;
				case FORMULA: System.out.println(cell.getCellFormula());
					break;
				case BLANK: System.out.println("BLANK");
					break;
				default:
					System.out.println("UNKNOWN");
				}
			}
			System.out.println();
		}
	}
	
	public static void writeSingleCellDataToFile() throws Exception
	{
		String sheetName="Feb2026";
	//	int rowIndex=0;
	//	int colIndex=0;
		String data="Java";
		
		String dirPath=System.getProperty("user.dir");
		File file=new File(dirPath+"\\src\\Resource\\Book1.xlsx");
		
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(sheetName);
		Row row=sheet.createRow(0);
		Cell cell=row.createCell(0);
		cell.setCellValue(data);
		fis.close();
		
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		fos.close();
		wb.close();
		System.out.println("End of Program");
		
	}
	
	public static void main(String[] args) throws Exception {
		 readSingleData();
		// readAllData();
		//writeSingleCellDataToFile();
	}

}
