Feature: Login Action

Scenario: Successful Login with Valid Credentials
	Given User navigates to home Page
	When User Entered Username as "test123" and Password as "Aa@123456"
	Then Verify the Login Page
