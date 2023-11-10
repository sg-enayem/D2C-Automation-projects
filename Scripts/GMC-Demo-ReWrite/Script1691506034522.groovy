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

WebUI.navigateToUrl('https://mango-rewrite-gmc-qa.herokuapp.com/vehicle-service-protection')

WebUI.setText(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Vehicle Service _04e2f2/input_VIN_vin'), 
    '3GTUUDEDXNG653995')

WebUI.setText(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Vehicle Service _04e2f2/input_Current Mileage_editVehicleOdometerVIN'), 
    '2000')

WebUI.selectOptionByValue(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Vehicle Service _04e2f2/select_AlabamaAlaskaArizonaArkansasCaliforn_3be247'), 
    'FL', true)

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Vehicle Service _04e2f2/span_Find My Price'))

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/div_Platinum'))

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/button_250'))

WebUI.selectOptionByValue(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/select_3 YEARS, 60,000 MILES  4 YEARS, 40,0_79a636'), 
    '3', true)

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/span_View Payment Options'))

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/span_30 months'))

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/span_NoYes_lever'))

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/span_NoYes_lever'))

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/button_Checkout'))

WebUI.setText(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/input_First Name_firstName'), 
    'Emran')

WebUI.setText(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/input_Last Name_lastName'), 
    'Nayem')

WebUI.setText(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/input_Email Address_emailFormEmail'), 
    'Emran03@gmail.com')

WebUI.setText(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/input_Confirm Your Email_emailFormConfirm'), 
    'Emran03@gmail.com')

WebUI.setText(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/input_Phone Number_emailFormPhone'), 
    '9999999999')

WebUI.setText(findTestObject('Object Repository/Vroom/input__Address'), '200 S State Rd 434, Altamonte Springs, Florida 32714, USA')
WebUI.setText(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ARROW_DOWN))
//WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), 
    Keys.chord(Keys.ENTER))

//WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/input__registrationFormCity'))
WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/button_Continue to Billing'))

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/button_COMPLETE'))

WebUI.setText(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/input_Name on Card_billingFormName'), 
    'EmranTest')

WebUI.setText(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/input_Card Number_billingFormCardNumber'), 
    '4111111111111111')

WebUI.selectOptionByValue(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/select_January February March April May Jun_0a059c'), 
    '06', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/select_January February March April May Jun_0a059c'), 
    '06', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/select_2023 2024 2025 2026 2027 2028 2029 2_d4b0be'), 
    '2030', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/select_2023 2024 2025 2026 2027 2028 2029 2_d4b0be'), 
    '2030', true)

WebUI.setText(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/input_CVC_cvcValue'), 
    '121')

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/label_Billing address same as primary address'))

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/button_Continue to Review'))

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/button_Confirm'))

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/label_By providing your consent, you are al_e009d9'))

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/button_Confirm'))

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/label_I have read and agree to the terms an_dd875f'))

WebUI.click(findTestObject('Object Repository/GMC-Demo/Page_GMC Protection Plan - Plans and Pricing/span_Pay Now'))

