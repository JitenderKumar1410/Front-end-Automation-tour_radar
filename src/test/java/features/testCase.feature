@tourradar
Feature: Test web appliaction of tourradar

  @contactInformationTest
  Scenario: Test the contact information of application
    Given You are are on a home page
    Then Verify the contact number on the web site
    When Click on the contact number
    Then Verify contact page loaded successfully

  @negativeTestLogin
  Scenario: Test the login functionality of application with wrong credentails
    Given You are are on a home page
    When Click on home and click on Log In button
    Then Wait and verify page load successfully
    Then Enter wrong username and password and try to login
      | username          | password         |
      | jitenderKumar     | tourRadar        |
      | jitenderKumar1410 | tourRadarCompany |
    And Check the visibility of forget password link

  @searchFeature
  Scenario: Test the search box functionality of application
    Given You are are on a home page
    Then Verify the visibility of search box
    And Verfiy the default text coming in search box
    And Click in the search box
    And Enter the place where you want to go like "india"
    When Press "Enter" from the keyboard
    Then Verify for "india" tour page to get loaded successfully

  @sortFeature
  Scenario: Test the functionality of Sort by feature
    Given You are are on a home page
    When Scroll down page to "200" pixel
    Then Check the visibility of sort filter
    And Verify the default value is in sort filter
    And Verify all of the options are correct in dropdown of sort filter
    When Select the "Total price: Lowest first" parameter from the options
    Then Wait for the list to get updated
    And Verify list is updated correctly according to selected parameter

  @filterDepartureDate
  Scenario Outline: Test the functionality of departure date filter
    Given You are are on a home page
    When Scroll down page to "300" pixel
    Then Verify the visibility of departure date
    When Click on "<date>" from the filter
    Then Wait for the list to get updated
    And Verify list is filtered correctly according to "<selected date>" of departure filter

    Examples: 
      | date       | selected date |
      | april-2019 | APR 2019      |
      | may-2019   | MAY 2019      |
