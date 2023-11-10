import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import internal.GlobalVariable;


public class DatabaseConnection {
	public static Connection connection = null;
	public static Statement stmt = null;
	public static ResultSet rs=null;
	
	//public static String serverName=WebServiceHooks.serverName;
	//public static String BMWserverName=WebServiceHooks.BMWserverName;
	//public static String HyundaiserverName=WebServiceHooks.HyundaiserverName;

	public static String dataBaseConnection(String contractId,String sqlDBInstance,String Dbname) throws SQLException, IOException {
		//String toDayDate=CurrentDateSelection.getCurrentDate();
		//String tableStatus="Fail";
		String  tableRate =null;
       String DBInstance=sqlDBInstance;
      
		System.out.println("-------- SQL "
				+ "JDBC Connection ------------");

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("SQL JDBC Driver is missing. "
					+ "Include in your library path!");
			e.printStackTrace();
			//return;

		}

		System.out.println("SQL JDBC Driver Registered!");

		Connection connection = null;
		Statement stmt = null;

		try {
			//System.out.println("jdbc:sqlserver://"+DBInstance+";DatabaseName = SGEAS_DIFF"+";user = "+HooksEas.userName+";password = "+HooksEas.password);
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://"+DBInstance+";DatabaseName = SGEAS_DIFF;integratedSecurity=true;");
			
			//connection = DriverManager.getConnection("jdbc:sqlserver://QTSQADB-2\\QABETA;DatabaseName = SGEAS_DIFF;user = appuser;password = @ppu5er123");

		} catch (SQLException e) {

			System.out.println("Connection Failed!");
			e.printStackTrace();
			//return;

		}

		if (connection != null) {
			//System.out.println("You made it, take control your database now!");
			
			  stmt = connection.createStatement();
			  
		         ResultSet rs = stmt.executeQuery( "select vin, status, last_name, * from econ_contract where econ_contract_number = '"+contractId+"'" );
		        
		         while ( rs.next() ) {		        	 
		        	 tableRate = rs.getString("Cms_Contract_Number");	
		         }
		         
		         rs.close();
		         stmt.close();
		         connection.close();
		         
		} else {
			System.out.println("Failed to make connection!");
		}
		return tableRate;
	}
	
	public static ResultSet dataBaseConnection(String vin,String dbInstance) throws SQLException, IOException {
		//String toDayDate=CurrentDateSelection.getCurrentDate();
		//String tableStatus="Fail";
		String  tableRate =null;
       String DBInstance=dbInstance;
		System.out.println("-------- SQL "
				+ "JDBC Connection ------------");

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("SQL JDBC Driver is missing. "
					+ "Include in your library path!");
			e.printStackTrace();
			//return;

		}

		System.out.println("SQL JDBC Driver Registered!");

		//Connection connection = null;
		//Statement stmt = null;

		try {
			//System.out.println("jdbc:sqlserver://"+DBInstance+";DatabaseName = SGEAS_DIFF"+";user = "+HooksEas.userName+";password = "+HooksEas.password);
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://"+DBInstance+";DatabaseName = SGEAS_DIFF;integratedSecurity=true;");
			
			//connection = DriverManager.getConnection("jdbc:sqlserver://QTSQADB-2\\QABETA;DatabaseName = SGEAS_DIFF;user = appuser;password = @ppu5er123");

		} catch (SQLException e) {

			System.out.println("Connection Failed!");
			e.printStackTrace();
			//return;

		}

		if (connection != null) {
			//System.out.println("You made it, take control your database now!");
			
			  stmt = connection.createStatement();
			  
		          rs = stmt.executeQuery( "select vin, status, last_name, * from econ_contract where vin = '"+vin+"'" );
		        
		       		       
		         
		} else {
			System.out.println("Failed to make connection!");
		}
		return rs;
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