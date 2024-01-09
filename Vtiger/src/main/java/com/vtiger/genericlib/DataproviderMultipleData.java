package com.vtiger.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderMultipleData {
	Object[][] obj;
	DataFormatter df;
	@DataProvider(name="org")
	public Object[][] orgMulData() throws Throwable
	{
		df=new DataFormatter();
		FileInputStream fis= new FileInputStream(Iconstant.excelpath);
		Workbook book= WorkbookFactory. create(fis);
		Sheet sh=book.getSheet("Sheet1");
		int lastRow=sh.getLastRowNum();
		obj=new Object[lastRow][4];
		for(int i=1;i<=lastRow;i++)
		{
			for(int j=0; j<4;j++)
			{
				obj[i-1][j]=df.formatCellValue(sh.getRow(i).getCell(j));
				
			}
		}
		
		return obj;
	}

	@Test(dataProvider="org")
	public void m1(String s1,String s2,String s3,String s4)
	{
		System.out.println(s1+" "+s2+" "+s3+" "+s4);
	}
}
