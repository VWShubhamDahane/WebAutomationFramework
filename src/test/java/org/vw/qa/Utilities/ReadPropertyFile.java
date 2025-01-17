package org.vw.qa.Utilities;


import org.vw.qa.Enum.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;



public class ReadPropertyFile {

	private ReadPropertyFile() {

	}

	private static Properties prop = new Properties();

// Static block for maintain common item  
	static {

		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/Configuration/Config.properties");
				prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
		}

	}

	public static String getValue(String key) throws Exception {
		if (Objects.isNull(prop.getProperty(key).trim()) || Objects.isNull(key)) {
			throw new Exception("Property name" + key + "Please check Config.properties");
		}
		return prop.getProperty(key);

	}


}
