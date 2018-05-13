package auto.lib.htfg;

import java.io.IOException;

import auto.lib.date.DateUtils;
import auto.lib.excel.ExcelUtils;
import auto.lib.file.FileUtils;
import auto.lib.man.ManUtils;
import auto.lib.random.RandomUtils;
import jxl.write.WriteException;

public class myJHDX {
	public static String JHDX_PUBLIC_DIR = "jhdxData";
	public static String[] fileTitle = {"客户编号","账单日","卡号(后4位)","账单金额","可分期金额","到期还款日","新老客户","姓名","手机号码","性别","年龄区间","卡等级","额度区间","营销活动"};
	public static FileUtils fileHandle = new FileUtils();
	public static String JHDX_PUBLIC_FILE = "";
	public myJHDX(){
		fileHandle = new FileUtils();
		if(!fileHandle.dirExist(JHDX_PUBLIC_DIR))
			fileHandle.makeDir(JHDX_PUBLIC_DIR);
	}
	
	public String get_cust_id(String prefix)
	{
		try{
			Thread.sleep(10);
		}catch (InterruptedException e) {  
            e.printStackTrace();  
        }
		return prefix+DateUtils.getFullDateStringNoSeparator();
	}
	
	public String get_bill_date(int n){
		String dateTemp = DateUtils.getFutureDateByDays(n);
		String str[] = dateTemp.substring(0, 10).split("-");
		String month = "";
		if(str.length==3){
			switch(str[1]){
			case "01":
				month = "JAN";break;
			case "02":
				month = "FEB";break;
			case "03":
				month = "FEB";break;
			case "04":
				month = "APR";break;
			case "05":
				month = "MAY";break;
			case "06":
				month = "JUN";break;
			case "07":
				month = "JUL";break;
			case "08":
				month = "AUG";break;
			case "09":
				month = "SEP";break;
			case "10":
				month = "OCT";break;
			case "11":
				month = "NOV";break;
			case "12":
				month = "DEC";break;
			}
			return str[2]+month+str[0];
		}else{
			return null;
		}
	}
	public String get_card_num(int n){
		return RandomUtils.getRandom(n);
	}
	
	public String get_bill_amount(){
		return RandomUtils.getRandomNum(30000.00,50000.99);
	}
	
	public String get_stage_amount(){
		return RandomUtils.getRandomNum(10000.00,30000.00);
	}
	public String get_due_date(int n){
		String dateTemp = DateUtils.getFutureDateByDays(n);
		String str[] = dateTemp.substring(0, 10).split("-");
		String month = "";
		if(str.length==3){
			switch(str[1]){
			case "01":
				month = "JAN";break;
			case "02":
				month = "FEB";break;
			case "03":
				month = "FEB";break;
			case "04":
				month = "APR";break;
			case "05":
				month = "MAY";break;
			case "06":
				month = "JUN";break;
			case "07":
				month = "JUL";break;
			case "08":
				month = "AUG";break;
			case "09":
				month = "SEP";break;
			case "10":
				month = "OCT";break;
			case "11":
				month = "NOV";break;
			case "12":
				month = "DEC";break;
			}
			return str[2]+month+str[0];
		}else{
			return null;
		}
	}
	public String get_is_old_cust(){
		return RandomUtils.getRandomItem("1|0");
	}
	public String get_cust_name(){
		return ManUtils.ttkName();
	}
	public String get_phone(){
		return RandomUtils.getRandomPhone(0);
	}
	public String get_sex(){
		return RandomUtils.getRandomItem("01|02");
	}
	public String get_age_range(){
		return RandomUtils.getRandomItem("30|40|50|60|70|80|90|00|10");
	}
	public String get_card_grade(){
		return RandomUtils.getRandomItem("1级|2级|3级|其他");
	}
	public String get_limit_amount(){
		//return RandomUtils.getRandomNum(50000,80000);
		return RandomUtils.getRandomItem(
				"50000.00|55000.00|58000.00|64000.00|68000.00|71000.00|78000.00|79000.00|83000.00"
				);
	}
	public String get_sale_event(){
		return RandomUtils.getRandomItem(
				"银联话费30元|VISA返现30元|Master返现30元|JCB返现30元|银联话费30元|VISA返现30元|VISA返现30元|Master返现30元|JCB返现30元"
				);
	}
	
	public void fileWrite(String[] str){
		try{
			ExcelUtils pfile = new ExcelUtils(JHDX_PUBLIC_DIR + "/" + JHDX_PUBLIC_FILE);
			pfile.fileAppend(str,0);
		}catch(IOException e){
			e.printStackTrace(); 
		}
	}
	
	public void fileCreate(String fileName){
		try{
			ExcelUtils pfile = new ExcelUtils(JHDX_PUBLIC_DIR + "/" + fileName);
			JHDX_PUBLIC_FILE = fileName;
			pfile.fileCreate(fileTitle);
		}catch(WriteException e){
			e.printStackTrace(); 
		}catch(IOException e){
			e.printStackTrace(); 
		}
	}
	public static void main(String[] args) throws InterruptedException {
			
//		myJHDX jhdx = new myJHDX();
//		System.out.println(jhdx.get_bill_date(30));
//		jhdx.fileCreate("test");
//		String[] caseInfo = new String[14];
//		for(int i=0; i<10000;i++){
//			caseInfo[0] = jhdx.get_cust_id("CN");
//			caseInfo[1] = jhdx.get_bill_date(40);
//			caseInfo[2]= jhdx.get_card_num(4);
//			caseInfo[3] = jhdx.get_bill_amount();
//			caseInfo[4] = jhdx.get_stage_amount();
//			caseInfo[5] = jhdx.get_due_date(55);
//			caseInfo[6] = jhdx.get_is_old_cust();
//			caseInfo[7] = jhdx.get_cust_name();
//			caseInfo[8] = jhdx.get_phone();
//			caseInfo[9] = jhdx.get_sex();
//			caseInfo[10] = jhdx.get_age_range();
//			caseInfo[11] = jhdx.get_card_grade();
//			caseInfo[12] = jhdx.get_limit_amount();
//			caseInfo[13] = jhdx.get_sale_event();
//			jhdx.fileWrite(caseInfo);
//		}
	}
}
