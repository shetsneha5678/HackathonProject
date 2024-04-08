Feature: Used Cars in chennai
	@master @regression
  Scenario: Clicking Used Cars
   	Given I am opening zigwheels WebSite
    When I am able to see the used car option
    And I am hovering over used car option
    And I am able to see chennai option 
    And I am clicking on chennai option displayed
    Then I am navigated to new page for used cars 
   	When I am able to see the read more option
   	And I am clicking on read more option
   	Then I am able to see the model