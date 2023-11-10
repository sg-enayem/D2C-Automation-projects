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


public class db_binary_pdfCheck_Nissan {
	@Keyword
	public static Map<String, String> download_pdf_from_binary(){

		def pdfTextnew = ""
		def converterPDF = ""
		PDDocument document = PDDocument.load(new File("C:/Users/enayem/Downloads/output.pdf"))
		//Target ->Last_name =def rect = new Rectangle(55, 64, 60, 20)
		def page = document.getPage(0)
		
		
		// Target ->name
		def nameRect = new Rectangle(53, 180, 188, 30)
		def stripperByName = new PDFTextStripperByArea()
		stripperByName.addRegion("nameRegion", nameRect)
		stripperByName.extractRegions(page)
		pdfTextnew = stripperByName.getTextForRegion("nameRegion")
		
		Pattern namePattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
		Matcher nameMatcher = namePattern.matcher(pdfTextnew)
		
		converterPDF = pdfTextnew.trim()
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		println('Name: ' + converterPDF)
		def Name = converterPDF

		// Address
		def addressRect = new Rectangle(44,230, 466, 18)      // for deductible
		//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		def stripperByaddress = new PDFTextStripperByArea()
		stripperByaddress.addRegion("addressRegion", addressRect)
		stripperByaddress.extractRegions(page)
		pdfTextnew = stripperByaddress.getTextForRegion("addressRegion")
		
		Pattern addressPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
		Matcher addressMatcher = addressPattern.matcher(pdfTextnew)
		
		converterPDF = pdfTextnew.trim()
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		println('Address: ' + converterPDF)
		def address_pdf = converterPDF
		
		////*****
		//Language Prefferred
		def languageRect = new Rectangle(355, 268, 86, 18) // for Language
		def stripperBylanguage = new PDFTextStripperByArea()
		stripperBylanguage.addRegion("languageRegion", languageRect)
		stripperBylanguage.extractRegions(page)
		pdfTextnew = stripperBylanguage.getTextForRegion("languageRegion")
		
		Pattern languagePattern = Pattern.compile("\\b[A-Za-z\\s-]+\\b")
		Matcher languageMatcher = languagePattern.matcher(pdfTextnew)
		
		converterPDF = pdfTextnew.trim()
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		String language_fromPdf = ''
		println('Language: ' + converterPDF)
		def Language_pdf =converterPDF
		
		
		//Plan Details
		def plandetailsRect = new Rectangle(245, 328, 270, 20)
		//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		def stripperByplandetails = new PDFTextStripperByArea()
		stripperByplandetails.addRegion("plandetailsRegion", plandetailsRect)
		stripperByplandetails.extractRegions(page)
		pdfTextnew = stripperByplandetails.getTextForRegion("plandetailsRegion")
		
		Pattern plandetailsPattern = Pattern.compile("\\b[A-Za-z0-9-]+\\b.*")
		//Pattern plandetailsPattern = Pattern.compile("\\b\\p{Alpha}[A-Z0-9-]+\\b.*")
		Matcher plandetailsMatcher = plandetailsPattern.matcher(pdfTextnew)
		
		converterPDF = pdfTextnew.trim()
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		String plandetails_fromPdf = ''
		println('Plan Details: ' + converterPDF)
		def PlanDetails_pdf =converterPDF
		
		
		//Duration
		def durationRect = new Rectangle(365, 355, 50, 20)
		//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		def stripperByduration = new PDFTextStripperByArea()
		stripperByduration.addRegion("durationRegion", durationRect)
		stripperByduration.extractRegions(page)
		pdfTextnew = stripperByduration.getTextForRegion("durationRegion")
		
		Pattern durationPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
		Matcher durationMatcher = durationPattern.matcher(pdfTextnew)
		
		converterPDF = pdfTextnew.trim()
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		String duration_fromPdf = ''
		println('Duration: ' + converterPDF)
		def duration_pdf = converterPDF
		
		
		// Deductible
		def deductibleRect = new Rectangle(470, 355, 60, 20)      // for deductible
		//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		def stripperBydeductible = new PDFTextStripperByArea()
		stripperBydeductible.addRegion("deductibleRegion", deductibleRect)
		stripperBydeductible.extractRegions(page)
		pdfTextnew = stripperBydeductible.getTextForRegion("deductibleRegion")
		
		
		Pattern deductiblePattern = Pattern.compile("[\$]\\b+[0-9]+\\.+\\b.*")
		//Pattern deductiblePattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
		//Pattern deductiblePattern =Pattern.compile("[\$][0-9]\\.+[0-9]{2}")
		Matcher deductibleMatcher = deductiblePattern.matcher(pdfTextnew)
		
		converterPDF = pdfTextnew.trim()
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		String deductible_fromPdf = ''
		println('Deductible: ' + converterPDF)
		def Deductible_pdf =converterPDF
		
		//TARGET  -> ASP Price
		///Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		def aspPriceRect = new Rectangle(381, 520, 50, 18)
		def stripperByAspPrice = new PDFTextStripperByArea()
		stripperByAspPrice.addRegion("aspPriceRegion", aspPriceRect)
		stripperByAspPrice.extractRegions(page)
		pdfTextnew = stripperByAspPrice.getTextForRegion("aspPriceRegion")
		
		
		Pattern aspPricePattern = Pattern.compile("[\$]+\\b[A-Z0-9-]+\\b.*")
		//Pattern aspPricePattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
		Matcher aspPriceMatcher = aspPricePattern.matcher(pdfTextnew)
		
		converterPDF = pdfTextnew.trim()
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		String aspPrice_fromPdf = ''
		println('ASP Price:' + converterPDF)
		def ASP_pdf = converterPDF
		
		// Target-> GST/HST(if applicable)
		def GSTRect = new Rectangle(381, 535, 40, 18)   //// GST
		def stripperByGST = new PDFTextStripperByArea()
		stripperByGST.addRegion("GSTRegion", GSTRect)
		stripperByGST.extractRegions(page)
		pdfTextnew = stripperByGST.getTextForRegion("GSTRegion")
		
		
		Pattern GSTPattern = Pattern.compile("[\$]+\\b[A-Z0-9-]+\\b.*")
		//Pattern GSTPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
		Matcher GSTMatcher = GSTPattern.matcher(pdfTextnew)
		
		converterPDF = pdfTextnew.trim()
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		String GST_fromPdf = ''
		println('GST/HST Price:' + converterPDF)
		def GST_pdf = converterPDF
		
		
		//Target->Grand-Total
		def Grand_TotalRect = new Rectangle(381, 560, 40, 18)   // Grand total
		def stripperByGrand_Total = new PDFTextStripperByArea()
		stripperByGrand_Total.addRegion("Grand_TotalRegion", Grand_TotalRect)
		stripperByGrand_Total.extractRegions(page)
		pdfTextnew = stripperByGrand_Total.getTextForRegion("Grand_TotalRegion")
		
		
		Pattern Grand_TotalPattern = Pattern.compile("[\$]\\b[A-Z0-9-]+\\b.*")
		//Pattern Grand_TotalPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
		Matcher Grand_TotalMatcher = Grand_TotalPattern.matcher(pdfTextnew)
		
		converterPDF = pdfTextnew.trim()
		pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
		String Grand_Total_fromPdf = ''
		println('Grand Total:' + converterPDF)
		def Grand_total =converterPDF
		
		
		//////****
// VIN
def vinRect = new Rectangle(45, 443, 113, 19)
def stripperByVin = new PDFTextStripperByArea()
stripperByVin.addRegion("vinRegion", vinRect)
stripperByVin.extractRegions(page)
pdfTextnew = stripperByVin.getTextForRegion("vinRegion")

Pattern vinPattern = Pattern.compile("\\b[A-Za-z0-9-]+\\b.*")
Matcher vinMatcher = vinPattern.matcher(pdfTextnew)

converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String vin_fromPdf = ''
println('VIN: ' + converterPDF)
def vin_pdf= converterPDF

// Odometer Reading
def OdometerRect = new Rectangle(44, 500, 48, 18)
def stripperByOdometer = new PDFTextStripperByArea()
stripperByOdometer.addRegion("OdometerRegion", OdometerRect)
stripperByOdometer.extractRegions(page)
pdfTextnew = stripperByOdometer.getTextForRegion("OdometerRegion")

Pattern OdometerPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
Matcher OdometerMatcher = OdometerPattern.matcher(pdfTextnew)

converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
println('Odometer: ' + converterPDF)
def odometer_pdf = converterPDF

//Agreement Purchase Date
def agreementDateRect = new Rectangle(70, 700, 75, 13) /// agreement purchase date
def stripperByagreementDate = new PDFTextStripperByArea()
stripperByagreementDate.addRegion("agreementDateRegion", agreementDateRect)
stripperByagreementDate.extractRegions(page)
pdfTextnew = stripperByagreementDate.getTextForRegion("agreementDateRegion")

Pattern agreementDatePattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}") // Updated regex pattern for date format (e.g., 07/05/2023)
Matcher agreementDateMatcher = agreementDatePattern.matcher(pdfTextnew)

converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String agreementDate_fromPdf = ''
println('Agreement Date:' + converterPDF)
def agreementRetailRate= converterPDF

//Customer Signature
///Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def customerSignatureRect = new Rectangle(380, 700, 185, 13)
def stripperByCustomerSignature = new PDFTextStripperByArea()
stripperByCustomerSignature.addRegion("customerSignatureRegion", customerSignatureRect)
stripperByCustomerSignature.extractRegions(page)
pdfTextnew = stripperByCustomerSignature.getTextForRegion("customerSignatureRegion")
//Pattern customerSignaturePattern = Pattern.compile(".*\\b\\d{2}/\\d{2}/\\d{4}\\s+\\d{2}:\\d{2}\\s+[AP]M\\s+[A-Z]+\\b.*")
//Matcher customerSignatureMatcher = customerSignaturePattern.matcher(pdfTextnew)
//println('Customer Signature:' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
println('Customer Signature:' + converterPDF)
def CSign= converterPDF

//TARGET  -> Form Number
///Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def formNumberRect = new Rectangle(380, 770, 195, 13)
def stripperByFormNumber = new PDFTextStripperByArea()
stripperByFormNumber.addRegion("formNumberRegion", formNumberRect)
stripperByFormNumber.extractRegions(page)
pdfTextnew = stripperByFormNumber.getTextForRegion("formNumberRegion")
Pattern formNumberPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
Matcher formNumberMatcher = formNumberPattern.matcher(pdfTextnew)

converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
println('Form Number:' + converterPDF)
def formNumber = converterPDF




