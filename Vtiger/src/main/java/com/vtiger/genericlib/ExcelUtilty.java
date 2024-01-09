package com.vtiger.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilty {

	FileInputStream fis;
	Workbook book;
	DataFormatter df;
	public String fetchSingleDataFromExcel(String path,String sheetName,int row,int cell) throws Throwable
	{
		
		df= new DataFormatter();
		
			fis=new FileInputStream(path);
		
			book=WorkbookFactory.create(fis);
		
		 
		return df.formatCellValue(book.getSheet(sheetName).getRow(row).getCell(cell));
		
	}
	
	public List<Object> fetchDataInRowWise(String path,String sheetName) throws Throwable
	{
		List<Object> mulRowData=new ArrayList<Object>();
		df= new DataFormatter();
		
			fis=new FileInputStream(path);
		
			book=WorkbookFactory.create(fis);
	
		
		 Sheet sh=book.getSheet(sheetName);
		
		for(int i=0;i<fetchLastRow(path, sheetName);i++)
		{
			String data=df.formatCellValue(sh.getRow(i).getCell(0));
			mulRowData.add(data);
		}
		
		return mulRowData;
		
	}
	
	public void fetchDataInCellWise()
	{
		
	}
	
	public int fetchLastRow(String path,String sheetName)
	{
		try {
			fis=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sh = book.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		return lastRow;
		
	}
	public void fetchLastCellWise()
	{
		
	}
}
