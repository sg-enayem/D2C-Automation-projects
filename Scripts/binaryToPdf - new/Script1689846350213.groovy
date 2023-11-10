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
import java.io.IOException
import java.net.URL
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import java.io.BufferedReader
import java.io.FileReader

import java.util.regex.Matcher
import java.util.regex.Pattern

/*
orderSummaryId='d054f907-d977-4474-aab5-2c4ee19f5628'
PGDatabaseConnection a = new PGDatabaseConnection()
String str5 = ('select * from public.contract_pdf where order_summary_id=\'' + orderSummaryId) + '\''

rs = a.dataBaseConnection(str5, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser,
		GlobalVariable.pgPassword)
//pdf_data =rs.getString('data')
//println(pdf_data)
while (rs.next()) {
	pdf = rs.getString('data')
	println(pdf)

	WebUI.openBrowser('')

	WebUI.maximizeWindow()
	WebUI.navigateToUrl('https:portal.safe-guardproducts.com/public/generatepdf.php')
	WebUI.delay(2)
	/////////////////////////
	//					def writeToFile(text) {
	File file = new File("C:/Users/murahman/Downloads/output.txt")
	BufferedWriter writer = new BufferedWriter(new FileWriter(file))
	writer.write(rs.getString('data'))
	writer.close()
	//					}
	String filePath = "C:/Users/murahman/Downloads/output.txt"
	// Open the notepad file
	def notepad = new ProcessBuilder("notepad.exe", filePath).start()

	// Wait for the notepad file to open
	Thread.sleep(3000)

	// Use the Robot class to simulate keyboard events
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


//check pdf from urls
//					def url = new URL("https://portal.safe-guardproducts.com/public/generatepdf.php")
//					def connection = url.openConnection()
//					def inputStream = connection.getInputStream()
//					def document = PDDocument.load(inputStream)

**/
def pdfTextnew = ""
def converterPDF = ""
PDDocument document = PDDocument.load(new File("C:/Users/enayem/Downloads/output.pdf"))
def page = document.getPage(0)

// Target ->name
def nameRect = new Rectangle(53, 185, 188, 17)
def stripperByName = new PDFTextStripperByArea()
stripperByName.addRegion("nameRegion", nameRect)
stripperByName.extractRegions(page)
pdfTextnew = stripperByName.getTextForRegion("nameRegion")

Pattern namePattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
Matcher nameMatcher = namePattern.matcher(pdfTextnew)

