Scenario: When user added new vip and click 'Save' button he should see pop uo window with message
Given the user is on the ranorex main page
Then the user should see that condition of database is 'Online'
When the user enters VIPs data: first name-'Gora', last name-'Vilkin', gender-'Male', category-'Other'
When the user click 'Add' button
Then 'Delete' button condition should be 'Enabled'
When the user enters VIPs data: first name-'Dusya', last name-'Barankina', gender-'Female', category-'Music'
When the user click 'Add' button
When the user enters VIPs data: first name-'Vasya', last name-'Ivanov', gender-'Male', category-'Movie'
When the user click 'Add' button
Then VIPs count should be 'VIP count: 3'
Then entered VIPs data should be the same with VIPs data from the table
When the user click 'Save' button
Then the user should see pop-up window with the message: '3 VIP(s) stored sucessfully'