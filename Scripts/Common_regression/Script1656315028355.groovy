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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

try {
	
	WebUI.openBrowser('')
	WebUI.maximizeWindow()
	if(portal=="Vroom" || portal=="vroom")
	{
	      WebUI.navigateToUrl(GlobalVariable.VroomURL+oid)
		  baseURL=GlobalVariable.baseVroomURL
	}
	else if (portal=="Nissan" || portal=="nissan")
	{
		WebUI.navigateToUrl(GlobalVariable.NisssanASP_URL_ASP+oid)
		baseURL=GlobalVariable.baseNissanURL
	}
	WebUI.delay(5)
	
	if(vehicle_reg_province!="")
	{
		WebUI.selectOptionByLabel(findTestObject('Object Repository/'+portal+'/select_Vehicle_Reg_Province'),
			vehicle_reg_province, true)
			}
	
	WebUI.setText(findTestObject('Object Repository/'+portal+'/input_Current mileage_odometerId'),
		mileage)
	
	WebUI.click(findTestObject('Object Repository/'+portal+'/b_Get Your Price'))
	
	WebUI.delay(5)
	println(baseURL+'/my-asp-pricing')
	if((WebUI.getUrl()!=baseURL+'/my-vsp-pricing') && (WebUI.getUrl()!=baseURL+'/my-asp-pricing'))
	{
		WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/login_err.png')
		status='fail'
		error_msg='Failed to move to vsp pricing page'
		WebUI.closeBrowser()
		throw new Exception('Invalid entry in first page')
	}
	
	else
	{
	
	//if(portal=="vroom" || portal=="Vroom")
	//{
	WebUI.click(findTestObject('Object Repository/'+portal+'/div_'+plan))
	
	//WebUI.click(findTestObject('Object Repository/'+portal+'/div_Platinum'))
	//}
	
	//else if(portal=="Nissan" || portal == "nissan")
	//{
		//WebUI.click(findTestObject('Object Repository/'+portal+'/div_'+plan))
		
		//WebUI.click(findTestObject('Object Repository/'+portal+'/div_Gold'))
		
		//WebUI.click(findTestObject('Object Repository/'+portal+'/div_Platinum'))
		
		//WebUI.click(findTestObject('Object Repository/'+portal+'/div_31.24'))
	//}
	//WebUI.selectOptionByValue(findTestObject('Object Repository/Vroom/select_termMileage'),
	 //   '5', true)
	
		WebUI.selectOptionByLabel(findTestObject('Object Repository/'+portal+'/select_termMileage'),
			termLength, true)
		if((portal=="vroom" || portal=="Vroom") && (commercialUse=="yes" || commercialUse == "Yes"))
			{
				WebUI.click(findTestObject('Object Repository/'+portal+'/span_NoYes_lever'))
				}
			WebUI.click(findTestObject('Object Repository/'+portal+'/span_View Payment Options'))
	}
	WebUI.delay(5)
	if(WebUI.getUrl()!=baseURL+'/cart')
		{
			WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/vsp_page_err.png')
			status='fail'
			error_msg='Failed to move to rates page'
			WebUI.closeBrowser()
			throw new Exception('Invalid entry in pricing page')
		}
	
	else {
	WebUI.click(findTestObject('Object Repository/'+portal+'/div_'+feePaymentPlan))
	
	WebUI.click(findTestObject('Object Repository/'+portal+'/button_CHECKOUT'))
	}
	
	WebUI.delay(5)
	if(WebUI.getUrl()!=baseURL+'/checkout')
		{
			WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/rates_err.png')
			status='fail'
			error_msg='Failed to move to checkout page'
			WebUI.closeBrowser()
			throw new Exception('Invalid entry in rates page')
		}
	else 
		{
	WebUI.setText(findTestObject('Object Repository/'+portal+'/input_First Name'), firstName)
	
	WebUI.setText(findTestObject('Object Repository/'+portal+'/input_Last Name'), lastName)
	
	WebUI.setText(findTestObject('Object Repository/'+portal+'/input_EmailAddress'), email)
	
	WebUI.setText(findTestObject('Object Repository/'+portal+'/input_ConfirmEmail'),
		email)
	
	WebUI.setText(findTestObject('Object Repository/'+portal+'/input_Phone Number'), phoneNo)
	
	WebUI.setText(findTestObject('Object Repository/'+portal+'/input__Address'), address)
	
	
	WebUI.delay(1)
	WebUI.sendKeys(findTestObject('Object Repository/'+portal+'/input__Address'), Keys.chord(Keys.ARROW_DOWN))
	WebUI.sendKeys(findTestObject('Object Repository/'+portal+'/input__Address'), Keys.chord(Keys.ENTER))
	
	//CustomKeywords.'utility.Elementwait.waitForElement'(findTestObject('Object Repository/Vroom/Page_Vroom - Get Rates/input__registrationFormApi'))
	//WebUI.click(findTestObject('Object Repository/Vroom/Page_Vroom - Get Rates/input__registrationFormApi'))
	
			  
	WebUI.click(findTestObject('Object Repository/'+portal+'/button_Continue to Billing'))
	
	
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/'+portal+'/button_Continue to Billing'))
	
	//WebUI.click(findTestObject('Object Repository/Vroom/label_add1'))
	
	WebUI.click(findTestObject('Object Repository/'+portal+'/button_COMPLETE'))
	
	WebUI.setText(findTestObject('Object Repository/'+portal+'/input_Name On Card'), nameOnCard)
	
	WebUI.setText(findTestObject('Object Repository/'+portal+'/input_Card Number'),
		cardNumber)                     
	
	def d = Date.parse('MMM', expMonth)
	def num = d.format('MM')
	
	WebUI.selectOptionByValue(findTestObject('Object Repository/'+portal+'/select_Month'),
		num, true)
	
	WebUI.selectOptionByValue(findTestObject('Object Repository/'+portal+'/select_Year'),
		expYear, true)
	
	WebUI.setText(findTestObject('Object Repository/'+portal+'/input_CVC'), cvc)
	
	WebUI.click(findTestObject('Object Repository/'+portal+'/label_Billing address check box'))
	
	WebUI.click(findTestObject('Object Repository/'+portal+'/button_Continue to Review'))
	
	WebUI.click(findTestObject('Object Repository/'+portal+'/button_Terms_and_conditions'))
	                
	
	WebUI.click(findTestObject('Object Repository/'+portal+'/label_acceptAgreement'))
	
	//WebUI.delay(5)
	
    if(WebUI.verifyElementPresent(findTestObject('Object Repository/'+portal+'/input_termsState'), 5))
    {
		WebUI.click(findTestObject('Object Repository/'+portal+'/input_termsState'))
	}
	
	WebUI.click(findTestObject('Object Repository/'+portal+'/span_Pay Now'))
	
		}
		WebUI.delay(15)
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/'+portal+'/p_orderid'), 20)
		if(WebUI.getUrl()!=baseURL+'/checkout/confirmation')
			{
				WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/checkout_err.png')
				status='fail'
				error_msg='Error in checkout page data'
				WebUI.closeBrowser()
				throw new Exception('Invalid entry in checkout- page')
			}
			else
			{
	
				WebUI.verifyElementPresent(findTestObject('Object Repository/'+portal+'/p_orderid'), 5)
	
				orderid=WebUI.getText(findTestObject('Object Repository/'+portal+'/p_orderid'))
	
	
				//println(orderid)
				WebUI.closeBrowser()
			}
}
catch (Exception e) {
	println('Exception Message is: ' + e)

	//assertThat('').isEqualToIgnoringCase(e.toString())
}

finally {
	'Writing the result to the excel file'
	WebUI.callTestCase(findTestCase('Excel/ExcelWrite'),
			[('testCase') : testCase
			, ('oid') : oid.trim()
			, ('mileage') : mileage.trim()
			, ('termLength') : termLength.trim()
			, ('status') : status
			, ('error_msg') : error_msg
			, ('order_id') : orderid
			//, ('email') : email.trim()
			//, ('phoneNo') : phoneNo.trim()
			//, ('address') : address.trim()
			//, ('feePaymentPlan') : feePaymentPlan.trim()
			//, ('initialPaymentAmount') : initialPaymentAmount.trim()
			//, ('contractStatus') : contractStatus
			//, ('contractId') : contractId
			//, ('responseDescription') : responseDescription
			]
		, FailureHandling.CONTINUE_ON_FAILURE)

}
