package auto.lib.cache;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;


public class RedisUtils {
	private static int PORT = 6379;
	private Jedis jedis;
	public RedisUtils(String ip,int db){
		jedis = new Jedis(ip, PORT);
		jedis.select(db);
	}
	
	/**
	public RedisUtils(String ip,int port, int db){
		jedis = new Jedis(ip, port);
		jedis.select(db);
	}*/
	
	public String get(String key){
		return this.jedis.get(key);
	}
	public List<String> mget(String key, String[] fields){
		List<String> li = new ArrayList<String>();
		switch(fields.length){
		case 1:
			li = this.jedis.hmget(key, fields[0]);break;
		case 2:
			li = this.jedis.hmget(key, fields[0],fields[1]);break;
		case 3:
			li = this.jedis.hmget(key, fields[0],fields[1],fields[2]);break;
		case 4:
			li = this.jedis.hmget(key, fields[0],fields[1],fields[2],fields[3]);break;
		case 5:
			li = this.jedis.hmget(key, fields[0],fields[1],fields[2],fields[3],fields[4]);break;
		case 6:
			li = this.jedis.hmget(key, fields[0],fields[1],fields[2],fields[3],fields[4],fields[5]);break;
		case 7:
			li = this.jedis.hmget(key, fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6]);break;
		case 8:
			li = this.jedis.hmget(key, fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7]);break;
		case 9:
			li = this.jedis.hmget(key, fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8]);break;
		case 10:
			li = this.jedis.hmget(key, fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);break;
		}
		return li;
	}
	public void set(String key, String value){
		this.jedis.set(key, value);
	}
	
	public void set(String key, Map<String, String> map){
		this.jedis.hmset(key,map);
	}
	public void del(String key){
		this.jedis.del(key);
	}
	public void hdel(String key, String[] fields){
		switch(fields.length){
		case 1:
			this.jedis.hdel(key, fields[0]);break;
		case 2:
			this.jedis.hdel(key, fields[0],fields[1]);break;
		case 3:
			this.jedis.hdel(key, fields[0],fields[1],fields[2]);break;
		case 4:
			this.jedis.hdel(key, fields[0],fields[1],fields[2],fields[3]);break;
		case 5:
			this.jedis.hdel(key, fields[0],fields[1],fields[2],fields[3],fields[4]);break;
		case 6:
			this.jedis.hdel(key, fields[0],fields[1],fields[2],fields[3],fields[4],fields[5]);break;
		case 7:
			this.jedis.hdel(key, fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6]);break;
		case 8:
			this.jedis.hdel(key, fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7]);break;
		case 9:
			this.jedis.hdel(key, fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8]);break;
		case 10:
			this.jedis.hdel(key, fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);break;
		
		}
	}
	public void flush(){
		this.jedis.flushDB();
	}
	
	public void mv(String key, int dbIndex){
		this.jedis.move(key, dbIndex);
	}
	
	public long count(){
		return this.jedis.dbSize();
	}
	public boolean isExist(String key){
		return this.jedis.exists(key);
	}
	public long hCount(String key){
		return this.jedis.hlen(key);
	}
	
	public static void main(String[] args){
		//RedisUtils redis = new RedisUtils("172.16.8.229",6379,1);
		//System.out.println(redis.count());
		RedisUtils redis = new RedisUtils("172.16.8.229",1);
		System.out.println(redis.hCount("user"));
		if(redis.isExist("user"))
		{
			System.out.println("y");
		}else{
			System.out.println("n");
		}
			
			
		///** redis map 
		//Map<String, String> map = new HashMap<String, String>();
		//map.put("name", "xinxin");
		//map.put("age", "22");
		//map.put("qq", "123456");
		//redis.set("user", map);
		
		
		/** list map
		String[] ll = {"name","age","qq"};
		List<String> li = redis.mget("user", new String[]{"name","age","qq"});
		//List<String> li = redis.mget("user", ll);
		System.out.println(li);
		*/
		
		///** list map del
		//String[] ll = {"name","age"};
		//List<String> li = redis.mget("user", new String[]{"name","age","qq"});
		//redis.hdel("user", ll);
		//*/
		
	}
}
