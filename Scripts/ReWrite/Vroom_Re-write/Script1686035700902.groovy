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

if(testCase=="1") {
			ExcelKeywords excelKeywords = new ExcelKeywords()

			excelKeywords.deleteExcel(System.getProperty('user.dir'), 'Result.xlsx', 'Vroom_Result');
		}

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

if(portal=="Vroom" || portal=="vroom") {
	println('test')
	//WebUI.navigateToUrl(GlobalVariable.VroomURL+oid)
	if (oid != '') {
		WebUI.navigateToUrl(GlobalVariable.VroomURL+oid)
		println("get the oid")
		} else {
			WebUI.navigateToUrl('https://mango-rewrite-qa.herokuapp.com/vehicle-service-protection')
			println(" not get the oid")
		}	
		baseURL='https://mango-rewrite-qa.herokuapp.com/vehicle-service-protection'
}
		
		if (vinNo != '') {
			WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_VIN_vin'),
				vinNo)
		
			WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_Current mileage_editVehicleOdometerVIN'),
				mileage)
		
			WebUI.selectOptionByValue(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/select_AlabamaAlaskaArizonaArkansasCaliforn_eff432'),
				vehicle_reg_province, true)
			println("get the vin")
			baseURL='https://mango-rewrite-qa.herokuapp.com/vehicle-service-protection'
		} else {
			WebUI.setText(findTestObject('Object Repository/Production/GMC/input_mileage'), mileage)
		
			WebUI.selectOptionByValue(findTestObject('Object Repository/Production/GMC/input_province'), vehicle_reg_province, true)
			println("not get the vin")
			baseURL=GlobalVariable.VroomURL
		}
	
	//
	//
//if (portal =='Nissan' || portal=="nissan") {
//	WebUI.navigateToUrl(GlobalVariable.NisssanASP_URL_ASP+oid)
//	baseURL=GlobalVariable.baseNissanURL
//	
//}
//if (portal=="Schomp" || portal=="schomp") {
//	WebUI.navigateToUrl(GlobalVariable.SchompURL+oid)
//	baseURL=GlobalVariable.baseSchompURL
//	
//}

WebUI.delay(5)

/*
if(vinNo != '')
{
	WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_VIN_vin'), vinNo)
	
	
			WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_Current mileage_editVehicleOdometerVIN'),
					mileage)
	
	
			WebUI.selectOptionByValue(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/select_AlabamaAlaskaArizonaArkansasCaliforn_eff432'),
					vehicle_reg_province, true)
}
else {
			WebUI.setText(findTestObject('Object Repository/Production/GMC/input_mileage'), mileage)
		
			WebUI.selectOptionByValue(findTestObject('Object Repository/Production/GMC/input_province'), vehicle_reg_province, true)
		}



if(vehicle_reg_province != '')
{
WebUI.selectOptionByValue(findTestObject('Object Repository/Production/GMC/input_province'),
		 vehicle_reg_province , true)

}

WebUI.setText(findTestObject('Object Repository/Production/GMC/input_mileage'),	mileage)

*/

