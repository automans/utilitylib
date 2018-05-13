package auto.lib.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


import auto.lib.string.*;

public class FileUtils {
	public static String FILE_PATH_PUBLIC = "dataTemp";
	
	public FileUtils(){
		//System.out.println(getCurrentDir());
		makeBaseDir(FILE_PATH_PUBLIC);
	}
	/** 
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。 
     *  
     * @param fileName 
     *            文件的名 
     */  
    public static void readFileByBytes(String fileName) {  
        File file = new File(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName);  
        InputStream in = null;  
        try {  
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");  
            // 一次读一个字节  
            in = new FileInputStream(file);  
            int tempbyte;  
            while ((tempbyte = in.read()) != -1) {  
                System.out.write(tempbyte);  
            }  
            in.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
            return;  
        }  
        try {  
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");  
            // 一次读多个字节  
            byte[] tempbytes = new byte[100];  
            int byteread = 0;  
            in = new FileInputStream(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName);  
            FileUtils.showAvailableBytes(in);  
            // 读入多个字节到字节数组中，byteread为一次读入的字节数  
            while ((byteread = in.read(tempbytes)) != -1) {  
                System.out.write(tempbytes, 0, byteread);  
            }  
        } catch (Exception e1) {  
            e1.printStackTrace();  
        } finally {  
            if (in != null) {  
                try {  
                    in.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
  
    /** 
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件 
     *  
     * @param fileName 
     *            文件名 
     */  
    public static void readFileByChars(String fileName) {  
        File file = new File(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName);  
        Reader reader = null;  
        try {  
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");  
            // 一次读一个字符  
            reader = new InputStreamReader(new FileInputStream(file));  
            int tempchar;  
            while ((tempchar = reader.read()) != -1) {  
                // 对于windows下，rn这两个字符在一起时，表示一个换行。  
                // 但如果这两个字符分开显示时，会换两次行。  
                // 因此，屏蔽掉r，或者屏蔽n。否则，将会多出很多空行。  
                if (((char) tempchar) != 'r') {  
                    System.out.print((char) tempchar);  
                }  
            }  
            reader.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        try {  
            System.out.println("以字符为单位读取文件内容，一次读多个字节：");  
            // 一次读多个字符  
            char[] tempchars = new char[30];  
            int charread = 0;  
            reader = new InputStreamReader(new FileInputStream(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName));  
            // 读入多个字符到字符数组中，charread为一次读取字符数  
            while ((charread = reader.read(tempchars)) != -1) {  
                // 同样屏蔽掉r不显示  
                if ((charread == tempchars.length)  
                        && (tempchars[tempchars.length - 1] != 'r')) {  
                    System.out.print(tempchars);  
                } else {  
                    for (int i = 0; i < charread; i++) {  
                        if (tempchars[i] == 'r') {  
                            continue;  
                        } else {  
                            System.out.print(tempchars[i]);  
                        }  
                    }  
                }  
            }  
        } catch (Exception e1) {  
            e1.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
  
    /** 
     * 以行为单位读取文件，常用于读面向行的格式化文件 
     *  
     * @param fileName 
     *            文件名 
     */  
    public static void readFileByLines(String fileName) {  
        File file = new File(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName);  
        BufferedReader reader = null;  
        try {  
            System.out.println("以行为单位读取文件内容，一次读一整行：");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
                System.out.println("line " + line + ": " + tempString);  
                line++;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
  
    
    /** 
     * 随机读取文件内容 
     *  
     * @param fileName 
     *            文件名 
     */  
    public static void readFileByRandomAccess(String fileName) {  
        RandomAccessFile randomFile = null;  
        try {  
            System.out.println("随机读取一段文件内容：");  
            // 打开一个随机访问文件流，按只读方式  
            randomFile = new RandomAccessFile(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName, "r");  
            // 文件长度，字节数  
            long fileLength = randomFile.length();  
            // 读文件的起始位置  
            int beginIndex = (fileLength > 4) ? 4 : 0;  
            // 将读文件的开始位置移到beginIndex位置。  
            randomFile.seek(beginIndex);  
            byte[] bytes = new byte[10];  
            int byteread = 0;  
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。  
            // 将一次读取的字节数赋给byteread  
            while ((byteread = randomFile.read(bytes)) != -1) {  
                System.out.write(bytes, 0, byteread);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (randomFile != null) {  
                try {  
                    randomFile.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
  
    /** 
     * 显示输入流中还剩的字节数 
     *  
     * @param in 
     */  
    private static void showAvailableBytes(InputStream in) {  
        try {  
            System.out.println("当前字节输入流中的字节数为:" + in.available());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    } 
    
    /** 
     * A方法追加文件：使用RandomAccessFile 
     *  
     * @param fileName 
     *            文件名 
     * @param content 
     *            追加的内容 
     */  
    public static void appendMethodA(String fileName, String content) {  
        try {  
            // 打开一个随机访问文件流，按读写方式  
            RandomAccessFile randomFile = new RandomAccessFile(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName, "rw");  
            // 文件长度，字节数  
            long fileLength = randomFile.length();  
            // 将写文件指针移到文件尾。  
            randomFile.seek(fileLength); 
            randomFile.writeBytes(content);  
            randomFile.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * B方法追加文件：使用FileWriter 
     *  
     * @param fileName 
     * @param content 
     */  
    public static void appendMethodB(String fileName, String content) {  
        try {  
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件  
            FileWriter writer = new FileWriter(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName, true);  
            writer.write(content);  
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    
    /**
     * ArrayList<String> aa = fileRead("test.txt");
     * for(int i = 0; i < aa.size(); i++){
    		System.out.println((String)aa.get(i));
    	}
     * @param fileName
     * @return
     */
    public  ArrayList<String> fileRead(String fileName){
    	ArrayList<String > alist = new ArrayList<String>();

    	File file = new File(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName);  
        BufferedReader reader = null;  
        try {  
            //System.out.println("以行为单位读取文件内容，一次读一整行：");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
                System.out.println("line " + line + ": " + tempString); 
                alist.add(tempString);
                line++;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }
		return alist;  
    }
    public  String fileReadByFirstLine(String fileName){
    	File file = new File(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName);  
        BufferedReader reader = null;  
        String firstList = null;
        try {  
            //System.out.println("以行为单位读取文件内容，一次读一整行：");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
                System.out.println("line " + line + ": " + tempString); 
                if(!tempString.isEmpty()){
                	firstList = tempString;
                	break;
                }
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }
		return firstList;  
    }
    public  void fileWrite(String str, String fileName){
    	// 向文件写入内容(输出流)  
    	 File file = new File(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName); 
		 try {  
		     file.createNewFile(); // 创建文件  
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
                // System.out.println("写入文件成功");  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }
    
    public static void makeBaseDir(String dirName){
    	File file =new File(getCurrentDir() + "/" + dirName);
    	if(!file.exists())  
    	{     
    	    file.mkdir();   
    	}
    }
    public  boolean dirExist(String dirName){
    	File file =new File(dirName);    
    	//如果文件夹不存在则创建    
    	if  (!file.exists() && !file.isDirectory())      
    	{       
    		return false;
    	} else   
    	{  
    	    return true; 
    	}  
    }
    public  void makeDir(String dirName){
    	File file =new File(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + dirName);
    	if(!file.exists())  
    	{     
    	    file.mkdir();   
    	} 
    }
    public void touchFile(String fileName){
    	File file=new File(getCurrentDir() + "/" + FILE_PATH_PUBLIC + "/" + fileName);   
        if(!file.exists())   
        {   
            try {   
                file.createNewFile();   
            } catch (IOException e) {   
                // TODO Auto-generated catch block   
                e.printStackTrace();   
            }   
        }  
    }
    public void fileDelete(String fileName){
    	File file=new File(getCurrentDir() + "/" + FILE_PATH_PUBLIC + "/" + fileName); 
    	if(file.exists()){
    		file.delete();
    	}
    		
    }
    public static String getCurrentDir(){
//    	File directory = new File("");//参数为空 
//    	String courseFile = directory.getCanonicalPath() ; 
//    	return courseFile; 
    	return System.getProperty("user.dir"); 
    }
    
    public static String fileCompare(String fileName1, String fileName2){
    	FileUtils pFile = new FileUtils();
    	ArrayList<String> tms_batch = pFile.fileRead(fileName1);
    	ArrayList<String> tms_batch_back = pFile.fileRead(fileName2);

    	HashMap<String , String> map1 = new HashMap<String , String>(); 
    	HashMap<String , String> map2 = new HashMap<String , String>(); 
    	for(int i = 0; i < tms_batch.size(); i++){
    		String[] column_array1 = StringUtils.strSplit((String)tms_batch.get(i), "	");
    		//if(!column_array1[0].isEmpty() && !column_array1[1].isEmpty())
    			map1.put(column_array1[0], column_array1[1]);
    	}
    	for(int j = 0; j < tms_batch_back.size(); j++){
    		String[] column_array2 = StringUtils.strSplit((String)tms_batch_back.get(j), "	");
    		map2.put(column_array2[0], column_array2[1]);
    	}

    	for (Entry<String, String> entry : map1.entrySet()) {
    		if(map2.get(entry.getKey()).isEmpty()){
    			return "The key("+entry.getKey()+") not found in $table_back$!";
    		}
    		if(!entry.getValue().equals(map2.get(entry.getKey()))){
    			return "The key("+entry.getKey()+") is not match! master:"+entry.getValue()+"<>slaver:"+map2.get(entry.getKey());
    		}
    	}
    	return "true";
    }
    
 
    public static void main(String[] args){ 
    	//String test = "fjkdkjfdkjfkdjfkdjfkjdf";
//    	FileUtils pFile = new FileUtils();
//    	ArrayList<String> tms_batch = pFile.fileRead("tms_batch.desc");
//    	ArrayList<String> tms_batch_back = pFile.fileRead("tms_batch_back.desc");
//
//    	HashMap<String , String> map1 = new HashMap<String , String>(); 
//    	HashMap<String , String> map2 = new HashMap<String , String>(); 
//    	for(int i = 0; i < tms_batch.size(); i++){
//    		String[] column_array1 = StringUtils.strSplit((String)tms_batch.get(i), "	");
//    		map1.put(column_array1[0], column_array1[1]);
//    	}
//    	for(int j = 0; j < tms_batch_back.size(); j++){
//    		String[] column_array2 = StringUtils.strSplit((String)tms_batch_back.get(j), "	");
//    		map2.put(column_array2[0], column_array2[1]);
//    	}
//
//    	for (Entry<String, String> entry : map1.entrySet()) {
//    		if(entry.getValue().equals(map2.get(entry.getKey()))){
//    			System.out.println(entry.getKey() + " is ok!");
//    		}else{
//    			System.out.println(entry.getKey() + " is false!");
//    		}
//    		//System.out.println(entry.getKey() + "=>" + entry.getValue());
//    		//System.out.println(map2.get(entry.getKey()));
//    	}
    	
    	
    	//System.out.println(fileCompare("tms_batch.desc","tms_batch_back.desc"));
    	
//    	System.out.println(getCurrentDir());
//    	FileUtils a = new FileUtils();
//    	
//    	a.touchFile("fdeeeeef.txt");
    	
    	//FileUtils pFile = new FileUtils();
    	//String aaaa = pFile.fileReadByFirstLine("zxdx_record_last_id.txt");
    	//FileUtils.appendMethodA("text.txt", "年活动的懂得");
    	//FileUtils.appendMethodA("text.txt","\n");

    }
}
