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

WebUI.navigateToUrl('https://workbench.developerforce.com/login.php?startUrl=%2Fquery.php')

WebUI.selectOptionByValue(findTestObject('Object Repository/SalesForceDB/Page_Workbench/select_ProductionSandbox'), 'test.salesforce.com', 
    true)

WebUI.click(findTestObject('Object Repository/SalesForceDB/Page_Workbench/input_QuickSelect_termsAccepted'))

WebUI.click(findTestObject('Object Repository/SalesForceDB/Page_Workbench/input_httpsgithub.comforceworkbenchforcewor_8b37fb'))

WebUI.setText(findTestObject('Object Repository/SalesForceDB/Page_Login  Salesforce/input_Username_username'), 'enayem@sgintl.com.levdev1')

WebUI.setEncryptedText(findTestObject('Object Repository/SalesForceDB/Page_Login  Salesforce/input_Password_pw'), 'KjlBWUGaQe2rFyqncfD4SA==')

WebUI.click(findTestObject('Object Repository/SalesForceDB/Page_Login  Salesforce/input_Password_Login'))

WebUI.click(findTestObject('Object Repository/SalesForceDB/Page_Workbench SOQL Query/span_queries'))

WebUI.click(findTestObject('Object Repository/SalesForceDB/Page_Workbench SOQL Query/a_SOQL Query'))

WebUI.setText(findTestObject('Object Repository/SalesForceDB/Page_Workbench SOQL Query/textarea_Enter or modify a SOQL query below_e86c72'), 
    'SELECT FIELDS(ALL) FROM Order where customer_order_number__C=\'chevroletdtc140289\' Limit 100')

WebUI.click(findTestObject('Object Repository/SalesForceDB/Page_Workbench SOQL Query/input_Enter or modify a SOQL query below_qu_a3c1bb'))

WebUI.click(findTestObject('Object Repository/SalesForceDB/Page_Workbench SOQL Query/a_0065500000MRMM8AAP'))

WebUI.delay(30)

WebUI.closeBrowser()

