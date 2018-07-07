Feature: Deal data creation

Scenario: Free CRM New deal scenario

Given user is on login page o Free CRM
When the title of the page is Free CRM
Then user enters username and password
| satyaRTest | test123 |
Then user clicks on log in button
Then user mouseover on deals link
Then user clicks on new deal link
Then user enters deal details
| testdeal1 | 1000 | 50 | 10 |
Then close the browser 