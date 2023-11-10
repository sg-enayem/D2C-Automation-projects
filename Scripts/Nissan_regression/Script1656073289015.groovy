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
if(portal=="Vroom" || portal=="vroom") {
	println('test')
	WebUI.navigateToUrl(GlobalVariable.VroomURL+oid)
	baseURL=GlobalVariable.baseVroomURL
}
if (portal =='Nissan' || portal=="nissan") {
	WebUI.navigateToUrl(GlobalVariable.NisssanASP_URL_ASP+oid)
	baseURL=GlobalVariable.baseNissanURL
	
}
if (portal=="Schomp" || portal=="schomp") {
	WebUI.navigateToUrl(GlobalVariable.SchompURL+oid)
	baseURL=GlobalVariable.baseSchompURL
	
}

WebUI.delay(5)

/*
if(vinNo != '')
{
	WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_VIN_vin'), vinNo)
	
	
			WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_Current mileage_editVehicleOdometerVIN'),
					mileage)
	
	
			WebUI.selectOptionByValue(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/select_AlabamaAlaskaArizonaArkansasCaliforn_eff432'),
					province, true)
}
else
{*/


if(vehicle_reg_province != '')
{
WebUI.selectOptionByValue(findTestObject('Object Repository/Production/GMC/input_province'),
		 vehicle_reg_province , true)

}

WebUI.setText(findTestObject('Object Repository/Production/GMC/input_mileage'),	mileage)



// Write code here that turns the phrase above into concrete actions

