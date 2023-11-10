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
import org.apache.pdfbox.pdmodel.PDDocument

 //check pdf from urls
//def url = new URL("https://portal.safe-guardproducts.com/public/generatepdf.php")
//def connection = url.openConnection()
//def inputStream = connection.getInputStream()
//def document = PDDocument.load(inputStream)

PDDocument document = PDDocument.load(new File("C:/Users/enayem/Downloads/output.pdf"))

def pdfTextnew = ""
def converterPDF = ""
//def pdf = PDDocument.load("C:/Users/murahman/Downloads/output.pdf")
//Target ->Last_name =def rect = new Rectangle(55, 64, 60, 20)
def page = document.getPage(0)



//deductable
//def rect = new Rectangle(5, 425, 200, 20)
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
//def str = converterPDF
//def result = str =~ /\$(\d+)/
//println(result[0][1])
//
//
//if(converterPDF == "deductable ::  ") {
//	println("Text found")
//} else {
//	println("deductable not matched")
//}

//Agreement coverage Term
//def rect_agreement_coverage_term = new Rectangle(95, 360, 100, 10)
////Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
////def stripperByArea = new PDFTextStripperByArea()
//stripperByArea.addRegion("region", rect_agreement_coverage_term)
//stripperByArea.extractRegions(page)
//pdfTextnew = stripperByArea.getTextForRegion("region")
//println('before convert ***********: ' + pdfTextnew)
//converterPDF = pdfTextnew.trim()
//pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
//println('after convert ************ : '+converterPDF)
//pdfTextnew = pdfTextnew.trim()

//def str = converterPDF
//def result = str =~ /\$(\d+)/
//println(result[0][1])


//if(converterPDF == "deductable ::  ") {
//	println("Text found")
//} else {
//	println("deductable not matched")
//}

//Agreement expiration date
//def rect_agreement_cexpiration_date = new Rectangle(395, 360, 100, 10) 
def rect_agreement_cexpiration_date = new Rectangle(55, 70, 170, 10)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def stripperByArea = new PDFTextStripperByArea()
stripperByArea.addRegion("region", rect_agreement_cexpiration_date)
stripperByArea.extractRegions(page)
pdfTextnew = stripperByArea.getTextForRegion("region")
println('before convert ***********: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
println('after convert ************ : '+pdfTextnew)
pdfTextnew = pdfTextnew.trim()

//Agreement retail rate
//def rect_agreement_retail_perice = new Rectangle(473, 416, 204, 15)
////Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
//stripperByArea.addRegion("region", rect_agreement_retail_perice)
//stripperByArea.extractRegions(page)
//pdfTextnew = stripperByArea.getTextForRegion("region")
//println('before convert : ' + pdfTextnew)
//converterPDF = pdfTextnew.trim()
//pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
//println('after convert : '+converterPDF)

//esign
//def rect_esign = new Rectangle(90, 711, 100, 10)
////Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
//def stripperByArea = new PDFTextStripperByArea()
//stripperByArea.addRegion("region", rect_esign)
//stripperByArea.extractRegions(page)
//pdfTextnew = stripperByArea.getTextForRegion("region")
//println('before convert : ' + pdfTextnew)
//converterPDF = pdfTextnew.trim()
//pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
//println('after convert : '+converterPDF)
//

////form number
//def rect = new Rectangle(3, 771, 120, 10)
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
//
//if(converterPDF == "................. ") {
//	println("Text found")
//} else {
//	println("....................")
//}
//
////checking last name
//rect_lastName = new Rectangle(55, 70, 170, 10)
////Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
////def stripperByArea = new PDFTextStripperByArea()
//stripperByArea.addRegion("region", rect_lastName)
//stripperByArea.extractRegions(page)
//pdfTextnew = stripperByArea.getTextForRegion("region")
//println('before convert : ' + pdfTextnew)
//converterPDF = pdfTextnew.trim()
//pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
//println('after convert : '+converterPDF)
//pdfTextnew = pdfTextnew.trim()
//last_name= 'TESTRAH'
////✔
//if(converterPDF == last_name) {
//	println("Last name is correct")
//} else {
//	println("Last name is not correct")
//}



////if(pdfTextnew.contains("Optional Lift Kit/Tire Modification Coverage ✔")) {
////	println("Text found")
////} else {
////	println("Text not found")
////}
////if(test == 'TESTRAH') {
////	println('success')
////}else {
////	println('unsuccess')
//}

////checking first_name
//def rect_firstName = new Rectangle(281, 73, 139, 10)
////Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
////def stripperByArea = new PDFTextStripperByArea()
//stripperByArea.addRegion("region", rect_firstName)
//stripperByArea.extractRegions(page)
//pdfTextnew = stripperByArea.getTextForRegion("region")
//println('before convert : ' + pdfTextnew)
//converterPDF = pdfTextnew.trim()
//pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
//println('after convert : '+converterPDF)
//
//
//if(converterPDF == "First Name MUNTASIRR") {
//	println("First name matched")
//} else {
//	println("INVALID")
//}

//

//checking vin number
//def rect_vin = new Rectangle(408, 201, 189, 10)
////Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
////def stripperByArea = new PDFTextStripperByArea()
//stripperByArea.addRegion("region", rect_vin)
//stripperByArea.extractRegions(page)
//pdfTextnew = stripperByArea.getTextForRegion("region")
//println('before convert : ' + pdfTextnew)
//converterPDF = pdfTextnew.trim()
//pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
//println('after convert : '+converterPDF)
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


document.close()

