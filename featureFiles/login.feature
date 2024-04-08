Feature: User Login
	@smoke @master
  Scenario: UnSuccessful Login
    Given the user opens zigwheels site
    And the user navigates to ZigWheels login page
    When the user clicks on sign in with Google
    And the user enters the invalid email id
    And the user clicks next
    Then the user should see error on the login page
