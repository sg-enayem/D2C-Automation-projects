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


	String str7 = ('select * from dms_con_m1 where dms_con_webid=\'' + '14674957') + '\''

	ResultSet rs2 = te.dataBaseConnection(str7, 'qtsuatpost6:54262', 'forte', 'murahman', 'mun@Abir#2')

	//String orderId=''
	println(str7)

	while (rs2.next()) {
		//orderId=rs1.getString('order_id__c')
		//println(orderId)
		dms_con = rs2.getString('dms_con_contract')

		cms_contract_Id = rs2.getString('dms_con_contract')

		println((dms_con + '   ') + rs2.getString('dms_con_contract'))

		if (((((rs2.getString('dms_con_vin') != null) && (rs2.getString('dms_con_product') != null)) && (rs2.getString(
			'dms_con_rectype') != null)) && (rs2.getString('dms_con_trandate') != null)) && (rs2.getString('dms_con_lname') !=
		null)) {
			verifyDB = 'dms_con_m1 Success'

			println('DMS verification Success')

			//M
			println('###---dms_con_product || dms_con_rectype || dms_con_trandate || dms_con_lname : fetched from Database---###')

			seventh_query_result = 'dms_con_product || dms_con_rectype || dms_con_trandate || dms_con_lname : fetched from Database'
		} else {
			verifyDB = 'heroku success and dms Unsuccessful,'

			status = 'fail'

			seventh_query_result = 'PG Admin validation failed. Please check in dms_con_product || dms_con_rectype || dms_con_trandate || dms_con_lname'

			println(seventh_query_result)
		}
	}

	String str8 = ('select * from sg_con_m1 where sg_con_contract = \'' + dms_con) + '\''

	ResultSet rs3 = te.dataBaseConnection(str8, 'qtsuatpost6:54262', 'forte', 'murahman', 'mun@Abir#2')

	//String orderId=''
	println(str8)

	while (rs3.next()) {
		//orderId=rs1.getString('order_id__c')
		//println(orderId)
		//cms_contract_Id=rs3.getString('sg_con_contract')
		//println(cms_contract_Id)
		if (((((rs3.getString('sg_con_vin') != null) && (rs3.getString('sg_con_carrier') != null)) && (rs3.getString(
			'sg_con_cover') != null)) && (rs3.getString('sg_con_status') != null)) && (rs3.getString('sg_con_lname') !=
		null)) {
			verifyDB = 'sg_con_m1 Success'

			println('Success')

			//M
			println('###---sg_con_carrier || sg_con_cover || sg_con_status || sg_con_lname : fetched from Databse---###')

			eightth_query_result = 'sg_con_carrier || sg_con_cover || sg_con_status || sg_con_lname : fetched from Databse'
		} else {
			verifyDB = 'heroku success and sg_con_m1 Unsuccessful,'

			status = 'fail'

			println('###---sg_con_carrier || sg_con_cover || sg_con_status || sg_con_lname :not  fetched from Databse---###')

			eightth_query_result = 'sg_con_carrier || sg_con_cover || sg_con_status || sg_con_lname : Not fetched from Databse'
		}
	}
	
	WebUI.delay(2)


te.closeConnection()
