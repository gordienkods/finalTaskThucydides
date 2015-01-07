Scenario: Connect to data base
Given the user is on the ranorex main page and data base condition is 'Offline'
When the user click 'Connect...' button
Then the user should see pop-up window with the message: 'Connect to Database?'
And the user should see that condition of database is 'Connecting...'
And the user should see that condition of database is 'Online'
And the user should see 'Disconnect...' button
And 'Load' button condition should be 'Enabled'
And 'Save' button condition should be 'Enabled'
And 'Add' button condition should be 'Enabled'
And 'Clear' button condition should be 'Enabled'