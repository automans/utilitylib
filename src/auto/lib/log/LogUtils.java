package auto.lib.log;

import auto.lib.date.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class LogUtils {
	public static String LOG_DIR = "logTemp";
	public static String LOG_FILE_NAME = DateUtils.getNow("yyyy-MM-dd") + ".txt";
	
	public LogUtils(){
		//System.out.println(getCurrentDir());
		makeBaseDir(LOG_DIR);
	}
	
	public static String getCurrentDir(){
    	return System.getProperty("user.dir"); 
    }
	public static void makeBaseDir(String dirName){
    	File file =new File(getCurrentDir() +  "/" + dirName);
    	if(!file.exists())  
    	{     
    	    file.mkdir();   
    	}
    }
	public static void fileWrite(String str, String fileName){
    	// ���ļ�д������(�����)  
    	 File file = new File(getCurrentDir()  + "/" +  LOG_DIR + "/" + fileName); 
    	 
		 try {  
		     file.createNewFile(); // �����ļ�  
		 } catch (IOException e) {  
		     // TODO Auto-generated catch block  
		     e.printStackTrace();  
		 }  
        byte bt[] = new byte[1024];  
        bt = str.getBytes();  
        try {  
            FileOutputStream in = new FileOutputStream(file);  
            try {  
                in.write(bt, 0, bt.length);  
                in.close();  
                // boolean success=true;  
                // System.out.println("д���ļ��ɹ�");  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }
	public static void fileAppend(String str, String fileName){
		 try {
	            //��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
	        FileWriter writer = new FileWriter(getCurrentDir()  + "/" +  LOG_DIR + "/" + fileName, true);
	        writer.write(str+"\n");
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void log(String str){
		String suffix_default = DateUtils.getNow("[yyyy-MM-dd HH:mm:ss.SSS]")+"[DEBUG]";
		fileAppend(suffix_default + str, LOG_FILE_NAME);
	}
	public static void log(String str, String type){
		switch(type){
		case "dump":
			String suffix_dump1 = DateUtils.getNow("[yyyy-MM-dd HH:mm:ss.SSS]")+"[DUMP-Start]";
			String suffix_dump2 = DateUtils.getNow("[yyyy-MM-dd HH:mm:ss.SSS]")+"[DUMP-End]";
			fileAppend(suffix_dump1 + "\n" + str + "\n" + suffix_dump2, LOG_FILE_NAME);
			break;
		case "error":
			String suffix_error = DateUtils.getNow("[yyyy-MM-dd HH:mm:ss.SSS]")+"[ERROR]";
			fileAppend(suffix_error + str, LOG_FILE_NAME);
			break;
		case "info":
			String suffix_info = DateUtils.getNow("[yyyy-MM-dd HH:mm:ss.SSS]")+"[INFO]";
			fileAppend(suffix_info + str, LOG_FILE_NAME);
			break;
		case "warning":
			String suffix_warning = DateUtils.getNow("[yyyy-MM-dd HH:mm:ss.SSS]")+"[WARNING]";
			fileAppend(suffix_warning + str, LOG_FILE_NAME);
			break;
		default:
			String suffix_default = DateUtils.getNow("[yyyy-MM-dd HH:mm:ss.SSS]")+"[DEBUG]";
			fileAppend(suffix_default + str, LOG_FILE_NAME);
			break;
		}
		
	}
	public void info(String str){
		log(str,"info");
	}
	public void err(String str){
		log(str,"error");
	}
	public void dump(String str){
		log(str,"dump");
	}
	public void debug(String str){
		log(str, "debug");
	}
	public void warn(String str){
		log(str, "warning");
	}
	public static void main(String[] args){ 
		LogUtils pl = new LogUtils();
		pl.info("This is info...");
		pl.err("this is error...");
		pl.dump("fjeifjiejfeijfiejfiejfijief");
		pl.debug("this is debug...");
		pl.warn("this is warning....");
	}
}
