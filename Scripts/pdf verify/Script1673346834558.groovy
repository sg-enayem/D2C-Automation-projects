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
import java.io.File as File
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

WebUI.openBrowser('')


WebUI.maximizeWindow()
WebUI.navigateToUrl('https://staging.mygmcprotection.com/checkout')

WebUI.setText(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Vehicle Service _04e2f2/input_VIN_vin'), 
    '3GTP9EEL4LG001229')

WebUI.setText(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Vehicle Service _04e2f2/input_Current Mileage_editVehicleOdometerVIN'), 
    '100')

WebUI.selectOptionByValue(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Vehicle Service _04e2f2/select_AlabamaAlaskaArizonaArkansasCaliforn_3be247'), 
    'FL', true)

WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Vehicle Service _04e2f2/span_Find My Price'))

WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/span_View Payment Options'))

//verify pdf is downloadable or not : link_01
WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/a_View Agreement and Exclusions'))  // this will open a pdf
WebUI.delay(2)
WebUI.switchToWindowIndex(1)

view_agreement_exclusion_pdf_url_GMC = 'https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf'

if(WebUI.getUrl()==view_agreement_exclusion_pdf_url) {
	println('view_agreement_exclusion_pdf_url pdf links downloadable')
}else {
	println('view_agreement_exclusion_pdf_url pdf links are not downloadable')
}
/////
WebUI.closeWindowIndex(1)

WebUI.delay(1)

WebUI.switchToWindowIndex(0)



//WebUI.sendKeys(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/a_View Agreement and Exclusions'), 
//    Keys.chord(Keys.ENTER))
//verify pdf is downloadable or not : link_02
WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/a_Payment Plan Agreement')) // will download pdf

WebUI.delay(2)
WebUI.switchToWindowIndex(1)

payment_plan_agreement_pdf='https://prismic-io.s3.amazonaws.com/sgidigital/0f760bd5-d4ea-4afb-9eaa-defe3f038820_PayLink+Direct+PPA+SAMPLE.pdf'


if(WebUI.getUrl()==payment_plan_agreement_pdf) {
	println('payment_plan_agreement_pdf url links downloadable')
}else {
	println('payment_plan_agreement_pdf url  pdf links are not downloadable')
}

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

WebUI.delay(1)

