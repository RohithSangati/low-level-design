import appender.DatabaseAppender;
import appender.FileAppender;
import model.LogLevel;
import model.Logger;

class LogginApplication {

	public static void main(String[] args) {

		Logger logger = Logger.getLoggerInstance();

		logger.info("This is info log");
		logger.debug("This is debug log");

		logger.setLoglevel(LogLevel.ERROR);
		logger.setLogAppender(new FileAppender());

		logger.info("This is info log");
		logger.debug("This is debug log");
		logger.fatal("This is fatal log");
		logger.error("This is error log");
		
		logger.setLoglevel(LogLevel.DEBUG);
		logger.setLogAppender(new DatabaseAppender());
		
		logger.info("This is info log");
		logger.debug("This is debug log");
		logger.fatal("This is fatal log");
		logger.error("This is error log");

	}

}