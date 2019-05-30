package com.xuehai.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	private Logger log;

	static {
		PropertyConfigurator.configure("src/main/resources/config/log4j.properties");
	}

	public Log(Class<?> clazz) {
		log=Logger.getLogger(clazz);
	}

	public void info(String message) {
		log.info(message);
	}

	public void debug(String message) {
		log.debug(message);
	}

	public void warn(String message) {
		log.warn(message);
	}

	public void error(String message) {
		log.error(message);
	}

	public void error(String message, Throwable t) {
		log.error(message, t);
	}

}
