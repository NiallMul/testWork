package testingweek;

import java.util.List;

import org.junit.Test;

import Spreadsheet.SpreadSheetReader;

public class SpreadSheetExample {
	@Test
	public void spreadSheet() {
		SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir")+"/src/main/resources/WhiteBoxTestingTemplate.xlsx");
		
		
		for(int i =0; i<=sheetReader.getNumOfRows("Sheet1");i++) {
			List<String> row = sheetReader.readRow(i,"Sheet1");
			for(String cell:row) {
				System.out.print(cell+"________");
			}
			System.out.println("");
		}
	}
}
