import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.Keys as Keys

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import utility.UtilKeywords as UtilKeywords
import excelPackage.ExcelKeywords as ExcelKeywords
//import DatabaseConnection as DbConnection
import java.sql.*



class VroomStepDefinition {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	String baseURL="";
	String data_repo="VolksW";
	String status="Pass";
	String error_msg="";
	String firstName="";
	String lastName="";
	String portal="";
	String testCase="";
	String oid="";
	String totalrate="";
	String subtotal="";
	String salesTax="";
	String province="";
	String plan=""
	String term=""
	String termLength=''
	String mileage=''
	String deductible=''
	String commercialUse=''
	String customerOrderNo=''
	String feePaymentPlan=''
	String verifyDB=''
	String econ_contract_number=''
	String cms_contract_Id=''
	@Given("Go to vroom url with data as (.*) and (.*) and (.*)")
	public void Go_to_url_with_data(String testCase, String portal,String oid)  {
		this.testCase=testCase;
		this.portal=portal
		this.oid=oid
		if(testCase=="1") {
			ExcelKeywords excelKeywords = new ExcelKeywords()

			excelKeywords.deleteExcel(System.getProperty('user.dir'), 'Result.xlsx', 'Vroom_Result');
		}
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		if(portal=="Vroom" || portal=="vroom") {
			WebUI.navigateToUrl(GlobalVariable.VroomURL+oid)
			baseURL=GlobalVariable.baseVroomURL
			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Vroom - Vehicle Service Protection/a_Agreement'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Vroom - Vehicle Service Protection/a_Get Your Price'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Vroom - Vehicle Service Protection/div_Verify Your VehicleSelect your state an_8d2498'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Vroom - Vehicle Service Protection/i_v 5.8.0_fa-times modal-close-icon fas'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Vroom - Vehicle Service Protection/a_Terms and Conditions'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Vroom - Vehicle Service Protection/a_Privacy'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Vroom - Vehicle Service Protection/a_Accessibility'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Vroom - Vehicle Service Protection/i_Help_fa-phone fas'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Vroom - Vehicle Service Protection/i_(833) 951-0123_fa-times fas'))

			WebUI.switchToWindowUrl(GlobalVariable.VroomURL+oid)
		}
		else if (portal=="Nissan" || portal=="nissan") {
			WebUI.navigateToUrl(GlobalVariable.NisssanURL+oid)
			baseURL=GlobalVariable.baseNissanURL
			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Nissan - Added Security Plans/a_Products'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Nissan - Added Security Plans/a_Products'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Nissan - Added Security Plans/a_Explore Plans'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Nissan - Added Security Plans/i_v 5.8.0_fa-times modal-close-icon fas'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Nissan - Added Security Plans/a_Terms and Conditions'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Nissan - Added Security Plans/a_Privacy'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Nissan - Added Security Plans/a_Accessibility'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Nissan - Added Security Plans/i_Prepaid Maintenance_fa-phone fas'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_Nissan - Added Security Plans/button_(855) 999-1857_close'))
			WebUI.switchToWindowUrl(GlobalVariable.NisssanURL+oid)
		}
		else if (portal=="Schomp" || portal=="schomp") {
			WebUI.navigateToUrl(GlobalVariable.SchompURL+oid)
			baseURL=GlobalVariable.baseSchompURL
			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect Vehicle Service Protection_c0e085/a_View Agreement  Exclusions'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect Vehicle Service Protection_c0e085/a_Get Protected'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect Vehicle Service Protection_c0e085/i_v 5.8.0_fa-times modal-close-icon fas'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect Vehicle Service Protection_c0e085/a_ADD COVERAGE'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect Vehicle Service Protection_c0e085/i_v 5.8.0_fa-times modal-close-icon fas'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect Vehicle Service Protection_c0e085/a_View Agreement Exclusions2'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect Vehicle Service Protection_c0e085/a_Terms and Conditions'))


			WebUI.switchToWindowTitle('One Protect Vehicle Service Protection (VSP) plan')

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect Vehicle Service Protection_c0e085/a_Privacy'))

			WebUI.switchToWindowTitle('One Protect Vehicle Service Protection (VSP) plan')

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect Vehicle Service Protection_c0e085/a_Accessibility'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect Vehicle Service Protection_c0e085/i_Help_fa-phone fas'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect Vehicle Service Protection_c0e085/i_(833) 954-0085_fa-times fas'))

		}
		WebUI.delay(5)
	}

