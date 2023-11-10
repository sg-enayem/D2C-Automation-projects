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

def pdfTextnew = ""
def converterPDF = ""
PDDocument document = PDDocument.load(new File("C:/Users/enayem/Downloads/Coverage Agreement (28).pdf"))
def page = document.getPage(0)

// Target ->name
def nameRect = new Rectangle(53, 180, 188, 30)
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

Pattern vinPattern = Pattern.compile("\\b[A-Za-z0-9-]+\\b.*")
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

Pattern OdometerPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
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

//Language Prefferred
def languageRect = new Rectangle(355, 268, 86, 18) // for Language
def stripperBylanguage = new PDFTextStripperByArea()
stripperBylanguage.addRegion("languageRegion", languageRect)
stripperBylanguage.extractRegions(page)
pdfTextnew = stripperBylanguage.getTextForRegion("languageRegion")

Pattern languagePattern = Pattern.compile("\\b[A-Za-z\\s-]+\\b")
Matcher languageMatcher = languagePattern.matcher(pdfTextnew)

println('Language: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String language_fromPdf = ''
if (languageMatcher.find()) {
	language_fromPdf = languageMatcher.group()
	println('Extracted Language: ' + language_fromPdf)
}
println()


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
def durationRect = new Rectangle(365, 355, 50, 20)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def stripperByduration = new PDFTextStripperByArea()
stripperByduration.addRegion("durationRegion", durationRect)
stripperByduration.extractRegions(page)
pdfTextnew = stripperByduration.getTextForRegion("durationRegion")

Pattern durationPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
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


Pattern aspPricePattern = Pattern.compile("[\$]+\\b[A-Z0-9-]+\\b.*")
//Pattern aspPricePattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
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


Pattern GSTPattern = Pattern.compile("[\$]+\\b[A-Z0-9-]+\\b.*")
//Pattern GSTPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
Matcher GSTMatcher = GSTPattern.matcher(pdfTextnew)

println('GST/HST Price:' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String GST_fromPdf = ''
if (GSTMatcher.find()) {
	GST_fromPdf = GSTMatcher.group()
	println('Extracted GST/HST Price: ' + GST_fromPdf)
}
println()


//Target->Grand-Total
def Grand_TotalRect = new Rectangle(381, 560, 40, 18)   // Grand total
def stripperByGrand_Total = new PDFTextStripperByArea()
stripperByGrand_Total.addRegion("Grand_TotalRegion", Grand_TotalRect)
stripperByGrand_Total.extractRegions(page)
pdfTextnew = stripperByGrand_Total.getTextForRegion("Grand_TotalRegion")


Pattern Grand_TotalPattern = Pattern.compile("[\$]\\b[A-Z0-9-]+\\b.*")
//Pattern Grand_TotalPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
Matcher Grand_TotalMatcher = Grand_TotalPattern.matcher(pdfTextnew)

println('Grand Total:' + pdfTextnew)
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

Pattern agreementDatePattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}") // Updated regex pattern for date format (e.g., 07/05/2023)
Matcher agreementDateMatcher = agreementDatePattern.matcher(pdfTextnew)

println('Agreement Date:' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String agreementDate_fromPdf = ''
if (agreementDateMatcher.find()) {
	agreementDate_fromPdf = agreementDateMatcher.group()
	println('Extracted Agreement Date: ' + agreementDate_fromPdf)
}
println()

//Customer Signature
///Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def customerSignatureRect = new Rectangle(380, 700, 185, 13)
def stripperByCustomerSignature = new PDFTextStripperByArea()
stripperByCustomerSignature.addRegion("customerSignatureRegion", customerSignatureRect)
stripperByCustomerSignature.extractRegions(page)
pdfTextnew = stripperByCustomerSignature.getTextForRegion("customerSignatureRegion")


Pattern customerSignaturePattern = Pattern.compile(".*\\b\\d{2}/\\d{2}/\\d{4}\\s+\\d{2}:\\d{2}\\s+[AP]M\\s+[A-Z]+\\b.*")
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
Pattern formNumberPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
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



document.close()


