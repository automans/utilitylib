package auto.lib.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * commons-beanutils-1.7.0.jar
 * commons-collections-3.2.2.jar
 *  commons-lang-2.6.jar
 *  commons-logging-1.2.jar
 *  ezmorph-1.0.4.jar
 *  json-lib-2.4-jdk15.jar
 *  commons-net-3.5.jar
 */
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtils {
	

	public static List<Map<String, String>> jsonStringToList(String rsContent) throws Exception
    {
        JSONArray arry = JSONArray.fromObject(rsContent);

        System.out.println("json字符串内容如下");
        System.out.println(arry);
        List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();
        for (int i = 0; i < arry.size(); i++)
        {
            JSONObject jsonObject = arry.getJSONObject(i);
            Map<String, String> map = new HashMap<String, String>();
            for (Iterator<?> iter = jsonObject.keys(); iter.hasNext();)
            {
                String key = (String) iter.next();
                String value = jsonObject.get(key).toString();
                map.put(key, value);
            }
            rsList.add(map);
        }
        return rsList;
    }
	
	public static Map<String, String> jsonStringToMap(String rsContent) throws Exception
    {
		System.out.println(rsContent);
        JSONArray arry = JSONArray.fromObject(rsContent);

        Map<String, String> rsMap = new HashMap<>();
       
        for (int i = 0; i < arry.size(); i++)
        {
            JSONObject jsonObject = arry.getJSONObject(i);
            //Map<String, String> map = new HashMap<String, String>();
            for (Iterator<?> iter = jsonObject.keys(); iter.hasNext();)
            {
                String key = (String) iter.next();
                String value = jsonObject.get(key).toString();
                System.out.println("key:"+key+" <=> value:"+value);
                rsMap.put(key, value);
            }
        }
       
        return rsMap;
    }
	
	public static String getKey(String key,String src) throws Exception{
		Map<String, String> gMap = new HashMap<>();
		gMap = jsonStringToMap(src);
		return gMap.get(key);
	}
	 public static void main(String[] args) throws Exception{
		 
		 	String oCar = "[{\"CityId\":18,\"CityName\":\"西安\",\"ProvinceId\":27,\"CityOrder\":1}]";
		 	
		 	System.out.println(JsonUtils.getKey("CityId",oCar));
//	        System.out.println("json字符串成map");
//	        for (Map<String, String> m1 : list1)
//	        {
//	            System.out.println(m1 + "------");
//	        }
//	        System.out.println("map转换成json字符串");
//            for (Map<String, String> m2 : list1)
//	        {
//	            JSONArray jsonArray = JSONArray.fromObject(m2);
//	            System.out.println(jsonArray.toString() + "----");
//
//	        }
//	        System.out.println("list转换成json字符串");
//	        JSONArray jsonArray2 = JSONArray.fromObject(list1);
//	        System.out.println(jsonArray2.toString());
//		 
		 
//		 	Map<String, String> stu = new HashMap<String, String>();
//		 	stu.put("Fuzzy", "11");
//	        stu.put("Spot", "22");
//	        
//	        //String oCar = "[{\"CityId\":18,\"CityName\":\"西安\",\"ProvinceId\":27,\"CityOrder\":1},{\"CityId\":128,\"CityName\":\"西安2\",\"ProvinceId\":272,\"CityOrder\":12}]";
//	        
//	        //1、使用JSONObject
//	        JSONObject json = JSONObject.fromObject(stu);
//	        //2、使用JSONArray
//	        JSONArray array = JSONArray.fromObject(stu);
//	        
//	        String strJson=json.toString();
//	        String strArray=array.toString();
//	        System.out.println("strJson:"+strJson);
//	        System.out.println("strArray:"+strArray);
//	        
//	        List<Map<String, String>> list1 = jsonStringToList(array.toString());
//	        for (Map<String, String> m : list1)
//		        {
//		            System.out.println(m + "------");
//     	        }
	 }
	
}
