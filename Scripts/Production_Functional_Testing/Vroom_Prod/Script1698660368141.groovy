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

import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import java.sql.*
import cucumber.api.java.en.When
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import utility.UtilKeywords as UtilKeywords
import excelPackage.ExcelKeywords as ExcelKeywords
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.time.Duration;
import java.time.Instant;

////new code for API-purchase contract
//import groovy.json.JsonSlurper
//import java.net.HttpURLConnection
//import java.net.URL
//
////----API-Purchase cotract---
//import com.kms.katalon.core.testobject.ConditionType
//import com.kms.katalon.core.testobject.RequestObject
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS



if(testCase=="1") 
//{
//			ExcelKeywords excelKeywords = new ExcelKeywords()
//
//			excelKeywords.deleteExcel(System.getProperty('user.dir'), 'Result.xlsx', 'GM_result');
//		}

WebUI.openBrowser('')
WebUI.maximizeWindow()
println(portal)
//WebUI.navigateToUrl(GlobalVariable.(portal)+'URL'+oid)

//////

if(portal=="Vroom" || portal=="vroom") {
	println('test')
	//WebUI.navigateToUrl(GlobalVariable.VroomURL+oid)
	if (oid != '') {
		WebUI.navigateToUrl(GlobalVariable.VroomURL+oid)
		println("get the oid")
		} else {
			WebUI.navigateToUrl('https://staging.vroomprotect.com/vehicle-service-protection')
			println(" not get the oid")
		}	
		baseURL=GlobalVariable.baseVroomURL
}
		
		if (vinNo != '') {
			WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_VIN_vin'),
				vinNo)
		
			WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_Current mileage_editVehicleOdometerVIN'),
				mileage)
		
			WebUI.selectOptionByValue(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/select_AlabamaAlaskaArizonaArkansasCaliforn_eff432'),
				vehicle_reg_province, true)
			println("get the vin")
			baseURL=GlobalVariable.baseVroomURL
		} else {
			WebUI.setText(findTestObject('Object Repository/Production/GMC/input_mileage'), mileage)
		
			WebUI.selectOptionByValue(findTestObject('Object Repository/Production/GMC/input_province'), vehicle_reg_province, true)
			println("not get the vin")
			baseURL=GlobalVariable.baseVroomURL
		}
	


WebUI.delay(5)



// Write code here that turns the phrase above into concrete actions

