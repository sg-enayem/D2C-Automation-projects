
import internal.GlobalVariable;
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint;
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase;
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData;
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject;

import com.kms.katalon.core.annotation.Keyword;
import com.kms.katalon.core.checkpoint.Checkpoint;
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords;
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords;
import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.testcase.TestCase;
import com.kms.katalon.core.testdata.TestData;
import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords;

import java.sql.*;
import java.io.*;

public class PGDatabaseConnection {
	static Connection connection = null;
	static Statement stmt = null;
	static ResultSet rs=null;

	public static ResultSet dataBaseConnection(String quer, String pgHost,String DBInstance, String userName, String password) throws SQLException, IOException {
		//String toDayDate=CurrentDateSelection.getCurrentDate();
		//String tableStatus="Fail";
		String  res =null;

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			//return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		
		try {
  if(pgHost!="qtsuatpost6:54262") {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://"+pgHost+"/"+DBInstance+"?currentSchema=salesforce", userName,
					password);
  }
  else
  {
	  connection = DriverManager.getConnection(
				"jdbc:postgresql://"+pgHost+"/"+DBInstance+"?currentSchema=public", userName,
				password);
  }

		} catch (SQLException e) {

			System.out.println("Connection Failed!");
			e.printStackTrace();
			//return;

		}
        
		if (connection != null) {
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery(quer);
		
			
			
		} else {
			System.out.println("Failed to make connection!");
		}
		return rs;
       
        	//rs.close();
			//stmt.close();
			//connection.close();

        
		
	}
	public void closeConnection()
	{
		try {
		if(rs != null && !rs.isClosed()){
		        rs.close();
		}
		if(stmt != null && !stmt.isClosed()){
		stmt.close();
		}
		if(connection != null && !connection.isClosed()){
		connection.close();
		}
		}
		catch (SQLException e) {

			System.out.println("Connection Failed!");
			e.printStackTrace();
			//return;

		}
        
	}
}