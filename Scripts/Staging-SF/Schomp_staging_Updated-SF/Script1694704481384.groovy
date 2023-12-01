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

import java.sql.*
import cucumber.api.java.en.When
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import utility.UtilKeywords as UtilKeywords
import excelPackage.ExcelKeywords as ExcelKeywords
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

if(testCase !="") 
//	   {
//			ExcelKeywords excelKeywords = new ExcelKeywords()
//
//			excelKeywords.deleteExcel(System.getProperty('user.dir'), 'Result.xlsx', 'Vroom_Result');
//		}

WebUI.openBrowser('')
WebUI.maximizeWindow()
println(portal)
//WebUI.navigateToUrl(GlobalVariable.(portal)+'URL'+oid)
/*  --- Old code-----
if(portal=="Vroom" || portal=="vroom") {
	println('test')
	WebUI.navigateToUrl(GlobalVariable.VroomURL+oid)
	baseURL=GlobalVariable.baseVroomURL
}
**/
//////

if(portal=="Schomp" || portal=="schomp") {
	println('test')
	//WebUI.navigateToUrl(GlobalVariable.VroomURL+oid)
	if (oid != '') {
		WebUI.navigateToUrl(GlobalVariable.SchompURL+oid)
		println("get the oid")
		} else {
			WebUI.navigateToUrl('https://staging.oneprotectplans.com/vehicle-service-protection')
			println(" not get the oid")
		}	
		baseURL=GlobalVariable.baseSchompURL
}
		
		if (vinNo != '') {
			WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_VIN_vin'),
				vinNo)
		
			WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_Current mileage_editVehicleOdometerVIN'),
				mileage)
		
			WebUI.selectOptionByValue(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/select_AlabamaAlaskaArizonaArkansasCaliforn_eff432'),
				vehicle_reg_province, true)
			println("get the vin")
			baseURL=GlobalVariable.baseSchompURL
		} else {
			WebUI.setText(findTestObject('Object Repository/Production/GMC/input_mileage'), mileage)
		
			WebUI.selectOptionByValue(findTestObject('Object Repository/Production/GMC/input_province'), vehicle_reg_province, true)
			println("not get the vin")
			baseURL=GlobalVariable.baseSchompURL
		}


// Write code here that turns the phrase above into concrete actions

