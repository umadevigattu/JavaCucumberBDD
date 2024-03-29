package com.application.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.application.constants.Constants;

public class BaseTest {

	protected static WebDriver driver;

	public static Properties properties;
	BufferedReader reader;
	
	public BaseTest() {

		try {
			reader = new BufferedReader(new FileReader(Constants.TestData_Path));
			properties = new Properties();
			try {
				properties.load(reader);
				properties.getProperty("username");
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + Constants.TestData_Path);
		}

	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public static WebDriver instance() {

		return driver;

	}

	
}
