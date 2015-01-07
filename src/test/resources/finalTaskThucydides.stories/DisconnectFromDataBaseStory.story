Scenario: Disconnect from data base
Given the user is on the ranorex main page and data base condition is 'Online'
When the user click 'Disconnect...' button
Then the user should see that condition of database is 'Offline'
And the user should see 'Connect...' button
And 'Load' button condition should be 'Disabled'
And 'Save' button condition should be 'Disabled'
And 'Delete' button condition should be 'Disabled'