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
import excelPackage.ExcelKeywords as ExcelKeywords
import utility.UtilKeywords as UtilKeywords


UtilKeywords utilKeywords = new UtilKeywords()
String currentDate = utilKeywords.getCurrentDate()

//String status = 'PASS'
//println(contractStatus)
//String responseDescription = 'SUCCESS'
//println(responseDescription)

String[] valueToWrite = new String[13]

(valueToWrite[0]) = testCase
(valueToWrite[1]) = oid
(valueToWrite[2]) = mileage
(valueToWrite[3]) = termLength
(valueToWrite[4]) = status
(valueToWrite[5]) = order_id
(valueToWrite[6]) = error_msg
//(valueToWrite[7]) = phoneNo
//(valueToWrite[8]) = address
//(valueToWrite[9]) = feePaymentPlan
//(valueToWrite[10]) = initialPaymentAmount
//(valueToWrite[11]) = contractStatus
//(valueToWrite[12]) = contractId              
//(valueToWrite[13]) = responseDescription

ExcelKeywords excelKeywords = new ExcelKeywords()
excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'Vroom_Result', valueToWrite)

