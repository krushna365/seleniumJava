package com.qf.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

		public static String readDataFromProperty(String key) throws IOException {
			String userDir = System.getProperty("user.dir");
			String filePath = userDir + "/src/test/resources/TestData/Config.properties";
			FileInputStream fis=new FileInputStream(filePath);
			Properties prop=new Properties();
			prop.load(fis);
			return prop.getProperty(key);
		}
		
}

