package com.atmecs.tutorialsninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadLocatorsFile {
    static Properties properties;
    static FileReader reader;
    static File file;
	public static String readPropertiesFile(String elements, String path) throws IOException {

		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(path);
		try {
			prop.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String data = prop.getProperty(elements);
		return data;

	}
	public static String getData(String elements, String path) throws IOException {

		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(path);
		try {
			prop.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String data = prop.getProperty(elements);
		return data;
}
	public static Properties readData(String filePath) {
		properties = new Properties();
		file = new File(filePath);
		try {
		reader = new FileReader(file);
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		}
		try {
		properties.load(reader);
		} catch (IOException e) {
		e.printStackTrace();
		}
		return properties;

	}
}
