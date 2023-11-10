package devTool

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
///------///
import org.codehaus.groovy.runtime.StackTraceUtils
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver
import org.openqa.selenium.devtools.DevTools
import org.openqa.selenium.devtools.network.Network

public class DevToolsKeyword {
	@Keyword
	def static String interceptApiResponse() {
		WebDriver driver = DriverFactory.getWebDriver()
		DevTools devTools = driver as DevTools

		// Enable the Network domain
		devTools.createSession()
		Network network = devTools.getNetwork()

		// Set up event listeners to intercept network responses
		network.enable()
		network.onResponseReceived { response ->
			def url = response['response']['url']
			def status = response['response']['status']
			def responseBody = response['response']['body']
			
			//https://dtc-gateway-srvc-staging.herokuapp.com/dtc-gateway-srvc/dtc-payment-srvc/purchaseContract%27
			//https://d2c-gateway-staging.herokuapp.com/dtc-gateway-srvc/dtc-payment-srvc/purchaseContract
			if (url.contains("purchaseContract") && status == 200) {
				println("API Response URL: ${url}")
				println("API Response Status Code: ${status}")
				println("API Response Body: ${responseBody}")
			}
		}

		// Perform the action that triggers the network request
		WebUI.click(findTestObject('Object Repository/Vroom/span_Pay Now'))

		// Wait for some time to allow network request and response
		WebUI.delay(10)

		// Clean up
		network.disable()
		devTools.close()

		return responseBody
	}
}

