Feature: Demoblaze Purchase Flow

Scenario: Successful product purchase
  Given user is on Demoblaze login page
  When user logs in with valid credentials
  And adds two products to cart
  And proceeds to checkout
  Then order should be placed successfully
