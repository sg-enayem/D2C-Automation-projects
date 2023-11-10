package pdf_verification

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import org.apache.poi.ss.usermodel.*
import org.openqa.selenium.Keys as Keys
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import com.kms.katalon.core.logging.KeywordLogger
import java.io.File as File
import com.itextpdf.text.pdf.PdfReader
import com.itextpdf.text.pdf.parser.PdfTextExtractor
import org.apache.pdfbox.text.PDFTextStripperByArea
import org.apache.pdfbox.pdmodel.PDPage
import java.awt.Rectangle

import com.kms.katalon.core.util.KeywordUtil
import java.io.BufferedReader
import java.io.FileReader
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.time.LocalDate
import java.util.regex.Matcher
import java.util.regex.Pattern


public class db_binary_pdfCheck_vroom_VRED {
	@Keyword
	public static Map<String, String> download_pdf_from_binary(){

		def pdfTextnew = ""
		def converterPDF = ""
		PDDocument document = PDDocument.load(new File("C:/Users/enayem/Downloads/output.pdf"))
		//Target ->Last_name =def rect = new Rectangle(55, 64, 60, 20)
		def page = document.getPage(0)

		//deductable
		def rect_deductable = new Rectangle(420, 470, 54, 10)
		//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		def stripperByArea = new PDFTextStripperByArea()
		stripperByArea.addRegion("region", rect_deductable)
		stripperByArea.extractRegions(page)
		pdfTextnew = stripperByArea.getTextForRegion("region")
		Pattern pattern = Pattern.compile("\\d+")
		Matcher matcher = pattern.matcher(pdfTextnew);
		String deductable_fromPdf=''
		if (matcher.find()) {
			deductable_fromPdf = matcher.group()
		}
		println("In PDF, Deductable is :"+ deductable_fromPdf)
		//		def str1 = converterPDF
		//		def result1 = str1 =~ /\$(\d+)/
		//		def deductable_fromPdf = result1[0][1]
		//		println("In PDF, Deductable is :"+ deductable_fromPdf)

		//Agreement coverage Term
		def rect_agreement_coverage_term = new Rectangle(206, 465, 10, 20)
		//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		//def stripperByArea = new PDFTextStripperByArea()
		stripperByArea.addRegion("region", rect_agreement_coverage_term)
		stripperByArea.extractRegions(page)
		pdfTextnew = stripperByArea.getTextForRegion("region")
		//converterPDF = pdfTextnew.trim()
		converterPDF = pdfTextnew.replaceAll("_", "").trim();
		def coverageTerm = converterPDF
		//println(converterPDF)
		println("In PDF, Agreement coverage Term is :"+ converterPDF)
		//return coverageTerm
		//demoKey(coverageTerm)

		//Agreement expiration date
		def rect_agreement_cexpiration_date = new Rectangle(395, 360, 100, 10)
		//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		//def stripperByArea = new PDFTextStripperByArea()
		stripperByArea.addRegion("region", rect_agreement_cexpiration_date)
		stripperByArea.extractRegions(page)
		pdfTextnew = stripperByArea.getTextForRegion("region")
		//println('before convert Agreement expiration date: ' + pdfTextnew)
		converterPDF = pdfTextnew.trim()
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		//println(converterPDF)
		def expiration_date = converterPDF
		println("In PDF, Agreement expiration date is :"+ expiration_date)
		//return expiration_date
		//demoKey(expiration_date)
		//pdfTextnew = pdfTextnew.trim()

		//Agreement retail rate
		def rect_agreement_retail_price = new Rectangle(413, 482, 32, 9)
		//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		//def stripperByArea = new PDFTextStripperByArea()
		stripperByArea.addRegion("region", rect_agreement_retail_price)
		stripperByArea.extractRegions(page)
		pdfTextnew = stripperByArea.getTextForRegion("region")
		//println('before convert Agreement retail rate: ' + pdfTextnew)
		converterPDF = pdfTextnew.replaceAll("_", " ").trim();
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		//	println(converterPDF)
		println("In PDF, Agreement retail rate is :"+ converterPDF)
		def agreementRetailRate = converterPDF
		//return agreementRetailRate

		//esign " need to check its not empty
		def rect_esign = new Rectangle(225, 700, 140, 30)
		//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		//def stripperByArea = new PDFTextStripperByArea()
		stripperByArea.addRegion("region", rect_esign)
		stripperByArea.extractRegions(page)
		pdfTextnew = stripperByArea.getTextForRegion("region")
		//println('before convert : esign' + pdfTextnew)
		converterPDF = pdfTextnew.replaceAll("_", " ").trim();
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		println("In PDF, Esign is : "+converterPDF)
		def esign = converterPDF
		//return esign

		////form number
		def rect_formNumber = new Rectangle(33, 771, 120, 100)
		//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		//def stripperByArea = new PDFTextStripperByArea()
		stripperByArea.addRegion("region", rect_formNumber)
		stripperByArea.extractRegions(page)
		pdfTextnew = stripperByArea.getTextForRegion("region")
		//println('before convert form number: ' + pdfTextnew)
		converterPDF = pdfTextnew.trim()
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		println("In PDF, form number is : "+converterPDF)
		def formNumber = converterPDF
		//return formNumber

		////checking first_name
		def rect_firstName = new Rectangle(85, 187, 90, 10)
		//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		//def stripperByArea = new PDFTextStripperByArea()
		stripperByArea.addRegion("region", rect_firstName)
		stripperByArea.extractRegions(page)
		pdfTextnew = stripperByArea.getTextForRegion("region")
		//println('before convert first_name: ' + pdfTextnew)
		converterPDF = pdfTextnew.replaceAll("[_\\s]+", " ").trim();
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		println("In PDF, First Name is : " +converterPDF)
		def first_Name = converterPDF
		//return firstName


		//checking Last name
		def rect_lastName =new Rectangle(320, 187, 85, 10)
		stripperByArea.addRegion("region", rect_lastName)
		stripperByArea.extractRegions(page)
		pdfTextnew = stripperByArea.getTextForRegion("region")
		//println('before convert last name: ' + pdfTextnew)
		converterPDF = pdfTextnew.replaceAll("[_\\s]+", " ").trim();
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		println("In PDF, Last Name is : " +converterPDF)
		pdfTextnew = pdfTextnew.trim()
		def last_Name = converterPDF
		//return lastName

		//checking vin number
		def rect_vin = new Rectangle(170, 291, 100, 10)
		//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		//def stripperByArea = new PDFTextStripperByArea()
		stripperByArea.addRegion("region", rect_vin)
		stripperByArea.extractRegions(page)
		pdfTextnew = stripperByArea.getTextForRegion("region")
		//println('before convert vin: ' + pdfTextnew)
		converterPDF = pdfTextnew.replaceAll("[_\\s]+", " ").trim();
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		println("In PDF, Vin number is : " +converterPDF)
		def vin_pdf = converterPDF
		//return vin

		//return new String[] {deductable_fromPdf, coverageTerm, expiration_date, agreementRetailRate, esign,formNumber,firstName,lastName,vin_pdf};
		Map<String, String> results = new HashMap<>();
		results.put("deductable_fromPdf", deductable_fromPdf);
		results.put("coverageTerm", coverageTerm);
		results.put("expiration_date", expiration_date);
		results.put("agreementRetailRate", agreementRetailRate);
		results.put("esign", esign);
		results.put("formNumber", formNumber);
		results.put("first_Name", first_Name);
		results.put("last_Name", last_Name);
		results.put("vin_pdf", vin_pdf);


		// add other results as needed
		return results;
		document.close()
	}
	@Keyword
	def static void Robot_key_press() {
		def robot = new Robot()

		// Press the Ctrl + A keys to select all the text in the notepad file
		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyPress(KeyEvent.VK_A)
		robot.keyRelease(KeyEvent.VK_A)
		robot.keyRelease(KeyEvent.VK_CONTROL)

		// Press the Ctrl + C keys to copy the selected text
		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyPress(KeyEvent.VK_C)
		robot.keyRelease(KeyEvent.VK_C)
		robot.keyRelease(KeyEvent.VK_CONTROL)

		// Close the notepad file
		robot.keyPress(KeyEvent.VK_ALT)
		robot.keyPress(KeyEvent.VK_F4)
		robot.keyRelease(KeyEvent.VK_F4)
		robot.keyRelease(KeyEvent.VK_ALT)

		// Wait for the notepad file to close
		Thread.sleep(3000)

		// Switch to the web browser and paste the copied text into the web textbox
		WebUI.setText(findTestObject('Object Repository/generatepdf/input_textArea'), '')
		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyPress(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_CONTROL)
		WebUI.click(findTestObject('Object Repository/generatepdf/input_button'))
		WebUI.delay(12)

		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyPress(KeyEvent.VK_S)
		robot.keyRelease(KeyEvent.VK_CONTROL)
		robot.keyRelease(KeyEvent.VK_S)
		WebUI.delay(2)

		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
	}

