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


/*
def pdfText = ""

// Directory containing PDF files
def pdfDirectoryPath = "C:/Users/enayem/Downloads/PdfVeirification/GM_pdf"

// Page number to extract v
def pageNumberToExtract = 0

// Get all PDF files in the specified directory
def pdfFiles = new File(pdfDirectoryPath).listFiles().findAll { file ->
    file.isFile() && file.getName().toLowerCase().endsWith(".pdf")
}

// Iterate through each PDF file in the directory
pdfFiles.each { pdfFile ->
    try {
     
        PDDocument document = PDDocument.load(pdfFile)
		
		int totalPages = document.getNumberOfPages()
        
        // Create a PDFTextStripper object
        PDFTextStripper pdfTextStripper = new PDFTextStripper()
        
        // Get the specified page
        def page = document.getPage(pageNumberToExtract)
        
        
// Target ->PHONE
def phonenoRect = new Rectangle(465, 205, 90, 20) //For cadillacMAIN pdf
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
pdfTextnew = pdfTextnew.replaceAll('\\s+', " ")
String phoneno_fromPdf = ''
if (phonenoMatcher.find()) {
	phoneno_fromPdf = phonenoMatcher.group()
	println('Extracted Phoneno: ' + phoneno_fromPdf)
}
println()

WebUI.delay(2)

//Buick: (833) 955-0045
//Cadillac: (833) 955-0046
//Chevrolet: (833) 955-0044
//GMC:(833) 955-0047
// String actual_phoneNumber = (833) 954-0085
if(phoneno_fromPdf == Buick_phoneNumber && phoneno_fromPdf == GMC_phoneNumber && phoneno_fromPdf == Cadillac_phoneNumber && phoneno_fromPdf == Chevy_phoneNumber)
 //if(phoneno_fromPdf == actual_phoneNumber)
 {
	 println("Dealer contact number matched with pdf")
 }
 else {println("Dealer contact number doesnot matched with pdf")}


        document.close()
		
		println("Total number of pages: $totalPages")
    } catch (Exception e) {
        // Handle exceptions if needed
        e.printStackTrace()
    }
}

// The variable pdfText now contains the text from the specified page of all PDF files in the directory
println(pdfText)

*/
//2nd logic building
/*
def pdfText = ""

// Directory containing PDF files
def pdfDirectoryPath = "C:/Users/enayem/Downloads/PdfVeirification/GM_pdf"

// Page number to extract
def pageNumberToExtract = 0

// Define the expected phone numbers for different dealers
def expectedPhoneNumbers = [
	"Buick": "(833) 955-0045",
	"Cadillac": "(833) 955-0046",
	"Chevrolet": "(833) 955-0044",
	"GMC": "(833) 955-0047"
]

// Get all PDF files in the specified directory
def pdfFiles = new File(pdfDirectoryPath).listFiles().findAll { file ->
	file.isFile() && file.getName().toLowerCase().endsWith(".pdf")
}

// Iterate through each PDF file in the directory
pdfFiles.each { pdfFile ->
	try {
		PDDocument document = PDDocument.load(pdfFile)
		int totalPages = document.getNumberOfPages()
		def page = document.getPage(pageNumberToExtract)

		// Extract the phone number as you did in your code
		def phonenoRect = new Rectangle(465, 205, 90, 20)
		def stripperByPhoneno = new PDFTextStripperByArea()
		stripperByPhoneno.addRegion("phonenoRegion", phonenoRect)
		stripperByPhoneno.extractRegions(page)
		pdfTextnew = stripperByPhoneno.getTextForRegion("phonenoRegion")

		Pattern phonenoPattern = Pattern.compile("\\(\\b[0-9-]+\\b\\).*")
		Matcher phonenoMatcher = phonenoPattern.matcher(pdfTextnew)
		
		converterPDF = pdfTextnew.trim()
		pdfTextnew = pdfTextnew.replaceAll('\\s+', " ")
		String phoneno_fromPdf = ''
		if (phonenoMatcher.find()) {
			phoneno_fromPdf = phonenoMatcher.group()
			println('Extracted Phoneno: ' + phoneno_fromPdf)
		}
		
		// Check if the extracted phone number matches any expected phone numbers
		def matchedDealer = null
		for (entry in expectedPhoneNumbers.entrySet()) {
			def dealer = entry.key
			def phoneNumber = entry.value
			if (phoneno_fromPdf == phoneNumber) {
				matchedDealer = dealer
				break
			}
		}
		
		if (matchedDealer != null) {
			println("Dealer contact number matched with PDF for $matchedDealer")
		} else {
			println("Dealer contact number does not match with PDF")
		}

		document.close()
		println("Total number of pages: $totalPages")
	} catch (Exception e) {
		// Handle exceptions if needed
		e.printStackTrace()
	}
}

// The variable pdfText now contains the text from the specified page of all PDF files in the directory
println(pdfText)
*/

//3rd logic building

def pdfText = ""

def pdfDirectoryPath = "C:/Users/enayem/Downloads/PdfVeirification/GM_pdf"

def pageNumberToExtract = 0

def expectedPhoneNumbers = [
	"Buick": "(833) 955-0045",
	"Cadillac": "(833) 955-0046",
	"Chevrolet": "(833) 955-0044",
	"GMC": "(833) 955-0047"
]

// Get all PDF files in the specified directory
def pdfFiles = new File(pdfDirectoryPath).listFiles().findAll { file ->
	file.isFile() && file.getName().toLowerCase().endsWith(".pdf")
}

// Function to clean and format the phone number
def cleanAndFormatPhoneNumber(phoneNumber) {
	
	def cleanedNumber = phoneNumber.replaceAll("\\D", "") // Remove all non-digit characters
	
	return "(${cleanedNumber.substring(0, 3)}) ${cleanedNumber.substring(3, 6)}-${cleanedNumber.substring(6)}" // Add parentheses and hyphens to match the expected format
}


pdfFiles.each { pdfFile ->
	try {
		PDDocument document = PDDocument.load(pdfFile)
		int totalPages = document.getNumberOfPages()
		def page = document.getPage(pageNumberToExtract)

		//Rectangle2D region = new Rectangle2D.Double(x (right), y(down), width, height);
		def phonenoRect = new Rectangle(465, 205, 90, 20)
		def stripperByPhoneno = new PDFTextStripperByArea()
		stripperByPhoneno.addRegion("phonenoRegion", phonenoRect)
		stripperByPhoneno.extractRegions(page)
		pdfTextnew = stripperByPhoneno.getTextForRegion("phonenoRegion")

		
		def phoneno_fromPdfFormatted = cleanAndFormatPhoneNumber(pdfTextnew) // Clean and format the extracted phone number
		println('Extracted Phoneno: ' + phoneno_fromPdfFormatted)

		
		def matchedDealer = null      // Check if the cleaned and formatted phone number matches any expected phone numbers
		for (entry in expectedPhoneNumbers) {
			def dealer = entry.key
			def phoneNumber = entry.value
			if (phoneno_fromPdfFormatted == cleanAndFormatPhoneNumber(phoneNumber)) {
				matchedDealer = dealer
				break
			}
		}

		if (matchedDealer != null) {
			println("Dealer contact number matched with PDF for $matchedDealer")
		} else {
			println("Dealer contact number does not match with PDF")
		}

		document.close()
		println("Total number of pages: $totalPages")
	} catch (Exception e) {
		// Handle exceptions if needed
		e.printStackTrace()
	}
}


println(pdfText)



