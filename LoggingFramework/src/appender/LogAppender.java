package appender;

import model.LogMessage;

public interface LogAppender {
	void append(LogMessage logMessage);
}
