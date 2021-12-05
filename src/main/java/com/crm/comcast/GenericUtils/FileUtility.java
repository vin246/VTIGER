package com.crm.comcast.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/***
 * 
 * @author Vinay_Dasari
 *
 */
public class FileUtility {
	/**
	 * This method is used to get the values from property file
	 * @param key
	 * @return
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key)  {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(IPathConstants.PROPERTYFILE_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return  p.getProperty(key);
	}
}
