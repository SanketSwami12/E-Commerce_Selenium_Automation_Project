package com.mystore.Utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile 
{
	public static FileInputStream inputStream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	
	public static String getcellvalue(String fileName, String sheetName, int rowNo, int cellNo)//- cell no is nothing but column number//
	{
		try
		{
			inputStream =new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputStream);
			excelSheet = workbook.getSheet(sheetName);
			cell = workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
			
			workbook.close();
			return cell.getStringCellValue();
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	public static int getRowCount(String fileName, String sheetName)
	{
		try
		{
			inputStream = new FileInputStream(fileName);
			
			//create XSSFWorkbook Class object for excel file manipulation
			workbook = new XSSFWorkbook(inputStream);
			excelSheet = workbook.getSheet(sheetName);
			
			// get total number of rows
			int totalRows = excelSheet.getLastRowNum() +1;
			workbook.close();
			return totalRows;
		}
		catch (Exception e)
		{
			
		
		return 0;
		}
	}
	
	
	public static int getColCount(String fileName, String sheetName)
	{
		try
		{
			FileInputStream inputStream = new FileInputStream(fileName);
			
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet excelSheet = workbook.getSheet(sheetName);
			
			// get total number of column
			int totalCells = excelSheet.getRow(0).getLastCellNum();
			workbook.close();
			return totalCells;
		}
		
		catch (Exception e)
		{
			return 0;
		}
	}
	}
	
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

