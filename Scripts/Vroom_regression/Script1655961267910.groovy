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


try {   
	
WebUI.callTestCase((findTestCase('Excel/ClearExcel')), null)               
WebUI.openBrowser('')
WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.VroomURL+oid)

WebUI.setText(findTestObject('Object Repository/Vroom/input_Current mileage_odometerId'), 
    mileage)

WebUI.click(findTestObject('Object Repository/Vroom/b_Get Your Price'))

WebUI.click(findTestObject('Object Repository/Vroom/div_Powertrain'))

WebUI.click(findTestObject('Object Repository/Vroom/div_Platinum'))
WebUI.click(findTestObject('null'))

//WebUI.selectOptionByValue(findTestObject('Object Repository/Vroom/select_termMileage'), 
 //   '5', true)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Vroom/select_termMileage'), 
        termLength, true)
WebUI.click(findTestObject('Object Repository/Vroom/span_View Payment Options'))

WebUI.click(findTestObject('Object Repository/Vroom/div_'+feePaymentPlan))

WebUI.click(findTestObject('Object Repository/Vroom/button_CHECKOUT'))

WebUI.setText(findTestObject('Object Repository/Vroom/input_First Name'), firstName)

WebUI.setText(findTestObject('Object Repository/Vroom/input_Last Name'), lastName)

WebUI.setText(findTestObject('Object Repository/Vroom/input_EmailAddress'), email)

WebUI.setText(findTestObject('Object Repository/Vroom/input_ConfirmEmail'), 
    email)

WebUI.setText(findTestObject('Object Repository/Vroom/input_Phone Number'), phoneNo)

WebUI.setText(findTestObject('Object Repository/Vroom/input__Address'), address)


WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ARROW_DOWN))
WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ENTER))

//CustomKeywords.'utility.Elementwait.waitForElement'(findTestObject('Object Repository/Vroom/Page_Vroom - Get Rates/input__registrationFormApi'))
//WebUI.click(findTestObject('Object Repository/Vroom/Page_Vroom - Get Rates/input__registrationFormApi'))

          
WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Billing'))


WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Billing'))

//WebUI.click(findTestObject('Object Repository/Vroom/label_add1'))

WebUI.click(findTestObject('Object Repository/Vroom/button_COMPLETE'))

WebUI.setText(findTestObject('Object Repository/Vroom/input_Name On Card'), nameOnCard)

WebUI.setText(findTestObject('Object Repository/Vroom/input_Card Number'), 
    cardNumber)

def d = Date.parse('MMM', expMonth)
def num = d.format('MM')

WebUI.selectOptionByValue(findTestObject('Object Repository/Vroom/select_Month'), 
    num, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Vroom/select_Year'), 
    expYear, true)

WebUI.setText(findTestObject('Object Repository/Vroom/input_CVC'), cvc)

WebUI.click(findTestObject('Object Repository/Vroom/label_Billing address check box'))

WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Review'))

WebUI.click(findTestObject('Object Repository/Vroom/button_Terms_and_conditions'))

WebUI.click(findTestObject('Object Repository/Vroom/label_acceptAgreement'))

WebUI.click(findTestObject('Object Repository/Vroom/span_Pay Now'))

//WebUI.click(findTestObject('Object Repository/Vroom/div_error_msg'))

WebUI.closeBrowser()    
}
catch (Exception e) {
    println('Exception Message is: ' + e)

    assertThat('').isEqualToIgnoringCase(e.toString())
} 

finally {
	'Writing the result to the excel file'                             
	WebUI.callTestCase(findTestCase('Excel/ExcelWrite'),
			[('testCase') : testCase
			, ('oid') : oid.trim()
			, ('mileage') : mileage.trim()
			, ('termLength') : termLength.trim()
			, ('firstName') : firstName.trim()
			, ('lastName') : lastName.trim()
			, ('email') : email.trim()
			, ('phoneNo') : phoneNo.trim()
			, ('address') : address.trim()
			, ('feePaymentPlan') : feePaymentPlan.trim()
			//s, ('initialPaymentAmount') : initialPaymentAmount.trim()			
			//, ('contractStatus') : contractStatus
			//, ('contractId') : contractId
			//, ('responseDescription') : responseDescription
			]
		, FailureHandling.CONTINUE_ON_FAILURE)

}
               

