package com.crm.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * @author dk
	 * this method is used to fetch the data from property file
	 * @param key
	 * @return type is String because its return data from String
	 * @throws IOException
	 */
public String getDataFromPropertyFile(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata/commondata.properties");
	Properties pro=new Properties();
	pro.load(fis);
	return pro.getProperty(key);
}
}
