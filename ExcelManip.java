package reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManip {
	private Workbook wb;
	private String path;
	
	public ExcelManip(String inputfile)
	{
		path=inputfile;
		try {
			FileInputStream excelFileIn=new FileInputStream(new File(path));
			wb=new XSSFWorkbook(excelFileIn);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void printSheet(String sheetName)
	{
		Sheet balances=wb.getSheet(sheetName);
		Iterator<Row> it=balances.iterator();
		
		while(it.hasNext())
		{
			Row currentRow=it.next();
			Iterator<Cell> cellIt=currentRow.iterator();
			while(cellIt.hasNext())
			{
				Cell curC=cellIt.next();
				if(curC.getCellTypeEnum()==CellType.STRING)
				{
					System.out.print(curC.getStringCellValue()+" , ");
				}
				else if(curC.getCellTypeEnum()==CellType.NUMERIC)
				{
					System.out.print(curC.getNumericCellValue()+" , ");
				}
			}
			System.out.println();
		}
	}
	
	public ArrayList<String> ReadColumn( String sheetName, String columnName)
	{
		ArrayList<String> columnVal=new ArrayList<String>();
		Sheet sh=wb.getSheet(sheetName);
		Row curRow;
		int columnIndex=findColumn(sh, columnName);
		if(columnIndex>=0) {
		Iterator<Row> rowIt=sh.iterator();
		
		while(rowIt.hasNext())
		{
			curRow=rowIt.next();
			
			if(curRow.getCell(columnIndex).getCellTypeEnum()==CellType.STRING) 
			{
			columnVal.add(curRow.getCell(columnIndex).getStringCellValue());
			}
			else if(curRow.getCell(columnIndex).getCellTypeEnum()==CellType.NUMERIC)
			{
				columnVal.add(Double.toString(curRow.getCell(columnIndex).getNumericCellValue()));
			}
			}
		}
		return columnVal;
	}
	
	public void updateField(String sheetName ,String name, String findField ,String replacement) 
	{
		Sheet sh= wb.getSheet(sheetName);
		Row person=findRow(sh ,name);
		int column=findColumn(sh, findField);
		person.getCell(column).setCellValue(replacement);
		updateExcel();
	}
	
	private int findColumn(Sheet sh, String columnName)
	{
		int columnIndex=0;
		int foundFlag=0;
		Cell curCell;
		Iterator<Cell> cellIt=sh.getRow(0).iterator();
		
		while(cellIt.hasNext())
		{
			curCell=cellIt.next();
			if(curCell.getCellTypeEnum()==CellType.STRING&&columnName.equals(curCell.getStringCellValue()))
			{
				foundFlag=1;
				break;
			}
			columnIndex++;
		}
		if (foundFlag==0)
		{
			columnIndex=-500;
		}
		return columnIndex;
	}
	
	private Row findRow(Sheet sh,String name)
	{
		Row row=sh.getRow(0);
		int column=findColumn(sh, "Name");
		if(column>=0) {
			Iterator<Row> rowIt=sh.iterator();
			while(rowIt.hasNext())
			{
				row=rowIt.next();
				if(name.equals(row.getCell(column).getStringCellValue()))
				{
					break;
				}
			}
			}
		return row;
	}
	
	private void updateExcel()
	{try {
	FileOutputStream ExcelOut=new FileOutputStream(new File(path));
	wb.write(ExcelOut);
	ExcelOut.close();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	}
}