Scenario: Save added VIPs
Given the user is on the ranorex main page and data base condition is 'Online'
When the user enters VIPs data: first name-'Gora', last name-'Vilkin', gender-'Male', category-'Other'
And the user click 'Add' button
And the user enters VIPs data: first name-'Dusya', last name-'Barankina', gender-'Female', category-'Music'
And the user click 'Add' button
And the user enters VIPs data: first name-'Vasya', last name-'Ivanov', gender-'Male', category-'Movie'
And the user click 'Add' button
And the user click 'Save' button
Then the user should see pop-up window with the info message: '3 VIP(s) stored sucessfully'