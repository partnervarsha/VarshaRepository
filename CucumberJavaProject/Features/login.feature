Feature: HRM Application

Background: Login Functionality
Given User navigates to the Website OrangeHrm
Given User entering Username and Password

Scenario: Admin Functionality
When User navigates to Admin Page
And User click on Job dropdown
Then Job Titles page is displayed.
Then Login must be successful.
