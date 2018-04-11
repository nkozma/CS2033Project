package CS2033;

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

public class ExcelIO implements Iwriter, Ireader, IProcessor {
	private Workbook wb;
	private Sheet sh;
	private String path;	
	
	public ExcelIO(String inputfile, String sheetName) 
	{
		path=inputfile;
		try {
			FileInputStream excelFileIn=new FileInputStream(new File(path));
			wb=new XSSFWorkbook(excelFileIn);
			sh=wb.getSheet(sheetName);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String read(String name, String findField) 
	{
		String found;
		Row person=findRow(name);
		int column=findColumn(findField);
		if(person.getCell(column).getCellTypeEnum()==CellType.STRING) 
		{
			found=person.getCell(column).getStringCellValue();
		}
		else
		{
			found=Double.toString(person.getCell(column).getNumericCellValue());
		}
		return found;
	}
	
	public ArrayList<String> readField(String field)
	{
		ArrayList<String> columnVal=new ArrayList<String>();
		Row curRow;
		int columnIndex=findColumn(field);
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
	
	public ArrayList<String> readRow(String name)
	{
		ArrayList<String> rowValue=new ArrayList<String>();
		Row curRow=findRow(name);
		Iterator<Cell> cellIt=curRow.iterator();
		while(cellIt.hasNext())
		{
			Cell curC=cellIt.next();
			if(curC.getCellTypeEnum()==CellType.STRING)
			{
				rowValue.add(curC.getStringCellValue());
			}
			else if(curC.getCellTypeEnum()==CellType.NUMERIC)
			{
				rowValue.add(Double.toString(curC.getNumericCellValue()));
			}
		}
		return rowValue;
	}
	
	public void write(String name, String findField, String replacement) 
	{
		Row person=findRow(name);
		int column=findColumn(findField);
		person.getCell(column).setCellValue(replacement);
		updateExcel();
	}
	
	private int findColumn(String columnName)
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
	
	private Row findRow(String name)
	{
		Row row=sh.getRow(0);
		int column=findColumn("Name");
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