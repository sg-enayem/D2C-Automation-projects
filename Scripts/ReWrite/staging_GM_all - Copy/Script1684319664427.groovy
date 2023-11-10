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

if (testCase == '1') {
    ExcelKeywords excelKeywords = new ExcelKeywords()

    excelKeywords.deleteExcel(System.getProperty('user.dir'), 'Result.xlsx', 'GM_result')
}

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

//WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/button_Get Your Quote'))
//WebUI.switchToWindowIndex(0)
//WebUI.waitForElementVisible(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_VIN_vin'), 10)
//WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_VIN_vin'), vinNo)
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
//
//println(WebUI.getUrl())
//
//println(baseURL + 'plans-pricing?plan=CHEVY1')
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

//link_01=System.out.println(CustomKeywords.'pdf_verification.pdf_url_check.first_link_GMC'())
//if(CustomKeywords.'pdf_verification.pdf_url_check.first_link_GMC'()) {
//	link1 = "Cart page PDF link 1 is working"
//}
///
CustomKeywords.'pdf_verification.pdf_url_check.second_link_GMC'()

//if(CustomKeywords.'pdf_verification.pdf_url_check.second_link_GMC'()) {
//	link2 = "Cart page PDF link 2 is working"
//}
//verify pdf is downloadable or not : link_02
CustomKeywords.'pdf_verification.pdf_url_check.third_link_GMC'()

//if(CustomKeywords.'pdf_verification.pdf_url_check.third_link_GMC'()) {
//	link3 = "Cart page PDF link 3 is working"
//}
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
//		float subtotal = subtotalText.replaceAll('\\$|\\.\\d+|,', '') as float
		float subtotal = subtotalText.replaceAll('\\$|,|(?<=\\d)\\.(?=\\d{2})', '') as float
		
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
			println(liftKit)
			println(portal)
			if (liftKit.equalsIgnoreCase('yes')) {
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
		//subtotal = WebUI.getText(findTestObject('Object Repository/Vroom/Vroom_cart_subtotal'))
		println(subtotal)

		est_total = WebUI.getText(findTestObject('Object Repository/Vroom/Vroom_cart_totalRate'))

		salesTax = WebUI.getText(findTestObject('Object Repository/test_object/Page_GMC Protection Plan - Plans and Pricing/sales_tax_v2'))

		down_payment = WebUI.getText(findTestObject('Object Repository/Vroom/down_payment'))
		

	   // println((subtotal + '     ') + salesTax)

		//String totalrate=WebUI.getText(findTestObject('Object Repository/Vroom/CartTotal_rates')) // new code
//		Trate = subtotal.replaceAll('\\$', "") // new code
		Trate = subtotal
		DownPayment = down_payment.replaceAll('\\$|\\.\\d+|,', '' // new code
			)

		Total_rate = est_total.replaceAll('\\$|\\.\\d+|,', '' // new code
			)

		//////
    
		
//		if ((greyMarket == 'yes') || (greyMarket == 'Yes')) {
//			WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever3' //WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_NoYes_lever_1_2'))
//					))
//		}
        
        ///
        //WebUI.click(findTestObject('Object Repository/'+portal+'/links/span_View Payment Options'))
        WebUI.click(findTestObject('Object Repository/Vroom/div_' + feePaymentPlan))

        selectedPayment = WebUI.getText(findTestObject('Object Repository/Vroom/div_' + feePaymentPlan //////////new code
                ))

        link1 = 'Link working:Cart Page->VIEW AGREEMENT AND EXCLUSIONS '

        link2 = 'Link working:Cart page->Payment Plan Agreement'

        link3 = 'Link working:Cart page->Payment Plan Agreement(2nd)'

        //println(feePaymentPlan)

        //println(selectedPayment)

        int index = selectedPayment.indexOf('m')

        selectedPayment = (((selectedPayment[(0..index - 1)]) + 'M') + (selectedPayment[(index + 1..-1)]))

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
 
 
	   //  println(Trate)

       // println(DownPayment)

       //  println(Total_rate)

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

        //verify pdf is downloadable or not : link_04
        /////////////////////////////////////
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
    catch (Exception E) {
        WebUI.takeFullPageScreenshot(((RunConfiguration.getProjectDir() + '/Screenshots/') + testCase) + 'personaldata_err.png')

        status = 'fail'

        error_msg = 'personal data page error'
    } 
}