//verify pdf is downloadable or not : link_03
WebUI.click(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/accept_Payment_Plan_Agreement'))

WebUI.delay(2)
WebUI.switchToWindowIndex(1)

payment_plan_agreement_accept_pdf='https://prismic-io.s3.amazonaws.com/sgidigital/0f760bd5-d4ea-4afb-9eaa-defe3f038820_PayLink+Direct+PPA+SAMPLE.pdf'


if(WebUI.getUrl()==payment_plan_agreement_accept_pdf) {
	println('payment_plan_agreement_pdf_accept url links downloadable')
}else {
	println('payment_plan_agreement_pdf_accept url  pdf links are not downloadable')
}

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

WebUI.delay(1)
///////////////////////

WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/button_Checkout'))

WebUI.setText(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/input_First Name_firstName'), 
    'ab')

WebUI.setText(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/input_Last Name_lastName'),
	'fd')

WebUI.setText(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/input_Email Address_emailFormEmail'),
	'aa@gmail.com')

WebUI.setText(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/input_Confirm Your Email_emailFormConfirm'),
	'aa@gmail.com')

WebUI.setText(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/input_Phone Number_emailFormPhone'),
	'4111155455')

WebUI.setText(findTestObject('Object Repository/Vroom/input__Address'), '200 S State Rd 434,Altamonte Springs,Florida,32714')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Object Repository/Vroom/input__Address'), Keys.chord(Keys.ENTER))

//verify pdf is downloadable or not : link_04
WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/a_View Agreement and Exclusions_1'))
WebUI.delay(1)
view_agreement_exclusion_pdf_cartPage_contact_url = 'https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf'
WebUI.delay(1)
WebUI.switchToWindowIndex(1)

if(WebUI.getUrl()==view_agreement_exclusion_pdf_cartPage_contact_url) {
	println('view_agreement_exclusion_pdf_contact_url pdf links downloadable on Checkout page')
}else {
	println('view_agreement_exclusion_contact_pdf_url pdf links are not downloadable on Checkout Page')
}

WebUI.closeWindowIndex(1)

WebUI.delay(1)

WebUI.switchToWindowIndex(0)
/////////////////////////////////////
        WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Billing'))

        WebUI.click(findTestObject('Object Repository/Vroom/button_COMPLETE'))
		
		
//...Checkout page..///
		WebUI.setText(findTestObject('Object Repository/Vroom/input_Name On Card'), 'abab')
		
				WebUI.setText(findTestObject('Object Repository/Vroom/input_Card Number'), '4111111111111111')

				WebUI.selectOptionByLabel(findTestObject('Object Repository/Vroom/select_Month'), 'June', true)
		
				//	num, true)
				WebUI.selectOptionByValue(findTestObject('Object Repository/Vroom/select_Year'), '2028', true)
		
				//	expYear, true)
				WebUI.setText(findTestObject('Object Repository/Vroom/input_CVC'), '121')
		
//		...review page
				////verify pdf is downloadable or not : link_05

				WebUI.click(findTestObject('Object Repository/generatepdf/Page_GMC Protection Plan - Plans and Pricing/a_View Agreement and Exclusions_1'))
				view_agreement_exclusion_pdf_cartPage_billing_url = 'https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf'
				WebUI.delay(1)
				WebUI.switchToWindowIndex(1)
				
				if(WebUI.getUrl()==view_agreement_exclusion_pdf_cartPage_billing_url) {
					println('view_agreement_exclusion_pdf_url pdf links downloadable on Checkout_billing page')
				}else {
					println('view_agreement_exclusion_pdf_url pdf links are not downloadable on Checkout_billing Page')
				}
				
				WebUI.closeWindowIndex(1)
				
				WebUI.delay(1)
				
				WebUI.switchToWindowIndex(0)
				///////////////////////////
				WebUI.click(findTestObject('Object Repository/Vroom/label_Billing address check box'))
				
						//WebUI.delay(30)
				WebUI.click(findTestObject('Object Repository/Vroom/button_Continue to Review'))
				
				//final page
				
				pdf_statusCheck_reviewPage = WebUI.getText(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/View_Sample_Agreement'))
				println(pdf_statusCheck_reviewPage)
				////verify pdf is downloadable or not : link_06
				WebUI.click(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/View_Sample_Agreement'))

				WebUI.delay(2)
				WebUI.switchToWindowIndex(1)
				view_agreement_exclusion_pdf_cartPage_review_url_GM='https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf'
				
			
				if(WebUI.getUrl()==view_agreement_exclusion_pdf_cartPage_review_url_GM) {
					println('view_agreement_exclusion_pdf_url pdf links downloadable on Checkout_review page')
				}else {
					println('view_agreement_exclusion_pdf_url pdf links are not downloadable on Checkout_review Page')
				}
				
				WebUI.closeWindowIndex(1)
				
				WebUI.delay(1)
				
				WebUI.switchToWindowIndex(0)
				///////

				
				//for download
				////verify pdf is downloadable or not : link_07
				WebUI.click(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/PPA_pdf_link'))
				WebUI.switchToWindowIndex(0)
				
	//check on local path if this is downloaded or not
WebUI.delay(2)

def robot = new Robot()
robot.keyPress(KeyEvent.VK_A)
robot.keyPress(KeyEvent.VK_B)
//robot.keyRelease(KeyEvent.VK_ENTER)
robot.keyPress(KeyEvent.VK_ENTER)
robot.keyRelease(KeyEvent.VK_ENTER)
robot.keyPress(KeyEvent.VK_ENTER)
robot.keyRelease(KeyEvent.VK_ENTER)
def path = 'C:/Users/murahman/Downloads'

def fileName = 'ab.pdf'
WebUI.delay(2)
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

WebUI.click(findTestObject('Object Repository/Vroom/button_Terms_and_conditions'))

WebUI.click(findTestObject('Object Repository/Vroom/label_acceptAgreement'))

WebUI.click(findTestObject('Object Repository/Vroom/button_accept'))

WebUI.click(findTestObject('Object Repository/Vroom/label_accept'))

pdf_statusCheck_reviewPage_afterConsent = WebUI.getText(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/View_Draft_Agreement'))
println(pdf_statusCheck_reviewPage_afterConsent)
////check Agreement value change
if(pdf_statusCheck_reviewPage_afterConsent == 'VIEW DRAFT AGREEMENT') {
	println('PDF status has been changed to Draft after consent')
}
//WebUI.click(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/View_Draft_Agreement'))
//WebUI.switchToWindowIndex(1)
//WebUI.delay(2)
//url_check = WebUI.getUrl()
//println(url_check)
//
//
//
//println('checkpoint!!!!')
//
//view_agreement_exclusion_pdf_cartPage_review_url_afterConsentGM='about:blank'
//if(WebUI.getUrl()==view_agreement_exclusion_pdf_cartPage_review_url_afterConsentGM) {
//	println('view_draft_agreement_pdf_url  links downloadable on Checkout_review page')
//}else {
//	println('view_draft_agreement_pdf_url  links downloadable on Checkout_review page are not downloadable on Checkout_review Page')
//}
//
//WebUI.closeWindowIndex(1)
//
//WebUI.delay(1)
//
//WebUI.switchToWindowIndex(0)
//
////verify pdf is downloadable or not : link_08
WebUI.delay(4)
WebUI.scrollToPosition(50, 0)
WebUI.click(findTestObject('Object Repository/pdf verify objects/Page_GMC Protection Plan - Plans and Pricing/PPA_pdf_link'))

				
	//check on local path if this is downloaded or not
WebUI.delay(2)

//def robot = new Robot()
robot.keyPress(KeyEvent.VK_A)
robot.keyPress(KeyEvent.VK_B)
//robot.keyRelease(KeyEvent.VK_ENTER)
robot.keyPress(KeyEvent.VK_ENTER)
robot.keyRelease(KeyEvent.VK_ENTER)
robot.keyPress(KeyEvent.VK_ENTER)
robot.keyRelease(KeyEvent.VK_ENTER)
//def path = 'C:/Users/murahman/Downloads'

//def fileName = 'ab.pdf'
//WebUI.delay(2)
//def file = new File(path, fileName)
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



//https://prismic-io.s3.amazonaws.com/sgidigital-dev/046cf148-f4cd-45e1-917c-26bdb3d04e54_GMVSCD2C_220627_Sample.pdf


