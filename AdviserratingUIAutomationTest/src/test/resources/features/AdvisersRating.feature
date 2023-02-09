@AdviserRating
Feature: Adviser Rating Search functionality validation

  Scenario: Check adviser's profile page displays correct practice and addresses
    Given Navigated to Adviserrating URL
    And Go to Adviser Tab, enter text and click enter
    And Get the current Page URL
    And Check the banner information is correct
    And Check the name, advisername and location
    And About tab check
    And Check the location panel
    Then Address check is performed

  #Scenario: Verification of Location and select and enter location feild
    #Given Navigated to Adviserrating URL
    #And Go to location Tab
    #When clicking on enter from dropdown menu and check Highlight
    #And verify CurrentUrl
    #And verify the dropdown box, listview and KMRange

  #Scenario: Search by adviser name and check search drop down box displays correct practice and addresses
    #Given Navigated to Adviserrating URL
    #When Click on Adviser Tab
    #And Enter "Brett Dillon" on the Search box
    #Then Dropdown should be displayed with "Brett Dillon"
    #And Dropdown should be highlighted for the "Brett Dillon"
    #And Practice under the "Brett Dillon" should be "Saige Financial Planning Pty Ltd"
    #And Two locations should be listed next to the adviser as "Erina, NSW 2250" and "Sydney, NSW 2000"
    #When click on Enter key
    #Then User should be redirected to the url "https://staging.adviserratings.com.au/adviser/265081/Brett-Dillon"
#
  #Scenario: Search by location and distance
    #Given Navigated to Adviserrating URL
    #And Go to location Tab
    #And Enter value in location field and find address of particulars
    #And Check the Km value and select and search
    #Then Get CurrentPageUrl and verify
    #And check descendingorder of KMRange
    #And Logout the browser
