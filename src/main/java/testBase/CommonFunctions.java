package testBase;

import java.util.List;

import org.junit.Assert;
import org.slf4j.Logger;
import cucumber.TestContext;
import utils.EmailValidation;

public class CommonFunctions {
    protected TestContext testContext;
    protected Logger logger;

    public CommonFunctions() {
        testContext = new TestContext();
        logger = testContext.getLogger();
    }


    /**
     * Method to return userId for given userName
     *
     * @param userName User Name
     */
    protected void searchUserName(String userName) {
        int userId = testContext.getEndPoints().getUserId(userName);
        if (userId > 0) {
            testContext.getCommentsManager().setUserId(userId);
        } else {
            logger.info("UserId not found for given username...");
            Assert.fail();
        }
    }


    /**
     * Method to return Posts for the UserId
     */
    protected void searchPosts() {
        int userId = testContext.getCommentsManager().getUserId();
        List<Integer> userPosts = testContext.getEndPoints().getUserPosts(userId);
        if (!(userPosts.isEmpty())) {
            testContext.getCommentsManager().setUserPosts(userPosts);
        } else {
            logger.info("Posts not found for given userId...");
            Assert.fail();
        }
    }

    /**
     * Method to return Comments for the PostID
     */
    protected void searchCommentsOnPosts() {
        List<Integer> commentIdsOnPosts = testContext.getCommentsManager().getListOfIntegers();
        List<Integer> userPosts = testContext.getCommentsManager().getUserPosts();

        if (!(userPosts.isEmpty())) {
            userPosts.forEach(postId -> commentIdsOnPosts.addAll(testContext.getEndPoints().getPostCommentIds(postId)));
        } else {
            logger.info("Posts not found for given userId...");
            Assert.fail();
        }
        testContext.getCommentsManager().setCommentIdsOnPosts(commentIdsOnPosts);
    }

    /**
     * Method to return Email IDs for the commentId
     */
    protected void getEmailIdsForComments() {
        List<String> emailIdsFromComments = testContext.getCommentsManager().getListOfStrings();
        List<Integer> commentIdsOnPosts = testContext.getCommentsManager().getCommentIdsOnPosts();
        commentIdsOnPosts.forEach(commentId -> emailIdsFromComments.addAll(testContext.getEndPoints().getEmailIdsFromComments(commentId)));
        testContext.getCommentsManager().setEmailIdsFromComments(emailIdsFromComments);
    }

    /**
     * Method to return names for the commentId
     */
    protected void getNamesForComments() {
        List<String> namesFromComments = testContext.getCommentsManager().getListOfStrings();
        List<Integer> commentIdsOnPosts = testContext.getCommentsManager().getCommentIdsOnPosts();
        commentIdsOnPosts.forEach(commentId -> namesFromComments.addAll(testContext.getEndPoints().getNamesFromComments(commentId)));
        testContext.getCommentsManager().setNamesFromComments(namesFromComments);
    }

    /**
     * Method to return Body's for the commentId
     */
    protected void getBodysForComments() {
        List<Integer> commentIdsOnPosts = testContext.getCommentsManager().getCommentIdsOnPosts();
        List<String> bodysFromComments = testContext.getCommentsManager().getListOfStrings();
        commentIdsOnPosts.forEach(commentId -> bodysFromComments.addAll(testContext.getEndPoints().getBodysFromComments(commentId)));
        testContext.getCommentsManager().setBodysFromComments(bodysFromComments);
    }

    /**
     * Method to validate Email Ids
     */
    protected void validateFormatOfEmailIds() {
        List<Integer> invalidEmailIds = testContext.getCommentsManager().getListOfIntegers();
        List<String> emailIdsFromComments = testContext.getCommentsManager().getEmailIdsFromComments();
        emailIdsFromComments.forEach(emailId -> {
            if (!EmailValidation.isValidEmail(emailId)) {
                int commentId = testContext.getCommentsManager().getCommentIdsOnPosts()
                        .get(emailIdsFromComments.indexOf(emailId));
                invalidEmailIds.add(commentId);
            }
        });

        if (!(invalidEmailIds.isEmpty())) {
            logger.info("Below list of commentIds where email addresses are in invalid format..");
            invalidEmailIds.forEach(id -> logger.info(id.toString()));
        }
    }

    /**
     * Method to validate if the field given is empty
     */
    protected void validateIfFieldEmpty(List<String> textToValidate, String text) {
        List<Integer> blankText = testContext.getCommentsManager().getListOfIntegers();
        textToValidate.forEach(textValue -> {
            if (textValue.isEmpty()) {
                int commentId = testContext.getCommentsManager().getCommentIdsOnPosts()
                        .get(textToValidate.indexOf(textValue));
                blankText.add(commentId);
            }
        });

        if (!(blankText.isEmpty())) {
            String comment = "Below list of commentIds where empty " + text + " values are provided...";
            logger.info(comment);
            blankText.forEach(id -> logger.info(id.toString()));
        }
    }


    /**
     * Method to check if the field length is less than given size
     *
     * @param textToValidate text To Validate
     * @param commentLength  Length of the comment
     */
    protected void validateLengthOfCommentField(List<String> textToValidate, int commentLength) {
        List<Integer> blankText = testContext.getCommentsManager().getListOfIntegers();
        textToValidate.forEach(textValue -> {
            if (textValue.length() < commentLength) {
                int commentId = testContext.getCommentsManager().getCommentIdsOnPosts()
                        .get(textToValidate.indexOf(textValue));
                blankText.add(commentId);
            }
        });

        if (!(blankText.isEmpty())) {
            String comment = "Below list of commentIds where length of " + "body" + " is less than " + commentLength + " characters...";
            logger.info(comment);
            blankText.forEach(id -> logger.info(id.toString()));
        }
    }


}
