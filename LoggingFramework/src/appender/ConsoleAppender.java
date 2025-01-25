package appender;

import model.LogMessage;

public class ConsoleAppender implements LogAppender {

	@Override
	public void append(LogMessage logMessage) {
		System.out.println(logMessage.toString() + "- Log added to the console");
	}

}
