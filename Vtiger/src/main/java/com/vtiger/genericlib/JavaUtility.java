package com.vtiger.genericlib;

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

/**
 * This Class will provide all reusable logics which is implemented in this project
 */

public class JavaUtility {
	public int randomNumberGenrate(int num)
	{
		Random r = new Random();
		 return r.nextInt(num);
	}
	
	
	public String genrateDateTime()
	{
		Date d = new Date();
		
		String s=d.toString();
		String[] s1=s.split(" ");
		
		String dateTime=  s1[3]+"-- "+ s1[2] +"-"+s1[1] +"-"+s1[5];
		String formatTime=dateTime.replace(":", "-");
		return formatTime;
		
		 
	}

	@Test
	public void m1()
	{
		System.out.println(genrateDateTime());
	}

}