	//////
	@Keyword
	def static verifyPdf(Map<String, String> results, String deductible, String termLength, String subtotal, String firstName, String lastName) {
		String deductable_fromPdf = results.get("deductable_fromPdf")
		String coverageTerm = results.get("coverageTerm")
		String expiration_date = results.get("expiration_date")
		String agreementRetailRate = results.get("agreementRetailRate")
		String esign = results.get("esign")
		String formNumber = results.get("formNumber")
		String first_Name = results.get("first_Name")
		String last_Name = results.get("last_Name")
		String vin_pdf = results.get("vin_pdf")


		// ready data for checking
		def regex = /\d+/
		def match = (termLength =~ regex)[0]
		def number = match[0].toInteger() // this number also affects the result year
		def termNumber = (number * 12).toString()  // from this we are getting termNumber

		def Trate = subtotal.replaceAll('[\\$,]', "");
		println(Trate)
		def currentDate = LocalDate.now()
		def dateFormat = "dd/MM/yyyy"
		def formattedDate = currentDate.format(java.time.format.DateTimeFormatter.ofPattern(dateFormat))
		def regex1 = /\d{2}\/\d{2}\/(\d{4})/
		def match1 = (formattedDate =~ regex1)[0]
		def year = match1[1].toInteger()

		def resultYear = year + number

		def resultDate = formattedDate.replaceAll(/\d{4}$/, resultYear.toString()) // from this we are getting the

		String pdf_check = ""
		println(deductable_fromPdf + deductible +" " +coverageTerm +' ' +termNumber + " " + " " + agreementRetailRate + ' ' + Trate + " " + firstName + first_Name + " " + lastName + last_Name)
		println(deductable_fromPdf + deductible  +coverageTerm +termNumber + agreementRetailRate + Trate + firstName + first_Name + lastName + last_Name)
		if(deductable_fromPdf == deductible) {
			print 'deductable_fromPdf matched'
			if(coverageTerm == termNumber) {
				print 'coverageTerm is matched'
				if(agreementRetailRate == Trate) {
					print 'agreementRetailRate is matched'
					if(firstName == first_Name) {
						print 'first name is matched'
						if(lastName == last_Name) {

							print 'last name matched'
						}else {
							print 'last name not matched'
						}
					}else {
						print 'first name is not matched'
					}
				}else {
					print 'agreementRetailRate not matched'
				}
			}else {
				print 'coverageTerm not matched'
			}
		}else {
			print 'deductable not matched'
		}

		if(vin_pdf != '') {
			print('Vin is placed')
			if(formNumber != '') {
				print('form number is placed')
				if(esign != '') {
					print('esing is placed')
				}else {
					print('esign is not placed')
				}
			}else {
				print('form number is not placed')
			}
		}else {
			print('vin is not placed')
		}


		//println(deductable_fromPdf + " "+ deductible +"| " +coverageTerm +" =" +termNumber+ "|" +expiration_date +"= " +resultDate + " |" + agreementRetailRate + "= " + Trate + "|" + firstName + "= " + first_Name + "| " + lastName + "= " + last_Name)
		if(vin_pdf != '' && formNumber != '' && esign != '' &&  deductible == deductable_fromPdf == deductible && coverageTerm == termNumber && agreementRetailRate == Trate && firstName == first_Name && lastName == last_Name) {
			println(  "Deductible | Coverage Term | Agreement Rate |First name | Last name :: is matched with PDF & eSign , form number , Vin is placed in PDF ")
			pdf_check = "Deductible | Coverage Term | Agreement Rate | First name | Last name :: is matched with PDF & eSign , form number , Vin is placed in PDF "
			return pdf_check
		} else {
			println ( "Deductible | Coverage Term | Agreement Rate | First name | Last name :: is not matched with PDF & eSign , form number , Vin is placed in PDF")
			pdf_check = "Deductible | Coverage Term | Agreement Rate  |First name | Last name :: is not matched with PDF & eSign , form number , Vin is placed in PDF"
			return pdf_check
		}

		//		println(pdf_check)
	}
	//////
}