//WebUI.click(findTestObject('Object Repository/'+portal+'/b_Get Your Price'))
WebUI.click(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/button_Find My Price'))

WebUI.delay(5)
println(WebUI.getUrl())
println(baseURL+'/my-asp-pricing')
//if((WebUI.getUrl()!=baseURL+'/my-vsp-pricing?plan='+portal.toUpperCase()+'1') && (WebUI.getUrl()!=baseURL+'/plans-pricing?plan='+portal.toUpperCase()+'1') && (WebUI.getUrl()!=baseURL+'/my-vsp-pricing?plan=CHEVY1') && (WebUI.getUrl()!=baseURL+'/my-asp-pricing'))
if(WebUI.getUrl()!=baseURL+'/my-vsp-pricing' && WebUI.getUrl()!=baseURL+'/my-asp-pricing' )

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
		
		WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/div_'+plan))

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
/*
		if( (commercialUse == "yes" || commercialUse == "Yes"))
		{
			//WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_NoYes_lever'))
			WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever1'))
		}
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
			{feePaymentPlan="12 months"}
			else if(WebUI.verifyElementClickable(findTestObject('Object Repository/Vroom/div_6 months')))
			{feePaymentPlan="6 months"}
		}
		//WebUI.click(findTestObject('Object Repository/'+portal+'/links/span_View Payment Options'))


		WebUI.click(findTestObject('Object Repository/Vroom/div_'+feePaymentPlan))

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


// Write code here that turns the phrase above into concrete actions
if(status=='Pass')
{

	try {
		subtotal=WebUI.getText(findTestObject('Object Repository/Vroom/rates_subtotal'))
		salesTax=WebUI.getText(findTestObject('Object Repository/Vroom/sales_tax'))
		totalrate=WebUI.getText((findTestObject('Object Repository/Vroom/CartTotal_rates')))
		WebUI.setText(findTestObject('Object Repository/Vroom/input_First Name'), firstName)

		WebUI.setText(findTestObject('Object Repository/Vroom/input_Last Name'), lastName)

		WebUI.setText(findTestObject('Object Repository/Vroom/input_EmailAddress'), email)

		WebUI.setText(findTestObject('Object Repository/Vroom/input_ConfirmEmail'),
				email)

		WebUI.setText(findTestObject('Object Repository/Vroom/input_Phone Number'), homePhoneNo)

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
if(status=='Pass') {
	try {
		WebUI.setText(findTestObject('Object Repository/Schomp/input_Name On Card'), GlobalVariable.nameOnCard)

		WebUI.setText(findTestObject('Object Repository/Schomp/input_Card Number'),GlobalVariable.creditCardNumber)
		//		cardNumber)

		//def d = Date.parse('MMM', GlobalVariable.expMonth)
		//def num = d.format('MM')

		WebUI.selectOptionByLabel(findTestObject('Object Repository/Schomp/select_Month'),GlobalVariable.expMonth,true)
			//	num, true)

		WebUI.selectOptionByValue(findTestObject('Object Repository/Schomp/select_Year'),GlobalVariable.expYear,true)
			//	expYear, true)

		WebUI.setText(findTestObject('Object Repository/Schomp/input_CVC'), GlobalVariable.cvc)

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
		
		WebUI.click(findTestObject('Object Repository/Vroom/span_Pay Now'))


		WebUI.delay(15)

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
	WebUI.delay(45)
	String cmd1='plink -ssh test01@qtsuatgmcms1 -pw testuser1234 "cd /data/scripts && sh process_econtracts"'
   //String cmd2='testuser1234'
   //String cmd3='cd /data/scripts'
   //String cmd4='sh process_econtracts'
   Runtime.getRuntime().exec(cmd1)
	//WebUI.closeBrowser()
}

//writeResult()
//WebUI.closeBrowser()



	if(status=='Pass')
		{
			PGDatabaseConnection a=new PGDatabaseConnection();
			String str1="select order_id__c,sfid, status,customer_order_number__c,payment_terms__c,order_total_before_tax__c, sales_tax__c, totalamount, monthly_payment__c, downpayment_amount__c, status,effectivedate, accountid,* from salesforce.order  where customer_order_number__c='"+customerOrderNo+"'";

            println(str1)
			ResultSet rs=a.dataBaseConnection(str1, GlobalVariable.pghost,,GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)
			String orderId=''
			while ( rs.next() ) {
				orderId=rs.getString('order_id__c')
				//println(rs.getString('status') + rs.getString('customer_order_number__c') + rs.getString('payment_terms__c')+ feePaymentPlan )
				//println(rs.getString('order_total_before_tax__c') + subtotal+ rs.getString('sales_tax__c')+salesTax + rs.getString('totalamount')+totalrate)

				if(rs.getString('status')=='Active' && rs.getString('customer_order_number__c')==customerOrderNo)
					/* &&
				rs.getString('payment_terms__c')==feePaymentPlan && rs.getString('order_total_before_tax__c')==subtotal &&
				rs.getString('sales_tax__c')==salesTax && rs.getString('totalamount')==totalrate)*/
				{
					verifyDB='Success'
					println('Success')
				}
				else {
					verifyDB='Unsuccessful,'
					status='fail'
				}
			}

			String orderSummaryId=''
			if(verifyDB=='Success')
			{
				String str2="select order_summary_id__c, sfid,item_name__C, * from salesforce.orderitem where order__order_id__c='"+orderId+"'"
				println(str2)
				rs=a.dataBaseConnection(str2,  GlobalVariable.pghost,,GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)
				//println(res)
				while ( rs.next() ) {
					orderSummaryId=rs.getString('order_summary_id__c')
					//econ_contract_number=rs.getString(c)
					if(portal!='Nissan')
					{
				   con_num=rs.getInt('external_reference_number__c')}
				   println(con_num)
					//int num=(int)econ_contract_number
					println(orderSummaryId)
					println(rs.getString('item_name__c')+plan+rs.getString('sales_date__c')+rs.getString('expiration_date__c')+rs.getString('sales_tax__c')+salesTax+rs.getString('summarydescription__c'))
					if(rs.getString('item_name__c')==plan &&
					rs.getString('sales_date__c')!=null && rs.getString('expiration_date__c')!=null &&
					 rs.getString('summarydescription__c')!=null)//rs.getString('sales_tax__c')==salesTax &&s

					{
						verifyDB='Success'
						println('Success')
					}
					else {
						verifyDB='Unsuccessful,'
						status='fail'
					}


				}

				if(verifyDB=='Success')
				{
					String str3="select value__c,_hc_lastop, _hc_err, order_metadata_external_id__c,* from salesforce.order_metadata__c where order__r__order_id__c='"+orderId+"'"
					rs=a.dataBaseConnection(str3,  GlobalVariable.pghost,,GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)
					
					while ( rs.next() ) {
						println(rs.getString('_hc_lastop')+rs.getString('_hc_err'))
						if( rs.getString('_hc_err')==null)//rs.getString('_hc_lastop')=='SYNCED' &&

						{
							verifyDB='Success'
							println('Success')
						}
						else {
							verifyDB='Unsuccessful,'
							status='fail'
							break
						}


					}
					if(verifyDB=='Success')
					{
						String str4="select orderpayment_id, * from public.orderpaymentrelation where order_external_id='"+orderId+"'"
						rs=a.dataBaseConnection(str4,  GlobalVariable.pghost,,GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)
						println(rs)
						while ( rs.next() ) {
							if(rs.getString('orderpayment_id')!=null && rs.getString('order_external_id')==orderId &&
							rs.getString('cc_last_four')!=null && rs.getString('cc_exp_month')!=null &&
							rs.getString('cc_exp_year')!=null &&
							rs.getString('created_by')=='APP' && rs.getString('updated_by')=='APP' &&
							rs.getString('created_date')!=null && rs.getString('updated_date')!=null)

							{
								verifyDB='Success'
								println('Success')
							}
							else {
								verifyDB='Unsuccessful,'
								status='fail'
							}


						}
						if(verifyDB=='Success')
						{
							String str5="select * from public.contract_pdf where order_summary_id='"+orderSummaryId+"'"
							rs=a.dataBaseConnection(str5,  GlobalVariable.pghost,,GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)
							//println(res)
							while ( rs.next() ) {

								if(rs.getString('order_summary_id')==orderSummaryId && rs.getString('data')!=null)
								{

									verifyDB='Heroku Success'
									println('Heroku Success')
								}
								else {
									verifyDB='Unsuccessful,'
									status='fail'
								}


							}
						}
					}
				}
			}
			a.closeConnection()
           if(verifyDB=='Success' && portal !='Nissan')
           {
			//  String cmd1='plink -ssh test01@qtsuatgmcms1 -pw testuser1234 "cd /data/scripts && sh process_econtracts"' 
//String cmd2='testuser1234'
//String cmd3='cd /data/scripts' 
//String cmd4='sh process_econtracts'
//Runtime.getRuntime().exec(cmd1)
			PGDatabaseConnection te=new PGDatabaseConnection();
			
			String str6="select * from web_con_m1 where id = '"+ con_num +"'";
			println(str6)
			ResultSet rs1=te.dataBaseConnection(str6, 'qtsuatpost6:54262','forte', 'pkumar', 'Sep@2022')
			//String orderId=''
			//println(res)s
			while ( rs1.next() ) {
				//orderId=rs1.getString('order_id__c')
				//println(orderId)
				if(rs1.getString('id')!=null && rs1.getString('web_con_vin')!=null &&
				rs1.getString('web_con_product')!=null && rs1.getString('web_con_rectype')!=null &&
				rs1.getString('web_con_trandate')!=null && rs1.getString('web_con_lname')!=null)
				{
					verifyDB='web_con_m1 Success'
					println('web_con_m1 Success')
				}
				else {
					verifyDB='heroku success and web_con_m1 Unsuccessful,'
					status='fail'
				}
			
			}
			if(verifyDB=='Success' && portal !='Nissan')
			{
			String str7="select * from dms_con_m1 where dms_con_webid='"+ con_num +"'";
			ResultSet rs2=te.dataBaseConnection(str7, 'qtsuatpost6:54262','forte', 'pkumar', 'Sep@2022')
			
			//String orderId=''
			println(str7)
			while ( rs2.next() ) {
				//orderId=rs1.getString('order_id__c')
				//println(orderId)
				dms_con=rs2.getString('dms_con_contract')
				cms_contract_Id=rs2.getString('dms_con_contract')
				println(dms_con + '   '+rs2.getString('dms_con_contract'))
				if( rs2.getString('dms_con_vin')!=null &&
				rs2.getString('dms_con_product')!=null && rs2.getString('dms_con_rectype')!=null &&
				rs2.getString('dms_con_trandate')!=null && rs2.getString('dms_con_lname')!=null)
				{
					verifyDB='dms_con_m1 Success'
					println('DMS verification Success')
				}
				else {
					verifyDB='heroku success and dms Unsuccessful,'
					status='fail'
				}
			}
			}
			if(verifyDB=='Success' && portal !='Nissan')
				{
				String str8="select * from sg_con_m1 where sg_con_contract = '"+ dms_con +"'";
				ResultSet rs3=te.dataBaseConnection(str8, 'qtsuatpost6:54262','forte', 'pkumar', 'Sep@2022')
				//String orderId=''
				println(str8)
				while ( rs3.next() ) {
					//orderId=rs1.getString('order_id__c')
					//println(orderId)
					cms_contract_Id=rs3.getString('sg_con_contract')
					//println(cms_contract_Id)
					if( rs3.getString('sg_con_vin')!=null &&
					rs3.getString('sg_con_carrier')!=null && rs3.getString('sg_con_cover')!=null &&
					rs3.getString('sg_con_status')!=null && rs3.getString('sg_con_lname')!=null)
					{
						verifyDB='sg_con_m1 Success'
						println('Success')
					}
					else {
						verifyDB='heroku success and sg_con_m1 Unsuccessful,'
						status='fail'
					}
				}
				}
			te.closeConnection()
			}



		}
	else {
		verifyDB='NA'
		cms_contract_Id='NA'
	}
		writeResult()
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

		String[] valueToWrite = new String[19]

		(valueToWrite[0]) = testCase
		(valueToWrite[1]) = portal
		(valueToWrite[2]) = oid
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
		(valueToWrite[16])=cms_contract_Id
		(valueToWrite[17]) = currentDate
		(valueToWrite[18]) = error_msg

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