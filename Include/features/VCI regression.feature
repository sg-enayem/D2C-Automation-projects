Feature: To Test DTc Portal Functionalities

  @DTC_VCI_portal_QUICK_Regression
  Scenario Outline: Add a New Contract
    Given Go to url with data as <testCase> and <portal>
    And enter as <vinNo> and <province> and <odometer>
    When Click on get started button
    And Enter plan selection information <plan> and <deductible> and <coverageInMonths> and <coveredMiles> and submit the details
    And Enter personal details <firstName> and <lastName> and <middleInitial> and <homePhoneNo> and <secondaryPhoneNo> and <email> and <street> and <city> and <zipcode> and submit the page.
    And Enter payment details <cardNumber> and <expMonth> and <expYear> and <CVC> and click on pay button
    Then click on confirm button and download the contract and close the browser

    Examples: 
      | testCase | portal     | vinNo             | province | odometer | coveredMiles | plan | coverageInMonths | deductible | firstName | lastName | middleInitial | email            | homePhoneNo | secondaryPhoneNo | street                 | city      | zipcode | feePaymentPlan | nameoncard   | cardNumber       | expMonth | expYear | CVC |
      |        1 | audi       | WA1DECF36N1088621 | Georgia  |       75 |       100000 | Gold |               48 |        100 | Test      | Test     | T             | test01@gmail.com |  4545454543 |       4567765434 | 1364 East Boone Avenue | Kingsland |   31548 | 18months       | shaniyanisha | 4111111111111111 |       06 |    2026 | 345 |
      |        2 | volkswagen | 1V2JP2CA5NC527830 | Georgia  |       75 |       100000 | Gold |               48 |        100 | Test      | Test     | T             | test01@gmail.com |  4545454543 |       4567765434 | 1364 East Boone Avenue | Kingsland |   31548 | 18months       | shaniyanisha | 4111111111111111 |       06 |    2026 | 345 |

  @DTC_Vroom&Nissan_portal_QUICK_Regression
  Scenario Outline: Add a New Contract
    Given Go to vroom url with data as <testCase> and <portal> and <oid>
    And enter as  <vehicle_reg_province> and <mileage>
    When Click on get your price button
    And Enter plan selection information <plan> and <termLength> and <commercialUse> and  click on view payment options button
    And enter feepaymentplan options as <feePaymentPlan> and click on checkout button
    And Enter personal details <firstName> and <lastName> and <email> and <phoneNo> and <address> and click on continue to billing button.
    And Enter vroom payment details <nameOnCard> and <cardNumber> and <expMonth> and <expYear> and <CVC> and click on pay button
    Then copy orderid and close the browser

    Examples: 
      | testCase | portal | oid                | vehicle_reg_province | mileage | plan     | termLength            | commercialUse | firstName | lastName | email            | phoneNo    | address | feePaymentPlan | nameOnCard | cardNumber       | expMonth | expYear | CVC |
      # |        1 | vroom  | 0065500000I61YDAAZ |  Georgia                    |      90 | Platinum | 7 YEARS, 70,000 MILES | Yes           | Test01    | Test01   | test01@gmail.com | 4545454543 | kfc Tex | 18 months      | test       | 4111111111111111 | June     |    2026 | 345 |
      |        2 | vroom  | 0065500000I61XuAAJ | Texas                |      90 | Platinum | 7 YEARS, 70,000 MILES | Yes           | Test01    | Test01   | test01@gmail.com | 4545454543 | kfc Tex | 18 months      | test       | 4111111111111111 | June     |    2026 | 345 |
