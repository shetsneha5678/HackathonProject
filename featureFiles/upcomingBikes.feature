Feature: UpcomingBikes
	@regression @master
	Scenario: New Bikes option is displayed
		Given the user is in zigwheel homepage
		When the user able to see New bikes option
		Then the user should hover mouse over newBikes option
		When the user able to see upcoming bikes option
		Then the user clicks on upcoming bike
		When the user able to see dropdown
		And the user clicks on honda option from dropdown
		And the user can see read more option 
		And the user can see table with list of bikes
		Then the user can see the list in console