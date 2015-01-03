Scenario: Connection codition should be 'Online' when database is 'connected'
Given the user is on the ranorex main page
Then the user should see that condition of database is 'Online'

Scenario: Button 'Disconnect...' should be present when database is 'connected'
Given the user finds 'Disconnect...' button

Scenario: Load button sould be 'enable' when database is 'connected'
Given the user finds 'Load' button
Then 'Load' button condition should be 'Enabled'

Scenario: Save button sould be 'enable' when database is 'connected'
Given the user finds 'Save' button
Then 'Save' button condition should be 'Enabled'