Scenario: Connection codition should be 'Offline' when database is 'disconnected'
Given the user is on the ranorex main page
When the user click 'Disconnect' button
Then the user should see that condition of database is 'Offline'

Scenario: Button 'Connect...' should be present when database is 'disconnected'
Given the user finds 'Connect' button

Scenario: Load button sould be 'disable' when database is 'disconnected'
Given the user finds 'Load' button
Then 'Load' button condition should be 'Disabled'

Scenario: Save button sould be 'disable' when database is 'disconnected'
Given the user finds 'Save' button
Then 'Save' button condition should be 'Disabled'

Scenario: Save button sould be 'disable' when database is 'disconnected'
Given the user finds 'Delete' button
Then 'Delete' button condition should be 'Disabled'