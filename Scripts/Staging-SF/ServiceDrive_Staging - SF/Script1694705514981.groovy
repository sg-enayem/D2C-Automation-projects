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

if(testCase!="") 
//{
//	ExcelKeywords excelKeywords = new ExcelKeywords()
//
//	excelKeywords.deleteExcel(System.getProperty('user.dir'), 'Result.xlsx', 'Vroom_Result');
//}

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
/*
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
*/
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
	
			/*
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
			
			//----//
			*/
			
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
						def roundedTotalRate = new BigDecimal(totalrates1.toString()).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue() // Round the result to two decimal places using BigDecimal
						println(roundedTotalRate)
						if(roundedTotalRate == trimmed_totalrate ) {
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
					CheckoutTotalDueTodayMessage = ""
				}
				if((commercialUse.equalsIgnoreCase('yes')) ) {
					subtotal=WebUI.getText(findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Single-Surcharge/Single-Subtotal'))
					salesTax=WebUI.getText(findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Single-Surcharge/Single-SalesTax'))
					totalDueToday_checkout=WebUI.getText((findTestObject('Object Repository/Schomp/Checkout-Calculation-Rates/Single-Surcharge/Single-TotalRates')))
					totalrate = "total due today is total amount in pay in full"
					trimmed_monthlyPayment = "no remaining payment for Pay In Full"
					remainingPaymentMessage = "no remaining payment message for Pay In Full"
					totalrateMessage = "no total amount message for Pay In Full"
					CheckoutTotalDueTodayMessage = ""
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
			
			
			WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Review'))
	
			WebUI.click(findTestObject('Object Repository/Vroom/button_Terms_and_conditions'))
		 
	
			WebUI.click(findTestObject('Object Repository/Nissan/label_acceptAgreement'))
			WebUI.delay(5)
			//if(vehicle_reg_province == 'GA') {
			//WebUI.click(findTestObject('Object Repository/Vroom/vroom_gorgia_consent'))
			//}
			WebUI.delay(7)
			WebUI.click(findTestObject('Object Repository/Schomp/span_Pay Now'))
			//WebUI.delay(30)
			
			WebUI.delay(8)
			//WebUI.waitForElementPresent(findTestObject('Object Repository/Vroom/p_order_id'), 60)
			customerOrderNo=WebUI.getText(findTestObject('Object Repository/Vroom/p_orderid')).substring(9)
			
			WebUI.takeElementScreenshot((RunConfiguration.getProjectDir() +'/Screenshots/Schomp/')+ (customerOrderNo+'_ServiceDrive.png'), findTestObject('Object Repository/GM/Confirmation'))
	
			WebUI.delay(3)
			
					//WebUI.waitForElementPresent(findTestObject('Object Repository/Vroom/p_orderid'), 60)
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
//			if(status=='Pass')
//			{
//				WebUI.verifyElementPresent(findTestObject('Object Repository/Vroom/p_orderid'), 5)
//			
//				customerOrderNo=WebUI.getText(findTestObject('Object Repository/Vroom/p_orderid')).substring(9)
//			
//				writeResult()
//				println(customerOrderNo)
//				WebUI.delay(15)
//				
//			}
			
			
			writeResult()
			//WebUI.closeBrowser()
			WebUI.delay(5)
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
						
						(valueToWrite[6]) = email
					
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
			
//			(valueToWrite[22]) = verifyDB
//			(valueToWrite[23]) = cms_contract_Id
			            (valueToWrite[23]) = currentDate
						
			            (valueToWrite[24]) = error_msg 
						
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
					
					excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'ServiceDrive_Result', valueToWrite)
			
					
					
				}