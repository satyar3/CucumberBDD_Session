Feature: Deal data creation 

Scenario: Free CRM New deal scenario 

	Given user is on login page of Free CRM 
	When the title of the page is Free CRM 
	Then user enters username and password 
		| username | password |
		| satyaRTest | test123 |
	Then user clicks on log in button 
	Then user mouseover on deals link 
	Then user clicks on new deal link 
	Then user enters deal details 
		| title 	| amount | probablity | comission |
		| testdeal3 | 3000 | 70 | 30 |
		| testdeal4 | 4000 | 80 | 40 |
		| testdeal5 | 5000 | 90 | 50 |
	Then close the browser 