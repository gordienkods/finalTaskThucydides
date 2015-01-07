Scenario: Load VIPs to table from data base
Given the user is on the ranorex main page and data base condition is 'Online'
When the user click 'Load' button
Then VIPs count should be 'VIP count: 6'
And quantity of Vips lines in table should be '6'
And 'Delete' button condition should be 'Enabled'