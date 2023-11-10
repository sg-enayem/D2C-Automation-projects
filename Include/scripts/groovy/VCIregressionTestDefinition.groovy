import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent
import java.sql.ResultSet
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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import utility.UtilKeywords as UtilKeywords
import excelPackage.ExcelKeywords as ExcelKeywords


class VCIregressionTestDefinitions {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	String url="";
	String data_repo="VolksW";
	String status="pass";
	String error_msg="";
	String firstName="";
	String lastName="";
	String portal="";
	String testCase="";
	String vinNo="";
	String totalrate="";
	String installmentrate="";
	String actualtax="";
	String province="";
	String plan=""
	String term=""
	String termMiles=''
	String odometer=''
	String deductible=''
	String econ_contract_number=''
	String verifyDB;


	@Given("Go to url with data as (.*) and (.*)" )
	def Go_to_url_wit_data(String testCase, String portal) {
		this.testCase=testCase;
		this.portal=portal;
		if(testCase=="1") {
			ExcelKeywords excelKeywords = new ExcelKeywords()

			excelKeywords.deleteExcel(System.getProperty('user.dir'), 'Result.xlsx', 'VCI_Result');
		}
		WebUI.openBrowser('')

		if(portal=='volkswagen' || portal=='Volkswagen') {
			WebUI.navigateToUrl(GlobalVariable.VWURL)
			url=GlobalVariable.VWURL
		}
		else if (portal=="Audi" || portal=="audi") {
			WebUI.navigateToUrl(GlobalVariable.AudiURL)
			url=GlobalVariable.AudiURL
		}
	}

