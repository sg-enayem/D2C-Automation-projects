package utility

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

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//import ConfigurationsEas;

public class DatabaseConnection {

	//public static String serverName=WebServiceHooks.serverName;
	//public static String BMWserverName=WebServiceHooks.BMWserverName;
	//public static String HyundaiserverName=WebServiceHooks.HyundaiserverName;

	public static String dataBaseConnection(String contractId, String tableName,String fieldName, String DBInstance, String userName,String password) throws SQLException, IOException {
		//String toDayDate=CurrentDateSelection.getCurrentDate();
		//String tableStatus="Fail";
		/*String  tableRate =null;
		 System.out.println("-------- SQL "
		 + "JDBC Connection ------------");
		 try {
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 } catch (ClassNotFoundException e) {
		 System.out.println("SQL JDBC Driver is missing. " + "Include in your library path!");
		 e.printStackTrace();
		 //return;
		 }
		 System.out.println("SQL JDBC Driver Registered!");
		 Connection connection = null;
		 Statement stmt = null;
		 DBInstance="QTSQADB1\\QAALPHA"
		 //userName="ETCH\\pkumar"
		 //password=2022"
		 try {
		 println("jdbc:sqlserver://"+DBInstance+";DatabaseName = SGEAS_DIFF"+"integratedSecurity=true;");
		 connection = DriverManager.getConnection(
		 "jdbc:sqlserver://"+DBInstance+";DatabaseName = SGEAS_DIFF;"+"integratedSecurity=true;");//;user = "+userName+";password = "+password);
		 //connection = DriverManager.getConnection("jdbc:sqlserver://QTSQADB1\\QAALPHA;DatabaseName = SGEAS_DIFF;user = pkumar;password = July@2022");
		 } catch (SQLException e) {
		 //connection = DriverManager.getConnection("jdbc:sqlserver://QTSQADB-2\\QABETA;DatabaseName = SGEAS_DIFF;user = appuser;password = @ppu5er123");
		 System.out.println("Connection Failed!");
		 e.printStackTrace();
		 //return;
		 }
		 if (connection != null) {
		 System.out.println("You made it, take control your database now!");
		 stmt = connection.createStatement();
		 ResultSet rs = stmt.executeQuery( "select "+fieldName+" from "+tableName+" where econ_contract_number='"+contractId+"'" );
		 while ( rs.next() ) {
		 tableRate = rs.getString(fieldName);
		 }
		 rs.close();
		 stmt.close();
		 connection.close();
		 } else {
		 System.out.println("Failed to make connection!");
		 }
		 return tableRate;*/



	}

}