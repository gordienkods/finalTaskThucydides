Scenario: Load VIPs from data base
Given the user is on the ranorex main page
When the user click 'Load' button
Then VIPs count should be 'VIP count: 6'
Then quantity of Vips lines in table should be '7'
Then 'Delete' button condition should be 'Enabled'

Scenario: Clear VIPs table
When the user click 'Clear' button
Then VIPs count should be 'VIP count: 0'
Then quantity of Vips lines in table should be '1'
Then 'Delete' button condition should be 'Disabled'