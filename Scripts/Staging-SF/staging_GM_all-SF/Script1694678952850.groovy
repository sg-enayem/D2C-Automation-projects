import com.kms.katalon.core.testobject.ConditionType as ConditionType
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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import utility.UtilKeywords as UtilKeywords
import excelPackage.ExcelKeywords as ExcelKeywords
import utility.jsscript as jsscript
//import DatabaseConnection as DbConnection
import java.sql.*
import java.awt.Robot as Robot
//for pdf validation
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import java.io.IOException as IOException
import java.net.URL as URL
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection
import java.awt.event.KeyEvent as KeyEvent
import java.io.BufferedReader as BufferedReader
import java.io.FileReader as FileReader
import java.time.LocalDate
import com.kms.katalon.core.configuration.RunConfiguration
//import com.carUtils.cartUtils_surcharge
//import carUtils.cartUtils_surcharge.CartUtils as cartUtils_surcharge
//import carUtils.cartUtils_surcharge as cartUtils_surcharge
//import utility.UtilKeywords as UtilKeywords
import cartUtils.cartUtils_surcharge






if (testCase != '') 
//{ 
//    ExcelKeywords excelKeywords = new ExcelKeywords()
//
//    excelKeywords.deleteExcel(System.getProperty('user.dir'), 'Result.xlsx', 'GM_result')
//}

WebUI.openBrowser('')

WebUI.maximizeWindow()

if ((portal == 'GMC') || (portal == 'gmc')) {
    if (oid != '') {
        if (GlobalVariable.gmcURL.toString().contains('staging')) {
            WebUI.navigateToUrl('https://staging.mygmcprotection.com/vehicle-service-protection?oid=' + oid)
        } else {
            WebUI.navigateToUrl(GlobalVariable.gmcURL + oid)
        }
        
        baseURL = GlobalVariable.basegmcURL
    } else {
        WebUI.navigateToUrl(GlobalVariable.gmcURL)

        baseURL = (('https://staging.my' + portal.toString().toLowerCase()) + 'protection.com/')
    }
} else if ((portal == 'Chevrolet') || (portal == 'chevrolet')) {
    if (oid != '') {
        if (GlobalVariable.chevroletURL.toString().contains('staging')) {
            WebUI.navigateToUrl('https://staging.mychevroletprotection.com/vehicle-service-protection?oid=' + oid)
        } else {
            WebUI.navigateToUrl(GlobalVariable.chevroletURL + oid)
        }
        
        baseURL = GlobalVariable.basechevroletURL
    } else {
        WebUI.navigateToUrl(GlobalVariable.chevroletURL)

        baseURL = (('https://staging.my' + portal.toString().toLowerCase()) + 'protection.com/')
    }
} else if ((portal == 'Buick') || (portal == 'buick')) {
    if (oid != '') {
        if (GlobalVariable.buickURL.toString().contains('staging')) {
            WebUI.navigateToUrl('https://staging.mybuickprotection.com/vehicle-service-protection?oid=' + oid)
        } else {
            WebUI.navigateToUrl(GlobalVariable.buickURL + oid)
        }
        
        baseURL = GlobalVariable.baseBuickURL
    } else {
        WebUI.navigateToUrl(GlobalVariable.buickURL)

        baseURL = (('https://staging.my' + portal.toString().toLowerCase()) + 'protection.com/')
    }
} else if ((portal == 'Cadillac') || (portal == 'Cadillac')) {
    if (oid != '') {
        if (GlobalVariable.cadillacURL.toString().contains('staging')) {
            WebUI.navigateToUrl('https://staging.mycadillacprotection.com/vehicle-service-protection?oid=' + oid)
        } else {
            WebUI.navigateToUrl(GlobalVariable.cadillacURL + oid)
        }
        
        baseURL = GlobalVariable.baseCadillacURL
    } else {
        WebUI.navigateToUrl(GlobalVariable.cadillacURL)

        baseURL = (('https://staging.my' + portal.toString().toLowerCase()) + 'protection.com/')
    }
}

