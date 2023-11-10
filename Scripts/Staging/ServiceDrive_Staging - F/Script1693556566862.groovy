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

if(status=='Pass') {
	
if(portal=="ServiceDrive" || portal=="servicedrive") {
	println('test')
	//WebUI.navigateToUrl(GlobalVariable.VroomURL+oid)
	 
		WebUI.navigateToUrl(GlobalVariable.ServiceDriveURL)
		println("get the dealerid")
}
		 else {
			WebUI.navigateToUrl('https://staging.oneprotectplans.com/service-drive')
			println(" -get the dealerid")
		}
		baseURL=GlobalVariable.baseServiceDrive_URL


//WebUI.navigateToUrl('https://staging.oneprotectplans.com/service-drive')
		if (DealershipID != '') {
WebUI.setText(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/input_Dealership ID_dealershipId'), 
    DealershipID)

WebUI.setText(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/input_Employee ID_employeeId'), 
	employeeId)
		}
WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/a_Manual VIN Input'))

WebUI.setText(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/input_VIN_vin'), 
    vinNo)
WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/input_Year_year'))

WebUI.setText(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/input_Odometer_odometer'), 
    mileage)
WebUI.delay(3)
//inspection_document
if( (inspection_document == "Yes" || inspection_document== "No")) {
WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/button_'+inspection_document))//need logic
//Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/button_No
}


WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect Vehicle Service Protection_c0e085/button_View Rates'))
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/div_'+plan))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Vroom/select_termMileage'),
	termLength, true)
WebUI.delay(2)
if(deductible=='0') {
	WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/button_0'))
}
else if(deductible=='100') {

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/button_100'))

if( (disappearing_deductible == "yes" || disappearing_deductible == "Yes"))
	{
WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/span_NoYes_lever'))
}

}
else if(deductible=='250') {
WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/button_250'))
}

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/span_View Payment Options'))

