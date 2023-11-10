package excelPackage

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import com.kms.katalon.core.annotation.Keyword
import org.apache.poi.ss.usermodel.*

import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFCell


public class ExcelKeywords {

	//new code for GM_Brands result writing-start
	@Keyword
	public void appendRowToExcel(String filePath, String sheetName, String[] rowData) {
		FileInputStream fis = new FileInputStream(filePath)
		XSSFWorkbook workbook = new XSSFWorkbook(fis)
		XSSFSheet sheet = workbook.getSheet(sheetName)

		int rowNum = sheet.getLastRowNum() + 1
		XSSFRow row = sheet.createRow(rowNum)

		for (int i = 0; i < rowData.length; i++) {   // i=1 inplace 0
			XSSFCell cell = row.createCell(i)
			cell.setCellValue(rowData[i])
		}

		FileOutputStream fos = new FileOutputStream(filePath)
		workbook.write(fos)
		fos.close()
		fis.close()
	}
	//------END---
	//private  static int i=0;

	@Keyword
	public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite)
	throws IOException {

		// Create a object of File class to open xlsx file

		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook Workbook = null;

		// Find the file extension by spliting file name in substing and getting
		// only extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file

		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class

			Workbook = new XSSFWorkbook(inputStream);

		}

		// Check condition if the file is xls file

		else if (fileExtensionName.equals(".xls")) {

			//If it is xls file then create object of XSSFWorkbook class

			Workbook = new HSSFWorkbook(inputStream);

		}

		// Read excel sheet by sheet name

		Sheet sheet = Workbook.getSheet(sheetName);

		// Get the current count of rows in excel file

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Get the first row from the sheet

		Row row = sheet.getRow(0);
		// Row row1 = sheet.getRow(1);
		// System.out.println("Cell
		// Value:-"+row1.getCell(0).getStringCellValue());

		// Create a new row and append it at last of sheet

		// Row newRow = sheet.createRow(rowCount+1);

		// Create a loop over the cell of newly created Row
		// for(int i=0;i<2;i++)
		// {
		// Row row = sheet.getRow(i);
		Row newRow = sheet.createRow(rowCount + 1);
		// Row newRow = sheet.createRow(rawNo);
		for (int j = 0; j < row.getLastCellNum(); j++) {

			// Fill data in row

			Cell cell = newRow.createCell(j);

			cell.setCellValue(dataToWrite[j]);

		}

		inputStream.close();

		// Create an object of FileOutputStream class to create write data in
		// excel file

		FileOutputStream outputStream = new FileOutputStream(file);

		// write data in the excel file

		Workbook.write(outputStream);

		outputStream.close();

	}

	@Keyword
	public void deleteExcel(String filePath,String fileName,String sheetName) throws IOException{

		//Create a object of File class to open xlsx file

		File file =    new File(filePath+"\\"+fileName);

		//Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook Workbook = null;

		//Find the file extension by spliting file name in substing and getting only extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		//Check condition if the file is xlsx file

		if(fileExtensionName.equals(".xlsx")){

			//If it is xlsx file then create object of XSSFWorkbook class

			Workbook = new XSSFWorkbook(inputStream);

		}

		//Check condition if the file is xls file

		else if(fileExtensionName.equals(".xls")){

			//If it is xls file then create object of XSSFWorkbook class

			Workbook = new HSSFWorkbook(inputStream);

		}



		//Read excel sheet by sheet name

		Sheet sheet = Workbook.getSheet(sheetName);

		//Get the current count of rows in excel file

		//int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();


		//Get the first row from the sheet

		Row row = sheet.getRow(0);

		//Create a new row and append it at last of sheet

		//Row newRow = sheet.createRow(rowCount+1);

		//Create a loop over the cell of newly created Row
		//for(int i=0;i<2;i++)
		//{
		//Row row = sheet.getRow(i);
		//Row newRow = sheet.createRow(rowCount+1);
		for(int j = 1; j <= sheet.getLastRowNum(); j++){

			//Fill data in row

			// Cell cell = newRow.createCell(j);

			//cell.setCellValue(dataToWrite[j]);
			if(sheet.getRow(j)!=null)
			{
				sheet.removeRow(sheet.getRow(j));
			}

		}
		// }

		//<span style="list-style: none; float: none; cursor: pointer !important; position: relative !important; font-size: inherit !important; vertical-align: inherit !important; display: inline !important; text-align: left !important; margin: 0px !important; border-style: none none solid !important; border-color: initial !important; border-bottom-width: 1px !important; padding: 0px 0px 0.065em !important; text-decoration: underline !important; line-height: 20px;" class="intexthighlight" id="VxIpu" title="" click-setup="true">Close</span> input stream

		inputStream.close();

		//Create an object of FileOutputStream class to create write data in excel file

		FileOutputStream outputStream = new FileOutputStream(file);

		//write data in the excel file

		Workbook.write(outputStream);

		//<span style="list-style: none; float: none; cursor: pointer !important; position: relative !important; font-size: inherit !important; vertical-align: inherit !important; display: inline !important; text-align: left !important; margin: 0px !important; border-style: none none solid !important; border-color: initial !important; border-bottom-width: 1px !important; padding: 0px 0px 0.065em !important; text-decoration: underline !important; line-height: 20px;" class="intexthighlight" id="KTAdF" title="" click-setup="true">close</span> output stream

		outputStream.close();



	}


}