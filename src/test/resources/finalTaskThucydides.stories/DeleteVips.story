Scenario: Connection codition should be 'Online' when user wonts add new VIPs
Given the user is on the ranorex main page
Then the user should see that condition of database is 'Online'

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

Scenario: Delete Vip by number and ckeck vip table condition
Given the user click radio button near vip number '2'
When the user click 'Delete' button
Then the user should see vips table with out VIP number '2'

Scenario: Check quantity of Vips line and vip count condition afret deleting vip number 2
Then quantity of Vips lines in table should be '6'
Then VIPs count should be 'VIP count: 5'

Scenario: Clear VIPs table using delete button and check VIPs count, quantity lines of VIPs table, Delete button condition
Given the user click radio button near vip number '1'
When the user click 'Delete' button
Given the user click radio button near vip number '1'
When the user click 'Delete' button
Given the user click radio button near vip number '1'
When the user click 'Delete' button
Given the user click radio button near vip number '1'
When the user click 'Delete' button
Given the user click radio button near vip number '1'
When the user click 'Delete' button
Then VIPs count should be 'VIP count: 0'
Then quantity of Vips lines in table should be '1'
Then 'Delete' button condition should be 'Disabled'

