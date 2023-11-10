import com.kms.katalon.core.testobject.ConditionType as ConditionType
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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import utility.UtilKeywords as UtilKeywords
import excelPackage.ExcelKeywords as ExcelKeywords
import utility.jsscript as jsscript
//import DatabaseConnection as DbConnection
import java.sql.*
import java.awt.Robot as Robot

//for pdf validation
import com.kms.katalon.core.util.KeywordUtil
import java.io.IOException
import java.net.URL
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import java.io.BufferedReader
import java.io.FileReader

if(testCase=="1") {
			ExcelKeywords excelKeywords = new ExcelKeywords()

			excelKeywords.deleteExcel(System.getProperty('user.dir'), 'Result.xlsx', 'Vroom_Result');
		}

String status = 'Pass'
if (status == 'Pass') {
	PGDatabaseConnection a = new PGDatabaseConnection()

	String str1 = ('select order_id__c,sfid, status,customer_order_number__c,payment_terms__c,order_total_before_tax__c, sales_tax__c, totalamount, monthly_payment__c, downpayment_amount__c, status,effectivedate, accountid from salesforce.order  where customer_order_number__c=\'' +
	'ncesidtc138395') + '\''

   // println(str1)

	ResultSet rs = a.dataBaseConnection(str1, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser,
		GlobalVariable.pgPassword)

	String orderId = ''

	while (rs.next()) {
		orderId = rs.getString('order_id__c')

		//		println((orderId + ' total rate : ') + totalrate)
		//
		//		println(((rs.getString('status') + rs.getString('customer_order_number__c')) + rs.getString('payment_terms__c')) +
		//			feePaymentPlan)
		//
		//		println(((((rs.getString('order_total_before_tax__c') + subtotal) + rs.getString('sales_tax__c')) + salesTax) +
		//			rs.getString('totalamount')) + totalrate)
		//
		//		println((((((('total amount: ' + rs.getString('totalamount')) + ' ^^**^^ ') + Trate) + '   ') + rs.getString('sfid')) +
		//			' ') + rs.getString('accountid'))
		WebUI.delay(2)
		feePaymentPlan = 'abc'
		if (feePaymentPlan != 'Pay In Full') {
			if (((rs.getString('status') == 'Active') && //rs.getString('customer_order_number__c')==customerOrderNo &&
			 //rs.getString('payment_terms__c')==selectedPayment && // new added selectedPayment instead of feePaymentPlan
			(rs.getString('payment_terms__c') != null)) && // need to change it after fix
			(rs.getString('sfid') != null //&& rs.getString('totalamount')==Trate  // totalrate changed to subtotal to Trate
			// rs.getString('downpayment_amount__c') == DownPayment && // split downpayment
			//need to update later// rs.getString('effectivedate') == effectiveDate &&
			// rs.getString('accounid') != null &&
			//&& rs.getString('_hc_lastop') == 'SYNCED'
		//&& rs.getString('_hc_err') == null
			// rs.getString('monthly_payment__c') == selectedPayment && **not applicable for Vins
			///////
			//rs.getString('order_total_before_tax__c')==subtotal ** Not applicable for Vins
			//rs.getString('sales_tax__c')==salesTax			  ** Not applicable for Vins
			/* &&
				rs.getString('payment_terms__c')==feePaymentPlan && rs.getString('order_total_before_tax__c')==subtotal &&
				rs.getString('sales_tax__c')==salesTax && rs.getString('totalamount')==totalrate)*/ )) {
				verifyDB = 'Success'

			   // println('Success')

				//M
				first_query_result = 'Status is Active || Customer Order number is Not empty' //println('###---Status is Active || Customer Order number is matched---###')
				//println('###---DB verification failed. Please check : status|payment_terms__c|sfid|totalamount|downpayment_amount__c|effectivedate|accounyid|_hc_lastop|_hc_err---###')
				///////////////////////////
				//rs.getString('customer_order_number__c')==customerOrderNo &&
				//rs.getString('payment_terms__c')==selectedPayment && // new added selectedPayment instead of feePaymentPlan
				// need to change it after fix
				//&& rs.getString('totalamount')==Trate  // totalrate changed to subtotal to Trate
				// rs.getString('downpayment_amount__c') == down_payment && // split downpayment
				//need to update later// rs.getString('effectivedate') == effectiveDate &&
				// rs.getString('accounid') != null &&
				// rs.getString('_hc_lastop') == 'SYNCED'
				// && rs.getString('_hc_err') == null
				// rs.getString('monthly_payment__c') == selectedPayment && **not applicable for Vins
				///////
				//rs.getString('order_total_before_tax__c')==subtotal ** Not applicable for Vins
				//rs.getString('sales_tax__c')==salesTax			  ** Not applicable for Vins
				/* &&
					rs.getString('payment_terms__c')==feePaymentPlan && rs.getString('order_total_before_tax__c')==subtotal &&
					rs.getString('sales_tax__c')==salesTax && rs.getString('totalamount')==totalrate)*/
				//M
			} //////
			//		else {
			else {
				verifyDB = 'Unsuccessful,'

				status = 'fail'

				first_query_result = 'DB verification failed. Please check : status|payment_terms__c|sfid|totalamount|downpayment_amount__c|effectivedate|accounyid|_hc_lastop|_hc_err'
			}
			//			println("else else else")
			//		}
		} else if (feePaymentPlan == 'Pay In Full') {
			if (((rs.getString('status') == 'Active') && (rs.getString('payment_terms__c') == null)) && (rs.getString('sfid') !=
			null)) {
				verifyDB = 'Success'

			   // println('Success')

				first_query_result = 'Status is Active || Customer Order number is matched'

			   // println('###---Status is Active || Customer Order number is matched---###')
			} else {
				verifyDB = 'Unsuccessful,'

				status = 'fail'

				first_query_result = 'DB verification failed. Please check : status|payment_terms__c|sfid|totalamount|downpayment_amount__c|effectivedate|accounyid|_hc_lastop|_hc_err'

				//println('###---DB verification failed. Please check : status|payment_terms__c|sfid|totalamount|downpayment_amount__c|effectivedate|accounyid|_hc_lastop|_hc_err---###')
			}
		}
	}
	
	WebUI.delay(2)

	String orderSummaryId = ''

	if (verifyDB == 'Success') {
		String str2 = ('select order_summary_id__c, sfid,item_name__C, * from salesforce.orderitem where order__order_id__c=\'' +
		orderId) + '\''

	   // println(str2)

		rs = a.dataBaseConnection(str2, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)

		WebUI.delay(2)

		//println(res)
		while (rs.next()) {
			orderSummaryId = rs.getString('order_summary_id__c')

			//econ_contract_number=rs.getString(c)
			con_num = rs.getString('external_reference_number__c')

		  //  println(con_num)

			//int num=(int)econ_contract_number
		  //  println(orderSummaryId)
plan = 'Platinum'
			//			println((((((rs.getString('item_name__c') + plan) + rs.getString('sales_date__c')) + rs.getString('expiration_date__c')) +
			//				rs.getString('sales_tax__c')) + salesTax) + rs.getString('summarydescription__c'))
			if (((((rs.getString('item_name__c') == plan) && (rs.getString('order_summary_id__c') != null)) && (rs.getString(
				'sales_date__c') != null)) && (rs.getString('expiration_date__c') != null)) && (rs.getString('summarydescription__c') !=
			null)) {
				//rs.getString('sales_tax__c')==salesTax &&s
				verifyDB = 'Success'

			  //  println('Success')

				//M
				second_query_result = 'Selected Plan is matched, Sales date, expiration date and order summary description is fetched to Database' //println('###---Selected Plan is matched, Sales date, expiration date and order summary description is fetched to Database---###') //second_query_result = 'DB verification failed. Please check : item_name__c|order_summary_id__c|sales_date__c|expiration_date__c|summarydescription__c '
				//println('DB verification failed. Please check : item_name__c|order_summary_id__c|sales_date__c|expiration_date__c|summarydescription__c ')
			} else {
				verifyDB = 'Unsuccessful,'

				status = 'fail'
				second_query_result = 'Selected Plan is matched, Sales date, expiration date and order summary description is not fetched to Database'
			}
		}
		
		if ((verifyDB == 'Success') || (verifyDB != 'Success')) {
			String str3 = ('select value__c,_hc_lastop, _hc_err, order_metadata_external_id__c,* from salesforce.order_metadata__c where order__r__order_id__c=\'' +
			orderId) + '\''

			rs = a.dataBaseConnection(str3, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser, GlobalVariable.pgPassword)

			while (rs.next()) {
				println(rs.getString('_hc_lastop') + rs.getString('_hc_err'))

				if ((rs.getString('_hc_err') == null) && (rs.getString('_hc_lastop') == 'INSERTED')) {
					verifyDB = 'Success'

				  //  println('Success')

					//M
					third_query_result = 'No _hc_err is occured and _hc_lastop is Synced'

				   // println('###---No _hc_err is occured---###')
				} else {
					verifyDB = 'Unsuccessful,'

					status = 'fail'

					third_query_result = '_hc_err is occured and _hc_lastop is not Synced. Please check'

				//    println('hc_err is occured and _hc_lastop is not Synced. Please check')

					break
				}
			}
			
			if ((verifyDB == 'Success') || (verifyDB != 'Success')) {
				String str4 = ('select orderpayment_id, * from public.orderpaymentrelation where order_external_id=\'' +
				orderId) + '\''

				rs = a.dataBaseConnection(str4, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser,
					GlobalVariable.pgPassword)

			  //  println(rs)

				while (rs.next()) {
					if (((((((((rs.getString('orderpayment_id') != null) && (rs.getString('order_external_id') == orderId)) &&
					(rs.getString('cc_last_four') != null)) && (rs.getString('cc_exp_month') != null)) && (rs.getString(
						'cc_exp_year') != null)) && (rs.getString('created_by') == 'APP')) && (rs.getString('updated_by') ==
					'APP')) && (rs.getString('created_date') != null)) && (rs.getString('updated_date') != null)) {
						verifyDB = 'Success'

					 //   println('Success')

						//M
						fourth_query_result = 'Orderpayment_id || order_external_id || cc_last_four || cc_exp_month || cc_exp_year : successfully fetched to database || Created by and updated by == APP || Created date || updated date: successfully fetched to Database' //fourth_part2_query_result = 'Created by and updated by == APP'
						//fourth_part3_query_result = 'Created date || updated date: successfully fetched to Database'
						//println('###---Orderpayment_id || order_external_id || cc_last_four || cc_exp_month || cc_exp_year : successfully fetched to database---###')
						//println('###---Created by and updated by == APP---###')
						//println('###---Created date || updated date: successfully fetched to Database---###') //fourth_part2_query_result = 'Database validation error. Please check Created by and updated by == APP'
						//fourth_part3_query_result = 'Database validation error. Please check Created date || updated date: successfully fetched to Database'
					} else {
						verifyDB = 'Unsuccessful,'

						status = 'fail'

						fourth_query_result = 'Database validation error. Please check Orderpayment_id || order_external_id || cc_last_four || cc_exp_month || cc_exp_year : successfully fetched to database || Please check Created by and updated by == APP ||  Created date || updated date'
					}
				}
				
				WebUI.delay(3)

				if ((verifyDB == 'Success') || (verifyDB != 'Success')) {
					String str5 = ('select * from public.contract_pdf where order_summary_id=\'' + orderSummaryId) + '\''

					rs = a.dataBaseConnection(str5, GlobalVariable.pghost, GlobalVariable.pgdbInstance, GlobalVariable.pgUser,
						GlobalVariable.pgPassword)

					///
					while (rs.next()) {
						if ((rs.getString('order_summary_id') == orderSummaryId) && (rs.getString('data') != null)) {
							verifyDB = 'Heroku Success'

							///
							///
							//M
							fifth_query_result = 'Heroku DB validation success. Order_sammary_id is equals to DBs orderSummaryId and data is fetched to DB'

							//println('###---order_sammary_id is equals to DBs orderSummaryId and data is fetched to DB---###')
							//println('Heroku Success')
							///
							WebUI.openBrowser('')

							WebUI.maximizeWindow()

							WebUI.navigateToUrl('https:portal.safe-guardproducts.com/public/generatepdf.php')

							WebUI.delay(2)

							File file = new File('C:/Users/murahman/Downloads/output.txt')

							BufferedWriter writer = new BufferedWriter(new FileWriter(file))

							writer.write(rs.getString('data'))

							writer.close()

							//					}
							String filePath = 'C:/Users/murahman/Downloads/output.txt'

							// Open the notepad file
							def notepad = new ProcessBuilder('notepad.exe', filePath).start()

							// Wait for the notepad file to open
								Thread.sleep(3000)

							CustomKeywords.'pdf_verification.db_binary_pdfCheck_vroom.Robot_key_press'()

							CustomKeywords.'pdf_verification.db_binary_pdfCheck_vroom.download_pdf_from_binary'()
								

					Map<String, String> results = CustomKeywords.'pdf_verification.db_binary_pdfCheck_vroom.download_pdf_from_binary'()
						String deductible = 100 
						
						
						String termLength = "3 YEARS, 60,000 MILES"
						String subtotal = '$1,515.00'
						String firstName = "John"
						String lastName = "Doe"
						//PdfVerification.verifyPdf(results, deductible, termLength, subtotal, firstName, lastName)
				pdfResult = CustomKeywords.'pdf_verification.db_binary_pdfCheck_vroom.verifyPdf'(results, deductible, termLength, subtotal, firstName, lastName)
						
						println(pdfResult)
								

				//	Map<String, String> results = CustomKeywords.'pdf_verification.db_binary_pdfCheck.download_pdf_from_binary'()
//						int deductible = 100
//						String termLength = "3 YEARS, 60,000 MILES"
//						String subtotal = '$1,515.00"
//						String firstName = "John"
//						String lastName = "Doe"
						//PdfVerification.verifyPdf(results, deductible, termLength, subtotal, firstName, lastName)
				//pdfResult = CustomKeywords.'pdf_verification.db_binary_pdfCheck.verifyPdf'(results, deductible, termLength, subtotal, firstName, lastName)
						
					//	println(pdfResult)KuKu 
								//////////////////////////////
							///
						} else {
							verifyDB = 'Unsuccessful,'

							status = 'fail'

							fifth_query_result = 'Database validation error. Please check order_sammary_id is equals to DBs orderSummaryId and data is fetched to DB'
						}
					}
				}
			}
		}
		
		a.closeConnection()
	}
}
	
	/////
	WebUI.delay(3)
			
			/*
		   if(verifyDB=='Success' && portal !='Nissan')
		   {
			//  String cmd1='plink -ssh test01@qtsuatgmcms1 -pw testuser1234 "cd /data/scripts && sh process_econtracts"'
//String cmd2='testuser1234'
//String cmd3='cd /data/scripts'
//String cmd4='sh process_econtracts'
//Runtime.getRuntime().exec(cmd1)
			PGDatabaseConnection te=new PGDatabaseConnection();
			
			String str6="select * from web_con_m1 where id = '"+ con_num +"'";
			println(str6)
			ResultSet rs1=te.dataBaseConnection(str6, 'qtsuatpost6:54262','forte', 'murahman', 'mun@Abir##22')
			//String orderId=''
			//println(res)s
			while ( rs1.next() ) {
				//orderId=rs1.getString('order_id__c')
				//println(orderId)
				if(rs1.getString('id')!=null && rs1.getString('web_con_vin')!=null &&
				rs1.getString('web_con_product')!=null && rs1.getString('web_con_rectype')!=null &&
				rs1.getString('web_con_trandate')!=null && rs1.getString('web_con_lname')!=null)
				{
					verifyDB='web_con_m1 Success'
					println('web_con_m1 Success')
				}
				else {
					verifyDB='heroku success and web_con_m1 Unsuccessful,'
					status='fail'
				}
			
			}
			if(verifyDB=='Success' && portal !='Nissan')
			{
			String str7="select * from dms_con_m1 where dms_con_webid='"+ con_num +"'";
			ResultSet rs2=te.dataBaseConnection(str7, 'qtsuatpost6:54262','forte', 'murahman', 'mun@Abir##22')
			
			//String orderId=''
			println(str7)
			while ( rs2.next() ) {
				//orderId=rs1.getString('order_id__c')
				//println(orderId)
				dms_con=rs2.getString('dms_con_contract')
				cms_contract_Id=rs2.getString('dms_con_contract')
				println(dms_con + '   '+rs2.getString('dms_con_contract'))
				if( rs2.getString('dms_con_vin')!=null &&
				rs2.getString('dms_con_product')!=null && rs2.getString('dms_con_rectype')!=null &&
				rs2.getString('dms_con_trandate')!=null && rs2.getString('dms_con_lname')!=null)
				{
					verifyDB='dms_con_m1 Success'
					println('DMS verification Success')
				}
				else {
					verifyDB='heroku success and dms Unsuccessful,'
					status='fail'
				}
			}
			}
			if(verifyDB=='Success' && portal !='Nissan')
				{
				String str8="select * from sg_con_m1 where sg_con_contract = '"+ dms_con +"'";
				ResultSet rs3=te.dataBaseConnection(str8, 'qtsuatpost6:54262','forte', 'murahman', 'mun@Abir##22')
				//String orderId=''
				println(str8)
				while ( rs3.next() ) {
					//orderId=rs1.getString('order_id__c')
					//println(orderId)
					cms_contract_Id=rs3.getString('sg_con_contract')
					//println(cms_contract_Id)
					if( rs3.getString('sg_con_vin')!=null &&
					rs3.getString('sg_con_carrier')!=null && rs3.getString('sg_con_cover')!=null &&
					rs3.getString('sg_con_status')!=null && rs3.getString('sg_con_lname')!=null)
					{
						verifyDB='sg_con_m1 Success'
						println('Success')
					}
					else {
						verifyDB='heroku success and sg_con_m1 Unsuccessful,'
						status='fail'
					}
				}
				}
			te.closeConnection()
			}



		}
	else {
		verifyDB='NA'
		cms_contract_Id='NA'
	}
	**/
	def portal = 'Vroom'
	
		def vinNo = "abc"
	
		def firstName = "abc"
	
		def lastName = "abc"
	
		def vehicle_reg_province = "abc"
	
		def plan = "abc"
	
		def termLength = "abc"
	
		def mileage = "abc"
	
		def feePaymentPlan = "abc"
	
		def subtotal = "abc"
	
		def salesTax = "abc"
	
		def totalrate = "abc"
	
		def customerOrderNo = "abc"
	
		def verifyDB = "abc"
	
		def cms_contract_Id = "abc"
	
		def currentDate = "abc"
	
		def error_msg = "abc"
	
		def first_query_result = "abc"
	
		def second_query_result = "abc"
	
		def third_query_result = "abc"
	
		def fourth_query_result = "abc"
	
		def fifth_query_result = "abc"
	
