Feature: Free CRM Login Feature

#without examples keyword
#Scenario: Free CRM Login test Scenario

#Given User is already is on Login Page 
#When title of Login Page is Free CRM
#Then user enters username and user enters password
#Then user enters "satyaRtest" and user enters "test123"
#Then user clicks on Login button
#Then user is on home page for first scenario
#Then close the browser


#with examples keyword
Scenario Outline: Free CRM Login test Scenario

Given User is already is on Login Page 
When title of Login Page is Free CRM
#Then user enters username and user enters password
Then user enters "<username>" and user enters "<password>"
Then user clicks on Login button
Then user is on home page for first scenario
#Then close the browser

Examples:
	| username | password |
	| satyaRtest | test123 |
	| Tom | test123 |