if (vinNo != '') {
    WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_VIN_vin'), 
        vinNo)

    WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_Current mileage_editVehicleOdometerVIN'), 
        mileage)

    WebUI.selectOptionByValue(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/select_AlabamaAlaskaArizonaArkansasCaliforn_eff432'), 
        province, true)
} else {
    WebUI.setText(findTestObject('Object Repository/Production/GMC/input_mileage'), mileage)

    WebUI.selectOptionByValue(findTestObject('Object Repository/Production/GMC/input_province'), province, true)
}

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/button_Find My Price'))

WebUI.delay(7)

//Wrong-Vin input Assersion
if ((WebUI.getUrl() != (((baseURL + 'plans-pricing?plan=') + portal.toUpperCase()) + '1')) && (WebUI.getUrl() != (baseURL + 'plans-pricing?plan=CHEVY1'))){
	
			def actualVinErrorText = WebUI.getText(findTestObject('Object Repository/GM/Vin_Error_Text'))
	
			if(actualVinErrorText.contains(expectedVinErrorText)) {
				WebUI.closeBrowser()
				def comment = 'STOP_TEST_EXECUTION'
	
				if (comment == "STOP_TEST_EXECUTION") {
					KeywordUtil.markFailedAndStop("Test execution stopped forcefully due to wrong vin.")
				}
			}
	}

println(baseURL)
//if((WebUI.getUrl()!=baseURL+'/my-vsp-pricing?plan='+portal.toUpperCase()+'1') && (WebUI.getUrl()!=baseURL+'/plans-pricing?plan='+portal.toUpperCase()+'1') && (WebUI.getUrl()!=baseURL+'/my-vsp-pricing?plan=CHEVY1') && (WebUI.getUrl()!=baseURL+'/my-asp-pricing'))
if ((WebUI.getUrl() != (((baseURL + 'plans-pricing?plan=') + portal.toUpperCase()) + '1')) && (WebUI.getUrl() != (baseURL + 
'plans-pricing?plan=CHEVY1'))) {
    WebUI.takeFullPageScreenshot(((RunConfiguration.getProjectDir() + '/Screenshots/') + testCase) + 'login_err.png')

    status = 'fail'

    error_msg = 'Failed to move to plans pricing page'
}

