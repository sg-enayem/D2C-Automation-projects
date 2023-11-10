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

//def pdfTextnew = ""
//def converterPDF = ""
//PDDocument document = PDDocument.load(new File("C:/Users/enayem/Downloads/GMCPDF.pdf"))
//def page = document.getPage(0)




import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper

def pdfText = ""

// Directory containing PDF files
def pdfDirectoryPath = "C:/Users/enayem/Downloads/New folder/SchompPDF"


def pageNumberToExtract = 0

// Get all PDF files in the specified directory
def pdfFiles = new File(pdfDirectoryPath).listFiles().findAll { file ->
    file.isFile() && file.getName().toLowerCase().endsWith(".pdf")
}

// Iterate through each PDF file in the directory
pdfFiles.each { pdfFile ->
    try {
        
        PDDocument document = PDDocument.load(pdfFile)
        
        // Create a PDFTextStripper object
        PDFTextStripper pdfTextStripper = new PDFTextStripper()
        
       
        def page = document.getPage(pageNumberToExtract)
        
        
        // Target ->PHONE
def phonenoRect = new Rectangle(450, 310, 60, 15) 
//def phonenoRect = new Rectangle(460, 205, 105, 20)  //gmcDRAFT
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def stripperByPhoneno = new PDFTextStripperByArea()
stripperByPhoneno.addRegion("phonenoRegion", phonenoRect)
stripperByPhoneno.extractRegions(page)
pdfTextnew = stripperByPhoneno.getTextForRegion("phonenoRegion")

 

//Pattern phonenoPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
// Updated regular expression pattern to include parentheses
Pattern phonenoPattern = Pattern.compile("\\(\\b[0-9-]+\\b\\).*")
Matcher phonenoMatcher = phonenoPattern.matcher(pdfTextnew)

 

println('Phoneno: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String phoneno_fromPdf = ''
if (phonenoMatcher.find()) {
	phoneno_fromPdf = phonenoMatcher.group()
	println('Extracted Phoneno: ' + phoneno_fromPdf)
}
println()
WebUI.delay(2)
// String actual_phoneNumber = (833) 954-0085
 if(phoneno_fromPdf == actual_phoneNumber)
 {
	 println("Dealer contact number matched with pdf")
 }
 else {println("Dealer contact number doesnot matched with pdf")}


 /*

// Target ->name
def nameRect = new Rectangle(80, 280, 50, 20)
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

def addressRect = new Rectangle(105, 300, 145, 10)

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

 

// Target ->City
def cityRect = new Rectangle(70, 310, 30, 10)
def stripperByCity = new PDFTextStripperByArea()
stripperByCity.addRegion("cityRegion", cityRect)
stripperByCity.extractRegions(page)
pdfTextnew = stripperByCity.getTextForRegion("cityRegion")

 

Pattern cityPattern = Pattern.compile("\\b[A-Za-z0-9-]+\\b.*")
Matcher cityMatcher = cityPattern.matcher(pdfTextnew)

 

println('City: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String city_fromPdf = ''
if (cityMatcher.find()) {
	city_fromPdf = cityMatcher.group()
	println('Extracted city: ' + city_fromPdf)
}
println()

 

// State
def stateRect = new Rectangle(260, 310, 30, 10)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def stripperBystate = new PDFTextStripperByArea()
stripperBystate.addRegion("stateRegion", stateRect)
stripperBystate.extractRegions(page)
pdfTextnew = stripperBystate.getTextForRegion("stateRegion")

 

Pattern statePattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
Matcher stateMatcher = statePattern.matcher(pdfTextnew)

 

println('state: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String state_fromPdf = ''
if (stateMatcher.find()) {
	state_fromPdf = stateMatcher.group()
	println('Extracted state: ' + state_fromPdf)
}
println()

 

 

// ZipCode
def zipCodeRect = new Rectangle(330, 310, 60, 10)
//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
def stripperByzipCode = new PDFTextStripperByArea()
stripperByzipCode.addRegion("zipCodeRegion", zipCodeRect)
stripperByzipCode.extractRegions(page)
pdfTextnew = stripperByzipCode.getTextForRegion("zipCodeRegion")

 

Pattern zipCodePattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
Matcher zipCodeMatcher = zipCodePattern.matcher(pdfTextnew)

 

println('Zip Code: ' + pdfTextnew)
converterPDF = pdfTextnew.trim()
pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
String zipCode_fromPdf = ''
if (zipCodeMatcher.find()) {
	zipCode_fromPdf = zipCodeMatcher.group()
	println('Extracted Zip Code: ' + zipCode_fromPdf)
}
println()
 

*/       
        // Close the document
        document.close()
    } catch (Exception e) {
        // Handle exceptions if needed
        e.printStackTrace()
    }
}

// The variable pdfText now contains the text from the specified page of all PDF files in the directory
println(pdfText)




//// Target ->PhoneNo
//def phoneNoRect = new Rectangle(460, 250, 90, 20)
//def stripperByName = new PDFTextStripperByArea()
//stripperByName.addRegion("phoneNoRegion", phoneNoRect)
//stripperByName.extractRegions(page)
//pdfTextnew = stripperByName.getTextForRegion("phoneNoRegion")
//
//Pattern phoneNoPattern = Pattern.compile("\\b[A-Z0-9-]+\\b.*")
//Matcher phoneNoMatcher = phoneNoPattern.matcher(pdfTextnew)
//
//println('PhoneNo: ' + pdfTextnew)
//converterPDF = pdfTextnew.trim()
//pdfTextnew = pdfTextnew.replaceAll("\\s+", " ")
//String phoneNo_fromPdf = ''
//if (phoneNoMatcher.find()) {
//	phoneNo_fromPdf = phoneNoMatcher.group()
//	println('Extracted PhoneNo: ' + phoneNo_fromPdf)
//}
//println()
//
//
//document.close()


