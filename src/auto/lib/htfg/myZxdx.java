package auto.lib.htfg;

import auto.lib.date.*;
import auto.lib.man.*;
import auto.lib.random.*;
import auto.lib.file.*;


public class myZxdx {
	
	public static String ZXDX_PUBLIC_DIR = "zxdxData";
	public static FileUtils fileHandle = new FileUtils();
	public myZxdx(){
		fileHandle = new FileUtils();
		if(!fileHandle.dirExist(ZXDX_PUBLIC_DIR))
			fileHandle.makeDir(ZXDX_PUBLIC_DIR);
	}
	public String get_serial_nbr() throws InterruptedException{Thread.sleep(10);return DateUtils.getFullDateStringNoSeparator();}
	public String get_identity_no(){return RandomUtils.getRandomNum(10);}
	public String get_app_date(){return DateUtils.getNow("yyyy/MM/dd");}
	public String get_called_num(){return RandomUtils.getRandomNum(2,6);}
	public String get_card_app_nbr(){return null;}
	public String get_card_dte_open(){return DateUtils.getNow("yyyy/MM/dd");}
	public String get_card_format_id(){return RandomUtils.getRandom("K",3);}
	public String get_card_grade(){return RandomUtils.getRandomItem("A|B|C|D|E|F|G|J|H");}
	public String get_card_nbr(){return RandomUtils.getRandomNum(12);}
	public String get_card_pdt_name(){return "卡板名称";}
	public String get_card_pdt_nbr(){return RandomUtils.getRandomItem("金卡|银卡|黑卡|普卡");}
	public String get_card_src_cde(){return RandomUtils.getRandom("G",3);}
	public String get_card_user_code(){return RandomUtils.getRandom(3);}
	public String get_crdacct_dte_open(){return DateUtils.getNow("yyyy/MM/dd");}
	public String get_crdacct_stage_amt(){return RandomUtils.getRandomNum(20000,30000);}
	public String get_crdacct_stmt_amt(){return RandomUtils.getRandomNum(5000,10000);}
	public String get_crdacct_stmt_cyc(){return DateUtils.getNow("yyyy/MM/dd");}
	public String get_CURDUE1(){return RandomUtils.getRandomNum(10000,20000);}
	public String get_CURDUE1S(){return RandomUtils.getRandomItem("+|-");}
	public String get_CURDUE2(){return RandomUtils.getRandomNum(20000,30000);}
	public String get_CUSTSEX(){return RandomUtils.getRandomItem("F|M");}
	public String get_cust_active_num(){return RandomUtils.getRandomNum(22,99);}
	public String get_cust_addr(){return "这是地址信息cust_addr";}
	public String get_cust_addr_city(){return "这是地址信息cust_addr_city"; }
	public String get_cust_cash_crlimit(){return RandomUtils.getRandomNum(30000,40000);}
	public String get_cust_cphone(){return RandomUtils.getRandom(12);}
	public String get_cust_data_type(){return RandomUtils.getRandom("K",4);}
	public String get_cust_email_addr(){return "test@qq.com";}
	public String get_cust_emp_addr(){return "这是地址信息cust_emp_addr";}
	public String get_cust_emp_name(){return ManUtils.ttkName();}
	public String get_cust_emp_phone(){return RandomUtils.getRandomPhone(0);}
	public String get_cust_eng_name(){return "engName";}
	public String get_cust_final_score(){return RandomUtils.getRandomNum(10,99);}
	public String get_cust_local_name(){return ManUtils.ttkName();}
	public String get_cust_maddr(){return "这是地址信息cust_maddr";}
	public String get_cust_perm_crlimit(){return RandomUtils.getRandomNum(20000,30000);}
	public String get_cust_sex(){return RandomUtils.getRandomItem("F|M");}
	public String get_data_grade(){return RandomUtils.getRandomItem("A|C|B|D|E|F");}
	public String get_data_type_fq(){return RandomUtils.getRandom("FQ",2);}
	public String get_DTEDUE(){return DateUtils.getNow("yyyy/MM/dd");}
	public String get_em_contact_name(){return "em名字";}
	public String get_em_contact_phone(){return RandomUtils.getRandomPhone(0);}
	public String get_ENAME(){return "eName";}
	public String get_EXT() throws InterruptedException{Thread.sleep(10);return DateUtils.getFullDateStringNoSeparator();}
	public String get_IDNBR(){return RandomUtils.getRandomNum(12);}
	public String get_lineal_cont_name(){return "Line名字";}
	public String get_lineal_cont_phone(){return RandomUtils.getRandomPhone(0);}
	public String get_packge_ind(){return "QF";}
	public String get_PERSID(){return RandomUtils.getRandomNum(18);}
	public String get_phone(){return RandomUtils.getRandomPhone(0);}
	public String get_PHONE1(){return RandomUtils.getRandomPhone(0);}
	public String get_PHONE2(){return RandomUtils.getRandomPhone(0);}
	public String get_PHONE3(){return RandomUtils.getRandomPhone(0);}
	public String get_PHONE4(){return RandomUtils.getRandomPhone(0);}
	public String get_PROJECT(){return null;}
	public String get_project_name(){return null;}
	public String get_RESERVE1(){return "RES01";}
	public String get_RESERVE10(){return "RES10";}
	public String get_RESERVE11(){return "RES11";}
	public String get_RESERVE12(){return "RES12";}
	public String get_RESERVE13(){return "RES13";}
	public String get_RESERVE14(){return "RES14";}
	public String get_RESERVE15(){return "RES15";}
	public String get_RESERVE16(){return "RES16";}
	public String get_RESERVE17(){return "RES17";}
	public String get_RESERVE18(){return "RES18";}
	public String get_RESERVE19(){return "RES19";}
	public String get_RESERVE2(){return "RES02";}
	public String get_RESERVE20(){return "RES20";}
	public String get_RESERVE21(){return "RES21";}
	public String get_RESERVE22(){return "RES22";}
	public String get_RESERVE23(){return "RES23";}
	public String get_RESERVE24(){return "RES24";}
	public String get_RESERVE25(){return "RES25";}
	public String get_RESERVE26(){return "RES26";}
	public String get_RESERVE27(){return "RES27";}
	public String get_RESERVE28(){return "RES28";}
	public String get_RESERVE29(){return "RES29";}
	public String get_RESERVE3(){return "RE03S";}
	public String get_RESERVE30(){return "RES30";}
	public String get_RESERVE4(){return "RES";}
	public String get_RESERVE5(){return "RES05";}
	public String get_RESERVE6(){return "RES06";}
	public String get_RESERVE7(){return "RES07";}
	public String get_RESERVE8(){return "RES08";}
	public String get_RESERVE9(){return "RES09";}
	public String get_respond_grade_score(){return RandomUtils.getRandomNum(22,99);}
	public String get_respond_score(){return RandomUtils.getRandomNum(22,99);}
	public String get_value_score(){return RandomUtils.getRandomNum(22,99);}
	public void fileWrite(String fileName, String str){
		fileHandle.fileWrite(str, ZXDX_PUBLIC_DIR + "/" + fileName);
	}
	public void fileAppend(String fileName, String str, boolean lineBreak){
		if(lineBreak){
			FileUtils.appendMethodB(ZXDX_PUBLIC_DIR + "/" + fileName, str+"\n");
		}else{
			FileUtils.appendMethodB(ZXDX_PUBLIC_DIR + "/" + fileName, str);
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		
		myZxdx zxdx = new myZxdx();
//		System.out.println(zxdx.get_app_date());
//		zxdx.fileAppend("test.txt", "heldddll",false);
//		
		System.out.println(zxdx.get_app_date());
//		System.out.println(zxdx.get_called_num());
//		System.out.println(zxdx.get_card_app_nbr());
//		System.out.println(zxdx.get_card_dte_open());
//		System.out.println(zxdx.get_card_format_id());
//		System.out.println(zxdx.get_card_grade());
//		System.out.println(zxdx.get_card_nbr());
//		System.out.println(zxdx.get_card_pdt_name());
//		System.out.println(zxdx.get_card_pdt_nbr());
//		System.out.println(zxdx.get_card_src_cde());
//		System.out.println(zxdx.get_card_user_code());
//		System.out.println(zxdx.get_crdacct_dte_open());
//		System.out.println(zxdx.get_crdacct_stage_amt());
//		System.out.println(zxdx.get_crdacct_stmt_amt());
//		System.out.println(zxdx.get_crdacct_stmt_cyc());
//		System.out.println(zxdx.get_CURDUE1());
//		System.out.println(zxdx.get_CURDUE1S());
//		System.out.println(zxdx.get_CURDUE2());
//		System.out.println(zxdx.get_CUSTSEX());
//		System.out.println(zxdx.get_cust_active_num());
//		System.out.println(zxdx.get_cust_addr());
//		System.out.println(zxdx.get_cust_addr_city());
//		System.out.println(zxdx.get_cust_cash_crlimit());
//		System.out.println(zxdx.get_cust_cphone());
//		System.out.println(zxdx.get_cust_data_type());
//		System.out.println(zxdx.get_cust_email_addr());
//		System.out.println(zxdx.get_cust_emp_addr());
//		System.out.println(zxdx.get_cust_emp_name());
//		System.out.println(zxdx.get_cust_emp_phone());
//		System.out.println(zxdx.get_cust_eng_name());
//		System.out.println(zxdx.get_cust_final_score());
//		System.out.println(zxdx.get_cust_local_name());
//		System.out.println(zxdx.get_cust_maddr());
//		System.out.println(zxdx.get_cust_perm_crlimit());
//		System.out.println(zxdx.get_cust_sex());
//		System.out.println(zxdx.get_data_grade());
//		System.out.println(zxdx.get_data_type_fq());
//		System.out.println(zxdx.get_DTEDUE());
//		System.out.println(zxdx.get_em_contact_name());
//		System.out.println(zxdx.get_em_contact_phone());
//		System.out.println(zxdx.get_ENAME());
//		System.out.println(zxdx.get_EXT());
//		System.out.println(zxdx.get_identity_no());
//		System.out.println(zxdx.get_IDNBR());
//		System.out.println(zxdx.get_lineal_cont_name());
//		System.out.println(zxdx.get_lineal_cont_phone());
//		System.out.println(zxdx.get_packge_ind());
//		System.out.println(zxdx.get_PERSID());
//		System.out.println(zxdx.get_phone());
//		System.out.println(zxdx.get_PHONE1());
//		System.out.println(zxdx.get_PHONE2());
//		System.out.println(zxdx.get_PHONE3());
//		System.out.println(zxdx.get_PHONE4());
//		System.out.println(zxdx.get_PROJECT());
//		System.out.println(zxdx.get_project_name());
//		System.out.println(zxdx.get_RESERVE1());
//		System.out.println(zxdx.get_RESERVE10());
//		System.out.println(zxdx.get_RESERVE11());
//		System.out.println(zxdx.get_RESERVE12());
//		System.out.println(zxdx.get_RESERVE13());
//		System.out.println(zxdx.get_RESERVE14());
//		System.out.println(zxdx.get_RESERVE15());
//		System.out.println(zxdx.get_RESERVE16());
//		System.out.println(zxdx.get_RESERVE17());
//		System.out.println(zxdx.get_RESERVE18());
//		System.out.println(zxdx.get_RESERVE19());
//		System.out.println(zxdx.get_RESERVE2());
//		System.out.println(zxdx.get_RESERVE20());
//		System.out.println(zxdx.get_RESERVE21());
//		System.out.println(zxdx.get_RESERVE22());
//		System.out.println(zxdx.get_RESERVE23());
//		System.out.println(zxdx.get_RESERVE24());
//		System.out.println(zxdx.get_RESERVE25());
//		System.out.println(zxdx.get_RESERVE26());
//		System.out.println(zxdx.get_RESERVE27());
//		System.out.println(zxdx.get_RESERVE28());
//		System.out.println(zxdx.get_RESERVE29());
//		System.out.println(zxdx.get_RESERVE3());
//		System.out.println(zxdx.get_RESERVE30());
//		System.out.println(zxdx.get_RESERVE4());
//		System.out.println(zxdx.get_RESERVE5());
//		System.out.println(zxdx.get_RESERVE6());
//		System.out.println(zxdx.get_RESERVE7());
//		System.out.println(zxdx.get_RESERVE8());
//		System.out.println(zxdx.get_RESERVE9());
//		System.out.println(zxdx.get_respond_grade_score());
//		System.out.println(zxdx.get_respond_score());
//		System.out.println(zxdx.get_value_score());
	}
}