CustomKeywords.'pdf_verification.pdf_url_check.fifth_link_GMC'()
link5 = 'PDF working:Cart Page_Billingt Page->VIEW AGREEMENT AND EXCLUSIONS'
////verify pdf is downloadable or not : link_05
if (status == 'Pass') {
    try {
		///

		///
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

            WebUI.click(findTestObject('Object Repository/Vroom/label_acceptAgreement'))

            WebUI.click(findTestObject('Object Repository/Vroom/button_accept'))

            WebUI.click(findTestObject('Object Repository/Vroom/label_accept'))

            CustomKeywords.'pdf_verification.pdf_url_check.check_agreement_value_change'()

            link8 = 'PDF Status Changed after consent'

            link9 = 'Not applicable in Pay in Full'
        }
        
        /////////////////
        ////check Draft Agreement value pdf link for download
        //
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
        WebUI.delay(10)

        WebUI.click(findTestObject('Object Repository/Vroom/span_Pay Now'))

//        WebUI.delay(7)

        WebUI.waitForElementPresent(findTestObject('Object Repository/Vroom/p_orderid'), 60 //changing 60 to 30
            )

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

// Write code here that turns the phrase above into concrete actions
if (status == 'Pass') {
    WebUI.verifyElementPresent(findTestObject('Object Repository/Vroom/p_orderid'), 5)

    customerOrderNo = WebUI.getText(findTestObject('Object Repository/Vroom/p_orderid')).substring(16)

   // writeResult()

    println((('Purchased Order number is : ' + customerOrderNo) + 'customer order :') + customerOrderNo)

    WebUI.delay(30)

    //putty
    String cmd1 = 'plink -ssh test01@qtsuatgmcms1 -pw testuser1234 "cd /data/scripts && sh process_econtracts"'

    //String cmd2='testuser1234'
    //String cmd3='cd /data/scripts'
    //String cmd4='sh process_econtracts'
    Runtime.getRuntime().exec(cmd1 //WebUI.closeBrowser()
        )
}

WebUI.delay(2)

writeResult()

//WebUI.closeBrowser()
//delay(30)
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
            (rs.getString('sfid') != null //&& rs.getString('totalamount')==Trate  // totalrate changed to subtotal to Trate
            // rs.getString('downpayment_amount__c') == DownPayment && // split downpayment
            //need to update later// rs.getString('effectivedate') == effectiveDate &&
            // rs.getString('accounid') != null &&
          //  && rs.getString('_hc_lastop') == 'SYNCED'
          //  && rs.getString('_hc_err') == null
            // rs.getString('monthly_payment__c') == selectedPayment && **not applicable for Vins
            ///////
            //rs.getString('order_total_before_tax__c')==subtotal ** Not applicable for Vins
            //rs.getString('sales_tax__c')==salesTax			  ** Not applicable for Vins
				
            /* &&
				rs.getString('payment_terms__c')==feePaymentPlan && rs.getString('order_total_before_tax__c')==subtotal &&
				rs.getString('sales_tax__c')==salesTax && rs.getString('totalamount')==totalrate)*/ )) {
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

        WebUI.delay(2)

        //println(res)
        while (rs.next()) {
            orderSummaryId = rs.getString('order_summary_id__c')

            //econ_contract_number=rs.getString(c)
            con_num = rs.getInt('external_reference_number__c')

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

                if ((rs.getString('_hc_err') == null) && (rs.getString('_hc_lastop') == 'INSERTED')) {
                    verifyDB = 'Success'

                  //  println('Success')

                    //M
                    third_query_result = 'No _hc_err is occured and _hc_lastop is Synced'

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

                            File file = new File('C:/Users/murahman/Downloads/output.txt')

                            BufferedWriter writer = new BufferedWriter(new FileWriter(file))

                            writer.write(rs.getString('data'))

                            writer.close()

                            //					}
                            String filePath = 'C:/Users/murahman/Downloads/output.txt'

                            // Open the notepad file
                            def notepad = new ProcessBuilder('notepad.exe', filePath).start()

                            // Wait for the notepad file to open
                            Thread.sleep(3000)

                            CustomKeywords.'pdf_verification.db_binary_pdfCheck.Robot_key_press'()

                            CustomKeywords.'pdf_verification.db_binary_pdfCheck.download_pdf_from_binary'()
								

					Map<String, String> results = CustomKeywords.'pdf_verification.db_binary_pdfCheck.download_pdf_from_binary'()
//						int deductible = 100
//						String termLength = "3 YEARS, 60,000 MILES"
//						String subtotal = '$1,515.00"
//						String firstName = "John"
//						String lastName = "Doe"
						//PdfVerification.verifyPdf(results, deductible, termLength, subtotal, firstName, lastName)
				pdfResult = CustomKeywords.'pdf_verification.db_binary_pdfCheck.verifyPdf'(results, deductible, termLength, subtotal, firstName, lastName)
				pdfResultPrint = pdfResult
						
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
    
    /////
    WebUI.delay(3)

    if (verifyDB == 'Heroku Success') {
        //  String cmd1='plink -ssh test01@qtsuatgmcms1 -pw testuser1234 "cd /data/scripts && sh process_econtracts"'
        //String cmd2='testuser1234'
        //String cmd3='cd /data/scripts'
        //String cmd4='sh process_econtracts'
        //Runtime.getRuntime().exec(cmd1)
        PGDatabaseConnection te = new PGDatabaseConnection()

        String str6 = ('select * from web_con_m1 where id = \'' + con_num) + '\''

       // println(str6)
// account password, as DBs password
        ResultSet rs1 = te.dataBaseConnection(str6, 'qtsuatpost6:54262', 'forte', 'murahman', 'mun@Abir##5656')

        //String orderId=''
        //println(res)s
        while (rs1.next()) {
            //orderId=rs1.getString('order_id__c')
            //println(orderId)
            if ((((((rs1.getString('id') != null) && (rs1.getString('web_con_vin') != null)) && (rs1.getString('web_con_product') != 
            null)) && (rs1.getString('web_con_rectype') != null)) && (rs1.getString('web_con_trandate') != null)) && (rs1.getString(
                'web_con_lname') != null)) {
                verifyDB = 'web_con_m1 Success'

                println('web_con_m1 Success')

                //M
                //println('###---id || web_con_vin || web_con_product || web_con_rectype || web_con_trandate || web_con_lname:: is fetched from Database---###')
                sixth_query_result = 'id || web_con_vin || web_con_product || web_con_rectype || web_con_trandate || web_con_lname:: is fetched from Database' //println(sixth_query_result)
            } else {
                verifyDB = 'heroku success and web_con_m1 Unsuccessful,'

                status = 'fail'

                sixth_query_result = 'PG Admin Validation error. Please check in  id || web_con_vin || web_con_product || web_con_rectype || web_con_trandate || web_con_lname'
            }
        }
        
        WebUI.delay(2)

        if (verifyDB == 'web_con_m1 Success') {
            String str7 = ('select * from dms_con_m1 where dms_con_webid=\'' + con_num) + '\''

            ResultSet rs2 = te.dataBaseConnection(str7, 'qtsuatpost6:54262', 'forte', 'murahman', 'mun@Abir##5656')

            //String orderId=''
          //  println(str7)

            while (rs2.next()) {
                //orderId=rs1.getString('order_id__c')
                //println(orderId)
                dms_con = rs2.getString('dms_con_contract')

                cms_contract_Id = rs2.getString('dms_con_contract')

                //println((dms_con + '   ') + rs2.getString('dms_con_contract'))
                if (((((rs2.getString('dms_con_vin') != null) && (rs2.getString('dms_con_product') != null)) && (rs2.getString(
                    'dms_con_rectype') != null)) && (rs2.getString('dms_con_trandate') != null)) && (rs2.getString('dms_con_lname') != 
                null)) {
                    verifyDB = 'dms_con_m1 Success'

                    //println('DMS verification Success')
                    //M
                    //println('###---dms_con_product || dms_con_rectype || dms_con_trandate || dms_con_lname : fetched from Database---###')
                    seventh_query_result = 'dms_con_product || dms_con_rectype || dms_con_trandate || dms_con_lname : fetched from Database' //println(seventh_query_result)
                } else {
                    verifyDB = 'heroku success and dms Unsuccessful,'

                    status = 'fail'

                    seventh_query_result = 'PG Admin validation failed. Please check in dms_con_product || dms_con_rectype || dms_con_trandate || dms_con_lname'
                }
            }
        }
        
        WebUI.delay(2)

        if (verifyDB == 'dms_con_m1 Success') {
            String str8 = ('select * from sg_con_m1 where sg_con_contract = \'' + dms_con) + '\''

            ResultSet rs3 = te.dataBaseConnection(str8, 'qtsuatpost6:54262', 'forte', 'murahman', 'mun@Abir##5656')

            //String orderId=''
          //  println(str8)

            while (rs3.next()) {
                //orderId=rs1.getString('order_id__c')
                //println(orderId)
                //cms_contract_Id=rs3.getString('sg_con_contract')
                //println(cms_contract_Id)
                if (((((rs3.getString('sg_con_vin') != null) && (rs3.getString('sg_con_carrier') != null)) && (rs3.getString(
                    'sg_con_cover') != null)) && (rs3.getString('sg_con_status') != null)) && (rs3.getString('sg_con_lname') != 
                null)) {
                    verifyDB = 'sg_con_m1 Success'

                //    println('Success')

                    //M
                    //println('###---sg_con_carrier || sg_con_cover || sg_con_status || sg_con_lname : fetched from Databse---###')
                    eightth_query_result = 'sg_con_carrier || sg_con_cover || sg_con_status || sg_con_lname : fetched from Databse' //println('###---sg_con_carrier || sg_con_cover || sg_con_status || sg_con_lname :not  fetched from Databse---###')
                } else {
                    verifyDB = 'heroku success and sg_con_m1 Unsuccessful,'

                    status = 'fail'

                    eightth_query_result = 'sg_con_carrier || sg_con_cover || sg_con_status || sg_con_lname : Not fetched from Databse'
                }
            }
            
            WebUI.delay(2)
        }
        
        te.closeConnection()
    }
} else {
    verifyDB = 'NA'

    cms_contract_Id = 'NA'
}

WebUI.delay(2)

writeResult()

WebUI.closeBrowser( //String status = 'PASS'
    //println(contractStatus)
    ) //String responseDescription = 'SUCCESS'
//println(responseDescription)

def writeResult() {
    'Writing the result to the excel file'
    UtilKeywords utilKeywords = new UtilKeywords()

    String currentDate = utilKeywords.getCurrentDate()

    String[] valueToWrite = new String[80]

    (valueToWrite[0]) = testCase

    (valueToWrite[1]) = portal

    (valueToWrite[2]) = vinNo

    (valueToWrite[3]) = firstName

    (valueToWrite[4]) = lastName

    (valueToWrite[5]) = province

    (valueToWrite[6]) = plan

    (valueToWrite[7]) = termLength

    (valueToWrite[8]) = mileage

    (valueToWrite[9]) = feePaymentPlan

    (valueToWrite[10]) = subtotal

    (valueToWrite[11]) = salesTax

    (valueToWrite[12]) = Total_rate

    (valueToWrite[13]) = status

    (valueToWrite[14]) = customerOrderNo

    (valueToWrite[15]) = verifyDB

    (valueToWrite[16]) = cms_contract_Id

    (valueToWrite[17]) = currentDate

    (valueToWrite[18]) = error_msg

    (valueToWrite[19]) = first_query_result

    (valueToWrite[20]) = second_query_result

    (valueToWrite[21]) = third_query_result

    (valueToWrite[22]) = fourth_query_result

    (valueToWrite[23]) = fifth_query_result

    (valueToWrite[24]) = sixth_query_result

    (valueToWrite[25]) = seventh_query_result

    (valueToWrite[26]) = eightth_query_result

    (valueToWrite[27]) = link1

    (valueToWrite[28]) = link2

    (valueToWrite[29]) = link3

    (valueToWrite[30]) = link4

    (valueToWrite[31]) = link5

    (valueToWrite[32]) = link6

    (valueToWrite[33]) = link7

    (valueToWrite[34]) = link8

    (valueToWrite[35]) = link9 
	
	(valueToWrite[36]) = pdfResultPrint
	

    ExcelKeywords excelKeywords = new ExcelKeywords()

    excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'GM_Result', valueToWrite)
}