package appender;

import model.LogMessage;

public class DatabaseAppender implements LogAppender {

	@Override
	public void append(LogMessage logMessage) {
		System.out.println(logMessage.toString() + " - Log added to the Data base");
	}

}
