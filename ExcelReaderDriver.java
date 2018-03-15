package reader;

import java.util.ArrayList;

public class ExcelReaderDriver {
	public static void main(String[] args) {
		ExcelManip readTest=new ExcelManip("data/TestSheet.xlsx");
		readTest.printSheet("Sheet1");
		System.out.println();
		ArrayList<String> testColumn=readTest.ReadColumn("Sheet1","Score");
		for(int i=0; i<testColumn.size(); i++)
		{
			System.out.println(testColumn.get(i));
		}
		
		System.out.println();
		
		readTest.updateField("Sheet1","Nick","Name","Nick Kozma");
		readTest.updateField("Sheet1", "Nick Kozma", "Score", "70.0");
		readTest.printSheet("Sheet1");
		
		System.out.println();
		
		readTest.updateField("Sheet1","Nick Kozma","Name","Nick");
		readTest.updateField("Sheet1", "Nick", "Score", "700.0");
		readTest.printSheet("Sheet1");
		
	}
}