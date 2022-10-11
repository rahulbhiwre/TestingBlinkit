Feature: Login

Scenario: user wants to login in blinkit
Given  user is in  homepage
When user enters the  "<mobileNumber>" and valid otp
Then user will see login successful message



Examples:

|mobileNumber|
|7218050140|
