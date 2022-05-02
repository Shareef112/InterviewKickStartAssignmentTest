@API @findJobs
Feature: Validation of Student Job Search API

  Scenario Outline: Validation Find Jobs Api
    Given User executed the FindJobs api with <api_request>
    Then User Should see 200 response code in the status
    And User should validate the response as per the request
    Examples:
      | api_request                           |
      | ""                                    |
      | "location:Hyderabad"                  |
      | "companyName:xyz"                     |
      | "companyName:ABC&&location:Hyderabad" |

  Scenario Outline: Validation Find Jobs Api
    Given User executed the FindJobs api with <api_request>
    Then User Should see 417 response code in the status
    And User should validate the error response as per the request
    Examples:
      | api_request                           |
      | "studentId:125"                                    |
      | "location:Vizag"                  |
