package com.crm.genericUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	/**
	 * @author dk
	 * this method is used to fetch the common data from json file
	 * @param key
	 * @return type is String because its return data from json file
	 * @throws IOException
	 * @throws ParseException
	 */
public String getDtaFromJsonFile(String key) throws IOException, ParseException {
	//first give the json file path to FileReader
	FileReader file=new FileReader("./src/main/resources/commondata/jsoncommondata.json");
	
	//create JSONParser object and using this reference variable call non static method parse
	JSONParser parser=new JSONParser();
	
	//pass the file reference inside parse(file) method ,it's return java object 
	Object obj = parser.parse(file);
	
	//downcast java object to JSONObject it's return JSONObject 
	//JSONObject behave like hasMap its store a data in key and values pairs 
	JSONObject map=(JSONObject)obj;
	  String data=(String) map.get(key);
	  //String data1=map.get(key).toString();
	
	return data;		
}
}
