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
import utility.jsscript as jsscript
import java.sql.*;

public class Gmstep {
	String baseURL="";
	String data_repo="VolksW";
	String status="Pass";
	String error_msg="";
	String firstName="";
	String lastName="";
	String portal="";
	String testCase="";
	String vinNo="";
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
	String id=''
	String liftKit=''
	String greyMarket=''
	@Given("Go to GM1 url with data as (.*) and (.*)" )
	def Go_to_url_wit_data(String testCase, String portal) {
		this.testCase=testCase;
		this.portal=portal;
		if(testCase=="1") {
			ExcelKeywords excelKeywords = new ExcelKeywords()

			excelKeywords.deleteExcel(System.getProperty('user.dir'), 'Result.xlsx', 'GM_result');
		}
		WebUI.openBrowser('')

		if(portal=='GMC' || portal=='gmc') {
			WebUI.navigateToUrl(GlobalVariable.gmcURL)
			baseURL=GlobalVariable.basegmcURL
		}
		else if (portal=="Chevrolet" || portal=="chevrolet") {
			WebUI.navigateToUrl(GlobalVariable.chevroletURL)
			baseURL=GlobalVariable.basechevroletURL
		}
		else if (portal=="Buick" || portal=="buick") {
			WebUI.navigateToUrl(GlobalVariable.buickURL)
			baseURL=GlobalVariable.baseBuickURL
		}
		else if (portal=="Cadillac" || portal=="Cadillac") {
			WebUI.navigateToUrl(GlobalVariable.cadillaURL)
			baseURL=GlobalVariable.baseCadillaURL
		}
	}

