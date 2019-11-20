package com.atmecs.tutorialsninja.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Configure the log4j file path.
 */
public class LogReport {

	Logger logger = null;

	public LogReport() {
		getlogger();
		logger = Logger.getLogger(LogReport.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator.configure("C:\\Users\\Srinischal.Thiparani\\eclipse-workspace1\\demoaut\\log4j.properties");
	}

	public void info(String message) {
		logger.info(message);
	}
}
