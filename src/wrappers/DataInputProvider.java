package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DataInputProvider {

	
	public static String[][] getSheet(String FileName, String SheetName) {

		String[][] data = null;
		int key = 0;

		if (SheetName != null) {
			key = 1;
		}

		switch (key) {
		case 1:

			FileInputStream fis = null;
			try {
				fis = new FileInputStream(new File("./TestData/" + FileName + ".xls")); 
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			HSSFWorkbook workbook = null;
			try {
				workbook = new HSSFWorkbook(fis);//System.out.println(workbook);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			HSSFSheet sheet = null;

			sheet = workbook.getSheet(SheetName);

			if (sheet == null)

			{

				break;
			} else {

				// get the number of rows
				int rowCount = sheet.getLastRowNum(); 
				
				// get the number of columns
				int columnCount = sheet.getRow(0).getLastCellNum();
				
				data = new String[rowCount][columnCount];

				for (int i = 0; i < rowCount; i++) {
					if (sheet.getRow(i) == null) {
						sheet.shiftRows(i + 1, rowCount, -1);
						i--;
						continue;
					}
					boolean isRowEmpty = false;
					for (int j = 0; j < columnCount; j++) {
						if (sheet.getRow(i).getCell(j) != null) {

							if (sheet.getRow(i).getCell(j).toString().trim().equals("")) {
								isRowEmpty = false;
							}
							
						} else {
							isRowEmpty = true;
							break;
						}
					}
					
					if (isRowEmpty == true) {
						
						sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
						rowCount = sheet.getLastRowNum();
						
						i--;
					}
				}
				

				rowCount = sheet.getLastRowNum();
				
				// get the number of columns
				columnCount = sheet.getRow(0).getLastCellNum();
				
				data = new String[rowCount][columnCount];

				// loop through the rows
				for (int i = 1; i < rowCount + 1; i++) {
					try {
						HSSFRow row = sheet.getRow(i);
						for (int j = 0; j < columnCount; j++) { // loop through
																// the columns
							try {
								String cellValue = "";
								try {
									cellValue = row.getCell(j).getStringCellValue();
								} catch (NullPointerException e) {

								}

								data[i - 1][j] = cellValue; // add to the data
															// array
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			break;

		default:
			break;
		}

		return data;

	}
}
