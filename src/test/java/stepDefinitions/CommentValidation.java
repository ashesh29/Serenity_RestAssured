package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testBase.CommonFunctions;

public class CommentValidation extends CommonFunctions {

    @Given("User obtains userId by searching the username {string}")
    public void User_obtains_userId_by_searching_the_username(String userName) {
        searchUserName(userName);
    }

    @Given("Gets all the posts written by the user using userId")
    public void  Gets_all_the_posts_written_by_the_user_using_userId() {
        searchPosts();
    }

    @When("User gets all the comments for the posts made by user")
    public void User_gets_all_the_comments_for_the_posts_made_by_user() {
        searchCommentsOnPosts();
    }

    @Then("User should validate that email in the comment section is in the proper format")
    public void User_should_validate_that_email_in_the_comment_section_is_in_the_proper_format() {
        getEmailIdsForComments();
        validateFormatOfEmailIds();
    }

    @Then("User should validate that name in the comment section are not empty")
    public void User_should_validate_that_name_in_the_comment_section_are_not_empty() {
        getNamesForComments();
        validateIfFieldEmpty(testContext.getCommentsManager().getNamesFromComments(), "name");
    }

    @Then("User should validate that text body in the comment section is not empty")
    public void User_should_validate_that_text_body_in_the_comment_section_is_not_empty() {
        getBodysForComments();
        validateIfFieldEmpty(testContext.getCommentsManager().getBodysFromComments(), "body");
    }

    @Then("User should validate that the length of text body in the comment is not less than {int} characters")
    public void User_should_validate_that_the_length_of_text_body_in_the_comment_is_not_less_than_characters(int commentLength) {
        getBodysForComments();
        validateLengthOfCommentField(testContext.getCommentsManager().getBodysFromComments(), commentLength);
    }

}
