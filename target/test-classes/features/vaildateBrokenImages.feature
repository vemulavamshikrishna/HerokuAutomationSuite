Feature: Image Check
Checking the whether the images are broken or fine.

    Background:
    Given user is on broken images page
 	
 	@smoke
 	Scenario Outline: validate the broken images
	  When user right clicks and opens "<elementName>" in a new tab
      Then user should see image not found
      
    Examples:
    |elementName|
    |firstElement|
    |secondElement|
    
    @smoke
    Scenario: validate the normal image
      When user right clicks and opens normal image in a new tab
      Then user should see the image
     
    @sanity  
    Scenario Outline: validate if the images are broken or not
      When user opens "<image>" url
      Then user should get image
      
      Examples:
      |image|
      |firstImage|
      |secondImage|
      |thirdImage|