Feature: E2E Scenarios


  Scenario : To validate all the HTTP methods are working as expected
    Given User wants to validate all the Http methods
    When User creates the new post using POST methods
    Then User should be able to get the record of the post using GET method
    And User should be able to update the record of the post using PUT method
    And User should be able to update the record of the post using PATCH method
    And User should be able to delete the record of the post using DELETE method


  Scenario : Get all the Posts
    Given User wants to get all the Posts
    When User hits the posts endpoint
    Then User should be able to get all the existing posts


  Scenario Outline: Get the Posts for existing UserId
    Given User wants to get post for existing UserId
    When User hits the posts endpoint for <UserId>
    Then User should be able to get the post for the <UserId>

    Examples:
      | UserId |
      | 1      |
      | 2      |


  Scenario Outline: Get all the Comments of the existing UserId
    Given User wants to get all the comments of the existing UserId
    When User hits the comments endpoint for <UserId>
    Then User should be able to get all comments for the <UserId>

    Examples:
      | UserId |
      | 1      |
      | 2      |


  Scenario Outline: Get all the Comments of the existing PostId
    Given User wants to get all the comments of the existing PostId
    When User hits the comments endpoint for <PostId>
    Then User should be able to get all comments for the <PostId>

    Examples:
      | PostId |
      | 1      |
      | 2      |


  Scenario Outline: Get all the Photos of the existing AlbumId
    Given User wants to get all the Photos of the existing AlbumId
    When User hits the photos endpoint for <AlbumId>
    Then User should be able to get all photos for the <AlbumId>

    Examples:
      | AlbumId |
      | 1       |
      | 2       |


  Scenario Outline: Get all the Albums of the existing UserID
    Given User wants to get all the Albums of the existing UserID
    When User hits the Albums endpoint for <UserID>
    Then User should be able to get all Albums for the <UserID>

    Examples:
      | UserID |
      | 1      |
      | 2      |


  Scenario Outline: Get all the Todos of the existing UserID
    Given User wants to get all the Todos of the existing UserID
    When User hits the Todos endpoint for <UserID>
    Then User should be able to get all Todos for the <UserID>

    Examples:
      | UserID |
      | 1      |
      | 2      |


