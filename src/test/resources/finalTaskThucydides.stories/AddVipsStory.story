Scenario: Connection codition should be 'Online' when user wonts add new VIPs
Given the user is on the ranorex main page
Then the user should see that condition of database is 'Online'

Scenario: Check buttons condition
Given the user finds 'Load' button
Then 'Load' button condition should be 'Enabled'
Given the user finds 'Save' button
Then 'Save' button condition should be 'Enabled'
Given the user finds 'Add' button
Then 'Add' button condition should be 'Enabled'
Given the user finds 'Clear' button
Then 'Clear' button condition should be 'Enabled'
Given the user finds 'Delete' button
Then 'Delete' button condition should be 'Disabled'

Scenario: Adding new VIPs and check VIP count and 'Delete' button condition
When the user enters VIPs data: first name-'Gora', last name-'Vilkin', gender-'Male', category-'Other'
When the user click 'Add' button
Then 'Delete' button condition should be 'Enabled'
When the user enters VIPs data: first name-'Dusya', last name-'Barankina', gender-'Female', category-'Music'
When the user click 'Add' button
When the user enters VIPs data: first name-'Vasya', last name-'Ivanov', gender-'Male', category-'Movie'
When the user click 'Add' button
When the user enters VIPs data: first name-'Manya', last name-'Pupkina', gender-'Female', category-'Science'
When the user click 'Add' button
When the user enters VIPs data: first name-'Gera', last name-'Popov', gender-'Male', category-'Sport'
When the user click 'Add' button
When the user enters VIPs data: first name-'Vika', last name-'Balabanova', gender-'Female', category-'Politics'
When the user click 'Add' button
Then VIPs count should be 'VIP count: 6'
Then entered VIPs data should be the same with VIPs data from the table


