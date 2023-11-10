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

WebUI.navigateToUrl('https://cons.purchase.vwdriveeasy.com/')

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_vin'), '1V2BR2CA5NC524926')

WebUI.selectOptionByValue(findTestObject('Object Repository/VSC/VW/select_StateOfProvince'), 'NY', true)

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_OdometerReading'), '65')

WebUI.click(findTestObject('Object Repository/VSC/VW/span_Get Started'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_Platinum'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_Gold'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_Powertrain'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_Platinum'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_0'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_100'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_250'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_0'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_100'))

WebUI.selectOptionByValue(findTestObject('Object Repository/VSC/VW/select_DurationOfCoverage'), '39', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/VSC/VW/select_coveredMiles'), '60000', true)

WebUI.click(findTestObject('Object Repository/VSC/VW/span_Installments'))

WebUI.click(findTestObject('Object Repository/VSC/VW/button_Next'))

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_FirstNameSign'), 'te')

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_LastNameSign'), 'te')

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_MiddleInitial'), 't')

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_PrimaryPhoneNumber'), '(435) 443-4543')

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_SecondaryPhoneNumber'), '(234) 332-3432')

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_EmailAddress'), 'te@tes.com')

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_verifyEmailAddress'), 'te@tes.com')

WebUI.click(findTestObject('Object Repository/VSC/VW/input_StreetAddress'))

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_StreetAddress'), '242 E 14th St')

WebUI.click(findTestObject('Object Repository/VSC/VW/fieldset_First NameLast NameMiddle InitialP_415770'))

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_City'), 'New York')

WebUI.click(findTestObject('Object Repository/VSC/VW/form_First NameLast NameMiddle InitialPrima_71d7f7'))

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_ZipCode'), '10003')

WebUI.click(findTestObject('Object Repository/VSC/VW/span_Validate Address'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_242 E 14th St , New York, NY, 10003, US'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_Confirm'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_I have read and agree to the E-SIGN Di_0a51d5'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_I confirm that the information I have _0df39c'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_I have read and agree with the Terms o_526d2a'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_Download a Preview of My Customer Agreement'))

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_FirstName'), 'ts')

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_LastName'), 'ts')

WebUI.click(findTestObject('Object Repository/VSC/VW/button_Add_My_Signature'))

WebUI.click(findTestObject('Object Repository/VSC/VW/span_I agree to make four (4) installment p_825cda'))

WebUI.click(findTestObject('Object Repository/VSC/VW/button_Pay Now'))

WebUI.click(findTestObject('Object Repository/VSC/VW/input_CardType'))

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_CardNumber'), '4111111111111111')

WebUI.selectOptionByValue(findTestObject('Object Repository/VSC/VW/select_Month'), '06', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/VSC/VW/select_Year'), '2026', true)

WebUI.setText(findTestObject('Object Repository/VSC/VW/input_cvn'), '345')

WebUI.click(findTestObject('Object Repository/VSC/VW/input_cancelbutton'))

