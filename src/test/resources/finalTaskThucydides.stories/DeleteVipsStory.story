Scenario: Delete Vip from table by number
Given the user is on the ranorex main page and data base condition is 'Online'
When the user enters VIPs data: first name-'Gora', last name-'Vilkin', gender-'Male', category-'Other'
And the user click 'Add' button
And the user enters VIPs data: first name-'Dusya', last name-'Barankina', gender-'Female', category-'Music'
And the user click 'Add' button
And the user enters VIPs data: first name-'Vasya', last name-'Ivanov', gender-'Male', category-'Movie'
And the user click 'Add' button
And the user enters VIPs data: first name-'Manya', last name-'Pupkina', gender-'Female', category-'Science'
And the user click 'Add' button
And the user enters VIPs data: first name-'Gera', last name-'Popov', gender-'Male', category-'Sport'
And the user click 'Add' button
And the user enters VIPs data: first name-'Vika', last name-'Balabanova', gender-'Female', category-'Politics'
And the user click 'Add' button
And the user click radio button near vip number '2'
And the user click 'Delete' button
Then VIPs count should be 'VIP count: 5'
And quantity of Vips lines in table should be '5'
And the user should see vips table with out VIP number '2'

Scenario: Clear VIPs table using delete button
Given the user is on the ranorex main page and data base condition is 'Online'
When the user enters VIPs data: first name-'Gora', last name-'Vilkin', gender-'Male', category-'Other'
And the user click 'Add' button
And the user enters VIPs data: first name-'Dusya', last name-'Barankina', gender-'Female', category-'Music'
And the user click 'Add' button
And the user enters VIPs data: first name-'Vasya', last name-'Ivanov', gender-'Male', category-'Movie'
And the user click 'Add' button
And the user click radio button near vip number '1'
And the user click 'Delete' button
And the user click radio button near vip number '1'
And the user click 'Delete' button
And the user click radio button near vip number '1'
And the user click 'Delete' button
Then VIPs count should be 'VIP count: 0'
And quantity of Vips lines in table should be '0'
And 'Delete' button condition should be 'Disabled'