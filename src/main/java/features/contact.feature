Feature: Free CRM New Contact creation

Scenario Outline: Free CRM New Contact creation and validation

Given user is on login page
#When the title of the page is Free CRM
Then user enters "<username>" and "<password>"
Then user mouseover on contacts link
Then user clicks on new conatct link
Then user enters conatact details "<firstname>" and "<lastname>" and "<postion>"
Then user clicks on save button
Then verify new conact created 

Examples:
	| username | password | firstname | lastname | postion |
	| satyaRtest | test123 | user11fn | user11ln | Manager |
	| Tom | test123 | user12fn | user12ln | Director |