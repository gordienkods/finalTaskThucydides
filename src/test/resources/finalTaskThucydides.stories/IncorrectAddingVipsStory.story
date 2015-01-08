Scenario: Adding new VIP give first name only
Given the user is on the ranorex main page and data base condition is 'Online'
When the user enters VIPs first name 'Gesha'
And the user click 'Add' button
Then the user should see pop-up window with the info message: 'Please specify 'Last Name' value'

Scenario: Adding new VIP give last name only
Given the user is on the ranorex main page and data base condition is 'Online'
When the user enters VIPs last name 'Pupkin'
And the user click 'Add' button
Then the user should see pop-up window with the info message: 'Please specify 'First Name' value'