//WebUI.click(findTestObject('Object Repository/'+portal+'/b_Get Your Price'))
WebUI.click(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/button_Find My Price_Vroom'))

WebUI.delay(7)
if ((WebUI.getUrl() != ((('https://staging.vroomprotect.com' + '/my-vsp-pricing')))))
	//&& (WebUI.getUrl() != ("https://staging.vroomprotect.com" + '/my-vsp-pricing'))) 
	
{


		def actualVinErrorText = WebUI.getText(findTestObject('Object Repository/Vroom/Vin_Error_Text'))
		println(actualVinErrorText)

		if(actualVinErrorText.contains(expectedVinErrorText)) {
			WebUI.delay(2)
			WebUI.closeBrowser()
			
			def comment = 'STOP_TEST_EXECUTION'
			
						if (comment == "STOP_TEST_EXECUTION") {
							KeywordUtil.markFailedAndStop("Test execution stopped forcefully due to wrong vin.")
						}
			
		}
	
}

WebUI.delay(5)
println(WebUI.getUrl())
println(baseURL+'/my-asp-pricing')
//if((WebUI.getUrl()!=baseURL+'/my-vsp-pricing?plan='+portal.toUpperCase()+'1') && (WebUI.getUrl()!=baseURL+'/plans-pricing?plan='+portal.toUpperCase()+'1') && (WebUI.getUrl()!=baseURL+'/my-vsp-pricing?plan=CHEVY1') && (WebUI.getUrl()!=baseURL+'/my-asp-pricing'))
if(WebUI.getUrl()!=baseURL+"/my-vsp-pricing" )
//if(WebUI.getUrl()!='https://mango-rewrite-qa.herokuapp.com/my-vsp-pricing' && WebUI.getUrl()!='https://mango-rewrite-qa.herokuapp.com/my-vsp-pricing' )

{
	WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/'+testCase+'login_err.png')
	status='fail'
	error_msg='Failed to move to plans pricing page'

}

if(status=='Pass') {
	try {
		if(plan=="")
		{
			plan="Platinum"
		}
		
		WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/Vroom_div_'+plan))

		WebUI.selectOptionByLabel(findTestObject('Object Repository/Vroom/select_termMileage'),
				termLength, true)


		
		if(deductible=='100' && portal=='Schomp')
		{
			WebUI.waitForElementClickable(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductile_100'), 30)
			UtilKeywords utilKeywordst = new UtilKeywords()
			utilKeywordst.clickUsingJS(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductile_100'), 30)
		}
		if(deductible=='250'&& portal=='Schomp')
		{
			WebUI.waitForElementClickable(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductible_250'), 30)
			UtilKeywords utilKeywordst = new UtilKeywords()
			utilKeywordst.clickUsingJS(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductible_250'), 30)
			//CustomKeywords.'com.example.WebUIKeywords.clickUsingJS'(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductible_250'), 30)
			//WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductible_250'))
		}


		WebUI.click(findTestObject('Object Repository/Vroom/span_View Payment Options'))
	}
	catch(Exception e)
	{WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/'+testCase+'vsp_page_err.png')
		status='fail'
		error_msg='Failed to move to rates page'
	}
	WebUI.delay(5)
	if(WebUI.getUrl()!=baseURL+'/cart')
	{
		WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/'+testCase+'Plans_page_err.png')
		status='fail'
		error_msg='Failed to move to rates page'

	}
	println(status)
}

//verify pdf is downloadable or not : link_01
CustomKeywords.'pdf_verification.pdf_url_check.sample_agreement_link_cartPage_vroom'()
link1 = 'Link working:Cart Page->VIEW AGREEMENT AND EXCLUSIONS '
if(status=='Pass')
{
	try {
		//this.feePaymentPlan=feePaymentPlan
		if(feePaymentPlan=="")
		{
			if(WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_36 months')))
			{ feePaymentPlan="36 months" }
			else if(WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_30 months')))
			{feePaymentPlan="30 months"}
			else if(WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_24 months')))
			{feePaymentPlan="24 months"}
			else if(WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_12 months')))
			{feePaymentPlan="18 months"}
			else if(WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_18 months')))
				{feePaymentPlan="12 months"}
			else if(WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_6 months')))
			{feePaymentPlan="6 months"}
			else if (WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_pay in full'))) {
				feePaymentPlan = 'Pay In Full'
			}
		}
		//WebUI.click(findTestObject('Object Repository/'+portal+'/links/span_View Payment Options'))


		WebUI.click(findTestObject('Object Repository/Vroom/div_'+feePaymentPlan))
		///
		//cart calculation

		TestObject subtotalCartPage = findTestObject('Object Repository/Vroom/Vroom_cart_subtotal')
		String subtotalText = WebUI.getText(subtotalCartPage)
		float subtotal = subtotalText.replaceAll('\\$|\\.\\d+|,', '') as float
		println(subtotal)
		
//		if ((portal.equalsIgnoreCase('GMC') || portal.equalsIgnoreCase('Chevrolet'))) {
//			println(portal)
//			println(commercialUse + " " + liftKit )
		println(commercialUse)
			if (commercialUse.equalsIgnoreCase('yes')) {
				TestObject lever1 = findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever1_vroom')
				WebUI.click(lever1)
				WebUI.delay(3)
				subtotal += 250
				
				String subtotalWithSurchargeText = WebUI.getText(subtotalCartPage)
				float subtotalWithSurcharge = subtotalWithSurchargeText.replaceAll('\\$|\\.\\d+|,', '') as float
				
				assert subtotal == subtotalWithSurcharge : "Surcharge is added to the cart."
				println('Surcharge added successfully.')
			}
			
			
		WebUI.delay(5)
		//////
		
		if (feePaymentPlan != 'Pay In Full') {
		totalrate=WebUI.getText((findTestObject('Object Repository/Vroom/Vroom_cart_totalRate')))
		totalDueToday_cartPage=WebUI.getText(findTestObject('Object Repository/Vroom/Vroom_cart_TotalDueToday'))
		subtotal_cartPage=WebUI.getText(findTestObject('Object Repository/Vroom/Vroom_cart_subtotal'))
		trimmed_subtotal = subtotal_cartPage.replaceAll('\\$|\\.\\d+|,', '') as float
		trimmed_totalDueToday = totalDueToday_cartPage.replaceAll(/[^0-9.]/, '') as float
		trimmed_totalrate = totalrate.replaceAll(/[^0-9.]/, '') as float


		if(initial_payment != '') {
		initialPay = (((initial_payment as int) / 100 ) * trimmed_subtotal).toString()
		println(initialPay)
		WebUI.clearText(findTestObject('Object Repository/Vroom/Vroom_initial_payment_input'))
		WebUI.sendKeys(findTestObject('Object Repository/Vroom/Vroom_initial_payment_input'), initialPay)
		
	
	
			//////////edit for here//////////			
		strrr_cart = WebUI.getText((findTestObject('Object Repository/Vroom/Vroom_cart_calculation'))) /// ex.18 Monthly Payments of $98.83
		println(strrr_cart)
		//trimmed_totalrate = totalrate.replaceAll('\\$|\\.\\d+|,', '') as int
		//trimmed_totalDueToday = totalDueToday_cartPage.replaceAll('\\$|\\.\\d+|,', '') as int
		println(trimmed_totalrate + " " + trimmed_totalDueToday)
		duesAfterInitialPay = trimmed_totalrate - trimmed_totalDueToday as float
		println(duesAfterInitialPay)
		def match_month_cart = strrr_cart.find(/\d+/)?.toInteger()
		//def month = match_month[0].toInteger()		
		println("  ssss"+duesAfterInitialPay+ " " + match_month_cart)	
		def match_pay = strrr_cart.find(/\$\d+\.\d{2}/)
		def cart_num = strrr_cart.tokenize('$')[1].toDouble().toFloat()
		println(cart_num)
		cart_cal = (duesAfterInitialPay / match_month_cart).round(2) as float
		println(cart_cal)
		println(cart_cal + " " + cart_num)
		
		
		if(cart_cal == cart_num) {
			
			cartPageCal = 'For customized initial Pay: '+initial_payment+'% ,Monthly payment after initial pay is : '+duesAfterInitialPay+" || For "+match_month_cart+"months Remaining payment, calculation is matched in Cart page "
			print(cartPageCal)
			}
			else{
				cartPageCal = 'cartPageCalculation is not Accurate'
			}
		}else {
			
			tenPercentsubtotal = trimmed_subtotal * 0.1 as float	
			strrr_cart = WebUI.getText((findTestObject('Object Repository/Vroom/Vroom_cart_calculation'))) /// ex.18 Monthly Payments of $98.83
			duesAfterInitialPay = trimmed_totalrate - trimmed_totalDueToday as float
			def match_month_cart = strrr_cart.find(/\d+/)?.toInteger()
			//def month = match_month[0].toInteger()
			def match_pay = strrr_cart.find(/\$\d+\.\d{2}/)
			def cart_num = strrr_cart.tokenize('$')[1].toDouble().toFloat()

			cart_cal = (duesAfterInitialPay / match_month_cart).round(2) as float
			def cartPageCal = ''
			if(cart_cal == cart_num && tenPercentsubtotal == trimmed_totalDueToday) {
				cartPageCal = 'Initial Pay, and monthly payment calculation is accurate in cart page'
				println(cartPageCalculation)
			}else {
			
			 cartPageCal = 'cartPageCalculation is not Accurate'
			println(cartPageCalculation)
		}
		}
		///////////////////
		}else {
			cartPageCalculation = 'Calculation is not applicable for PAY IN FULL option'
			
			totalDueToday_cartPage=WebUI.getText(findTestObject('Object Repository/Vroom/Vroom_cart_TotalDueToday'))
			subtotal_cartPage=WebUI.getText(findTestObject('Object Repository/Vroom/Vroom_cart_subtotal'))
			trimmed_subtotal = subtotal_cartPage.replaceAll('\\$|\\.\\d+|,', '') as float
			trimmed_totalDueToday = totalDueToday_cartPage.replaceAll(/[^0-9.]/, '') as float
			
		}

		

		WebUI.click(findTestObject('Object Repository/Vroom/button_CHECKOUT'))

	}
	catch(Exception E)
	{
		WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/'+testCase+'rates_err.png')
		status='fail'
		error_msg='Failed to move to checkout page'}
	
	WebUI.delay(5)
	if(WebUI.getUrl()!=baseURL+'/checkout')
	{
		WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/'+testCase+'rates_err.png')
		status='fail'
		error_msg='Failed to move to checkout page'


	}
}
CustomKeywords.'pdf_verification.pdf_url_check.sample_agreement_link_checkoutPage_contact_vroom'()
link4 = 'Link working:Checkout Page_Contact Page->VIEW AGREEMENT AND EXCLUSIONS'
// Write code here that turns the phrase above into concrete actions
if(status=='Pass')
{
//from here
	try {

//		salesTax=WebUI.getText(findTestObject('Object Repository/Vroom/sales_tax'))
//		totalrate=WebUI.getText((findTestObject('Object Repository/Vroom/CartTotal_rates')))
		WebUI.setText(findTestObject('Object Repository/Vroom/input_First Name'), firstName)

		WebUI.setText(findTestObject('Object Repository/Vroom/input_Last Name'), lastName)

		WebUI.setText(findTestObject('Object Repository/Vroom/input_EmailAddress'), email)

		WebUI.setText(findTestObject('Object Repository/Vroom/input_ConfirmEmail'),
				email)

		WebUI.setText(findTestObject('Object Repository/Vroom/input_Phone Number'), phoneNo)
		

		
		//new code
		// Wait for the address input field to be visible
		WebUI.waitForElementVisible(findTestObject('Object Repository/Vroom/input__Address'), 10)
		WebUI.setText(findTestObject('Object Repository/Vroom/input__Address'), address)

		WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ARROW_DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ENTER))

		// Wait for the "Continue to Billing" button to be clickable
		//WebUI.waitForElementClickable(findTestObject('Object Repository/Vroom/button_Continue to Billing'), 10)
		WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Billing'))
		
		WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Billing'))
		
		

		//WebUI.click(findTestObject('Object Repository/Vroom/label_add1'))

		WebUI.click(findTestObject('Object Repository/Vroom/button_COMPLETE'))
	}
	catch(Exception E)
	{
		WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/'+testCase+'personaldata_err.png')
		status='fail'
		error_msg='personal data page error'}

}

CustomKeywords.'pdf_verification.pdf_url_check.sample_agreement_link_checkoutPage_contact_vroom'()
link5 = 'PDF working:Cart Page_Billingt Page->VIEW AGREEMENT AND EXCLUSIONS'
///////start//////
if(status=='Pass') {
	try {
		//checkout page accounting
		println(trimmed_totalDueToday)

		if (feePaymentPlan != 'Pay In Full') {
			
			subtotal=WebUI.getText(findTestObject('Object Repository/Vroom/Vroom_subtotal_checkoutpage'))
			salesTax=WebUI.getText(findTestObject('Object Repository/Vroom/Vroom_sales_tax_checkoutpage'))
			totalrate=WebUI.getText((findTestObject('Object Repository/Vroom/vroom_Total_rate_checkoutpage')))
			
			strrr = WebUI.getText((findTestObject('Object Repository/Vroom/checkOutCalculation')))
		totalDueToday_checkout = WebUI.getText((findTestObject('Object Repository/Vroom/Vroom_checkout_TotalDueToday')))
		trimmed_totalrate = totalrate.replaceAll(/[^0-9.]/, '') as float
		trimmed_totalDueToday_checkout = totalDueToday_checkout.replaceAll(/[^0-9.]/, '') as float
		println(trimmed_totalrate + " " + trimmed_totalDueToday_checkout)
		duesAfterInitialPay = trimmed_totalrate - trimmed_totalDueToday_checkout as float
		def match_month = strrr.find(/\d+/)?.toInteger()
		//def month = match_month[0].toInteger()

		
		println("  ssss"+duesAfterInitialPay+ " " + match_month)
	
		def match_pay = strrr.find(/\$\d+\.\d{2}/)
		def num = strrr.tokenize('$')[1].toDouble().toFloat()
		checkout_cal = (duesAfterInitialPay / match_month).round(2) as float
		println(checkout_cal + " " + num)
		
		if(checkout_cal == num) {
			
			checkoutPageCal = 'Total dues after initial pay is : '+duesAfterInitialPay+" || For "+match_month+" Remaining payment calculation is matched in Checkout page"
			print(checkoutPageCal)
			}
			else{
				checkoutPageCal = 'Calculation is not matched for Checkout page'
			}
		}else {
			checkoutPageCal = 'Calculation is not applicable for PAY IN FULL option'
			subtotal=WebUI.getText(findTestObject('Object Repository/Vroom/rates_subtotal'))
			salesTax=WebUI.getText(findTestObject('Object Repository/Vroom/sales_tax'))
			
		}
		///////////end///////////

		WebUI.delay(3)
		WebUI.setText(findTestObject('Object Repository/Schomp/input_Name On Card'), nameOnCard)

		WebUI.setText(findTestObject('Object Repository/Schomp/input_Card Number'),cardNumber)
		//		cardNumber)

		//def d = Date.parse('MMM', GlobalVariable.expMonth)
		//def num = d.format('MM')

		WebUI.selectOptionByLabel(findTestObject('Object Repository/Schomp/select_Month'),expMonth,true)
			//	num, true)

		WebUI.selectOptionByValue(findTestObject('Object Repository/Schomp/select_Year'),expYear,true)
			//	expYear, true)

		WebUI.setText(findTestObject('Object Repository/Schomp/input_CVC'), cvc)

		WebUI.click(findTestObject('Object Repository/Vroom/label_Billing address check box'))

		//WebUI.delay(30)
		
		//WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Review'))
		
		// Capture the current time before clicking the button
		Instant startTime = Instant.now();
		
		WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Review'))
		
		// Wait for the page to load or for any subsequent actions to complete
		// You can use WebUI.waitFor* methods or any other suitable waiting mechanism here
		
		

		WebUI.click(findTestObject('Object Repository/Vroom/button_Terms_and_conditions'))
		
		// Capture the current time after the waiting period
		Instant endTime = Instant.now();
		
		// Calculate the elapsed time in milliseconds
		Duration duration = Duration.between(startTime, endTime);
		long waitingTimeMillis = duration.toMillis();
		
		// Print the waiting time
		System.out.println("Waiting Time: " + waitingTimeMillis + " milliseconds");
	 

		
		WebUI.click(findTestObject('Object Repository/Nissan/label_acceptAgreement'))
		WebUI.delay(5)
		if(vehicle_reg_province == 'GA') {
		WebUI.click(findTestObject('Object Repository/Vroom/vroom_gorgia_consent'))
		}
		
	WebUI.delay(5)
	}
	catch(Exception E)
	{
		/////

		////
		WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/'+testCase+'payment_err.png')
		status='fail'
		error_msg='payment data page error'}
}









//WebUI.closeBrowser()
writeResult()
WebUI.delay(7)
//writeResult()
WebUI.closeBrowser()



	def writeResult()
	{
		'Writing the result to the excel file'
		UtilKeywords utilKeywords = new UtilKeywords()
		String currentDate = utilKeywords.getCurrentDate()

		//String status = 'PASS'
		//println(contractStatus)
		//String responseDescription = 'SUCCESS'
		//println(responseDescription)

		String[] valueToWrite = new String[80]

		(valueToWrite[0]) = testCase
		
			(valueToWrite[1]) = portal
		
			(valueToWrite[2]) = vinNo
		
			(valueToWrite[3]) = firstName
		
			(valueToWrite[4]) = lastName
		
			(valueToWrite[5]) = vehicle_reg_province
		
			(valueToWrite[6]) = plan
		
			(valueToWrite[7]) = termLength
		
			(valueToWrite[8]) = mileage
		
			(valueToWrite[9]) = feePaymentPlan
		
			(valueToWrite[10]) = subtotal
		
			(valueToWrite[11]) = salesTax
		
			(valueToWrite[12]) = totalrate
		
			(valueToWrite[13]) = status
		
			(valueToWrite[14]) = customerOrderNo
		
			(valueToWrite[15]) = verifyDB
		
			(valueToWrite[16]) = cms_contract_Id
		
			(valueToWrite[17]) = currentDate
		
			(valueToWrite[18]) = error_msg
		
//			(valueToWrite[19]) = first_query_result
		
//			(valueToWrite[20]) = second_query_result
		
//			(valueToWrite[21]) = third_query_result
		
//			(valueToWrite[22]) = fourth_query_result
		
//			(valueToWrite[23]) = fifth_query_result
		
//			(valueToWrite[24]) = sixth_query_result
//		
//			(valueToWrite[25]) = seventh_query_result
//		
//			(valueToWrite[26]) = eightth_query_result
			(valueToWrite[24]) = link1
			(valueToWrite[25]) = link4
			(valueToWrite[26]) = link5
		
//			(valueToWrite[27]) = pdfResultPrint
		
		//	(valueToWrite[28]) = link2
		
		//	(valueToWrite[29]) = link3
		
			(valueToWrite[28]) = cartPageCal
		
			(valueToWrite[29]) = checkoutPageCal
		
			//(valueToWrite[32]) = link6
		
			//(valueToWrite[33]) = link7
		
			//(valueToWrite[34]) = link8
		
			//(valueToWrite[35]) = link9


		ExcelKeywords excelKeywords = new ExcelKeywords()
	
		excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result - Prod.xlsx', 'Vroom_Result', valueToWrite)

		
		
	}
	
	
	