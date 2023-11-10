import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://mango-rewrite-qa.herokuapp.com/vehicle-service-protection?oid=0065500000LmohMAAR')

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Vehicle Service Protection/input_Current Mileage_odometerId'), 
    '2000')

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Vehicle Service Protection/button_Get Your Price'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/span_NoYes_lever'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/span_NoYes_lever_1'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/select_4 YEARS, 48,000 MILES  4 YEARS, 60,0_5bc830'), 
    '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/select_4 YEARS, 48,000 MILES  4 YEARS, 60,0_5bc830'), 
    '18', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/select_4 YEARS, 48,000 MILES  4 YEARS, 60,0_5bc830'), 
    '8', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/select_4 YEARS, 48,000 MILES  4 YEARS, 60,0_5bc830'), 
    '0', true)

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/div_Powertrain'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/div_Platinum'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/span_NoYes_lever_1'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/span_View Payment Options'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/a_View Agreement and Exclusions'))
WebUI.closeWindowIndex(1)
WebUI.delay(1)
WebUI.switchToWindowIndex(0)

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/span_30 months'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/div_24 months'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/div_6 months'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/div_Pay in Full'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/span_36 months'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/button_Checkout'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_First Name_firstName'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Last Name_lastName'))

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_First Name_firstName'), 'Muntasir')

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Last Name_lastName'), 'Rahman')

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Email Address_emailFormEmail'), 
    'a@gmail.com')

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Confirm Your Email_emailFormConfirm'), 
    '')

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/mdb-card-body_1 Contact InfoAll fields are _3c3fd2'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/div_Confirm Your EmailConfirm email does not match'))

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Confirm Your Email_emailFormConfirm'), 
    'a@gmail.com')

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Phone Number_emailFormPhone'), 
    '2424242424')

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input__registrationFormAddress'), '200 S State Rd 434,Altamonte Springs,Florida,32714')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ENTER))

WebUI.delay(3)

WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/a_View Agreement and Exclusions_1'))

WebUI.delay(2)
WebUI.closeWindowIndex(1)
WebUI.delay(1)
WebUI.switchToWindowIndex(0)

WebUI.delay(4)
WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/button_Continue to Billing'))



WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/button_COMPLETE'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Name on Card_billingFormName'))

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Name on Card_billingFormName'), 
    'Muntasir')

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Card Number_billingFormCardNumber'), 
    '4111111111111111')

WebUI.selectOptionByValue(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/select_January February March April May Jun_0a059c'), 
    '11', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/select_2023 2024 2025 2026 2027 2028 2029 2_d4b0be'), 
    '2028', true)

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_CVC_cvcValue'), '111')

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/label_Billing address same as primary address'))

WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/a_View Agreement and Exclusions_1'))
WebUI.closeWindowIndex(1)
WebUI.delay(1)
WebUI.switchToWindowIndex(0)

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/button_Continue to Review'))

WebUI.rightClick(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/div_Order SummaryProtection For the Followi_08568b'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/span_I READ THE TERMS AND CONDITIONS'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/label_I have read and agree to the terms an_dd875f'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/span_View Payment Options'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/button_Checkout'))

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_First Name_firstName'), 'Muntasir')

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Last Name_lastName'), 'Rahman')

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Email Address_emailFormEmail'), 
    'a@gmail.com')

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Confirm Your Email_emailFormConfirm'), 
    'a@gmail.com')

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Phone Number_emailFormPhone'), 
    '5454545454')

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/button_Continue to Billing'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/button_COMPLETE'))

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Name on Card_billingFormName'), 
    'Rahman')

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_Card Number_billingFormCardNumber'), 
    '4111111111111111')

WebUI.selectOptionByValue(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/select_January February March April May Jun_0a059c'), 
    '09', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/select_2023 2024 2025 2026 2027 2028 2029 2_d4b0be'), 
    '2030', true)

WebUI.setText(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/input_CVC_cvcValue'), '111')

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/label_Billing address same as primary address'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/button_Continue to Review'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/span_I READ THE TERMS AND CONDITIONS'))

WebUI.click(findTestObject('Object Repository/Re-write_test/Page_Vroom - Get Rates/label_I have read and agree to the terms an_dd875f'))

WebUI.closeBrowser()

