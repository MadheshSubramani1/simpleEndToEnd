package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

	

	public String[][] getExcelData(String sheetName) throws BiffException, IOException {

		FileInputStream fileInputStream = new FileInputStream("./Excel.xls");
		Workbook workbook = Workbook.getWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		String[][] testData = new String[rowCount - 1][columnCount];

		for (int i = 1; i < rowCount; i++) {

			for (int j = 0; j < columnCount; j++) {

				testData[i - 1][j] = sheet.getCell(j, i).getContents();
			}
		}

		return testData;
	}


}
