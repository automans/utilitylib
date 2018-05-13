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
     * ���ֽ�Ϊ��λ��ȡ�ļ��������ڶ��������ļ�����ͼƬ��������Ӱ����ļ��� 
     *  
     * @param fileName 
     *            �ļ����� 
     */  
    public static void readFileByBytes(String fileName) {  
        File file = new File(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName);  
        InputStream in = null;  
        try {  
            System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");  
            // һ�ζ�һ���ֽ�  
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
            System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�����ֽڣ�");  
            // һ�ζ�����ֽ�  
            byte[] tempbytes = new byte[100];  
            int byteread = 0;  
            in = new FileInputStream(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName);  
            FileUtils.showAvailableBytes(in);  
            // �������ֽڵ��ֽ������У�bytereadΪһ�ζ�����ֽ���  
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
     * ���ַ�Ϊ��λ��ȡ�ļ��������ڶ��ı������ֵ����͵��ļ� 
     *  
     * @param fileName 
     *            �ļ��� 
     */  
    public static void readFileByChars(String fileName) {  
        File file = new File(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName);  
        Reader reader = null;  
        try {  
            System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");  
            // һ�ζ�һ���ַ�  
            reader = new InputStreamReader(new FileInputStream(file));  
            int tempchar;  
            while ((tempchar = reader.read()) != -1) {  
                // ����windows�£�rn�������ַ���һ��ʱ����ʾһ�����С�  
                // ������������ַ��ֿ���ʾʱ���ỻ�����С�  
                // ��ˣ����ε�r����������n�����򣬽������ܶ���С�  
                if (((char) tempchar) != 'r') {  
                    System.out.print((char) tempchar);  
                }  
            }  
            reader.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        try {  
            System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�����ֽڣ�");  
            // һ�ζ�����ַ�  
            char[] tempchars = new char[30];  
            int charread = 0;  
            reader = new InputStreamReader(new FileInputStream(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName));  
            // �������ַ����ַ������У�charreadΪһ�ζ�ȡ�ַ���  
            while ((charread = reader.read(tempchars)) != -1) {  
                // ͬ�����ε�r����ʾ  
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
     * ����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ� 
     *  
     * @param fileName 
     *            �ļ��� 
     */  
    public static void readFileByLines(String fileName) {  
        File file = new File(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName);  
        BufferedReader reader = null;  
        try {  
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
            while ((tempString = reader.readLine()) != null) {  
                // ��ʾ�к�  
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
     * �����ȡ�ļ����� 
     *  
     * @param fileName 
     *            �ļ��� 
     */  
    public static void readFileByRandomAccess(String fileName) {  
        RandomAccessFile randomFile = null;  
        try {  
            System.out.println("�����ȡһ���ļ����ݣ�");  
            // ��һ����������ļ�������ֻ����ʽ  
            randomFile = new RandomAccessFile(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName, "r");  
            // �ļ����ȣ��ֽ���  
            long fileLength = randomFile.length();  
            // ���ļ�����ʼλ��  
            int beginIndex = (fileLength > 4) ? 4 : 0;  
            // �����ļ��Ŀ�ʼλ���Ƶ�beginIndexλ�á�  
            randomFile.seek(beginIndex);  
            byte[] bytes = new byte[10];  
            int byteread = 0;  
            // һ�ζ�10���ֽڣ�����ļ����ݲ���10���ֽڣ����ʣ�µ��ֽڡ�  
            // ��һ�ζ�ȡ���ֽ�������byteread  
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
     * ��ʾ�������л�ʣ���ֽ��� 
     *  
     * @param in 
     */  
    private static void showAvailableBytes(InputStream in) {  
        try {  
            System.out.println("��ǰ�ֽ��������е��ֽ���Ϊ:" + in.available());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    } 
    
    /** 
     * A����׷���ļ���ʹ��RandomAccessFile 
     *  
     * @param fileName 
     *            �ļ��� 
     * @param content 
     *            ׷�ӵ����� 
     */  
    public static void appendMethodA(String fileName, String content) {  
        try {  
            // ��һ����������ļ���������д��ʽ  
            RandomAccessFile randomFile = new RandomAccessFile(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName, "rw");  
            // �ļ����ȣ��ֽ���  
            long fileLength = randomFile.length();  
            // ��д�ļ�ָ���Ƶ��ļ�β��  
            randomFile.seek(fileLength); 
            randomFile.writeBytes(content);  
            randomFile.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * B����׷���ļ���ʹ��FileWriter 
     *  
     * @param fileName 
     * @param content 
     */  
    public static void appendMethodB(String fileName, String content) {  
        try {  
            // ��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�  
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
            //System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
            while ((tempString = reader.readLine()) != null) {  
                // ��ʾ�к�  
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
            //System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
            while ((tempString = reader.readLine()) != null) {  
                // ��ʾ�к�  
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
    	// ���ļ�д������(�����)  
    	 File file = new File(getCurrentDir()  + "/" +  FILE_PATH_PUBLIC + "/" + fileName); 
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
    
    public static void makeBaseDir(String dirName){
    	File file =new File(getCurrentDir() + "/" + dirName);
    	if(!file.exists())  
    	{     
    	    file.mkdir();   
    	}
    }
    public  boolean dirExist(String dirName){
    	File file =new File(dirName);    
    	//����ļ��в������򴴽�    
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
//    	File directory = new File("");//����Ϊ�� 
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
    	//FileUtils.appendMethodA("text.txt", "���Ķ���");
    	//FileUtils.appendMethodA("text.txt","\n");

    }
}