	@And("enter GM1 as (.*) and (.*) and (.*)")
	def enter_GM_vinno_province_odometer(String vinNo,String province,String odometer) {
		this.vinNo=vinNo;
		this.province=province
		this.mileage=odometer


		//WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/button_Get Your Quote'))

		//WebUI.switchToWindowIndex(0)
		WebUI.waitForElementVisible(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_VIN_vin'), 10)
		WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_VIN_vin'), vinNo)


		WebUI.setText(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/input_Current mileage_editVehicleOdometerVIN'),
				odometer)


		WebUI.selectOptionByValue(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/select_AlabamaAlaskaArizonaArkansasCaliforn_eff432'),
				province, true)
	}





	@When("Click on GM1 find my price button")
	public void click_on_get_your_price_button() {
		// Write code here that turns the phrase above into concrete actions

		//WebUI.click(findTestObject('Object Repository/'+portal+'/b_Get Your Price'))
		WebUI.click(findTestObject('Object Repository/GM/Page_GMC Protection Plan Vehicle Service Pr_1fd231/button_Find My Price'))

		WebUI.delay(5)
		println(baseURL+'/my-asp-pricing')
		if((WebUI.getUrl()!=baseURL+'/my-vsp-pricing?plan='+portal.toUpperCase()+'1') && (WebUI.getUrl()!=baseURL+'/my-vsp-pricing?plan=CHEVY1') && (WebUI.getUrl()!=baseURL+'/my-asp-pricing'))
		{
			WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/'+testCase+'login_err.png')
			status='fail'
			error_msg='Failed to move to vsp pricing page'

		}}




	@When("Enter GM1 plan selection information (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and  click on view payment options button")
	public void enter_plan_selection_information_Platinum_and_termMileage_and_commercialuse_and_click_on_view_payment_options_button(String plan,String termLength,String commercialUse,String liftKit, String greyMarket, String deductible) {
		if(status=='Pass') {
			if(plan=="")
			{
				plan="Powertrain"
			}
			this.plan=plan
			this.termLength=termLength
			this.commercialUse=commercialUse
			this.liftKit=liftKit
			this.greyMarket=greyMarket


			WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/div_'+plan))

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Vroom/select_termMileage'),
					termLength, true)


			/*	catch(Exception e)
			 {
			 WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/label_err.png')
			 status='fail'
			 error_msg='Invalid termlength'
			 }*/
			if(deductible=='100')
			{
				WebUI.waitForElementClickable(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductile_100'), 30)
				UtilKeywords utilKeywordst = new UtilKeywords()
				utilKeywordst.clickUsingJS(findTestObject('Object Repository/GM/Page_GMC - Get Rates/deductile_100'), 30)
			}
			if(deductible=='250')
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
			if( (liftKit == "yes" || liftKit == "Yes"))
			{
				//WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_NoYes_lever_1'))
				WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever2'))
			}
			if( (greyMarket == "yes" || greyMarket == "Yes"))
			{
				WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever3'))
				//WebUI.click(findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_NoYes_lever_1_2'))
			}

			WebUI.click(findTestObject('Object Repository/Vroom/span_View Payment Options'))

			WebUI.delay(5)
			if(WebUI.getUrl()!=baseURL+'/cart')
			{
				WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/'+testCase+'vsp_page_err.png')
				status='fail'
				error_msg='Failed to move to rates page'

			}
			println(status)
		}

	}

	@When("enter GM1 feepaymentplan options as (.*) and click on checkout button")
	public void enter_feepaymentplan_options_as_months_and_click_on_checkout_button(String feePaymentPlan) {
		if(status=='Pass')
		{
			this.feePaymentPlan=feePaymentPlan
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
		WebUI.delay(5)
		if(WebUI.getUrl()!=baseURL+'/checkout')
		{
			WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/'+testCase+'rates_err.png')
			status='fail'
			error_msg='Failed to move to checkout page'


		}}
}


@When("Enter GM1 personal details (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and click on continue to billing button.")
public void enter_personal_details_and_click_on_continue_to_billing_button(String firstName,String lastName,String email, String phoneNo,String address, String city,String state,String zip) {
	// Write code here that turns the phrase above into concrete actions
	if(status=='Pass')
	{this.firstName=firstName
		this.lastName=lastName


		subtotal=WebUI.getText(findTestObject('Object Repository/Vroom/rates_subtotal'))
		salesTax=WebUI.getText(findTestObject('Object Repository/Vroom/sales_tax'))
		totalrate=WebUI.getText((findTestObject('Object Repository/Vroom/CartTotal_rates')))
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

		//if(WebUI.verifyElementChecked(findTestObject('Object Repository/Vroom/button_Continue to Billing'), 30, FailureHandling.STOP_ON_FAILURE))
		//	{
		WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Billing'))


		WebUI.delay(1)

		WebUI.setText(findTestObject('Object Repository/GM/GM_city'), city)
		WebUI.selectOptionByValue(findTestObject('Object Repository/GM/GM_state'), state,true)
		//WebUI.setText(findTestObject('Object Repository/GM/GM_city'), state)
		WebUI.setText(findTestObject('Object Repository/GM/GM_zip'), zip)
		try {
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
}





@And("Enter GM1 payment details (.*) and (.*) and (.*) and (.*) and (.*) and click on pay button")
public void enter_GM_payment_details(String nameOnCard, String cardNumber,String expMonth, String expYear, String cvc)
{   if(status=='Pass') {
		WebUI.setText(findTestObject('Object Repository/Vroom/input_Name On Card'), nameOnCard)

		WebUI.setText(findTestObject('Object Repository/Vroom/input_Card Number'),
				cardNumber)

		def d = Date.parse('MMM', expMonth)
		def num = d.format('MM')

		WebUI.selectOptionByValue(findTestObject('Object Repository/Vroom/select_Month'),
				num, true)

		WebUI.selectOptionByValue(findTestObject('Object Repository/Vroom/select_Year'),
				expYear, true)

		WebUI.setText(findTestObject('Object Repository/Vroom/input_CVC'), cvc)

		WebUI.click(findTestObject('Object Repository/Vroom/label_Billing address check box'))

		WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Review'))

		WebUI.click(findTestObject('Object Repository/Vroom/button_Terms_and_conditions'))


		WebUI.click(findTestObject('Object Repository/Vroom/label_acceptAgreement'))

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
		WebUI.click(findTestObject('Object Repository/Vroom/span_Pay Now'))


		WebUI.delay(15)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Vroom/p_orderid'), 60)
		if(WebUI.getUrl()!=baseURL+'/checkout/confirmation')
		{
			WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/'+testCase+'checkout_err.png')
			status='fail'
			error_msg='Error in checkout page data'

		}}

}
@Then("copy GM1 orderid and close the browser")
public void copy_orderid_and_close_the_browser() {
	// Write code here that turns the phrase above into concrete actions
	if(status=='Pass')
	{
		WebUI.verifyElementPresent(findTestObject('Object Repository/Vroom/p_orderid'), 5)

		customerOrderNo=WebUI.getText(findTestObject('Object Repository/Vroom/p_orderid'))

		//writeResult()
		println(customerOrderNo)
		//WebUI.closeBrowser()
	}
	writeResult()

}
@And("Verify GM1 the order details from database")
public void verify_the_order_details()
{
	if(status=='Pass')
	{
		PGDatabaseConnection a=new PGDatabaseConnection();
		String str1="select order_id__c,sfid, status,customer_order_number__c,payment_terms__c,order_total_before_tax__c, sales_tax__c, totalamount, monthly_payment__c, downpayment_amount__c, status,effectivedate, accountid,* from salesforce.order  where customer_order_number__c='"+customerOrderNo+"'";


		ResultSet rs=a.dataBaseConnection(str1, GlobalVariable.pghost,,GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)
		String orderId=''
		//println(res)
		while ( rs.next() ) {
			orderId=rs.getString('order_id__c')
			println(orderId)

			if(rs.getString('status')=='Active' && rs.getString('customer_order_number__c')==customerOrderNo &&
			rs.getString('payment_terms__c')==feePaymentPlan && rs.getString('order_total_before_tax__c')==subtotal &&
			rs.getString('sales_tax__c')==salesTax && rs.getString('totalamount')==totalrate)
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
				//int num=(int)econ_contract_number
				println(orderSummaryId)
				if(rs.getString('item_name__c')==plan &&
				rs.getString('sales_date__c')!=null && rs.getString('expiration_date__c')!=null &&
				rs.getString('sales_tax__c')==salesTax && rs.getString('summarydescription__c')!=null)

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

		PGDatabaseConnection te=new PGDatabaseConnection();
		String str6="select * from web_con_m1 where id = '"+Integer.parseInt(econ_contract_number)+"'";
		ResultSet rs1=te.dataBaseConnection(str6, 'qtsuatpost6:54262','forte', 'pkumar', 'Aug@2022')
		//String orderId=''
		//println(res)
		while ( rs.next() ) {
			orderId=rs.getString('order_id__c')
			println(orderId)
			if(rs1.getString('id')!=null && rs1.getString('web_con_vin')!=null &&
			rs1.getString('web_con_product')!=null && rs1.getString('web_con_rectype')!=null &&
			rs1.getString('web_con_trandate')!=null && rs1.getString('web_con_lname')!=null)
			{
				verifyDB='Success'
				println('Success')
			}
			else {
				verifyDB='Unsuccessful,'
				status='fail'
			}
		}
		te.closeConnection()




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
	(valueToWrite[12]) = totalrate
	(valueToWrite[13]) = status
	(valueToWrite[14]) = customerOrderNo
	(valueToWrite[15]) = verifyDB
	(valueToWrite[16])=cms_contract_Id
	(valueToWrite[17]) = currentDate
	(valueToWrite[18]) = error_msg

	ExcelKeywords excelKeywords = new ExcelKeywords()

	excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'GM_Result', valueToWrite)

}

