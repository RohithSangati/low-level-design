package model;

import appender.ConsoleAppender;
import appender.LogAppender;

public class LoggerConfig {

	private LogLevel logLevel;
	private LogAppender logAppender;
	
	public LoggerConfig() {
		this.logLevel = LogLevel.INFO;
		this.logAppender = new ConsoleAppender();
	}

	public LogLevel getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
	}

	public LogAppender getLogAppender() {
		return logAppender;
	}

	public void setLogAppender(LogAppender logAppender) {
		this.logAppender = logAppender;
	}

	
	
}