//second page code
if (status == 'Pass') {
    try {
        if (plan == '') {
            plan = 'Platinum'
        }
        
        WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/div_' + plan))

        WebUI.selectOptionByLabel(findTestObject('Object Repository/Vroom/select_termMileage'), termLength, true)

        /*	catch(Exception e)
			 {
			 WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/label_err.png')
			 status='fail'
			 error_msg='Invalid termlength'
			 }*/
        if (deductible == '100') {
            WebUI.waitForElementClickable(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductile_100'), 30)

            UtilKeywords utilKeywordst = new UtilKeywords()

            utilKeywordst.clickUsingJS(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductile_100'), 30)
        }
        
        if (deductible == '250') {
            WebUI.waitForElementClickable(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductible_250'), 30)

            UtilKeywords utilKeywordst = new UtilKeywords()

            utilKeywordst.clickUsingJS(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductible_250'), 30 //CustomKeywords.'com.example.WebUIKeywords.clickUsingJS'(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductible_250'), 30)
                //WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductible_250'))
                )
        }
        
//surcharge is shifter to cart page
        

        WebUI.click(findTestObject('Object Repository/Vroom/span_View Payment Options'))
    }
    catch (Exception e) {
        WebUI.takeFullPageScreenshot(((RunConfiguration.getProjectDir() + '/Screenshots/') + testCase) + 'vsp_page_err.png')

        status = 'fail'

        error_msg = 'Failed to move to rates page'
    } 
    
    WebUI.delay(7)

    if (WebUI.getUrl() != (baseURL + 'cart')) {
        WebUI.takeFullPageScreenshot(((RunConfiguration.getProjectDir() + '/Screenshots/') + testCase) + 'Plans_page_err.png')

        status = 'fail'

        error_msg = 'Failed to move to rates page'
    }
    
   // println(status)
}



//verify pdf is downloadable or not : link_01
CustomKeywords.'pdf_verification.pdf_url_check.first_link_GMC'()


//CustomKeywords.'pdf_verification.pdf_url_check.second_link_GMC'()  //comment for code error

//verify pdf is downloadable or not : link_02
//CustomKeywords.'pdf_verification.pdf_url_check.third_link_GMC'()  //comment for code error


//verify pdf is downloadable or not : link_03

if (status == 'Pass') {
    try {
        //this.feePaymentPlan=feePaymentPlan
        if (feePaymentPlan == '') {
            if (WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_36 months'))) {
                feePaymentPlan = '36 months'
            } else if (WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_30 months'))) {
                feePaymentPlan = '30 months'
            } else if (WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_24 months'))) {
                feePaymentPlan = '24 months'
            } else if (WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_12 months'))) {
                feePaymentPlan = '12 months'
            } else if (WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_6 months'))) {
                feePaymentPlan = '6 months'
            } else if (WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_pay in full'))) {
                feePaymentPlan = 'Pay In Full'
            }
        }
		

		TestObject subtotalCartPage = findTestObject('Object Repository/Vroom/Vroom_cart_subtotal')
		String subtotalText = WebUI.getText(subtotalCartPage)
		float subtotal = subtotalText.replaceAll('\\$|\\.\\d+|,', '') as float
		//float subtotal = subtotalText.replaceAll('\\$|,|(?<=\\d)\\.(?=\\d{2})', '') as float
		
		if ((portal.equalsIgnoreCase('GMC') || portal.equalsIgnoreCase('Chevrolet'))) {
			println(portal)
			println(commercialUse + " " + liftKit )
			if (commercialUse.equalsIgnoreCase('yes')) {
				TestObject lever1 = findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever1')
				WebUI.click(lever1)
				WebUI.delay(3)
				subtotal += 250
			}
			
			if (liftKit.equalsIgnoreCase('yes')) {
				TestObject lever2 = findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever2')
				WebUI.click(lever2)
				WebUI.delay(3)
				subtotal += 350
			}
			
			String subtotalWithSurchargeText = WebUI.getText(subtotalCartPage)
			float subtotalWithSurcharge = subtotalWithSurchargeText.replaceAll('\\$|\\.\\d+|,', '') as float
			
			assert subtotal == subtotalWithSurcharge : "Surcharge is added to the cart."
			println('Surcharge added successfully.')
			
		} else if (portal.equalsIgnoreCase('Buick') || portal.equalsIgnoreCase('Cadillac')) {
			println(commercialUse)
			println(portal)
			if (commercialUse.equalsIgnoreCase('yes')) {
				TestObject lever2 = findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever2')
				WebUI.click(lever2)
				
				subtotal += 250
				
				String subtotalWithSurchargeText = WebUI.getText(subtotalCartPage)
				float subtotalWithSurcharge = subtotalWithSurchargeText.replaceAll('\\$|\\.\\d+|,', '') as float
				
				assert subtotal == subtotalWithSurcharge : "Surcharge not added to the cart."
				println('Surcharge added successfully.')
			}
		}
		WebUI.delay(5)
		//////
	//	subtotal = WebUI.getText(findTestObject('Object Repository/Vroom/Vroom_cart_subtotal'))
		println(subtotal)
		
		est_total = WebUI.getText(findTestObject('Object Repository/Vroom/Vroom_cart_totalRate'))

		salesTax = WebUI.getText(findTestObject('Object Repository/test_object/Page_GMC Protection Plan - Plans and Pricing/sales_tax_v2'))

		down_payment = WebUI.getText(findTestObject('Object Repository/Vroom/down_payment'))
		
		println(salesTax)
		println(est_total)

		

	   // println((subtotal + '     ') + salesTax)

		//String totalrate=WebUI.getText(findTestObject('Object Repository/Vroom/CartTotal_rates')) // new code
//		Trate = subtotal.replaceAll('\\$', "") // new code
		Trate = subtotal
		DownPayment = down_payment.replaceAll('\\$|\\.\\d+|,', '' // new code
			)

		Total_rate = est_total.replaceAll('\\$|\\.\\d+|,', '' // new code
			)
    
		
        
        ///
        //WebUI.click(findTestObject('Object Repository/'+portal+'/links/span_View Payment Options'))
        WebUI.click(findTestObject('Object Repository/Vroom/div_' + feePaymentPlan))


        link1 = 'Link working:Cart Page->VIEW AGREEMENT AND EXCLUSIONS '

        link2 = 'Link working:Cart page->Payment Plan Agreement'

        link3 = 'Link working:Cart page->Payment Plan Agreement(2nd)'

        //println(feePaymentPlan)

        //println(selectedPayment)

        

        //println(selectedPayment)

        WebUI.click(findTestObject('Object Repository/Vroom/button_CHECKOUT'))
    }
    catch (Exception E) {
        WebUI.takeFullPageScreenshot(((RunConfiguration.getProjectDir() + '/Screenshots/') + testCase) + 'rates_err.png')

        status = 'fail'

        error_msg = 'Failed to move to checkout page'
    } 
    
    WebUI.delay(2 //5 to 2
        )

    if (WebUI.getUrl() != (baseURL + 'checkout')) {
        WebUI.takeFullPageScreenshot(((RunConfiguration.getProjectDir() + '/Screenshots/') + testCase) + 'rates_err.png')

        status = 'fail'

        error_msg = 'Failed to move to checkout page'
    }
}

CustomKeywords.'pdf_verification.pdf_url_check.fourth_link_GMC'()

// Write code here that turns the phrase above into concrete actions
if (status == 'Pass') {
    try {

        link4 = 'Link working:Checkout Page_Contact Page->VIEW AGREEMENT AND EXCLUSIONS'

        WebUI.setText(findTestObject('Object Repository/Vroom/input_First Name'), firstName)

        WebUI.setText(findTestObject('Object Repository/Vroom/input_Last Name'), lastName)

        WebUI.setText(findTestObject('Object Repository/Vroom/input_EmailAddress'), email)

        WebUI.setText(findTestObject('Object Repository/Vroom/input_ConfirmEmail'), email)

        WebUI.setText(findTestObject('Object Repository/Vroom/input_Phone Number'), phoneNo)

        WebUI.setText(findTestObject('Object Repository/Vroom/input__Address'), address)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ARROW_DOWN))

        WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ENTER))

        WebUI.delay(3)

		
		// Get the WebElement of the 'Continue to Billing' button
		WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Billing'))

        WebUI.delay(3)
        WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Billing'))//change note-xpath

        //WebUI.click(findTestObject('Object Repository/Vroom/label_add1'))
        WebUI.click(findTestObject('Object Repository/Vroom/button_COMPLETE'))
    }
    catch (Exception E) {
        WebUI.takeFullPageScreenshot(((RunConfiguration.getProjectDir() + '/Screenshots/') + testCase) + 'personaldata_err.png')

        status = 'fail'

        error_msg = 'personal data page error'
    } 
}
WebUI.delay(3)

