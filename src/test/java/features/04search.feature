Feature: Search in blinkit

@search
Scenario Outline: user wants to search product
Given when user is in blinkit Home page
When he enters product name in search bar from "<SheetName>" and <RowNumber>
Then he sees the product details

Examples:

|SheetName|RowNumber|
|Search|0|
|Search|1|