package cucumber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import api.EndPoints;
import testBase.CommonFunctions;
import utils.CommentsManager;

public class TestContext {
	private EndPoints endPoints;
	private CommentsManager commentsManager;
	private Logger logger;

	public TestContext() {
		commentsManager = new CommentsManager();
		endPoints = new EndPoints();
		logger = LoggerFactory.getLogger(CommonFunctions.class);
	}

	public EndPoints getEndPoints() {
		return endPoints;
	}

	public CommentsManager getCommentsManager() {
		return commentsManager;
	}

	public Logger getLogger() {
		return logger;
	}

}