	@And("enter as (.*) and (.*) and (.*)")
	def enter_vinno_province_odometer(String vinNo,String province,String odometer) {
		this.vinNo=vinNo;
		this.province=province
		this.odometer=odometer

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Explore additional benefits_c-accordio_2dc32c'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Explore additional benefits_c-accordio_2dc32c_1'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Explore additional benefits_c-accordio_2dc32c'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Explore additional benefits_c-accordio_2dc32c_1'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Explore additional benefits_c-accordio_2dc32c'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Explore additional benefits_c-accordio_2dc32c_1'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Explore additional benefits_c-accordio_2dc32c'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Explore additional benefits_c-accordio_2dc32c_1'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Explore additional benefits_c-accordio_2dc32c'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Explore additional benefits_c-accordio_2dc32c_1'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Download the brochure'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Download Sample Customer Agreement'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Audi Emissions Modification Lookup'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Privacy Terms'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Terms of Service'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Do Not Sell My Personal Information'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/button_Go to top'))

		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/button_Get Your Quote'))

		WebUI.switchToWindowIndex(0)
		WebUI.waitForElementVisible(findTestObject('Object Repository/VSC/'+data_repo+'/input_VIN'), 10)
		WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_VIN'), vinNo)

		WebUI.selectOptionByLabel(findTestObject('Object Repository/VSC/'+data_repo+'/select_Province'),
				province, true)

		WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_CurrentOdometer'),
				odometer)
	}



	@When("Click on get started button")
	def Clink_on_get_started_button() {
		WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/button_Get Started'))

		WebUI.delay(10)

		println(WebUI.getUrl())

		if(WebUI.getUrl()!=url+'/select-plan') {
			WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/login_err.png')
			status='fail'
			error_msg='Login Failed please check the Vin number'
			//writeResult()
			//WebUI.closeBrowser()

			//throw new Exception('Invalid login')
		}
		println(status)
	}
	@And("Enter plan selection information (.*) and (.*) and (.*) and (.*) and submit the details")
	def Enter_plan_VCI_selection_information(String plan,String deductible,String coverageInMonths,String coveredMiles) {
		if(status=='pass') {
			this.plan=plan
			this.deductible=deductible
			this.term=coverageInMonths
			this.termMiles=coveredMiles

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Powertrain_c-accordion__title-icon'))



			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Powertrain_c-accordion__title-icon'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Powertrain_c-accordion__title-icon_1'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Powertrain_c-accordion__title-icon_1'))




			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Audi Emissions Modification Lookup'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Privacy Terms'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Terms of Service'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Do Not Sell My Personal Information'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Go to top'))

			WebUI.switchToWindowIndex(0)

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/span_'+plan))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/span_'+deductible))

			WebUI.selectOptionByValue(findTestObject('Object Repository/VSC/'+data_repo+'/select_coverageInMonths'),
					coverageInMonths, true)

			WebUI.selectOptionByValue(findTestObject('Object Repository/VSC/'+data_repo+'/select_coveredMiles'),
					coveredMiles, true)

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/span_Installments'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/button_Next'))

			WebUI.delay(5)

			if(WebUI.getUrl()!=url+"/personal-details") {

				WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/term_err.png')
				status='fail'
				error_msg='Error in term selection page '
				//writeResult()
				//WebUI.closeBrowser()
				//throw new Exception('Invalid term selection page data')
			}
		}
	}

	@And("Enter personal details (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and submit the page.")
	def Enter_personal_details(String firstName,String lastName,String middleInitial,String homePhoneNo,String secondaryPhoneNumber, String email,String street,String city,String zipCode) {
		if(status=='pass') {
			this.firstName=firstName;
			this.lastName=lastName;
			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Audi Emissions Modification Lookup'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Privacy Terms'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Terms of Service'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Do Not Sell My Personal Information'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Go to top'))

			WebUI.switchToWindowIndex(0)
			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_customerFirstName'),
					firstName)

			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_customerLastName'),
					lastName)

			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_middleInitials'),
					middleInitial)

			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_customerHomePhone'),
					homePhoneNo)

			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_secondaryPhoneNumber'),
					secondaryPhoneNumber)

			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_emailAddress'),
					email)

			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_verifyEmailAddress'),
					email)

			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_Street Address'),
					street)

			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_customerCity'), city)

			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_customerZipCode'), zipCode)

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/span_Validate Address'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/span_address'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/button_Confirm'))

			WebUI.delay(30)

			if(WebUI.getUrl()!=url+"/enter-payment") {

				WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/personalInfo_err.png')
				status='fail'
				error_msg='Error in personal Info submission page '
				//writeResult()
				//WebUI.closeBrowser()
				//throw new Exception('Invalid personal data entered')
			}
		}
	}

	@And("Enter payment details (.*) and (.*) and (.*) and (.*) and click on pay button")
	def Enter_payment_details(String cardNumber,String expMonth,String expYear,String cvc) {
		if(status=='pass') {
			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Audi Emissions Modification Lookup'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Privacy Terms'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Terms of Service'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/a_Do Not Sell My Personal Information'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/ad/Page_Audi Pure Protection/span_Go to top'))
			WebUI.switchToWindowIndex(0)
			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/pointPdf'), FailureHandling.STOP_ON_FAILURE)

			Robot rb = new Robot()

			for (int i = 0; i < 6; i++) {
				rb.keyPress(KeyEvent.VK_PAGE_DOWN)

				rb.keyRelease(KeyEvent.VK_PAGE_DOWN)
			}


			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/span_E-SIGN'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/span_confirmInformation'))

			WebUI.clickOffset(findTestObject('Object Repository/VSC/'+data_repo+'/span_ReadandAgreeTerms'),
					-50, -10)

			//WebUI.click(findTestObject('Object Repository/VSC/VolksW/span_ReadandAgreeTerms'))
			WebUI.click(findTestObject('Object Repository/VSC/VolksW/span_Download'))
			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_firstName'), firstName)

			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_lastName'), lastName)

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/span_AddMySignature'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/span_agreeToMakeInstallment'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/span_Pay Now'))

			totalrate=WebUI.getText(findTestObject('Object Repository/VSC/'+data_repo+'/rate_total'));
			println(totalrate)
			installmentrate=WebUI.getText(findTestObject('Object Repository/VSC/'+data_repo+'/rate_installmentamt'));
			println(installmentrate)
			actualtax=WebUI.getText(findTestObject('Object Repository/VSC/'+data_repo+'/rate_tax'));
			println(actualtax)

			WebUI.waitForElementPresent(findTestObject('Object Repository/VSC/'+data_repo+'/input_CardType'), 5)

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/input_CardType'))

			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_CardNumber'), cardNumber)

			WebUI.selectOptionByValue(findTestObject('Object Repository/VSC/'+data_repo+'/select_Month'),
					expMonth, true)

			WebUI.selectOptionByValue(findTestObject('Object Repository/VSC/'+data_repo+'/select_Year'),
					expYear, true)

			WebUI.setText(findTestObject('Object Repository/VSC/'+data_repo+'/input_CV'),
					cvc)

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/input_lastpaybutton'))

			WebUI.delay(10)

			if(WebUI.getUrl()!=url+"/confirmation")
			{

				WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir()+'/Screenshots/payment_err.png')
				status='fail'
				error_msg='Error in payment submission page '

			}
		}
	}
	@Then("click on confirm button and download the contract and close the browser")
	def Click_on_confirm_button()
	{ if(status=='pass')
		{
			//WebUI.waitForElementPresent(findTestObject('Object Repository/VSC/'+data_repo+'/div_popup'), 10)

			//WebUI.focus(findTestObject('Object Repository/VSC/'+data_repo+'/div_popup'))

			WebUI.switchToWindowIndex(0)
			//WebUI.waitForElementPresent(findTestObject('Object Repository/VSC/'+data_repo+'/span_Confirm'), 10)


			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/span_Confirm'))

			WebUI.click(findTestObject('Object Repository/VSC/'+data_repo+'/button_Download Signed Contract'))

			WebUI.delay(5)
		}

	}

	@And("verify the order details in database")
	public void dbverify()
	{

		if(status=='pass')
		{
			DatabaseConnection db=new DatabaseConnection();
			//String sqlqu1="select vin, status, last_name, * from econ_contract where vin = '";
			ResultSet rs=db.dataBaseConnection(vinNo,GlobalVariable.sqlDBInstance)
			while ( rs.next() ) {
				if(rs.getString('vin')!=null && rs.getString('status')!=null &&
				rs.getString('last_name')!=null && rs.getString('Contract_ID')!=null &&
				rs.getString('eCon_Contract_ID')!=null &&
				rs.getString('Source_Application')!=null && rs.getString('Dealer_ID')!=null &&
				rs.getString('Transaction_ID')!=null && rs.getString('Year')!=null &&
				rs.getString('Make')!=null && rs.getString('Model')!=null )

				{
					econ_contract_number=rs.getString('econ_Contract_number')
					println(econ_contract_number)
					verifyDB='Success'
					println('Success')
				}
			}
		}
		else {
			verifyDB='Unsuccessful,'
			status='fail'
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
		(valueToWrite[7]) = term
		(valueToWrite[8]) = termMiles
		(valueToWrite[9]) = odometer
		(valueToWrite[10]) = deductible
		(valueToWrite[11]) = installmentrate
		(valueToWrite[12]) = actualtax
		(valueToWrite[13]) = totalrate
		(valueToWrite[14]) = status
		(valueToWrite[15]) = verifyDB
		(valueToWrite[16]) = econ_contract_number
		(valueToWrite[17]) = currentDate
		(valueToWrite[18]) = error_msg

		ExcelKeywords excelKeywords = new ExcelKeywords()
		excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'VCI_Result', valueToWrite)



	}


}