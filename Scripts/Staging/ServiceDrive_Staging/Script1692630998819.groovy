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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection

WebUI.openBrowser('')

WebUI.navigateToUrl('https://staging.oneprotectplans.com/service-drive')

WebUI.setText(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/input_Dealership ID_dealershipId'), 
    '00000SC9')

WebUI.setText(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/input_Employee ID_employeeId'), 
    '112')

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/a_Manual VIN Input'))

WebUI.setText(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/input_VIN_vin'), 
    'WAUGMAF43LN700309')
WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/input_Year_year'))

WebUI.setText(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/input_Odometer_odometer'), 
    '2000')

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/button_No'))

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/button_View Rates'))

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/div_Gold SD'))

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/button_100'))

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/span_NoYes_lever'))

WebUI.selectOptionByValue(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/select_4 YEARS, 100,000 MILES  5 YEARS, 60,_d72163'), 
    '4', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/select_4 YEARS, 100,000 MILES  5 YEARS, 60,_d72163'), 
    '4', true)

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/span_View Payment Options'))

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/span_NoYes_lever_1'))

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/span_30 months'))

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/button_Checkout'))

WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/a_Choose file'))


//WebUI.click(findTestObject('Service Drive/Page_One Protect - Get Rates/button_chooseFile'))

 

def robot = new Robot()

StringSelection stringSelection = new StringSelection('C:\\Users\\enayem\\Downloads\\New folder\\ServiceDriveFile\\newdoc.pdf')
//C:\Users\enayem\Downloads\New folder\ServiceDriveFile\newdoc.pdf
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null)
//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null)

WebUI.delay(2)

robot.keyPress(KeyEvent.VK_CONTROL)
robot.keyPress(KeyEvent.VK_V)

robot.keyRelease(KeyEvent.VK_CONTROL)
robot.keyRelease(KeyEvent.VK_V)

WebUI.delay(2)

robot.keyPress(KeyEvent.VK_ENTER)
robot.keyRelease(KeyEvent.VK_ENTER)


WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/button_Upload'))

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/button_Begin Checkout'))

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/button_Proceed'))

