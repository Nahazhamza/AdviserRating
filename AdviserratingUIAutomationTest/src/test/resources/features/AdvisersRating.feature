@AdviserRating
Feature: Adviser Rating Search functionality validation


  Scenario: Check adviser's profile page displays correct practice and addresses
    Given Navigated to Adviserrating URL
    And Go to Adviser Tab, enter "Brett Dillon" and click enter
    And Get the current Page URL should be equal to "https://staging.adviserratings.com.au/adviser/265081/Brett-Dillon"
    And Check the banner image equals "https://resources.adviserratings.com.au/adviser-profile/brett-andrew-dillon-265081.png"
    And Check the name is "Brett Dillon",Advisor name is "Saige Financial Planning Pty Ltd" and location will be "Erina, NSW 2250"
    And About tab is "About Brett" check
    And Check the location panel with advisor name "Saige Financial Planning Pty Ltd" and src url "https://resources.adviserratings.com.au/practices/saige-financial-planning-pty-ltd-18006980.png"
    Then Address check is performed
    
  Scenario: Verification of Location and select and enter location feild
    Given Navigated to Adviserrating URL
    And Go to location Tab
    When "Sydney" is entered from dropdown menu, check it contains "NSW 2000" and check it is highlighted
    And verify it is redirected to the url "https://staging.adviserratings.com.au/find-an-adviser/Sydney-NSW-2000"
    And verify the dropdown box contains location as "Sydney, NSW 2000", listview and KMRange "10km" in "We've found 2444 advisers within 10km of Sydney, NSW 2000"
    


  Scenario: Search by adviser name and check search drop down box displays correct practice and addresses
    Given Navigated to Adviserrating URL
    When Click on Adviser Tab
    And Enter "Brett Dillon" on the Search box
    Then Dropdown should be displayed with "Brett Dillon"
    And Dropdown should be highlighted for the "Brett Dillon"
    And Practice under the "Brett Dillon" should be "Saige Financial Planning Pty Ltd"
    And Two locations should be listed next to the adviser as "Erina, NSW 2250" and "Sydney, NSW 2000"
    When click on Enter key
    Then User should be redirected to the url "https://staging.adviserratings.com.au/adviser/265081/Brett-Dillon"

  Scenario: Search by location and distance
    Given Navigated to Adviserrating URL
    And Go to location Tab
    When Enter "800" inside the Search box
    Then Find "Darwin, NT 0800" from the Address search dropdown and click on it
    And select for "5km" from dropdown and click search
    Then Get CurrentPageUrl as"https://staging.adviserratings.com.au/find-an-adviser/Darwin-NT-0800", location name "Darwin, NT 0800",  distance "5km" and verify search result as "We've found 27 advisers within 5km of Darwin, NT 0800"
    And check descendingorder of KMRange
    And Logout the browser
