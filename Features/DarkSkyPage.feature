@web
Feature: Darksky home page - Temperature

@DarkShyTempCom
Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
 Given I am on Darksky Home Page
 Then I verify current temp is not greater or less then temps from daily timeline




 @DarkskyTimelineCompare
  Scenario: Verify timline is displayed in correct format
  Given I am on Darksky Home Page
  Then I verify timeline is displayed with two hours incremented