// Write code here that turns the phrase above into concrete actions
WebUI.waitForElementClickable(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/button_Find My Price_Vroom'), 10)
WebUI.click(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/button_Find My Price_Vroom'))

//WebUI.click(findTestObject('Object Repository/'+portal+'/b_Get Your Price'))
//WebUI.click(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/button_Find My Price_Vroom'))

WebUI.delay(5)
println(WebUI.getUrl())
//println(baseURL+'/my-asp-pricing')
//if((WebUI.getUrl()!=baseURL+'/my-vsp-pricing?plan='+portal.toUpperCase()+'1') && (WebUI.getUrl()!=baseURL+'/plans-pricing?plan='+portal.toUpperCase()+'1') && (WebUI.getUrl()!=baseURL+'/my-vsp-pricing?plan=CHEVY1') && (WebUI.getUrl()!=baseURL+'/my-asp-pricing'))
if(WebUI.getUrl()!='https://mango-rewrite-qa.herokuapp.com/my-vsp-pricing' && WebUI.getUrl()!='https://mango-rewrite-qa.herokuapp.com/my-vsp-pricing' )

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
		//WebUI.delay(5)

		WebUI.selectOptionByLabel(findTestObject('Object Repository/Vroom/select_termMileage'),
				termLength, true)


		/*	catch(Exception e)
		 {
		 WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/label_err.png')
		 status='fail'
		 error_msg='Invalid termlength'
		 }*/
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

		if( (commercialUse == "yes" || commercialUse == "Yes"))
		{
			//WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_NoYes_lever'))
			WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever1'))
		}
		
/*
		if( (liftKit == "yes" || liftKit == "Yes"))
		{
			//WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_NoYes_lever_1'))
			WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever2'))
		}
		if( (greyMarket == "yes" || greyMarket == "Yes"))
		{
			WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever3'))
			//WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_NoYes_lever_1_2'))
		}*/

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

		//WebUI.setText(findTestObject('Object Repository/GM/GM_city'), city)
		//WebUI.selectOptionByValue(findTestObject('Object Repository/GM/GM_state'), state,true)
		//WebUI.setText(findTestObject('Object Repository/GM/GM_city'), state)
		//WebUI.setText(findTestObject('Object Repository/GM/GM_zip'), zip)




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

		if (feePaymentPlan != 'Pay In Full') {
			
			subtotal=WebUI.getText(findTestObject('Object Repository/Vroom/rates_subtotal'))
			salesTax=WebUI.getText(findTestObject('Object Repository/Vroom/sales_tax'))
			totalrate=WebUI.getText((findTestObject('Object Repository/Vroom/Total_rate')))
			
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
		
		WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Review'))

		WebUI.click(findTestObject('Object Repository/Vroom/button_Terms_and_conditions'))
	 

		//WebUI.click(findTestObject('Object Repository/Vroom/label_acceptAgreement'))
		
		//WebUI.click(findTestObject('Object Repository/Vroom/button_accept'))
		
		//WebUI.click(findTestObject('Object Repository/Vroom/label_accept'))

		//WebUI.delay(5)

		//if(WebUI.verifyElementPresent(findTestObject('Object Repository/'+portal+'/input_termsState'), 5))
		//if(salesTax=="\$0.00")
		/*try {
		 if(WebUI.verifyElementPresent(findTestObject('Object Repository/Vroom/input_termsState'), 5, FailureHandling.OPTIONAL))
		 {
		 WebUI.click(findTestObject('Object Repository/Vroom/input_termsState'))
		 }}
		 catch(Exception e)
		 {
		 println('termsState element not present')
		 }
		 */
		WebUI.click(findTestObject('Object Repository/Nissan/label_acceptAgreement'))
		WebUI.delay(5)
		if(vehicle_reg_province == 'GA') {
		WebUI.click(findTestObject('Object Repository/Vroom/vroom_gorgia_consent'))
		}
		WebUI.delay(20)
		//WebUI.click(findTestObject('Object Repository/Vroom/span_Pay Now'))


		

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



// Write code here that turns the phrase above into concrete actions
if(status=='Pass')
{
	WebUI.verifyElementPresent(findTestObject('Object Repository/Vroom/p_orderid'), 5)

	customerOrderNo=WebUI.getText(findTestObject('Object Repository/Vroom/p_orderid')).substring(9)

	//writeResult()
	println(customerOrderNo)
	WebUI.delay(15)
	// putty command 
	//String cmd1='plink -ssh test01@qtsuatgmcms1 -pw testuser1234 "cd /data/scripts && sh process_econtracts"'
   //String cmd2='testuser1234'
   //String cmd3='cd /data/scripts'
   //String cmd4='sh process_econtracts'
   //Runtime.getRuntime().exec(cmd1)
	//WebUI.closeBrowser()
}


writeResult()

//WebUI.closeBrowser()
//WebUI.delay(30)
WebUI.closeBrowser()
//
//if (status == 'Pass') {
//	
//
//	PGDatabaseConnection a = new PGDatabaseConnection()
//
//	String str1 = ('select order_id__c,sfid, status,customer_order_number__c,payment_terms__c,order_total_before_tax__c, sales_tax__c, totalamount, monthly_payment__c, downpayment_amount__c, status,effectivedate, accountid from salesforce.order  where customer_order_number__c=\'' + 
//    customerOrderNo) + '\''
//
//   // println(str1)
//
//	ResultSet rs = a.dataBaseConnection(str1, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser,
//		GlobalVariable.pgPassword)
//
//	String orderId = ''
//
//	while (rs.next()) {
//		orderId = rs.getString('order_id__c')
//
//		//		println((orderId + ' total rate : ') + totalrate)
//		//
//		//		println(((rs.getString('status') + rs.getString('customer_order_number__c')) + rs.getString('payment_terms__c')) +
//		//			feePaymentPlan)
//		//
//		//		println(((((rs.getString('order_total_before_tax__c') + subtotal) + rs.getString('sales_tax__c')) + salesTax) +
//		//			rs.getString('totalamount')) + totalrate)
//		//
//		//		println((((((('total amount: ' + rs.getString('totalamount')) + ' ^^**^^ ') + Trate) + '   ') + rs.getString('sfid')) +
//		//			' ') + rs.getString('accountid'))
//		WebUI.delay(2)
//
//		if (feePaymentPlan != 'Pay In Full') {
//			if (((rs.getString('status') == 'Active') && //rs.getString('customer_order_number__c')==customerOrderNo &&
//			 //rs.getString('payment_terms__c')==selectedPayment && // new added selectedPayment instead of feePaymentPlan
//			(rs.getString('payment_terms__c') != null)) && // need to change it after fix
//			(rs.getString('sfid') != null ))//&& rs.getString('totalamount')==Trate  // totalrate changed to subtotal to Trate
//			// rs.getString('downpayment_amount__c') == DownPayment && // split downpayment
//			//need to update later// rs.getString('effectivedate') == effectiveDate &&
//			// rs.getString('accounid') != null &&
//			//&& rs.getString('_hc_lastop') == 'SYNCED'
//			//&& rs.getString('_hc_err') == null
//			// rs.getString('monthly_payment__c') == selectedPayment && **not applicable for Vins
//			///////
//			//rs.getString('order_total_before_tax__c')==subtotal ** Not applicable for Vins
//			//rs.getString('sales_tax__c')==salesTax			  ** Not applicable for Vins
//			/* &&
//				rs.getString('payment_terms__c')==feePaymentPlan && rs.getString('order_total_before_tax__c')==subtotal &&
//				rs.getString('sales_tax__c')==salesTax && rs.getString('totalamount')==totalrate)*/ 
//			 {
//				verifyDB = 'Success'
//
//			   // println('Success')
//
//				//M
//				first_query_result = 'Status is Active || Customer Order number is Not empty' //println('###---Status is Active || Customer Order number is matched---###')
//				//println('###---DB verification failed. Please check : status|payment_terms__c|sfid|totalamount|downpayment_amount__c|effectivedate|accounyid|_hc_lastop|_hc_err---###')
//				///////////////////////////
//				//rs.getString('customer_order_number__c')==customerOrderNo &&
//				//rs.getString('payment_terms__c')==selectedPayment && // new added selectedPayment instead of feePaymentPlan
//				// need to change it after fix
//				//&& rs.getString('totalamount')==Trate  // totalrate changed to subtotal to Trate
//				// rs.getString('downpayment_amount__c') == down_payment && // split downpayment
//				//need to update later// rs.getString('effectivedate') == effectiveDate &&
//				// rs.getString('accounid') != null &&
//				// rs.getString('_hc_lastop') == 'SYNCED'
//				// && rs.getString('_hc_err') == null
//				// rs.getString('monthly_payment__c') == selectedPayment && **not applicable for Vins
//				///////
//				//rs.getString('order_total_before_tax__c')==subtotal ** Not applicable for Vins
//				//rs.getString('sales_tax__c')==salesTax			  ** Not applicable for Vins
//				/* &&
//					rs.getString('payment_terms__c')==feePaymentPlan && rs.getString('order_total_before_tax__c')==subtotal &&
//					rs.getString('sales_tax__c')==salesTax && rs.getString('totalamount')==totalrate)*/
//				//M
//			} //////
//			//		else {
//			else {
//				verifyDB = 'Unsuccessful,'
//
//				status = 'fail'
//
//				first_query_result = 'DB verification failed. Please check : status|payment_terms__c|sfid|totalamount|downpayment_amount__c|effectivedate|accounyid|_hc_lastop|_hc_err'
//			}
//			//			println("else else else")
//			//		}
//		} else if (feePaymentPlan == 'Pay In Full') {
//			if (((rs.getString('status') == 'Active') && (rs.getString('payment_terms__c') == null)) && (rs.getString('sfid') !=
//			null)) {
//				verifyDB = 'Success'
//
//			   // println('Success')
//
//				first_query_result = 'Status is Active || Customer Order number is matched'
//
//			   // println('###---Status is Active || Customer Order number is matched---###')
//			} else {
//				verifyDB = 'Unsuccessful,'
//
//				status = 'fail'
//
//				first_query_result = 'DB verification failed. Please check : status|payment_terms__c|sfid|totalamount|downpayment_amount__c|effectivedate|accounyid|_hc_lastop|_hc_err'
//
//				//println('###---DB verification failed. Please check : status|payment_terms__c|sfid|totalamount|downpayment_amount__c|effectivedate|accounyid|_hc_lastop|_hc_err---###')
//			}
//		}
//	}
//	
//	WebUI.delay(2)
//
//	String orderSummaryId = ''
//
//	if (verifyDB == 'Success') {
//		String str2 = ('select order_summary_id__c, sfid,item_name__C, * from salesforce.orderitem where order__order_id__c=\'' +
//		orderId) + '\''
//
//	   // println(str2)
//
//		rs = a.dataBaseConnection(str2, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)
//
//		WebUI.delay(8)
//
//		//println(res)
//		while (rs.next()) {
//			orderSummaryId = rs.getString('order_summary_id__c')
//
//			//econ_contract_number=rs.getString(c)
//			con_num = rs.getString('external_reference_number__c')
//
//		  //  println(con_num)
//
//			//int num=(int)econ_contract_number
//		  //  println(orderSummaryId)
//
//			//			println((((((rs.getString('item_name__c') + plan) + rs.getString('sales_date__c')) + rs.getString('expiration_date__c')) +
//			//				rs.getString('sales_tax__c')) + salesTax) + rs.getString('summarydescription__c'))
//			if (((((rs.getString('item_name__c') == plan) && (rs.getString('order_summary_id__c') != null)) && (rs.getString(
//				'sales_date__c') != null)) && (rs.getString('expiration_date__c') != null)) && (rs.getString('summarydescription__c') !=
//			null)) {
//				//rs.getString('sales_tax__c')==salesTax &&s
//				verifyDB = 'Success'
//
//			  //  println('Success')
//
//				//M
//				second_query_result = 'Selected Plan is matched, Sales date, expiration date and order summary description is fetched to Database' //println('###---Selected Plan is matched, Sales date, expiration date and order summary description is fetched to Database---###') //second_query_result = 'DB verification failed. Please check : item_name__c|order_summary_id__c|sales_date__c|expiration_date__c|summarydescription__c '
//				//println('DB verification failed. Please check : item_name__c|order_summary_id__c|sales_date__c|expiration_date__c|summarydescription__c ')
//			} else {
//				verifyDB = 'Unsuccessful,'
//
//				status = 'fail'
//				second_query_result = 'Selected Plan is matched, Sales date, expiration date and order summary description is not fetched to Database'
//			}
//		}
//		
//		if ((verifyDB == 'Success') || (verifyDB != 'Success')) {
//			String str3 = ('select value__c,_hc_lastop, _hc_err, order_metadata_external_id__c,* from salesforce.order_metadata__c where order__r__order_id__c=\'' +
//			orderId) + '\''
//
//			rs = a.dataBaseConnection(str3, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)
//
//			while (rs.next()) {
//				println(rs.getString('_hc_lastop') + rs.getString('_hc_err'))
//
//				if ((rs.getString('_hc_err') == null) && (rs.getString('_hc_lastop') == 'INSERTED' || 'SYNCED')) {
//					verifyDB = 'Success'
//
//				  //  println('Success')
//
//					//M
//					third_query_result = 'No _hc_err is occured and _hc_lastop is Synced' + rs.getString('_hc_lastop')
//
//				   // println('###---No _hc_err is occured---###')
//				} else {
//					verifyDB = 'Unsuccessful,'
//
//					status = 'fail'
//
//					third_query_result = '_hc_err is occured and _hc_lastop is not Synced. Please check'
//
//				//    println('hc_err is occured and _hc_lastop is not Synced. Please check')
//
//					break
//				}
//			}
//			
//			if ((verifyDB == 'Success') || (verifyDB != 'Success')) {
//				String str4 = ('select orderpayment_id, * from public.orderpaymentrelation where order_external_id=\'' +
//				orderId) + '\''
//
//				rs = a.dataBaseConnection(str4, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser,
//					GlobalVariable.pgPassword)
//
//			  //  println(rs)
//
//				while (rs.next()) {
//					if (((((((((rs.getString('orderpayment_id') != null) && (rs.getString('order_external_id') == orderId)) &&
//					(rs.getString('cc_last_four') != null)) && (rs.getString('cc_exp_month') != null)) && (rs.getString(
//						'cc_exp_year') != null)) && (rs.getString('created_by') == 'APP')) && (rs.getString('updated_by') ==
//					'APP')) && (rs.getString('created_date') != null)) && (rs.getString('updated_date') != null)) {
//						verifyDB = 'Success'
//
//					 //   println('Success')
//
//						//M
//						fourth_query_result = 'Orderpayment_id || order_external_id || cc_last_four || cc_exp_month || cc_exp_year : successfully fetched to database || Created by and updated by == APP || Created date || updated date: successfully fetched to Database' //fourth_part2_query_result = 'Created by and updated by == APP'
//						//fourth_part3_query_result = 'Created date || updated date: successfully fetched to Database'
//						//println('###---Orderpayment_id || order_external_id || cc_last_four || cc_exp_month || cc_exp_year : successfully fetched to database---###')
//						//println('###---Created by and updated by == APP---###')
//						//println('###---Created date || updated date: successfully fetched to Database---###') //fourth_part2_query_result = 'Database validation error. Please check Created by and updated by == APP'
//						//fourth_part3_query_result = 'Database validation error. Please check Created date || updated date: successfully fetched to Database'
//					} else {
//						verifyDB = 'Unsuccessful,'
//
//						status = 'fail'
//
//						fourth_query_result = 'Database validation error. Please check Orderpayment_id || order_external_id || cc_last_four || cc_exp_month || cc_exp_year : successfully fetched to database || Please check Created by and updated by == APP ||  Created date || updated date'
//					}
//				}
//				
//				WebUI.delay(3)
//
//				if ((verifyDB == 'Success') || (verifyDB != 'Success')) {
//					String str5 = ('select * from public.contract_pdf where order_summary_id=\'' + orderSummaryId) + '\''
//
//					rs = a.dataBaseConnection(str5, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser,
//						GlobalVariable.pgPassword)
//
//					///
//					while (rs.next()) {
//						if ((rs.getString('order_summary_id') == orderSummaryId) && (rs.getString('data') != null)) {
//							verifyDB = 'Heroku Success'
//
//							///
//							///
//							//M
//							fifth_query_result = 'Heroku DB validation success. Order_sammary_id is equals to DBs orderSummaryId and data is fetched to DB'
//
//							//println('###---order_sammary_id is equals to DBs orderSummaryId and data is fetched to DB---###')
//							//println('Heroku Success')
//							///
//							WebUI.openBrowser('')
//
//							WebUI.maximizeWindow()
//
//							WebUI.navigateToUrl('https:portal.safe-guardproducts.com/public/generatepdf.php')
//
//							WebUI.delay(2)
//
//							File file = new File('C:/Users/murahman/Downloads/output.txt')
//
//							BufferedWriter writer = new BufferedWriter(new FileWriter(file))
//
//							writer.write(rs.getString('data'))
//
//							writer.close()
//
//							//					}
//							String filePath = 'C:/Users/murahman/Downloads/output.txt'
//
//							// Open the notepad file
//							def notepad = new ProcessBuilder('notepad.exe', filePath).start()
//
//							// Wait for the notepad file to open
//							Thread.sleep(3000)
//
//							CustomKeywords.'pdf_verification.db_binary_pdfCheck_vroom.Robot_key_press'()
//
//							CustomKeywords.'pdf_verification.db_binary_pdfCheck_vroom.download_pdf_from_binary'()
//								
//
//					Map<String, String> results = CustomKeywords.'pdf_verification.db_binary_pdfCheck_vroom.download_pdf_from_binary'()
//						String deductible = '100'
////						String termLength = "3 YEARS, 60,000 MILES"
////						String subtotal = '$1,515.00"
////						String firstName = "John"
////						String lastName = "Doe"
//						//PdfVerification.verifyPdf(results, deductible, termLength, subtotal, firstName, lastName)
//				def pdfResult = ""
//					pdfResult = CustomKeywords.'pdf_verification.db_binary_pdfCheck_vroom.verifyPdf'(results, deductible, termLength, subtotal, firstName, lastName)
//						pdfResultPrint = pdfResult
//						println(pdfResult)
//								//////////////////////////////
//							///
//						} else {
//							verifyDB = 'Unsuccessful,'
//
//							status = 'fail'
//
//							fifth_query_result = 'Database validation error. Please check order_sammary_id is equals to DBs orderSummaryId and data is fetched to DB'
//						}
//					}
//				}
//			}
//		}
//		
//		a.closeConnection()
//	}
//}
//	
//	/////
//	WebUI.delay(3)
//			
//			/*
//           if(verifyDB=='Success' && portal !='Nissan')
//           {
//			//  String cmd1='plink -ssh test01@qtsuatgmcms1 -pw testuser1234 "cd /data/scripts && sh process_econtracts"' 
////String cmd2='testuser1234'
////String cmd3='cd /data/scripts' 
////String cmd4='sh process_econtracts'
////Runtime.getRuntime().exec(cmd1)
//			PGDatabaseConnection te=new PGDatabaseConnection();
//			
//			String str6="select * from web_con_m1 where id = '"+ con_num +"'";
//			println(str6)
//			ResultSet rs1=te.dataBaseConnection(str6, 'qtsuatpost6:54262','forte', 'murahman', 'mun@Abir##22')
//			//String orderId=''
//			//println(res)s
//			while ( rs1.next() ) {
//				//orderId=rs1.getString('order_id__c')
//				//println(orderId)
//				if(rs1.getString('id')!=null && rs1.getString('web_con_vin')!=null &&
//				rs1.getString('web_con_product')!=null && rs1.getString('web_con_rectype')!=null &&
//				rs1.getString('web_con_trandate')!=null && rs1.getString('web_con_lname')!=null)
//				{
//					verifyDB='web_con_m1 Success'
//					println('web_con_m1 Success')
//				}
//				else {
//					verifyDB='heroku success and web_con_m1 Unsuccessful,'
//					status='fail'
//				}
//			
//			}
//			if(verifyDB=='Success' && portal !='Nissan')
//			{
//			String str7="select * from dms_con_m1 where dms_con_webid='"+ con_num +"'";
//			ResultSet rs2=te.dataBaseConnection(str7, 'qtsuatpost6:54262','forte', 'murahman', 'mun@Abir##22')
//			
//			//String orderId=''
//			println(str7)
//			while ( rs2.next() ) {
//				//orderId=rs1.getString('order_id__c')
//				//println(orderId)
//				dms_con=rs2.getString('dms_con_contract')
//				cms_contract_Id=rs2.getString('dms_con_contract')
//				println(dms_con + '   '+rs2.getString('dms_con_contract'))
//				if( rs2.getString('dms_con_vin')!=null &&
//				rs2.getString('dms_con_product')!=null && rs2.getString('dms_con_rectype')!=null &&
//				rs2.getString('dms_con_trandate')!=null && rs2.getString('dms_con_lname')!=null)
//				{
//					verifyDB='dms_con_m1 Success'
//					println('DMS verification Success')
//				}
//				else {
//					verifyDB='heroku success and dms Unsuccessful,'
//					status='fail'
//				}
//			}
//			}
//			if(verifyDB=='Success' && portal !='Nissan')
//				{
//				String str8="select * from sg_con_m1 where sg_con_contract = '"+ dms_con +"'";
//				ResultSet rs3=te.dataBaseConnection(str8, 'qtsuatpost6:54262','forte', 'murahman', 'mun@Abir##22')
//				//String orderId=''
//				println(str8)
//				while ( rs3.next() ) {
//					//orderId=rs1.getString('order_id__c')
//					//println(orderId)
//					cms_contract_Id=rs3.getString('sg_con_contract')
//					//println(cms_contract_Id)
//					if( rs3.getString('sg_con_vin')!=null &&
//					rs3.getString('sg_con_carrier')!=null && rs3.getString('sg_con_cover')!=null &&
//					rs3.getString('sg_con_status')!=null && rs3.getString('sg_con_lname')!=null)
//					{
//						verifyDB='sg_con_m1 Success'
//						println('Success')
//					}
//					else {
//						verifyDB='heroku success and sg_con_m1 Unsuccessful,'
//						status='fail'
//					}
//				}
//				}
//			te.closeConnection()
//			}
//
//
//
//		}
//	else {
//		verifyDB='NA'
//		cms_contract_Id='NA'
//	}
//	**/
//
//		writeResult()
//		WebUI.closeBrowser()
 // added for commenting out after checking 5 db tables

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
		
			//(valueToWrite[15]) = verifyDB
		
			//(valueToWrite[16]) = cms_contract_Id
		
			(valueToWrite[17]) = currentDate
		
			(valueToWrite[18]) = error_msg
		
			//(valueToWrite[19]) = first_query_result
		
			//(valueToWrite[20]) = second_query_result
		
			//(valueToWrite[21]) = third_query_result
		
			//(valueToWrite[22]) = fourth_query_result
		
			//(valueToWrite[23]) = fifth_query_result
		
//			(valueToWrite[24]) = sixth_query_result
//		
//			(valueToWrite[25]) = seventh_query_result
//		
//			(valueToWrite[26]) = eightth_query_result
			(valueToWrite[24]) = link1
			(valueToWrite[25]) = link4
			(valueToWrite[26]) = link5
		
		//	(valueToWrite[27]) = pdfResultPrint
		
		//	(valueToWrite[28]) = link2
		
		//	(valueToWrite[29]) = link3
		
			(valueToWrite[28]) = cartPageCal
		
			(valueToWrite[29]) = checkoutPageCal
		
			//(valueToWrite[32]) = link6
		
			//(valueToWrite[33]) = link7
		
			//(valueToWrite[34]) = link8
		
			//(valueToWrite[35]) = link9


		ExcelKeywords excelKeywords = new ExcelKeywords()
		if(portal=="Vroom" || portal=="vroom") {
			excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'Vroom_Result', valueToWrite)

		}
		else if (portal=="Nissan" || portal=="nissan") {
			excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'Nissan_Result', valueToWrite)

		}
		else if (portal=="Schomp" || portal=="schomp") {
			excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'Schomp_Result', valueToWrite)

		}



	}
	
	
	