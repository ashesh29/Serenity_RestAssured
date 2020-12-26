package api;

import java.util.List;

import org.junit.Assert;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class EndPoints {
    private EnvironmentVariables variables;
    private String baseURI;    // Store Base Url
    private String usersEndPoint;   // Store User Endpoint
    private String postsEndPoint;   // Store Post Endpoint
    private String commentsEndPoint; // Store Comments Endpoint
    private String message="Status Check Failed!";

    public EndPoints() {
        variables = SystemEnvironmentVariables.createEnvironmentVariables();
        baseURI = variables.getProperty("base.uri");
        usersEndPoint = baseURI + "users";
        postsEndPoint = baseURI + "posts";
        commentsEndPoint = baseURI + "comments";
    }

    /**
     * Method to return userId for given userName
     *
     * @param userName User Name
     * @return UserId for the given userName
     */
    public int getUserId(String userName) {
        Response response = SerenityRest.given().param("username", userName).get(usersEndPoint);
        Assert.assertEquals(message, 200, response.getStatusCode());
        List<Integer> allUsersIds = response.jsonPath().get("id");
        if (allUsersIds.size() == 1) {
            return allUsersIds.get(0);
        } else {
            return -1;
        }
    }

    /**
     * Method to return List of Post ids for given userId
     *
     * @param userId User Id
     * @return PostId for the given userId
     */
    public List<Integer> getUserPosts(int userId) {
        Response response = SerenityRest.given().param("userId", userId).get(postsEndPoint);
        Assert.assertEquals(message, 200, response.getStatusCode());
        return response.jsonPath().get("id");
    }

    /**
     * Method to return List of comment ids for given post id
     *
     * @param postId Post Id
     * @return CommentId for the given postId
     */
    public List<Integer> getPostCommentIds(int postId) {
        Response response = SerenityRest.given().param("postId", postId).get(commentsEndPoint);
        Assert.assertEquals(message, 200, response.getStatusCode());
        return response.jsonPath().get("id");
    }

    /**
     * Method to return list of email ids for given commentId
     *
     * @param commentId Comment Id
     * @return Email ids for the given commentId
     */
    public List<String> getEmailIdsFromComments(int commentId) {
        Response response = SerenityRest.given().param("id", commentId).get(commentsEndPoint);
        Assert.assertEquals(message, 200, response.getStatusCode());
        return response.jsonPath().get("email");
    }

    /**
     * Method to return List of Names for given commentId
     *
     * @param commentId Comment Id
     * @return Names for the given commentId
     */
    public List<String> getNamesFromComments(int commentId) {
        Response response = SerenityRest.given().param("id", commentId).get(commentsEndPoint);
        Assert.assertEquals(message, 200, response.getStatusCode());
        return response.jsonPath().get("name");
    }

    /**
     * Method to return List of comment body for given commentId
     *
     * @param commentId Comment Id
     * @return Body's for the given commentId
     */
    public List<String> getBodysFromComments(int commentId) {
        Response response = SerenityRest.given().param("id", commentId).get(commentsEndPoint);
        Assert.assertEquals(message, 200, response.getStatusCode());
        return response.jsonPath().get("body");
    }

}
