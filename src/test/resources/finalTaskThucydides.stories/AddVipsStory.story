Scenario: Adding new VIPs
Given the user is on the ranorex main page and data base condition is 'Online'
When the user enters VIPs data: first name-'Gora', last name-'Vilkin', gender-'Male', category-'Other'
And the user click 'Add' button
Then 'Delete' button condition should be 'Enabled'
When the user enters VIPs data: first name-'Dusya', last name-'Barankina', gender-'Female', category-'Music'
And the user click 'Add' button
And the user enters VIPs data: first name-'Vasya', last name-'Ivanov', gender-'Male', category-'Movie'
And the user click 'Add' button
And the user enters VIPs data: first name-'Manya', last name-'Pupkina', gender-'Female', category-'Science'
And the user click 'Add' button
And the user enters VIPs data: first name-'Gera', last name-'Popov', gender-'Male', category-'Sport'
And the user click 'Add' button
And the user enters VIPs data: first name-'Vika', last name-'Balabanova', gender-'Female', category-'Politics'
And the user click 'Add' button
Then VIPs count should be 'VIP count: 7'
Then entered VIPs data should be the same with VIPs data from the table