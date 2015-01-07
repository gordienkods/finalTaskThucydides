Scenario: Clear VIPs table
Given the user is on the ranorex main page and data base condition is 'Online'
When the user click 'Load' button
And the user click 'Clear' button
Then VIPs count should be 'VIP count: 0'
And quantity of Vips lines in table should be '0'
And 'Delete' button condition should be 'Disabled'