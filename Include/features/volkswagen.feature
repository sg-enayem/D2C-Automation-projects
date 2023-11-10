Feature: To Test DTC VCI volkswagen Portal Functionalities

  @DTC_VCI_volkswagen_portal_QUICK_Regression
  Scenario Outline: Add a New Contract
    Given Go to url with data as <testCase> and <portal>
    And enter as <vinNo> and <province> and <odometer>
    When Click on get started button
    And Enter plan selection information <plan> and <deductible> and <coverageInMonths> and <coveredMiles> and submit the details
    And Enter personal details <firstName> and <lastName> and <middleInitial> and <homePhoneNo> and <secondaryPhoneNo> and <email> and <street> and <city> and <zipcode> and submit the page.
    And Enter payment details <cardNumber> and <expMonth> and <expYear> and <CVC> and click on pay button
    Then click on confirm button and download the contract and close the browser
    And verify the order details in database

    Examples: 
      | testCase | portal     | vinNo             | province | odometer | coveredMiles | plan | coverageInMonths | deductible | firstName | lastName | middleInitial | email            | homePhoneNo | secondaryPhoneNo | street                 | city      | zipcode | feePaymentPlan | nameoncard   | cardNumber       | expMonth | expYear | CVC |
      |        2 | volkswagen | 1V2BR2CA9NC524265 | Georgia  |       75 |       100000 | Gold |               48 |        100 | Test      | Test     | T             | test01@gmail.com |  4545454543 |       4567765434 | 1364 East Boone Avenue | Kingsland |   31548 | 18months       | shaniyanisha | 4111111111111111 |       06 |    2026 | 345 |