// commercial Use ctrl+X
}
		WebUI.delay(3)
		
	if(status=='Pass') {
       // freepayment plan 
		if(feePaymentPlan=="")
			{
				if(WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/div_36 months')))
				{ feePaymentPlan="36 months" }
				else if(WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/div_30 months')))
				{feePaymentPlan="30 months"}
				else if(WebUI.verifyElementClickable(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/div_24 months')))
				{feePaymentPlan="24 months"}
				else if(WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/div_21 months')))
					{feePaymentPlan="21 months"}
				else if(WebUI.verifyElementClickable(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/div_18 months')))
				{feePaymentPlan="18 months"}
				else if(WebUI.verifyElementClickable(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/div_12 months')))
					{feePaymentPlan="12 months"}
				else if(WebUI.verifyElementClickable(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/div_6 months')))
				{feePaymentPlan="6 months"}
				else if (WebUI.verifyElementClickable(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/div_Pay in Full'))) {
					feePaymentPlan = 'Pay In Full'
				}
			}
			// commercial use- new implement 
			if( (commercialUse == "yes" || commercialUse == "Yes"))
				{
		WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/span_NoYes_lever_1'))
			}
		
//WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/span_30 months'))
			WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/div_'+feePaymentPlan))

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/button_Checkout'))

WebUI.delay(2)
if(inspection_document== 'No' || inspection_document!= 'Yes') {
WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/a_Choose file'))


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


WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/button_Upload'))


WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/button_Begin Checkout'))
}

WebUI.click(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/button_Proceed'))

	}
	
/////////Schomp---//////
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
				
				subtotal=WebUI.getText(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/rates_subtotal'))
				salesTax=WebUI.getText(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/salesTax'))
				totalrate=WebUI.getText((findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/total_rates')))
				
			strrr = WebUI.getText((findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/checkOutCalculation')))
			totalDueToday_checkout = WebUI.getText((findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/checkout_TotalDueToday')))
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
				subtotal=WebUI.getText(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/rates_subtotal'))
				salesTax=WebUI.getText(findTestObject('Object Repository/SD_Schomp/Page_One Protect - Get Rates/salesTax'))
				
			}
			
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
	
			WebUI.click(findTestObject('Object Repository/Vroom/label_Billing address check box'))
	
			//WebUI.delay(30)
			
			WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Review'))
	
			WebUI.click(findTestObject('Object Repository/Vroom/button_Terms_and_conditions'))
		 
	
			WebUI.click(findTestObject('Object Repository/Nissan/label_acceptAgreement'))
			WebUI.delay(5)
			//if(vehicle_reg_province == 'GA') {
			//WebUI.click(findTestObject('Object Repository/Vroom/vroom_gorgia_consent'))
			//}
			WebUI.delay(20)
			WebUI.click(findTestObject('Object Repository/Schomp/span_Pay Now'))
			WebUI.delay(30)
			
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
			
			
			
			//WebUI.closeBrowser()
			WebUI.delay(30)
			WebUI.closeBrowser()
			
			if (status == 'Pass') {
				
			
				PGDatabaseConnection a = new PGDatabaseConnection()
			
				String str1 = ('select order_id__c,sfid, status,customer_order_number__c,payment_terms__c,order_total_before_tax__c, sales_tax__c, totalamount, monthly_payment__c, downpayment_amount__c, status,effectivedate, accountid from salesforce.order  where customer_order_number__c=\'' +
				customerOrderNo) + '\''
			
			   // println(str1)
			
				ResultSet rs = a.dataBaseConnection(str1, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser,
					GlobalVariable.pgPassword)
			
				String orderId = ''
			
				while (rs.next()) {
					orderId = rs.getString('order_id__c')
			
					//		println((orderId + ' total rate : ') + totalrate)
					//
					//		println(((rs.getString('status') + rs.getString('customer_order_number__c')) + rs.getString('payment_terms__c')) +
					//			feePaymentPlan)
					//
					//		println(((((rs.getString('order_total_before_tax__c') + subtotal) + rs.getString('sales_tax__c')) + salesTax) +
					//			rs.getString('totalamount')) + totalrate)
					//
					//		println((((((('total amount: ' + rs.getString('totalamount')) + ' ^^**^^ ') + Trate) + '   ') + rs.getString('sfid')) +
					//			' ') + rs.getString('accountid'))
					WebUI.delay(2)
			
					if (feePaymentPlan != 'Pay In Full') {
						if (((rs.getString('status') == 'Active') && //rs.getString('customer_order_number__c')==customerOrderNo &&
						 //rs.getString('payment_terms__c')==selectedPayment && // new added selectedPayment instead of feePaymentPlan
						(rs.getString('payment_terms__c') != null)) && // need to change it after fix
						(rs.getString('sfid') != null ))//&& rs.getString('totalamount')==Trate  // totalrate changed to subtotal to Trate
						// rs.getString('downpayment_amount__c') == DownPayment && // split downpayment
						//need to update later// rs.getString('effectivedate') == effectiveDate &&
						// rs.getString('accounid') != null &&
						//&& rs.getString('_hc_lastop') == 'SYNCED'
						//&& rs.getString('_hc_err') == null
						// rs.getString('monthly_payment__c') == selectedPayment && **not applicable for Vins
						///////
						//rs.getString('order_total_before_tax__c')==subtotal ** Not applicable for Vins
						//rs.getString('sales_tax__c')==salesTax			  ** Not applicable for Vins
						/* &&
							rs.getString('payment_terms__c')==feePaymentPlan && rs.getString('order_total_before_tax__c')==subtotal &&
							rs.getString('sales_tax__c')==salesTax && rs.getString('totalamount')==totalrate)*/
						 {
							verifyDB = 'Success'
			
						   // println('Success')
			
							//M
							first_query_result = 'Status is Active || Customer Order number is Not empty' //println('###---Status is Active || Customer Order number is matched---###')
							//println('###---DB verification failed. Please check : status|payment_terms__c|sfid|totalamount|downpayment_amount__c|effectivedate|accounyid|_hc_lastop|_hc_err---###')
							///////////////////////////
							//rs.getString('customer_order_number__c')==customerOrderNo &&
							//rs.getString('payment_terms__c')==selectedPayment && // new added selectedPayment instead of feePaymentPlan
							// need to change it after fix
							//&& rs.getString('totalamount')==Trate  // totalrate changed to subtotal to Trate
							// rs.getString('downpayment_amount__c') == down_payment && // split downpayment
							//need to update later// rs.getString('effectivedate') == effectiveDate &&
							// rs.getString('accounid') != null &&
							// rs.getString('_hc_lastop') == 'SYNCED'
							// && rs.getString('_hc_err') == null
							// rs.getString('monthly_payment__c') == selectedPayment && **not applicable for Vins
							///////
							//rs.getString('order_total_before_tax__c')==subtotal ** Not applicable for Vins
							//rs.getString('sales_tax__c')==salesTax			  ** Not applicable for Vins
							/* &&
								rs.getString('payment_terms__c')==feePaymentPlan && rs.getString('order_total_before_tax__c')==subtotal &&
								rs.getString('sales_tax__c')==salesTax && rs.getString('totalamount')==totalrate)*/
							//M
						} //////
						//		else {
						else {
							verifyDB = 'Unsuccessful,'
			
							status = 'fail'
			
							first_query_result = 'DB verification failed. Please check : status|payment_terms__c|sfid|totalamount|downpayment_amount__c|effectivedate|accounyid|_hc_lastop|_hc_err'
						}
						//			println("else else else")
						//		}
					} else if (feePaymentPlan == 'Pay In Full') {
						if (((rs.getString('status') == 'Active') && (rs.getString('payment_terms__c') == null)) && (rs.getString('sfid') !=
						null)) {
							verifyDB = 'Success'
			
						   // println('Success')
			
							first_query_result = 'Status is Active || Customer Order number is matched'
			
						   // println('###---Status is Active || Customer Order number is matched---###')
						} else {
							verifyDB = 'Unsuccessful,'
			
							status = 'fail'
			
							first_query_result = 'DB verification failed. Please check : status|payment_terms__c|sfid|totalamount|downpayment_amount__c|effectivedate|accounyid|_hc_lastop|_hc_err'
			
							//println('###---DB verification failed. Please check : status|payment_terms__c|sfid|totalamount|downpayment_amount__c|effectivedate|accounyid|_hc_lastop|_hc_err---###')
						}
					}
				}
				
				WebUI.delay(2)
			
				String orderSummaryId = ''
			
				if (verifyDB == 'Success') {
					String str2 = ('select order_summary_id__c, sfid,item_name__C, * from salesforce.orderitem where order__order_id__c=\'' +
					orderId) + '\''
			
				   // println(str2)
			
					rs = a.dataBaseConnection(str2, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)
			
					WebUI.delay(8)
			
					//println(res)
					while (rs.next()) {
						orderSummaryId = rs.getString('order_summary_id__c')
			
						//econ_contract_number=rs.getString(c)
						con_num = rs.getString('external_reference_number__c')
			
					  //  println(con_num)
			
						//int num=(int)econ_contract_number
					  //  println(orderSummaryId)
			
						//			println((((((rs.getString('item_name__c') + plan) + rs.getString('sales_date__c')) + rs.getString('expiration_date__c')) +
						//				rs.getString('sales_tax__c')) + salesTax) + rs.getString('summarydescription__c'))
						if (((((rs.getString('item_name__c') == plan) && (rs.getString('order_summary_id__c') != null)) && (rs.getString(
							'sales_date__c') != null)) && (rs.getString('expiration_date__c') != null)) && (rs.getString('summarydescription__c') !=
						null)) {
							//rs.getString('sales_tax__c')==salesTax &&s
							verifyDB = 'Success'
			
						  //  println('Success')
			
							//M
							second_query_result = 'Selected Plan is matched, Sales date, expiration date and order summary description is fetched to Database' //println('###---Selected Plan is matched, Sales date, expiration date and order summary description is fetched to Database---###') //second_query_result = 'DB verification failed. Please check : item_name__c|order_summary_id__c|sales_date__c|expiration_date__c|summarydescription__c '
							//println('DB verification failed. Please check : item_name__c|order_summary_id__c|sales_date__c|expiration_date__c|summarydescription__c ')
						} else {
							verifyDB = 'Unsuccessful,'
			
							status = 'fail'
							second_query_result = 'Selected Plan is matched, Sales date, expiration date and order summary description is not fetched to Database'
						}
					}
					
					if ((verifyDB == 'Success') || (verifyDB != 'Success')) {
						String str3 = ('select value__c,_hc_lastop, _hc_err, order_metadata_external_id__c,* from salesforce.order_metadata__c where order__r__order_id__c=\'' +
						orderId) + '\''
			
						rs = a.dataBaseConnection(str3, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)
			
						while (rs.next()) {
							println(rs.getString('_hc_lastop') + rs.getString('_hc_err'))
			
							if ((rs.getString('_hc_err') == null) && (rs.getString('_hc_lastop') == 'INSERTED' || 'SYNCED')) {
								verifyDB = 'Success'
			
							  //  println('Success')
			
								//M
								third_query_result = 'No _hc_err is occured and _hc_lastop is Synced' + rs.getString('_hc_lastop')
			
							   // println('###---No _hc_err is occured---###')
							} else {
								verifyDB = 'Unsuccessful,'
			
								status = 'fail'
			
								third_query_result = '_hc_err is occured and _hc_lastop is not Synced. Please check'
			
							//    println('hc_err is occured and _hc_lastop is not Synced. Please check')
			
								break
							}
						}
						
						if ((verifyDB == 'Success') || (verifyDB != 'Success')) {
							String str4 = ('select orderpayment_id, * from public.orderpaymentrelation where order_external_id=\'' +
							orderId) + '\''
			
							rs = a.dataBaseConnection(str4, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser,
								GlobalVariable.pgPassword)
			
						  //  println(rs)
			
							while (rs.next()) {
								if (((((((((rs.getString('orderpayment_id') != null) && (rs.getString('order_external_id') == orderId)) &&
								(rs.getString('cc_last_four') != null)) && (rs.getString('cc_exp_month') != null)) && (rs.getString(
									'cc_exp_year') != null)) && (rs.getString('created_by') == 'APP')) && (rs.getString('updated_by') ==
								'APP')) && (rs.getString('created_date') != null)) && (rs.getString('updated_date') != null)) {
									verifyDB = 'Success'
			
								 //   println('Success')
			
									//M
									fourth_query_result = 'Orderpayment_id || order_external_id || cc_last_four || cc_exp_month || cc_exp_year : successfully fetched to database || Created by and updated by == APP || Created date || updated date: successfully fetched to Database' //fourth_part2_query_result = 'Created by and updated by == APP'
									//fourth_part3_query_result = 'Created date || updated date: successfully fetched to Database'
									//println('###---Orderpayment_id || order_external_id || cc_last_four || cc_exp_month || cc_exp_year : successfully fetched to database---###')
									//println('###---Created by and updated by == APP---###')
									//println('###---Created date || updated date: successfully fetched to Database---###') //fourth_part2_query_result = 'Database validation error. Please check Created by and updated by == APP'
									//fourth_part3_query_result = 'Database validation error. Please check Created date || updated date: successfully fetched to Database'
								} else {
									verifyDB = 'Unsuccessful,'
			
									status = 'fail'
			
									fourth_query_result = 'Database validation error. Please check Orderpayment_id || order_external_id || cc_last_four || cc_exp_month || cc_exp_year : successfully fetched to database || Please check Created by and updated by == APP ||  Created date || updated date'
								}
							}
							
							WebUI.delay(3)
			
							if ((verifyDB == 'Success') || (verifyDB != 'Success')) {
								String str5 = ('select * from public.contract_pdf where order_summary_id=\'' + orderSummaryId) + '\''
			
								rs = a.dataBaseConnection(str5, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser,
									GlobalVariable.pgPassword)
			
								///
								while (rs.next()) {
									if ((rs.getString('order_summary_id') == orderSummaryId) && (rs.getString('data') != null)) {
										verifyDB = 'Heroku Success'
			
										///
										///
										//M
										fifth_query_result = 'Heroku DB validation success. Order_sammary_id is equals to DBs orderSummaryId and data is fetched to DB'
			
										//println('###---order_sammary_id is equals to DBs orderSummaryId and data is fetched to DB---###')
										//println('Heroku Success')
										///
										WebUI.openBrowser('')
			
										WebUI.maximizeWindow()
			
										WebUI.navigateToUrl('https:portal.safe-guardproducts.com/public/generatepdf.php')
			
										WebUI.delay(2)
			
										File file = new File('C:/Users/enayem/Downloads/output.txt')
			
										BufferedWriter writer = new BufferedWriter(new FileWriter(file))
			
										writer.write(rs.getString('data'))
			
										writer.close()
			
										//					}
										String filePath = 'C:/Users/enayem/Downloads/output.txt'
			
										// Open the notepad file
										def notepad = new ProcessBuilder('notepad.exe', filePath).start()
			
										// Wait for the notepad file to open
										Thread.sleep(3000)
			
										CustomKeywords.'pdf_verification.db_binary_pdfCheck_vroom.Robot_key_press'()
			
										CustomKeywords.'pdf_verification.db_binary_pdfCheck_vroom.download_pdf_from_binary'()
											
			
								Map<String, String> results = CustomKeywords.'pdf_verification.db_binary_pdfCheck_vroom.download_pdf_from_binary'()
									String deductible = '100'
			//						String termLength = "3 YEARS, 60,000 MILES"
			//						String subtotal = '$1,515.00"
			//						String firstName = "John"
			//						String lastName = "Doe"
									//PdfVerification.verifyPdf(results, deductible, termLength, subtotal, firstName, lastName)
							def pdfResult = ""
								pdfResult = CustomKeywords.'pdf_verification.db_binary_pdfCheck_vroom.verifyPdf'(results, deductible, termLength, subtotal, firstName, lastName)
									pdfResultPrint = pdfResult
									println(pdfResult)
											//////////////////////////////
										///
									} else {
										verifyDB = 'Unsuccessful,'
			
										status = 'fail'
			
										fifth_query_result = 'Database validation error. Please check order_sammary_id is equals to DBs orderSummaryId and data is fetched to DB'
									}
								}
							}
						}
					}
					
					a.closeConnection()
				}
				
			}else {
    
				verifyDB = 'NA'

                  }
					
			
			 WebUI.delay(4)
			
					writeResult()
					WebUI.closeBrowser()
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
					
						(valueToWrite[2]) = DealershipID
						
						(valueToWrite[3]) = vinNo
					
						(valueToWrite[4]) = firstName
					
						(valueToWrite[5]) = lastName
					
						//(valueToWrite[6]) = vehicle_reg_province
					
						(valueToWrite[7]) = plan
					
						(valueToWrite[8]) = termLength
					
						(valueToWrite[9]) = mileage
					
						(valueToWrite[10]) = feePaymentPlan
					
						(valueToWrite[11]) = subtotal
					
						(valueToWrite[12]) = salesTax
					
						(valueToWrite[13]) = totalrate
					
						(valueToWrite[14]) = status
					
						(valueToWrite[15]) = customerOrderNo
					
						(valueToWrite[16]) = verifyDB
					
				//		(valueToWrite[17]) = cms_contract_Id
					
						(valueToWrite[18]) = currentDate
					
			//			(valueToWrite[18]) = error_msg
					
						(valueToWrite[19]) = first_query_result
					
						(valueToWrite[20]) = second_query_result
					
						(valueToWrite[21]) = third_query_result
					
						(valueToWrite[22]) = fourth_query_result
					
						(valueToWrite[23]) = fifth_query_result
					
			//			(valueToWrite[24]) = sixth_query_result
			
			//			(valueToWrite[25]) = seventh_query_result
			//
			//			(valueToWrite[26]) = eightth_query_result
			//			(valueToWrite[24]) = link1
			//			(valueToWrite[25]) = link4
			//			(valueToWrite[26]) = link5
					
			//			(valueToWrite[27]) = pdfResultPrint
					
					//	(valueToWrite[28]) = link2
					
					//	(valueToWrite[29]) = link3
					
		//				(valueToWrite[28]) = cartPageCal
					
		//				(valueToWrite[29]) = checkoutPageCal
					
						//(valueToWrite[32]) = link6
					
						//(valueToWrite[33]) = link7
					
						//(valueToWrite[34]) = link8
					
						//(valueToWrite[35]) = link9
			
			
					ExcelKeywords excelKeywords = new ExcelKeywords()
					if(portal=="ServiceDrive" || portal=="servicedrive") {
						excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'ServiceDrive_Result', valueToWrite)
			
					}
					
				}