		//return new String[] {deductable_fromPdf, coverageTerm, expiration_date, agreementRetailRate, CSign,formNumber,firstName,lastName,vin_pdf};
		Map<String, String> results = new HashMap<>();
		results.put("Name", Name);
		results.put("address_pdf", address_pdf);
		results.put("vin_pdf", vin_pdf);
		results.put("odometer_pdf",odometer_pdf)
		results.put("Language_pdf", Language_pdf);
		results.put("PlanDetails_pdf", PlanDetails_pdf);
		results.put("duration_pdf", duration_pdf);
		results.put("Deductible_pdf", Deductible_pdf);
		results.put("ASP_pdf", ASP_pdf);
		results.put("GST_pdf", GST_pdf);
		results.put("Grand_total", Grand_total);
		results.put("agreementRetailRate", agreementRetailRate);
		results.put("CSign", CSign);
		results.put("formNumber", formNumber);
		


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
		String Name = results.get("Name")
		String address_pdf = results.get("address_pdf")
		String vin_pdf = results.get("vin_pdf")
		String odometer_pdf = results.get("odometer_pdf")
		String Language_pdf = results.get("Language_pdf")
		String PlanDetails_pdf = results.get("PlanDetails_pdf")
		String duration_pdf = results.get("duration_pdf")
		String Deductible_pdf = results.get("Deductible_pdf")
		String ASP_pdf = results.get("ASP_pdf")
		String GST_pdf = results.get("GST_pdf")
		String Grand_total = results.get("Grand_total")
		String agreementRetailRate = results.get("agreementRetailRate")
		String CSign = results.get("CSign")
		String formNumber = results.get("formNumber")
		


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
		//println(Deductible_pdf + deductible +" " +coverageTerm +' ' +termNumber + " " + " " + agreementRetailRate + ' ' + Trate + " " + firstName + first_Name + " " + lastName + last_Name)
		//println(Deductible_pdf + deductible  +coverageTerm +termNumber + agreementRetailRate + Trate + firstName + first_Name + lastName + last_Name)
		if(Deductible_pdf == deductible) {
			print 'deductable_fromPdf matched'
				if(agreementRetailRate == Trate) {
					print 'agreementRetailRate is matched'
					if(firstName == Name) {
						print 'first name is matched'
						if(lastName == Name) {

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
			print 'deductable not matched'
		}

		if(vin_pdf != '') {
			print('Vin is placed')
			if(formNumber != '') {
				print('form number is placed')
				if(CSign != '') {
					print('CSing is placed')
				}else {
					print('CSign is not placed')
				}
			}else {
				print('form number is not placed')
			}
		}else {
			print('vin is not placed')
		}

		//println(deductable_fromPdf + " "+ deductible +"| " +coverageTerm +" =" +termNumber+ "|" +expiration_date +"= " +resultDate + " |" + agreementRetailRate + "= " + Trate + "|" + firstName + "= " + first_Name + "| " + lastName + "= " + last_Name)
		if(vin_pdf != '' && formNumber != '' && CSign != '' &&  deductible == Deductible_pdf  &&   agreementRetailRate == Trate && firstName == Name && lastName == Name) {
			println(  "Deductible | Coverage Term | Agreement Rate |First name | Last name :: is matched with PDF & eSign , form number , Vin is placed in PDF ")
			pdf_check = "Deductible | Coverage Term | Agreement Rate | First name | Last name :: is matched with PDF & eSign , form number , Vin is placed in PDF "
			return pdf_check
		} else {
			println ( "Deductible | Coverage Term | Agreement Rate | First name | Last name :: is not matched with PDF & CSign , form number , Vin is placed in PDF")
			pdf_check = "Deductible | Coverage Term | Agreement Rate  |First name | Last name :: is not matched with PDF & CSign , form number , Vin is placed in PDF"
			return pdf_check
		}

		//		println(pdf_check)
	}
	//////
}