//			(valueToWrite[24]) = sixth_query_result
//
//			(valueToWrite[25]) = seventh_query_result
//
//			(valueToWrite[26]) = eightth_query_result
	
		def link1 = "abc"
	
	//	(valueToWrite[28]) = link2
	
	//	(valueToWrite[29]) = link3
	
		def link4 = "abc"
	
		def link5 = "abc"
	
		//(valueToWrite[32]) = link6
	
		//(valueToWrite[33]) = link7
	
		//(valueToWrite[34]) = link8
	
		//(valueToWrite[35]) = link9
		
		
		def cartPageCal = "abc"
		def checkoutPageCal = "abc"
	

	
	WebUI.closeBrowser()
	writeResult()
// added for commenting out after checking 5 db tables


	
def writeResult()
{
	'Writing the result to the excel file'
	UtilKeywords utilKeywords = new UtilKeywords()
	String currentDate = utilKeywords.getCurrentDate()

	//String status = 'PASS'
	//println(contractStatus)
	//String responseDescription = 'SUCCESS'
	//println(responseDescription)

	String[] valueToWrite = new String[40]

	(valueToWrite[0]) = testCase
	
		(valueToWrite[1]) = portal
	
		(valueToWrite[2]) = vinNo
	
		(valueToWrite[3]) = firstName
	
		(valueToWrite[4]) = lastName
	
		(valueToWrite[5]) = vehicle_reg_province
	
		(valueToWrite[6]) = plan
	
		(valueToWrite[7]) = termLength
	
		(valueToWrite[8]) = mileage
	
		(valueToWrite[9]) = feePaymentPlan
	
		(valueToWrite[10]) = subtotal
	
		(valueToWrite[11]) = salesTax
	
		(valueToWrite[12]) = totalrate
	
		(valueToWrite[13]) = status
	
		(valueToWrite[14]) = customerOrderNo
	
		(valueToWrite[15]) = verifyDB
	
		(valueToWrite[16]) = cms_contract_Id
	
		(valueToWrite[17]) = currentDate
	
		(valueToWrite[18]) = error_msg
	
		(valueToWrite[19]) = first_query_result
	
		(valueToWrite[20]) = second_query_result
	
		(valueToWrite[21]) = third_query_result
	
		(valueToWrite[22]) = fourth_query_result
	
		(valueToWrite[23]) = fifth_query_result
	
//			(valueToWrite[24]) = sixth_query_result
//
//			(valueToWrite[25]) = seventh_query_result
//
//			(valueToWrite[26]) = eightth_query_result
	
		(valueToWrite[24]) = link1
	
	//	(valueToWrite[28]) = link2
	
	//	(valueToWrite[29]) = link3
	
		(valueToWrite[25]) = link4
	
		(valueToWrite[26]) = link5
	
		//(valueToWrite[32]) = link6
	
		//(valueToWrite[33]) = link7
	
		//(valueToWrite[34]) = link8
	
		//(valueToWrite[35]) = link9
		
		(valueToWrite[27]) = pdfResult
		(valueToWrite[28]) = cartPageCal
		(valueToWrite[29]) = checkoutPageCal
	


	ExcelKeywords excelKeywords = new ExcelKeywords()
	if(portal=="Vroom" || portal=="vroom") {
		excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'Vroom_Result', valueToWrite)

	}
	else if (portal=="Nissan" || portal=="nissan") {
		excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'Nissan_Result', valueToWrite)

	}
	else if (portal=="Schomp" || portal=="schomp") {
		excelKeywords.writeExcel(System.getProperty('user.dir'), 'Result.xlsx', 'Schomp_Result', valueToWrite)

	}



}

	