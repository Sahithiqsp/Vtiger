package com.vtiger.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * This class is used to create reusable method to fetch the data from property file.
 */
public final class PropertyUtility {
	
	/**
	 * This method is used to fetch the data from property file
	 */
	FileInputStream fis;
	public String fetchPropertyfile(String Path,String key) throws Throwable
	{
		if(Objects.isNull(Path)|| Objects.isNull(key))
		{
		  throw new Exception("Check the path and key if it is null");
		}
		
		else
		{
		fis = new FileInputStream(Path);
		
		
		Properties pobj = new Properties();
		
			pobj.load(fis);
		
		String data =pobj.getProperty(key);
		if(Objects.isNull(data))
		{
			throw new Exception("Check the key value entered is wrong");
		}
		else
		{
			return data;
		}
		
	}
	

}
}