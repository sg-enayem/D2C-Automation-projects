package pdf_verification
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.exception.WebElementNotFoundException

//link 1 GMC
public class pdf_url_check {
	//String view_agreement_exclusion_pdf_url_GMC
	@Keyword
	def static void first_link_Nissan() {
		WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/a_View Agreement and Exclusions'))  // this will open a pdf
		WebUI.delay(2)
		WebUI.switchToWindowIndex(1)

		//public static view_agreement_exclusion_pdf_url_GMC = 'https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf'

		if(WebUI.getUrl()=='https://prismic-io.s3.amazonaws.com/sgidigital-dev/b614c723-33f7-4899-b3e2-0826eb02cc75_Gold+WM+Nissan+Added+Security+Plan+Gold+Application+0421+Blank_D2C+-+Final.pdf') {
			println('view_agreement_exclusion_pdf_url pdf links downloadable')
		}else {
			println('view_agreement_exclusion_pdf_url pdf links are not downloadable')
		}
		WebUI.closeWindowIndex(1)
		WebUI.delay(1)
		WebUI.switchToWindowIndex(0)
	}
	/////////
	@Keyword
	def static void first_link_GMC() {
		WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/a_View Agreement and Exclusions'))  // this will open a pdf
		WebUI.delay(2)
		WebUI.switchToWindowIndex(1)

		//public static view_agreement_exclusion_pdf_url_GMC = 'https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf'

		if(WebUI.getUrl()=='https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf') {
			println('view_agreement_exclusion_pdf_url pdf links downloadable')
		}else {
			println('view_agreement_exclusion_pdf_url pdf links are not downloadable')
		}
		WebUI.closeWindowIndex(1)
		WebUI.delay(1)
		WebUI.switchToWindowIndex(0)
	}
	//
	def static void sample_agreement_link_cartPage_vroom () {
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/a_View Agreement and Exclusions'))  // this will open a pdf
		WebUI.delay(2)
		WebUI.switchToWindowIndex(1)

		//public static view_agreement_exclusion_pdf_url_GMC = 'https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf'

		if(WebUI.getUrl()=='https://prismic-io.s3.amazonaws.com/sgidigital/d72661fb-e700-4a13-84ce-805fafdfd89c_VRVSCA-D2C_200918_Accessible_Sample.pdf') {
			println('view_agreement_exclusion_pdf_url pdf links downloadable')
		}else {
			println('view_agreement_exclusion_pdf_url pdf links are not downloadable')
		}
		WebUI.closeWindowIndex(1)
		WebUI.delay(1)
		WebUI.switchToWindowIndex(0)
	}
	//
	def static void second_link_GMC() {
		//verify pdf is downloadable or not : link_02
		WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/a_Payment Plan Agreement')) // will download pdf

		WebUI.delay(2)
		WebUI.switchToWindowIndex(1)

		//payment_plan_agreement_pdf='https://prismic-io.s3.amazonaws.com/sgidigital/0f760bd5-d4ea-4afb-9eaa-defe3f038820_PayLink+Direct+PPA+SAMPLE.pdf'


		if(WebUI.getUrl()=='https://prismic-io.s3.amazonaws.com/sgidigital/0f760bd5-d4ea-4afb-9eaa-defe3f038820_PayLink+Direct+PPA+SAMPLE.pdf') {
			println('payment_plan_agreement_pdf url links downloadable')
		}else {
			println('payment_plan_agreement_pdf url  pdf links are not downloadable')
		}

		WebUI.closeWindowIndex(1)

		WebUI.switchToWindowIndex(0)

		WebUI.delay(1)
	}
	//
	def static void third_link_GMC() {
		//verify pdf is downloadable or not : link_03
		WebUI.click(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/accept_Payment_Plan_Agreement'))

		WebUI.delay(2)
		WebUI.switchToWindowIndex(1)

		//payment_plan_agreement_accept_pdf='https://prismic-io.s3.amazonaws.com/sgidigital/0f760bd5-d4ea-4afb-9eaa-defe3f038820_PayLink+Direct+PPA+SAMPLE.pdf'


		if(WebUI.getUrl()=='https://prismic-io.s3.amazonaws.com/sgidigital/0f760bd5-d4ea-4afb-9eaa-defe3f038820_PayLink+Direct+PPA+SAMPLE.pdf') {
			println('payment_plan_agreement_pdf_accept url links downloadable')
		}else {
			println('payment_plan_agreement_pdf_accept url  pdf links are not downloadable')
		}

		WebUI.closeWindowIndex(1)

		WebUI.switchToWindowIndex(0)

		WebUI.delay(1)
	}
	def static void fourth_link_GMC() {
		//verify pdf is downloadable or not : link_04
		WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/a_View Agreement and Exclusions_1'))
		WebUI.delay(1)
		//view_agreement_exclusion_pdf_cartPage_contact_url = 'https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf'
		WebUI.delay(1)
		WebUI.switchToWindowIndex(1)

		if(WebUI.getUrl()=='https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf') {
			println('view_agreement_exclusion_pdf_contact_url pdf links downloadable on Checkout page')
		}else {
			println('view_agreement_exclusion_contact_pdf_url pdf links are not downloadable on Checkout Page')
		}

		WebUI.closeWindowIndex(1)

		WebUI.delay(1)

		WebUI.switchToWindowIndex(0)
		WebUI.delay(1)
	}
	////
	def static void sample_agreement_link_checkoutPage_contact_vroom() {
		//verify pdf is downloadable or not : link_04
		WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/a_View Agreement and Exclusions_1'))
		WebUI.delay(1)
		//view_agreement_exclusion_pdf_cartPage_contact_url = 'https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf'
		WebUI.delay(1)
		WebUI.switchToWindowIndex(1)

		if(WebUI.getUrl()=='https://prismic-io.s3.amazonaws.com/sgidigital/d72661fb-e700-4a13-84ce-805fafdfd89c_VRVSCA-D2C_200918_Accessible_Sample.pdf') {
			println('view_agreement_exclusion_pdf_contact_url pdf links downloadable on Checkout page')
		}else {
			println('view_agreement_exclusion_contact_pdf_url pdf links are not downloadable on Checkout Page')
		}

		WebUI.closeWindowIndex(1)

		WebUI.delay(1)

		WebUI.switchToWindowIndex(0)
		WebUI.delay(1)
	}

	def static void fifth_link_GMC() {
		//verify pdf is downloadable or not : link_05

		WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/a_View Agreement and Exclusions_1'))
		//view_agreement_exclusion_pdf_cartPage_billing_url = 'https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf'
		WebUI.delay(1)
		WebUI.switchToWindowIndex(1)

		if(WebUI.getUrl()=='https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf') {
			println('view_agreement_exclusion_pdf_url pdf links downloadable on Checkout_billing page')
		}else {
			println('view_agreement_exclusion_pdf_url pdf links are not downloadable on Checkout_billing Page')
		}

		WebUI.closeWindowIndex(1)

		WebUI.delay(1)

		WebUI.switchToWindowIndex(0)
	}
	def static void sixth_link_GMC() {
		//verify pdf is downloadable or not : link_06
		WebUI.click(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/View_Sample_Agreement'))

		WebUI.delay(2)
		WebUI.switchToWindowIndex(1)
		//view_agreement_exclusion_pdf_cartPage_review_url_GM='https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf'


		if(WebUI.getUrl()=='https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf') {
			println('view_agreement_exclusion_pdf_url pdf links downloadable on Checkout_review page')
		}else {
			println('view_agreement_exclusion_pdf_url pdf links are not downloadable on Checkout_review Page')
		}

		WebUI.closeWindowIndex(1)

		WebUI.delay(1)

		WebUI.switchToWindowIndex(0)


		//for download
	}
	//Vroom links//
	def static void VIEW_AGREEMENT_AND_EXCLUSIONS_link_vroom() {
		WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/a_View Agreement and Exclusions'))  // this will open a pdf
		WebUI.delay(2)
		WebUI.switchToWindowIndex(1)

		//public static view_agreement_exclusion_pdf_url_GMC = 'https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf'

		if(WebUI.getUrl()=='https://prismic-io.s3.amazonaws.com/sgidigital/d72661fb-e700-4a13-84ce-805fafdfd89c_VRVSCA-D2C_200918_Accessible_Sample.pdf') {
			println('view_agreement_exclusion_pdf_url pdf links downloadable')
		}else {
			println('view_agreement_exclusion_pdf_url pdf links are not downloadable')
		}
		WebUI.closeWindowIndex(1)
		WebUI.delay(1)
		WebUI.switchToWindowIndex(0)
	}
	//////////////
	def static void check_download_before_consent() {
		WebUI.click(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/PPA_pdf_link'))
		WebUI.switchToWindowIndex(0)

		//check on local path if this is downloaded or not
		WebUI.delay(5)

		def robot = new Robot()
		robot.keyPress(KeyEvent.VK_A)
		robot.keyPress(KeyEvent.VK_B)
		robot.keyRelease(KeyEvent.VK_ENTER)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		def path = 'C:/Users/enayem/Downloads'

		def fileName = 'ab.pdf'
		WebUI.delay(3)
		def file = new File(path, fileName)

		if (file.exists()) {
			println('Sample PDF file found!')
		} else {
			println('Sample PDF file not found.')
		}
		if (file.exists()) {
			file.delete()

			println('Sample PDF is deleted successfully')
		} else {
			println('File does not exist')
		}
	}
	////check Agreement value change
	def static void check_agreement_value_change() {
		//		pdf_statusCheck_reviewPage_afterConsent = WebUI.getText(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/View_Draft_Agreement'))
		//		println(pdf_statusCheck_reviewPage_afterConsent)

		if(WebUI.getText(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/View_Draft_Agreement')) == 'VIEW DRAFT AGREEMENT') {
			println('PDF status has been changed to Draft after consent')
		}else {
			println('PDF status has not been changed to Draft after consent')
		}
	}
	def static void check_download_afterConsent() {

		WebUI.delay(4)
		WebUI.scrollToPosition(50, 0)
		WebUI.click(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/PPA_pdf_link'))

		WebUI.delay(5)
		def robot = new Robot()
		robot.keyPress(KeyEvent.VK_A)
		robot.keyPress(KeyEvent.VK_B)
		robot.keyRelease(KeyEvent.VK_ENTER)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		def path = 'C:/Users/enayem/Downloads'

		def fileName = 'ab.pdf'
		WebUI.delay(3)
		def file = new File(path, fileName)
		WebUI.delay(2)
		if (file.exists()) {
			println('Draft agreement PDF file found!')
		} else {
			println('Draft agreement PDF file not found.')
		}
		if (file.exists()) {
			file.delete()

			println('Draft PDF is deleted successfully')
		} else {
			println('File does not exist')
		}
	}



}