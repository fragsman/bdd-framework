#This is a dummy file and it won't be used
Feature: Ignore this file (dummy testing code)

  @disabled
  Scenario: Complete a contact us form and verify data gets the database
  Given user "rob@gmail.com" completes the contact us form with "hello, my roof is leaking water"
  Then information in db should be correct