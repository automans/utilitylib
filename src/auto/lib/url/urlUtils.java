package auto.lib.url;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;  

public class urlUtils {
	
	
	public static String isKeyWordExist(String url, String keyword) throws UnsupportedEncodingException, MalformedURLException, IOException{
		String url2 = "http://finance.sina.com.cn/realstock/company/"+url+"/nc.shtml";
		//System.out.println(url2);
		String a = null;
		try {  
			BufferedReader in = new BufferedReader(new InputStreamReader(  
	                new URL(url2).openConnection().getInputStream(), "GB2312"));
			while ((a = in.readLine()) != null) {
	            if(a.indexOf(keyword) > 0){
	            	return "true";
	            }
	            System.out.println(a);
	        }
			return "false";
		} catch (MalformedURLException e) {  
			return "false";
        } catch (IOException e) {  
        	return "false";
        } 
	}
	
	public static String[] getKeyWordList(String url, String keyword) throws UnsupportedEncodingException, MalformedURLException, IOException{
		String url2 = "http://finance.sina.com.cn/realstock/company/"+url+"/nc.shtml";
		//System.out.println(url2);
		String a = null;
		String[] List = new String[4];
		List[0] = "false";
		try {  
			BufferedReader in = new BufferedReader(new InputStreamReader(  
	                new URL(url2).openConnection().getInputStream(), "GB2312"));
			while ((a = in.readLine()) != null) {
	            if(a.indexOf(keyword) > 0){
	            	List[1] = a;
	            	a = in.readLine();
	            	List[2] = a;
	            	a = in.readLine();
	            	List[3] = a;
	            	List[0] = "true";
	            	return List;
	            }
	            //System.out.println(a);
	        }
			return List;
		} catch (MalformedURLException e) {  
			return List;
        } catch (IOException e) {  
        	return List;
        } 
	}
	public static void main(String args[]) throws UnsupportedEncodingException, MalformedURLException, IOException {  
		System.out.print(isKeyWordExist("SH600001","ÊÐÖµ"));
    } 
}
