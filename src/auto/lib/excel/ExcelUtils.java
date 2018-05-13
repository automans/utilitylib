package auto.lib.excel;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import auto.lib.file.FileUtils;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;  
import jxl.write.WritableSheet;  
import jxl.write.WritableWorkbook;  
import jxl.write.WriteException; 

public class ExcelUtils {
	public static String PUBLIC_FILE_NAME = "";
	public static String PUBLIC_FILE_DIR = "dataTemp";
	private HSSFWorkbook wb;
	public ExcelUtils(String fileName){
		PUBLIC_FILE_NAME = FileUtils.getCurrentDir()  + "/" + PUBLIC_FILE_DIR + "/" + fileName;
	}
	
	public void fileCreate() throws IOException, WriteException{
		WritableWorkbook book = Workbook.createWorkbook(new File(PUBLIC_FILE_NAME+".xls"));  
        WritableSheet sheet = book.createSheet("文档内容",0); 
        Label label = new Label(0,0,null); 
        sheet.addCell(label);
        book.write();  
        book.close();  
	}
	public void fileCreate(String[] fileTitle) throws IOException, WriteException{
		WritableWorkbook book = Workbook.createWorkbook(new File(PUBLIC_FILE_NAME+".xls"));  
        WritableSheet sheet = book.createSheet("文档内容",0); 
        for(int i=0; i<fileTitle.length; i++){
        	Label label = new Label(i,0,fileTitle[i]); 
        	sheet.addCell(label);
        }
        book.write();  
        book.close();  
	}
	public void fileAppend(String[] str, int index) throws IOException{
		FileInputStream fs=new FileInputStream(PUBLIC_FILE_NAME+".xls");  //获取d://test.xls  
       POIFSFileSystem ps=new POIFSFileSystem(fs);  //使用POI提供的方法得到excel的信息  
        wb = new HSSFWorkbook(ps);    
        HSSFSheet sheet=wb.getSheetAt(0);  //获取到工作表，因为一个excel可能有多个工作表  
        HSSFRow row=sheet.getRow(0);  //获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值  
        System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());  //分别得到最后一行的行号，和一条记录的最后一个单元格  
          
        FileOutputStream out=new FileOutputStream(PUBLIC_FILE_NAME+".xls");  //向d://test.xls中写数据  
        row=sheet.createRow((short)(sheet.getLastRowNum()+1)); //在现有行号后追加数据  
        
        for(int i=0; i<str.length; i++){
        	row.createCell(index+i).setCellValue(str[i]); //设置第一个（从0开始）单元格的数据  
        }
        //row.createCell(1).setCellValue(24); //设置第二个（从0开始）单元格的数据  
        out.flush();  
        wb.write(out);    
        out.close();   
	}

	public ArrayList<String> fileRead(){
		ArrayList<String > alist = new ArrayList<String>();
		try{
			 File file = new File(PUBLIC_FILE_NAME+".xls");  
	         
			 Workbook book = Workbook.getWorkbook(file);  
	         Sheet sheet = book.getSheet(0);  
	         
	         int rows = sheet.getRows(); 
	         int columns = sheet.getColumns(); 
	         //String[] rowsTemp = new String[columns];
	        // HashMap alist=new HashMap();
	         for(int j=0; j<rows; j++){
	        	 for(int i=0; i<columns; i++){
	        		 Cell cell = sheet.getCell(i, j);
	        		 alist.add(cell.getContents());
	        	 }
	         }
	         
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alist;
		
	}
	 public static void main(String args[]) throws WriteException, IOException{
	        
		 	String[] a = {"fjd","jfdk","jfkjd"};
		 	ExcelUtils pfile = new ExcelUtils("test1111");
		 	//pfile.fileCreate();
		 	pfile.fileAppend(a,0);
			//System.out.println(pfile.fileRead());
	    }

}
