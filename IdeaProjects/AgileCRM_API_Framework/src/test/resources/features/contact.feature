Feature: Verify Contact Functionality

  @CreateContactsFeatureSerialization
  Scenario Outline: Verify Create Contact Feature using serialization

    Given I create request structure to create contacts using Serialization
      | type   | star_value   | lead_score   | tags   | first_name   | last_name   | email   | phone   | statusCode   |
      | <type> | <star_value> | <lead_score> | <tags> | <first_name> | <last_name> | <email> | <phone> | <statusCode> |

    When I hit an api
      | endpoint   | contacts |
      | pathParam  |          |
      | httpMethod | POST     |


    Then I verify the contacts is created successfully by using serialization concept using "<statusCode>"

    Examples:

      | type   | star_value | lead_score | tags        | first_name | last_name | email                    | phone      | statusCode |
      | SYSTEM | 1          | 79         | smoke,rocky | Heetarth101   | Jawade    | heetarth000@hotmail.com | 9011002234 | 200        |


  @GetContact
  Scenario Outline: Verify get Contact api
    Given I prepare request structure to get the contact

    When I hit an api
      | endpoint   | contacts    |
      | pathParam  | <pathParam> |
      | httpMethod | GET         |

    Then I verify the contact information using "<pathParam>" and status code should be <statusCode>
      | valid | <valid> |

    Examples:

      | pathParam        | valid | statusCode |
      | 6673417399238656 | true  | 200        |
      | null             | true  | 200        |
      |                  | true  | 200        |
      | 6600007399000056 | false | 204        |
      | @#$%^&*          | false | 400        |
      | invalidstring    | false | 400        |


  @GetContactList
  Scenario: Verify get Contact api for List
    Given I prepare request structure to get the contact

    When I hit an api
      | endpoint   | contacts |
      | pathParam  |          |
      | httpMethod | GET      |

    Then I verify the contact List and status code should be 200

  @UpdateContactProperties
  Scenario Outline: verify Update properties of a contact by ID (partial update)
    Given I create request structure to update properties of a contacts by ID using Serialization
      | Id   | type   |  | first_name   | last_name   | email   | phone   | statusCode   |
      | <Id> | <type> |  | <first_name> | <last_name> | <email> | <phone> | <statusCode> |

    When I hit an api
      | endpoint   | contacts        |
      | pathParam  | edit-properties |
      | httpMethod | PUT             |
    Then I verify the Update properties of a contact by ID and status code should be 200

    Examples:
      | Id               | type   | first_name    | last_name   | email                     | phone      | statusCode |
      | 4790182507511808 | SYSTEM | HeetarthChuku | ManojJawade | heetarth10001@hotmail.com | 9011111111 | 200        |

  @UpdateLeadScore
  Scenario: verify Update lead score by ID
    Given I create request structure to update lead score is 19
      | Id | 6328802129281024 |
    When I hit an api
      | endpoint   | contacts        |
      | pathParam  | edit/lead-score |
      | httpMethod | PUT             |
    Then I verfiy the Update lead score 19 and status code should be 200

  @UpdateStarValue
  Scenario: verify Update Star value by ID
    Given I create request structure to update star value is 1
      | Id | 6328802129281024 |
    When I hit an api
      | endpoint   | contacts      |
      | pathParam  | edit/add-star |
      | httpMethod | PUT           |
    Then I verfiy the Update star value 1 and status code should be 200

  @UpdateTagsValue
  Scenario: verify Update Tags value by ID
    Given I create request structure to update tags value
      | Id               | tags              |
      | 6328802129281024 | Regression,Sanity |
    When I hit an api
      | endpoint   | contacts  |
      | pathParam  | edit/tags |
      | httpMethod | PUT       |
    Then I verfiy the Update tags and status code should be 200

  @DeleteTagsValue
  Scenario: verify Delete Tags value by ID
    Given I create request structure to delete tags value
      | Id               | tags   |
      | 6328802129281024 | Sanity |
    When I hit an api
      | endpoint   | contacts    |
      | pathParam  | delete/tags |
      | httpMethod | PUT         |
    Then I verfiy the Delete tags and status code should be 200


  @DeleteSingleContact
  Scenario: verify the delete single contact by ID
    Given I create request structure to delete single contact

    When I hit an api
      | endpoint   | contacts/5957607684898816 |
      | pathParam  |                           |
      | httpMethod | DELETE                    |
    Then I verfiy the Delete single contacts and status code should be 204
