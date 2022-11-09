Feature: Test Vegetable Site

@smoke
Scenario: Check the Vegetable availale
    Given User Launch Chrome browser 
    When URL is Entered
    And User searches "Tomato" then Tomato should be displayed
    And click on top deals link
    Then Page title should be "GreenKart - veg and fruits kart"
    When user enters "Tomato" in search field
    And close browser
    