CustomKeywords.'pdf_verification.pdf_url_check.fifth_link_GMC'()
link5 = 'PDF working:Cart Page_Billingt Page->VIEW AGREEMENT AND EXCLUSIONS'
////verify pdf is downloadable or not : link_05

//Checkout page Calculation---->
if (feePaymentPlan != 'Pay In Full') {
	
	//Calculation-without Surcharge
	if(liftKit.equalsIgnoreCase('') && commercialUse.equalsIgnoreCase('')) {
		
		subtotal=WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates_without_Surcharge/rates_subtotal_GM_CheckoutCalculation'))
		
		salesTax=WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates_without_Surcharge/rates_salestax_GM_CheckoutCalculation'))
		totalrate=WebUI.getText((findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates_without_Surcharge/rates_totalrates_GM_CheckoutCalculation')))
		
	strrr = WebUI.getText((findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates_without_Surcharge/rates_remaining_payments_GM_CheckoutCalculation')))
	totalDueToday_checkout = WebUI.getText((findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates_without_Surcharge/rates_totalduetoday_GM_CheckoutCalculation')))
	
	
	}
	
	//Calculation- Single Surcharge
	if((liftKit.equalsIgnoreCase('yes') && commercialUse.equalsIgnoreCase('')) || (liftKit.equalsIgnoreCase('') && commercialUse.equalsIgnoreCase('yes')) ) {
		
		subtotal=WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-With-Single-Surcharge/rates_subtotal_Single'))
		salesTax=WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-With-Single-Surcharge/rates_salestax__Single'))
		totalrate=WebUI.getText((findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-With-Single-Surcharge/rates_totalrate_Single')))
		
	strrr = WebUI.getText((findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-With-Single-Surcharge/rates_remainingpayments_Single')))
	totalDueToday_checkout = WebUI.getText((findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-With-Single-Surcharge/rates_totalduetoday_Single')))

	}
	
	//Calculation- Double Surcharge
	if(liftKit.equalsIgnoreCase('yes') && commercialUse.equalsIgnoreCase('yes')) {
		
		subtotal=WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-With-Double-Surcharge/rates_subtotal_Double'))
		salesTax=WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-With-Double-Surcharge/rates_salestax_Double'))
		totalrate=WebUI.getText((findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-With-Double-Surcharge/rates_totalrate_Double')))
		
	strrr = WebUI.getText((findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-With-Double-Surcharge/rates_remainingpayments_Double')))
	totalDueToday_checkout = WebUI.getText((findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-With-Double-Surcharge/rates_totalduetoday_Double')))
		

		
	}
	
//	//trimmed_subtotal = subtotal.replaceAll(/[^0-9.]/, '') as float
//	trimmed_totalrate = totalrate.replaceAll(/[^0-9.]/, '') as float
//	trimmed_totalDueToday_checkout = totalDueToday_checkout.replaceAll(/[^0-9.]/, '') as float
//	println("Total rate= "+ trimmed_totalrate + " " + "Total due today= "+ trimmed_totalDueToday_checkout)
//	println("Sales Tax= "+ salesTax)
//	println("Sub Total= "+ subtotal)
//	duesAfterInitialPay = trimmed_totalrate - trimmed_totalDueToday_checkout as float
//	def match_month = strrr.find(/\d+/)?.toInteger()
//	//def month = match_month[0].toInteger()
//	
//	println("  ssss"+duesAfterInitialPay+ " " + match_month)
//	
//	def match_pay = strrr.find(/\$\d+\.\d{2}/)
//	println(match_pay)
//	def num = strrr.tokenize('$')[1].toDouble().toFloat()
//	println(num)
//	checkout_cal = Math.ceil(duesAfterInitialPay / match_month * 100) / 100
//	println(checkout_cal + " " + num)
//	
//	
	
	trimmed_subtotal = subtotal.replaceAll(/[^0-9.]/, '') as float
	trimmed_salestax = salesTax.replaceAll(/[^0-9.]/, '') as float
	trimmed_totalrate = totalrate.replaceAll(/[^0-9.]/, '') as float 
	trimmed_monthlyPayment = strrr.tokenize('$')[1].toDouble().toFloat()
	trimmed_totalDueToday_checkout = totalDueToday_checkout.replaceAll(/[^0-9.]/, '') as float
	println("Total rate= "+ trimmed_totalrate + " " + "Total due today= "+ trimmed_totalDueToday_checkout)
	println("Sales Tax= "+ salesTax)
	println("Sub Total= "+ subtotal)
	println("Monthly Payment= "+ trimmed_monthlyPayment)
	duesAfterInitialPay = trimmed_totalrate - trimmed_totalDueToday_checkout as float 
	println(duesAfterInitialPay)
	def match_month = strrr.find(/\d+/)?.toInteger()
	//def month = match_month[0].toInteger()
	println("  ssss"+duesAfterInitialPay+ " " + match_month)
	def match_pay = strrr.find(/\$\d+\.\d{2}/)
	println(match_pay)
	def num = strrr.tokenize('$')[1].toDouble().toFloat()
	println(num)
	checkout_cal = Math.ceil(duesAfterInitialPay / match_month * 100) / 100
	println(checkout_cal + " " + num)
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
		if(remainingPayment1 == trimmed_monthlyPayment ) {
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
	
	
	if(checkout_cal == num) {
		
		checkoutPageCal = 'Total dues after initial pay is : '+duesAfterInitialPay+" || For "+match_month+" Remaining payment calculation is matched in Checkout page"
		print(checkoutPageCal)
		}
		else{
			checkoutPageCal = 'Calculation is not matched for Checkout page'
		}
			
	}else {
		checkoutPageCal = 'Calculation is not applicable for PAY IN FULL option'
		//Calculation-without surcharge
		if(liftKit.equalsIgnoreCase('') && commercialUse.equalsIgnoreCase('')) {
		subtotal=WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-Pay In FUll/PayInFull_subtotal_GM_Checkoutcalculation_withoutsurcharge'))
		salesTax=WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-Pay In FUll/PayInFull_salestax_GM_Checkoutcalculation_withoutsurcharge'))
		totalrate =WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-Pay In FUll/PayInFull_totalrate_GM_Checkoutcalculation___withoutsurcharge'))
		}
		//Calculation- Single Surcharge
		if((liftKit.equalsIgnoreCase('yes') && commercialUse.equalsIgnoreCase('')) || (liftKit.equalsIgnoreCase('') && commercialUse.equalsIgnoreCase('yes')) ) {
			
			subtotal=WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-Pay In FUll/PayInFull_subtotal_GM_Checkoutcalculation__Single'))
			salesTax=WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-Pay In FUll/PayInFull_salestax_GM_Checkoutcalculation___Single'))
			totalrate =WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-Pay In FUll/PayInFull_totalrate_GM_Checkoutcalculation___Single'))
		}
		
		//Calculation- Double Surcharge
		if(liftKit.equalsIgnoreCase('yes') && commercialUse.equalsIgnoreCase('yes')) {
			
			subtotal=WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-Pay In FUll/PayInFull_subtotal_GM_Checkoutcalculation_Double'))
			salesTax=WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-Pay In FUll/PayInFull_salestax_GM_Checkoutcalculation__Double'))
			totalrate =WebUI.getText(findTestObject('Object Repository/GM/GM-Checkout-Calculation/Rates-Pay In FUll/PayInFull_totalrate_GM_Checkoutcalculation___Double'))
			
		}
	}
	
//-------->
	
if (status == 'Pass') {
    try {
       
		
        WebUI.setText(findTestObject('Object Repository/Vroom/input_Name On Card'), nameOnCard)

        WebUI.setText(findTestObject('Object Repository/Vroom/input_Card Number'), creditCardNumber)

        //		cardNumber)
        //def d = Date.parse('MMM', GlobalVariable.expMonth)
        //def num = d.format('MM')
        WebUI.selectOptionByLabel(findTestObject('Object Repository/Vroom/select_Month'), expMonth, true)

        //	num, true)
        WebUI.selectOptionByValue(findTestObject('Object Repository/Vroom/select_Year'), expYear, true)

        //	expYear, true)
        WebUI.setText(findTestObject('Object Repository/Vroom/input_CVC'), cvc)

        WebUI.click(findTestObject('Object Repository/Vroom/label_Billing address check box'))

        //WebUI.delay(30)
        WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Review'))

        /////
        if (feePaymentPlan != 'Pay In Full') {
            

            CustomKeywords.'pdf_verification.pdf_url_check.sixth_link_GMC'()

            link6 = 'PDF working:Checkout Page_Billingt Page->VIEW AGREEMENT AND EXCLUSIONS'

            ////verify pdf is downloadable or not : link_06
            CustomKeywords.'pdf_verification.pdf_url_check.check_download_before_consent'()

            link7 = 'PPA PDF is downloadable before consentt'

            WebUI.click(findTestObject('Object Repository/Vroom/button_Terms_and_conditions'))

            WebUI.click(findTestObject('Object Repository/Vroom/label_acceptAgreement'))

            WebUI.click(findTestObject('Object Repository/Vroom/button_accept'))

            WebUI.click(findTestObject('Object Repository/Vroom/label_accept'))

            ////check Agreement value change
            CustomKeywords.'pdf_verification.pdf_url_check.check_agreement_value_change'()

            link8 = 'PDF Status Changed after consent'

            CustomKeywords.'pdf_verification.pdf_url_check.check_download_afterConsent'()

            link9 = 'PPA PDF is downloadable after consent' ////verify pdf is downloadable or not : link_06
            //CustomKeywords.'pdf_verification.pdf_url_check.check_download_before_consent'()
            ////check Agreement value change
            //CustomKeywords.'pdf_verification.pdf_url_check.check_download_afterConsent'()
        }
		 else {
            link5 = 'PDF working:Cart Page_Billingt Page->VIEW AGREEMENT AND EXCLUSIONS'

            CustomKeywords.'pdf_verification.pdf_url_check.sixth_link_GMC'()

            link6 = 'PDF working:Checkout Page_Billingt Page->VIEW AGREEMENT AND EXCLUSIONS'

            link7 = 'Not applicable in Pay in Full'

            WebUI.click(findTestObject('Object Repository/Vroom/button_Terms_and_conditions'))
			WebUI.delay(5)
            WebUI.click(findTestObject('Object Repository/Vroom/label_acceptAgreement'))

            WebUI.click(findTestObject('Object Repository/Vroom/button_accept'))
			WebUI.delay(4)
            WebUI.click(findTestObject('Object Repository/Vroom/label_accept'))
			
			if(province == 'WA') {
				WebUI.click(findTestObject('Object Repository/Vroom/vroom_gorgia_consent'))
				}

            CustomKeywords.'pdf_verification.pdf_url_check.check_agreement_value_change'()

            link8 = 'PDF Status Changed after consent'

            link9 = 'Not applicable in Pay in Full'
        }
        


        WebUI.delay(10)

        WebUI.click(findTestObject('Object Repository/Vroom/span_Pay Now'))

		WebUI.delay(12)
	
		
		//WebUI.waitForElementPresent(findTestObject('Object Repository/Vroom/p_order_id'), 0, FailureHandling.STOP_ON_FAILURE)
		//WebUI.waitForElementPresent(findTestObject('Object Repository/Vroom/p_order_id'), 30)
		customerOrderNo=WebUI.getText(findTestObject('Object Repository/Vroom/p_orderid')).substring(16)
		//println((('Purchased Order number is : ' + customerOrderNo) + 'customer order :') + customerOrderNo)
		println((('Purchased Order number is : ' + customerOrderNo) + 'customer order :') + customerOrderNo)
		WebUI.takeElementScreenshot((RunConfiguration.getProjectDir() +'/Screenshots/GMBrands/')+(customerOrderNo+'_ContractSS.png'), findTestObject('Object Repository/GM/Confirmation'))

		println((('Purchased Order number is : ' + customerOrderNo) + 'customer order :') + customerOrderNo)
		WebUI.delay(3)
		
		if ((WebUI.getUrl() != (baseURL + '/checkout/confirmation')) && (WebUI.getUrl() != (baseURL + 'checkout/confirmation'))) {
			WebUI.takeFullPageScreenshot(((RunConfiguration.getProjectDir() + '/Screenshots/') + testCase) + 'checkout_err.png')

			status = 'fail'

			error_msg = 'Error in checkout page data'
		}
	}
	catch (Exception E) {
		WebUI.takeFullPageScreenshot(((RunConfiguration.getProjectDir() + '/Screenshots/') + testCase) + 'payment_err.png')

		status = 'fail'

		error_msg = 'payment data page error'
	}
}

WebUI.delay(2)

 

		if((WebUI.getUrl() != (baseURL + '/checkout/confirmation')) && (WebUI.getUrl() != (baseURL + 'checkout/confirmation'))) {
			try {

 

					def actualOrderIssueText = WebUI.getText(findTestObject('Object Repository/GM/Order_Issue_Text'))
					println(actualOrderIssueText)

					if(actualOrderIssueText.contains(expectedOrderIssueText)) {
						WebUI.delay(2)
						WebUI.closeBrowser()
					}
				} catch (Exception e) {

 

					println("Contract creation issue")
			}
		}


writeResult()

//WebUI.closeBrowser()
WebUI.delay(2)

WebUI.closeBrowser()

def writeResult() {
//    'Writing the result to the excel file'
//    UtilKeywords utilKeywords = new UtilKeywords()
//
//    String currentDate = utilKeywords.getCurrentDate()
//
//    String[] valueToWrite = new String[80]
//
//    (valueToWrite[0]) = testCase
//
//    (valueToWrite[1]) = portal
//
//    (valueToWrite[2]) = vinNo
//
//    (valueToWrite[3]) = firstName
//
//    (valueToWrite[4]) = lastName
//
//    (valueToWrite[5]) = province
//
//    (valueToWrite[6]) = plan
//
//    (valueToWrite[7]) = termLength
//
//    (valueToWrite[8]) = mileage
//
//    (valueToWrite[9]) = feePaymentPlan
//
//    //(valueToWrite[10]) = subtotal
//	(valueToWrite[10]) = subtotal
//	//(valueToWrite[10]) = subtotalCartPage
//	//valueToWrite[10] = String.valueOf(subtotal)
//
//    (valueToWrite[11]) = salesTax
//
//    (valueToWrite[12]) = Total_rate
//
//    (valueToWrite[13]) = status
//
//    (valueToWrite[14]) = customerOrderNo
//
//    //(valueToWrite[15]) = verifyDB
//
//    (valueToWrite[16]) = cms_contract_Id
//
//    (valueToWrite[17]) = currentDate
//
//    (valueToWrite[18]) = error_msg
//
//    //(valueToWrite[19]) = first_query_result
//
//    //(valueToWrite[20]) = second_query_result
//
//    //(valueToWrite[21]) = third_query_result
//
//    //(valueToWrite[22]) = fourth_query_result
//
//    //(valueToWrite[23]) = fifth_query_result
//
//   // (valueToWrite[24]) = sixth_query_result
//
//   // (valueToWrite[25]) = seventh_query_result
//
//    //(valueToWrite[26]) = eightth_query_result
//
//    (valueToWrite[27]) = link1
//
//    (valueToWrite[28]) = link2
//
//    (valueToWrite[29]) = link3
//
//    (valueToWrite[30]) = link4
//
//    (valueToWrite[31]) = link5
//
//    (valueToWrite[32]) = link6
//
//    (valueToWrite[33]) = link7
//
//    (valueToWrite[34]) = link8
//
//    (valueToWrite[35]) = link9 
//	
//	//(valueToWrite[36]) = pdfResultPrint
//	
//
//    ExcelKeywords excelKeywords = new ExcelKeywords()
//
//    excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'GM_Brands_Result', valueToWrite)
	
	///
	'Writing the result to the excel file'
	UtilKeywords utilKeywords = new UtilKeywords()
 
	String currentDate = utilKeywords.getCurrentDate()
 
	String[] valueToWrite = new String[80]
 
	(valueToWrite[0]) = testCase
 
	(valueToWrite[1]) = portal
 
	(valueToWrite[2]) = vinNo
 
	(valueToWrite[3]) = firstName
 
	(valueToWrite[4]) = lastName
	(valueToWrite[5]) = email
 
	(valueToWrite[6]) = province
 
	(valueToWrite[7]) = plan
	(valueToWrite[8]) = deductible
//	(valueToWrite[9]) = liftlit
 
	(valueToWrite[10]) = termLength
 
	(valueToWrite[11]) = mileage
 
	(valueToWrite[12]) = feePaymentPlan
 
	(valueToWrite[13]) = subtotal
	//(valueToWrite[10]) = subtotal.toString()
	//(valueToWrite[10]) = subtotalCartPage
	//valueToWrite[10] = String.valueOf(subtotal)
 
	(valueToWrite[14]) = salesTax
 
	(valueToWrite[15]) = totalrate
	(valueToWrite[16]) = totalDueToday_checkout
	(valueToWrite[17]) = trimmed_monthlyPayment  //monthly/remaining payment
	(valueToWrite[18]) = CheckoutTotalDueTodayMessage
	(valueToWrite[19]) = remainingPaymentMessage
	(valueToWrite[20]) = totalrateMessage
 
	(valueToWrite[21]) = status
 
	(valueToWrite[22]) = customerOrderNo
 
//	(valueToWrite[23]) = verifyDB
 
	(valueToWrite[24]) = cms_contract_Id
 
	(valueToWrite[25]) = currentDate
 
	(valueToWrite[26]) = error_msg
 
//    (valueToWrite[25]) = first_query_result
//
//    (valueToWrite[26]) = second_query_result
//
//    (valueToWrite[27]) = third_query_result
//
//    (valueToWrite[28]) = fourth_query_result
//
//    (valueToWrite[29]) = fifth_query_result
//
//    (valueToWrite[30]) = sixth_query_result
//
//    (valueToWrite[31]) = seventh_query_result
//
//    (valueToWrite[32]) = eightth_query_result
 
	(valueToWrite[35]) = link1
 
	(valueToWrite[36]) = link2
 
	(valueToWrite[37]) = link3
 
	(valueToWrite[38]) = link4
 
	(valueToWrite[39]) = link5
 
	(valueToWrite[40]) = link6
 
	(valueToWrite[41]) = link7
 
	(valueToWrite[42]) = link8
 
	(valueToWrite[43]) = link9
//	(valueToWrite[44]) = pdfResultPrint

 
	ExcelKeywords excelKeywords = new ExcelKeywords()
 
	excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'GM_result', valueToWrite)
}