	@And("enter as  (.*) and (.*)")
	public void enter_province_and_odometer(String vehicle_reg_province,String mileage) {
		this.province=vehicle_reg_province
		this.mileage=mileage



		if(vehicle_reg_province!="") {
			WebUI.selectOptionByLabel(findTestObject('Object Repository/'+portal+'/select_Vehicle_Reg_Province'),
					vehicle_reg_province, true)
			//String allBranchLocations = WebUI.getText(findTestObject('Object Repository/'+portal+'/select_Vehicle_Reg_Province'))
			//List allBranchesList=allBranchLocations.split("\\r?\\n") //Remove CRLF from each dropdown entry
			//province=allBranchesList[0]
			//println(province)
		}

		WebUI.setText(findTestObject('Object Repository/'+portal+'/input_Current mileage_odometerId'),
				mileage)
	}


	@When("Click on get your price button")
	public void click_on_get_your_price_button() {
		// Write code here that turns the phrase above into concrete actions

		WebUI.click(findTestObject('Object Repository/'+portal+'/b_Get Your Price'))

		WebUI.delay(5)
		println(baseURL+'/my-asp-pricing')
		if((WebUI.getUrl()!=baseURL+'/my-vsp-pricing') && (WebUI.getUrl()!=baseURL+'/my-asp-pricing'))
		{
			WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/login_err.png')
			status='fail'
			error_msg='Failed to move to vsp pricing page'

		}}




	@When("Enter plan selection information (.*) and (.*) and (.*) and  click on view payment options button")
	public void enter_plan_selection_information_Platinum_and_termMileage_and_commercialuse_and_click_on_view_payment_options_button(String plan,String termLength,String commercialUse) {
		if(status=='Pass') {
			this.plan=plan
			this.termLength=termLength
			this.commercialUse=commercialUse
			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/a_Whats this'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/a_Close'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/div_What if my vehicle is still under warranty'))

			WebUI.switchToWindowTitle('One Protect - Get Rates')
			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_What if my vehicle is still under warrant_d30b4f'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_Where can I have my vehicle repaired_mdb-_bfe096'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/strong_claims help page'))

			WebUI.switchToWindowTitle('One Protect - Get Rates')
			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_Where can I have my vehicle repaired_mdb-_bfe096'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_Can I cancel my plan_mdb-accordion-indica_027e87'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/strong_cancellations help page'))

			WebUI.switchToWindowTitle('One Protect - Get Rates')
			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_Can I cancel my plan_mdb-accordion-indica_027e87'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_Can I transfer my plan if I sell my car_m_2c8249'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/strong_Customer Agreement'))

			WebUI.switchToWindowTitle('One Protect - Get Rates')
			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_Can I transfer my plan if I sell my car_m_2c8249'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_What is not covered_mdb-accordion-indicat_fad210'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/strong_Customer Agreement2'))

			WebUI.switchToWindowTitle('One Protect - Get Rates')
			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_What is not covered_mdb-accordion-indicat_fad210'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_What is included with Roadside Assistance_d27c1b'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_What is included with Roadside Assistance_d27c1b'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_How does the Trip Interruption benefit wo_d1733e'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/strong_Customer Agreement3'))

			WebUI.switchToWindowTitle('One Protect - Get Rates')
			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_How does the Trip Interruption benefit wo_d1733e'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_What is included with Rental Car coverage_a0bebb'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/strong_Customer Agreement4'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_What is included with Rental Car coverage_a0bebb'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_Where can I find more details on what is _04d02b'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/strong_Read the Customer Agreement'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_Where can I find more details on what is _04d02b'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/a_Terms and Conditions'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/a_Privacy'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/a_Accessibility'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_Help_fa-phone fas'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/Page_One Protect - Get Rates/i_(833) 954-0085_fa-times fas'))
			WebUI.switchToWindowTitle('One Protect - Get Rates')

