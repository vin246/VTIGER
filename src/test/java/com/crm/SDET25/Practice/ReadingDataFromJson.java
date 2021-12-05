package com.crm.SDET25.Practice;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadingDataFromJson {
	@Test
	public void readDataFromExcel() throws Throwable {
		JSONParser parser = new JSONParser();
		FileReader fr = new FileReader("./data/data.json");
		Object obj = parser.parse(fr);
		JSONObject jObj = (JSONObject) obj;
		System.out.println(jObj.get("designation").toString());		
	}
}
