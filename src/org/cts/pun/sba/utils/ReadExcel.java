package org.cts.pun.sba.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.log4testng.Logger;

public class ReadExcel {

	private FileInputStream fis;
	private final static Logger logger = Logger.getLogger(ReadExcel.class);
	private XSSFWorkbook wb;

	public ReadExcel(String fileName) {
		try {
			fis = new FileInputStream(Constants.datafilesPath + "/" + fileName + ".xlsx");
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			logger.warn("Data excel not found!!!!");
		}
	}

	public HashMap<String, String> readExcel() {
		HashMap<String, String> input = new HashMap<String, String>();
		XSSFSheet sh = wb.getSheetAt(0);
		int colCount = sh.getRow(0).getLastCellNum();
		for (int i = 0; i < colCount; i++) {
			input.put(sh.getRow(0).getCell(i).getStringCellValue(), sh.getRow(1).getCell(i).getStringCellValue());
		}
		return input;
	}

}