println('Name: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String name_fromPdf = ''
if (nameMatcher.find()) {
	name_fromPdf = nameMatcher.group()
	println('Extracted Name: ' + name_fromPdf)
}
println()

// Address
def addressRect = new Rectangle(44,230, 466, 18)      // for deductible
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def stripperByaddress = new PDFTextStripperByArea()
stripperByaddress.addRegion("addressRegion", addressRect)
stripperByaddress.extractRegions(page)
pdfTextnew = stripperByaddress.getTextForRegion("addressRegion")

Pattern addressPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
Matcher addressMatcher = addressPattern.matcher(pdfTextnew)

println('Address: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String address_fromPdf = ''
if (addressMatcher.find()) {
	address_fromPdf = addressMatcher.group()
	println('Extracted Address: ' + address_fromPdf)
}
println()

// VIN
def vinRect = new Rectangle(45, 443, 113, 19)
def stripperByVin = new PDFTextStripperByArea()
stripperByVin.addRegion("vinRegion", vinRect)
stripperByVin.extractRegions(page)
pdfTextnew = stripperByVin.getTextForRegion("vinRegion")

Pattern vinPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
Matcher vinMatcher = vinPattern.matcher(pdfTextnew)

println('VIN: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String vin_fromPdf = ''
if (vinMatcher.find()) {
	vin_fromPdf = vinMatcher.group()
	println('Extracted VIN: ' + vin_fromPdf)
}
println()

// Odometer Reading
def OdometerRect = new Rectangle(44, 500, 48, 18)
def stripperByOdometer = new PDFTextStripperByArea()
stripperByOdometer.addRegion("OdometerRegion", OdometerRect)
stripperByOdometer.extractRegions(page)
pdfTextnew = stripperByOdometer.getTextForRegion("OdometerRegion")

Pattern OdometerPattern = Pattern.compile("\\d+")
Matcher OdometerMatcher = OdometerPattern.matcher(pdfTextnew)

println('Odometer: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String Odometer_fromPdf = ''
if (OdometerMatcher.find()) {
	Odometer_fromPdf = OdometerMatcher.group()
	println('Extracted Odometer: ' + Odometer_fromPdf)
}
println()

// LANGUAGE PREFERRED
def languageRect = new Rectangle(355,268, 86, 18)      // for Language
//def durationRect = new Rectangle(365, 335, 50, 40)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def stripperBylanguage = new PDFTextStripperByArea()
stripperBylanguage.addRegion("languageRegion", languageRect)
stripperBylanguage.extractRegions(page)
pdfTextnew = stripperBylanguage.getTextForRegion("languageRegion")

Pattern languagePattern = Pattern.compile("\\d+")
Matcher languageMatcher = languagePattern.matcher(pdfTextnew)

println('Language: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String language_fromPdf = ''
if (languageMatcher.find()) {
	address_fromPdf = languageMatcher.group()
	println('Extracted Language: ' + language_fromPdf)
}
println()

//Plan Details
def plandetailsRect = new Rectangle(245, 328, 175, 20)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def stripperByplandetails = new PDFTextStripperByArea()
stripperByplandetails.addRegion("plandetailsRegion", plandetailsRect)
stripperByplandetails.extractRegions(page)
pdfTextnew = stripperByplandetails.getTextForRegion("plandetailsRegion")

Pattern plandetailsPattern = Pattern.compile("\\d+")
Matcher plandetailsMatcher = plandetailsPattern.matcher(pdfTextnew)

println('Plan Details: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String plandetails_fromPdf = ''
if (plandetailsMatcher.find()) {
	plandetails_fromPdf = plandetailsMatcher.group()
	println('Extracted Plan Details: ' + plandetails_fromPdf)
}
println()


//Duration
def durationRect = new Rectangle(365, 335, 50, 40)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def stripperByduration = new PDFTextStripperByArea()
stripperByduration.addRegion("durationRegion", durationRect)
stripperByduration.extractRegions(page)
pdfTextnew = stripperByduration.getTextForRegion("durationRegion")

Pattern durationPattern = Pattern.compile("\\d+")
Matcher durationMatcher = durationPattern.matcher(pdfTextnew)

println('Duration: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String duration_fromPdf = ''
if (durationMatcher.find()) {
	duration_fromPdf = durationMatcher.group()
	println('Extracted Duration: ' + duration_fromPdf)
}
println()


// Deductible 
def deductibleRect = new Rectangle(470, 335, 60, 40)      // for deductible
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def stripperBydeductible = new PDFTextStripperByArea()
stripperBydeductible.addRegion("deductibleRegion", deductibleRect)
stripperBydeductible.extractRegions(page)
pdfTextnew = stripperBydeductible.getTextForRegion("deductibleRegion")

Pattern deductiblePattern = Pattern.compile("\\d+")
Matcher deductibleMatcher = deductiblePattern.matcher(pdfTextnew)

println('Deductible: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String deductible_fromPdf = ''
if (deductibleMatcher.find()) {
	deductible_fromPdf = deductibleMatcher.group()
	println('Extracted Deductible: ' + deductible_fromPdf)
}
println()

//TARGET  -> ASP Price
///Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def aspPriceRect = new Rectangle(381, 520, 50, 18)
def stripperByAspPrice = new PDFTextStripperByArea()
stripperByAspPrice.addRegion("aspPriceRegion", aspPriceRect)
stripperByAspPrice.extractRegions(page)
pdfTextnew = stripperByAspPrice.getTextForRegion("aspPriceRegion")

Pattern aspPricePattern = Pattern.compile("\\d+")
Matcher aspPriceMatcher = aspPricePattern.matcher(pdfTextnew)

println('ASP Price:' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String aspPrice_fromPdf = ''
if (aspPriceMatcher.find()) {
	aspPrice_fromPdf = aspPriceMatcher.group()
	println('Extracted ASP Price: ' + aspPrice_fromPdf)
}
println()

// Target-> GST/HST(if applicable)
def GSTRect = new Rectangle(381, 535, 40, 18)   //// GST
def stripperByGST = new PDFTextStripperByArea()
stripperByGST.addRegion("GSTRegion", GSTRect)
stripperByGST.extractRegions(page)
pdfTextnew = stripperByGST.getTextForRegion("GSTRegion")

Pattern GSTPattern = Pattern.compile("\\d+")
Matcher GSTMatcher = GSTPattern.matcher(pdfTextnew)

println('GST/HST Price:' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String GST_fromPdf = ''
if (GSTMatcher.find()) {
	GST_fromPdf = GSTMatcher.group()
	println('Extracted GST/HST Price: ' + aspPrice_fromPdf)
}
println()

//Target->Grand-Total
def Grand_TotalRect = new Rectangle(381, 560, 40, 18)   // Grand total
def stripperByGrand_Total = new PDFTextStripperByArea()
stripperByGrand_Total.addRegion("Grand_TotalRegion", Grand_TotalRect)
stripperByGrand_Total.extractRegions(page)
pdfTextnew = stripperByGrand_Total.getTextForRegion("Grand_TotalRegion")

Pattern Grand_TotalPattern = Pattern.compile("\\d+")
Matcher Grand_TotalMatcher = Grand_TotalPattern.matcher(pdfTextnew)

println(' Grand Total:' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String Grand_Total_fromPdf = ''
if (Grand_TotalMatcher.find()) {
	Grand_Total_fromPdf = Grand_TotalMatcher.group()
	println('Extracted Grand Total: ' + Grand_Total_fromPdf)
}
println()

//Agreement Purchase Date
def agreementDateRect = new Rectangle(70, 700, 75, 13) /// agreement purchase date
def stripperByagreementDate = new PDFTextStripperByArea()
stripperByagreementDate.addRegion("agreementDateRegion", agreementDateRect)
stripperByagreementDate.extractRegions(page)
pdfTextnew = stripperByagreementDate.getTextForRegion("agreementDateRegion")

Pattern agreementDatePattern = Pattern.compile("\\d+")
Matcher agreementDateMatcher = agreementDatePattern.matcher(pdfTextnew)

println('Agreement Date:' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String agreementDate_fromPdf = ''
if (agreementDateMatcher.find()) {
	agreementDate_fromPdf = agreementDateMatcher.group()
	println('Extracted ASP Price: ' + agreementDate_fromPdf)
}
println()

//Customer Signature
///Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def customerSignatureRect = new Rectangle(380, 700, 185, 13)
def stripperByCustomerSignature = new PDFTextStripperByArea()
stripperByCustomerSignature.addRegion("customerSignatureRegion", customerSignatureRect)
stripperByCustomerSignature.extractRegions(page)
pdfTextnew = stripperByCustomerSignature.getTextForRegion("customerSignatureRegion")
Pattern customerSignaturePattern = Pattern.compile("\\d+")
Matcher customerSignatureMatcher = customerSignaturePattern.matcher(pdfTextnew)
println('Customer Signature:' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String customerSignature_fromPdf = ''
if (customerSignatureMatcher.find()) {
	customerSignature_fromPdf = customerSignatureMatcher.group()
	println('Extracted Customer Signature: ' + customerSignature_fromPdf)
}
println()

//TARGET  -> Form Number
///Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def formNumberRect = new Rectangle(380, 770, 195, 13)
def stripperByFormNumber = new PDFTextStripperByArea()
stripperByFormNumber.addRegion("formNumberRegion", formNumberRect)
stripperByFormNumber.extractRegions(page)
pdfTextnew = stripperByFormNumber.getTextForRegion("formNumberRegion")
Pattern formNumberPattern = Pattern.compile("\\d+")
Matcher formNumberMatcher = formNumberPattern.matcher(pdfTextnew)
println('Form Number:' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String formNumber_fromPdf = ''
if (formNumberMatcher.find()) {
	formNumber_fromPdf = formNumberMatcher.group()
	println('Extracted Form Number: ' + formNumber_fromPdf)
}
println()

/*
def pdfTextnew = ""
def converterPDF = ""
PDDocument document = PDDocument.load(new File("C:/Users/enayem/Downloads/output.pdf"))
//Target ->Last_name =def rect = new Rectangle(55, 64, 60, 20)
def page = document.getPage(0)


//Nissan Contract Name
//name
def name = new Rectangle(53, 185, 188, 17)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def stripperByArea = new PDFTextStripperByArea()
stripperByArea.addRegion("region", name)
stripperByArea.extractRegions(page)
pdfTextnew = stripperByArea.getTextForRegion("region")
Pattern pattern = Pattern.compile("\\d+")
Matcher matcher = pattern.matcher(pdfTextnew);

println(' ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String name_fromPdf=''
if (matcher.find()) {
	name_fromPdf = matcher.group()
	System.out.println(name_fromPdf)
}
println(' '+name_fromPdf)



//VIN
def vin= new Rectangle(70, 620, 123, 19)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def stripperByArea = new PDFTextStripperByArea()
stripperByArea.addRegion("region", vin)
stripperByArea.extractRegions(page)
pdfTextnew = stripperByArea.getTextForRegion("region")
Pattern pattern = Pattern.compile("\\d+")
Matcher matcher = pattern.matcher(pdfTextnew);

println(' ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String vin_fromPdf=''
if (matcher.find()) {
	vin_fromPdf = matcher.group()
	System.out.println(vin_fromPdf)
}
println(' '+vin_fromPdf)
*/
//
/*
////checking first_name
def rect_firstName = new Rectangle(75, 248, 95, 40)
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
def rect_lastName = new Rectangle(164, 243, 193, 47)
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

*/
////checking Optional Lift Kit/Tire Modification Coverage
//def rect = new Rectangle(10, 468, 170, 10)
////Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
//stripperByArea.addRegion("region", rect)
//stripperByArea.extractRegions(page)
//pdfTextnew = stripperByArea.getTextForRegion("region")
//println('before convert : ' + pdfTextnew)
//converterPDF = pdfTextnew.trim()
////pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
//println('after convert : '+converterPDF)
////pdfTextnew = pdfTextnew.trim()
//
////✔
//if(converterPDF == "Optional Lift Kit/Tire Modification Coverage ✔") {
//	println("Text found")
//} else {
//	println("Optional Lift Kit/Tire Modification Coverage is not checked")
//}

////Optional Light Duty Commercial Use Coverage
//def rect = new Rectangle(10, 455, 170, 10)
////Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
//stripperByArea.addRegion("region", rect)
//stripperByArea.extractRegions(page)
//pdfTextnew = stripperByArea.getTextForRegion("region")
//println('before convert : ' + pdfTextnew)
//converterPDF = pdfTextnew.trim()
////pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
//println('after convert : '+converterPDF)
////pdfTextnew = pdfTextnew.trim()
//
////✔
//if(converterPDF == "Optional Light Duty Commercial Use Coverag ✔") {
//	println("Text found")
//} else {
//	println("Optional Light Duty Commercial Use Coverage is not checked")
//}

////Optional Canadian Grey Market Vehicle Coverage
//def rect = new Rectangle(10, 490, 200, 10)
////Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
//stripperByArea.addRegion("region", rect)
//stripperByArea.extractRegions(page)
//pdfTextnew = stripperByArea.getTextForRegion("region")
//println('before convert : ' + pdfTextnew)
//converterPDF = pdfTextnew.trim()
////pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
//println('after convert : '+converterPDF)
////pdfTextnew = pdfTextnew.trim()
//
////✔
//if(converterPDF == "Optional Canadian Grey Market Vehicle Coverage ✔") {
//	println("Text found")
//} else {
//	println("Optional Light Duty Commercial Use Coverage is not checked")
//}
/*
//deductable
def rect_deductable = new Rectangle(420, 470, 54, 10)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def stripperByArea = new PDFTextStripperByArea()
stripperByArea.addRegion("region", rect_deductable)
stripperByArea.extractRegions(page)
pdfTextnew = stripperByArea.getTextForRegion("region")
Pattern pattern = Pattern.compile("\\d+")
Matcher matcher = pattern.matcher(pdfTextnew);

println('before convert deductable: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
//pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String deductable_fromPdf=''
if (matcher.find()) {
	deductable_fromPdf = matcher.group()
	System.out.println(deductable_fromPdf)
}
println('after convert deductable: '+deductable_fromPdf)
//pdfTextnew = pdfTextnew.trim()


def str1 = converterPDF
def result1 = str1 =~ /\$(\d+)/
//println(result1[0][1])

//
//if(converterPDF == "deductable ::  ") {
//	println("Text found")
//} else {
//	println("deductable not matched")
//}

//Agreement coverage Term
def rect_agreement_coverage_term = new Rectangle(206, 465, 10, 20)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
stripperByArea.addRegion("region", rect_agreement_coverage_term)
stripperByArea.extractRegions(page)
pdfTextnew = stripperByArea.getTextForRegion("region")
println('before convert Agreement coverage term: ' + pdfTextnew)
converterPDF = pdfTextnew.replaceAll("_", "").trim();
//pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
println('after convert Agreement coverage term : '+converterPDF)
pdfTextnew = pdfTextnew.trim()

//					def str2 = converterPDF
//					def result2 = str2 =~ /\$(\d+)/
//					println(result2[0][1])


//if(converterPDF == "deductable ::  ") {
//	println("Text found")
//} else {
//	println("deductable not matched")
//}

//Agreement expiration date
//def rect_agreement_cexpiration_date = new Rectangle(395, 360, 100, 10)
////Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
////def stripperByArea = new PDFTextStripperByArea()
//stripperByArea.addRegion("region", rect_agreement_cexpiration_date)
//stripperByArea.extractRegions(page)
//pdfTextnew = stripperByArea.getTextForRegion("region")
//println('before convert Agreement expiration date: ' + pdfTextnew)
//converterPDF = pdfTextnew.trim()
//pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
//println('after convert Agreement expiration date : '+converterPDF)
//pdfTextnew = pdfTextnew.trim()


//Agreement retail rate
def rect_agreement_retail_price = new Rectangle(413, 482, 32, 9)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
stripperByArea.addRegion("region", rect_agreement_retail_price)
stripperByArea.extractRegions(page)
pdfTextnew = stripperByArea.getTextForRegion("region")
println('before convert Agreement retail rate: ' + pdfTextnew)
converterPDF = pdfTextnew.replaceAll("_", " ").trim();
//pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
println('after convert Agreement retail rate: '+converterPDF)

//esign
def rect_esign = new Rectangle(225, 700, 140, 30)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
stripperByArea.addRegion("region", rect_esign)
stripperByArea.extractRegions(page)
pdfTextnew = stripperByArea.getTextForRegion("region")
println('before convert : esign' + pdfTextnew)
converterPDF = pdfTextnew.replaceAll("_", " ").trim();
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
println('after convert : esign '+converterPDF)


////form number
def rect_formNumber = new Rectangle(33, 771, 120, 100)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
stripperByArea.addRegion("region", rect_formNumber)
stripperByArea.extractRegions(page)
pdfTextnew = stripperByArea.getTextForRegion("region")
println('before convert form number: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
println('after convert form number: '+converterPDF)

//
//if(converterPDF == "................. ") {
//	println("Text found")
//} else {
//	println("....................")
//}
//
////checking last name
rect_lastName = new Rectangle(85, 187, 90, 10)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
stripperByArea.addRegion("region", rect_lastName)
stripperByArea.extractRegions(page)
pdfTextnew = stripperByArea.getTextForRegion("region")
println('before convert lastName: ' + pdfTextnew)
converterPDF = pdfTextnew.replaceAll("[_\\s]+", " ").trim();
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
println('after convert lastName: '+converterPDF)
pdfTextnew = pdfTextnew.trim()
//last_name= 'TESTRAH'
//
//if(converterPDF == last_name) {
//	println("Last name is correct")
//} else {
//	println("Last name is not correct")
//}


////checking first_name
def rect_firstName = new Rectangle(320, 187, 85, 10)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
stripperByArea.addRegion("region", rect_firstName)
stripperByArea.extractRegions(page)
pdfTextnew = stripperByArea.getTextForRegion("region")
println('before convert first_name: ' + pdfTextnew)
converterPDF = pdfTextnew.replaceAll("[_\\s]+", " ").trim();
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
println('after convert first_name: '+converterPDF)


//

//checking vin number
def rect_vin = new Rectangle(170, 291, 100, 10)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
stripperByArea.addRegion("region", rect_vin)
stripperByArea.extractRegions(page)
pdfTextnew = stripperByArea.getTextForRegion("region")
println('before convert vin: ' + pdfTextnew)
converterPDF = pdfTextnew.replaceAll("[_\\s]+", " ").trim();
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
println('after convert vin: '+converterPDF)
//
//
//if(converterPDF == "3GTP9EEL4LG001184") {
//	println("Vin found")
//} else {
//	println("INVALID")
//}

//COVERAGE plan
//def rect = new Rectangle(28, 416, 204, 15)
////Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
//stripperByArea.addRegion("region", rect)
//stripperByArea.extractRegions(page)
//pdfTextnew = stripperByArea.getTextForRegion("region")
//println('before convert : ' + pdfTextnew)
//converterPDF = pdfTextnew.trim()
////pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
//println('after convert : '+converterPDF)
//

//if(converterPDF.contains("Powertrain ✔")) {
//	coverage_plan='Powertrain'
//} else if (converterPDF.contains("Silver ✔")){
//	coverage_plan='Silver'
//}else if (converterPDF.contains("Platinum ✔")) {
//	coverage_plan='Platinum'
//}
//
//
//println(coverage_plan)

//
//def rect = new Rectangle(28, 416, 204, 15)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
//stripperByArea.addRegion("region", rect)
//stripperByArea.extractRegions(page)
//pdfTextnew = stripperByArea.getTextForRegion("region")
//println('before convert : ' + pdfTextnew)
//converterPDF = pdfTextnew.trim()
//pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
//println('after convert : '+converterPDF)
//
//
//if(converterPDF.contains("Powertrain ✔")) {
//	coverage_plan='Powertrain'
//} else if (converterPDF.contains("Silver ✔")){
//	coverage_plan='Silver'
//}else if (converterPDF.contains("Platinum ✔")) {
//	coverage_plan='Platinum'
//}
//
//
//println(coverage_plan)

// uncomment if checking pdf for irls
//inputStream.close()

*/
document.close()




