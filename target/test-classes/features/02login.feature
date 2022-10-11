Feature: Login

@ValidLogin
Scenario: user wants to login in blinkit
Given  user is in homepage
When user enters the  "<mobileNumber>" and valid otp
Then user will see login successful message

Examples:
|mobileNumber|
|7218050140|
|7904654159|


@InValidLogin
Scenario: user wants to login in blinkit
Given  user is in the homepage
When user enters the "<mobileNumber>" and invalid otp
Then user will see verfication failed message

Examples:
|mobileNumber|
|7218050140|
|7904654159|