Feature: To Test DTC Vroom Portal Functionalities
@DTC_Vroom_portal_QUICK_Regression
  Scenario Outline: Add a New Contract
    Given Go to vroom url with data as <testCase> and <portal> and <oid>
    And enter as  <vehicle_reg_province> and <mileage>
    When Click on get your price button
    And Enter plan selection information <plan> and <termLength> and <commercialUse> and  click on view payment options button
    And enter feepaymentplan options as <feePaymentPlan> and click on checkout button
    And Enter personal details <firstName> and <lastName> and <email> and <phoneNo> and <address> and click on continue to billing button.
    And Enter vroom payment details <nameOnCard> and <cardNumber> and <expMonth> and <expYear> and <CVC> and click on pay button
    Then copy orderid and close the browser
    And Verify the order details from database

    Examples: 
      | testCase | portal | oid                | vehicle_reg_province | mileage | plan     | termLength            | commercialUse | firstName | lastName | email            | phoneNo    | address | feePaymentPlan | nameOnCard | cardNumber       | expMonth | expYear | CVC |
      # |        1 | vroom  | 0065500000I61YDAAZ |  Georgia                    |      90 | Platinum | 7 YEARS, 70,000 MILES | Yes           | Test01    | Test01   | test01@gmail.com | 4545454543 | kfc Tex | 18 months      | test       | 4111111111111111 | June     |    2026 | 345 |
      |        2 | vroom  | 0065500000I61XuAAJ | Texas                |      90 | Platinum | 7 YEARS, 70,000 MILES | Yes           | Test01    | Test01   | test01@gmail.com | 4545454543 | kfc Tex | 18 months      | test       | 4111111111111111 | June     |    2026 | 345 |
