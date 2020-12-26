@Test
Feature: To validate the comments for the post made by specific user

  Scenario Outline: To validate if emails in the comment section are in the proper format
    Given User obtains userId by searching the username "<userName>"
    And Gets all the posts written by the user using userId
    When User gets all the comments for the posts made by user
    Then User should validate that email in the comment section is in the proper format

    Examples:
      | userName |
      | Delphine |
      | Bret     |
      | Karianne |

  Scenario Outline: To validate if name in the comment is not empty
    Given User obtains userId by searching the username "<userName>"
    And Gets all the posts written by the user using userId
    When User gets all the comments for the posts made by user
    Then User should validate that name in the comment section are not empty

    Examples:
      | userName |
      | Delphine |
      | Bret     |
      | Karianne |

  Scenario Outline: To validate if body in the comment is not empty
    Given User obtains userId by searching the username "<userName>"
    And Gets all the posts written by the user using userId
    When User gets all the comments for the posts made by user
    Then User should validate that text body in the comment section is not empty

    Examples:
      | userName |
      | Delphine |
      | Bret     |
      | Karianne |

  Scenario Outline: To validate if length of body in the comment is not less than given characters
    Given User obtains userId by searching the username "<userName>"
    And Gets all the posts written by the user using userId
    When User gets all the comments for the posts made by user
    Then User should validate that the length of text body in the comment is not less than <commentLength> characters

    Examples:
      | userName | commentLength |
      | Delphine | 50            |
      | Bret     | 50            |
      | Karianne | 50            |