@FunctionalTest
Feature: Free CRM Application testing

@SmokeTest @RegressionTest
Scenario: Log in with correct user name and password
Given valid login test

@RegressionTest
Scenario: Log in with incorrect user name and password
Given invalid login test

@SmokeTest
Scenario: Create a contact
Given This is a contact test case

@SmokeTest @RegressionTest
Scenario: Create a deal
Given This is a deal test case

@RegressionTest
Scenario: Create a task
Given This is a task test case

@SmokeTest
Scenario: Create a case
Given This is a case test case

@SmokeTest
Scenario: Verify leftpanel links
Given Clicking on left panel links

@SmokeTest
Scenario: Search a deal
Given This is a search deal test

@SmokeTest
Scenario: Search a contact
Given This is a search contact test

@SmokeTest @RegressionTest @End2End
Scenario: Search a task
Given This is a search task test

@SmokeTest @RegressionTest @End2End
Scenario: Search a call
Given This is a search call test

@SmokeTest @End2End
Scenario: Search email
Given This is a search email test

@SmokeTest @End2End
Scenario: Search doc
Given This is a search doc test

@SmokeTest @End2End
Scenario: Validate a report
Given This is a report test

@SmokeTest @End2End
Scenario: Application log out
Given This is a log out test

Scenario: Browser close
Given This is a close browser test