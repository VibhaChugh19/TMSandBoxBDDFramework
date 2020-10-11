Feature: Search used cars listing in TMSandbox

Scenario: To verify the link of Used cars on Home page
Given Guest User is in tmsandbox Home page
When  User clicks on In all categories drop down in search field
Then  User arrow down and clicks on car section
Then  User clicks on search button
And   User clicks on Used cars link 
Then  User closes the browser

Scenario: To verify the car make Kia exists in used cars section
Given Guest User is in tmsandbox Home page
When  User clicks on In all categories drop down in search field
Then  User arrow down and clicks on car section
Then  User clicks on search button
And   User clicks on Used cars link 
And  User checks the make Kia exists 

Scenario: To verify the details of listing cars
Given Guest User is in tmsandbox Home page
When  User clicks on In all categories drop down in search field
Then  User arrow down and clicks on car section
Then  User clicks on search button
And   User clicks on Used cars link
Then User scroll down the page to check the listing of the cars
And  User clicks on more link to check the used cars listing
And  User checks the car key details displaying in the listing