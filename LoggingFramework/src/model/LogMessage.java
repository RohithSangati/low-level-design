package model;

import java.util.Date;

public class LogMessage {

	private LogLevel logLevel;
	private String logMessage;
	private Date timeStamp;

	public LogMessage(LogLevel logLevel, String logMessage, Date timeStamp) {
		this.logLevel = logLevel;
		this.logMessage = logMessage;
		this.timeStamp = timeStamp;
	}

	public LogLevel getLogLevel() {
		return logLevel;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	@Override
	public String toString() {
		return "LogMessage [logLevel=" + logLevel + ", logMessage=" + logMessage + ", timeStamp=" + timeStamp + "]";
	}

}