//WebUI.click(findTestObject('Object Repository/'+portal+'/b_Get Your Price'))
WebUI.click(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/button_Find My Price_Vroom'))

WebUI.delay(7)
if ((WebUI.getUrl() != ((('https://staging.oneprotectplans.com' + '/my-vsp-pricing')))))
	//&& (WebUI.getUrl() != ("https://staging.vroomprotect.com" + '/my-vsp-pricing')))
	
{


		def actualVinErrorText = WebUI.getText(findTestObject('Object Repository/Schomp/Vin_Error_Text'))
		println(actualVinErrorText)

		if(actualVinErrorText.contains(expectedVinErrorText)) {
			WebUI.delay(2)
			WebUI.closeBrowser()
			
			def comment = 'STOP_TEST_EXECUTION'
			
						if (comment == "STOP_TEST_EXECUTION") {
							//error_msg='Failed to move to plans pricing page'
							//writeResult()
							KeywordUtil.markFailedAndStop("Test execution stopped forcefully due to wrong vin.")
							
						}
//						else {
//							//vinNo
//							error_msg='Failed to move to plans pricing page'
//							writeResult()
//						}

			
		}
	
}



WebUI.delay(5)

if(status=='Pass') {
	try {
		if(plan=="")
		{
			plan="Platinum"
		}
		
		WebUI.click(findTestObject('Object Repository/Schomp/div_'+plan))

		WebUI.selectOptionByLabel(findTestObject('Object Repository/Vroom/select_termMileage'),
				termLength, true)

		WebUI.delay(2)
		// New Deductible implementation-->
		if(plan=='Gold' && portal=='Schomp') {
			if(deductible=='0'){
				WebUI.waitForElementClickable(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Gold_0'), 30)
				UtilKeywords utilKeywordst = new UtilKeywords()
				utilKeywordst.clickUsingJS(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Gold_0'), 30)
		}
			if(deductible=='100'){
					WebUI.waitForElementClickable(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deductible_Gold_100'), 30)
					UtilKeywords utilKeywordst = new UtilKeywords()
					utilKeywordst.clickUsingJS(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deductible_Gold_100'), 30)
					
					if( (disappearing_deductible == "yes" || disappearing_deductible == "Yes"))
						{
					WebUI.click(findTestObject('Object Repository/Schomp/Schomp_Deductibles/gold_span_NoYes_lever'))
					}
			}
			if(deductible=='250'){
				WebUI.waitForElementClickable(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Gold_250'), 30)
				UtilKeywords utilKeywordst = new UtilKeywords()
				utilKeywordst.clickUsingJS(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Gold_250'), 30)
		}}
			
		else if(plan=='Platinum' && portal=='Schomp') {
			if(deductible=='0'){
				WebUI.waitForElementClickable(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Platinum_0'), 30)
				UtilKeywords utilKeywordst = new UtilKeywords()
				utilKeywordst.clickUsingJS(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Platinum_0'), 30)
		}
			if(deductible=='100'){
					WebUI.waitForElementClickable(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Platinum_100'), 30)
					UtilKeywords utilKeywordst = new UtilKeywords()
					utilKeywordst.clickUsingJS(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Platinum_100'), 30)
					
					if( (disappearing_deductible == "yes" || disappearing_deductible == "Yes"))
						{
					WebUI.click(findTestObject('Object Repository/Schomp/Schomp_Deductibles/platinum_span_NoYes_lever'))
					}
			}
			if(deductible=='250'){
				WebUI.waitForElementClickable(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Platinum_250'), 30)
				UtilKeywords utilKeywordst = new UtilKeywords()
				utilKeywordst.clickUsingJS(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Platinum_250'), 30)
		}}
		else if(plan=='Powertrain' && portal=='Schomp') {
			if(deductible=='0'){
				WebUI.waitForElementClickable(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Powertrain_0'), 30)
				UtilKeywords utilKeywordst = new UtilKeywords()
				utilKeywordst.clickUsingJS(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Powertrain_0'), 30)
		}
			if(deductible=='100'){
					WebUI.waitForElementClickable(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Powertrain_100'), 30)
					UtilKeywords utilKeywordst = new UtilKeywords()
					utilKeywordst.clickUsingJS(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Powertrain_100'), 30)
					
					if( (disappearing_deductible == "yes" || disappearing_deductible == "Yes"))
						{
					WebUI.click(findTestObject('Object Repository/Schomp/Schomp_Deductibles/powertrain_span_NoYes_lever'))
					}
			}
			if(deductible=='250'){
				WebUI.waitForElementClickable(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Powertrain_250'), 30)
				UtilKeywords utilKeywordst = new UtilKeywords()
				utilKeywordst.clickUsingJS(findTestObject('Object Repository/Schomp/Schomp_Deductibles/deducticble_Powertrain_250'), 30)
		}}
		
		//----->


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
//		WebUI.clearText(findTestObject('Object Repository/Vroom/Vroom_initial_payment_input'))
//		WebUI.sendKeys(findTestObject('Object Repository/Vroom/Vroom_initial_payment_input'), initialPay)
		
		//int_trimmed_totalDueToday =trimmed_subtotal as int 

		//println(tenPercentsubtotal +"   "+trimmed_totalDueToday+'Total :' +trimmed_totalrate )
		//roundtenPercenttotalDueToday = tenPercenttotalDueToday.round()
		//println('totalDueToday_cartPage:' +totalDueToday_cartPage + 'subtotal_cartPage: '+subtotal_cartPage +'trimmed_subtotal: '+ trimmed_subtotal +'tenPercentsubtotal: '+ tenPercentsubtotal )
	
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

		WebUI.setText(findTestObject('Object Repository/Vroom/input__Address'), address)


		WebUI.delay(1)
		WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ARROW_DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ENTER))

		//CustomKeywords.'utility.Elementwait.waitForElement'(findTestObject('Object Repository/Vroom/Page_Vroom - Get Rates/input__registrationFormApi'))
		//WebUI.click(findTestObject('Object Repository/Vroom/Page_Vroom - Get Rates/input__registrationFormApi'))
		WebUI.delay(1)

		WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Billing'))


		WebUI.delay(1)



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
if(status=='Pass') {
	try {
		//checkout page accounting
		println(trimmed_totalDueToday)

//		if (feePaymentPlan != 'Pay In Full') {
//			
//			subtotal=WebUI.getText(findTestObject('Object Repository/Schomp/rates_subtotal - Staging'))
//			salesTax=WebUI.getText(findTestObject('Object Repository/Schomp/sales_tax'))
//			totalrate=WebUI.getText((findTestObject('Object Repository/Schomp/total_rates')))
//			
//		strrr = WebUI.getText((findTestObject('Object Repository/Schomp/remainingPayment')))
//		totalDueToday_checkout = WebUI.getText((findTestObject('Object Repository/Schomp/checkout_TotalDueToday')))
//		trimmed_totalrate = totalrate.replaceAll(/[^0-9.]/, '') as float
//		trimmed_totalDueToday_checkout = totalDueToday_checkout.replaceAll(/[^0-9.]/, '') as float
//		println(trimmed_totalrate + " " + trimmed_totalDueToday_checkout)
//		duesAfterInitialPay = trimmed_totalrate - trimmed_totalDueToday_checkout as float
//		def match_month = strrr.find(/\d+/)?.toInteger()
//		//def month = match_month[0].toInteger()
//
//		
//		println("  ssss"+duesAfterInitialPay+ " " + match_month)
//	
//		def match_pay = strrr.find(/\$\d+\.\d{2}/)
//		def num = strrr.tokenize('$')[1].toDouble().toFloat()
//		checkout_cal = (duesAfterInitialPay / match_month).round(2) as float
//		println(checkout_cal + " " + num)
//		
//		if(checkout_cal == num) {
//			
//			checkoutPageCal = 'Total dues after initial pay is : '+duesAfterInitialPay+" || For "+match_month+" Remaining payment calculation is matched in Checkout page"
//			print(checkoutPageCal)
//			}
//			else{
//				checkoutPageCal = 'Calculation is not matched for Checkout page'
//			}
//		}else {
//			checkoutPageCal = 'Calculation is not applicable for PAY IN FULL option'
//			subtotal=WebUI.getText(findTestObject('Object Repository/Schomp/rates_subtotal'))
//			salesTax=WebUI.getText(findTestObject('Object Repository/Schomp/sales_tax'))
//			
//		}
		
		///-- Checkout calculation start-->
		if (feePaymentPlan != 'Pay In Full') {
			if(commercialUse.equalsIgnoreCase('')) {
				subtotal=WebUI.getText(findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Without-Surcharge/Without-Subtotal'))
				salesTax=WebUI.getText(findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Without-Surcharge/Without-SalesTax'))
				totalrate=WebUI.getText((findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Without-Surcharge/Without-TotalRates')))
			strrr = WebUI.getText((findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Without-Surcharge/Without-MonthlyPayment')))
			totalDueToday_checkout = WebUI.getText((findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Without-Surcharge/Without-TotalDueToday')))
			}
			if((commercialUse.equalsIgnoreCase('yes')) ) {
				subtotal=WebUI.getText(findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Single-Surcharge/Single-Subtotal'))
				salesTax=WebUI.getText(findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Single-Surcharge/Single-SalesTax'))
				totalrate=WebUI.getText((findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Single-Surcharge/Single-TotalRates')))
			strrr = WebUI.getText((findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Single-Surcharge/Single-MonthlyPayment')))
			totalDueToday_checkout = WebUI.getText((findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Single-Surcharge/Single-TotalDueToday')))
		 
			}
		//		strrr = WebUI.getText((findTestObject('Object Repository/Vroom/checkOutCalculation')))
		//		totalDueToday_checkout = WebUI.getText((findTestObject('Object Repository/Vroom/Vroom_checkout_TotalDueToday')))
				trimmed_subtotal = subtotal.replaceAll(/[^0-9.]/, '') as float
				trimmed_salestax = salesTax.replaceAll(/[^0-9.]/, '') as float
				trimmed_totalrate = totalrate.replaceAll(/[^0-9.]/, '') as float
				trimmed_monthlyPayment = strrr.tokenize('$')[1].toDouble().toFloat()
				trimmed_totalDueToday_checkout = totalDueToday_checkout.replaceAll(/[^0-9.]/, '') as float
				println("Total rate= "+ trimmed_totalrate)
				println("Total due today= "+ trimmed_totalDueToday_checkout)
				println("Sales Tax= "+ trimmed_salestax)
				println("Sub Total= "+ trimmed_subtotal)
				println("Monthly Payment= "+ trimmed_monthlyPayment)
		
				//total due today calculation and matching
				totalDueToday1 = trimmed_salestax + trimmed_monthlyPayment as float
				println(totalDueToday1)
				if(totalDueToday1 == trimmed_totalDueToday_checkout) {
					CheckoutTotalDueTodayMessage = "Calculation for total due today is matched"
					println(CheckoutTotalDueTodayMessage)
				}else {
					CheckoutTotalDueTodayMessage = "Calculation for total due today is not matched"
					println(CheckoutTotalDueTodayMessage)
				}///end
				//remaining payments calculation and matching
				if(feePaymentPlan != 'Pay In Full' ) {
					trimmedfeePaymentPlan = feePaymentPlan.find(/\d+/)?.toInteger()
					println(trimmedfeePaymentPlan)
					remainingPayment1 = trimmed_subtotal/trimmedfeePaymentPlan as float
					println(remainingPayment1)
					def roundedMonthlyPayment = new BigDecimal(remainingPayment1.toString()).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue() // Round the result to two decimal places using BigDecimal
					println(roundedMonthlyPayment)
					if(roundedMonthlyPayment == trimmed_monthlyPayment ) {
						remainingPaymentMessage = "Calculation for remaining payment is matched"
						println(remainingPaymentMessage)
					}else {
						remainingPaymentMessage = "Calculation for remaining payment is not matched"
						println(remainingPaymentMessage)
					}
				}///end
				//total rates calculation and matching
					totalrates1 = trimmed_subtotal + trimmed_salestax as float
					println(totalrates1)
					if(totalrates1 == trimmed_totalrate ) {
						totalrateMessage = "Calculation for total rate is matched"
						println(totalrateMessage)
					}else {
						totalrateMessage = "Calculation for total rate is not matched"
						println(totalrateMessage)
					}	///end
		
		
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
				}else { // payInFull
			if(commercialUse.equalsIgnoreCase('')) {
				subtotal=WebUI.getText(findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Without-Surcharge/Without-Subtotal'))
				salesTax=WebUI.getText(findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Without-Surcharge/Without-SalesTax'))
				totalDueToday_checkout=WebUI.getText((findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Without-Surcharge/Without-TotalRates')))
				totalrate = "total due today is total amount in pay in full"
				trimmed_monthlyPayment = "no remaining payment for Pay In Full"
				remainingPaymentMessage = "no remaining payment message for Pay In Full"
				totalrateMessage = "no total amount message for Pay In Full"
				CheckoutTotalDueTodayMessage = "total due today is total amount in pay in full"
			}
			if((commercialUse.equalsIgnoreCase('yes')) ) {
				subtotal=WebUI.getText(findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Single-Surcharge/Single-Subtotal'))
				salesTax=WebUI.getText(findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Single-Surcharge/Single-SalesTax'))
				totalDueToday_checkout=WebUI.getText((findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Single-Surcharge/Single-TotalRates')))
				totalrate = "total due today is total amount in pay in full"
				trimmed_monthlyPayment = "no remaining payment for Pay In Full"
				remainingPaymentMessage = "no remaining payment message for Pay In Full"
				totalrateMessage = "no total amount message for Pay In Full"
				CheckoutTotalDueTodayMessage = "total due today is total amount in pay in full"
			}
				}
				
		//---END-->		
		
		println(subtotal)
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

		//WebUI.click(findTestObject('Object Repository/Vroom/label_Billing address check box'))
		//---new code--//
		if (billingAddress == '') {
			WebUI.click(findTestObject('Object Repository/Vroom/label_Billing address check box'))
				
			}
			else if(billingAddress !='') {
				WebUI.setText(findTestObject('Object Repository/Nissan/Nissan_input__Address'), billingAddress)
				WebUI.delay(1)
				WebUI.sendKeys(findTestObject('Object Repository/Nissan/Nissan_input__Address'), Keys.chord(Keys.ARROW_DOWN))
				WebUI.sendKeys(findTestObject('Object Repository/Nissan/Nissan_input__Address'), Keys.chord(Keys.ENTER))
			}

		//WebUI.delay(30)
		
		WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Review'))

		WebUI.click(findTestObject('Object Repository/Vroom/button_Terms_and_conditions'))
	 

		
		WebUI.click(findTestObject('Object Repository/Nissan/label_acceptAgreement'))
//		WebUI.delay(5)
//		if(vehicle_reg_province == 'GA') {
//		WebUI.click(findTestObject('Object Repository/Vroom/vroom_gorgia_consent'))
//		}
		WebUI.delay(10)
		WebUI.click(findTestObject('Object Repository/Schomp/span_Pay Now'))
		
		
		//WebUI.delay(10)
		//WebUI.waitForElementPresent(findTestObject('Object Repository/Vroom/p_order_id'), 60)
		customerOrderNo=WebUI.getText(findTestObject('Object Repository/Vroom/p_orderid')).substring(9)
		
		WebUI.takeElementScreenshot((RunConfiguration.getProjectDir() +'/Screenshots/Schomp/')+ (customerOrderNo+'_SchompD2C.png'), findTestObject('Object Repository/GM/Confirmation'))
		//Screenshots/Schomp
		WebUI.delay(3)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Vroom/p_orderid'), 60)
		if(WebUI.getUrl()!=baseURL+'/checkout/confirmation' && WebUI.getUrl()!=baseURL+'checkout/confirmation' )
		{
			WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/'+testCase+'checkout_err.png')
			status='fail'
			error_msg='Error in checkout page data'

		}
	}
	catch(Exception E)
	{
		/////

		////
		WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/'+testCase+'payment_err.png')
		status='fail'
		error_msg='payment data page error'}
}



//// Write code here that turns the phrase above into concrete actions
//if(status=='Pass')
//{
//	WebUI.verifyElementPresent(findTestObject('Object Repository/Vroom/p_orderid'), 5)
//
//	customerOrderNo=WebUI.getText(findTestObject('Object Repository/Vroom/p_orderid')).substring(9)
//
//	//writeResult()
//	println(customerOrderNo)
//	WebUI.delay(15)
//	
//}


writeResult()
//WebUI.closeBrowser()
WebUI.delay(5)
//writeResult()
WebUI.closeBrowser()



		
 // added for commenting out after checking 5 db tables

 
	//--->
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
			(valueToWrite[2]) = oid
			(valueToWrite[3]) = firstName
			(valueToWrite[4]) = lastName
			(valueToWrite[5]) = email
			(valueToWrite[6]) = vehicle_reg_province
			(valueToWrite[7]) = plan
			(valueToWrite[8]) = deductible
	    	(valueToWrite[9]) = commercialUse
			(valueToWrite[10]) = termLength
			(valueToWrite[11]) = mileage
			(valueToWrite[12]) = feePaymentPlan
			(valueToWrite[13]) = subtotal
			(valueToWrite[14]) = salesTax
			(valueToWrite[15]) = totalrate
			(valueToWrite[16]) = totalDueToday_checkout
			(valueToWrite[17]) = trimmed_monthlyPayment  //monthly/remaining payment
			(valueToWrite[18]) = CheckoutTotalDueTodayMessage
			(valueToWrite[19]) = remainingPaymentMessage
			(valueToWrite[20]) = totalrateMessage
			(valueToWrite[21]) = status
			(valueToWrite[22]) = customerOrderNo
//			(valueToWrite[23]) = verifyDB
//			(valueToWrite[24]) = cms_contract_Id
			(valueToWrite[25]) = currentDate
			(valueToWrite[26]) = error_msg
//			(valueToWrite[19]) = first_query_result
//
//			(valueToWrite[20]) = second_query_result
//
//			(valueToWrite[21]) = third_query_result
//
//			(valueToWrite[22]) = fourth_query_result
//
//			(valueToWrite[23]) = fifth_query_result
//			(valueToWrite[24]) = sixth_query_result
//
//			(valueToWrite[25]) = seventh_query_result
//
//			(valueToWrite[26]) = eightth_query_result
//			(valueToWrite[24]) = link1
//			(valueToWrite[25]) = link4
//			(valueToWrite[26]) = link5
		//	(valueToWrite[27]) = pdfResultPrint
		//	(valueToWrite[28]) = link2
		//	(valueToWrite[29]) = link3
//			(valueToWrite[28]) = cartPageCal
//
//			(valueToWrite[29]) = checkoutPageCal
			//(valueToWrite[32]) = link6
			//(valueToWrite[33]) = link7
			//(valueToWrite[34]) = link8
			//(valueToWrite[35]) = link9
 
 
		ExcelKeywords excelKeywords = new ExcelKeywords()
		 if (portal=="Schomp" || portal=="schomp") {
			excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'Schomp_Result', valueToWrite)

		}
	}
	