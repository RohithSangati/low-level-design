package model;

import java.util.Date;

import appender.LogAppender;

public class Logger {

	private static Logger loggerInstance;

	private final LoggerConfig loggerConfig;

	private Logger() {
		this.loggerConfig = new LoggerConfig();
	}

	public static Logger getLoggerInstance() {
		if (loggerInstance == null) {
			synchronized (Logger.class) {
				loggerInstance = new Logger();
			}
		}
		return loggerInstance;
	}

	public void log(LogLevel logLevel, String logMessage) {
		if (this.loggerConfig.getLogLevel().ordinal() <= logLevel.ordinal()) {
			LogMessage log = new LogMessage(logLevel, logMessage, new Date());
			this.loggerConfig.getLogAppender().append(log);
		}
	}

	public void debug(String logMessage) {
		this.log(LogLevel.DEBUG, logMessage);
	}

	public void info(String logMessage) {
		this.log(LogLevel.INFO, logMessage);
	}

	public void warning(String logMessage) {
		this.log(LogLevel.WARNING, logMessage);
	}

	public void error(String logMessage) {
		this.log(LogLevel.ERROR, logMessage);
	}

	public void fatal(String logMessage) {
		this.log(LogLevel.FATAL, logMessage);
	}

	public void setLoglevel(LogLevel logLevel) {
		this.loggerConfig.setLogLevel(logLevel);
	}

	public void setLogAppender(LogAppender appender) {
		this.loggerConfig.setLogAppender(appender);
	}

}
