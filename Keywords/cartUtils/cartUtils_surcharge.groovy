package cartUtils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class cartUtils_surcharge {

	/**
	 * Adds surcharge to the cart subtotal based on portal and commercial use/lift kit options.
	 * 
	 * @param portal the portal name (case insensitive)
	 * @param commercialUse 'yes' or 'no' for commercial use option
	 * @param liftKit 'yes' or 'no' for lift kit option
	 * @return true if surcharge is added successfully, false otherwise
	 */
	@Keyword
	def static boolean addSurcharge(String portal, String commercialUse, String liftKit) {
		boolean surchargeAdded = true

		TestObject subtotalCartPage = findTestObject('Object Repository/Vroom/Vroom_cart_subtotal')
		String subtotalText = WebUI.getText(subtotalCartPage)
		float subtotal = subtotalText.replaceAll('\\$|\\.\\d+|,', '') as float

		if ((portal.equalsIgnoreCase('GMC') || portal.equalsIgnoreCase('Chevrolet'))) {
			TestObject lever1 = findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever1')
			WebUI.click(lever1)
			WebUI.delay(3)

			if (commercialUse.equalsIgnoreCase('yes')) {
				subtotal += 250
			}

			if (liftKit.equalsIgnoreCase('yes')) {
				TestObject lever2 = findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever2')
				WebUI.click(lever2)
				WebUI.delay(3)
				subtotal += 350
			}

			String subtotalWithSurchargeText = WebUI.getText(subtotalCartPage)
			float subtotalWithSurcharge = subtotalWithSurchargeText.replaceAll('\\$|\\.\\d+|,', '') as float

			if (subtotal == subtotalWithSurcharge) {
				surchargeAdded = true
				println('Surcharge added successfully.')
			}
		} else if (portal.equalsIgnoreCase('Buick') || portal.equalsIgnoreCase('Cadillac')) {
			if (liftKit.equalsIgnoreCase('yes')) {
				TestObject lever2 = findTestObject('Object Repository/GM/Page_GMC - Get Rates/span_lever2')
				WebUI.click(lever2)

				subtotal += 250

				String subtotalWithSurchargeText = WebUI.getText(subtotalCartPage)
				float subtotalWithSurcharge = subtotalWithSurchargeText.replaceAll('\\$|\\.\\d+|,', '') as float

				if (subtotal == subtotalWithSurcharge) {
					surchargeAdded = true
					println('Surcharge added successfully.')
				}
			}
		}

		return surchargeAdded
	}
}