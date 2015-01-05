Scenario: Adding new VIP give first name only
Given the user is on the ranorex main page
Given the user enters VIPs first name 'Gesha'
When the user click 'Add' button
Then the user should see pop-up window with the message: 'Please specify 'Last Name' value'

Scenario: Adding new VIP give last name only
Given the user enters VIPs last name 'Pupkin'
When the user click 'Add' button
Then the user should see pop-up window with the message: 'Please specify 'First Name' value'