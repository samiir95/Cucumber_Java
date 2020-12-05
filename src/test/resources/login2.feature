Feature: Login functionality

		In order to do internet banking
		As a valid para bank customer
		I want to login successfully
		
#Scenario: Login successful
#
#Given I am in the login page of the Para Bank Application
#When I enter valid credentials
#Then I should be taken to the overview page 


#Scenario: Login successful
#
#Given I am in the login page
#When I enter valid credentials
#Then I should be taken to the overview page 

#Scenario Outline: Login successful
#
#Given I am in the login page of the Para Bank Application
#When I enter valid <username> and <password>
#Then I should be taken to the overview page
#
#Examples:
#		|username|password|
#		|"autotester"|"password"|
#		|"tautester"|"password"|


#Scenario: Login successful
#
#Given I am in the login page of the Para Bank Application
#When I enter valid credentials
#|autotester|password|
#Then I should be taken to the overview page
		
Scenario Outline: Login successful

Given I am in the login page of the Para Bank Application
When I enter valid <username> and <password> with <userFullName>
Then I should be taken to the overview page

Examples:
		|username|password|userFullName|
		|"autotester2"|"password2"|"full name"|
		