			WebUI.click(findTestObject('Object Repository/'+portal+'/div_'+plan))


			WebUI.selectOptionByLabel(findTestObject('Object Repository/'+portal+'/select_termMileage'),
					termLength, true)
			if((portal=="vroom" || portal=="Vroom") && (commercialUse=="yes" || commercialUse == "Yes"))
			{
				WebUI.click(findTestObject('Object Repository/'+portal+'/span_NoYes_lever'))
			}
			WebUI.click(findTestObject('Object Repository/'+portal+'/span_View Payment Options'))

			WebUI.delay(5)
			if(WebUI.getUrl()!=baseURL+'/cart')
			{
				WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/vsp_page_err.png')
				status='fail'
				error_msg='Failed to move to rates page'

			}
		}

	}

	@When("enter feepaymentplan options as (.*) and click on checkout button")
	public void enter_feepaymentplan_options_as_months_and_click_on_checkout_button(String feePaymentPlan) {
		if(status=='Pass')
		{
			this.feePaymentPlan=feePaymentPlan
			//WebUI.click(findTestObject('Object Repository/'+portal+'/links/span_View Payment Options'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/links/a_VIEW AGREEMENT  EXCLUSIONS'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/links/a_VIEW AGREEMENT  EXCLUSIONS'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/links/a_REMOVE'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/links/a_No, take me back'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/links/a_Terms and Conditions'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/links/a_Privacy'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/links/a_Accessibility'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/links/a_Help_call'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/links/i_(833) 954-0085_fa-times fas'))
			WebUI.click(findTestObject('Object Repository/'+portal+'/div_'+feePaymentPlan))

			WebUI.click(findTestObject('Object Repository/'+portal+'/button_CHECKOUT'))


			WebUI.delay(5)
			if(WebUI.getUrl()!=baseURL+'/checkout')
			{
				WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/rates_err.png')
				status='fail'
				error_msg='Failed to move to checkout page'


			}}
	}


	@When("Enter personal details (.*) and (.*) and (.*) and (.*) and (.*) and click on continue to billing button.")
	public void enter_personal_details_and_click_on_continue_to_billing_button(String firstName,String lastName,String email, String phoneNo,String address) {
		// Write code here that turns the phrase above into concrete actions
		if(status=='Pass')
		{this.firstName=firstName
			this.lastName=lastName

			WebUI.click(findTestObject('Object Repository/'+portal+'/links/a_Go back to Cart'))

			WebUI.click(findTestObject('Object Repository/'+portal+'/links/button_CHECKOUT'))
			WebUI.click(findTestObject('Object Repository/'+portal+'/links/a_VIEW AGREEMENT  EXCLUSIONS_1'))
			subtotal=WebUI.getText(findTestObject('Object Repository/'+portal+'/rates_subtotal'))
			salesTax=WebUI.getText(findTestObject('Object Repository/'+portal+'/sales_tax'))
			totalrate=WebUI.getText((findTestObject('Object Repository/'+portal+'/total_rates')))
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
			//if(WebUI.ve)

			WebUI.click(findTestObject('Object Repository/'+portal+'/button_COMPLETE'))
		}

	}

	@And("Enter vroom payment details (.*) and (.*) and (.*) and (.*) and (.*) and click on pay button")
	public void enter_payment_details(String nameOnCard, String cardNumber,String expMonth, String expYear, String cvc)
	{   if(status=='Pass') {
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

			//if(WebUI.verifyElementPresent(findTestObject('Object Repository/'+portal+'/input_termsState'), 5))
			//if(salesTax=="\$0.00")
			try {
				if(WebUI.verifyElementPresent(findTestObject('Object Repository/'+portal+'/input_termsState'), 5, FailureHandling.OPTIONAL))
				{
					WebUI.click(findTestObject('Object Repository/'+portal+'/input_termsState'))
				}}
			catch(Exception e)
			{
				println('termsState element not present')
			}

			WebUI.click(findTestObject('Object Repository/'+portal+'/span_Pay Now'))


			WebUI.delay(15)

			WebUI.waitForElementPresent(findTestObject('Object Repository/'+portal+'/p_orderid'), 60)
			if(WebUI.getUrl()!=baseURL+'/checkout/confirmation')
			{
				WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/checkout_err.png')
				status='fail'
				error_msg='Error in checkout page data'

			}}

	}
	@Then("copy orderid and close the browser")
	public void copy_orderid_and_close_the_browser() {
		// Write code here that turns the phrase above into concrete actions
		if(status=='Pass')
		{
			WebUI.verifyElementPresent(findTestObject('Object Repository/'+portal+'/p_orderid'), 5)

			customerOrderNo=WebUI.getText(findTestObject('Object Repository/'+portal+'/p_orderid'))

			//writeResult()
			//println(orderid)
			//WebUI.closeBrowser()
		}
		//writeResult()

	}
	@And("Verify the order details from database")
	public void verify_the_order_details()
	{
		if(status=='Pass')
		{
			PGDatabaseConnection a=new PGDatabaseConnection();
			String str1="select order_id__c,sfid, status,customer_order_number__c,payment_terms__c,order_total_before_tax__c, sales_tax__c, totalamount, monthly_payment__c, downpayment_amount__c, status,effectivedate, accountid,* from salesforce.order  where customer_order_number__c='"+customerOrderNo+"'"


			ResultSet rs=a.dataBaseConnection(str1, GlobalVariable.pghost,,GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)
			String orderId=''
			//println(res)
			while ( rs.next() ) {
				orderId=rs.getString('order_id__c')
				println(orderId)

				if(rs.getString('status')=='Active' && rs.getString('customer_order_number__c')!=customerOrderNo &&
				rs.getString('payment_terms__c')!=feePaymentPlan && rs.getString('order_total_before_tax__c')!=subtotal &&
				rs.getString('sales_tax__c')!=salesTax && rs.getString('totalamount')!=totalrate)
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
				//println(str2)
				rs=a.dataBaseConnection(str2,  GlobalVariable.pghost,,GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)
				//println(res)
				while ( rs.next() ) {
					orderSummaryId=rs.getString('order_summary_id__c')
					econ_contract_number=rs.getString('external_reference_number__c')
					println(orderSummaryId)
					if(rs.getString('item_name__c')!=plan &&
					rs.getString('sales_date__c')!=null && rs.getString('expiration_date__c')!=null &&
					rs.getString('sales_tax__c')!=salesTax && rs.getString('summarydescription__c')!=null)

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
					println(rs)
					while ( rs.next() ) {

						if(rs.getString('_hc_lastop')=='SYNCED' && rs.getString('_hc_err')==null)

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
							rs.getString('created_by')=='APP' && rs.getString('updated_by')=='scheduler' &&
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

									verifyDB='Success'
									println('Success')
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
			DatabaseConnection db=new DatabaseConnection();
			String sqlqu1="select vin, status, last_name, * from econ_contract where econ_contract_number = '";
			cms_contract_Id=db.dataBaseConnection(econ_contract_number,GlobalVariable.sqlDBInstance,'SGEAS_DIFF');
			println(cms_contract_Id)

		}
		else {
			verifyDB='NA'
			cms_contract_Id='NA'
		}
		writeResult()
		WebUI.closeBrowser()
	}

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
		(valueToWrite[5]) = province
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
}

